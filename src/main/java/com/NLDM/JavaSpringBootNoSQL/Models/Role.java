package com.NLDM.JavaSpringBootNoSQL.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Setter
@Getter
@AllArgsConstructor
@Document("RoleRecords")
public class Role {
    @Id
    private String id;
    private String name;

    private LocalDateTime updated;
    private LocalDateTime lastUpdated;
}
