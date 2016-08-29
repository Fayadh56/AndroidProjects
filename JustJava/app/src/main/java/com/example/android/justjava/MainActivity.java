package com.example.android.justjava; /**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p/>
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

import com.example.android.justjava.R;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int quantity = 0;

    // calls submit order method, to display the string summary
    public void submitOrder(View view) {

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkBoxWhipped);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.checkBoxChocolate);
        boolean hasChocolate = chocolateCheckBox.isChecked();

        EditText personName = (EditText) findViewById(R.id.personName);
        String name = personName.getText().toString();

        //displayMessage(createOrderSummary(name, checkBoxes(hasWhippedCream,hasChocolate, calculatePrice())));
        composeEmail(createOrderSummary(name, checkBoxes(hasWhippedCream, hasChocolate, calculatePrice())));
    }

    // calculates price
    private int calculatePrice() {
        return quantity * 5;
    }

    // creates the summary to display
    private String createOrderSummary(String name, String checkBoxes) {
        return "Name: " + name + "\nQuantity: " + quantity + "\nTotal: $" + checkBoxes;
    }

    /* this function determines checkboxes if ticked or not */
    private String checkBoxes (boolean whippedCream, boolean chocolate, int price) {
        // if else and what not
        String hasCream = "No";
        if (whippedCream) {
            hasCream = "Yes";
            price += 1;
        }

        String hasChoc = "No";
        if (chocolate) {
            hasChoc = "Yes";
            price += 2;
        }
        return price + "\nThank You!" + "\nWhipped Cream: " + hasCream + "\nChocolate: " + hasChoc;
    }

    // increment function for quantity
    public void increment(View view) {
        if (quantity >= 100) {
            Toast.makeText(this, "Don't you think that's too much?", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        display(quantity);
    }

    // email app intent, to send order out.
    public void composeEmail(String summary) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order for Coffee");
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    // decrement for quantity
    public void decrement(View view) {
        if (quantity <= 1) {
            Toast.makeText(this, "Can't Have Negatives Lad", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity--;
        display(quantity);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        String setText1 = "" + number;
        quantityTextView.setText(setText1);
    }

    //    private void displayMessage(String message) {
    //        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
    //        orderSummaryTextView.setText(message);
    //    }
}
