package com.example.android.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment(View view) {

        if(quantity == 100) {
            Toast.makeText(this ,  "you cant have coffee" , Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement(View view) {
        if(quantity == 0)
        {
            Toast.makeText(this ,  "you cant have coffee" , Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
        display(quantity);

    }

    public void submitOrder(View view) {
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_creame_checkbox);
       boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate= chocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream , hasChocolate);

        displayMessage(createOrderSummary(name , price , hasWhippedCream , hasChocolate));

    }

    private String createOrderSummary(String name , int price , boolean addWhippedCream, boolean addChocolate ) {
        String priceMessage = " Name : " + name;
        priceMessage += "\nAdd Whipped Cream " + addWhippedCream;
        priceMessage += "\nchocolate "       + addChocolate;
        priceMessage += "\n quantity " + quantity;
        priceMessage += "\n Total : $" + price;
        priceMessage += " \n thank you";
        return priceMessage;
    }


    private int calculatePrice(boolean addWhippedCream, boolean chocolate) {
        int basePrice = 5;

        if (addWhippedCream)
        {
            basePrice = basePrice + 1;
        }
        if (chocolate)
            basePrice = basePrice + 2;
        return quantity * basePrice ;

    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }


    private void display(int numbers) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(" " + numbers);
    }


}