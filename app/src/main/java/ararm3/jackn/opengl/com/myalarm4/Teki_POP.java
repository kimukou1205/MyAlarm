package ararm3.jackn.opengl.com.myalarm4;

import java.util.ArrayList;

public class Teki_POP {
    public int tpc;
    public ArrayList<Integer> tms = new ArrayList();
    public ArrayList<Integer> tmr = new ArrayList();
    public ArrayList<Integer> tmc = new ArrayList();

    Teki_POP(int tpc,ArrayList tms,ArrayList tmr,ArrayList tmc){
        this.tpc = tpc;
        this.tms = tms;
        this.tmr = tmr;
        this.tmc = tmc;
    }

}
/*
 * 将来的にはいらなくなるかもですが
 * 一時的に敵の動きを記憶させておくクラスです
 */
