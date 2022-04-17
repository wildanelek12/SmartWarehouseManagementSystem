package id.codes.smartwarehousemanagementsystem;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.core.cartesian.series.Line;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.MarkerType;
import com.anychart.enums.TooltipPositionMode;
import com.anychart.graphics.vector.Stroke;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import id.codes.smartwarehousemanagementsystem.Model.DataDebu;
import id.codes.smartwarehousemanagementsystem.Model.DataSuhu;

public class GrafikDebuActivity extends AppCompatActivity {

    private AnyChartView anyChartView;
    List<DataEntry> seriesData = new ArrayList<>();
    Set set;
    Mapping series1Mapping;
    Line series1;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik_debu);
        initView();
        Cartesian cartesian = AnyChart.line();

        cartesian.animation(true);

        cartesian.padding(10d, 20d, 5d, 20d);

        cartesian.crosshair().enabled(true);
        cartesian.crosshair()
                .yLabel(true)
                // TODO ystroke
                .yStroke((Stroke) null, null, null, (String) null, (String) null);

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT);

        cartesian.title(getIntent().getStringExtra("nama"));

        FirebaseDatabase.getInstance().getReference("chart").child("chart_debu").limitToLast(5).orderByChild("waktu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                seriesData.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        DataDebu dataDebu = snapshot.getValue(DataDebu.class);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        SimpleDateFormat output = new SimpleDateFormat("HH:mm");
                        Date d = null;
                        try {
                            d = sdf.parse(dataDebu.getWaktu());
                            String formattedTime = output.format(d);
                            seriesData.add(new CustomDataEntry(formattedTime, dataDebu.getDebu()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                    set = Set.instantiate();
                    series1Mapping = set.mapAs("{ x: 'x', value: 'value' }");
                    series1 = cartesian.line(series1Mapping);
                    series1.name("Debu");
                    series1.hovered().markers().enabled(true);
                    series1.hovered().markers()
                            .type(MarkerType.CIRCLE)
                            .size(4d);
                    series1.tooltip()
                            .position("right")
                            .anchor(Anchor.LEFT_CENTER)
                            .offsetX(5d)
                            .offsetY(5d);
                    set.data(seriesData);



                }
            }

            @Override
            public void onCancelled(DatabaseError error) {

            }
        });

        anyChartView.setChart(cartesian);

    }

    private class CustomDataEntry extends ValueDataEntry {

        CustomDataEntry(String x, Number value) {
            super(x, value);
        }

    }


    private void initView() {
        anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
    }
}