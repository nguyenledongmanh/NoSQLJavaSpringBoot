package com.NLDM.JavaSpringBootNoSQL.Services;

import com.NLDM.JavaSpringBootNoSQL.Models.Role;
import com.NLDM.JavaSpringBootNoSQL.Models.User;
import com.NLDM.JavaSpringBootNoSQL.Repositories.RoleRepository;
import com.NLDM.JavaSpringBootNoSQL.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BusinessServices {
    // ROLE METHODS
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    public Role addRole(Role role) {
        Role existRole = roleRepository.findByid(role.getId());
        if (existRole != null)
            return null;
        role.setUpdated(LocalDateTime.now());
        role.setLastUpdated(LocalDateTime.now());
        roleRepository.insert(role);
        return role;
    }

    public Role editRole(String id, Role role) {
        Role existRole = roleRepository.findByid(id);
        if (existRole != null) {
            role.setUpdated(existRole.getUpdated());
            role.setLastUpdated(LocalDateTime.now());
            roleRepository.deleteById(id); // NOTE : how to save without deleting previous node
            roleRepository.save(role);
            return role;
        }
        return null;
    }

    public void deleteAllRecords() {
        roleRepository.deleteAll();
    }

    public Role deleteRole(String id) {
        Role existRole = roleRepository.findByid(id);
        if (existRole != null) {
            roleRepository.deleteById(id);
            return existRole;
        }
        return null;
    }

// USER METHODS

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        User existUser = userRepository.findByid(user.getId());
        if (existUser == null && checkRoleList(user.getListRole())) {
            user.setUpdated(LocalDateTime.now());
            user.setLastUpdated(LocalDateTime.now());
            return userRepository.insert(user);
        }
        return null;
    }

    public User editUserById(User user, String id) {
        User existUser = userRepository.findByid(id);
        if (existUser != null && checkRoleList(user.getListRole())) {
            userRepository.deleteById(id);
            user.setUpdated(existUser.getUpdated());
            user.setLastUpdated(LocalDateTime.now());
            userRepository.save(user);
            return user;
        }
        return null;
    }

    public User deleteById(String id) {
        User existRole = userRepository.findByid(id);
        if (existRole != null) {
            userRepository.deleteById(id);
            existRole.setLastUpdated(LocalDateTime.now());
            return existRole;
        }
        return null;
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    // private methods
    private boolean checkRoleList(List<String> Ids) {
        int flag = 0;
        for (String id : Ids) {
            if (roleRepository.findByid(id) != null)
                flag++;
        }
        return flag == Ids.size();
    }
}
