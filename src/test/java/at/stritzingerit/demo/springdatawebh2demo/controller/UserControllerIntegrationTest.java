package at.stritzingerit.demo.springdatawebh2demo.controller;

import at.stritzingerit.demo.springdatawebh2demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Slf4j
public class UserControllerIntegrationTest {

    @Autowired
    UserController controller;

    @Test
    public void all() {
        Iterable<User> users = controller.all();
        assertTrue("no users found", users.iterator().hasNext() == true);
    }

    @Test
    public void one() {
        Optional<User> user = controller.one(1);
        assertTrue("user not found", user.isPresent());
    }

    @Test
    public void create() {
        User newUser = new User(null, "Helmut", "Helmut", false);
        newUser = controller.create(newUser);
        log.debug(newUser.toString());
        assertTrue("user did not get an id", newUser.getId() != null && newUser.getId() > 0);
    }

    @Test
    public void update() {
        Optional<User> user = controller.one(1);
        user.get().setFirstName("Wilfried");
        user.get().setLastName("Wilfried");
        User updatedUser = controller.update(user.get(), user.get().getId());
        log.debug(updatedUser.toString());
        assertTrue("firstName did not change", updatedUser.getFirstName().equalsIgnoreCase("Wilfried"));
        assertTrue("firstName did not change", updatedUser.getLastName().equalsIgnoreCase("Wilfried"));
    }

    @Test
    public void delete() {
        controller.delete(1);
        assertTrue("user id 1 not deleted", !controller.one(1).isPresent());
    }

}
