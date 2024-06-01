package com.javaded.web.controller;

import com.javaded.service.KafkaDataService;
import com.javaded.web.dto.DataDto;
import com.javaded.web.mapper.DataMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    public final KafkaDataService kafkaDataService;
    public  final DataMapper dataMapper;

    @RequestMapping
    public void send(@RequestBody DataDto dataDto) {
        kafkaDataService.send(dataMapper.toEntity(dataDto));
    }

}
