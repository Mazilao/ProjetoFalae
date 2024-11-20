package com.falae.service.dto;

import lombok.Data;

@Data
public class UserDTO {
    private int Id;
    private String name;
    private String email;
    private String address;
    private String phone;
}
//requestUser