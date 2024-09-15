package com.vasilkova.myapplication.Exercise3;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.vasilkova.myapplication.Exercise4.NextActivity;
import com.vasilkova.myapplication.R;

public class MainActivity2 extends AppCompatActivity {

    private static final int BUTTON_PRESS_DURATION = 200; // Время в миллисекундах
    private static final int ACTIVITY_TRANSITION_DELAY = 300; // Время задержки перед переходом на следующую активность

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2); // Убедитесь, что используете правильное имя XML файла

        // Инициализация кнопок
        Button[] buttons = {
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6)
        };

        // Установка обработчиков нажатий
        View.OnClickListener buttonClickListener = v -> {
            // Изменение цвета кнопки при нажатии
            ObjectAnimator colorAnim = ObjectAnimator.ofArgb(
                    v,
                    "backgroundColor",
                    Color.TRANSPARENT,
                    Color.parseColor("#ab72b7")
            );
            colorAnim.setDuration(BUTTON_PRESS_DURATION);
            colorAnim.start();

            // Восстановление исходного цвета после задержки
            colorAnim.addListener(new android.animation.AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(android.animation.Animator animation) {
                    ObjectAnimator reverseColorAnim = ObjectAnimator.ofArgb(
                            v,
                            "backgroundColor",
                            Color.parseColor("#ab72b7"),
                            Color.TRANSPARENT
                    );
                    reverseColorAnim.setDuration(BUTTON_PRESS_DURATION);
                    reverseColorAnim.start();
                }
            });

            // Задержка перед запуском следующей активности
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(MainActivity2.this, NextActivity.class);
                startActivity(intent);
            }, ACTIVITY_TRANSITION_DELAY);
        };

        for (Button button : buttons) {
            button.setOnClickListener(buttonClickListener);
        }
    }
}
