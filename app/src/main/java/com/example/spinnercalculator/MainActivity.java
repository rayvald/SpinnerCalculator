package com.example.spinnercalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1,et2;
    private Spinner sp_options;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_value1);
        et2 = (EditText)findViewById(R.id.txt_value2);

        tv1 = (TextView)findViewById(R.id.tv_result);
        sp_options = (Spinner)findViewById(R.id.spinner);

        String [] options = {"Add", "Subtract", "Multiply", "Divide"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_config, options);
        sp_options.setAdapter(adapter);
    }

    public void calculate(View view){

        String value1_string = et1.getText().toString();
        String value2_string = et2.getText().toString();

        int value1 = Integer.parseInt(value1_string);
        int value2 = Integer.parseInt(value2_string);

        String selection =  sp_options.getSelectedItem().toString();

        if (selection.equals("Add")) {
            int add = value1 + value2;
            String result = String.valueOf(add);
            tv1.setText(result);
        } else if (selection.equals("Subtract")){
            int sub = value1 - value2;
            String result = String.valueOf(sub);
            tv1.setText(result);
        } else if (selection.equals("Multiply")){
            int mul = value1 * value2;
            String result = String.valueOf(mul);
            tv1.setText(result);
        } else if (selection.equals("Divide")){
            if (value2 != 0){
                int div = value1 / value2;
                String result = String.valueOf(div);
                tv1.setText(result);
            } else {
                Toast.makeText(this, "You can't divide a number by 0", Toast.LENGTH_LONG).show();
            }

        }

    }
}