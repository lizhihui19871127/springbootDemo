package com.sishuok.controller;

import com.sishuok.entity.User;
import com.xinwis.pms.model.Bi_building;
import com.xinwis.pms.service.BiBuildingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-12-22
 * <p>Version: 1.0
 */
@EnableAutoConfiguration
@RestController
@RequestMapping("/user")
@ImportResource("classpath:dubbo-consumer.xml")
public class UserController {

    @Resource
    private BiBuildingService biBuildingService;

    @RequestMapping("/{id}")
    private User view(@PathVariable("id") Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        Bi_building bi_building = biBuildingService.getBiBuilding(new BigDecimal(51602));
        System.out.println(bi_building);
        return user;
    }

    public static void main(String[] args) {
        SpringApplication.run(UserController.class);
    }
}
