package edu.orangecoastcollege.cs273.jkim428.inandout;

/**
 * Created by jiwoongkim on 2017. 9. 25..
 */

public class Order {

    private static final double PRICE_DOUBLE_DOUBLE = 3.60;
    private static final double PRICE_CHEESEBURGER = 2.15;
    private static final double PRICE_FRENCH_FRIES = 1.65;
    private static final double PRICE_SHAKE = 2.20;
    private static final double PRICE_SMALL_DRINK = 1.45;
    private static final double PRICE_MEDIUM_DRINK = 1.55;
    private static final double PRICE_LARGE_DRINK = 1.75;
    private static final double TAX_RATE = 0.08;

    private int mDoubleDouble;
    private int mCheeseburgers;
    private int mFrenchFries;
    private int mShakes;
    private int mSmallDrinks;
    private int mMediumDrinks;
    private int mLargeDrinks;

    public Order()
    {
        mDoubleDouble = 0;
        mCheeseburgers = 0;
        mFrenchFries = 0;
        mShakes = 0;
        mSmallDrinks = 0;
        mMediumDrinks = 0;
        mLargeDrinks = 0;
    }

    public int getDoubleDouble() {
        return mDoubleDouble;
    }

    public void setDoubleDouble(int doubleDouble) {
        mDoubleDouble = doubleDouble;
    }

    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    public int getFrenchFries() {
        return mFrenchFries;
    }

    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    public int getShakes() {
        return mShakes;
    }

    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    public double calculateSubtotal() {
        return PRICE_DOUBLE_DOUBLE * mDoubleDouble + PRICE_CHEESEBURGER * mCheeseburgers +
                PRICE_FRENCH_FRIES * mFrenchFries + PRICE_SHAKE * mShakes +
                PRICE_SMALL_DRINK * mSmallDrinks + PRICE_MEDIUM_DRINK * mMediumDrinks +
                PRICE_LARGE_DRINK * mLargeDrinks;
    }

    public double calculateTax(){
        return TAX_RATE * calculateSubtotal();
    }

    public double calculateTotal(){
        return calculateSubtotal() + calculateTax();
    }
}
