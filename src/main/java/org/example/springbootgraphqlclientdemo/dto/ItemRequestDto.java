package org.example.springbootgraphqlclientdemo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequestDto {

    private int id;
    private int stock;
}
