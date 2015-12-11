// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
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
import com.aio.downloader.adapter.RingtoneDownloadedAdapter;
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

public class RingtoneDownloadedActivity extends Activity
    implements android.view.View.OnClickListener
{
    class SeekBarChangeEvent
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        int progress;
        final RingtoneDownloadedActivity this$0;

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
            this$0 = RingtoneDownloadedActivity.this;
            super();
        }
    }


    private RingtoneDownloadedAdapter adapter;
    private ImageView charingtone;
    TextView currenttime;
    private TypeDbUtils dbUtils;
    private ImageView filemoreringtone;
    Handler handler;
    boolean isAlarm;
    boolean isMusic;
    boolean isNotification;
    boolean isRingtone;
    private Boolean istag;
    private RelativeLayout l1;
    private RelativeLayout l2;
    private RelativeLayout l3;
    private RelativeLayout l4;
    private List listdd;
    private BroadcastReceiver mBroadcastReceiver_delete;
    private PopupWindow mWindow;
    private SeekBar musicProgress;
    private RelativeLayout playbarringtone;
    private Player player;
    private ImageView playpauseringtone;
    private ListView ringtone_lv;
    private ImageView ringtonefan;
    private TextView ringtonenotice;
    private BroadcastReceiver ringtoneplay;
    private BroadcastReceiver ringtonesuccessful;
    BroadcastReceiver showBroadcast;
    private BroadcastReceiver stopringtone;
    private TimerTask task;
    private Timer timer;
    TextView title;
    TextView totaltime;

    public RingtoneDownloadedActivity()
    {
        mBroadcastReceiver_delete = new BroadcastReceiver() {

            private int pos;
            final RingtoneDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                pos = intent.getIntExtra("position", 0);
                (new android.app.AlertDialog.Builder(RingtoneDownloadedActivity.this)).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

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
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        };
        handler = new Handler() {

            final RingtoneDownloadedActivity this$0;

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
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        };
        ringtonesuccessful = new BroadcastReceiver() {

            final RingtoneDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = listdd;
                Myutils.getInstance();
                context.add(Myutils.successItem);
                ringtone_lv.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        };
        showBroadcast = new BroadcastReceiver() {

            final RingtoneDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                totaltime.setText((new StringBuilder(String.valueOf(Player.formatTime(player.mediaPlayer.getDuration())))).toString());
            }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        };
        ringtoneplay = new BroadcastReceiver() {

            final RingtoneDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("ringtoneposition");
                intent = intent.getStringExtra("ringtonepositiontitle");
                title.setText(intent);
                playbarringtone.setVisibility(0);
                (new Thread(context. new Runnable() {

                    final _cls5 this$1;
                    private final String val$ringtoneposition;

                    public void run()
                    {
                        Looper.prepare();
                        player.playUrl(ringtoneposition);
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
                ringtoneposition = String.this;
                super();
            }
                })).start();
            }


            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        };
        stopringtone = new BroadcastReceiver() {

            final RingtoneDownloadedActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                charingtone.performClick();
            }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        };
        adapter = null;
        dbUtils = null;
        istag = Boolean.valueOf(true);
        isRingtone = false;
        isNotification = false;
        isAlarm = false;
        isMusic = false;
    }

    private void buildLister()
    {
        ringtonefan.setOnClickListener(this);
        filemoreringtone.setOnClickListener(this);
        musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(this, musicProgress);
        playpauseringtone.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedActivity this$0;

            public void onClick(View view)
            {
                if (istag.booleanValue())
                {
                    player.pause();
                    playpauseringtone.setBackgroundResource(0x7f02015a);
                    istag = Boolean.valueOf(false);
                    return;
                } else
                {
                    player.play();
                    playpauseringtone.setBackgroundResource(0x7f02015e);
                    istag = Boolean.valueOf(true);
                    return;
                }
            }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
        });
        charingtone.setOnClickListener(new android.view.View.OnClickListener() {

            final RingtoneDownloadedActivity this$0;

            public void onClick(View view)
            {
                if (player.mediaPlayer.isPlaying())
                {
                    player.pause();
                    playpauseringtone.setBackgroundResource(0x7f02015e);
                    istag = Boolean.valueOf(true);
                    playbarringtone.setVisibility(8);
                    return;
                } else
                {
                    playpauseringtone.setBackgroundResource(0x7f02015e);
                    istag = Boolean.valueOf(true);
                    playbarringtone.setVisibility(8);
                    return;
                }
            }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
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
        listdd = dbUtils.queryApk("ringtone", "timesort");
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        ringtonefan = (ImageView)findViewById(0x7f070397);
        filemoreringtone = (ImageView)findViewById(0x7f070398);
        ringtonenotice = (TextView)findViewById(0x7f07039a);
        ringtone_lv = (ListView)findViewById(0x7f070399);
        adapter = new RingtoneDownloadedAdapter(this, listdd);
        ringtone_lv.setAdapter(adapter);
        playpauseringtone = (ImageView)findViewById(0x7f07039c);
        charingtone = (ImageView)findViewById(0x7f07039d);
        playbarringtone = (RelativeLayout)findViewById(0x7f07039b);
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

    public void RingtoneSort(String s)
    {
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        listdd = dbUtils.queryApk("ringtone", s);
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        ringtone_lv = (ListView)findViewById(0x7f070399);
        adapter = new RingtoneDownloadedAdapter(this, listdd);
        ringtone_lv.setAdapter(adapter);
    }

    public void Ringtonedeletall()
    {
        dbUtils.deleteallfile("ringtone");
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

        case 2131166103: 
            moveTaskToBack(true);
            return;

        case 2131166104: 
            popuWindow();
            mWindow.showAsDropDown(downloadpathCustomDialog);
            return;

        case 2131165585: 
            RingtoneSort("timesort");
            mWindow.dismiss();
            return;

        case 2131165586: 
            RingtoneSort("zimusort");
            mWindow.dismiss();
            return;

        case 2131165587: 
            (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage(getString(0x7f0b0043)).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                final RingtoneDownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    Ringtonedeletall();
                }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
                super();
            }
            }).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                final RingtoneDownloadedActivity this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
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

                final RingtoneDownloadedActivity this$0;
                private final DownloadpathCustomDialog val$downloadpathCustomDialog;

                public void onClick(View view)
                {
                    downloadpathCustomDialog.dismiss();
                }

            
            {
                this$0 = RingtoneDownloadedActivity.this;
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
        setContentView(0x7f0300aa);
        bundle = new IntentFilter();
        bundle.addAction("ringtonedelete");
        registerReceiver(mBroadcastReceiver_delete, bundle);
        bundle = new IntentFilter();
        bundle.addAction("ringtonesuccessful");
        registerReceiver(ringtonesuccessful, bundle);
        bundle = new IntentFilter();
        bundle.addAction("ringtoneplay");
        registerReceiver(ringtoneplay, bundle);
        bundle = new IntentFilter();
        bundle.addAction("show");
        registerReceiver(showBroadcast, bundle);
        bundle = new IntentFilter();
        bundle.addAction("mp3play");
        registerReceiver(stopringtone, bundle);
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
            ringtonenotice.setVisibility(8);
        } else
        {
            ringtonenotice.setVisibility(0);
        }
        adapter.notifyDataSetChanged();
        MobclickAgent.onResume(this);
    }

    public void setRingtone(int i, String s)
    {
        i;
        JVM INSTR tableswitch 1 7: default 44
    //                   1 146
    //                   2 154
    //                   3 44
    //                   4 162
    //                   5 44
    //                   6 44
    //                   7 167;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L5
_L1:
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("_data", s);
        contentvalues.put("mime_type", "audio/*");
        contentvalues.put("is_ringtone", Boolean.valueOf(isRingtone));
        contentvalues.put("is_notification", Boolean.valueOf(isNotification));
        contentvalues.put("is_alarm", Boolean.valueOf(isAlarm));
        contentvalues.put("is_music", Boolean.valueOf(isMusic));
        s = android.provider.MediaStore.Audio.Media.getContentUriForPath(s);
        RingtoneManager.setActualDefaultRingtoneUri(this, 1, getContentResolver().insert(s, contentvalues));
        return;
_L2:
        isAlarm = true;
        continue; /* Loop/switch isn't completed */
_L3:
        isNotification = true;
        continue; /* Loop/switch isn't completed */
_L4:
        isRingtone = true;
_L5:
        isMusic = true;
        if (true) goto _L1; else goto _L6
_L6:
    }














}
