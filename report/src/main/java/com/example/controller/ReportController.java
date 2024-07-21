// ReportController.java
package com.example.controller;


import com.example.models.InputData;
import com.example.models.OutputData;
import com.example.models.ReferenceData;
import com.example.service.FileService;
import com.example.service.TransformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private FileService fileService;

    @Autowired
    private TransformationService transformationService;

    @PostMapping("/generate")
    public String generateReport(@RequestParam("inputFile") MultipartFile inputFile,
                                 @RequestParam("referenceFile") MultipartFile referenceFile) {
        try {
            // Parse input and reference files
            List<InputData> inputDataList = fileService.parseInputFile(inputFile);
            List<ReferenceData> referenceDataList = fileService.parseReferenceFile(referenceFile);

            // Transform data
            List<OutputData> outputDataList = transformationService.transformData(inputDataList, referenceDataList);

            // Save outputDataList to a CSV file
            // ...

            return "Report generated successfully!";
        } catch (Exception e) {
            return "Error generating report: " + e.getMessage();
        }
    }
}