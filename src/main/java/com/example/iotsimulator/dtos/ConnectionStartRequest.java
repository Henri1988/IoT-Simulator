package com.example.iotsimulator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConnectionStartRequest implements Serializable {
    private int sourceAssetId;
    private int targetAssetId;
    private int intervalMs;
}