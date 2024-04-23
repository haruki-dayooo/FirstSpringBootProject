package com.springdemo.springbootproject.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tblusers")
@Table(name = "tblusers")
public class User implements UserDetails {

    @Id
    @Column(name = "userid", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String userId;

    @Column(name = "password", columnDefinition = "TEXT")
    @JsonIgnore
    private String password;

    @Column(name = "fullname", columnDefinition = "TEXT")
    private String fullName;

    @Column(name = "roleid", columnDefinition = "TEXT")
    private String roleId;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(roleId));
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
