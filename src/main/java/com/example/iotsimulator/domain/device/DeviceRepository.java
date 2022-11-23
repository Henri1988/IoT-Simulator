package com.example.iotsimulator.domain.device;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
    @Query("select d from Device d where d.id = ?1")
    Device findDeviceById(Integer id);

}