// TransformationService.java
package com.example.service;

import com.example.models.InputData;
import com.example.models.OutputData;
import com.example.models.ReferenceData;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransformationService {

    public List<OutputData> transformData(List<InputData> inputDataList, List<ReferenceData> referenceDataList) {
        List<OutputData> outputDataList = new ArrayList<>();

        for (InputData inputData : inputDataList) {
            Optional<ReferenceData> refDataOptional = referenceDataList.stream()
                    .filter(ref -> ref.getRefkey1().equals(inputData.getRefkey1()) && ref.getRefkey2().equals(inputData.getRefkey2()))
                    .findFirst();

            if (refDataOptional.isPresent()) {
                ReferenceData referenceData = refDataOptional.get();
                OutputData outputData = new OutputData();
                outputData.setOutfield1(inputData.getField1() + inputData.getField2());
                outputData.setOutfield2(referenceData.getRefdata1());
                outputData.setOutfield3(referenceData.getRefdata2() + referenceData.getRefdata3());
                outputData.setOutfield4(new BigDecimal(inputData.getField3()).multiply(
                        inputData.getField5().max(referenceData.getRefdata4())));
                outputData.setOutfield5(inputData.getField5().max(referenceData.getRefdata4()));
                outputDataList.add(outputData);
            }
        }
        return outputDataList;
    }
}
