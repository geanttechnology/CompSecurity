// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.service;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.RemoteViews;
import com.aio.downloader.activity.AppDetailsActivity;
import com.aio.downloader.activity.PaidforFreeActivity1;
import com.aio.downloader.dialog.CallerOutDialog1;
import com.aio.downloader.dialog.CleanerUpdateDialog;
import com.aio.downloader.dialog.CleanermusterDialog;
import com.aio.downloader.dialog.CleanertoolboxDialog;
import com.aio.downloader.dialog.InstallfirstDialog;
import com.aio.downloader.model.AppInfo;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.utils.MD5;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.publicTools;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServiceUpdate extends Service
{
    class Mya5 extends AsyncTask
    {

        private String icon_pick1;
        private String img_pick;
        private String short_desc1;
        final ServiceUpdate this$0;
        private String title_pick1;
        private String url1;

        private void ShowResult6(String s)
        {
            list_pick.addAll(Myutils.parsetodaypick(s));
            Log.e("lpl", (new StringBuilder("list_pick=")).append(list_pick).toString());
            try
            {
                icon_pick = ((DownloadMovieItem)list_pick.get(0)).getIcon();
                title_pick = ((DownloadMovieItem)list_pick.get(0)).getTitle();
                short_desc = ((DownloadMovieItem)list_pick.get(0)).getShort_desc();
                img_pick = ((DownloadMovieItem)list_pick.get(0)).getMovieHeadImagePath();
                id_meiribig = ((DownloadMovieItem)list_pick.get(0)).getId();
                icon_pick1 = ((DownloadMovieItem)list_pick.get(1)).getIcon();
                title_pick1 = ((DownloadMovieItem)list_pick.get(1)).getTitle();
                short_desc1 = ((DownloadMovieItem)list_pick.get(1)).getShort_desc();
                id_meiri = ((DownloadMovieItem)list_pick.get(1)).getId();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            (new Timer()).schedule(new TimerTask() {

                final Mya5 this$1;

                public void run()
                {
                    Intent intent = new Intent("meiri");
                    intent.putExtra("icon_pick1", icon_pick1);
                    intent.putExtra("title_pick1", title_pick1);
                    intent.putExtra("short_desc1", short_desc1);
                    intent.putExtra("id_meiri", id_meiri);
                    sendBroadcast(intent);
                    intent = new Intent("meiribig");
                    intent.putExtra("icon_pick", icon_pick);
                    intent.putExtra("title_pick", title_pick);
                    intent.putExtra("short_desc", short_desc);
                    intent.putExtra("img_pick", img_pick);
                    intent.putExtra("id_meiribig", id_meiribig);
                    sendBroadcast(intent);
                }

            
            {
                this$1 = Mya5.this;
                super();
            }
            }, 30000L, 60000L);
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            url1 = "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1";
            return publicTools.getUrl(url1);
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            } else
            {
                Log.e("asd", (new StringBuilder("result=")).append(s).toString());
                ShowResult6(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }






        Mya5()
        {
            this$0 = ServiceUpdate.this;
            super();
        }
    }

    class Mya7 extends AsyncTask
    {

        private int showup;
        final ServiceUpdate this$0;
        private String url1;

        private void ShowResult7(String s)
        {
            list_update.addAll(Myutils.parseupdata(s));
            if (Myutils.status != 1)
            {
                break MISSING_BLOCK_LABEL_203;
            }
            try
            {
                Log.e("qaz", (new StringBuilder(String.valueOf(list_update.size()))).toString());
                showup = (int)(Math.random() * (double)list_update.size());
                (new Timer()).schedule(new TimerTask() {

                    final Mya7 this$1;

                    public void run()
                    {
                        Log.e("qaz", (new StringBuilder("updateservise")).append(((DownloadMovieItem)list_update.get(showup)).getId()).toString());
                        Intent intent = new Intent("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD");
                        intent.putExtra("appid", ((DownloadMovieItem)list_update.get(showup)).getId());
                        intent.putExtra("appvirsion", ((DownloadMovieItem)list_update.get(showup)).getVersion());
                        intent.putExtra("appurl", ((DownloadMovieItem)list_update.get(showup)).getLink_url());
                        sendBroadcast(intent);
                    }

            
            {
                this$1 = Mya7.this;
                super();
            }
                }, 1000L, 30000L);
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
            s = new MyAppInfo(getApplicationContext());
            appName = s.getAppName(((DownloadMovieItem)list_update.get(showup)).getId());
            appVersion = s.getAppVersion(((DownloadMovieItem)list_update.get(showup)).getId());
            appIcon = s.getAppIcon(((DownloadMovieItem)list_update.get(showup)).getId());
            return;
            s;
            s.printStackTrace();
            return;
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            Log.e("qaz", (new StringBuilder(String.valueOf(upJsonStr))).append("===").toString());
            return upJsonStr;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            if (s == null)
            {
                return;
            } else
            {
                Log.e("qaz", (new StringBuilder("result=")).append(s).toString());
                ShowResult7(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }



        Mya7()
        {
            this$0 = ServiceUpdate.this;
            super();
        }
    }


    protected static final String STATUS_BAR_COVER_CLICK_UPDATE = "update";
    protected static final String STATUS_BAR_COVER_PAID = "paid";
    protected static final String STATUS_BAR_COVER_PICK = "pick";
    protected static final String STATUS_BAR_COVER_PICK_BIG = "pick_big";
    protected static final String STATUS_BAR_DOWNLOAD_INSTALL = "status_bar_download_install";
    protected static final String STATUS_BAR_DOWNLOAD_SUCCESS = "status_bar_download_success";
    public static NotificationManager mNotificationManager3;
    private final String ACTION_NAME_UPDATE = "\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD";
    private final String ACTION_NAME_UPDATE_FLAG = "\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD\u6807\u793A";
    private final String ACTION_NAME_UPDATE_UPDATE = "setbroadUpdate";
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private final String DOWNLOADINSTALL = "downloadinstall";
    private final String DOWNLOADSUCCESS = "downloadsuccess";
    private final String MEIRI = "meiri";
    private final String MEIRIBIG = "meiribig";
    private final String PAIDPPP = "paidppp";
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private Handler appHandler;
    Drawable appIcon;
    Drawable appIcondown;
    Drawable appIconinstall;
    String appName;
    String appNamedown;
    String appNameinstall;
    String appVersion;
    String appid;
    private String appid_down;
    private String appidinstall;
    private String appurl;
    private String appversion2;
    private CallerOutDialog1 callerOutDialog1;
    private int clean_box;
    private CleanerUpdateDialog cleanerUpdateDialog;
    private CleanermusterDialog cleanermusterDialog;
    private CleanertoolboxDialog cleanertoolboxDialog;
    private int cleanerupdate;
    private String dEVICE_ID;
    private InstallfirstDialog dialog;
    private String filepathdown;
    private Handler handler;
    private String icon_pick;
    private String icon_pick1;
    private String id_meiri;
    private String id_meiribig;
    private String iddown;
    private String img_pick;
    private android.view.View.OnClickListener itemsOnClick4;
    private JSONArray jsonArray;
    ArrayList list_pick;
    ArrayList list_update;
    private BroadcastReceiver mBroadcastReceiver;
    public List mListInfo;
    private NotificationManager mNotificationManager1;
    private NotificationManager mNotificationManager2;
    private NotificationManager mNotificationManager4;
    private NotificationManager mNotificationManager8;
    private NotificationManager mNotificationManager9;
    private Notification notification_down;
    private Notification notification_i;
    private Notification notification_install;
    private Notification notification_ram;
    BroadcastReceiver onClickReceiver;
    private int serial;
    SharedPreferences sharedPreferences;
    private String short_desc;
    private String short_desc1;
    private String title_pick;
    private String title_pick1;
    private String upJsonStr;
    private String url1;

    public ServiceUpdate()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        list_pick = new ArrayList();
        mListInfo = new ArrayList();
        list_update = new ArrayList();
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        clean_box = 0;
        cleanerupdate = 0;
        appHandler = new Handler() {

            private int showup;
            final ServiceUpdate this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR tableswitch 1001 1001: default 24
            //                           1001 30;
                   goto _L1 _L2
_L1:
                super.handleMessage(message);
                return;
_L2:
                Log.e("qaz", (new StringBuilder("10001")).append(message.obj.toString()).toString());
                list_update.addAll(Myutils.parseupdata(message.obj.toString()));
                if (Myutils.status == 1)
                {
                    try
                    {
                        Log.e("qaz", (new StringBuilder(String.valueOf(list_update.size()))).toString());
                        showup = (int)(Math.random() * (double)list_update.size());
                        (new Timer()).schedule(new TimerTask() {

                            final _cls1 this$1;

                            public void run()
                            {
                                Intent intent = new Intent("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD");
                                intent.putExtra("appid", ((DownloadMovieItem)list_update.get(showup)).getId());
                                intent.putExtra("appvirsion", ((DownloadMovieItem)list_update.get(showup)).getVersion());
                                intent.putExtra("appurl", ((DownloadMovieItem)list_update.get(showup)).getLink_url());
                                sendBroadcast(intent);
                            }

            
            {
                this$1 = _cls1.this;
                super();
            }
                        }, 1000L, 30000L);
                    }
                    catch (Exception exception) { }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }



            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        };
        handler = new Handler() {

            private String icon0;
            private String icon1;
            private String icon2;
            private String icon3;
            private String icon4;
            private String icon5;
            private String icon6;
            private String icon7;
            final ServiceUpdate this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR lookupswitch 4: default 52
            //                           10: 262
            //                           30: 53
            //                           100: 554
            //                           250: 76;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return;
_L3:
                MobclickAgent.onEvent(getApplicationContext(), "first_insall_cleaner");
                dialog.show();
                return;
_L5:
                message = message.obj.toString();
                try
                {
                    message = new JSONObject(message);
                    message.getInt("has_next_page");
                    if (message.getInt("status") == 1)
                    {
                        message = message.getJSONArray("list");
                        icon0 = message.getJSONObject(0).getString("icon");
                        icon1 = message.getJSONObject(1).getString("icon");
                        icon2 = message.getJSONObject(2).getString("icon");
                        icon3 = message.getJSONObject(3).getString("icon");
                        icon4 = message.getJSONObject(4).getString("icon");
                        icon5 = message.getJSONObject(5).getString("icon");
                        icon6 = message.getJSONObject(6).getString("icon");
                        icon7 = message.getJSONObject(7).getString("icon");
                        (new Timer()).schedule(new TimerTask() {

                            final _cls2 this$1;

                            public void run()
                            {
                                Log.e("qwa", (new StringBuilder("icon0=")).append(icon0).toString());
                                Intent intent = new Intent("paidppp");
                                intent.putExtra("icon0", icon0);
                                intent.putExtra("icon1", icon1);
                                intent.putExtra("icon2", icon2);
                                intent.putExtra("icon3", icon3);
                                intent.putExtra("icon4", icon4);
                                intent.putExtra("icon5", icon5);
                                sendBroadcast(intent);
                            }

            
            {
                this$1 = _cls2.this;
                super();
            }
                        }, 10000L, 30000L);
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Message message)
                {
                    message.printStackTrace();
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L2:
                message = message.obj.toString();
                list_pick.addAll(Myutils.parsetodaypick(message));
                Log.e("lpl", (new StringBuilder("list_pick=")).append(list_pick).toString());
                Object obj;
                android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
                int i;
                int j;
                int k;
                try
                {
                    icon_pick = ((DownloadMovieItem)list_pick.get(0)).getIcon();
                    title_pick = ((DownloadMovieItem)list_pick.get(0)).getTitle();
                    short_desc = ((DownloadMovieItem)list_pick.get(0)).getShort_desc();
                    img_pick = ((DownloadMovieItem)list_pick.get(0)).getMovieHeadImagePath();
                    id_meiribig = ((DownloadMovieItem)list_pick.get(0)).getId();
                    icon_pick1 = ((DownloadMovieItem)list_pick.get(1)).getIcon();
                    title_pick1 = ((DownloadMovieItem)list_pick.get(1)).getTitle();
                    short_desc1 = ((DownloadMovieItem)list_pick.get(1)).getShort_desc();
                    id_meiri = ((DownloadMovieItem)list_pick.get(1)).getId();
                }
                // Misplaced declaration of an exception variable
                catch (Message message) { }
                (new Timer()).schedule(new TimerTask() {

                    final _cls2 this$1;

                    public void run()
                    {
                        Intent intent = new Intent("meiri");
                        intent.putExtra("icon_pick1", icon_pick1);
                        intent.putExtra("title_pick1", title_pick1);
                        intent.putExtra("short_desc1", short_desc1);
                        intent.putExtra("id_meiri", id_meiri);
                        sendBroadcast(intent);
                        intent = new Intent("meiribig");
                        intent.putExtra("icon_pick", icon_pick);
                        intent.putExtra("title_pick", title_pick);
                        intent.putExtra("short_desc", short_desc);
                        intent.putExtra("img_pick", img_pick);
                        intent.putExtra("id_meiribig", id_meiribig);
                        sendBroadcast(intent);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }, 30000L, 60000L);
                return;
_L4:
                message = null;
                obj = getApplicationContext().getPackageManager().getPackageInfo("com.allinone.callerid", 0);
                message = ((Message) (obj));
_L7:
                obj = new Time();
                ((Time) (obj)).setToNow();
                i = ((Time) (obj)).hour;
                j = ((Time) (obj)).minute;
                k = ((Time) (obj)).second;
                if (i == 10 && j == 30 && k == 0 && message == null)
                {
                    MobclickAgent.onEvent(getApplicationContext(), "simulate_call");
                    callerOutDialog1 = new CallerOutDialog1(getApplicationContext(), 0x7f0c0010, itemsOnClick4, "+1 813-449-2756");
                    callerOutDialog1.setCanceledOnTouchOutside(true);
                    callerOutDialog1.getWindow().setType(2003);
                    callerOutDialog1.show();
                    return;
                }
                if (true) goto _L1; else goto _L6
_L6:
                namenotfoundexception;
                namenotfoundexception.printStackTrace();
                  goto _L7
            }








            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        };
        onClickReceiver = new BroadcastReceiver() {

            final ServiceUpdate this$0;

            public void onReceive(Context context, Intent intent)
            {
                if (intent.getAction().equals("update"))
                {
                    MobclickAgent.onEvent(getApplicationContext(), "update_not_click");
                    context = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    context.putExtra("myid", appid);
                    context.putExtra("linkurl", appurl);
                    context.putExtra("wocao", 1);
                    context.putExtra("caocao", 0);
                    context.putExtra("myupver", appversion2);
                    context.setFlags(0x10000000);
                    startActivity(context);
                } else
                {
                    if (intent.getAction().equals("pick"))
                    {
                        MobclickAgent.onEvent(getApplicationContext(), "pick_apps_click");
                        context = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                        context.putExtra("myid", id_meiri);
                        context.setFlags(0x10000000);
                        context.putExtra("linkurl", "");
                        context.putExtra("caocao", 0);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("pick_big"))
                    {
                        MobclickAgent.onEvent(getApplicationContext(), "pick_big_click");
                        context = new Intent(context, com/aio/downloader/activity/AppDetailsActivity);
                        context.putExtra("myid", id_meiribig);
                        context.setFlags(0x10000000);
                        context.putExtra("linkurl", "");
                        context.putExtra("caocao", 0);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("paid"))
                    {
                        MobclickAgent.onEvent(getApplicationContext(), "paid_click");
                        context = new Intent(context, com/aio/downloader/activity/PaidforFreeActivity1);
                        context.setFlags(0x10000000);
                        context.putExtra("caocao", 0);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("status_bar_download_success"))
                    {
                        MobclickAgent.onEvent(context, "downloadsuccess_click");
                        context = new Intent("android.intent.action.VIEW");
                        context.setDataAndType(Uri.parse((new StringBuilder("file://")).append(filepathdown).toString()), "application/vnd.android.package-archive");
                        context.addFlags(0x10000000);
                        startActivity(context);
                        return;
                    }
                    if (intent.getAction().equals("status_bar_download_install"))
                    {
                        MobclickAgent.onEvent(context, "installsuccess_click");
                        intent = context.getPackageManager().getLaunchIntentForPackage(appidinstall);
                        intent.addFlags(0x10000000);
                        context.startActivity(intent);
                        return;
                    }
                }
            }

            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        };
        mBroadcastReceiver = new BroadcastReceiver() {

            final ServiceUpdate this$0;

            public void onReceive(Context context, Intent intent)
            {
                int i;
                int j;
                context = intent.getAction();
                Time time = new Time();
                time.setToNow();
                i = time.year;
                i = time.month;
                i = time.monthDay;
                i = time.hour;
                j = time.minute;
                int k = time.second;
                Log.e("caobi", (new StringBuilder("hour=")).append(i).append("minute=").append(j).append("second=").append(k).toString());
                if (!context.equals("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD")) goto _L2; else goto _L1
_L1:
                int l = getSharedPreferences("app_update", 0).getInt("wycupdate", 0);
                if (i == 14 && j == 0 && l == 0)
                {
                    appid = intent.getStringExtra("appid");
                    appurl = intent.getStringExtra("appurl");
                    appversion2 = intent.getStringExtra("appvirsion");
                    context = new MyAppInfo(getApplicationContext());
                    try
                    {
                        appName = context.getAppName(appid);
                        appIcon = context.getAppIcon(appid);
                        appVersion = context.getAppVersion(appid);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        context.printStackTrace();
                    }
                    MobclickAgent.onEvent(getApplicationContext(), "update_not");
                    mNotificationManager1 = (NotificationManager)getSystemService("notification");
                    notification_ram = new Notification();
                    notification_ram.flags = 16;
                    notification_ram.icon = 0x7f0201ab;
                    context = new Intent("update");
                    context = PendingIntent.getBroadcast(getApplicationContext(), 0, context, 0);
                    notification_ram.contentIntent = context;
                    context = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030086);
                    context.setImageViewBitmap(0x7f07031d, ServiceUpdate.drawableToBitmap(appIcon));
                    context.setTextViewText(0x7f07031e, appName);
                    context.setTextViewText(0x7f070320, (new StringBuilder("v")).append(appversion2).toString());
                    context.setTextViewText(0x7f07031f, (new StringBuilder("v")).append(appVersion).toString());
                    notification_ram.contentView = context;
                    mNotificationManager1.notify(657, notification_ram);
                }
_L4:
                return;
_L2:
                if (context.equals("setbroadUpdate"))
                {
                    continue; /* Loop/switch isn't completed */
                }
                if (!context.equals("meiri"))
                {
                    break; /* Loop/switch isn't completed */
                }
                context = intent.getStringExtra("icon_pick1");
                String s = intent.getStringExtra("title_pick1");
                String s2 = intent.getStringExtra("short_desc1");
                id_meiri = intent.getStringExtra("id_meiri");
                if (i == 10 && j == 0)
                {
                    try
                    {
                        mNotificationManager8 = (NotificationManager)getSystemService("notification");
                        intent = new Notification();
                        intent.flags = 16;
                        intent.icon = 0x7f0201aa;
                        Object obj1 = new Intent("pick");
                        intent.contentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, ((Intent) (obj1)), 0);
                        obj1 = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030098);
                        ((RemoteViews) (obj1)).setImageViewBitmap(0x7f070351, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(context)).toString()));
                        ((RemoteViews) (obj1)).setTextViewText(0x7f070352, s);
                        ((RemoteViews) (obj1)).setTextViewText(0x7f070353, s2);
                        intent.contentView = ((RemoteViews) (obj1));
                        mNotificationManager8.notify(19, intent);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        return;
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
                String s1;
                String s3;
                String s4;
                if (!context.equals("meiribig"))
                {
                    break MISSING_BLOCK_LABEL_1284;
                }
                context = intent.getStringExtra("short_desc");
                s1 = intent.getStringExtra("title_pick");
                s4 = intent.getStringExtra("img_pick");
                s3 = intent.getStringExtra("icon_pick");
                id_meiribig = intent.getStringExtra("id_meiribig");
                if (i != 22 || j != 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
                Object obj2;
                MobclickAgent.onEvent(getApplicationContext(), "pick_big");
                mNotificationManager9 = (NotificationManager)getSystemService("notification");
                intent = new Intent("pick_big");
                obj2 = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
                intent = (new android.support.v4.app.NotificationCompat.Builder(getApplicationContext())).setAutoCancel(true).setContentText(context).setContentTitle(s1).setDefaults(4).setLargeIcon(BitmapFactory.decodeResource(getResources(), 0x7f0200eb)).setOngoing(false).setTicker(s1).setPriority(2).setSmallIcon(0x7f0200eb, 0);
                intent.setStyle(new android.support.v4.app.NotificationCompat.BigPictureStyle());
                intent = intent.build();
                intent.flags = 16;
                intent.icon = 0x7f0201aa;
                intent.contentIntent = ((PendingIntent) (obj2));
                obj2 = new RemoteViews(getApplication().getPackageName(), 0x7f030099);
                s4 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s4)).toString();
                s3 = (new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s3)).toString();
                ((RemoteViews) (obj2)).setImageViewBitmap(0x7f070358, Myutils.getImage(s4));
                ((RemoteViews) (obj2)).setImageViewBitmap(0x7f070354, Myutils.getImage(s3));
                ((RemoteViews) (obj2)).setTextViewText(0x7f070355, s1);
                ((RemoteViews) (obj2)).setTextViewText(0x7f070357, context);
                if (android.os.Build.VERSION.SDK_INT < 16)
                {
                    break MISSING_BLOCK_LABEL_1275;
                }
                intent.bigContentView = ((RemoteViews) (obj2));
_L5:
                mNotificationManager9.notify(1999, intent);
                return;
                try
                {
                    intent.contentView = ((RemoteViews) (obj2));
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
                  goto _L5
                if (!context.equals("paidppp"))
                {
                    break; /* Loop/switch isn't completed */
                }
                context = intent.getStringExtra("icon0");
                s1 = intent.getStringExtra("icon1");
                s3 = intent.getStringExtra("icon2");
                s4 = intent.getStringExtra("icon3");
                obj2 = intent.getStringExtra("icon4");
                intent = intent.getStringExtra("icon5");
                if (i == 18 && j == 0)
                {
                    try
                    {
                        mNotificationManager2 = (NotificationManager)getSystemService("notification");
                        MobclickAgent.onEvent(getApplicationContext(), "paid");
                        Notification notification = new Notification();
                        notification.flags = 16;
                        notification.icon = 0x7f0200ec;
                        Object obj3 = new Intent("paid");
                        notification.contentIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, ((Intent) (obj3)), 0);
                        obj3 = new RemoteViews(getApplicationContext().getPackageName(), 0x7f030093);
                        ((RemoteViews) (obj3)).setImageViewBitmap(0x7f070337, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(context)).toString()));
                        ((RemoteViews) (obj3)).setImageViewBitmap(0x7f070339, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s1)).toString()));
                        ((RemoteViews) (obj3)).setImageViewBitmap(0x7f07033b, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s3)).toString()));
                        ((RemoteViews) (obj3)).setImageViewBitmap(0x7f07033d, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(s4)).toString()));
                        ((RemoteViews) (obj3)).setImageViewBitmap(0x7f07033f, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(((String) (obj2)))).toString()));
                        ((RemoteViews) (obj3)).setImageViewBitmap(0x7f070341, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(intent)).toString()));
                        notification.contentView = ((RemoteViews) (obj3));
                        mNotificationManager2.notify(54, notification);
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        return;
                    }
                }
                if (true) goto _L4; else goto _L6
