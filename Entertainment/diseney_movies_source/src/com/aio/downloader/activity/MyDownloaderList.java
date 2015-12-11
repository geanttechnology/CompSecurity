// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.SeekBar;
import android.widget.TextView;
import cn.jpush.android.api.JPushInterface;
import com.aio.downloader.adapter.AppDownloadedAdapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.DownloadFile;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.DownloadTask;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.Player;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.LImageButton;
import com.aio.downloader.views.MyListView;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            MyMainActivity, AppDetailsActivity, DownloadAppManager

public class MyDownloaderList extends BaseActivity
    implements AdListener, android.view.View.OnClickListener
{
    class DeleteTask
        implements com.aio.downloader.mydownload.DownloadTask.OnDeleteTaskListener
    {

        private LinearLayout lin;
        final MyDownloaderList this$0;

        public void onDelete(View view, DownloadMovieItem downloadmovieitem, Boolean boolean1)
        {
            if (boolean1.booleanValue())
            {
                lin.removeView(view);
                view = downloadmovieitem.getDownloadFile();
                if (view != null)
                {
                    view.stopDownload();
                }
                view = new File(downloadmovieitem.getFilePath());
                if (view.exists())
                {
                    view.delete();
                }
                (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
                    downloadmovieitem.getFile_id()
                });
            } else
            {
                lin.removeView(view);
                view = downloadmovieitem.getDownloadFile();
                if (view != null)
                {
                    view.stopDownload();
                }
                view = new File(downloadmovieitem.getFilePath());
                if (view.exists())
                {
                    view.delete();
                }
                (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "movieName=?", new String[] {
                    downloadmovieitem.getMovieName()
                });
                view = new Notification();
                view.flags = 16;
                view.icon = 0x7f0200eb;
                downloadmovieitem = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                downloadmovieitem.setFlags(0x10000000);
                view.contentIntent = PendingIntent.getActivity(getApplicationContext(), 110, downloadmovieitem, 0x8000000);
                downloadmovieitem = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030090);
                ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                downloadmovieitem.setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                view.contentView = downloadmovieitem;
                if (ds.size() > 0)
                {
                    MyDownloaderList.mNotificationManager.notify(110, view);
                }
                if (ds.size() == 0)
                {
                    MyDownloaderList.mNotificationManager.cancel(110);
                    return;
                }
            }
        }

        public DeleteTask(LinearLayout linearlayout)
        {
            this$0 = MyDownloaderList.this;
            super();
            lin = linearlayout;
        }
    }

    class SeekBarChangeEvent
        implements android.widget.SeekBar.OnSeekBarChangeListener
    {

        int progress;
        final MyDownloaderList this$0;

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
            this$0 = MyDownloaderList.this;
            super();
        }
    }


    public static List downloadinglist = new ArrayList();
    public static NotificationManager mNotificationManager;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private final String DOWNLOADSUCCESS = "downloadsuccess";
    private String acquire_url_start;
    private AppDownloadedAdapter adapter;
    private int aio;
    private AnimationDrawable animationDrawable;
    private MyApplcation app;
    private Button app_download_bt;
    private RatingBar app_ratingbar;
    private TextView appauthortitle;
    private ImageView appicon;
    private TextView appprice;
    private BroadcastReceiver appsuccessful;
    private TextView apptitle;
    private Button bt_complement;
    private ImageView champ3;
    TextView currenttime;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private DisplayMetrics displayMetrics;
    private TextView downloadingnotice1;
    private List ds;
    private boolean fb;
    private ArrayList gvlist;
    Handler handler;
    private String imgurl;
    private RelativeLayout inmobtop;
    private Boolean istag;
    private ImageView iv_ioio;
    private List listdd;
    private LinearLayout listview_lin;
    private LinearLayout ll_download_complement;
    private LinearLayout ll_downnull;
    private BroadcastReceiver mBroadcastReceiver;
    private BroadcastReceiver mBroadcastReceiver_delete;
    private MyListView mlistview;
    private BroadcastReceiver mp3play;
    private SeekBar musicProgress;
    private NativeAd nativeAd;
    private NativeAd nativeAdgift;
    private TextView official;
    private RelativeLayout playbarmp3;
    private Player player;
    private ImageView playpausemp3;
    private ProgressWheel progress_wheel;
    private RelativeLayout rl_downloading;
    private int screenWidth;
    private BroadcastReceiver successful;
    private TimerTask task;
    private Timer timer;
    TextView title;
    TextView totaltime;
    private TextView tv_delete_all_down;
    private TextView tv_downloaded;
    private TextView tv_downloading;
    private Typeface typeFace;
    private TextView xian;

    public MyDownloaderList()
    {
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        handler = new Handler() {

            final MyDownloaderList this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR tableswitch 100 101: default 32
            //                           100 33
            //                           101 144;
                   goto _L1 _L2 _L3
_L1:
                return;
_L2:
                ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                if (ds.size() == 0) goto _L5; else goto _L4
_L4:
                ll_downnull.setVisibility(8);
                tv_downloading.setVisibility(0);
_L8:
                if (listdd.size() <= 0) goto _L7; else goto _L6
_L6:
                ll_downnull.setVisibility(8);
                tv_downloaded.setVisibility(0);
                rl_downloading.setVisibility(0);
_L3:
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
_L5:
                ll_downnull.setVisibility(0);
                tv_downloading.setVisibility(8);
                  goto _L8
_L7:
                try
                {
                    tv_downloaded.setVisibility(8);
                    rl_downloading.setVisibility(8);
                }
                // Misplaced declaration of an exception variable
                catch (Message message) { }
                  goto _L3
            }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        };
        mp3play = new BroadcastReceiver() {

            final MyDownloaderList this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = intent.getStringExtra("mp3position");
                intent = intent.getStringExtra("mp3positiontitle");
                title.setText(intent);
                playbarmp3.setVisibility(0);
                (new Thread(context. new Runnable() {

                    final _cls2 this$1;
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
                                message.what = 101;
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
                this$1 = final__pcls2;
                mp3position = String.this;
                super();
            }
                })).start();
            }


            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        };
        mBroadcastReceiver = new BroadcastReceiver() {

            final MyDownloaderList this$0;

            public void onReceive(Context context, Intent intent)
            {
                View view;
                ImageView imageview;
                String s;
                int i;
                intent = getMyApp().getStartDownloadMovieItem();
                view = getLayoutInflater().inflate(0x7f030068, null);
                imageview = (ImageView)view.findViewById(0x7f070277);
                s = intent.getMovieHeadImagePath();
                i = intent.getSerial();
                Log.e("qwa", (new StringBuilder("serial=")).append(i).toString());
                if (i != 110) goto _L2; else goto _L1
_L1:
                context = new MyAppInfo(context);
                try
                {
                    imageview.setBackgroundDrawable(context.getAppIcon(intent.getFile_id()));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    context.printStackTrace();
                }
_L4:
                intent.setDownloadState(Integer.valueOf(7));
                listview_lin.addView(view);
                (new DownloadTask(getmContext(), view, intent, false)).setOnDeleteTaskListener(new DeleteTask(listview_lin));
                if (intent.getType().equals("app"))
                {
                    context = new Notification();
                    context.flags = 16;
                    context.icon = 0x7f0200ec;
                    intent = new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager);
                    intent.setFlags(0x10000000);
                    context.contentIntent = PendingIntent.getActivity(getApplicationContext(), 110, intent, 0x8000000);
                    intent = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030090);
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                    intent.setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                    intent.setTextViewText(0x7f07031b, DateFormat.format("kk:mm", System.currentTimeMillis()));
                    context.contentView = intent;
                    if (ds.size() > 0)
                    {
                        MyDownloaderList.mNotificationManager.notify(110, context);
                    }
                }
                return;
