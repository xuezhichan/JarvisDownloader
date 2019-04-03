package com.ares.downloaderdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.ares.downloader.jarvis.Jarvis;
import com.ares.downloader.jarvis.core.DataCallBack;
import com.ares.downloader.jarvis.core.LocalFileRecordBean;

import java.util.List;

/**
 * Created on 2018/4/26 11:31.
 *
 * @author ares
 */

public class DownloadActivity extends AppCompatActivity {


    String url = "https://s.samewwj.com/sameV5.0.9.apk";
    String url1 = "https://s.samewwj.com/sameV5.1.1.apk";
    String url2 = "https://s.samewwj.com/sameV5.1.2.apk";
    String url3 = "https://gdown.baidu.com/data/wisegame/d2fbbc8e64990454/wangyiyunyinle_87.apk";



    private RecyclerView rv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloader);

//        rv = findViewById(R.id.rv);
//
//        rv.setLayoutManager(new LinearLayoutManager(this));
//        List<FileBean> list = new ArrayList<>();
//        MultiDownloadAdapter downloadAdapter = new MultiDownloadAdapter(list);
//        list.add(new FileBean(url1));
//        list.add(new FileBean(url2));
//        list.add(new FileBean(url3));
//        list.add(new FileBean(url4));
//        list.add(new FileBean(url5));
//        list.add(new FileBean(url6));
//        list.add(new FileBean(url7));
//        list.add(new FileBean(url8));
//        list.add(new FileBean(url9));
//        list.add(new FileBean(url10));
//        list.add(new FileBean(url11));
//        list.add(new FileBean(url12));
//        rv.setAdapter(downloadAdapter);


        new DownloadLayouter().add(findViewById(R.id.layout1), url2)

                .add(findViewById(R.id.layout2),  url1)
                .add(findViewById(R.id.layout3), url).add(findViewById(R.id.layout4), url3);
        ;

        Jarvis.getInstance().getDownloadedList(new DataCallBack<List<LocalFileRecordBean>>() {
            @Override
            public void onData(List<LocalFileRecordBean> data) {

                System.out.println(data.size()+"个记录");
            }
        });

    }



    public void startAll(View v) {


        Jarvis.getInstance().startAllDownload();

    }


    public void pauseAll(View v) {


        Jarvis.getInstance().pauseAllDownloader();

    }


    public void deleteAll(View v) {


        Jarvis.getInstance().forceDeleteAll();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, DownloadActivity.class);
        context.startActivity(starter);
    }



}
