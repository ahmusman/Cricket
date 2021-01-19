package com.Tekion.Cricket;

import java.util.Random;
class Utils {

    /**
     * generates a random number from 1-100
     * @return the number of runs the rand corresponds to
     */
    public static int random(){
        Random rand = new Random();
        int hit = rand.nextInt(101);
        if( hit < 5){ return 7; }
        if( hit <20){return 1;}
        if( hit <35){return 2;}
        if( hit <50){return 3;}
        if( hit <65){return 4;}
        if( hit <80){return 5;}
        else{return 6;}
    }

}