package id.codes.smartwarehousemanagementsystem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.codes.smartwarehousemanagementsystem.Model.DataMonitor;

public class MonitoringActivity extends AppCompatActivity {

    private TextView tvSuhu;
    private TextView tvKelembapan;
    private TextView tvDebu;
    private TextView tvDayaPemanas;
    private TextView tvDayaPendingin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitoring);
        initView();
        FirebaseDatabase.getInstance().getReference("monitor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataMonitor dataMonitor = snapshot.getValue(DataMonitor.class);
                tvSuhu.setText(String.valueOf(dataMonitor.getSuhu())+"°C");
                tvKelembapan.setText(String.valueOf(dataMonitor.getKelembapan())+" RH");
                tvDebu.setText(String.valueOf(dataMonitor.getDebu())+" mg/m3");
                tvDayaPemanas.setText(String.valueOf(dataMonitor.getDaya_pemanas())+"%");
                tvDayaPendingin.setText(String.valueOf(dataMonitor.getDaya_pendingin())+"%");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void initView() {
        tvSuhu = (TextView) findViewById(R.id.tv_suhu);
        tvKelembapan = (TextView) findViewById(R.id.tv_kelembapan);
        tvDebu = (TextView) findViewById(R.id.tv_debu);
        tvDayaPemanas = (TextView) findViewById(R.id.tv_daya_pemanas);
        tvDayaPendingin = (TextView) findViewById(R.id.tv_daya_pendingin);
    }
}