package com.example.android.sunrisecafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // Jump to the Quick Order View
    public final void focusOnView(View view) {
        final ScrollView scrollViewText = (ScrollView) findViewById(R.id.activity_main);
        final TextView quickOrder = (TextView) findViewById(R.id.quick_order);

        scrollViewText.post(new Runnable() {
            @Override
            public void run() {
                scrollViewText.scrollTo(0, quickOrder.getTop());
            }
        });
    }

    // Increment Button
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    // Decrement Button
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = quantity * 4;
        String priceMessage = "Total: $" + price;
        displayMessage(priceMessage);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
    */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    public void openBrowser(View view){

        // Get url from tag
        String url = (String)view.getTag();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        // Pass the url to intent data
        intent.setData(Uri.parse(url));

        startActivity(intent);
    }


}
