package model;

import java.util.ArrayList;

public class Grids {
    private Cell[][] cells;
    private Cell[][] oldCells;
    private ArrayList<Cell> aroundCells;
    public static int N = 50;
    private static double cowBirthRate = 0.16;
    private static double grassBirthRate = 0.66;

    private Grids() {
        cells = new Cell[N][N];
        oldCells = new Cell[N][N];
        genCells();
        aroundCells = new ArrayList<>();
    }

    private static Grids grids = null;

    public static Grids getGrids(){
        if(grids == null)
            grids  = new Grids();
        return grids;
    }

    private void setCow(int i, int j){
        oldCells[i][j] = new Cow();
    }

    private void setGrass(int i, int j){
        oldCells[i][j] = new Grass();
    }

    public Cell getCell(int i, int j){
        return oldCells[i][j];
    }

    public void genAroundCells(int i, int j){
        aroundCells.clear();
        for(int m=i-1; m<=N-1 && m>=0 && m<=i+1; ++m)
            for(int n=j-1; n<=N-1 && n>=0 && n<=j+1; ++n){
                if(m == i && n == j)
                    continue;
                aroundCells.add(getCell(i, j));
            }
    }

    public int countCow(){
        int n = 0;
        for(Cell cell : aroundCells){
            if(cell instanceof Cow && cell.isLive())
                n++;
        }
        return n;
    }

    public int countGrass(){
        int n = 0;
        for(Cell cell : aroundCells){
            if(cell instanceof Grass && cell.isLive())
                n++;
        }
        return n;
    }

    private void genCells(){
        int i, j;
        double p;
        for(i = 0; i < N; ++i){
            for(j = 0; j < N; ++j){

                p = Math.random();
                if(p < cowBirthRate){
                    setCow(i, j);
                } else if(p >= cowBirthRate && p < grassBirthRate){
                    setGrass(i, j);
                } else {
                    setGrass(i, j);
                    getCell(i, j).die();    // status = 0
                }
            }
        }
    }

    // test initializing

//    public static void main(String[] args){
//        Grids grids = new Grids();
//        Cell cell;
//        for(int i = 0; i < N; ++i){
//            for(int j = 0; j < N; ++j){
//                cell = grids.getCell(i, j);
//                if(cell instanceof Grass && cell.isDie()){
//                    System.out.print(" ");
//                } else if(cell instanceof Grass && cell.isLive()){
//                    System.out.print("G ");
//                } else{
//                    System.out.print("C ");
//                }
//            }
//            System.out.println();
//        }
//    }
}


