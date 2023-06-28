package org.example;

public class Account implements OnlineAccount, Comparable<Account>{

    int noOfRegularMovies;
    int noOfExclusiveMovies;
    String ownerName;

    Account(){

    }

    public Account(int regularMovie, int exclusiveMovie, String ownerName){
        this.noOfExclusiveMovies = exclusiveMovie;
        this.noOfRegularMovies = regularMovie;
        this.ownerName = ownerName;
    }

    public int monthlyCost(){
        return BASE_PRICE+(noOfRegularMovies*REGULAR_MOVIE_PRICE)+(noOfExclusiveMovies*EXCLUSIVE_MOVIE_PRICE);
    }

    @Override
    public int compareTo(Account o) {
        return o.monthlyCost()-this.monthlyCost();
    }

    @Override
    public String toString(){
        return "Owner is "+ownerName+" and Monthly cost is "+this.monthlyCost()+" USD";
    }
}
