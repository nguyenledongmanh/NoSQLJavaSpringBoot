package com.NLDM.JavaSpringBootNoSQL.Repositories;

import com.NLDM.JavaSpringBootNoSQL.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByid(String id);
}
