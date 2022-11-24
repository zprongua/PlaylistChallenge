package io.zipcoder;

import java.util.ArrayList;

public class Music {

    private String[] playList;
    ArrayList<Integer> il = new ArrayList<Integer>();

    public Music(String[] playList){
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection){

        for (int i=0; i < playList.length; i++) {
            if (playList[i].equals(selection)) {
                il.add(i);
            }
        }
        int num = fastestRoute(startIndex, il);
        return num;
    }

    public int fastestRoute(int index, ArrayList il) {
        int lowest = 10;
        for (Object i : il) {
            if ( (Integer)i - index < lowest && (Integer) i - index> 0) {
                lowest = (Integer)i - index;
            }
            if ((index + playList.length) - (Integer) i < lowest && (index + playList.length) - (Integer) i > 0) {
                lowest = (index + playList.length) - (Integer) i;
            }
            if (((Integer) i + playList.length) - index < lowest) {
                lowest = ((Integer) i + playList.length) - index;
            }
        }
        return lowest;
    }
}
