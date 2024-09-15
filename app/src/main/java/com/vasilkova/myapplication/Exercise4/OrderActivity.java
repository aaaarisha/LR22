package com.vasilkova.myapplication.Exercise4;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.vasilkova.myapplication.R;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        TextView orderSummaryText = findViewById(R.id.orderSummaryText);

        // Получаем заказ из intent
        String orderSummary = getIntent().getStringExtra("order_summary");

        // Отображаем заказ
        orderSummaryText.setText(orderSummary);
    }
}
