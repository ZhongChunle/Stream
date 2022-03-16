package com.zcl.Lambda;

import com.zcl.startegy.ComputeStr;

public class Test {
    private ComputeStr computeStr;

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        String method = args[2];
        Test calculator = new Test();
        if("aff".equals(method)){
            System.out.println(calculator.add(a,b));
        }else if("sub".equals(method)){
            System.out.println(calculator.sub(a,b));
        }else {
            System.out.println("待开放算法");
        }
    }

    public int add(int a,int b){return a+b;}
    public int sub(int a,int b){return a-b;}

    public ComputeStr getComputeStr() {
        return computeStr;
    }

    public void setComputeStr(ComputeStr computeStr) {
        this.computeStr = computeStr;
    }
}