_L2:
                if (i != 110)
                {
                    app.asyncLoadImage(s, imageview);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        };
        successful = new BroadcastReceiver() {

            private DownloadMovieItem down;
            final MyDownloaderList this$0;

            public void onReceive(Context context, Intent intent)
            {
                if (dbUtils == null)
                {
                    dbUtils = new TypeDbUtils(context);
                }
                down = getMyApp().getDownloadSuccess();
                (new Thread(new Runnable() {

                    final _cls4 this$1;

                    public void run()
                    {
                        Looper.prepare();
                        dbUtils.insertApk(down.getFile_id(), down.getType(), down.getMovieName(), down.getMovieHeadImagePath(), down.getFileSize(), down.getFilePath(), down.getSerial(), down.getCreate_time(), down.getVersion());
                        (new FinalDBChen(getmContext(), "download2.db")).deleteItem("downloadtask2", "file_id=?", new String[] {
                            down.getFile_id()
                        });
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                })).start();
                Log.e("qwa", (new StringBuilder("down.getSerial()=")).append(down.getSerial()).toString());
                intent = new Intent("downloadsuccess");
                intent.putExtra("headimage", down.getMovieHeadImagePath());
                intent.putExtra("appname", down.getMovieName());
                intent.putExtra("baoming", down.getFile_id());
                intent.putExtra("serial", down.getSerial());
                intent.putExtra("filepathdown", down.getFilePath());
                if (down.getSerial() == 110)
                {
                    intent.putExtra("iddown", down.getId());
                }
                if (!down.getType().equals("mp3") && !down.getType().equals("video") && getSharedPreferences("downloadcomplete", 0).getInt("wycdc", 0) == 0)
                {
                    context.sendBroadcast(intent);
                }
                MobclickAgent.onEvent(context, "downloadsuccess");
                MyDownloaderList.mNotificationManager.cancel(110);
            }



            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        };
        mBroadcastReceiver_delete = new BroadcastReceiver() {

            private int pos;
            final MyDownloaderList this$0;

            public void onReceive(Context context, Intent intent)
            {
                pos = intent.getIntExtra("position", 0);
                (new android.app.AlertDialog.Builder(MyDownloaderList.this)).setTitle(getString(0x7f0b0034)).setMessage((new StringBuilder(String.valueOf(getString(0x7f0b003c)))).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).append("?").toString()).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dialoginterface.dismiss();
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                }).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                    final _cls5 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        dbUtils.deletefile(((DownloadMovieItem)listdd.get(pos)).getFile_id());
                        dialoginterface = new File(((DownloadMovieItem)listdd.get(pos)).getFilePath());
                        Log.e("www", (new StringBuilder("listdd.get(pos).getFilePath()=")).append(((DownloadMovieItem)listdd.get(pos)).getFilePath()).toString());
                        if (dialoginterface.exists())
                        {
                            dialoginterface.delete();
                        }
                        listdd.remove(pos);
                        adapter.notifyDataSetChanged();
                        MyDownloaderList.mNotificationManager = (NotificationManager)getSystemService("notification");
                        dialoginterface = new Notification();
                        dialoginterface.flags = 16;
                        dialoginterface.icon = 0x7f0200eb;
                        Object obj = new Intent(_fld0, com/aio/downloader/activity/DownloadAppManager);
                        ((Intent) (obj)).setFlags(0x10000000);
                        dialoginterface.contentIntent = PendingIntent.getActivity(_fld0, 110, ((Intent) (obj)), 0x8000000);
                        obj = new RemoteViews(getPackageName(), 0x7f030090);
                        ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                        ((RemoteViews) (obj)).setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(ds.size()).append(") & Completed").append("(").append(listdd.size()).append(")").toString());
                        ((RemoteViews) (obj)).setTextViewText(0x7f07031b, DateFormat.format("kk:mm", System.currentTimeMillis()));
                        dialoginterface.contentView = ((RemoteViews) (obj));
                        if (ds.size() > 0)
                        {
                            MyDownloaderList.mNotificationManager.notify(110, dialoginterface);
                        }
                        try
                        {
                            if (ds.size() == 0)
                            {
                                MyDownloaderList.mNotificationManager.cancel(110);
                            }
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (DialogInterface dialoginterface)
                        {
                            return;
                        }
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                }).show();
            }



            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        };
        dbUtils = null;
        fb = false;
        typeFace = null;
        adapter = null;
        istag = Boolean.valueOf(true);
        acquire_url_start = "";
        appsuccessful = new BroadcastReceiver() {

            final MyDownloaderList this$0;

            public void onReceive(Context context, Intent intent)
            {
                context = listdd;
                Myutils.getInstance();
                context.add(Myutils.successItem);
                mlistview.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        };
    }

    public static Drawable bitmapToDrawble(Bitmap bitmap, Context context)
    {
        return new BitmapDrawable(context.getResources(), bitmap);
    }

    private void buildLister()
    {
        tv_delete_all_down.setOnClickListener(this);
        musicProgress.setOnSeekBarChangeListener(new SeekBarChangeEvent());
        player = new Player(this, musicProgress);
        playpausemp3.setOnClickListener(new android.view.View.OnClickListener() {

            final MyDownloaderList this$0;

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
                this$0 = MyDownloaderList.this;
                super();
            }
        });
        champ3.setOnClickListener(new android.view.View.OnClickListener() {

            final MyDownloaderList this$0;

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
                this$0 = MyDownloaderList.this;
                super();
            }
        });
    }

    private void download_file()
    {
        if (ds.size() == 0) goto _L2; else goto _L1
_L1:
        Iterator iterator = ds.iterator();
_L11:
        if (iterator.hasNext()) goto _L3; else goto _L2
_L2:
        return;
_L3:
        double d;
        double d1;
        Object obj;
        String s;
        String s1;
        DownloadMovieItem downloadmovieitem;
        View view;
        ProgressBar progressbar;
        TextView textview;
        TextView textview1;
        downloadmovieitem = (DownloadMovieItem)iterator.next();
        view = getLayoutInflater().inflate(0x7f030068, null);
        listview_lin.addView(view);
        progressbar = (ProgressBar)view.findViewById(0x7f07027a);
        displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        if (screenWidth < 500)
        {
            android.view.ViewGroup.LayoutParams layoutparams = progressbar.getLayoutParams();
            layoutparams.width = 186;
            progressbar.setLayoutParams(layoutparams);
        }
        obj = (TextView)view.findViewById(0x7f070278);
        ((TextView) (obj)).setText(downloadmovieitem.getMovieName());
        ((TextView) (obj)).setTypeface(typeFace);
        s1 = downloadmovieitem.getFileSize();
        textview1 = (TextView)view.findViewById(0x7f07027c);
        textview = (TextView)view.findViewById(0x7f070279);
        obj = (ImageView)view.findViewById(0x7f070277);
        imgurl = downloadmovieitem.getMovieHeadImagePath();
        app.asyncLoadImage(imgurl, ((ImageView) (obj)));
        d1 = 0.0D;
        d = d1;
        s = s1;
        obj = s1;
        if (s1.equals("")) goto _L5; else goto _L4
_L4:
        d = d1;
        s = s1;
        if (s1 == null) goto _L5; else goto _L6
_L6:
        obj = s1;
        if (!s1.contains("MB")) goto _L8; else goto _L7
_L7:
        obj = s1;
        s = s1.replace("MB", "").trim();
        obj = s;
        d = Double.parseDouble(s) * 1024D;
_L5:
        if (d >= 200D) goto _L10; else goto _L9
_L9:
        obj = s;
        textview1.setText("Invalid");
        obj = s;
        textview1.setTextColor(Color.parseColor("#f39801"));
        obj = s;
_L12:
        int i;
        long l = downloadmovieitem.getCurrentProgress().longValue();
        s1 = Formatter.formatFileSize(getmContext(), l);
        s = ((String) (obj));
        if (((String) (obj)).contains("null"))
        {
            s = "0.00B";
        }
        textview.setText((new StringBuilder(String.valueOf(s1))).append("/").append(s).toString());
        obj = (TextView)view.findViewById(0x7f070276);
        progressbar.setMax((int)downloadmovieitem.getProgressCount().longValue());
        progressbar.setProgress((int)l);
        if (((TextView) (obj)).getVisibility() == 4)
        {
            ((TextView) (obj)).setVisibility(0);
        }
        obj = Boolean.valueOf(false);
        i = 0;
_L13:
        Myutils.getInstance();
        if (i < Myutils.list.size())
        {
            break MISSING_BLOCK_LABEL_603;
        }
        if (!((Boolean) (obj)).booleanValue())
        {
            (new DownloadTask(getmContext(), view, downloadmovieitem, true)).setOnDeleteTaskListener(new DeleteTask(listview_lin));
        }
          goto _L11
_L8:
        obj = s1;
        s = s1.replace("KB", "").trim();
        obj = s;
        d = Double.parseDouble(s);
          goto _L5
_L10:
        obj = s;
        textview1.setText(downloadmovieitem.getPercentage());
        obj = s;
          goto _L12
        Exception exception;
        exception;
          goto _L12
        Myutils.getInstance();
        if (((DownloadMovieItem)Myutils.list.get(i)).getDownloadUrl().equals(downloadmovieitem.getDownloadUrl()))
        {
            (new DownloadTask(getmContext(), view, downloadmovieitem, false)).setOnDeleteTaskListener(new DeleteTask(listview_lin));
            obj = Boolean.valueOf(true);
        }
        i++;
          goto _L13
    }

    private void facebookad()
    {
        apptitle.setText(nativeAd.getAdTitle());
        appauthortitle.setText("Download Complete");
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), appicon);
        com.facebook.ads.NativeAd.Rating rating = nativeAd.getAdStarRating();
        if (rating != null)
        {
            app_ratingbar.setVisibility(8);
            app_ratingbar.setNumStars((int)rating.getScale());
            app_ratingbar.setRating((float)rating.getValue());
        } else
        {
            app_ratingbar.setVisibility(8);
        }
        nativeAd.registerViewForInteraction(inmobtop);
    }

    private void init()
    {
        rl_downloading = (RelativeLayout)findViewById(0x7f070187);
        tv_delete_all_down = (TextView)findViewById(0x7f070189);
        downloadingnotice1 = (TextView)findViewById(0x7f07018c);
        progress_wheel = (ProgressWheel)findViewById(0x7f070072);
        listview_lin = (LinearLayout)findViewById(0x7f070172);
        mlistview = (MyListView)findViewById(0x7f07018a);
        tv_downloading = (TextView)findViewById(0x7f070186);
        tv_downloaded = (TextView)findViewById(0x7f070188);
        Object obj = (LImageButton)findViewById(0x7f070181);
        iv_ioio = (ImageView)findViewById(0x7f07018d);
        ll_downnull = (LinearLayout)findViewById(0x7f07018b);
        ll_download_complement = (LinearLayout)findViewById(0x7f070184);
        bt_complement = (Button)findViewById(0x7f070185);
        ll_download_complement.setOnClickListener(this);
        bt_complement.setOnClickListener(this);
        ((LImageButton) (obj)).setOnClickListener(this);
        obj = getApplicationContext();
        getApplicationContext();
        mNotificationManager = (NotificationManager)((Context) (obj)).getSystemService("notification");
        try
        {
            app = (MyApplcation)getApplicationContext().getApplicationContext();
        }
        catch (Exception exception) { }
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("download_aio");
        getApplicationContext().registerReceiver(mBroadcastReceiver, ((IntentFilter) (obj)));
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("successful");
        getApplicationContext().registerReceiver(successful, ((IntentFilter) (obj)));
        db = new FinalDBChen(getmContext(), getApplicationContext().getDatabasePath("download2.db").getAbsolutePath());
        ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(getApplicationContext());
        }
        listdd = dbUtils.myqueryfile();
        if (listdd == null)
        {
            listdd = new ArrayList();
        }
        adapter = new AppDownloadedAdapter(this, listdd);
        mlistview.setAdapter(adapter);
        playpausemp3 = (ImageView)findViewById(0x7f07018f);
        champ3 = (ImageView)findViewById(0x7f070190);
        playbarmp3 = (RelativeLayout)findViewById(0x7f07018e);
        totaltime = (TextView)findViewById(0x7f0700ec);
        currenttime = (TextView)findViewById(0x7f0700ea);
        title = (TextView)findViewById(0x7f0700e7);
        musicProgress = (SeekBar)findViewById(0x7f0700eb);
    }

    public void Appdeletall()
    {
        dbUtils.deleteall();
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

    public long getFileSizes(File file)
        throws Exception
    {
        if (file.exists())
        {
            return (long)(new FileInputStream(file)).available();
        } else
        {
            file.createNewFile();
            return 0L;
        }
    }

    public void initView()
    {
        super.initView();
    }

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd != ad) goto _L2; else goto _L1
_L1:
        if (nativeAd != null && nativeAd == ad) goto _L4; else goto _L3
