package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Stack {

    Queue<Integer> queue = new LinkedList<>();

    public void push(int val){
        int size = queue.size();

        queue.add(val);

        for (int i = 0; i < size; i++) {
            queue.add(queue.remove());
        }
    }

    public int pop(){
        if (queue.isEmpty()){
            return -1;
        }
        return queue.remove();
    }

    public static void main(String[] args){
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("top: "+s.pop());
        System.out.println("top: "+s.pop());
        System.out.println("top: "+s.pop());
    }
}
