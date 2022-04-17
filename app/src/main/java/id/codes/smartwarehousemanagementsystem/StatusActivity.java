package id.codes.smartwarehousemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class StatusActivity extends AppCompatActivity {

    private AppCompatButton btnSetPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        initView();
        btnSetPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StatusActivity.this,SetPointActivity.class));
            }
        });
    }

    private void initView() {
        btnSetPoint = (AppCompatButton) findViewById(R.id.btn_set_point);
    }
}