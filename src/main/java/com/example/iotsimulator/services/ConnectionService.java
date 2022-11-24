package com.example.iotsimulator.services;
import com.example.iotsimulator.configs.ApplicationConfigs;
import com.example.iotsimulator.configs.ControlPanelProperties;
import com.example.iotsimulator.dtos.AssetConnectionDto;
import com.example.iotsimulator.dtos.ConnectionStartRequest;
import com.example.iotsimulator.dtos.ConnectionStartResponse;
import com.example.iotsimulator.dtos.MetricsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class ConnectionService {
    @Autowired
    private ApplicationConfigs applicationConfigs;

    private static Map<Integer, Timer> tasks = new HashMap<Integer, Timer>();

    @Resource
    private ControlPanelProperties controlPanelProperties;

    public ConnectionStartResponse startConnection(ConnectionStartRequest req) {
        String url = String.format("%s/connection/create/%s/%s",
                controlPanelProperties.getControllerPath(),
                req.getSourceAssetId(),
                req.getTargetAssetId());
        System.out.println(url);

        var resp = applicationConfigs.getRestTemplate().postForObject(url, null, AssetConnectionDto.class);

        this.setupMetricsTimer(req, resp);
        return new ConnectionStartResponse(resp.getId());
    }

    private void setupMetricsTimer(ConnectionStartRequest req, AssetConnectionDto resp) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Random random = new Random();
                Integer value = random.nextInt();
                MetricsRequest metricsRequest = new MetricsRequest(value);

//                String url = String.format("%s/%s/%s", controlPanelProperties.getControllerPath(), connectionId, controlPanelProperties.getMetricsPath());
//                sendPost(url, metricsRequest);
            }
        };
        timer.scheduleAtFixedRate(task, 10, req.getIntervalMs());
        tasks.put(connectionId, timer);

        // TODO: start timer (copy paste from his service.sendMetrics)
//        req.getIntervalMs()
    }





}
