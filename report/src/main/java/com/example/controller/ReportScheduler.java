// ReportScheduler.java
package com.example.controller;


import com.example.service.FileService;
import com.example.service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportScheduler {

    @Autowired
    private FileService fileService;

    @Autowired
    private TransformationService transformationService;

    @Scheduled(cron = "0 0 0 * * ?") // Every day at midnight
    public void generateReport() {
        // Logic to fetch files, parse, transform and generate reports
        // fileService.parseInputFile(...);
        // fileService.parseReferenceFile(...);
        // transformationService.transformData(...);
        // Save the transformed data to output CSV
    }
}


