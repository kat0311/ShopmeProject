package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.email=:email")
    public User getUserByEmail(@Param("email") String email);


    public Long countById( Integer id);
    @Query("select u from User u where concat(u.id,' ',u.email,' ',u.firstName,' ',u.lastName,' ') like %?1%")
    public Page<User> findAll(String keyword, Pageable pageable);

//    @Query("UPDATE User u SET u.enabled = ?2 WHERE u.id = ?1")
//
//    public void updateEnabledStatus(Integer id, boolean enabled);
    @Query("update User u set u.enabled=?2 where u.id=?1")
    @Modifying
    public void updateEnabledStatus(Integer id,boolean enabled);

}
