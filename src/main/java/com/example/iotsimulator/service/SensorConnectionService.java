package com.example.iotsimulator.service;


import com.example.iotsimulator.domain.device.Device;
import com.example.iotsimulator.domain.device.DeviceRepository;
import com.example.iotsimulator.domain.machine.Machine;
import com.example.iotsimulator.domain.machine.MachineRepository;
import com.example.iotsimulator.domain.sensorconnection.SensorConnection;
import com.example.iotsimulator.domain.sensorconnection.SensorConnectionDto;
import com.example.iotsimulator.domain.sensorconnection.SensorConnectionMapper;
import com.example.iotsimulator.domain.sensorconnection.SensorConnectionRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SensorConnectionService {

    @Resource
    private SensorConnectionMapper sensorConnectionMapper;
    @Resource
    private SensorConnectionRepository sensorConnectionRepository;
    @Resource
    private DeviceRepository deviceRepository;
    @Resource
    private MachineRepository machineRepository;



    public SensorConnectionDto createSensorConnection(SensorConnectionDto sensorConnectionDto) {

        SensorConnection sensorConnection =sensorConnectionMapper.toEntity(sensorConnectionDto);

        Device device =deviceRepository.findDeviceById(sensorConnectionDto.getDeviceId());
        Machine machine =machineRepository.findMachineById(sensorConnectionDto.getDeviceId());

        sensorConnection.setDevice(device);
        sensorConnection.setMachine(machine);

        sensorConnectionRepository.save(sensorConnection);

        return sensorConnectionMapper.toDto(sensorConnection);
    }
}
