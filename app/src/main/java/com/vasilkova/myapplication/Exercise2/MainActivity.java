package com.vasilkova.myapplication.Exercise2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.vasilkova.myapplication.Exercise1.StopwatchActivity;
import com.vasilkova.myapplication.Exercise3.MainActivity2;
import com.vasilkova.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Привязка первого текстового поля с текстом "Это кот (или кошка)"
        TextView catTextView = findViewById(R.id.cat_text);

        // Получение текста из ресурсов
        String text = getString(R.string.this_iscat);
        SpannableString spannableString = new SpannableString(text);

        // Обработка клика на "Это кот"
        ClickableSpan clickableSpanCat = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                // Переход к первому заданию (StopwatchActivity)
                Intent intent = new Intent(MainActivity.this, StopwatchActivity.class);
                startActivity(intent);
            }
        };

        // Обработка клика на "(или кошка)"
        ClickableSpan clickableSpanKitty = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        };

        // Устанавливаем клики для определённых частей текста
        if (text.length() >= 7) {
            spannableString.setSpan(clickableSpanCat, 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // "Это кот"
            spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }
        if (text.length() >= 19) {
            spannableString.setSpan(clickableSpanKitty, 8, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE); // "(или кошка)"
            spannableString.setSpan(new ForegroundColorSpan(Color.WHITE), 8, 19, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        // Применяем SpannableString к TextView
        catTextView.setText(spannableString);
        catTextView.setMovementMethod(LinkMovementMethod.getInstance());
        catTextView.setHighlightColor(Color.TRANSPARENT); // Убираем подсветку при нажатии

        // Привязка второго текстового поля с текстом "Или кошка"
        TextView catOrTextView = findViewById(R.id.cat_or);

        // Получаем текст из ресурсов
        String orText = getString(R.string.or_kitty);
        SpannableString spannableOrString = new SpannableString(orText);

        // Обработка клика на "Или кошка"
        ClickableSpan clickableSpanOr = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                // Переход к следующему заданию
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        };

        // Устанавливаем клики для текста
        spannableOrString.setSpan(clickableSpanOr, 0, orText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableOrString.setSpan(new ForegroundColorSpan(Color.WHITE), 0, orText.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Применяем SpannableString ко второму TextView
        catOrTextView.setText(spannableOrString);
        catOrTextView.setMovementMethod(LinkMovementMethod.getInstance());
        catOrTextView.setHighlightColor(Color.TRANSPARENT); // Убираем подсветку при нажатии
    }
}
