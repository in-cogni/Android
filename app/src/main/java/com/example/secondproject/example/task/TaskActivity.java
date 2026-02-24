package com.example.secondproject.example.task;

import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import android.widget.*;
import com.example.secondproject.R;
import com.example.secondproject.example.task.models.TaskModels;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {
    List<TaskModels> taskModels = new ArrayList<>();
    Button btnAddTask;
    LinearLayout lytContainerTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }
    void init(){
        btnAddTask = findViewById(R.id.btnAddTask);
        lytContainerTasks = findViewById(R.id.lytContainerTask);
        btnAddTask.setOnClickListener(
                v->{
                    LocalDate now = null;
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                        now=LocalDate.now();
                    }
                    TaskModels task = new TaskModels(now.toString(), now, null);
                    taskModels.add(task);

                    LinearLayout containerTask = new LinearLayout(this);

                    TextView descriptionValue=new TextView(this);
                    descriptionValue.setText(task.description);
                    containerTask.addView(descriptionValue);

                    lytContainerTasks.addView(containerTask);
                }
        );
    }
}