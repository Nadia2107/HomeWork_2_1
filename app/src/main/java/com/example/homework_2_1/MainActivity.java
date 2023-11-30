package com.example.homework_2_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // создадим поля
    private float camera = 3_200; // фотоаппарат
    private int cameraDiscount = 25; // скидка на фотоаппарат
    private float flashlight = 1_050; // фотовспышка
    private int flashlightDiscount = 15; // скидка на фотовспышку
    private float lens25 = 1_900; // объектив с фокусным расстоянием 25 мм
    private int lens25Discount = 41; // скидка на данный объектив
    private float lens50 = 2_500; // объектив с фокусным расстоянием 50 мм
    private int lens50Discount = 16; // скидка на данный объектив
    private float lens85 = 2_300; // объектив с фокусным расстоянием 85 мм
    private int lens85Discount = 19; // скидка на данный объектив
    private float uvFilter = 500; // UV фильтр
    private float account = 10_000; // баланс на счету

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView possibilityOut; // поле возможности покупки
    private TextView balanceOut; // поле возможного остатка от покупки

    // вывод на экран полученных значений
    @Override
    protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main

        // присваивание переменным активити элементов представления activity_main
        possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
        balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

        // запонение экрана
        if (possibility()) { // если имеется возможность купить фото-комплект
            possibilityOut.setText("Имеется достаточно средств для покупки фото-комплекта");
            balanceOut.setText("Остаток от покупки " + balance() + " монет");
        } else { // иначе
            possibilityOut.setText("Недостаточно средств для покупки фото-комплекта");
            balanceOut.setText(" - ");
        }
    }

    // метод подсчёта стоимости фото-комплекта
    private float calculation() {
        // создание и инициализация переменной подсчёта стоимости
        float count = (camera * (100 - cameraDiscount) + flashlight * (100 - flashlightDiscount)
                + lens25 * (100 - lens25Discount) + lens50 * (100 - lens50Discount)
                + lens85 * (100 - lens85Discount)) / 100 + uvFilter * 3;
        return count; // возврат подсчитанного значения
    }

    // метод определения возможностей бюджета покупки фото-комплекта
    private boolean possibility() {
        if (calculation() <= account) { // если стоимость комплекта меньше имеющихся средств
            return true; // то возврат истинного значения
        } else { // иначе
            return false; // возврат ложного значения
        }
    }

    // метод определения возможной сдачи
    private float balance() {
        if(possibility()) { // если имеется возможность купить фото-комплект
            return account - calculation(); // то возвращается остаток от покупки
        } else { // иначе
            return -1; // возвращается маркер недостатка денежных средств
        }
    }
}