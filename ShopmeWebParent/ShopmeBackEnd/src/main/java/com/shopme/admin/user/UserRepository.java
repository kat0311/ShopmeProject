package com.shopme.admin.user;

import com.shopme.common.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.email=:email")
    public User getUserByEmail(@Param("email") String email);


    public Long countById( Integer id);

//    @Query("UPDATE User u SET u.enabled = ?2 WHERE u.id = ?1")
//
//    public void updateEnabledStatus(Integer id, boolean enabled);
    @Query("update User u set u.enabled=?2 where u.id=?1")
    @Modifying
    public void updateEnabledStatus(Integer id,boolean enabled);

}
