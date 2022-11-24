package com.example.iotsimulator.controllers;
import com.example.iotsimulator.dtos.ConnectionStartRequest;
import com.example.iotsimulator.dtos.ConnectionStartResponse;
import com.example.iotsimulator.services.ConnectionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
@RequestMapping("/connection")
public class ConnectionController {


    @Resource
    private ConnectionService connectionService;

    @PostMapping("/start")
    @Operation(summary = "Starts connection")
    public ConnectionStartResponse startConnection(@RequestBody ConnectionStartRequest req) {
        return connectionService.startConnection(req);
    }

}
