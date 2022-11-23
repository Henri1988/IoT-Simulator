package com.example.iotsimulator.service;


import com.example.iotsimulator.domain.sensorconnection.SensorConnectionDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SensorConnectionController {


    @Resource
    private SensorConnectionService sensorConnectionService;


    @PostMapping("/connection/create")
    @Operation(summary = "Creates connection between the machine and device")
    public SensorConnectionDto createSensorConnection(@RequestBody SensorConnectionDto sensorConnectionDto ){
        return sensorConnectionService.createSensorConnection(sensorConnectionDto);
    }

}
