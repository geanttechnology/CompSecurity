// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aio.downloader.adapter.VideoDownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.DownloadpathCustomDialog;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoDownloadedActivity extends Activity
    implements android.view.View.OnClickListener
{

    private VideoDownloadedAdapter adapter;
    private TextView appnotice;
    private TypeDbUtils dbUtils;
    private ImageView filemorevideo;
    private RelativeLayout l1;
    private RelativeLayout l2;
    private RelativeLayout l3;
    private RelativeLayout l4;
    private List listdd;
    private BroadcastReceiver mBroadcastReceiver_delete;
    private PopupWindow mWindow;
    private ListView video_lv;
    private ImageView videofan;
    private BroadcastReceiver videosuccessful;

    public VideoDownloadedActivity()
    {
        mBroadcastReceiver_delete = new BroadcastReceiver() {

            private int pos;
            final VideoDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                pos = intent.getIntExtra("position", 0);
                (new android.app.AlertDialog.Builder(VideoDownloadedActivity.this)).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                    final _cls1 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dbUtils.deletefile(((DownloadMovieItem)listdd.get(pos)).getFile_id());
                        dialoginterface = new File(((DownloadMovieItem)listdd.get(pos)).getFilePath());
                        if (dialoginterface.exists())
                        {
                            dialoginterface.delete();
                        }
                        listdd.remove(pos);
                        adapter.notifyDataSetChanged();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                }).show();
            }



            
            {
                this$0 = VideoDownloadedActivity.this;
                super();
            }
        };
        videosuccessful = new BroadcastReceiver() {

            final VideoDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = listdd;
                Myutils.getInstance();
                context.add(Myutils.successItem);
                video_lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = VideoDownloadedActivity.this;
                super();
            }
        };
        adapter = null;
        dbUtils = null;
    }

    private void buildListener()
    {
        videofan.setOnClickListener(this);
        filemorevideo.setOnClickListener(this);
    }

    private void init()
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("video", "timesort");
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        videofan = (ImageView)findViewById(0x7f0703f3);
        filemorevideo = (ImageView)findViewById(0x7f0703f4);
        appnotice = (TextView)findViewById(0x7f0703f6);
        video_lv = (ListView)findViewById(0x7f0703f5);
        adapter = new VideoDownloadedAdapter(this, listdd);
        video_lv.setAdapter(adapter);
    }

    private void popuWindow()
    {
        Object obj = LayoutInflater.from(this).inflate(0x7f030041, null);
        l1 = (RelativeLayout)((View) (obj)).findViewById(0x7f070191);
        l2 = (RelativeLayout)((View) (obj)).findViewById(0x7f070192);
        l3 = (RelativeLayout)((View) (obj)).findViewById(0x7f070193);
        l4 = (RelativeLayout)((View) (obj)).findViewById(0x7f0701ac);
        l1.setOnClickListener(this);
        l2.setOnClickListener(this);
        l3.setOnClickListener(this);
        l4.setOnClickListener(this);
        mWindow = new PopupWindow(((View) (obj)));
        getWindowManager().getDefaultDisplay().getHeight();
        int i = getWindowManager().getDefaultDisplay().getWidth();
        mWindow.setWidth(i / 2 + 50);
        mWindow.setHeight(-2);
        mWindow.setFocusable(true);
        mWindow.setAnimationStyle(0x7f0c0011);
        obj = new ColorDrawable(0);
        mWindow.setBackgroundDrawable(((android.graphics.drawable.Drawable) (obj)));
    }

    public void VideoSort(String s)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("video", s);
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        video_lv = (ListView)findViewById(0x7f0703f5);
        adapter = new VideoDownloadedAdapter(this, listdd);
        video_lv.setAdapter(adapter);
    }

    public void Videodeletall()
    {
        dbUtils.deleteallfile("video");
        int i = 0;
        do
        {
            if (i >= listdd.size())
            {
                listdd.removeAll(listdd);
                adapter.notifyDataSetChanged();
                return;
            }
            File file = new File(((DownloadMovieItem)listdd.get(i)).getFilePath());
            if (file.exists())
            {
                file.delete();
            }
            i++;
        } while (true);
    }

    public void onClick(final View downloadpathCustomDialog)
    {
        switch (downloadpathCustomDialog.getId())
        {
        default:
            return;

        case 2131166195: 
            moveTaskToBack(true);
            return;

        case 2131166196: 
            popuWindow();
            mWindow.showAsDropDown(downloadpathCustomDialog);
            return;

        case 2131165585: 
            VideoSort("timesort");
            mWindow.dismiss();
            return;

        case 2131165586: 
            VideoSort("zimusort");
            mWindow.dismiss();
            return;

        case 2131165587: 
            (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage(getString(0x7f0b0044)).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                final VideoDownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    Videodeletall();
                }

            
            {
                this$0 = VideoDownloadedActivity.this;
                super();
            }
            }).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                final VideoDownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = VideoDownloadedActivity.this;
                super();
            }
            }).show();
            mWindow.dismiss();
            return;

        case 2131165612: 
            downloadpathCustomDialog = new DownloadpathCustomDialog(this, 0x7f0c000e);
            downloadpathCustomDialog.setCanceledOnTouchOutside(false);
            downloadpathCustomDialog.show();
            ((Button)downloadpathCustomDialog.findViewById(0x7f070194)).setOnClickListener(new android.view.View.OnClickListener() {

                final VideoDownloadedActivity this$0;
                private final DownloadpathCustomDialog val$downloadpathCustomDialog;

                public void onClick(View view)
                {
                    downloadpathCustomDialog.dismiss();
                }

            
            {
                this$0 = VideoDownloadedActivity.this;
                downloadpathCustomDialog = downloadpathcustomdialog;
                super();
            }
            });
            mWindow.dismiss();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300bc);
        bundle = new IntentFilter();
        bundle.addAction("videodelete");
        registerReceiver(mBroadcastReceiver_delete, bundle);
        bundle = new IntentFilter();
        bundle.addAction("videosuccessful");
        registerReceiver(videosuccessful, bundle);
        init();
        buildListener();
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        if (listdd.size() > 0)
        {
            appnotice.setVisibility(8);
        }
        adapter.notifyDataSetChanged();
        MobclickAgent.onResume(this);
    }




}
