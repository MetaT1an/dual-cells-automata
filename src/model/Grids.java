package model;

import java.util.ArrayList;

public class Grids {
    private Cell[][] cells;
    private Cell[][] oldCells;
    private ArrayList<Cell> aroundCells;
    public static int N = 50;
    private static double cowBirthRate = 0.16;
    private static double grassBirthRate = 0.36;
    private static int SA_FOR_COW = 0;
    private static int CA_FOR_COW = 4;
    private static int RA_FOR_COW = 2;
    private static int RA_FOR_GRASS = 2;

    private Grids() {
        cells = new Cell[N][N];
        oldCells = new Cell[N][N];
        aroundCells = new ArrayList<>();
    }

    private static Grids grids = null;

    public static Grids getGrids(){
        if(grids == null)
            grids  = new Grids();
        return grids;
    }

    public static void resetArgs(int saForCow, int caForCow, int raForCow, int raForGrass){
        SA_FOR_COW = saForCow;
        CA_FOR_COW = caForCow;
        RA_FOR_COW = raForCow;
        RA_FOR_GRASS = raForGrass;
    }

    private void setCow(int i, int j){
        cells[i][j] = new Cow();
    }

    private void setGrass(int i, int j){
        cells[i][j] = new Grass();
    }

    public Cell getCell(int i, int j){
        return oldCells[i][j];
    }

    private void genAroundCells(int i, int j){
        aroundCells.clear();
        for(int m=i-1; m<=N-1 && m>=0 && m<=i+1; ++m)
            for(int n=j-1; n<=N-1 && n>=0 && n<=j+1; ++n){
                if(m == i && n == j)
                    continue;
                aroundCells.add(getCell(m, n));
            }
    }

    private int countCow(){
        int n = 0;
        for(Cell cell : aroundCells){
            if(cell instanceof Cow && cell.isLive())
                n++;
        }
        return n;
    }

    private int countGrass(){
        int n = 0;
        for(Cell cell : aroundCells){
            if(cell instanceof Grass && cell.isLive())
                n++;
        }
        return n;
    }

    public void resetCells(){
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
                    cells[i][j].die();    // status = 0
                }
            }
        }
        copyCells();
    }

    private void copyCells(){
        for(int i = 0; i < Grids.N; ++i){
            System.arraycopy(cells[i], 0, oldCells[i], 0, Grids.N);
        }
    }

    public void scan(){
        Cell cell;
        int c, g;
        for(int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {

                cell = getCell(i, j);
                genAroundCells(i, j);
                c = countCow();
                g = countGrass();

                if (cell.isDie()) {
                    if (c >= g && c >= RA_FOR_COW && c < 4) {
                        setCow(i, j);
                    } else if (g >= c && g >= RA_FOR_GRASS) {
                        setGrass(i, j);
                    } else {
                        // remain died
                    }
                } else if (cell instanceof Cow) {
                    if (g >= c + SA_FOR_COW && g != 0) {
                        cell.live();
                    } else {
                        cell.die();
                    }
                } else {    // grass
                    if (c >= CA_FOR_COW || g >= 5) {
                        cell.die();
                    } else {
                        cell.live();
                    }
                }
            }
        }
        copyCells();
    }
}


