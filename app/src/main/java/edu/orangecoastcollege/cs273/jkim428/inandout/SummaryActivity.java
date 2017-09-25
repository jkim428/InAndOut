package edu.orangecoastcollege.cs273.jkim428.inandout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

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

        mOrderTotalTextView.setText(R.string.order_total + String.valueOf(f.format(intentFromOrder.getDoubleExtra("orderTotal", 0.0f))));
        mItemsOrderedTextView.setText(R.string.items_ordered + intentFromOrder.getIntExtra("itemsOrdered", 0));
        mSubtotalTextView.setText(R.string.subtotal + intentFromOrder.getIntExtra("subtotal", 0));
        mTaxTextView.setText(R.string.tax + intentFromOrder.getIntExtra("tax", 0));
    }

    protected void startNewOrder(View v)
    {
        Intent OrderIntent = new Intent(this, OrderActivity.class);
        startActivity(OrderIntent);
    }
}
