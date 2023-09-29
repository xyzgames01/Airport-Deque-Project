/**
 * Zachary Zawodny
 * Deque Airport simulator
 * 4/12/23
 * ITN262
 */

package com.airport.dlldeque;

import java.util.ArrayList;
import java.util.Scanner;

public class AirportDriver {

    public static Scanner scanObj = new Scanner(System.in);

    public static ArrayList<Deque<Flight>> airport = new ArrayList<>();

    public static Deque<Flight> runway1 = new Deque<>();
    public static Deque<Flight> runway2 = new Deque<>();

    public static boolean runwayTurn = true;

    public static void main(String[] args){

        runway1.offerFirst(new Flight(451, "AA"));
        runway1.offerFirst(new Flight(1561, "AA"));
        runway1.offerFirst(new Flight(3134, "AA"));
        runway1.offerFirst(new Flight(4561, "SA"));

        runway2.offerFirst(new Flight(1134, "SA"));
        runway2.offerFirst(new Flight(1351, "AA"));



        System.out.println("Loading Airplane queues...");
        System.out.println("Planes are ready for take off! \n");

        Runway();

    }

    public static void Runway(){

        if (runway2.isEmpty() && runway1.isEmpty()){
            System.out.println("All planes have left the building");
            System.exit(0);
        }


        System.out.println("Runway:1 " + runway1.toString());
        System.out.println("Runway:2 " + runway2.toString());


        System.out.println("### MENU ### \n1. Approve next plane \n2. Emergency override from Runway 1" +
                "\n3. Emergency override from Runway 2");
        int menu;
        menu = scanObj.nextInt();

        if (menu >= 1 && menu <= 3){
            if (menu == 1){
                ApprovePlane();
            }
            OverrideRunway(menu);
        }else {
            System.out.println("Invalid Input Try again");
            Runway();
        }

    }

    public static void ApprovePlane(){

        if (runwayTurn){
            if (!runway1.isEmpty()) {
                System.out.println(runway1.pollFirst() + " Is Taking Off on runway 1 \n");
            }else {
                System.out.println(runway2.pollFirst() + " Is Taking Off on runway 2 \n");
            }
            runwayTurn = false;
        }else {
            if (!runway2.isEmpty()) {
                System.out.println(runway2.pollFirst() + " Is Taking Off on runway 2 \n");
            }else {
                System.out.println(runway1.pollFirst() + " Is Taking Off on runway 1 \n");
            }
            runwayTurn = true;
        }

        Runway();

    }

    public static void OverrideRunway(int plane){

        if (plane == 2){
            if (!runway1.isEmpty()){
                System.out.println(runway1.pollFirst() + " Is Taking Off on runway 1 \n");
            }else {
                System.out.println("Runway 1 is empty \n");
            }
        }
        if (plane == 3){
            if (!runway2.isEmpty()){
                System.out.println(runway2.pollFirst() + " Is Taking Off on runway 2 \n");
            }else {
                System.out.println("Runway 2 is empty \n");
            }
        }
        Runway();
    }


}
