package com.NLDM.JavaSpringBootNoSQL.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserException extends Exception{
    private String code, msg;
}
