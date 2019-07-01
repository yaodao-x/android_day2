package chapter.android.aweme.ss.com.homework;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
@SuppressLint("SetTextI18n")
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LayoutInflater inflater = LayoutInflater.from(this);
        View sampleView = inflater.inflate(R.layout.activity_tips, null);

        TextView textView = new TextView(this);
        textView.setText("" + getViewCount(sampleView));
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(40);
        setContentView(textView);
    }

    public static int getViewCount(View view) {
        List<View> viewList = new ArrayList<>();
        viewList.add(view);
        for (int i = 0; i < viewList.size(); i++) {
            View tmpView = viewList.get(i);
            if (tmpView instanceof ViewGroup) {
                int childCount = ((ViewGroup) tmpView).getChildCount();
                for (int j = 0; j < childCount; j++) {
                    View childView = ((ViewGroup) tmpView).getChildAt(j);
                    if (childView != null) {
                        viewList.add(childView);
                    }
                }
            }
        }
        return viewList.size();
    }
}
