package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.model.PullParser;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {
    private static final String TAG = Exercises3.class.getSimpleName();
    private static final Map<Integer, Integer> imageNameMap
            = Collections.unmodifiableMap(new HashMap<Integer, Integer>() {{
                put(R.id.img_icon_fans, R.string.fans_icon_name);
                put(R.id.img_icon_thumb, R.string.thumb_icon_name);
                put(R.id.img_icon_myself, R.string.myself_icon_name);
                put(R.id.img_icon_review, R.string.review_icon_name);
        }});

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercises3);

        // 点击上方四个按钮显示 Toast
        for (final Map.Entry<Integer, Integer> entry : imageNameMap.entrySet()) {
            findViewById(entry.getKey()).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Exercises3.this, NameDisplayView.class);
                    intent.putExtra("function", getString(entry.getValue()));
                    startActivity(intent);
                }
            });
        }

        // 点击 LIstView 显示相应 Item 序号
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(new ListViewAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "ListView item clicked!");
                Intent intent = new Intent(Exercises3.this, IndexDisplayView.class);
                intent.putExtra("idx", "" + position);
                startActivity(intent);
            }
        });
    }

    private class ListViewAdapter extends BaseAdapter {
        private Context context;
        private List<Message> messages;

        public ListViewAdapter(Context context) {
            this.context = context;
            try {
                this.messages = PullParser.getMessage(Exercises3.this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public Object getItem(int position) {
            return messages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(R.layout.im_list_item, null);
            } else {
                view = convertView;
            }
            Message message = messages.get(position);
            ((TextView) view.findViewById(R.id.tv_title)).setText(message.getTitle());
            ((TextView) view.findViewById(R.id.tv_description)).setText(message.getDescription());
            ((TextView) view.findViewById(R.id.tv_time)).setText(message.getTime());
            return view;
        }
    }
}
