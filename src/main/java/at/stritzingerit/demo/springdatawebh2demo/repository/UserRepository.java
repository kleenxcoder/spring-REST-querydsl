package at.stritzingerit.demo.springdatawebh2demo.repository;

import at.stritzingerit.demo.springdatawebh2demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Integer>,
        QuerydslPredicateExecutor<User> {

    @Query("SELECT u FROM User u WHERE u.active = 1")
    List<User> findActiveUsers();

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findActiveUserById(Integer id);

    @Query(value = "SELECT u FROM User u WHERE u.firstName = :firstName")
    User findActiveUserByFirstName(@Param("firstName") String firstName);

    @Query(value = "SELECT * FROM User WHERE LAST_NAME = :firstName", nativeQuery = true)
    User findActiveUserByLastName(@Param("firstName") String firstName);

}
