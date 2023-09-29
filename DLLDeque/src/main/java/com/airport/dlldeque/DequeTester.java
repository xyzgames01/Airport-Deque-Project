package com.airport.dlldeque;

public class DequeTester {

    public static Deque<Integer> runway1 = new Deque<>();
    public static Deque<Integer> runway2 = new Deque<>();

    public static void main(String[] args){

        runway1.offerLast(12);
        runway1.offerLast(13);
        runway1.offerLast(14);

        runway1.offerFirst(14);

        runway1.offerLast(23);

        System.out.println(runway1);

        System.out.println(runway1.peekLast());
        System.out.println(runway1.peekFirst());

        System.out.println(runway1.pollFirst());
        System.out.println(runway1.pollLast());

        System.out.println(runway1);

        System.out.println(runway1.peekLast());
        System.out.println(runway1.peekFirst());

    }

}
