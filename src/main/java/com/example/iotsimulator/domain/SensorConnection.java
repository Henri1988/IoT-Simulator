package com.example.iotsimulator.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Data
@Entity
@Table(name = "sensor_connection", schema = "iot-simulator")
public class SensorConnection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "name", nullable = false)
    private String name;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "device_id", nullable = false)
    private Device device;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "machine_id", nullable = false)
    private Machine machine;


    @Column(name = "connection_start_time", nullable = false)
    private Instant connectionStartTime;


/*
    TODO [JPA Buddy] create field to map the 'time_interval' column
     Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "time_interval", columnDefinition = "interval(49, 6) not null")
    private Object timeInterval;
*/
}