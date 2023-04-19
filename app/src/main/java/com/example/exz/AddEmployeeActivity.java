package com.example.exz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.exz.Employee;

public class AddEmployeeActivity extends AppCompatActivity {
    private EditText etFullName,etFirst,etMiddle, etBirthDate, etPosition, etDepartment, etSalary;
    private Button btnSave;

    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);
        databaseHelper = new DatabaseHelper(this);

        etFullName = findViewById(R.id.last_name);
        etFirst =findViewById(R.id.first_name);
        etMiddle = findViewById(R.id.middle_name);
        etBirthDate = findViewById(R.id.et_employee_birthdate);
        etPosition = findViewById(R.id.et_employee_position);
        etDepartment = findViewById(R.id.et_employee_department);
        etSalary = findViewById(R.id.et_employee_salary);

        btnSave = findViewById(R.id.btn_add_employee);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullName = etFullName.getText().toString();
                String firsname = etFirst.getText().toString();
                String middlename = etMiddle.getText().toString();

                if (databaseHelper.insertData(etFullName, etFirst, etMiddle)) {
                    Toast.makeText(AddEmployeeActivity.this, "Данные успешно сохранены!", Toast.LENGTH_SHORT).show();
                    Employee employee = new Employee(fullName, firsname, middlename);
                    Intent intent = new Intent(AddEmployeeActivity.this, MainActivity.class);
                    intent.putExtra("newEmployee", (Parcelable) employee);
                    startActivity(intent);
                    // Закрываем текущую активность
                    finish();
                } else {
                    Toast.makeText(AddEmployeeActivity.this, "Ошибка сохранения данных!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}