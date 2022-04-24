package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main
{
    public static void main(String[] args) {

        char[] Z = {'A','B','D','D','A','B','C','A','B','C','C','D','A','B','C','A','C'};

        int l = Z.length;
        double k = 0;

        ArrayList<Character> list = new ArrayList<Character>();
        ArrayList<Double> lcount = new ArrayList<Double>();
        ArrayList<Character> lletter = new ArrayList<Character>();
        ArrayList<String> lbi = new ArrayList<String>();

        for (int i = 0; i < Z.length; i++)
            list.add(Z[i]);

        Collections.sort(list);

        int letter = list.get(0), count = 0;
        for (int i = 0; i < list.size(); i++){
            if (list.get(i) != letter){
                letter = list.get(i);
                k = (double)count/l;
                System.out.print("[" + list.get(i - 1) + "] - " + k + ", ");
                lletter.add(list.get(i - 1));
                lcount.add((double)count/l);
                count = 1;
            }
            else count++;
        }
        k = (double)count/l;
        System.out.print("[" + list.get(list.size() - 1) + "] - " + k + ";");
        lletter.add(list.get(list.size() - 1));
        lcount.add((double)count/l);

        for (int i=0; i<lletter.size(); i++){
            for (int j = i+1; j<lletter.size(); j++)
                if (lcount.get(i) < lcount.get(j)){
                    double temp1 = lcount.get(i);
                    double temp2 = lcount.get(j);
                    lcount.set(j,temp1);
                    lcount.set(i,temp2);
                    char temp11 = lletter.get(i);
                    char temp12 = lletter.get(j);
                    lletter.set(j,temp11);
                    lletter.set(i,temp12);
                }
        }

        System.out.println();
        System.out.println();

        for(int i=0;i<lletter.size();i++){
            System.out.print("[" + lletter.get(i)+"] - "+lcount.get(i)+"; ");
        }

        for (int i = 0; i<lletter.size(); i++)
            lbi.add("");

        String temp3 = String.valueOf(lletter.get(lletter.size()-1));
        double summ = lcount.get(lcount.size()-1);
        ArrayList<Double> lsumm = new ArrayList<Double>();

        for (int i = lletter.size()-1; i>0; i--){
            if (summ < lcount.get(i-1)){
                for(int j = i; j<lletter.size(); j++){
                    lbi.set(j,"1"+lbi.get(j));
                }
                lbi.set(i-1,"0"+lbi.get(i-1));
            }
            else {
                for(int j = i; j<lletter.size(); j++){
                    lbi.set(j,"0"+lbi.get(j));
                }
                lbi.set(i-1,"1"+lbi.get(i-1));
            }
            temp3 = temp3 + String.valueOf(lletter.get(i-1));
            summ = summ + lcount.get(i-1);
            lsumm.add(summ);
        }

        System.out.println();
        System.out.println();
        for(int i=0;i<lletter.size();i++){
            System.out.print("[" + lletter.get(i)+"] - "+lbi.get(i)+"; ");
        }

        System.out.println();

        Double L = 0.0;
        for (int i=0; i<lletter.size(); i++){
            L = L + lbi.get(i).length()*lcount.get(i);
        }

        System.out.println();
        System.out.println("Average code length: "+L);
    }
}
