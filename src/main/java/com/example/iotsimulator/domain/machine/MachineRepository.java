package com.example.iotsimulator.domain.machine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MachineRepository extends JpaRepository<Machine, Integer> {
    @Query("select m from Machine m where m.id = ?1")
    Machine findMachineById(Integer id);
}