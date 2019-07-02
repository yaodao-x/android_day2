package chapter.android.aweme.ss.com.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NameDisplayView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_display_view);

        findViewById(R.id.dis_name).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        NameDisplayView.this,
                        getIntent().getStringExtra("function"),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
