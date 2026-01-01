package sec4;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.configuration.Orthography;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.junit5.DBUnitExtension;
import com.github.database.rider.junit5.api.DBRider;
import exercises.sec3.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DBRider
@DBUnit(
        url="jdbc:postgresql://localhost:5432/postgres",
        user="postgres",
        password = "postgres",
        schema = "public",
        caseInsensitiveStrategy = Orthography.LOWERCASE
)
@ExtendWith(DBUnitExtension.class)
class UserDaoTest {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USER = "postgres";
    private static final String DB_PASS = "postgres";
    @Test
    @DataSet("datasets/users.yml") //テストメソッド実行前に.ymlファイルに記載されたテストデータを自動的に投入する
    void  testFindAllUsers() throws  Exception{
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASS)){
            UserDao userDao = new UserDao(conn);

            //実測値
            List<User> actualUsers = userDao.findAll();

            //期待値
            List<User> expectedUsers = List.of(
                    new User(0, "suzuki_taro", "suzuki.taro@example.com", 28),
                    new User(1, "tanaka_hanako", "tanaka.hanako@example.com",25),
                    new User(2, "yamada_ichiro", "yamada.ichiro@example.com", 35)
            );

            assertEquals(actualUsers, expectedUsers);

        }

    }

    @Test
    @DataSet("datasets/users.yml")
    //特定の条件でメールを１件取得できるか確認するテスト
    void  testFindByEmail_existingEmail() throws  Exception{
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASS)) {
            UserDao userDao = new UserDao(conn);

            Optional<User> userOpt = userDao.findByEmail("suzuki.taro@example.com");
            assertTrue(userOpt.isPresent());
            }
        }

    @Test
    @DataSet("datasets/users_before_add.yml")
    @ExpectedDataSet(value = "datasets/users_after_add.yml", ignoreCols = "id")
    void testAddUser() throws  Exception{
        try(Connection conn = DriverManager.getConnection(DB_URL, DB_USER,DB_PASS)) {
            UserDao userDao = new UserDao(conn);

            User newUser = new User("shimizu_naoki", "shimizu.naoki@example.com",26);
            userDao.add(newUser);
        }


        }

    }