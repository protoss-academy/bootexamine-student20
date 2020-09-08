package com.protosstechnology.train.bootexamine.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {

    Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Value("${application.server.path}")
    String serverPath;

    @GetMapping("/logger")
    public ResponseEntity<String> index(){
        LOGGER.trace("A TRACE Message");
        LOGGER.debug("A DEBUG Message");
        LOGGER.info("An INFO Message");
        LOGGER.warn("A WARN Message");
        LOGGER.error("An Error Message");

        LOGGER.warn("serverPath={}",serverPath);

        return ResponseEntity.ok().body("Check out the Logs to see the output...");

    }

}
