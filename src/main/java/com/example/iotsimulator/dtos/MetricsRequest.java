package com.example.iotsimulator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricsRequest extends ConnectionStartRequest implements Serializable {

    private Integer value;
}