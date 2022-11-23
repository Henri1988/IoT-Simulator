package com.example.iotsimulator.domain.sensorconnection;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SensorConnectionMapper {
    @Mapping(source = "deviceId", target = "device.id")
    @Mapping(source = "machineId", target = "machine.id")
    @Mapping(target = "id", ignore = true)
    SensorConnection toEntity(SensorConnectionDto sensorConnectionDto);

    @InheritInverseConfiguration(name = "toEntity")
    SensorConnectionDto toDto(SensorConnection sensorConnection);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SensorConnection updateEntity(SensorConnectionDto sensorConnectionDto, @MappingTarget SensorConnection sensorConnection);
}
