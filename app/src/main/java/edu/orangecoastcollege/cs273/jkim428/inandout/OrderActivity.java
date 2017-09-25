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

    private Order mOrder;

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

        mOrder = new Order();
    }

    protected void placeOrder(View v)
    {
        int numDoubleDouble = Integer.parseInt(mDoubleDoubleEditText.getText().toString());
        int numCheeseburgers = Integer.parseInt(mCheeseburgerEditText.getText().toString());
        int numFrenchFries = Integer.parseInt(mFrenchFriesEditText.getText().toString());
        int numShakes = Integer.parseInt(mShakesEditText.getText().toString());
        int numSmallDrinks = Integer.parseInt(mSmallDrinksEditText.getText().toString());
        int numMediumDrinks = Integer.parseInt(mMediumDrinksEditText.getText().toString());
        int numLargeDrinks = Integer.parseInt(mLargeDrinksEditText.getText().toString());
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

