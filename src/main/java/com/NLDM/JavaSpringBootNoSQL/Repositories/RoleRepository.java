package com.NLDM.JavaSpringBootNoSQL.Repositories;

import com.NLDM.JavaSpringBootNoSQL.Models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
    Role findByid(String id);
}
