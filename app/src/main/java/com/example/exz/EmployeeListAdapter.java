package com.example.exz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<Employee> mEmployeeList;

    public EmployeeListAdapter(Context context, ArrayList<Employee> employeeList) {
        mContext = context;
        mEmployeeList = employeeList;
    }

    @Override
    public int getCount() {
        return mEmployeeList.size();
    }

    @Override
    public Object getItem(int position) {
        return mEmployeeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_employee, null);
        }

        TextView fullNameTextView = convertView.findViewById(R.id.employee_full_name_text_view);
        TextView departmentTextView = convertView.findViewById(R.id.employee_department_text_view);
        TextView positionTextView = convertView.findViewById(R.id.employee_position_text_view);

        Employee employee = mEmployeeList.get(position);
        fullNameTextView.setText(employee.getFirstName());
        departmentTextView.setText(employee.getDepartment());
        positionTextView.setText(employee.getPosition());

        return convertView;
    }
}