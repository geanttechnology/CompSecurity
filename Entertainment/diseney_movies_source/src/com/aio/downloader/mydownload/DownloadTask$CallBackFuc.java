// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.mydownload;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.aio.downloader.activity.DownloadAppManager;
import com.aio.downloader.utils.MD5;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.stericson.RootTools.RootTools;
import java.io.File;
import java.io.IOException;
import java.util.List;
import net.tsz.afinal.FinalDBChen;
import net.tsz.afinal.http.AjaxCallBack;

// Referenced classes of package com.aio.downloader.mydownload:
//            DownloadTask, DownloadMovieItem, MyApplcation

class stop_download_bt extends AjaxCallBack
{

    private int cu;
    private TextView current_progress;
    private DownloadMovieItem down;
    private TextView kb;
    private TextView movie_name_item;
    private ProgressBar p;
    private TextView stop_download_bt;
    final DownloadTask this$0;
    private TextView totalSize;
    private View view;

    public void onFailure(Throwable throwable, String s)
    {
        Log.e("qaz", "onFailure");
        (new Thread(new Runnable() {

            final DownloadTask.CallBackFuc this$1;

            public void run()
            {
                publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=app&action=retry_fail&id=")).append(down.getFile_id()).append("&size=").append(down.getCurrentProgress()).toString());
            }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
        })).start();
        throwable = new Intent("pdt_failure");
        DownloadTask.access$3(DownloadTask.this).sendBroadcast(throwable);
        if (TextUtils.isEmpty(down.getFileSize()))
        {
            down.setFileSize("0.0B");
        }
        down.setDownloadState(Integer.valueOf(5));
        throwable = DownloadTask.access$9(DownloadTask.this);
        s = down.getMovieName();
        DownloadMovieItem downloadmovieitem = down;
        throwable.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
            s
        }, downloadmovieitem);
        if (view != null)
        {
            kb.setVisibility(4);
            if (stop_download_bt.getVisibility() == 4)
            {
                stop_download_bt.setVisibility(0);
            }
            stop_download_bt.setText("Retry");
            current_progress.setTextColor(Color.parseColor("#f39801"));
            current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0026));
            throwable = new nit>(DownloadTask.this, 5, down, stop_download_bt);
            throwable.tCurrent_progress(current_progress);
            stop_download_bt.setOnClickListener(throwable);
            throwable = DownloadTask.this;
            DownloadTask.access$14(throwable, DownloadTask.access$13(throwable) + 1);
            int i = DownloadTask.access$3(DownloadTask.this).getSharedPreferences("downloadcomplete", 0).getInt("wycand", 0);
            if (DownloadTask.access$13(DownloadTask.this) < 4)
            {
                stop_download_bt.performClick();
            } else
            if (i == 0)
            {
                DownloadTask.access$14(DownloadTask.this, 0);
                throwable = new Notification();
                throwable.flags = 16;
                throwable.icon = 0x7f0200ec;
                s = new Intent(DownloadTask.access$3(DownloadTask.this), com/aio/downloader/activity/DownloadAppManager);
                s.setFlags(0x10000000);
                throwable.contentIntent = PendingIntent.getActivity(DownloadTask.access$3(DownloadTask.this), down.getSerial(), s, 0x8000000);
                s = new RemoteViews(DownloadTask.access$3(DownloadTask.this).getPackageName(), 0x7f030091);
                DownloadTask.access$11(DownloadTask.this, DownloadTask.access$9(DownloadTask.this).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
                s.setTextViewText(0x7f070332, "Incomplete Task");
                s.setTextViewText(0x7f070333, DateFormat.format("kk:mm", System.currentTimeMillis()));
                s.setImageViewBitmap(0x7f070331, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(down.getMovieHeadImagePath())).toString()));
                throwable.contentView = s;
                try
                {
                    DownloadTask.mNotificationManager.notify(down.getSerial(), throwable);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Throwable throwable)
                {
                    return;
                }
            }
        }
    }

    public void onLoading(long l, long l1)
    {
        int i = 0;
        if (l1 > (long)cu)
        {
            i = (int)(l1 - (long)cu);
            cu = (int)l1;
        }
        Object obj = (new StringBuilder(String.valueOf(Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), i)))).append("/s").toString();
        i = (int)((100L * l1) / l);
        if (view != null)
        {
            String s = Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), l1);
            current_progress.setText((new StringBuilder(String.valueOf(i))).append("%").toString());
            down.setPercentage((new StringBuilder(String.valueOf(i))).append("%").toString());
            down.setProgressCount(Long.valueOf(l));
            down.setCurrentProgress(Long.valueOf(l1));
            Object obj1 = Formatter.formatFileSize(DownloadTask.access$3(DownloadTask.this), l);
            down.setFileSize(String.valueOf(l));
            totalSize.setText((new StringBuilder(String.valueOf(s))).append("/").append(((String) (obj1))).toString());
            kb.setText(((CharSequence) (obj)));
            if (kb.getVisibility() == 4)
            {
                kb.setVisibility(0);
            }
            p.setMax((int)l);
            p.setProgress((int)l1);
            if (stop_download_bt.getVisibility() == 4)
            {
                stop_download_bt.setVisibility(0);
                stop_download_bt.setText("Pause");
            }
            down.setDownloadState(Integer.valueOf(2));
            obj = DownloadTask.access$9(DownloadTask.this);
            s = down.getMovieName();
            obj1 = down;
            ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                s
            }, obj1);
        }
    }

    public void onStart()
    {
        down.setDownloadState(Integer.valueOf(7));
        Object obj = DownloadTask.access$9(DownloadTask.this);
        String s = down.getMovieName();
        DownloadMovieItem downloadmovieitem = down;
        ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
            s
        }, downloadmovieitem);
        obj = new Intent();
        ((Intent) (obj)).putExtra("downloadType", 7);
        ((Intent) (obj)).setAction("downloadType");
        ((MyApplcation)DownloadTask.access$3(DownloadTask.this).getApplicationContext()).setDownloadSuccess(down);
        DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj)));
        super.onStart();
    }

    public void onSuccess(File file)
    {
label0:
        {
            {
                (new Thread(new Runnable() {

                    final DownloadTask.CallBackFuc this$1;

                    public void run()
                    {
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloading&id=")).append(down.getFile_id()).append("&status=success&size=").append(down.getFileSize()).toString());
                    }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
                })).start();
                Log.e("qaz", "onSuccess");
                if (view != null)
                {
                    Log.e("qaz", "view!=null");
                    kb.setVisibility(4);
                    current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0024));
                    stop_download_bt.setText("Pause");
                    stop_download_bt.setOnClickListener(new nit>(DownloadTask.this, 6, down, stop_download_bt));
                }
                down.setDownloadState(Integer.valueOf(6));
                Object obj = DownloadTask.access$9(DownloadTask.this);
                Object obj1 = down.getMovieName();
                Object obj2 = down;
                ((FinalDBChen) (obj)).updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                    obj1
                }, obj2);
                obj = new Intent();
                Myutils.getInstance();
                Myutils.successItem = down;
                Log.v("erer", (new StringBuilder("11111111")).append(down.getType()).append(down.getFile_id()).toString());
                obj2 = (MyApplcation)DownloadTask.access$3(DownloadTask.this).getApplicationContext();
                ((Intent) (obj)).putExtra("downpath", down.getFilePath());
                ((Intent) (obj)).setAction("successful");
                obj1 = new Intent();
                if (down.getType().equals("mp3"))
                {
                    ((Intent) (obj1)).setAction("mp3successful");
                } else
                if (down.getType().equals("ringtone"))
                {
                    ((Intent) (obj1)).setAction("ringtonesuccessful");
                } else
                if (down.getType().equals("app"))
                {
                    ((Intent) (obj1)).setAction("appsuccessful_aio");
                } else
                if (down.getType().equals("video"))
                {
                    ((Intent) (obj1)).setAction("videosuccessful");
                }
                if (!is_valid_file().booleanValue())
                {
                    break label0;
                }
                ((MyApplcation) (obj2)).setDownloadSuccess(down);
                obj2 = (LinearLayout)view.getParent();
                IOException ioexception;
                try
                {
                    ((LinearLayout) (obj2)).removeView(view);
                }
                catch (Exception exception2) { }
                DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj)));
                DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj1)));
                if (down.getType().equals("app"))
                {
                    publicTools.toptoast = false;
                    publicTools.openimgpath = down.getMovieHeadImagePath();
                    publicTools.opentitle = down.getTitle();
                    publicTools.openid = down.getFile_id();
                    if (RootTools.isRootAvailable())
                    {
                        Log.e("qaz", "root");
                        (new Thread(new Runnable() {

                            final DownloadTask.CallBackFuc this$1;

                            public void run()
                            {
                                String s = (new StringBuilder(String.valueOf("pm install -r "))).append(down.getFilePath()).toString();
                                excuteSuCMD(s);
                            }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
                        })).start();
                    } else
                    {
                        try
                        {
                            obj = new Intent("android.intent.action.VIEW");
                            ((Intent) (obj)).setDataAndType(Uri.parse((new StringBuilder("file://")).append(down.getFilePath()).toString()), "application/vnd.android.package-archive");
                            ((Intent) (obj)).addFlags(0x10000000);
                            DownloadTask.access$3(DownloadTask.this).startActivity(((Intent) (obj)));
                        }
                        catch (Exception exception) { }
                    }
                    DownloadTask.access$10(DownloadTask.this, 0x7f0200ec, (new StringBuilder("'")).append(down.getTitle()).append("' Download Complete. Click to install").toString());
                    obj = new Intent();
                    ((Intent) (obj)).setAction("jingmoanzhuang_aio");
                    DownloadTask.access$3(DownloadTask.this).sendBroadcast(((Intent) (obj)));
                    (new AsyncTask() {

                        final DownloadTask.CallBackFuc this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(2000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
                            }
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj3)
                        {
                            onPostExecute((Void)obj3);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            void1 = new Notification();
                            void1.flags = 16;
                            void1.icon = 0x7f0200ec;
                            Object obj3 = new Intent(DownloadTask.access$3(this$0), com/aio/downloader/activity/DownloadAppManager);
                            ((Intent) (obj3)).setFlags(0x10000000);
                            void1.contentIntent = PendingIntent.getActivity(DownloadTask.access$3(this$0), 110, ((Intent) (obj3)), 0x8000000);
                            obj3 = new RemoteViews(DownloadTask.access$3(this$0).getPackageName(), 0x7f030090);
                            DownloadTask.access$11(this$0, DownloadTask.access$9(this$0).findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null));
                            ((RemoteViews) (obj3)).setTextViewText(0x7f07031c, (new StringBuilder("Downloading(")).append(DownloadTask.access$12(this$0).size()).append(") & Completed").append("(").append(publicTools.noticomplete).append(")").toString());
                            ((RemoteViews) (obj3)).setTextViewText(0x7f07031b, DateFormat.format("kk:mm", System.currentTimeMillis()));
                            void1.contentView = ((RemoteViews) (obj3));
                            if (DownloadTask.access$12(this$0).size() > 0)
                            {
                                DownloadTask.mNotificationManager.notify(110, void1);
                            }
                        }

            
            {
                this$1 = DownloadTask.CallBackFuc.this;
                super();
            }
                    }).execute(new Void[0]);
                }
            }
            super.onSuccess(file);
            return;
        }
        obj2 = new Message();
        obj2.what = 1212;
        ((Message) (obj2)).getData().putString("type", down.getType());
        ((Message) (obj2)).getData().putString("id", down.getFile_id());
        ((Message) (obj2)).getData().putString("size", down.getFileSize());
        exception = "";
        obj1 = BufferedReader(down.getFilePath());
        exception = ((Exception) (obj1));
        Log.v("tyty", (new StringBuilder("content===")).append(((String) (obj1))).toString());
        exception = ((Exception) (obj1));
