package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.widget.TextView;

public class IndexDisplayView extends AppCompatActivity {
    private static final String TAG = IndexDisplayView.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "IndexDisplayView created!");
        TextView textView = new TextView(this);
        Log.d(TAG, "get position " + getIntent().getStringExtra("idx"));
        textView.setText(String.format("%d", getIntent().getStringExtra("idx")));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(40);
        setContentView(textView);
    }
}
