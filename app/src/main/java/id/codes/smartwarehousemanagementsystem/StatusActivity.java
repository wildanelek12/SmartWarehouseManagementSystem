package id.codes.smartwarehousemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import id.codes.smartwarehousemanagementsystem.Model.DataStatus;

public class StatusActivity extends AppCompatActivity {

    private AppCompatButton btnSetPoint;
    private TextView tvStatusSuhu;
    private TextView tvStatusKelembapan;
    private TextView tvStatusDebu;
    private TextView tvStatusDayaPemanas;
    private TextView tvStatusDayaPendingin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        initView();
        btnSetPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StatusActivity.this, SetPointActivity.class));
            }
        });
        FirebaseDatabase.getInstance().getReference().child("status").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                DataStatus dataStatus = snapshot.getValue(DataStatus.class);
                tvStatusSuhu.setText("Suhu : "+dataStatus.getSuhu());
                tvStatusKelembapan.setText("Kelembapan : "+dataStatus.getKelembapan());
                tvStatusDebu.setText("Debu : "+dataStatus.getDebu());
                tvStatusDayaPemanas.setText("Daya Pemanas : "+dataStatus.getLevel_pemanas());
                tvStatusDayaPendingin.setText("Daya Pendingin : "+dataStatus.getLevel_pendingin());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    private void initView() {
        btnSetPoint = (AppCompatButton) findViewById(R.id.btn_set_point);
        tvStatusSuhu = (TextView) findViewById(R.id.tv_status_suhu);
        tvStatusKelembapan = (TextView) findViewById(R.id.tv_status_kelembapan);
        tvStatusDebu = (TextView) findViewById(R.id.tv_status_debu);
        tvStatusDayaPemanas = (TextView) findViewById(R.id.tv_status_daya_pemanas);
        tvStatusDayaPendingin = (TextView) findViewById(R.id.tv_status_daya_pendingin);
    }
}