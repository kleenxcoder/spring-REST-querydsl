package at.stritzingerit.demo.springdatawebh2demo.repository;

import at.stritzingerit.demo.springdatawebh2demo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class UserRepositoryIntegrationTest {

    @Autowired
    UserRepository repository;

    @Test
    public void findActiveUserById() {
        User user = repository.findActiveUserById(1);
        assertTrue("user not found", user != null);
    }

    @Test
    public void findActiveUsers() {
        List<User> users = repository.findActiveUsers();
        assertTrue("user not found", users.size() > 0);
    }

    @Test
    public void findActiveUserByFirstName() {
        User users = repository.findActiveUserByFirstName("firstName");
        assertTrue("user not found", users != null);
    }

    @Test
    public void findActiveUserByLastName() {
        User users = repository.findActiveUserByLastName("lastName");
        assertTrue("user not found", users != null);
    }

}