_L3:
        return;
_L4:
        nativeAd.unregisterView();
        fb = true;
        try
        {
            facebookad();
            inmobtop.setVisibility(0);
            ll_download_complement.setVisibility(8);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Ad ad)
        {
            return;
        }
_L2:
        if (nativeAdgift == ad && nativeAdgift != null && nativeAdgift == ad)
        {
            nativeAdgift.unregisterView();
            nativeAdgift.registerViewForInteraction(ll_downnull);
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131165570: 
        case 2131165571: 
        case 2131165574: 
        case 2131165575: 
        case 2131165576: 
        default:
            return;

        case 2131165569: 
            if (aio == 1)
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                view.putExtra("acquire_url_start", "");
                startActivity(view);
                return;
            }
            if (android.os.Build.VERSION.RELEASE.startsWith("5"))
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                view.putExtra("acquire_url_start", "");
                startActivity(view);
                return;
            } else
            {
                moveTaskToBack(true);
                return;
            }

        case 2131165577: 
            (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage(getString(0x7f0b0041)).setPositiveButton(getString(0x7f0b003c), new android.content.DialogInterface.OnClickListener() {

                final MyDownloaderList this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                    Appdeletall();
                }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
            }).setNegativeButton(getString(0x7f0b003b), new android.content.DialogInterface.OnClickListener() {

                final MyDownloaderList this$0;

                public void onClick(DialogInterface dialoginterface, int i)
                {
                }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
            }).show();
            return;

        case 2131165572: 
        case 2131165573: 
            view = null;
            break;
        }
        android.content.pm.PackageInfo packageinfo = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        view = packageinfo;
