package com.example.cm1005.cheese.old;

import com.example.cm1005.cheese.R;

public class Cheese {
    String name;
    int viscosity;
    int meltingPoint;
    String origin;
    public static String[] names = {"Brie", "Mozzarella", "Camembert", "Emmental"};

    public static Cheese brie = new Cheese(names[0],40030,1,"France");
    public static Cheese mozarella = new Cheese(names[1],15329,0,"Italy");
    public static Cheese camembert = new Cheese(names[2],38025,0,"French");
    public static Cheese emmental = new Cheese(names[3],439264,67,"Germany");
    public static Cheese cheeseFacts[] = {brie, mozarella, camembert, emmental};

    //Resource IDs of drawable images placed in res/drawable folder

    public static int[] cheeseResource = new int[]{R.drawable.brie, R.drawable.mozarella,
            R.drawable.camembert,R.drawable.emmental};

    //public static int[] cheeseResource = new int[]{R.drawable.earth, R.drawable.earth,
          // R.drawable.earth,R.drawable.earth};

    //constructor
    public Cheese(String name, int viscosity, int meltingPoint, String origin) {
        this.name = name;
        this.viscosity = viscosity;
        this.meltingPoint = meltingPoint;
        this.origin = origin;
    }
    //accessors
    public String getName(){return name;}
    public int getViscosity() { return viscosity; }
    public int getMeltingPoint() { return meltingPoint; }
    public String getOrigin() { return origin; }
}


