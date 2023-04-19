package com.example.exz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<Employee> employeeList;
    private DatabaseHelper databaseHelper;
    private EmployeeListAdapter employeeListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.employee_list_view);
        databaseHelper = new DatabaseHelper(this);
        // Получение списка сотрудников из базы данных
        employeeList = databaseHelper.getAllEmployees();

        Employee newEmployee = (Employee) getIntent().getSerializableExtra("newEmployee");
        // Если данные о новом сотруднике были переданы, добавляем его в список
        if (newEmployee != null) {
            employeeList.add(newEmployee);
            employeeListAdapter.notifyDataSetChanged();
        }

        // Загружаем список всех сотрудников из базы данных и отображаем их в списке
        loadEmployees();
    }
    }
}