_L2:
        if (view != null)
        {
            break MISSING_BLOCK_LABEL_396;
        }
        try
        {
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                startActivity(view);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
        break; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
        if (true) goto _L2; else goto _L1
_L1:
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final MyDownloaderList this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    void1 = new Intent("android.intent.action.VIEW");
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                    startActivity(void1);
                }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.freepezzle.hexcrush");
        startActivity(view);
        return;
        startActivity(getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush"));
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Log.e("gak", (new StringBuilder("aaaa=")).append(Myutils.iswidget2).toString());
        if (!Myutils.iswidget2)
        {
            bundle = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
            bundle.putExtra("acquire_url_start", "");
            startActivity(bundle);
            overridePendingTransition(0x7f04000c, 0x7f040011);
            Myutils.iswidget = true;
        }
        setContentView(0x7f030034);
        setmContext(getApplicationContext());
        init();
        initView();
        download_file();
        buildLister();
        bundle = new IntentFilter();
        bundle.addAction("delete");
        registerReceiver(mBroadcastReceiver_delete, bundle);
        bundle = new IntentFilter();
        bundle.addAction("successful");
        registerReceiver(appsuccessful, bundle);
        bundle = new IntentFilter();
        bundle.addAction("mymp3play");
        registerReceiver(mp3play, bundle);
        (new Timer()).schedule(new TimerTask() {

            final MyDownloaderList this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 100;
                handler.sendMessage(message);
            }

            
            {
                this$0 = MyDownloaderList.this;
                super();
            }
        }, 0L, 1000L);
        appicon = (ImageView)findViewById(0x7f0700fb);
        apptitle = (TextView)findViewById(0x7f0700c4);
        official = (TextView)findViewById(0x7f0700fc);
        appprice = (TextView)findViewById(0x7f0700c0);
        appauthortitle = (TextView)findViewById(0x7f0700c6);
        app_ratingbar = (RatingBar)findViewById(0x7f0700be);
        app_download_bt = (Button)findViewById(0x7f0700c7);
        inmobtop = (RelativeLayout)findViewById(0x7f0700c2);
        xian = (TextView)findViewById(0x7f0700c1);
        try
        {
            typeFace = Typeface.createFromAsset(getApplicationContext().getAssets(), "Roboto-Light.ttf");
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle) { }
        nativeAd = new NativeAd(getApplicationContext(), "340186902832477_418871068297393");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        nativeAdgift = new NativeAd(getApplicationContext(), "340186902832477_436045469913286");
        nativeAdgift.setAdListener(this);
        nativeAdgift.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        aio = getIntent().getIntExtra("aio", 0);
        JPushInterface.setSilenceTime(getApplicationContext(), 8, 0, 7, 59);
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

    public void onError(Ad ad, AdError aderror)
    {
        inmobtop.setVisibility(8);
        ll_download_complement.setVisibility(0);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (aio == 1)
            {
                keyevent = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                keyevent.putExtra("acquire_url_start", "");
                startActivity(keyevent);
                return true;
            }
            if (android.os.Build.VERSION.RELEASE.startsWith("5"))
            {
                keyevent = new Intent(getApplicationContext(), com/aio/downloader/activity/MyMainActivity);
                keyevent.putExtra("acquire_url_start", "");
                startActivity(keyevent);
                return true;
            } else
            {
                moveTaskToBack(true);
                return true;
            }
        }
        if (3 == i)
        {
            moveTaskToBack(true);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(getApplicationContext());
        try
        {
            animationDrawable.stop();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(getApplicationContext());
        adapter.notifyDataSetChanged();
        if (!Myutils.iswidget2 || ll_downnull.getVisibility() != 0)
        {
            break MISSING_BLOCK_LABEL_75;
        }
        Log.e("qaz", "qazqazqzaza");
        iv_ioio.setImageResource(0x7f040006);
        animationDrawable = (AnimationDrawable)iv_ioio.getDrawable();
        animationDrawable.start();
        return;
        Exception exception;
        exception;
    }


























}