_L6:
                if (context.equals("downloadsuccess"))
                {
                    context = intent.getStringExtra("appname");
                    Object obj = intent.getStringExtra("headimage");
                    appid_down = intent.getStringExtra("baoming");
                    serial = intent.getIntExtra("serial", 1);
                    filepathdown = intent.getStringExtra("filepathdown");
                    if (serial == 110)
                    {
                        iddown = intent.getStringExtra("iddown");
                    }
                    ServiceUpdate.mNotificationManager3 = (NotificationManager)getSystemService("notification");
                    notification_down = new Notification();
                    notification_down.flags = 16;
                    notification_down.icon = 0x7f0201a8;
                    intent = new Intent("status_bar_download_success");
                    intent = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
                    notification_down.contentIntent = intent;
                    intent = new RemoteViews(getApplicationContext().getPackageName(), 0x7f03008b);
                    if (serial == 110)
                    {
                        obj = new MyAppInfo(getApplicationContext());
                        try
                        {
                            appNamedown = ((MyAppInfo) (obj)).getAppName(iddown);
                            appIcondown = ((MyAppInfo) (obj)).getAppIcon(iddown);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object obj)
                        {
                            ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
                        }
                        intent.setImageViewBitmap(0x7f070325, ServiceUpdate.drawableToBitmap(appIcondown));
                    } else
                    {
                        intent.setImageViewBitmap(0x7f070325, Myutils.getImage((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append("com.ywh.imgcache").append(File.separator).append("allicon").append(File.separator).append(MD5.enlode(((String) (obj)))).toString()));
                    }
                    intent.setTextViewText(0x7f070326, context);
                    intent.setTextViewText(0x7f070327, "Click to install");
                    notification_down.contentView = intent;
                    ServiceUpdate.mNotificationManager3.notify(13131, notification_down);
                    return;
                }
                if (!context.equals("downloadinstall")) goto _L4; else goto _L7
_L7:
                appidinstall = intent.getStringExtra("appidinstall");
                context = new MyAppInfo(getApplicationContext());
                try
                {
                    appNameinstall = context.getAppName(appidinstall);
                    appIconinstall = context.getAppIcon(appidinstall);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    try
                    {
                        context.printStackTrace();
                    }
                    // Misplaced declaration of an exception variable
                    catch (Context context)
                    {
                        return;
                    }
                }
                mNotificationManager4 = (NotificationManager)getSystemService("notification");
                notification_install = new Notification();
                notification_install.flags = 16;
                notification_install.icon = 0x7f0201a9;
                context = new Intent("status_bar_download_install");
                context = PendingIntent.getBroadcast(getApplicationContext(), 0, context, 0);
                notification_install.contentIntent = context;
                context = new RemoteViews(getApplicationContext().getPackageName(), 0x7f03008b);
                context.setImageViewBitmap(0x7f070325, ServiceUpdate.drawableToBitmap(appIconinstall));
                context.setTextViewText(0x7f070326, appNameinstall);
                context.setTextViewText(0x7f070327, "Click to launch");
                notification_install.contentView = context;
                mNotificationManager4.notify(14141, notification_install);
                return;
            }

            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        };
    }

    public static Bitmap drawableToBitmap(Drawable drawable)
    {
        int i = drawable.getIntrinsicWidth();
        int j = drawable.getIntrinsicHeight();
        Object obj;
        Canvas canvas;
        if (drawable.getOpacity() != -1)
        {
            obj = android.graphics.Bitmap.Config.ARGB_8888;
        } else
        {
            obj = android.graphics.Bitmap.Config.RGB_565;
        }
        obj = Bitmap.createBitmap(i, j, ((android.graphics.Bitmap.Config) (obj)));
        canvas = new Canvas(((Bitmap) (obj)));
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return ((Bitmap) (obj));
    }

    private void getNewApps()
    {
        (new Thread(new Runnable() {

            final ServiceUpdate this$0;

            public void run()
            {
                String s = Uri.encode(Build.MODEL);
                Object obj = new HashMap();
                try
                {
                    ((HashMap) (obj)).put("content", jsonArray.toString());
                    ((HashMap) (obj)).put("ucode", dEVICE_ID);
                    ((HashMap) (obj)).put("os_version", android.os.Build.VERSION.RELEASE);
                    ((HashMap) (obj)).put("source", "aio");
                    ((HashMap) (obj)).put("device", s);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
                upJsonStr = Myutils.doHttpPost("http://android.downloadatoz.com/_201409/market/app_version_check.php", ((HashMap) (obj)));
                Log.e("qaz", (new StringBuilder(String.valueOf(upJsonStr))).toString());
                obj = new Message();
                obj.obj = upJsonStr;
                obj.what = 1001;
                appHandler.sendMessage(((Message) (obj)));
            }

            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        })).start();
    }

    public String HttpGetData()
    {
        String s = null;
        try
        {
            HttpResponse httpresponse = (new DefaultHttpClient()).execute(new HttpGet("http://127.0.0.0"));
            if (httpresponse.getStatusLine().getStatusCode() == 200)
            {
                s = EntityUtils.toString(httpresponse.getEntity());
            }
        }
        catch (Exception exception)
        {
            return null;
        }
        return s;
    }

    public void getAllAppInfo()
    {
        PackageManager packagemanager = getPackageManager();
        List list = packagemanager.getInstalledPackages(0);
        Log.e("qew", (new StringBuilder(String.valueOf(list.size()))).toString());
        jsonArray = new JSONArray();
        new Build();
        new HashMap();
        int i = 0;
        do
        {
            if (i >= list.size())
            {
                Log.e("qew", (new StringBuilder(String.valueOf(mListInfo.size()))).toString());
                Log.e("qew", (new StringBuilder("jsonArray=")).append(jsonArray).toString());
                return;
            }
            JSONObject jsonobject = new JSONObject();
            AppInfo appinfo = new AppInfo();
            PackageInfo packageinfo = (PackageInfo)list.get(i);
            ApplicationInfo applicationinfo = packageinfo.applicationInfo;
            if ((applicationinfo.flags & 1) <= 0)
            {
                String s = packagemanager.getApplicationLabel(applicationinfo).toString();
                String s1 = packageinfo.packageName;
                String s2 = packageinfo.versionName;
                Log.i("appname", (new StringBuilder()).append(packagemanager.getApplicationLabel(applicationinfo)).append(packageinfo.packageName).toString());
                appinfo.setAppname(s);
                appinfo.setP_name(s1);
                appinfo.setAvatar(packagemanager.getApplicationIcon(applicationinfo));
                appinfo.setVersion(s2);
                mListInfo.add(appinfo);
                try
                {
                    jsonobject.put("title", s);
                    jsonobject.put("url_id", s1);
                    jsonobject.put("version", s2);
                    jsonobject.put("install_time", System.currentTimeMillis() / 1000L);
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                }
                jsonArray.put(jsonobject);
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

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        itemsOnClick4 = new android.view.View.OnClickListener() {

            final ServiceUpdate this$0;

            public void onClick(View view)
            {
                switch (view.getId())
                {
                case 2131166057: 
                case 2131166058: 
                default:
                    return;

                case 2131166056: 
                    callerOutDialog1.dismiss();
                    return;

                case 2131166059: 
                    MobclickAgent.onEvent(getApplicationContext(), "simulate_call_click");
                    break;
                }
                if (!AIOCALLERAPK.exists() || getFileSizes(AIOCALLERAPK) < 0x4e87bdL) goto _L2; else goto _L1
_L1:
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                getApplicationContext().startActivity(view);
_L4:
                callerOutDialog1.dismiss();
                return;
_L2:
                if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x4e87bdL)
                {
                    (new AsyncTask() {

                        final _cls5 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            getApplicationContext().startActivity(void1);
                        }

            
            {
                this$1 = _cls5.this;
                super();
            }
                    }).execute(new Void[0]);
                    continue; /* Loop/switch isn't completed */
                }
                try
                {
                    view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    view.putExtra("myid", "com.allinone.callerid");
                    view.addFlags(0x10000000);
                    getApplicationContext().startActivity(view);
                }
                // Misplaced declaration of an exception variable
                catch (View view)
                {
                    view.printStackTrace();
                }
                if (true) goto _L4; else goto _L3
_L3:
            }


            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        };
        (new Timer()).schedule(new TimerTask() {

            final ServiceUpdate this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 100;
                handler.sendMessage(message);
            }

            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        }, 0L, 1000L);
        (new Thread() {

            final ServiceUpdate this$0;

            public void run()
            {
                super.run();
                url1 = "http://android.downloadatoz.com/_201409/market/top_app_list_more.php?tab=es&page=1";
                String s = publicTools.getUrl(url1);
                Message message = new Message();
                message.what = 10;
                message.obj = s;
                handler.sendMessage(message);
            }

            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        }).start();
        (new Thread() {

            final ServiceUpdate this$0;

            public void run()
            {
                super.run();
                StringBuffer stringbuffer;
                Object obj;
                InputStream inputstream;
                InputStreamReader inputstreamreader;
                BufferedReader bufferedreader;
                obj = (HttpURLConnection)(new URL("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1")).openConnection();
                ((HttpURLConnection) (obj)).setRequestMethod("GET");
                ((HttpURLConnection) (obj)).setConnectTimeout(5000);
                ((HttpURLConnection) (obj)).setReadTimeout(5000);
                if (((HttpURLConnection) (obj)).getResponseCode() != 200)
                {
                    break MISSING_BLOCK_LABEL_174;
                }
                inputstream = ((HttpURLConnection) (obj)).getInputStream();
                inputstreamreader = new InputStreamReader(inputstream);
                bufferedreader = new BufferedReader(inputstreamreader);
                stringbuffer = new StringBuffer();
_L1:
                String s = bufferedreader.readLine();
                if (s == null)
                {
                    try
                    {
                        bufferedreader.close();
                        inputstreamreader.close();
                        inputstream.close();
                        ((HttpURLConnection) (obj)).disconnect();
                        obj = handler.obtainMessage();
                        obj.what = 250;
                        obj.obj = stringbuffer.toString();
                        handler.sendMessage(((Message) (obj)));
                        return;
                    }
                    catch (MalformedURLException malformedurlexception)
                    {
                        malformedurlexception.printStackTrace();
                        return;
                    }
                    catch (IOException ioexception)
                    {
                        ioexception.printStackTrace();
                    }
                    break MISSING_BLOCK_LABEL_174;
                }
                stringbuffer.append(s);
                  goto _L1
            }

            
            {
                this$0 = ServiceUpdate.this;
                super();
            }
        }).start();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("update");
        intentfilter.addAction("pick");
        intentfilter.addAction("pick_big");
        intentfilter.addAction("paid");
        intentfilter.addAction("status_bar_download_success");
        intentfilter.addAction("status_bar_download_install");
        registerReceiver(onClickReceiver, intentfilter);
        intentfilter = new IntentFilter();
        intentfilter.addAction("\u53D1\u9001\u5347\u7EA7\u5E7F\u64AD");
        intentfilter.addAction("setbroadUpdate");
        intentfilter.addAction("meiri");
        intentfilter.addAction("meiribig");
        intentfilter.addAction("paidppp");
        intentfilter.addAction("downloadsuccess");
        intentfilter.addAction("downloadinstall");
        registerReceiver(mBroadcastReceiver, intentfilter);
        sharedPreferences = getSharedPreferences("countName_first", 0);
        int i = sharedPreferences.getInt("iFirst1", 0);
        Log.e("qwa", (new StringBuilder("installFirst=")).append(i).toString());
        try
        {
            getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            namenotfoundexception.printStackTrace();
        }
        getAllAppInfo();
        dEVICE_ID = ((TelephonyManager)getSystemService("phone")).getDeviceId();
        Log.e("gog", (new StringBuilder("DEVICE_ID=")).append(dEVICE_ID).append("\u624B\u673A\u578B\u53F7\uFF1A").append(Build.MODEL).toString());
        getNewApps();
    }

    public void onDestroy()
    {
        super.onDestroy();
    }





























































}
