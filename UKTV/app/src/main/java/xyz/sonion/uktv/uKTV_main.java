package xyz.sonion.uktv;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class uKTV_main extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    // ID -> Music
    private Map<Integer, Music> musicRecord;

    public uKTV_main() {
        // TODO 优雅地放到资源xml里……当然这玩意还是存数据库、网络获取吧……
        //// https://developer.android.com/guide/topics/resources/string-resource.html?hl=zh-cn#Plurals

        musicRecord = new HashMap<>();
        musicRecord.put(0, new Music("陈奕迅 - 葡萄成熟时", "http://onaszq2yn.bkt.clouddn.com/audio/%E9%99%88%E5%A5%95%E8%BF%85%20-%20%E8%91%A1%E8%90%84%E6%88%90%E7%86%9F%E6%97%B6.mp3"));
        musicRecord.put(1, new Music("陈奕迅 - 倾城", "http://onaszq2yn.bkt.clouddn.com/audio/%E9%99%88%E5%A5%95%E8%BF%85%20-%20%E5%80%BE%E5%9F%8E.mp3"));
        musicRecord.put(2, new Music("肖邦 - 降E大调夜曲", "http://onaszq2yn.bkt.clouddn.com/audio/%E8%82%96%E9%82%A6%20-%20%E9%99%8DE%E5%A4%A7%E8%B0%83%E5%A4%9C%E6%9B%B2.mp3"));
        musicRecord.put(3, new Music("五月天 - 知足", "http://onaszq2yn.bkt.clouddn.com/audio/%E4%BA%94%E6%9C%88%E5%A4%A9%20-%20%E7%9F%A5%E8%B6%B3.mp3"));
        musicRecord.put(4, new Music("张国荣 - 我", "http://onaszq2yn.bkt.clouddn.com/audio/%E5%BC%A0%E5%9B%BD%E8%8D%A3%20-%20%E6%88%91.mp3"));
        musicRecord.put(5, new Music("ZZZ - 都是靡靡之音呐 呵呵 只要为你活一天", "http://onaszq2yn.bkt.clouddn.com/audio/ZZZ%20-%20%E9%83%BD%E6%98%AF%E9%9D%A1%E9%9D%A1%E4%B9%8B%E9%9F%B3%E5%91%90%20%E5%91%B5%E5%91%B5%20%E5%8F%AA%E8%A6%81%E4%B8%BA%E4%BD%A0%E6%B4%BB%E4%B8%80%E5%A4%A9.mp3"));
//        getResources().getStringArray(R.array.music_names_array); // 蛤！不能在这里获取。
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_ktv_main);

        Spinner spinner = (Spinner) findViewById(R.id.musicSelectionSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.music_names_array,
                android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // TODO 那么怎么从代码里绑定一个list上去呢……这更关键
        // https://developer.android.com/reference/android/widget/ArrayAdapter.html#ArrayAdapter(android.content.Context,%20int,%20java.util.List<T>)

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Music music = musicRecord.get(position);
        TextView textView = (TextView) findViewById(R.id.urlTextView);
        textView.setText(music.getDirectURL());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        System.out.println("LEE === onNothingSelected");
    }
}
