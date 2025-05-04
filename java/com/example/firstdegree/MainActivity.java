package com.example.firstdegree;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến để quản lý các ô nhớ của các view:
    EditText edt_coefficientA;
    EditText edt_coefficientB;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        addContentView();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void addContentView() {
        edt_coefficientA = findViewById(R.id.edtCoefficientA);
        edt_coefficientB = findViewById(R.id.edtCoefficientB);
        txt = findViewById(R.id.txt);
    }

    public void do_solution(View view) {
        //Lấy hệ số a trên giao diện
        String hsa = edt_coefficientA.getText().toString();
        double a=Double.parseDouble(hsa);

        //Lấy hệ số b trên giao diện
        double b = Double.parseDouble(edt_coefficientB.getText().toString());

        if (a==0 & b==0) {
            ///txt.setText("Infinity!!!");
            txt.setText(getResources().getText(R.string.title_infinity));
        }
        else if(a==0 & b!=0)
        {
            ///txt.setText("No solution!!!");
            txt.setText(getResources().getText(R.string.title_no_solution));
        }
        else
        {
            double x = -b/a;
            txt.setText("x="+x);
        }
    }

    public void do_next(View view) {
        edt_coefficientA.setText("");
        edt_coefficientB.setText("");
        txt.setText("");
        //Di chuyển con trỏ nhập liệu HSA
        edt_coefficientA.requestFocus();
    }

    public void do_exit(View view) {
        finish();
    }
}