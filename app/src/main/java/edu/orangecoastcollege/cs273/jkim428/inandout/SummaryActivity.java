package edu.orangecoastcollege.cs273.jkim428.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

/**
 * Controller for SummaryActivity.
 * Displays order details received from OrderActivity.
 */
public class SummaryActivity extends AppCompatActivity {

    private TextView mOrderTotalTextView;
    private TextView mItemsOrderedTextView;
    private TextView mSubtotalTextView;
    private TextView mTaxTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        mOrderTotalTextView = (TextView) findViewById(R.id.orderTotalTextView);
        mItemsOrderedTextView = (TextView) findViewById(R.id.itemsOrderedTextView);
        mSubtotalTextView = (TextView) findViewById(R.id.subtotalTextView);
        mTaxTextView = (TextView) findViewById(R.id.taxTextView);

        Intent intentFromOrder = getIntent();

        DecimalFormat f = new DecimalFormat("0.00");

        mOrderTotalTextView.setText(getString(R.string.order_total) + " $" + f.format(intentFromOrder.getDoubleExtra("orderTotal", 0.0f)));
        mItemsOrderedTextView.setText(getString(R.string.items_ordered) + " " + intentFromOrder.getIntExtra("itemsOrdered", 0));
        mSubtotalTextView.setText(getString(R.string.subtotal) + " $" + f.format(intentFromOrder.getDoubleExtra("subtotal", 0.0f)));
        mTaxTextView.setText(getString(R.string.tax) + " $" + f.format(intentFromOrder.getDoubleExtra("tax", 0.0f)));
    }

    protected void startNewOrder(View v)
    {
        Intent OrderIntent = new Intent(this, OrderActivity.class);
        startActivity(OrderIntent);
    }
}
