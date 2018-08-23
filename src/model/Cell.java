package model;

public class Cell {
    public int status;

    public Cell(){
        this.status = 1;
    }

    public void die(){
        this.status = 0;
    }

    public void live(){
        this.status = 1;
    }

    public boolean isDie(){
        return this.status == 0;
    }

    public boolean isLive(){
        return this.status == 1;
    }
}


