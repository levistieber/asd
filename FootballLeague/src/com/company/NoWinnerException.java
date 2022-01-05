package com.company;

public class NoWinnerException extends Exception{
    public NoWinnerException() {
        super("There are no teams in the league yet.");
    }
}
