package id.codes.smartwarehousemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainMenuActivity extends AppCompatActivity {

    private ImageView btnMenuMonitor;
    private ImageView btnMenuStatus;
    private ImageView btnMenuGrafik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        initView();
        btnMenuGrafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this,MenuGrafikActivity.class));
            }
        });
        btnMenuMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this,MonitoringActivity.class));
            }
        });
        btnMenuStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainMenuActivity.this,StatusActivity.class));
            }
        });
    }

    private void initView() {
        btnMenuMonitor = (ImageView) findViewById(R.id.btn_menu_monitor);
        btnMenuStatus = (ImageView) findViewById(R.id.btn_menu_status);
        btnMenuGrafik = (ImageView) findViewById(R.id.btn_menu_grafik);
    }
}