package com.protosstechnology.train.bootexamine.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogController {

//    Logger logger = LoggerFactory.getLogger(LogController.class);

    @Value("${application.server.path}")
    String serverPath;

    @GetMapping("/logger")
    public ResponseEntity<String> index(){
//        logger.trace("A TRACE Message");
//        logger.debug("A DEBUG Message");
//        logger.info("An INFO Message");
//        logger.warn("A WARN Message");
//        logger.error("An Error Message");
//
//        logger.warn("serverPath={}",serverPath);

        return ResponseEntity.ok().body("Check out the Logs to see the output...");

    }

}
