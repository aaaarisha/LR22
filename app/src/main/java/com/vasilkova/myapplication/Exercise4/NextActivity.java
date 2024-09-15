package com.vasilkova.myapplication.Exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vasilkova.myapplication.R;

public class NextActivity extends AppCompatActivity {

    private RadioGroup radioGroupTemperature;
    private CheckBox checkMilk, checkCream, checkSugar, checkSyrup;
    private Spinner spinnerDelivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        radioGroupTemperature = findViewById(R.id.radioGroupTemperature);
        checkMilk = findViewById(R.id.checkMilk);
        checkCream = findViewById(R.id.checkCream);
        checkSugar = findViewById(R.id.checkSugar);
        checkSyrup = findViewById(R.id.checkSyrup);
        spinnerDelivery = findViewById(R.id.spinnerDelivery);
        Button buttonSubmit = findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(v -> submitOrder());
    }

    private void submitOrder() {
        // Получаем выбранную температуру кофе
        int selectedTemperatureId = radioGroupTemperature.getCheckedRadioButtonId();
        if (selectedTemperatureId == -1) {
            // Если температура не выбрана, показываем Toast и выходим из метода
            Toast.makeText(this, "Выберите температуру кофе", Toast.LENGTH_SHORT).show();
            return;
        }
        String temperature = ((RadioButton) findViewById(selectedTemperatureId)).getText().toString();

        // Собираем добавки
        StringBuilder additions = new StringBuilder();
        if (checkMilk.isChecked()) additions.append("Молоко ");
        if (checkCream.isChecked()) additions.append("Сливки ");
        if (checkSugar.isChecked()) additions.append("Сахар ");
        if (checkSyrup.isChecked()) additions.append("Сироп ");
        if (additions.length() == 0) additions.append("без добавок");

        // Получаем выбранный способ доставки
        String deliveryMethod = spinnerDelivery.getSelectedItem().toString();

        // Формируем текст заказа
        String orderSummary = getString(R.string.order_summary, temperature, additions.toString(), deliveryMethod);

        // Переход на новую активность
        Intent intent = new Intent(NextActivity.this, OrderActivity.class);
        intent.putExtra("order_summary", orderSummary);
        startActivity(intent);

        // Показываем Toast с именем студента
        String studentName = getString(R.string.student_name);
        Toast.makeText(NextActivity.this, "Заказ выполнил: " + studentName, Toast.LENGTH_SHORT).show();
    }
}
