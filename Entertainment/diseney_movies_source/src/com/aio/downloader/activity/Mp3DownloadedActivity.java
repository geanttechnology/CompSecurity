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
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.aio.downloader.adapter.Mp3DownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.DownloadpathCustomDialog;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.Player;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Mp3DownloadedActivity extends Activity
    implements android.view.View.OnClickListener
{
    class SeekBarChangeEvent
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        int progress;
        final Mp3DownloadedActivity this$0;

        public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
        {
            progress = (player.mediaPlayer.getDuration() * i) / seekbar.getMax();
        }

        public void onStartTrackingTouch(SeekBar seekbar)
        {
        }

        public void onStopTrackingTouch(SeekBar seekbar)
        {
            player.mediaPlayer.seekTo(progress);
        }

        SeekBarChangeEvent()
        {
            this$0 = Mp3DownloadedActivity.this;
            super();
        }
    }


    private Mp3DownloadedAdapter adapter;
    private ImageView champ3;
    TextView currenttime;
    private TypeDbUtils dbUtils;
    private ImageView filemoremp3;
    Handler handler;
    private Boolean istag;
    private RelativeLayout l1;
    private RelativeLayout l2;
    private RelativeLayout l3;
    private RelativeLayout l4;
    private List listdd;
    private BroadcastReceiver mBroadcastReceiver_delete;
    private PopupWindow mWindow;
    private ListView mp3_lv;
    private ImageView mp3fan;
    private TextView mp3notice;
    private BroadcastReceiver mp3play;
    private BroadcastReceiver mp3successful;
    private SeekBar musicProgress;
    private RelativeLayout playbarmp3;
    private Player player;
    private ImageView playpausemp3;
    BroadcastReceiver showBroadcast;
    private BroadcastReceiver stopmp3;
    private TimerTask task;
    private Timer timer;
    TextView title;
    TextView totaltime;

    public Mp3DownloadedActivity()
    {
        mBroadcastReceiver_delete = new BroadcastReceiver() {

            private int pos;
            final Mp3DownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                pos = intent.getIntExtra("position", 0);
                (new android.app.AlertDialog.Builder(Mp3DownloadedActivity.this)).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

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
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        };
        handler = new Handler() {

            final Mp3DownloadedActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                switch (message.what)
                {
                default:
                    return;

                case 100: // 'd'
                    break;
                }
                try
                {
                    currenttime.setText((new StringBuilder(String.valueOf(Player.formatTime(player.mediaPlayer.getCurrentPosition())))).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    return;
                }
            }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        };
        mp3successful = new BroadcastReceiver() {

            final Mp3DownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = listdd;
                Myutils.getInstance();
                context.add(Myutils.successItem);
                mp3_lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        };
        showBroadcast = new BroadcastReceiver() {

            final Mp3DownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    totaltime.setText((new StringBuilder(String.valueOf(Player.formatTime(player.mediaPlayer.getDuration())))).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
            }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        };
        mp3play = new BroadcastReceiver() {

            final Mp3DownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("mp3position");
                intent = intent.getStringExtra("mp3positiontitle");
                title.setText(intent);
                playbarmp3.setVisibility(0);
                (new Thread(context. new Runnable() {

                    final _cls5 this$1;
                    private final String val$mp3position;

                    public void run()
                    {
                        Looper.prepare();
                        player.playUrl(mp3position);
                        timer = new Timer();
                        task = new TimerTask() {

                            final _cls1 this$2;

                            public void run()
                            {
                                Message message = new Message();
                                message.what = 100;
                                handler.sendMessage(message);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        };
                        timer.schedule(task, 0L, 1000L);
                    }


            
            {
                this$1 = final__pcls5;
                mp3position = String.this;
                super();
            }
                })).start();
            }


            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        };
        stopmp3 = new BroadcastReceiver() {

            final Mp3DownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                champ3.performClick();
            }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        };
        adapter = null;
        dbUtils = null;
        istag = Boolean.valueOf(true);
    }

    private void buildLister()
    {
        mp3fan.setOnClickListener(this);
        filemoremp3.setOnClickListener(this);
        musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(this, musicProgress);
        playpausemp3.setOnClickListener(new android.view.View.OnClickListener() {

            final Mp3DownloadedActivity this$0;

            public void onClick(View view)
            {
                if (istag.booleanValue())
                {
                    player.pause();
                    playpausemp3.setBackgroundResource(0x7f02015a);
                    istag = Boolean.valueOf(false);
                    return;
                } else
                {
                    player.play();
                    playpausemp3.setBackgroundResource(0x7f02015e);
                    istag = Boolean.valueOf(true);
                    return;
                }
            }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        });
        champ3.setOnClickListener(new android.view.View.OnClickListener() {

            final Mp3DownloadedActivity this$0;

            public void onClick(View view)
            {
                if (player.mediaPlayer.isPlaying())
                {
                    player.pause();
                    playpausemp3.setBackgroundResource(0x7f02015e);
                    istag = Boolean.valueOf(true);
                    playbarmp3.setVisibility(8);
                    return;
                } else
                {
                    playpausemp3.setBackgroundResource(0x7f02015e);
                    istag = Boolean.valueOf(true);
                    playbarmp3.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
        });
    }

    private void init()
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("mp3", "timesort");
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        mp3fan = (ImageView)findViewById(0x7f0702f3);
        filemoremp3 = (ImageView)findViewById(0x7f0702f4);
        mp3_lv = (ListView)findViewById(0x7f0702f5);
        mp3notice = (TextView)findViewById(0x7f0702f6);
        adapter = new Mp3DownloadedAdapter(this, listdd);
        mp3_lv.setAdapter(adapter);
        playpausemp3 = (ImageView)findViewById(0x7f07018f);
        champ3 = (ImageView)findViewById(0x7f070190);
        playbarmp3 = (RelativeLayout)findViewById(0x7f07018e);
        totaltime = (TextView)findViewById(0x7f0700ec);
        currenttime = (TextView)findViewById(0x7f0700ea);
        title = (TextView)findViewById(0x7f0700e7);
        musicProgress = (SeekBar)findViewById(0x7f0700eb);
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

    public void Mp3Sort(String s)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("mp3", s);
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        mp3_lv = (ListView)findViewById(0x7f0702f5);
        adapter = new Mp3DownloadedAdapter(this, listdd);
        mp3_lv.setAdapter(adapter);
    }

    public void Mp3deletall()
    {
        dbUtils.deleteallfile("mp3");
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

        case 2131165939: 
            moveTaskToBack(true);
            return;

        case 2131165940: 
            popuWindow();
            mWindow.showAsDropDown(downloadpathCustomDialog);
            return;

        case 2131165585: 
            Mp3Sort("timesort");
            mWindow.dismiss();
            return;

        case 2131165586: 
            Mp3Sort("zimusort");
            mWindow.dismiss();
            return;

        case 2131165587: 
            (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage(getString(0x7f0b0042)).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                final Mp3DownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    Mp3deletall();
                }

            
            {
                this$0 = Mp3DownloadedActivity.this;
                super();
            }
            }).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                final Mp3DownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = Mp3DownloadedActivity.this;
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

                final Mp3DownloadedActivity this$0;
                private final DownloadpathCustomDialog val$downloadpathCustomDialog;

                public void onClick(View view)
                {
                    downloadpathCustomDialog.dismiss();
                }

            
            {
                this$0 = Mp3DownloadedActivity.this;
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
        setContentView(0x7f03007d);
        bundle = new IntentFilter();
        bundle.addAction("mp3delete");
        registerReceiver(mBroadcastReceiver_delete, bundle);
        bundle = new IntentFilter();
        bundle.addAction("mp3successful");
        registerReceiver(mp3successful, bundle);
        bundle = new IntentFilter();
        bundle.addAction("mp3play");
        registerReceiver(mp3play, bundle);
        bundle = new IntentFilter();
        bundle.addAction("show");
        registerReceiver(showBroadcast, bundle);
        bundle = new IntentFilter();
        bundle.addAction("ringtoneplay");
        registerReceiver(stopmp3, bundle);
        init();
        buildLister();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (timer != null)
        {
            timer.cancel();
            timer = null;
        }
        if (task != null)
        {
            task.cancel();
            task = null;
        }
        if (player.mediaPlayer.isPlaying())
        {
            player.pause();
            player.stop();
        }
        if (player != null)
        {
            player = null;
        }
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        if (listdd.size() > 0)
        {
            mp3notice.setVisibility(8);
        }
        adapter.notifyDataSetChanged();
        MobclickAgent.onResume(this);
    }














}
