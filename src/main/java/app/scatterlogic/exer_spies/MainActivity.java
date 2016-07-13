package app.scatterlogic.exer_spies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SimpleGPSLocation tempLoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView gpsFeedback = (TextView) findViewById(R.id.gpsView);
        tempLoc = new SimpleGPSLocation(this);

        gpsFeedback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final double latitude = tempLoc.latNow();
                final double longitude = tempLoc.longNow();
                TextView x = (TextView) v;
                x.setText(latitude + ", " + longitude);
                // TODO
            }

        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // make the device update its location
        tempLoc.beginUpdates();

        // ...
    }

    @Override
    protected void onPause() {
        // stop location updates (saves battery)
        tempLoc.endUpdates();

        // ...

        super.onPause();
    }
}
