package edu.orangecoastcollege.cs273.jkim428.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {

    private EditText mDoubleDoubleEditText;
    private EditText mCheeseburgerEditText;
    private EditText mFrenchFriesEditText;
    private EditText mShakesEditText;
    private EditText mSmallDrinksEditText;
    private EditText mMediumDrinksEditText;
    private EditText mLargeDrinksEditText;

    private Order mOrder = new Order();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        initialize();
    }

    protected void initialize()
    {
        mDoubleDoubleEditText = (EditText) findViewById(R.id.doubleDoubleEditText);
        mCheeseburgerEditText = (EditText) findViewById(R.id.cheeseBurgerEditText);
        mFrenchFriesEditText = (EditText) findViewById(R.id.frenchFriesEditText);
        mShakesEditText = (EditText) findViewById(R.id.shakesEditText);
        mSmallDrinksEditText = (EditText) findViewById(R.id.smallEditText);
        mMediumDrinksEditText = (EditText) findViewById(R.id.mediumEditText);
        mLargeDrinksEditText = (EditText) findViewById(R.id.largeEditText);
    }

    protected void placeOrder(View v)
    {
        int numDoubleDouble = 0, numCheeseburgers = 0, numFrenchFries = 0,
            numShakes = 0, numSmallDrinks = 0, numMediumDrinks = 0, numLargeDrinks = 0;

        if (mDoubleDoubleEditText.getText().toString() != null)
            numDoubleDouble = Integer.parseInt(mDoubleDoubleEditText.getText().toString());
        if (mCheeseburgerEditText.getText().toString() != null)
            numCheeseburgers = Integer.parseInt(mCheeseburgerEditText.getText().toString());
        if (mFrenchFriesEditText.getText() != null)
            numFrenchFries = Integer.parseInt(mFrenchFriesEditText.getText().toString());
        if (mShakesEditText.getText() != null)
            numShakes = Integer.parseInt(mShakesEditText.getText().toString());
        if (mSmallDrinksEditText.getText() != null)
            numSmallDrinks = Integer.parseInt(mSmallDrinksEditText.getText().toString());
        if (mMediumDrinksEditText.getText() != null)
            numMediumDrinks = Integer.parseInt(mMediumDrinksEditText.getText().toString());
        if (mLargeDrinksEditText.getText() != null)
            numLargeDrinks = Integer.parseInt(mLargeDrinksEditText.getText().toString());

        int itemsOrdered = numDoubleDouble + numCheeseburgers + numFrenchFries + numShakes +
                           numSmallDrinks + numMediumDrinks + numLargeDrinks;

        mOrder.setDoubleDouble(numDoubleDouble);
        mOrder.setCheeseburgers(numCheeseburgers);
        mOrder.setFrenchFries(numFrenchFries);
        mOrder.setShakes(numShakes);
        mOrder.setSmallDrinks(numSmallDrinks);
        mOrder.setMediumDrinks(numMediumDrinks);
        mOrder.setLargeDrinks(numLargeDrinks);

        Intent summaryIntent = new Intent(this, SummaryActivity.class);
        summaryIntent.putExtra("orderTotal", mOrder.calculateTotal());
        summaryIntent.putExtra("itemsOrdered", itemsOrdered);
        summaryIntent.putExtra("subtotal", mOrder.calculateSubtotal());
        summaryIntent.putExtra("tax", mOrder.calculateTax());

        startActivity(summaryIntent);
    }
}

