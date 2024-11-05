package com.shopme.admin.user;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repo;
    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void testCreateNewUserWithOneRole(){
        Role roleAdmin = entityManager.find(Role.class,1);
        User userNamHM = new User("namHM@gmail.com","123456","nam","HM");
        userNamHM.addRole(roleAdmin);
        User savedUser = repo.save(userNamHM);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testCreateNewUserWithTwoRoles(){
        User userRavi = new User("ravi@gmail.com","123456","ravi","HM");
        Role roleEditor = new Role(4);
        Role roleAssistant = new Role(3);
        userRavi.addRole(roleEditor);
        userRavi.addRole(roleAssistant);
        User savedUser = repo.save(userRavi);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAllUsers(){
        Iterable<User> listUsers=  repo.findAll();
        listUsers.forEach(user -> System.out.println(user));
    }
    @Test
    public void testGetUserById(){
        User userNam = repo.findById(1).get();
        System.out.println(userNam);
        assertThat(userNam).isNotNull();

    }
    @Test
    public void testUpdateUserDetails(){
        User userNam = repo.findById(1).get();
        userNam.setEnabled(true);
        userNam.setEmail("nam123456@gmail.com");
        repo.save(userNam);
    }
    @Test
    public void testUpdateUserRoles(){
        User userNam = repo.findById(2).get();
        Role roleEditor = new Role(4);
        Role roleSalesperson = new Role(2);
        userNam.getRoles().remove(roleEditor);
        userNam.addRole(roleSalesperson);
        repo.save(userNam);
    }
    @Test
    public void testDeleteUser(){
        Integer userId =2;
        repo.deleteById(userId);
    }

}
