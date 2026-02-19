package com.example.secondproject.example;

import android.os.Bundle;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.secondproject.R;

public class ClickerActivity extends AppCompatActivity {

    Integer count=0;
    TextView labelCounter;
    Button incrementCounterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clicker);
        labelCounter = findViewById(R.id.label);
        incrementCounterButton = findViewById(R.id.button);
        init();
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void init(){
        updateUi();
        incrementCounterButton.setOnClickListener(
                e->{
                    count+=1;
                    updateUi();
                }
        );
    }
    void updateUi(){
        labelCounter.setText(count.toString());
    }
}