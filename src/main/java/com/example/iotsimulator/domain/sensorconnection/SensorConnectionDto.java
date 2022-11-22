package com.example.iotsimulator.domain.sensorconnection;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link SensorConnection} entity
 */
@Data
public class SensorConnectionDto implements Serializable {
    private Integer id;
    private String name;
    private Integer deviceId;
    private String deviceName;
    private Integer machineId;
    private String machineName;
    private Instant connectionStartTime;
}