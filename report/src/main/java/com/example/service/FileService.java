// FileService.java
package com.example.service;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.example.models.InputData;
import com.example.models.ReferenceData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    public List<InputData> parseInputFile(MultipartFile file) throws Exception {
        List<InputData> inputDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                InputData inputData = new InputData();
                inputData.setField1(record.get("field1"));
                inputData.setField2(record.get("field2"));
                inputData.setField3(record.get("field3"));
                inputData.setField5(new BigDecimal(record.get("field5")));
                inputData.setRefkey1(record.get("refkey1"));
                inputData.setRefkey2(record.get("refkey2"));
                inputDataList.add(inputData);
            }
        }
        return inputDataList;
    }

    public List<ReferenceData> parseReferenceFile(MultipartFile file) throws Exception {
        List<ReferenceData> referenceDataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                ReferenceData referenceData = new ReferenceData();
                referenceData.setRefkey1(record.get("refkey1"));
                referenceData.setRefdata1(record.get("refdata1"));
                referenceData.setRefkey2(record.get("refkey2"));
                referenceData.setRefdata2(record.get("refdata2"));
                referenceData.setRefdata3(record.get("refdata3"));
                referenceData.setRefdata4(new BigDecimal(record.get("refdata4")));
                referenceDataList.add(referenceData);
            }
        }
        return referenceDataList;
    }
}
