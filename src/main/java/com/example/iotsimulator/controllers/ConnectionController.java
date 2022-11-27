package com.example.iotsimulator.controllers;
import com.example.iotsimulator.dtos.AssetConnectionDto;
import com.example.iotsimulator.dtos.ConnectionStartRequest;
import com.example.iotsimulator.dtos.ConnectionStartResponse;
import com.example.iotsimulator.services.ConnectionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/connection")
public class ConnectionController {


    @Resource
    private ConnectionService connectionService;

    @PostMapping("/start")
    @Operation(summary = "Starts connection")
    public ResponseEntity <ConnectionStartResponse> startConnection(@RequestBody ConnectionStartRequest req) {
        return ResponseEntity.ok().body(connectionService.startConnection(req));
    }

    @PostMapping("/sendmetrics/")
    public ResponseEntity<?> setupAndSendMetrics(@RequestBody ConnectionStartRequest req, @RequestBody AssetConnectionDto resp) {
        connectionService.setupMetricsTimer(req, resp);
        return ResponseEntity.ok().build();
    }

    /*
    Alternative?

    @PostMapping("/start")
    @Operation(summary = "Starts connection")
    public ConnectionStartResponse startConnection(@RequestBody ConnectionStartRequest req) {
        return connectionService.startConnection(req);
    }*/




}
