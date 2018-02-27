package com.mygdx.game;


import com.badlogic.gdx.utils.TimeUtils;

import java.sql.Time;


public class Timer {
    private static long startTime;
    private  static  long defaultTime = System.currentTimeMillis()/1000;
   // private  static  long endTIme = startTime/1000 - defaultTime;
    private  static  long endTIme;


    public Timer() {






    }


    public static long StartTimer() {

        startTime = System.currentTimeMillis();

         System.out.print((startTime/1000 - defaultTime) + "\n");

            return startTime/1000 - defaultTime;
    }




    public static long StopTimer(){

        System.out.println("Time elapsed in seconds = " + ((startTime/1000 - defaultTime)));
        return  (startTime/1000 - defaultTime);
    }

    public static long getEndTIme() {



        return StopTimer();
    }


}
