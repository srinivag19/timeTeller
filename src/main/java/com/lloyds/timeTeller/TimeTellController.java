package com.lloyds.timeTeller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@RestController
public class TimeTellController {

    @GetMapping("/time/{hour}/{minute}")
    public Map<String, String> index(@PathVariable("hour") int hour, @PathVariable("minute") int minute ) {

        Map<String, String> jsonReturn = new HashMap<>();
        String singularOrPlural,selectWord;
        String words[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
                "Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Twenty one","Twenty two","Twenty three","Twenty four","Twenty five","Twenty six",
                "Twenty seven","Twenty eight", "Twenty nine"};

        if((hour>=1 && hour<=23)&&(minute>=0&&minute<=59))
        {
            if(minute==1 || minute==59)
            {
                singularOrPlural="Minute";
            }
            else
            {
                singularOrPlural="Minutes";
            }
            if(hour==12 || hour==23)
            {
                selectWord= words[1];
            }
            else
            {
                selectWord= words[hour+1];
            }

            if(hour>=13 && hour<=23)
            {
                selectWord= words[hour - 11];
                hour=hour-12;
            }

            if(minute==0)
            {
                jsonReturn.put("Time Entered", +hour+" : "+minute);
                jsonReturn.put("Time in words", words[hour]+" O' clock");

                return jsonReturn;
            }
            else if(minute==15)
            {
                jsonReturn.put("Time Entered", +hour+" : "+minute);
                jsonReturn.put("Time in words", "Quarter Past "+words[hour]);

                return jsonReturn;
            }
            else if(minute==30)
            {
                jsonReturn.put("Time Entered", +hour+" : "+minute);
                jsonReturn.put("Time in words", "Half Past "+words[hour]);
                return jsonReturn;
            }
            else if(minute==45)
            {
                jsonReturn.put("Time Entered", +hour+" : "+minute);
                jsonReturn.put("Time in words", "Quarter to "+selectWord);
                return jsonReturn;

            }
            else if(minute<30)
            {
                jsonReturn.put("Time Entered", +hour+" : "+minute);
                jsonReturn.put("Time in words", words[minute]+" "+ singularOrPlural +" past "+words[hour]);
                return jsonReturn;
            }
            else
            {
                jsonReturn.put("Time Entered", +hour+" : "+minute);
                jsonReturn.put("Time in words", words[60-minute]+" "+ singularOrPlural +" to "+selectWord);
                return jsonReturn;

            }
        }
        else
        {
            jsonReturn.put("Time Entered", +hour+" : "+minute);
            jsonReturn.put("Time in words", "Invalid time entered");
            return jsonReturn;
        }
    }

}