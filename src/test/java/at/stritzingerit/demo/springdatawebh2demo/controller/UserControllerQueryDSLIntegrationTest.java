package at.stritzingerit.demo.springdatawebh2demo.controller;

import at.stritzingerit.demo.springdatawebh2demo.entity.User;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Visitor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Nullable;
import javax.transaction.Transactional;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class UserControllerQueryDSLIntegrationTest {

    @Autowired
    UserController controller;

    @Test
    public void searchEqual() {
        UserPredicatesBuilder builder = new UserPredicatesBuilder().with("lastName", "=", "Peter");
        Iterable<User> users = controller.search(builder.build());
        assertTrue("user not found", users.iterator().hasNext() == true);
    }

}
