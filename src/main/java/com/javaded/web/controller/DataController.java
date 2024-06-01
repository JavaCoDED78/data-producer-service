package com.javaded.web.controller;

import com.javaded.model.test.DataTestOptions;
import com.javaded.service.KafkaDataService;
import com.javaded.service.TestDataService;
import com.javaded.web.dto.DataDto;
import com.javaded.web.dto.DataTestOptionsDto;
import com.javaded.web.mapper.DataMapper;
import com.javaded.web.mapper.DataTestOptionsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/data")
@RequiredArgsConstructor
public class DataController {

    public final KafkaDataService kafkaDataService;
    private final TestDataService testDataService;
    public  final DataMapper dataMapper;
    private final DataTestOptionsMapper dataTestOptionsMapper;

    @PostMapping("/send")
    public void send(@RequestBody DataDto dataDto) {
        kafkaDataService.send(dataMapper.toEntity(dataDto));
    }

    @PostMapping("/test/send")
    public void testSend(@RequestBody DataTestOptionsDto testOptionsDto) {
        DataTestOptions testOptions = dataTestOptionsMapper.toEntity(testOptionsDto);
        testDataService.sendMessages(testOptions);
    }

}
