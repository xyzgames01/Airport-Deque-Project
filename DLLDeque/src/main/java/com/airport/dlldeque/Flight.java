package com.airport.dlldeque;

public class Flight {

    private int flightNumber;
    private String airLine;

    Flight(int flightNum, String airln){
        flightNumber = flightNum;
        airLine = airln;
    }

    public String toString(){
        return  airLine + flightNumber ;
    }

}
