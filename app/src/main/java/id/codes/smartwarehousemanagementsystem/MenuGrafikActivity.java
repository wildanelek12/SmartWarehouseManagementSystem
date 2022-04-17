package id.codes.smartwarehousemanagementsystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MenuGrafikActivity extends AppCompatActivity {

    private CardView cardGrafikSuhu;
    private CardView cardGrafikKelembapan;
    private CardView cardGrafikDebu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_grafik);
        initView();
        cardGrafikSuhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuGrafikActivity.this,GrafikActivity.class));
            }
        });
        cardGrafikKelembapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuGrafikActivity.this,GrafikKelembapan.class));
            }
        });
        cardGrafikDebu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuGrafikActivity.this,GrafikDebuActivity.class));
            }
        });
    }

    private void initView() {
        cardGrafikSuhu = (CardView) findViewById(R.id.card_grafik_suhu);
        cardGrafikKelembapan = (CardView) findViewById(R.id.card_grafik_kelembapan);
        cardGrafikDebu = (CardView) findViewById(R.id.card_grafik_debu);
    }
}