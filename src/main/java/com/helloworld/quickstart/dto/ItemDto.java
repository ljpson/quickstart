package com.helloworld.quickstart.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemDto {

    private String id;
    private String name;
}
