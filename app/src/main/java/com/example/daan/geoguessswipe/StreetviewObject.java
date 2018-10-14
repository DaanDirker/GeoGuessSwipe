package com.example.daan.geoguessswipe;

public class StreetviewObject {

    private String mStreetviewName;
    private int mImage;
    private boolean mIsInEurope;

    public static String[] PRE_DEFINED_STREETVIEW_OBJECT_NAMES = {
            "Denmark",
            "Canada",
            "Bangladesh",
            "Kazachstan",
            "Colombia",
            "Poland",
            "Malta",
            "Thailand"
    };

    public static int[] PRE_DEFINED_STREETVIEW_OBJECT_IMAGE_IDS = {
            R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand
    };

    public static boolean[] PRE_DEFINED_IF_IN_EUROPE = {
            true,
            false,
            false,
            true,
            false,
            true,
            true,
            false
    };

    public StreetviewObject(String mStreetviewName, int mImage, boolean mIsInEurope) {
        this.mStreetviewName = mStreetviewName;
        this.mImage = mImage;
        this.mIsInEurope = mIsInEurope;
    }

    public String getmStreetviewObject() {
        return mStreetviewName;
    }

    public void setmStreetviewObject(String mStreetviewObject) {
        this.mStreetviewName = mStreetviewObject;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
        this.mImage = mImage;
    }

    public boolean mIsInEurope() {
        return mIsInEurope;
    }

    public void setmIsInEurope(boolean mIsInEurope) {
        this.mIsInEurope = mIsInEurope;
    }
}
