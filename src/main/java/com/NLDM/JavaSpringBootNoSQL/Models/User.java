package com.NLDM.JavaSpringBootNoSQL.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("UserRecords")
@Data
@Setter
@Getter
@AllArgsConstructor
public class User {
    @Id
    private String id;
    private String name;

    private List<String> listRole;
    private LocalDateTime updated;
    private LocalDateTime lastUpdated;
}