_L6:
        if (exception.length() <= 100) goto _L2; else goto _L1
_L1:
        ((Message) (obj2)).getData().putString("content", exception.substring(1, 100));
_L7:
        if (!down.getType().equals("app")) goto _L4; else goto _L3
_L3:
        Myutils.getInstance();
        if (!Myutils.type_current.equals("app_recent")) goto _L4; else goto _L5
_L5:
        publicTools.app_recent_handler.sendMessage(((Message) (obj2)));
_L8:
        current_progress.setText("Invalid");
        current_progress.setTextColor(Color.parseColor("#f39801"));
        kb.setVisibility(0);
        kb.setText("0KB/s");
        break MISSING_BLOCK_LABEL_519;
        ioexception;
        ioexception.printStackTrace();
          goto _L6
_L2:
        ((Message) (obj2)).getData().putString("content", exception);
          goto _L7
_L4:
label1:
        {
            if (!down.getType().equals("app"))
            {
                break label1;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_popular"))
            {
                break label1;
            }
            publicTools.app_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label2:
        {
            if (!down.getType().equals("app"))
            {
                break label2;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_search"))
            {
                break label2;
            }
            publicTools.app_search_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label3:
        {
            if (!down.getType().equals("app"))
            {
                break label3;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("app_detail"))
            {
                break label3;
            }
            publicTools.app_detail_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label4:
        {
            if (!down.getType().equals("game"))
            {
                break label4;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("game_recent"))
            {
                break label4;
            }
            publicTools.game_recent_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label5:
        {
            if (!down.getType().equals("game"))
            {
                break label5;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("game_popular"))
            {
                break label5;
            }
            publicTools.game_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label6:
        {
            if (!down.getType().equals("mp3"))
            {
                break label6;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("mp3_recent"))
            {
                break label6;
            }
            publicTools.mp3_recent_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label7:
        {
            if (!down.getType().equals("mp3"))
            {
                break label7;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("mp3_popular"))
            {
                break label7;
            }
            publicTools.mp3_popular_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
label8:
        {
            if (!down.getType().equals("mp3"))
            {
                break label8;
            }
            Myutils.getInstance();
            if (!Myutils.type_current.equals("mp3_search"))
            {
                break label8;
            }
            publicTools.mp3_search_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
        try
        {
label9:
            {
                if (!down.getType().equals("ringtone"))
                {
                    break label9;
                }
                Myutils.getInstance();
                if (!Myutils.type_current.equals("ringtone_recent"))
                {
                    break label9;
                }
                publicTools.ringtone_recent_handler.sendMessage(((Message) (obj2)));
            }
        }
        catch (Exception exception1) { }
          goto _L8
        if (!down.getType().equals("ringtone")) goto _L10; else goto _L9
_L9:
        Myutils.getInstance();
        if (!Myutils.type_current.equals("ringtone_popular")) goto _L10; else goto _L11
_L11:
        publicTools.ringtone_popular_handler.sendMessage(((Message) (obj2)));
          goto _L8
_L10:
        if (!down.getType().equals("ringtone")) goto _L8; else goto _L12
_L12:
        Myutils.getInstance();
        if (Myutils.type_current.equals("ringtone_search"))
        {
            publicTools.ringtone_search_handler.sendMessage(((Message) (obj2)));
        }
          goto _L8
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((File)obj);
    }



    public _cls4.this._cls1(View view1, DownloadMovieItem downloadmovieitem)
    {
        this$0 = DownloadTask.this;
        super();
        down = downloadmovieitem;
        view = view1;
        if (view1 == null)
        {
            break MISSING_BLOCK_LABEL_271;
        }
        p = (ProgressBar)view1.findViewById(0x7f07027a);
        DownloadTask.access$5(DownloadTask.this, DownloadTask.access$3(DownloadTask.this).getResources().getDisplayMetrics().widthPixels);
        if (DownloadTask.access$6(DownloadTask.this) < 500)
        {
            android.view.Task task = p.getLayoutParams();
            task.dth = 186;
            p.setLayoutParams(task);
        }
        kb = (TextView)view1.findViewById(0x7f07027b);
        totalSize = (TextView)view1.findViewById(0x7f070279);
        stop_download_bt = (TextView)view1.findViewById(0x7f070276);
        stop_download_bt.setText("Pause");
        current_progress = (TextView)view1.findViewById(0x7f07027c);
        movie_name_item = (TextView)view1.findViewById(0x7f070278);
        stop_download_bt.setVisibility(4);
        stop_download_bt.setText("Pause");
        movie_name_item.setText(downloadmovieitem.getMovieName());
        movie_name_item.setTypeface(DownloadTask.access$7(DownloadTask.this));
        current_progress.setTextColor(Color.parseColor("#cccccc"));
        current_progress.setText(DownloadTask.access$3(DownloadTask.this).getString(0x7f0b0020));
        DownloadTask.access$8(DownloadTask.this, new nit>(DownloadTask.this, 7, downloadmovieitem, stop_download_bt));
        DownloadTask.access$0(DownloadTask.this).tCurrent_progress(current_progress);
        stop_download_bt.setOnClickListener(DownloadTask.access$0(DownloadTask.this));
        return;
        downloadtask;
    }
}
