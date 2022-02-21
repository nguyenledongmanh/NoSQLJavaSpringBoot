package com.NLDM.JavaSpringBootNoSQL.Controllers;

import com.NLDM.JavaSpringBootNoSQL.Exceptions.UserException;
import com.NLDM.JavaSpringBootNoSQL.Models.User;
import com.NLDM.JavaSpringBootNoSQL.Services.BusinessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/User")
public class UserController {
    @Autowired
    BusinessServices businessServices;

    @GetMapping("")
    public List<User> getAllUser() {
        return businessServices.getAllUser();
    }

    @PostMapping("")
    public User addUser(@RequestBody User user) throws UserException {
        User userAdded = businessServices.addUser(user);
        if (userAdded != null)
            return userAdded;
        throw new UserException("406", "ID is exist or new role list is not match with available role list in role repository");
    }

    @PutMapping("")
    public User editUserById(@RequestBody User user, @RequestParam String id) throws UserException {
        User userEdited = businessServices.editUserById(user, id);
        if (userEdited != null)
            return userEdited;
        throw new UserException("406", "ID is exist or new role list is not match with available role list in role repository");
    }

    @DeleteMapping("/deleteAll")
    public String deleteAllUser() {
        businessServices.deleteAll();
        return "Successful";
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable String id) throws UserException {
        User userDeleted = businessServices.deleteById(id);
        if (userDeleted != null)
            return userDeleted;
        throw new UserException("404", "ID is not exist");
    }
}
