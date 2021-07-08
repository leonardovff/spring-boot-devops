package com.example.springboot.realestates;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RealEstateService {

	@Autowired 
	private RealEstateRepository realEstateRepository;

    @KafkaListener(topics = "new-real-estate", groupId = "group_id")
    public void consumeCreateRealEstate(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode realEstateJson = mapper.readTree(message);
    
        RealEstate realEstate = new RealEstate();
        realEstate.setSku(realEstateJson.get("sku").intValue());
        realEstate.setType(realEstateJson.get("type").textValue());
        realEstate.setMarketType(realEstateJson.get("marketType").textValue());
        realEstate.setDescription(realEstateJson.get("description").textValue());

        realEstateRepository.save(realEstate);
        System.out.print(String.format("#### -> Consumed message -> %s", message));
    }

    @KafkaListener(topics = "update-real-estate", groupId = "group_id")
    public void consumeUpdateRealEstate(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode realEstateJson = mapper.readTree(message);

        RealEstate realEstate = realEstateRepository.findBySku(realEstateJson.get("sku").intValue());
        realEstate.setType(realEstateJson.get("type").textValue());
        realEstate.setMarketType(realEstateJson.get("marketType").textValue());
        realEstate.setDescription(realEstateJson.get("description").textValue());

        realEstateRepository.save(realEstate);
        System.out.print(realEstate);
        System.out.print(String.format("#### -> Consumed message -> %s", message));
    }
}