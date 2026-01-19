# ＠BeforeEachと＠AfterEachの記述したコード
### [ddac2a1](https://github.com/kb8864/JUnit5/pull/1/commits/ddac2a1e43a15e3c99d13710d89a46a67adf2e0a)

(https://note.com/hip_mole2699/n/n710e6c079079)

## AfterEachとBeforeEachって実際どんなときに使う?
> [!TIP]
> ```
> @BeforeEach：各テストの「直前」に毎回走る「準備係」。
> 
> @AfterEach：各テストの「直後」に毎回走る「片付け係」。
> ```
どちらもテストの独立性（前後のテストに影響しない）と再現性を守るた目に使う

> [!TIP]
> こんなときに `@BeforeEach`を使う
> 
> 
> - テスト対象やモックを毎回「新品」で用意したい
> 例：`service = new MemberService(mockRepo, mockMailer);`
> 
> - 固定時刻まどの「環境」を毎回セットしたい
>  
> 例：`clock = Clock.fixed(...); service = new Foo(clock);`
> 
> - 共通のテストデータを初期化したい
>   
> 例：`validMember = Member.builder().email("abc@.com").build();`

```
class ToDoServiceTest {
  ToDoRepository repo;
  ToDoService service;

  @BeforeEach
  void setUp() {
    repo = mock(ToDoRepository.class);       // ← 毎回新品
    service = new ToDoService(repo);
  }

  @Test
  void 追加できる() { /* ... */ }

  @Test
  void 空タイトルは例外() { /* ... */ }
}

```


> [!TIP]
> こんなときに` @AfterEach`
> 
> 一時資源の片付け（ファイル/ディレクトリ/ソケット等）
> 
> システムプロパティやTimeZone/Localeを元に戻す
> 外部のスタブサーバ（WireMockなど）をリセット
> 静的な共有状態をクリア（ThreadLocal、グローバルキャッシュなど）
> 
> （ファイルや環境を元に戻す）
```
class ImportServiceTest {
  Path tempDir;
  String originalUserHome;

  @BeforeEach
  void setUp(@TempDir Path tmp) { // JUnitが毎回新しい一時ディレクトリをくれる
    tempDir = tmp;
    originalUserHome = System.getProperty("user.home");
    System.setProperty("user.home", tempDir.toString());
  }

  @AfterEach
  void tearDown() {
    System.setProperty("user.home", originalUserHome); // ←⭐️ 環境を元に戻す
    // tempDirは@TempDirなので自動片付け、明示不要
  }
}

```



原則：モックは @BeforeEach で作り直す（Mockito.reset()は最終手段）。

副作用の確認はテスト本体で verify(...)、片付けは @AfterEach。責務を分けると読みやすい。

DBスライス（@DataJpaTest）は各テスト後に自動ロールバックされるので @AfterEach の掃除が原則不要。追加の初期化は @Sql で明示。

環境変更（System.setProperty, TimeZone.setDefault など）をテストで行ったら、必ず @AfterEach で元に戻す。

Springコンテキストは極力共有（キャッシュ）したいので、@DirtiesContext を安易に使わない（遅くなる）
