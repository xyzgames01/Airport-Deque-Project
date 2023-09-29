package com.airport.dlldeque;

public class Deque<T> {

    private Node<T> head, tail;

    private int numNodes = 0;

    public void offerLast(T data){
        Node<T> node = new Node<T>(data);
        if(head == null){
            head = node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
        }
        tail = node;
        numNodes++;
    }

    public void offerFirst(T data){
        Node<T> node = new Node<T>(data);
        if(tail == null){
            tail = node;
        }else{
            head.setPrevious(node);
            node.setNext(head);
        }
        head = node;
        numNodes++;
    }

    public T pollLast(){
        if (head == null){
            return (T) "Stack is Empty";
        }

        T POLLED_OBJECT = tail.getData();

        if (tail == head){
            head.setNext(null);
            head = null;
        }else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        numNodes--;
        return POLLED_OBJECT;
    }

    public T pollFirst(){
        if (head == null){
            return (T) "Stack is Empty";
        }

        T POLLED_OBJECT = head.getData();

        if (tail == head){
            tail.setNext(null);
            tail = null;
        }else {
            head = head.getNext();
            head.setPrevious(null);
        }
        numNodes--;
        return POLLED_OBJECT;
    }

    public T peekLast(){
        if (head == null){
            return (T) "Stack is Empty";
        }

        return tail.getData();

    }

    public T peekFirst(){
        if (head == null){
            return (T) "Stack is Empty";
        }

        return head.getData();

    }

    public int size(){
        return numNodes;
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public String toString(){
        if (head == null){
            return "[]";
        }

        String DEQUE_STRING = "";

        Node<T> current = head;

        while (current != null){

            if (current == head){
                DEQUE_STRING = current.data.toString() + DEQUE_STRING;
            }else {
                DEQUE_STRING = DEQUE_STRING + ", " + current.data.toString();
            }

            current = current.getNext();

        }
        return DEQUE_STRING;
    }


    private static class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> previous;

        private Node(T d) {
            data = d;
        }
        private T getData() {
            return data;
        }
        private void setData(T d) {
            this.data = d;
        }
        private Node<T> getNext() {
            return next;
        }
        private Node<T> getPrevious() {
            return previous;
        }
        private void setNext(Node<T> n) {
            this.next = n;
        }
        private void setPrevious(Node<T> p) {
            this.previous = p;
        }

    }



}
