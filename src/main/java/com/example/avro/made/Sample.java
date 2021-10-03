package com.example.avro.made;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Sample {

    private String name;
    private int id;
}
