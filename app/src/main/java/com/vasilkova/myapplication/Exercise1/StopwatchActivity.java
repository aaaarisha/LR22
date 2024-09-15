package com.vasilkova.myapplication.Exercise1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.vasilkova.myapplication.Exercise2.MainActivity; // Импорт второго задания
import com.vasilkova.myapplication.R;

public class StopwatchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        // Привязка полей
        final EditText toField = findViewById(R.id.toField);
        final EditText messageField = findViewById(R.id.messageField);
        Button sendButton = findViewById(R.id.sendButton);
        Button buttonToTaskTwo = findViewById(R.id.button_to_task_two); // Привязка новой кнопки

        // Обработка нажатия на кнопку отправки сообщения
        sendButton.setOnClickListener(v -> {
            String to = toField.getText().toString();
            String message = messageField.getText().toString();

            // Показать Toast с содержимым полей
            Toast.makeText(StopwatchActivity.this, "Отправлено: " + to + ", Сообщение: " + message, Toast.LENGTH_SHORT).show();

            // Очистить поля после отправки
            toField.setText("");
            messageField.setText("");
        });

        // Переход на активити второго задания
        buttonToTaskTwo.setOnClickListener(v -> {
            Intent intent = new Intent(StopwatchActivity.this, MainActivity.class); // Переход на активити второго задания
            startActivity(intent);
        });
    }
}
