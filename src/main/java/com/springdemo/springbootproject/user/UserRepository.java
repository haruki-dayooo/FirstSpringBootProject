package com.springdemo.springbootproject.user;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT u FROM tblusers u WHERE u.fullName LIKE %?1%")
    List<User> searchByFullName(String search);

    @Query("SELECT u FROM tblusers u WHERE u.userId=?1 AND u.password=?2")
    Optional<User> checkLoginUser(String userId, String password);

    @Query("SELECT u FROM tblusers u WHERE u.userId=?1 AND u.password=?2")
    User checkAuthenticate(String userId, String password);

    @Query("SELECT u FROM tblusers u WHERE u.userId=?1")
    Optional<User> findByUserId(String userId);
}
