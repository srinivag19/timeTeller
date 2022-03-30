package com.lloyds.timeTeller;

import java.util.Scanner;

public class TimeTeller {

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int hour, minute;
        String singularOrPlural,word;
        String words[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
                "Sixteen","Seventeen","Eighteen","Nineteen","Twenty","Twenty one","Twenty two","Twenty three","Twenty four","Twenty five","Twenty six",
                "Twenty seven","Twenty eight", "Twenty nine"};
        System.out.println("Enter Hour");
        hour = in.nextInt();
        System.out.println("Enter Minutes");
        minute = in.nextInt();
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
                word= words[1];
            }
            else
            {
                word= words[hour+1];
            }

            if(hour>=13 && hour<=23)
            {
                word= words[hour - 11];
                hour=hour-12;
            }

            if(minute==0)
            {
                System.out.println("Time Entered - "+hour+" : "+minute);
                System.out.println(words[hour]+" O' clock");
            }
            else if(minute==15)
            {
                System.out.println("Time Entered - "+hour+" : "+minute);
                System.out.println("Quarter Past "+words[hour]);
            }
            else if(minute==30)
            {
                System.out.println("Time Entered - "+hour+" : "+minute);
                System.out.println("Half Past "+words[hour]);
            }
            else if(minute==45)
            {
                System.out.println("Time Entered - "+hour+" : "+minute);
                System.out.println("Quarter to "+word);
            }
            else if(minute<30)
            {
                System.out.println("Time Entered - "+hour+" : "+minute);
                System.out.println(words[minute]+" "+ singularOrPlural +" past "+words[hour]);
            }
            else
            {
                System.out.println("Time Entered - "+hour+" : "+minute);
                System.out.println(words[60-minute]+" "+ singularOrPlural +" to "+word);
            }
        }
        else
        {
            System.out.println("Invalid Time Entered");
        }
    }

}
