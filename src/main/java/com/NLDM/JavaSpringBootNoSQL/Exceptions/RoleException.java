package com.NLDM.JavaSpringBootNoSQL.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RoleException extends Exception{
    private String code, msg;
}
