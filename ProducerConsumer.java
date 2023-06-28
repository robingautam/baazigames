package org.example;

class Data {
    public int data;
    public boolean isProduced = false;
    public synchronized void produce(int d){
        if (isProduced==true){
            try {
                wait();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        this.data = d;
        System.out.println("producing data : "+data);
        isProduced = true;
        notify();
    }

    public synchronized int consume(){
        if (isProduced==false){
            try {
                wait();
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
        }
        isProduced = false;
        notify();
        return data;
    }
}

class Producer extends Thread {
    Data obj;
    Producer(){};
    Producer(Data d){
        this.obj = d;
    }

    @Override
    public void run(){
        for (int i=1;i<=10;i++){
            obj.produce(i);
        }
    }

}

class Consumer extends Thread {
    Data obj;
    Consumer(){};
    Consumer(Data d){
        this.obj = d;
    }

    @Override
    public void run(){
        for (int i=1;i<=10;i++){
            System.out.println("Consuming data: "+obj.consume());
        }
    }
}
public class ProducerConsumer {

    public static void main(String[] args){
        Data sharedObj = new Data();
        Producer producer = new Producer(sharedObj);
        Consumer consumer = new Consumer(sharedObj);

        producer.start();
        consumer.start();
    }
}
