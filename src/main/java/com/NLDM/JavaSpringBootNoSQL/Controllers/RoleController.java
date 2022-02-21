package com.NLDM.JavaSpringBootNoSQL.Controllers;

import com.NLDM.JavaSpringBootNoSQL.Exceptions.RoleException;
import com.NLDM.JavaSpringBootNoSQL.Models.Role;
import com.NLDM.JavaSpringBootNoSQL.Services.BusinessServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Role")
public class RoleController {
    @Autowired
    BusinessServices businessServices;

    @GetMapping("")
    public List<Role> getAllRole() {
        return businessServices.getAllRole();
    }

    @PostMapping("")
    public Role addRole(@RequestBody Role role) throws RoleException {
        Role newRole = businessServices.addRole(role);
        if (newRole != null)
            return role;
        throw new RoleException("406", "ID is exist. Try another ID or edit information.");
    }

    @PutMapping("/{id}")
    public Role editRole(@PathVariable String id, @RequestBody Role role) throws RoleException {
        Role roleEdited = businessServices.editRole(id,role);
        if (roleEdited != null)
            return roleEdited;
        throw new RoleException("404", "ID NOT FOUND !!!");
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll() {
        businessServices.deleteAllRecords();
        return "Successful";
    }

    @DeleteMapping("/{id}")
    public Role deleteById(@PathVariable String id) throws RoleException {
        Role roleDeleted = businessServices.deleteRole(id);
        if (roleDeleted != null)
            return roleDeleted;
        throw new RoleException("404", "ID NOT FOUND !!!");
    }
}
