// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.DrawerLayout;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;
import com.aio.downloader.adapter.Home_Listview_Adapter;
import com.aio.downloader.db.TypeDbUtils;
import com.aio.downloader.dialog.AboutCustomDialog;
import com.aio.downloader.dialog.Batterylow;
import com.aio.downloader.dialog.GralleryDialog;
import com.aio.downloader.dialog.LianwangDialog;
import com.aio.downloader.dialog.NointentDialog;
import com.aio.downloader.dialog.NoupdareversionDialog;
import com.aio.downloader.dialog.UpdateDialogVerison;
import com.aio.downloader.dialog.UpdateDialogVerison2;
import com.aio.downloader.dialog.WebFirstDialog;
import com.aio.downloader.floatwindow.FloatWindowService;
import com.aio.downloader.floatwindow.MyFloatService;
import com.aio.downloader.model.AppInfo;
import com.aio.downloader.model.GameInfosVersionModel;
import com.aio.downloader.model.Info;
import com.aio.downloader.mydownload.BaseActivity;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.mydownload.MyApplcation;
import com.aio.downloader.refresh.PullableListView;
import com.aio.downloader.service.BatteryInfoService1;
import com.aio.downloader.service.MyService;
import com.aio.downloader.service.ServiceCleaner;
import com.aio.downloader.service.ServiceGallery;
import com.aio.downloader.service.ServiceToggle;
import com.aio.downloader.service.ServiceUpdate;
import com.aio.downloader.unstall.Unstall;
import com.aio.downloader.utils.MyAppInfo;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.NetWorkUtil;
import com.aio.downloader.utils.ProgressWheel;
import com.aio.downloader.utils.SharedPreferencesConfig;
import com.aio.downloader.utils.Updatesize;
import com.aio.downloader.utils.publicTools;
import com.aio.downloader.views.BadgeView;
import com.aio.downloader.views.LImageButton;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAd;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListener;
import com.thin.downloadmanager.ThinDownloadManager;
import com.umeng.analytics.MobclickAgent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.tsz.afinal.FinalDBChen;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.aio.downloader.activity:
//            WidgeGametActivity, WidgePaidActivity, HexCrushActivity, AppActivity1, 
//            GameActivity1, AppDetailsActivity, AppRecommendKeywordsActivity, DownloadAppManager, 
//            MusthaveActivity, FunActivity1, TodaysPickActivity, PaidforFreeActivity1, 
//            MyDownloaderList, UpdateActivity, AdultActivity1, ExclusiveAppsActivity, 
//            MySettingsActivity, AcquireWebview

public class MyMainActivity extends BaseActivity
    implements android.view.View.OnClickListener, com.aio.downloader.refresh.PullableListView.OnLoadListener, OnDismissCallback, ContentValue, AdListener, InterstitialAdListener
{
    class MyAsyncTaskVersion extends AsyncTask
    {

        private ProgressDialog mProgressDialog;
        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            Object obj;
            Thread.sleep(1000L);
            obj = (HttpURLConnection)(new URL((new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.3.9").toString())).openConnection();
            ((HttpURLConnection) (obj)).setConnectTimeout(5000);
            ((HttpURLConnection) (obj)).setRequestMethod("GET");
            Log.v("ggg", (new StringBuilder(String.valueOf(((HttpURLConnection) (obj)).getResponseCode()))).toString());
            if (((HttpURLConnection) (obj)).getResponseCode() != 200)
            {
                break MISSING_BLOCK_LABEL_212;
            }
            avoid = new StringBuffer();
            obj = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj)).getInputStream()));
_L1:
            String s = ((BufferedReader) (obj)).readLine();
            if (s == null)
            {
                try
                {
                    avoid = new JSONObject(avoid.toString());
                    if (avoid.getInt("status") == 1)
                    {
                        GameInfosVersionModel gameinfosversionmodel = new GameInfosVersionModel();
                        gameinfosversionmodel.setUpdatePath(avoid.getString("update_url"));
                        handlerversion.sendMessage(handlerversion.obtainMessage(564, gameinfosversionmodel));
                    }
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    avoid.printStackTrace();
                }
                break MISSING_BLOCK_LABEL_212;
            }
            avoid.append(s);
              goto _L1
            return null;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Void)obj);
        }

        protected void onPostExecute(Void void1)
        {
            super.onPostExecute(void1);
            if (mProgressDialog != null && mProgressDialog.isShowing())
            {
                mProgressDialog.dismiss();
                mProgressDialog = null;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            mProgressDialog = ProgressDialog.show(MyMainActivity.this, null, "Loading......");
        }

        MyAsyncTaskVersion()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("jone", "download completed");
            Notification notification = new Notification();
            notification.flags = 16;
            notification.icon = 0x7f0200eb;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOUPDATEFILE).append(File.separator).append("aioupdate.apk").toString()), "application/vnd.android.package-archive");
            notification.contentIntent = PendingIntent.getActivity(MyMainActivity.this, 231, intent, 0x8000000);
            notification.contentView = new RemoteViews(getPackageName(), 0x7f03008e);
            mNotificationManager8.notify(231, notification);
            updateaioApk();
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.i("jone", "DownloadFailed");
            if (i == downloadId1)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.i("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId1)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner_Caller
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("jone", "download caller completed");
            Myutils.copyfile(AIOCALLERDOWN, AIOCALLERAPK, Boolean.valueOf(false));
            Intent intent = new Intent("diyicianzhuang");
            sendBroadcast(intent);
            try
            {
                Log.e("caller", (new StringBuilder("caller=")).append(getFileSizes(AIOCALLERDOWN)).toString());
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.e("jone", "DownloadFailed");
            if (i == downloadId_caller)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId_caller)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner_Caller()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner_battery
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("battery", "download battery completed");
            try
            {
                Log.e("battery", (new StringBuilder("===")).append(getFileSizes(AIOBATTERY)).toString());
            }
            catch (Exception exception) { }
            Myutils.copyfile(AIOBATTERY, AIOBATTERYAPK, Boolean.valueOf(false));
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.e("jone", "DownloadFailed");
            if (i == downloadId_battery)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId_battery)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner_battery()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner_cleaner
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("jone", "download cleaner completed");
            Myutils.copyfile(AIOCLEANERDOWN, AIOCLEANERAPK, Boolean.valueOf(false));
            Intent intent = new Intent("diyicianzhuang");
            sendBroadcast(intent);
            try
            {
                Log.e("cleaner", (new StringBuilder("cleaner=")).append(getFileSizes(AIOCLEANERDOWN)).toString());
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.e("jone", "DownloadFailed");
            if (i == downloadId_cleaner)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId_cleaner)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner_cleaner()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner_crush
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("jone", "download crush completed");
            Myutils.copyfile(AIOCRUSHSWF, AIOCRUSHAPK, Boolean.valueOf(false));
            try
            {
                Log.e("crush", (new StringBuilder("crush=")).append(getFileSizes(AIOCRUSHSWF)).toString());
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.e("jone", "DownloadFailed");
            if (i == downloadId_crush)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId_crush)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner_crush()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner_free
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("jone", "download free completed");
            Myutils.copyfile(AIOFREE, AIOFREEAPK, Boolean.valueOf(false));
            try
            {
                Log.e("jone", (new StringBuilder("free=")).append(getFileSizes(AIOFREE)).toString());
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.e("jone", "DownloadFailed");
            if (i == downloadId_free)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId_free)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner_free()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class MyDownloadListner_gallery
        implements DownloadStatusListener
    {

        final MyMainActivity this$0;

        public void onDownloadComplete(int i)
        {
            Log.e("jone", "download gallery completed");
            Myutils.copyfile(AIOGALLERY, AIOGALLERYAPK, Boolean.valueOf(false));
            try
            {
                Log.e("gallery", (new StringBuilder("gallery=")).append(getFileSizes(AIOGALLERY)).toString());
                return;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        public void onDownloadFailed(int i, int j, String s)
        {
            Log.e("jone", "DownloadFailed");
            if (i == downloadId_gallery)
            {
                mProgress1.setProgress(0);
            }
        }

        public void onProgress(int i, long l, long l1, int j)
        {
            Log.e("jone", (new StringBuilder(String.valueOf(j))).toString());
            if (i == downloadId_gallery)
            {
                mProgress1.setProgress(j);
            }
        }

        MyDownloadListner_gallery()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya1 extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient ArrayList doInBackground(Void avoid[])
        {
            String s = null;
            avoid = publicTools.getUrl(recommendurl);
label0:
            {
                s = avoid;
                if (avoid == null)
                {
                    return null;
                }
                break label0;
            }
            avoid;
            list2 = new ArrayList();
            if (s == null) goto _L2; else goto _L1
_L1:
            avoid = new JSONObject(s);
            if (avoid.getInt("status") != 1) goto _L2; else goto _L3
_L3:
            ppmodel = new DownloadMovieItem();
            int i;
            int j;
            try
            {
                if (run_time == 1 && !avoid.isNull("pdt"))
                {
                    JSONObject jsonobject = avoid.getJSONObject("pdt");
                    ppmodel.setId(jsonobject.getString("id"));
                    ppmodel.setIcon(jsonobject.getString("icon"));
                    ppmodel.setTitle(jsonobject.getString("title"));
                    ppmodel.setAuthor_title(jsonobject.getString("author_title"));
                    ppmodel.setShort_desc(jsonobject.getString("short_desc"));
                    ppmodel.setRating(Float.valueOf(Float.parseFloat(jsonobject.getString("rating"))));
                    ppmodel.setSerial(jsonobject.getInt("serial"));
                    ppmodel.setHas_apk(jsonobject.getString("has_apk"));
                    ppmodel.setIs_official(jsonobject.getString("is_official"));
                }
            }
            catch (Exception exception) { }
            avoid = avoid.getJSONArray("list");
            i = 0;
_L5:
            j = avoid.length();
            if (i < j) goto _L4; else goto _L2
_L2:
            return list2;
_L4:
            DownloadMovieItem downloadmovieitem = new DownloadMovieItem();
            JSONObject jsonobject1 = avoid.getJSONObject(i);
            downloadmovieitem.setId(jsonobject1.getString("id"));
            downloadmovieitem.setSerial(jsonobject1.getInt("serial"));
            downloadmovieitem.setTitle(jsonobject1.getString("title"));
            downloadmovieitem.setAuthor_title(jsonobject1.getString("author_title"));
            downloadmovieitem.setIcon(jsonobject1.getString("icon"));
            downloadmovieitem.setSize(jsonobject1.getString("size"));
            downloadmovieitem.setRating(Float.valueOf(Float.parseFloat(jsonobject1.getString("rating"))));
            downloadmovieitem.setPrice(jsonobject1.getString("price"));
            downloadmovieitem.setHas_apk(jsonobject1.getString("has_apk"));
            downloadmovieitem.setIs_official(jsonobject1.getString("is_official"));
            list2.add(downloadmovieitem);
            i++;
              goto _L5
            avoid;
            avoid.printStackTrace();
              goto _L2
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((ArrayList)obj);
        }

        protected void onPostExecute(ArrayList arraylist)
        {
            super.onPostExecute(arraylist);
            if (arraylist != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            if (run_time != 1) goto _L1; else goto _L3
_L3:
            TextView textview;
            Button button;
            Button button1;
            Object obj;
            MobclickAgent.onEvent(getApplicationContext(), "web_caller");
            obj = new WebFirstDialog(MyMainActivity.this, 0x7f0c000e);
            ((WebFirstDialog) (obj)).setCanceledOnTouchOutside(true);
            ((WebFirstDialog) (obj)).show();
            arraylist = (ImageView)((WebFirstDialog) (obj)).findViewById(0x7f070369);
            textview = (TextView)((WebFirstDialog) (obj)).findViewById(0x7f070371);
            button = (Button)((WebFirstDialog) (obj)).findViewById(0x7f070376);
            button1 = (Button)((WebFirstDialog) (obj)).findViewById(0x7f070377);
            ((ImageView)((WebFirstDialog) (obj)).findViewById(0x7f070378)).setOnClickListener(((_cls1) (obj)). new android.view.View.OnClickListener() {

                final Mya1 this$1;
                private final WebFirstDialog val$dialog1;

                public void onClick(View view)
                {
                    dialog1.dismiss();
                }

            
            {
                this$1 = final_mya1;
                dialog1 = WebFirstDialog.this;
                super();
            }
            });
            ((CheckBox)((WebFirstDialog) (obj)).findViewById(0x7f070379)).setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

                final Mya1 this$1;

                public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
                {
                    if (flag)
                    {
                        callerD = false;
                        return;
                    } else
                    {
                        callerD = true;
                        return;
                    }
                }

            
            {
                this$1 = Mya1.this;
                super();
            }
            });
            button.setOnClickListener(((_cls3) (obj)). new android.view.View.OnClickListener() {

                final Mya1 this$1;
                private final WebFirstDialog val$dialog1;

                public void onClick(View view)
                {
                    if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(_fld0) != 1)
                    {
                        downwifi();
                        return;
                    }
                    if (dbUtils.queryfile(ppmodel.getId()) == null)
                    {
                        MydownloadApk(ppmodel.getId(), ppmodel.getTitle(), ppmodel.getIcon(), ppmodel.getSerial());
                    } else
                    {
                        Mydialog();
                    }
                    if (callerD)
                    {
                        if (dbUtils.queryfile("com.freepezzle.hexcrush") == null)
                        {
                            MobclickAgent.onEvent(getApplicationContext(), "web_caller_click");
                            MydownloadApk("com.freepezzle.hexcrush", "HEX Crush", "http://android.downloadatoz.com/_201409/img/hex512.png", 8964);
                        } else
                        {
                            Mydialog();
                        }
                    }
                    dialog1.dismiss();
                }

            
            {
                this$1 = final_mya1;
                dialog1 = WebFirstDialog.this;
                super();
            }
            });
            button1.setOnClickListener(((_cls4) (obj)). new android.view.View.OnClickListener() {

                final Mya1 this$1;
                private final WebFirstDialog val$dialog1;

                public void onClick(View view)
                {
                    view = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder("https://play.google.com/store/apps/details?id=")).append(ppmodel.getId()).toString()));
                    startActivity(view);
                    dialog1.dismiss();
                }

            
            {
                this$1 = final_mya1;
                dialog1 = WebFirstDialog.this;
                super();
            }
            });
            obj = ppmodel.getHas_apk();
            if (!((String) (obj)).equals("1")) goto _L5; else goto _L4
_L4:
            button.setVisibility(0);
_L7:
            app.asyncLoadImage(ppmodel.getIcon(), arraylist);
            textview.setText(ppmodel.getTitle());
            return;
_L5:
            if (((String) (obj)).equals("0"))
            {
                button1.setVisibility(0);
            }
            if (true) goto _L7; else goto _L6
_L6:
            arraylist;
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }


        Mya1()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya2 extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=home&page=")).append(page).toString();
            Log.e("fuck", (new StringBuilder("url=")).append(avoid).toString());
            return publicTools.getUrl(avoid);
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
                ShowResult(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya2()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya3 extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl("http://welaf.com/fun/list.php?recommend=1&page=1");
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
                ShowResult1(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya3()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya4 extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            return publicTools.getUrl("http://welaf.com/fun/list.php?tab=random&page=1");
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
                ShowResult2(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya4()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya5 extends AsyncTask
    {

        final MyMainActivity this$0;
        private String url1;

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
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya6 extends AsyncTask
    {

        final MyMainActivity this$0;
        private String url1;

        private void ShowResult7(String s)
        {
            list_update.addAll(Myutils.parseupdata(s));
            if (Myutils.status == 1)
            {
                try
                {
                    Log.e("llt", (new StringBuilder(String.valueOf(list_update.size()))).toString());
                    showup = (int)(Math.random() * (double)list_update.size());
                }
                // Misplaced declaration of an exception variable
                catch (String s) { }
                ll_updata.setVisibility(8);
                s = new MyAppInfo(getApplicationContext());
                try
                {
                    appName = s.getAppName(((DownloadMovieItem)list_update.get(showup)).getId());
                    appVersion = s.getAppVersion(((DownloadMovieItem)list_update.get(showup)).getId());
                    appIcon = s.getAppIcon(((DownloadMovieItem)list_update.get(showup)).getId());
                    iv_updata.setBackgroundDrawable(appIcon);
                    tv_updata_name.setText(appName);
                    tv_current_version.setText(appVersion);
                    tv_updata_version.setText(((DownloadMovieItem)list_update.get(showup)).getVersion());
                    tv_updata_size.setText(((DownloadMovieItem)list_update.get(showup)).getSize());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                }
                return;
            } else
            {
                ll_updata.setVisibility(8);
                return;
            }
        }

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            Log.e("upJsonStr", (new StringBuilder(String.valueOf(upJsonStr))).append("===").toString());
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
                Log.e("asd1", (new StringBuilder("result=")).append(s).toString());
                ShowResult7(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        Mya6()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }

    class Mya_rush extends AsyncTask
    {

        final MyMainActivity this$0;

        protected volatile transient Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            Log.e("fuck", (new StringBuilder("url=")).append("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=home&page=1").toString());
            return publicTools.getUrl("http://android.downloadatoz.com/_201409/market/app_list_recommend.php?tab=home&page=1");
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
                ShowResult(s);
                return;
            }
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
            progressWheel.setVisibility(0);
        }

        Mya_rush()
        {
            this$0 = MyMainActivity.this;
            super();
        }
    }


    private static final int DOWNLOAD_THREAD_POOL_SIZE = 4;
    private static final String FILE1 = "http://apk.downloadatoz.com/package/com.allinone.free.apk";
    private static final String FILE_BATTERY = "http://apktop.downloadatoz.com/upload_swf/com.freeapp.batterysaver.swf";
    private static final String FILE_CALLER = "http://apktop.downloadatoz.com/upload_swf/com.allinone.callerid.swf";
    private static final String FILE_CLEANER = "http://apktop.downloadatoz.com/upload_swf/com.evzapp.cleanmaster.swf";
    private static final String FILE_CRUSH = "http://apktop.downloadatoz.com/upload_swf/com.freepezzle.hexcrush.swf";
    private static final String FILE_FREE = "http://apktop.downloadatoz.com/upload_swf/com.osamahq.freestore.swf";
    private static final String FILE_GALLERY = "http://apktop.downloadatoz.com/upload_swf/com.androidapp.gallary3d.swf";
    public static final int UPDATE_TAG = 564;
    public static DrawerLayout mDrawerLayout;
    private final String ACTION_NAME = "\u53D1\u9001\u5E7F\u64AD";
    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOCLEANERAPK;
    private File AIOCLEANERDOWN;
    private File AIOCRUSHAPK;
    private File AIOCRUSHSWF;
    private File AIOFREE;
    private File AIOFREEAPK;
    private File AIOGALLERY;
    private File AIOGALLERYAPK;
    private File AIOUPDATEFILE;
    private File AIOUPDATEFILE1;
    private File AIOUPDATEFILE2;
    private final String FIRST = "diyicianzhuang";
    private final String PAIDPPP = "paidppp";
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private Intent aa_app;
    private Intent aa_change;
    private Intent aa_lev;
    private Intent aa_temp;
    private String acquire_url_start;
    private Home_Listview_Adapter adapter;
    private Intent aio_intent;
    private String apkname;
    private String apkname_google;
    private String apkname_mp3;
    private String apkname_mp4;
    private MyApplcation app;
    private Handler appHandler;
    private Drawable appIcon;
    private String appName;
    private String appVersion;
    private LinearLayout appbanner;
    private String appid;
    private LinearLayout appline;
    private ImageView apptopgift;
    private BadgeView badgedownimg;
    private BadgeView badgedowntv;
    private TextView badgetv;
    private String banner_type_name;
    private Batterylow batterylow;
    boolean callerD;
    private String dEVICE_ID;
    private LinearLayout datingline;
    private FinalDBChen db;
    private TypeDbUtils dbUtils;
    private HashMap default_options;
    private int downloadId1;
    private int downloadId_battery;
    private int downloadId_caller;
    private int downloadId_cleaner;
    private int downloadId_crush;
    private int downloadId_free;
    private int downloadId_gallery;
    private ThinDownloadManager downloadManager;
    private ThinDownloadManager downloadManager_battery;
    private ThinDownloadManager downloadManager_caller;
    private ThinDownloadManager downloadManager_cleaner;
    private ThinDownloadManager downloadManager_crush;
    private ThinDownloadManager downloadManager_free;
    private ThinDownloadManager downloadManager_gallery;
    private RelativeLayout downrelelativetv;
    private LImageButton drawerButtonLeft;
    private List ds;
    android.content.SharedPreferences.Editor editor;
    private LinearLayout gameline;
    private GralleryDialog gralleryDialog;
    Handler handler;
    Handler handlertimer;
    Handler handlerversion;
    Handler handlerversoin;
    private LinearLayout havetryline;
    private BroadcastReceiver hidehomeapp;
    private BroadcastReceiver homeapp;
    private String icon_pick;
    private String icon_pick1;
    private String id;
    private String id_meiri;
    private String id_meiribig;
    private String img_pick;
    public int in_control;
    GameInfosVersionModel info;
    private Info info2;
    private List infos;
    private List infos2;
    private Intent intent_float;
    private InterstitialAd interstitialAd;
    private boolean isfbshow;
    private android.view.View.OnClickListener itemsOnClick;
    android.view.View.OnClickListener itemsOnClick2;
    private ImageView iv_fb_fragment;
    private ImageView iv_tianchi;
    private ImageView iv_tianchi1;
    private ImageView iv_tianchi2;
    private ImageView iv_tianchi3;
    private ImageView iv_tianchi4;
    private ImageView iv_tianchi5;
    private ImageView iv_tianchi6;
    private ImageView iv_tianchi7;
    private ImageView iv_tianchi8;
    private ImageView iv_tianchi9;
    private ImageView iv_updata;
    private ImageView iv_updata_bt;
    private JSONArray jsonArray;
    private ArrayList list;
    private ArrayList list2;
    ArrayList list3;
    private PullableListView listView;
    ArrayList list_fun;
    ArrayList list_fun_app;
    ArrayList list_pick;
    private ArrayList list_update;
    private LinearLayout ll_updata;
    private BroadcastReceiver load_more;
    private android.view.ViewGroup.LayoutParams lp;
    private ImageView mAnimImageView;
    private Animation mAnimation;
    private View mLeftGravityView;
    public List mListInfo;
    private NotificationManager mNotificationManager8;
    private ProgressBar mProgress1;
    private int mRandom;
    private RelativeLayout main_tab_top;
    private MyDownloadListner myDownloadStatusListener;
    private MyDownloadListner_battery myDownloadStatusListener_battery;
    private MyDownloadListner_Caller myDownloadStatusListener_caller;
    private MyDownloadListner_cleaner myDownloadStatusListener_cleaner;
    private MyDownloadListner_crush myDownloadStatusListener_crush;
    private MyDownloadListner_free myDownloadStatusListener_free;
    private MyDownloadListner_gallery myDownloadStatusListener_gallery;
    private Intent myIntent;
    private Intent myIntent2;
    private NativeAd nativeAd;
    private NativeAd nativeAdfb;
    private String newVersionUrl;
    private int next;
    private Notification notification_app;
    private Notification notification_change;
    private Notification notification_lev;
    private Notification notification_ram;
    private Notification notification_temp;
    private BroadcastReceiver numbertip;
    PackageInfo packageInfo;
    private int page;
    private LinearLayout paidline;
    private int pen_mem;
    private RelativeLayout playnowline;
    private DownloadMovieItem ppmodel;
    private ProgressWheel progressWheel;
    private publicTools publictools;
    private String recommendurl;
    private int record;
    private DownloadRequest request1;
    private DownloadRequest request_battery;
    private DownloadRequest request_caller;
    private DownloadRequest request_cleaner;
    private DownloadRequest request_crush;
    private DownloadRequest request_free;
    private DownloadRequest request_gallery;
    private int run_time;
    private String s2;
    SharedPreferences sharedPreferences;
    private String short_desc;
    private String short_desc1;
    private BroadcastReceiver showhomeapp;
    private int showup;
    private SharedPreferences sp_config;
    private SharedPreferences spnetworkre;
    public int status;
    private SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;
    private LImageButton tab_app;
    private LImageButton tab_down;
    private LImageButton tab_game;
    private RadioGroup tab_group;
    private LImageButton tab_search;
    private String title_pick;
    private String title_pick1;
    private String todayid;
    private TextView tv_current_version;
    private TextView tv_updata_name;
    private TextView tv_updata_size;
    private TextView tv_updata_version;
    private Typeface typeFace;
    private String upJsonStr;
    private UpdateDialogVerison updateDialog;
    UpdateDialogVerison updateDialogVersion;
    UpdateDialogVerison2 updateDialogVersion2;
    private String urlPath;
    private String urlPath_battery;
    private String urlPath_caller;
    private String urlPath_cleaner;
    private String urlPath_crush;
    private String urlPath_free;
    private String urlPath_gallery;
    private String url_id;
    private String version;
    private View view_kong;
    private boolean windowFocus;
    private int wuyule;

    public MyMainActivity()
    {
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        mRandom = 0;
        myDownloadStatusListener = new MyDownloadListner();
        myDownloadStatusListener_battery = new MyDownloadListner_battery();
        myDownloadStatusListener_free = new MyDownloadListner_free();
        myDownloadStatusListener_gallery = new MyDownloadListner_gallery();
        myDownloadStatusListener_cleaner = new MyDownloadListner_cleaner();
        myDownloadStatusListener_caller = new MyDownloadListner_Caller();
        myDownloadStatusListener_crush = new MyDownloadListner_crush();
        downloadId1 = 0;
        downloadId_battery = 0;
        downloadId_free = 0;
        downloadId_gallery = 0;
        downloadId_cleaner = 0;
        downloadId_caller = 0;
        downloadId_crush = 0;
        mListInfo = new ArrayList();
        callerD = true;
        appHandler = new Handler() {

            final MyMainActivity this$0;

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
                (new Mya6()).execute(new Void[0]);
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        handlerversion = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what != 564) goto _L2; else goto _L1
_L1:
                message = (GameInfosVersionModel)message.obj;
                newVersionUrl = message.getUpdatePath();
                if (newVersionUrl.equals(""))
                {
                    break MISSING_BLOCK_LABEL_168;
                }
                if (!AIOUPDATEFILE2.exists()) goto _L4; else goto _L3
_L3:
                Log.e("bbb", "exists___exists");
                updateaioApk1();
_L2:
                return;
_L4:
                Log.e("bbb", "unexists___unexists");
                (new AsyncTask() {

                    final _cls2 this$1;

                    protected volatile transient Object doInBackground(Object aobj[])
                    {
                        return doInBackground((Void[])aobj);
                    }

                    protected transient Void doInBackground(Void avoid[])
                    {
                        return null;
                    }

                    protected volatile void onPostExecute(Object obj)
                    {
                        onPostExecute((Void)obj);
                    }

                    protected void onPostExecute(Void void1)
                    {
                        super.onPostExecute(void1);
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                }).execute(new Void[0]);
                if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
                {
                    downwifi();
                    return;
                }
                if (dbUtils.queryfile("com.allinone.downloader") != null) goto _L2; else goto _L5
_L5:
                MydownloadApk1("com.allinone.downloader", "AIO Downloader", "http://img.android.downloadatoz.com/upload/android/other/201504/03/all-in-one-downloader-downloader-pn-1428055219.jpg", 0x2488ef);
                return;
                message = new NoupdareversionDialog(MyMainActivity.this, 0x7f0c000e);
                message.setCanceledOnTouchOutside(false);
                message.show();
                ((TextView)message.findViewById(0x7f070140)).setText("Current version: 3.3.9 is the latest version.");
                ((Button)message.findViewById(0x7f07034d)).setOnClickListener(message. new android.view.View.OnClickListener() {

                    final _cls2 this$1;
                    private final NoupdareversionDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$1 = final__pcls2;
                dialog = NoupdareversionDialog.this;
                super();
            }
                });
                return;
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        load_more = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                (new Mya_rush()).execute(new Void[0]);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        homeapp = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                try
                {
                    db = new FinalDBChen(MyMainActivity.this, getDatabasePath("download2.db").getAbsolutePath());
                    ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
                    (new AsyncTask() {

                        final _cls4 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient String doInBackground(Void avoid[])
                        {
                            return String.valueOf(ds.size());
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((String)obj);
                        }

                        protected void onPostExecute(String s)
                        {
                            super.onPostExecute(s);
                            badgedownimg.setText(s);
                            badgedownimg.show();
                            badgedowntv.setText(String.valueOf(s));
                            badgedowntv.show();
                        }

            
            {
                this$1 = _cls4.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    return;
                }
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        showhomeapp = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        hidehomeapp = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        windowFocus = false;
        newVersionUrl = "";
        updateDialogVersion = null;
        updateDialogVersion2 = null;
        sp_config = null;
        banner_type_name = "";
        list_fun = new ArrayList();
        list_fun_app = new ArrayList();
        list_pick = new ArrayList();
        list_update = Updatesize.getUpdatesize().list_update;
        infos2 = new ArrayList();
        handlerversoin = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.what == 564 && windowFocus)
                {
                    info = (GameInfosVersionModel)message.obj;
                    message = info.getNtId();
                    newVersionUrl = info.getUpdatePath();
                    if (!newVersionUrl.equals(""))
                    {
                        Log.v("version", "777777");
                        android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                            final _cls7 this$1;

                            public void onClick(View view)
                            {
                                switch (view.getId())
                                {
                                default:
                                    return;

                                case 2131165527: 
                                    updateDialogVersion.dismiss();
                                    return;

                                case 2131165528: 
                                    view = new Intent("android.intent.action.VIEW", Uri.parse(newVersionUrl));
                                    break;
                                }
                                updateDialogVersion.dismiss();
                                startActivity(view);
                            }

            
            {
                this$1 = _cls7.this;
                super();
            }
                        };
                        updateDialogVersion = new UpdateDialogVerison(MyMainActivity.this, 0x7f0c0010, onclicklistener);
                        updateDialogVersion.setCanceledOnTouchOutside(false);
                        try
                        {
                            updateDialogVersion.setTvTitle((new StringBuilder("Update Time: ")).append(Myutils.timezhuanhua(System.currentTimeMillis())).append(DateFormat.format(" dd, yyyy", System.currentTimeMillis())).toString());
                        }
                        catch (Exception exception) { }
                    }
                    if (message != null && !"".equals(message))
                    {
                        try
                        {
                            packageInfo = getPackageManager().getPackageInfo(message, 0);
                        }
                        // Misplaced declaration of an exception variable
                        catch (Message message)
                        {
                            packageInfo = null;
                            message.printStackTrace();
                        }
                        message = info.getNtPath();
                        if (packageInfo == null && message != null && !"".equals(message))
                        {
                            itemsOnClick2 = message. new android.view.View.OnClickListener() {

                                final _cls7 this$1;
                                private final String val$ntPath;

                                public void onClick(View view)
                                {
                                    switch (view.getId())
                                    {
                                    default:
                                        return;

                                    case 2131165530: 
                                        updateDialogVersion2.dismiss();
                                        return;

                                    case 2131165531: 
                                        view = new Intent("android.intent.action.VIEW", Uri.parse(ntPath));
                                        break;
                                    }
                                    updateDialogVersion2.dismiss();
                                    startActivity(view);
                                }

            
            {
                this$1 = final__pcls7;
                ntPath = String.this;
                super();
            }
                            };
                            message = new Message();
                            message.what = 10000;
                            handlertimer.sendMessageDelayed(message, 5000L);
                            Log.v("ppp", "10000");
                        }
                    }
                }
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        handlertimer = new Handler() {

            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                message.what;
                JVM INSTR lookupswitch 2: default 32
            //                           20: 230
            //                           10000: 38;
                   goto _L1 _L2 _L3
_L1:
                super.handleMessage(message);
                return;
_L3:
                try
                {
                    if (System.currentTimeMillis() - Myutils.setting_json.getLong("neitui_time") > 0x2932e00L)
                    {
                        updateDialogVersion2 = new UpdateDialogVerison2(MyMainActivity.this, 0x7f0c0010, itemsOnClick2);
                        updateDialogVersion2.setCanceledOnTouchOutside(false);
                        updateDialogVersion2.show();
                        updateDialogVersion2.setTvTitle(info.getNtTitle());
                        updateDialogVersion2.setTvContent(info.getNtMsg());
                        updateDialogVersion2.setImgIcon(info.getPicPath());
                        Myutils.setting_json.put("neitui_time", System.currentTimeMillis());
                        Myutils.saveSetting();
                    }
                }
                catch (JSONException jsonexception)
                {
                    jsonexception.printStackTrace();
                    try
                    {
                        Myutils.setting_json.put("neitui_time", System.currentTimeMillis());
                        Myutils.saveSetting();
                    }
                    catch (JSONException jsonexception1)
                    {
                        jsonexception1.printStackTrace();
                    }
                    (new AsyncTask() {

                        final _cls8 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(40000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
                            }
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                            updateDialogVersion2 = new UpdateDialogVerison2(_fld0, 0x7f0c0010, itemsOnClick2);
                            updateDialogVersion2.setCanceledOnTouchOutside(false);
                            updateDialogVersion2.show();
                            updateDialogVersion2.setTvTitle(info.getNtTitle());
                            updateDialogVersion2.setTvContent(info.getNtMsg());
                            updateDialogVersion2.setImgIcon(info.getPicPath());
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    }).execute(new Void[0]);
                }
                continue; /* Loop/switch isn't completed */
_L2:
                if (windowFocus)
                {
                    (new AsyncTask() {

                        final _cls8 this$1;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            try
                            {
                                Thread.sleep(20000L);
                            }
                            // Misplaced declaration of an exception variable
                            catch (Void avoid[])
                            {
                                avoid.printStackTrace();
                            }
                            return null;
                        }

                        protected volatile void onPostExecute(Object obj)
                        {
                            onPostExecute((Void)obj);
                        }

                        protected void onPostExecute(Void void1)
                        {
                            super.onPostExecute(void1);
                        }

            
            {
                this$1 = _cls8.this;
                super();
            }
                    }).execute(new Void[0]);
                }
                if (true) goto _L1; else goto _L4
_L4:
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        numbertip = new BroadcastReceiver() {

            final MyMainActivity this$0;

            public void onReceive(Context context, Intent intent)
            {
                progressWheel.setVisibility(8);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
            }

            
            {
                this$0 = MyMainActivity.this;
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
            private String price0;
            private String price1;
            private String price2;
            private String price3;
            private String price4;
            private String price5;
            private String price6;
            final MyMainActivity this$0;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
                message.what;
                JVM INSTR lookupswitch 8: default 84
            //                           1: 85
            //                           2: 99
            //                           3: 107
            //                           4: 200
            //                           5: 277
            //                           250: 354
            //                           297: 871
            //                           30000: 798;
                   goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9
_L1:
                return;
_L2:
                Toast.makeText(MyMainActivity.this, "Failed to connect server.", 0).show();
                return;
_L3:
                Mydialog();
                return;
_L4:
                Toast.makeText(MyMainActivity.this, (new StringBuilder("'")).append(ppmodel.getTitle()).append("' is added to download queue.").toString(), 0).show();
                message = new Intent();
                message.setAction("homeapp");
                sendBroadcast(message);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
                return;
_L5:
                message = new Intent();
                message.setAction("homeapp");
                sendBroadcast(message);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
                message = new Intent(getApplicationContext(), com/aio/downloader/activity/MyDownloaderList);
                startActivity(message);
                return;
_L6:
                message = new Intent();
                message.setAction("homeapp");
                sendBroadcast(message);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
                message = new Intent(getApplicationContext(), com/aio/downloader/activity/MyDownloaderList);
                startActivity(message);
                return;
_L7:
                message = message.obj.toString();
                try
                {
                    message = new JSONObject(message);
                    message.getInt("has_next_page");
                    if (message.getInt("status") == 1)
                    {
                        message = message.getJSONArray("list");
                        JSONObject jsonobject = message.getJSONObject(0);
                        icon0 = jsonobject.getString("icon");
                        price0 = jsonobject.getString("price");
                        app.asyncLoadImage(icon0, iv_tianchi6);
                        jsonobject = message.getJSONObject(1);
                        icon1 = jsonobject.getString("icon");
                        price1 = jsonobject.getString("price");
                        app.asyncLoadImage(icon1, iv_tianchi1);
                        jsonobject = message.getJSONObject(2);
                        icon2 = jsonobject.getString("icon");
                        price2 = jsonobject.getString("price");
                        app.asyncLoadImage(icon2, iv_tianchi2);
                        jsonobject = message.getJSONObject(3);
                        icon3 = jsonobject.getString("icon");
                        price3 = jsonobject.getString("price");
                        app.asyncLoadImage(icon3, iv_tianchi3);
                        jsonobject = message.getJSONObject(4);
                        icon4 = jsonobject.getString("icon");
                        price4 = jsonobject.getString("price");
                        app.asyncLoadImage(icon4, iv_tianchi4);
                        jsonobject = message.getJSONObject(5);
                        icon5 = jsonobject.getString("icon");
                        price5 = jsonobject.getString("price");
                        app.asyncLoadImage(icon5, iv_tianchi5);
                        jsonobject = message.getJSONObject(6);
                        icon6 = jsonobject.getString("icon");
                        price6 = jsonobject.getString("price");
                        app.asyncLoadImage(icon5, iv_tianchi7);
                        message = message.getJSONObject(7);
                        message.getString("icon");
                        message.getString("price");
                        app.asyncLoadImage(icon5, iv_tianchi8);
                        (new Timer()).schedule(new TimerTask() {

                            final _cls10 this$1;

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
                this$1 = _cls10.this;
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
_L9:
                if (System.currentTimeMillis() > SharedPreferencesConfig.GetClickTime(getApplicationContext()))
                {
                    SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
                    apptopgift.setImageResource(0x7f0200d8);
                    message = AnimationUtils.loadAnimation(getApplicationContext(), 0x7f04001e);
                    apptopgift.startAnimation(message);
                    return;
                }
                if (true) goto _L1; else goto _L8
_L8:
                Toast.makeText(MyMainActivity.this, "'AIO Downloader' is added to download queue.", 0).show();
                message = new Intent();
                message.setAction("homeapp");
                sendBroadcast(message);
                mAnimImageView.setVisibility(0);
                mAnimImageView.startAnimation(mAnimation);
                return;
            }








            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        };
        progressWheel = null;
        url_id = "";
        recommendurl = "";
        run_time = 1;
        typeFace = null;
        dbUtils = null;
        publictools = null;
        list = new ArrayList();
        page = 1;
        next = 1;
        infos = new ArrayList();
        AIOUPDATEFILE = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOUPDATE").toString());
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        AIOGALLERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.swf").toString());
        AIOGALLERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.apk").toString());
        AIOCLEANERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("cleaner.swf").toString());
        AIOCLEANERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("cleaner.apk").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        AIOCRUSHSWF = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.swf").toString());
        AIOCRUSHAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("crush.apk").toString());
        AIOFREE = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("freestore.swf").toString());
        AIOFREEAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("freestore.apk").toString());
        AIOUPDATEFILE1 = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOUPDATE").append(File.separator).append("aioupdate.apk").toString());
        AIOUPDATEFILE2 = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/com.aio.downloader").append(File.separator).append("com.allinone.downloader.apk").toString());
        acquire_url_start = "";
        list3 = new ArrayList();
        isfbshow = false;
    }

    private void Mydialog()
    {
        (new android.app.AlertDialog.Builder(this)).setTitle(getString(0x7f0b0034)).setMessage("It has been in downloading list already.").setPositiveButton("Ok", new android.content.DialogInterface.OnClickListener() {

            final MyMainActivity this$0;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        }).show();
    }

    private void Recommed_Url()
    {
        try
        {
            InputStream inputstream = getResources().openRawResource(0x7f050000);
            byte abyte0[] = new byte[inputstream.available()];
            inputstream.read(abyte0);
            inputstream.close();
            url_id = new String(abyte0);
            recommendurl = (new StringBuilder("http://android.downloadatoz.com/_201409/market/recommend_list_more.php?id=")).append(url_id).toString();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void ShowResult(String s)
    {
        list.addAll(Myutils.parsefeatured(s));
        Log.e("eee", (new StringBuilder("page=")).append(page).toString());
        adapter = new Home_Listview_Adapter(this, list, "homefeatured", list_fun);
        if (page == 1)
        {
            swingBottomInAnimationAdapter = new SwingBottomInAnimationAdapter(adapter);
            swingBottomInAnimationAdapter.setListView(listView);
            listView.setAdapter(swingBottomInAnimationAdapter);
        }
        listView.setHasMoreData(true);
        progressWheel.setVisibility(8);
        adapter.notifyDataSetChanged();
    }

    private void ShowResult1(String s)
    {
        list_fun.addAll(Myutils.funList(s));
    }

    private void ShowResult2(String s)
    {
        list_fun_app.addAll(Myutils.fun_appList(s));
    }

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
            app.asyncLoadImage(icon_pick, iv_tianchi);
            app.asyncLoadImage(img_pick, iv_tianchi9);
            app.asyncLoadImage(icon_pick1, iv_tianchi2);
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        Log.e("record", (new StringBuilder("record=====")).append(record).toString());
    }

    private void buildlistener()
    {
        tab_group.setOnClickListener(this);
        tab_app.setOnClickListener(this);
        tab_game.setOnClickListener(this);
        tab_search.setOnClickListener(this);
        tab_down.setOnClickListener(this);
    }

    private void count()
    {
        int i;
        int j;
        record = sharedPreferences.getInt("first", 0);
        i = sharedPreferences.getInt("iFirst1", 0);
        j = sharedPreferences.getInt("shortcut", 0);
        Log.e("tag", (new StringBuilder("shortcut=")).append(j).toString());
        if (j != 0) goto _L2; else goto _L1
_L1:
        PackageInfo packageinfo = null;
        PackageInfo packageinfo1 = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        packageinfo = packageinfo1;
_L3:
        packageinfo1 = null;
        PackageInfo packageinfo2 = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        packageinfo1 = packageinfo2;
_L4:
        packageinfo2 = null;
        PackageInfo packageinfo3 = getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        packageinfo2 = packageinfo3;
_L5:
        if (packageinfo != null)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        MobclickAgent.onEvent(getApplicationContext(), "shortcut_battery");
        Intent intent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        android.content.Intent.ShortcutIconResource shortcuticonresource2 = android.content.Intent.ShortcutIconResource.fromContext(this, 0x7f0200ee);
        Intent intent5 = new Intent(this, com/aio/downloader/activity/WidgeGametActivity);
        intent.putExtra("android.intent.extra.shortcut.NAME", getString(0x7f0b0001));
        intent.putExtra("duplicate", false);
        intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcuticonresource2);
        intent.putExtra("android.intent.extra.shortcut.INTENT", intent5);
        sendBroadcast(intent);
        if (packageinfo1 != null)
        {
            break MISSING_BLOCK_LABEL_317;
        }
        MobclickAgent.onEvent(getApplicationContext(), "shortcut_cleaner");
        Intent intent1 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        android.content.Intent.ShortcutIconResource shortcuticonresource = android.content.Intent.ShortcutIconResource.fromContext(this, 0x7f0200f8);
        Intent intent4 = new Intent(this, com/aio/downloader/activity/WidgePaidActivity);
        intent1.putExtra("android.intent.extra.shortcut.NAME", getString(0x7f0b0002));
        intent1.putExtra("duplicate", false);
        intent1.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcuticonresource);
        intent1.putExtra("android.intent.extra.shortcut.INTENT", intent4);
        sendBroadcast(intent1);
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception1;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception2;
        if (packageinfo2 == null)
        {
            try
            {
                MobclickAgent.onEvent(getApplicationContext(), "shortcut_crush");
                Intent intent2 = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                android.content.Intent.ShortcutIconResource shortcuticonresource1 = android.content.Intent.ShortcutIconResource.fromContext(this, 0x7f0200d0);
                Intent intent3 = new Intent(this, com/aio/downloader/activity/HexCrushActivity);
                intent2.putExtra("android.intent.extra.shortcut.NAME", getString(0x7f0b0003));
                intent2.putExtra("duplicate", false);
                intent2.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", shortcuticonresource1);
                intent2.putExtra("android.intent.extra.shortcut.INTENT", intent3);
                sendBroadcast(intent2);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
_L2:
        record = record + 1;
        editor.putInt("first", record);
        editor.putInt("iFirst1", i + 1);
        editor.putInt("shortcut", j + 1);
        editor.commit();
        return;
        namenotfoundexception;
        namenotfoundexception.printStackTrace();
          goto _L3
        namenotfoundexception1;
        namenotfoundexception1.printStackTrace();
          goto _L4
        namenotfoundexception2;
        namenotfoundexception2.printStackTrace();
          goto _L5
    }

    private void downwifi()
    {
        final LianwangDialog dialog = new LianwangDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        Button button = (Button)dialog.findViewById(0x7f070141);
        Button button1 = (Button)dialog.findViewById(0x7f070142);
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
        button1.setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity this$0;
            private final LianwangDialog val$dialog;

            public void onClick(View view)
            {
                startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                dialog.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                dialog = lianwangdialog;
                super();
            }
        });
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

    private void facebookad()
    {
        nativeAdfb.registerViewForInteraction(apptopgift);
    }

    private String getBytesDownloaded(int i, long l)
    {
        long l1 = ((long)i * l) / 100L;
        if (l >= 0xf4240L)
        {
            return (new StringBuilder()).append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l1 / 1000000F)
            })).append("/").append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l / 1000000F)
            })).append("MB").toString();
        }
        if (l >= 1000L)
        {
            return (new StringBuilder()).append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l1 / 1000F)
            })).append("/").append(String.format("%.1f", new Object[] {
                Float.valueOf((float)l / 1000F)
            })).append("Kb").toString();
        } else
        {
            return (new StringBuilder()).append(l1).append("/").append(l).toString();
        }
    }

    private String[] getCpuInfo()
    {
        String as[];
        as = new String[2];
        as[0] = "";
        as[1] = "";
        BufferedReader bufferedreader;
        String as1[];
        bufferedreader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
        as1 = bufferedreader.readLine().split("\\s+");
        int i = 2;
_L3:
        if (i < as1.length) goto _L2; else goto _L1
_L1:
        as1 = bufferedreader.readLine().split("\\s+");
        as[1] = (new StringBuilder(String.valueOf(as[1]))).append(as1[2]).toString();
        bufferedreader.close();
_L4:
        Log.e("qwa", (new StringBuilder("cpuinfo:")).append(as[0]).append(" ").append(as[1]).toString());
        return as;
_L2:
        as[0] = (new StringBuilder(String.valueOf(as[0]))).append(as1[i]).append(" ").toString();
        i++;
          goto _L3
        IOException ioexception;
        ioexception;
          goto _L4
    }

    private void getNewApps()
    {
        (new Thread(new Runnable() {

            final MyMainActivity this$0;

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
                Log.e("jsonStr", (new StringBuilder(String.valueOf(upJsonStr))).toString());
                obj = new Message();
                obj.obj = upJsonStr;
                obj.what = 1001;
                appHandler.sendMessage(((Message) (obj)));
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        })).start();
    }

    public static long getmem_TOLAL()
    {
        Object obj;
        Object obj2;
        Object obj4;
        String s;
        Object obj5;
        obj4 = null;
        obj2 = null;
        obj5 = null;
        obj = null;
        s = null;
        Object obj1 = new BufferedReader(new FileReader("/proc/meminfo"), 8);
        s = ((BufferedReader) (obj1)).readLine();
        Object obj3;
        obj = obj2;
        if (s != null)
        {
            obj = s;
        }
        if (obj1 != null)
        {
            try
            {
                ((BufferedReader) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                ((IOException) (obj1)).printStackTrace();
            }
        }
        return (long)Integer.parseInt(((String) (obj)).substring(((String) (obj)).indexOf(':') + 1, ((String) (obj)).indexOf('k')).trim());
        obj3;
        obj1 = s;
_L6:
        obj = obj1;
        ((FileNotFoundException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_56;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_56;
        obj3;
        obj1 = obj5;
_L4:
        obj = obj1;
        ((IOException) (obj3)).printStackTrace();
        obj = obj4;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        try
        {
            ((BufferedReader) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            obj = obj4;
            break MISSING_BLOCK_LABEL_56;
        }
        obj = obj4;
        break MISSING_BLOCK_LABEL_56;
        obj1;
_L2:
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((IOException) (obj)).printStackTrace();
            }
        }
        throw obj1;
        obj3;
        obj = obj1;
        obj1 = obj3;
        if (true) goto _L2; else goto _L1
_L1:
        obj3;
        if (true) goto _L4; else goto _L3
_L3:
        obj3;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void init()
    {
        listView = (PullableListView)findViewById(0x7f07006f);
        listView.setOnLoadListener(this);
        listView.setHasMoreData(false);
        downrelelativetv = (RelativeLayout)findViewById(0x7f07006d);
        badgetv = (TextView)findViewById(0x7f070266);
        apptopgift = (ImageView)findViewById(0x7f07006a);
        apptopgift.setOnClickListener(this);
        sp_config = getSharedPreferences("banner_type", 0);
        mAnimImageView = (ImageView)findViewById(0x7f070073);
        appbanner = (LinearLayout)findViewById(0x7f070070);
        Object obj = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-2192624499353475/5842010949");
        appbanner.addView(((View) (obj)));
        ((AdView) (obj)).loadAd(new AdRequest());
        int i;
        int j;
        try
        {
            typeFace = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        }
        catch (Exception exception1) { }
        progressWheel = (ProgressWheel)findViewById(0x7f070072);
        app = (MyApplcation)getApplicationContext();
        tab_group = (RadioGroup)findViewById(0x7f070066);
        tab_app = (LImageButton)findViewById(0x7f070068);
        tab_game = (LImageButton)findViewById(0x7f070069);
        tab_search = (LImageButton)findViewById(0x7f07006b);
        tab_down = (LImageButton)findViewById(0x7f07006c);
        mDrawerLayout = (DrawerLayout)findViewById(0x7f070064);
        drawerButtonLeft = (LImageButton)findViewById(0x7f070067);
        drawerButtonLeft.setOnClickListener(this);
        mLeftGravityView = findViewById(0x7f070071);
        lp = mLeftGravityView.getLayoutParams();
        obj = ((WindowManager)getSystemService("window")).getDefaultDisplay();
        i = ((Display) (obj)).getHeight();
        j = ((Display) (obj)).getWidth();
        lp.width = (int)((double)j * 0.90000000000000002D);
        lp.height = i;
        mLeftGravityView.setLayoutParams(lp);
        mAnimation = AnimationUtils.loadAnimation(this, 0x7f040008);
        publictools = new publicTools(this);
        default_options = new HashMap();
        default_options.put("save_cookie", Integer.valueOf(0));
        default_options.put("send_cookie", Integer.valueOf(0));
        default_options.put("show_header", Integer.valueOf(0));
        default_options.put("redirect", Integer.valueOf(1));
        try
        {
            db = new FinalDBChen(getmContext(), getDatabasePath("download2.db").getAbsolutePath());
        }
        catch (Exception exception) { }
        spnetworkre = getSharedPreferences("network", 0);
        if (dbUtils == null)
        {
            dbUtils = new TypeDbUtils(this);
        }
        mAnimation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final MyMainActivity this$0;

            public void onAnimationEnd(Animation animation)
            {
                mAnimImageView.setVisibility(4);
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        });
        badgedownimg = new BadgeView(this, downrelelativetv);
        badgedowntv = new BadgeView(this, badgetv);
        main_tab_top = (RelativeLayout)findViewById(0x7f070065);
        nativeAdfb = new NativeAd(this, "340186902832477_401790893338744");
        nativeAdfb.setAdListener(this);
        nativeAdfb.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        findViewById(0x7f070297).setOnClickListener(this);
        findViewById(0x7f070298).setOnClickListener(this);
        findViewById(0x7f070299).setOnClickListener(this);
        findViewById(0x7f07029a).setOnClickListener(this);
        findViewById(0x7f07029b).setOnClickListener(this);
        findViewById(0x7f07029c).setOnClickListener(this);
        findViewById(0x7f07029d).setOnClickListener(this);
        findViewById(0x7f07029e).setOnClickListener(this);
        findViewById(0x7f07029f).setOnClickListener(this);
        findViewById(0x7f0702a0).setOnClickListener(this);
        findViewById(0x7f0702a1).setOnClickListener(this);
        findViewById(0x7f0702a2).setOnClickListener(this);
        findViewById(0x7f0702a3).setOnClickListener(this);
        findViewById(0x7f0702a4).setOnClickListener(this);
        findViewById(0x7f0702a5).setOnClickListener(this);
        findViewById(0x7f0702a6).setOnClickListener(this);
        findViewById(0x7f0702a7).setOnClickListener(this);
        findViewById(0x7f0702a8).setOnClickListener(this);
        findViewById(0x7f0702a9).setOnClickListener(this);
    }

    private void initDownload()
    {
        try
        {
            Uri uri = Uri.parse("http://apk.downloadatoz.com/package/com.allinone.free.apk");
            Uri uri1 = Uri.parse(urlPath);
            Log.e("jone", urlPath);
            request1 = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initDownload_battery()
    {
        try
        {
            Uri uri = Uri.parse("http://apktop.downloadatoz.com/upload_swf/com.freeapp.batterysaver.swf");
            Uri uri1 = Uri.parse(urlPath_battery);
            Log.e("jone", urlPath_battery);
            request_battery = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener_battery);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initDownload_caller()
    {
        try
        {
            Uri uri = Uri.parse("http://apktop.downloadatoz.com/upload_swf/com.allinone.callerid.swf");
            Uri uri1 = Uri.parse(urlPath_caller);
            Log.e("jone", urlPath_caller);
            request_caller = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener_caller);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initDownload_cleaner()
    {
        try
        {
            Uri uri = Uri.parse("http://apktop.downloadatoz.com/upload_swf/com.evzapp.cleanmaster.swf");
            Uri uri1 = Uri.parse(urlPath_cleaner);
            Log.e("jone", urlPath_cleaner);
            request_cleaner = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener_cleaner);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initDownload_crush()
    {
        try
        {
            Uri uri = Uri.parse("http://apktop.downloadatoz.com/upload_swf/com.freepezzle.hexcrush.swf");
            Uri uri1 = Uri.parse(urlPath_crush);
            Log.e("jone", urlPath_crush);
            request_crush = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener_crush);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initDownload_free()
    {
        try
        {
            Uri uri = Uri.parse("http://apktop.downloadatoz.com/upload_swf/com.osamahq.freestore.swf");
            Uri uri1 = Uri.parse(urlPath_free);
            Log.e("jone", urlPath_free);
            request_free = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener_free);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initDownload_gallery()
    {
        try
        {
            Uri uri = Uri.parse("http://apktop.downloadatoz.com/upload_swf/com.androidapp.gallary3d.swf");
            Uri uri1 = Uri.parse(urlPath_gallery);
            Log.e("jone", urlPath_gallery);
            request_gallery = (new DownloadRequest(uri)).setDestinationURI(uri1).setPriority(com.thin.downloadmanager.DownloadRequest.Priority.HIGH).setDownloadListener(myDownloadStatusListener_gallery);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void initupdate()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager = new ThinDownloadManager(4);
    }

    private void initupdate_battery()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager_battery = new ThinDownloadManager(4);
    }

    private void initupdate_caller()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager_caller = new ThinDownloadManager(4);
    }

    private void initupdate_cleaner()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager_cleaner = new ThinDownloadManager(4);
    }

    private void initupdate_crush()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager_crush = new ThinDownloadManager(4);
    }

    private void initupdate_free()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager_free = new ThinDownloadManager(4);
    }

    private void initupdate_gallery()
    {
        mProgress1 = (ProgressBar)findViewById(0x7f070074);
        mProgress1.setMax(100);
        mProgress1.setProgress(0);
        downloadManager_gallery = new ThinDownloadManager(4);
    }

    public static boolean isBackground(Context context, String s)
    {
        context = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
        android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo;
        do
        {
            if (!context.hasNext())
            {
                return false;
            }
            runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)context.next();
        } while (!runningappprocessinfo.processName.equals(s));
        if (runningappprocessinfo.importance == 400)
        {
            Log.e("\u540E\u53F0", runningappprocessinfo.processName);
            return false;
        } else
        {
            Log.e("\u524D\u53F0", runningappprocessinfo.processName);
            return true;
        }
    }

    private void loadInterstitialAd()
    {
        interstitialAd = new InterstitialAd(this, "340186902832477_401798000004700");
        interstitialAd.setAdListener(this);
        interstitialAd.loadAd();
    }

    private void neiTui()
    {
        (new Thread(new Runnable() {

            private String min_version;
            final MyMainActivity this$0;

            public void run()
            {
                Log.v("version", "11111111getversion");
                Object obj1;
                String s = (new StringBuilder("http://app.loveitsomuch.com/gonglue_xilie/ping.php?id=")).append(Myutils.packagename2).append("&version=").append("3.3.9").toString();
                Log.e("path", s);
                obj1 = (HttpURLConnection)(new URL(s)).openConnection();
                ((HttpURLConnection) (obj1)).setConnectTimeout(60000);
                ((HttpURLConnection) (obj1)).setRequestMethod("GET");
                if (((HttpURLConnection) (obj1)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
                Object obj;
                obj = new StringBuffer();
                obj1 = new BufferedReader(new InputStreamReader(((HttpURLConnection) (obj1)).getInputStream()));
_L12:
                Object obj2 = ((BufferedReader) (obj1)).readLine();
                if (obj2 != null) goto _L4; else goto _L3
_L3:
                JSONObject jsonobject;
                jsonobject = new JSONObject(((StringBuffer) (obj)).toString());
                status = jsonobject.getInt("status");
                in_control = jsonobject.getInt("in_control");
                banner_type_name = jsonobject.getString("ad_banner");
                min_version = jsonobject.getString("min_version_in_maintenance");
                if (min_version.equals("3.3.9"))
                {
                    Log.e("eee", "min_version=null");
                }
                if (banner_type_name.equals("admob"))
                {
                    obj = new Message();
                    obj.what = 10;
                    handlertimer.sendMessage(((Message) (obj)));
                }
                sp_config.edit().putString("banner_type", banner_type_name).commit();
                Log.e("aaaa", (new StringBuilder("22222222status:")).append(status).toString());
                Log.e("aaaa", (new StringBuilder("3333333in_control")).append(in_control).toString());
                if (status != 1 || in_control != 0) goto _L2; else goto _L5
_L5:
                GameInfosVersionModel gameinfosversionmodel;
                gameinfosversionmodel = new GameInfosVersionModel();
                gameinfosversionmodel.setUpdatePath(jsonobject.getString("update_url"));
                if (gameinfosversionmodel.getUpdatePath().equals("")) goto _L7; else goto _L6
_L6:
                if (!AIOUPDATEFILE.exists()) goto _L9; else goto _L8
_L8:
                Log.e("www", "eeeeee");
                (new File((new StringBuilder()).append(AIOUPDATEFILE).append(File.separator).append("aioupdate.apk").toString())).delete();
_L10:
                if (downloadManager.query(downloadId1) == 32 && NetWorkUtil.getAPNType(getApplicationContext()) == 1)
                {
                    downloadId1 = downloadManager.add(request1);
                    Log.e("www", "download");
                }
_L7:
                Myutils.big_ad_interval = Integer.parseInt(jsonobject.getString("big_ad_interval")) * 1000;
                Log.v("fdfd", (new StringBuilder("dd")).append(Myutils.big_ad_interval).toString());
                if (!jsonobject.getString("big_ad_interval").equals("0"))
                {
                    (new Timer()).schedule(new TimerTask() {

                        final _cls42 this$1;

                        public void run()
                        {
                            Message message = new Message();
                            message.what = 20;
                            handlertimer.sendMessage(message);
                        }

            
            {
                this$1 = _cls42.this;
                super();
            }
                    }, 0L, Myutils.big_ad_interval);
                }
                obj2 = Boolean.valueOf(false);
                Boolean boolean1;
                boolean1 = Boolean.valueOf(false);
                obj = obj2;
                JSONArray jsonarray = jsonobject.getJSONArray("neitui_list");
                obj1 = obj2;
                obj = obj2;
                if (jsonarray.length() <= 0)
                {
                    break MISSING_BLOCK_LABEL_735;
                }
                obj = obj2;
                obj1 = Boolean.valueOf(true);
                obj = obj1;
                obj2 = jsonarray.getJSONObject(0);
                obj = obj1;
                gameinfosversionmodel.setNtTitle(((JSONObject) (obj2)).getString("headline"));
                obj = obj1;
                gameinfosversionmodel.setNtMsg(((JSONObject) (obj2)).getString("description"));
                obj = obj1;
                gameinfosversionmodel.setPicPath(((JSONObject) (obj2)).getString("thumb_url"));
                obj = obj1;
                gameinfosversionmodel.setNtPath(((JSONObject) (obj2)).getString("url"));
                obj = obj1;
                gameinfosversionmodel.setNtId(((JSONObject) (obj2)).getString("url_scheme"));
                obj = obj1;
                try
                {
                    Log.v("version", "44444");
                }
                catch (Exception exception)
                {
                    exception = ((Exception) (obj));
                }
                obj = boolean1;
                if (((Boolean) (obj1)).booleanValue())
                {
                    break MISSING_BLOCK_LABEL_789;
                }
                obj = boolean1;
                if (!jsonobject.getString("update_url").equals(""))
                {
                    obj = Boolean.valueOf(true);
                    gameinfosversionmodel.setNtPath(jsonobject.getString("update_url"));
                    Log.v("version", "55555");
                }
                if (((Boolean) (obj1)).booleanValue() || ((Boolean) (obj)).booleanValue())
                {
                    handlerversoin.sendMessage(handlerversoin.obtainMessage(564, gameinfosversionmodel));
                    Log.v("version", "66666");
                    return;
                }
                  goto _L2
_L4:
                try
                {
                    ((StringBuffer) (obj)).append(((String) (obj2)));
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    ((Exception) (obj)).printStackTrace();
                    return;
                }
                continue; /* Loop/switch isn't completed */
_L9:
                Log.e("www", "nnnnn");
                  goto _L10
_L2:
                return;
                if (true) goto _L12; else goto _L11
_L11:
            }


            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        })).start();
    }

    private void updateaioApk()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOUPDATEFILE).append(File.separator).append("aioupdate.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    private void updateaioApk1()
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse((new StringBuilder("file://")).append(Environment.getExternalStorageDirectory().toString()).append("/com.aio.downloader").append(File.separator).append("com.allinone.downloader.apk").toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    private void viewtop()
    {
        View view = View.inflate(this, 0x7f030070, null);
        listView.addHeaderView(view, null, false);
        iv_fb_fragment = (ImageView)view.findViewById(0x7f0701a6);
        appline = (LinearLayout)view.findViewById(0x7f0702aa);
        gameline = (LinearLayout)view.findViewById(0x7f0702ab);
        paidline = (LinearLayout)view.findViewById(0x7f0702ac);
        datingline = (LinearLayout)view.findViewById(0x7f0702ad);
        playnowline = (RelativeLayout)view.findViewById(0x7f0702af);
        havetryline = (LinearLayout)view.findViewById(0x7f0702b0);
        view_kong = view.findViewById(0x7f0702b1);
        ll_updata = (LinearLayout)view.findViewById(0x7f0702b2);
        iv_updata = (ImageView)view.findViewById(0x7f0702b3);
        tv_updata_name = (TextView)view.findViewById(0x7f0702b4);
        tv_current_version = (TextView)view.findViewById(0x7f0702b5);
        tv_updata_version = (TextView)view.findViewById(0x7f0702b6);
        tv_updata_size = (TextView)view.findViewById(0x7f0702b7);
        iv_updata_bt = (ImageView)view.findViewById(0x7f0702b8);
        appline.setOnClickListener(this);
        gameline.setOnClickListener(this);
        paidline.setOnClickListener(this);
        datingline.setOnClickListener(this);
        playnowline.setOnClickListener(this);
        havetryline.setOnClickListener(this);
        iv_updata_bt.setOnClickListener(this);
        ll_updata.setOnClickListener(this);
    }

    public void MydownloadApk(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.e("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (TextUtils.isEmpty(avoid))
                    {
                        avoid = new Message();
                        avoid.what = 1;
                        handler.sendMessage(avoid);
                        if (content.length() > 100)
                        {
                            content.substring(0, 100);
                        } else
                        {
                            avoid = content;
                        }
                    } else
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        Log.e("goo", (new StringBuilder("file_url=")).append(avoid).toString());
                        d.setDownloadUrl(avoid);
                        d.setFilePath(s1);
                        Log.e("lklk", avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 3;
                        handler.sendMessage(avoid);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk1(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                        return null;
                    } else
                    {
                        avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl("http://apk.downloadatoz.com/package/com.allinone.free.apk");
                        d.setFilePath(avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 297;
                        handler.sendMessage(avoid);
                        return null;
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk2(final String id, final String title, final String icon, final int appserial)
    {
        Log.e("gak", "MydownloadApk2");
        (new AsyncTask() {

            DownloadMovieItem d;
            final MyMainActivity this$0;
            private final int val$appserial;
            private final String val$icon;
            private final String val$id;
            private final String val$title;

            protected volatile transient Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                if (db.findItemsByWhereAndWhereValue("downloadUrl", acquire_url_start, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                {
                    avoid = new Message();
                    avoid.what = 2;
                    handler.sendMessage(avoid);
                    return null;
                } else
                {
                    avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                    d.setDownloadUrl(acquire_url_start);
                    d.setFilePath(avoid);
                    d.setDownloadState(Integer.valueOf(4));
                    d.setMovieName(title);
                    d.setMovieHeadImagePath(icon);
                    d.setFile_id(id);
                    d.setType("app");
                    d.setTitle(title);
                    d.setSerial(appserial);
                    d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                    toDownload(d);
                    Myutils.getInstance();
                    Myutils.list.add(d);
                    avoid = new Message();
                    avoid.what = 3;
                    handler.sendMessage(avoid);
                    return null;
                }
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((Void)obj);
            }

            protected void onPostExecute(Void void1)
            {
                super.onPostExecute(void1);
                progressWheel.setVisibility(8);
            }

            protected void onPreExecute()
            {
                super.onPreExecute();
                progressWheel.setVisibility(0);
            }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s1;
                icon = s3;
                appserial = i;
                super();
                d = new DownloadMovieItem();
            }
        }).execute(new Void[0]);
    }

    public void MydownloadApk3(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                        return null;
                    } else
                    {
                        avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(acquire_url_start);
                        d.setFilePath(avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 4;
                        handler.sendMessage(avoid);
                        return null;
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk4(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                        return null;
                    } else
                    {
                        avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(acquire_url_start);
                        d.setFilePath(avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("mp3");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 5;
                        handler.sendMessage(avoid);
                        return null;
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk5(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                        return null;
                    } else
                    {
                        avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(acquire_url_start);
                        d.setFilePath(avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("video");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 5;
                        handler.sendMessage(avoid);
                        return null;
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk6(final String id, final String title, String s, int i)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(s, i) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.e("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (TextUtils.isEmpty(avoid))
                    {
                        avoid = new Message();
                        avoid.what = 1;
                        handler.sendMessage(avoid);
                        if (content.length() > 100)
                        {
                            content.substring(0, 100);
                        } else
                        {
                            avoid = content;
                        }
                    } else
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                    } else
                    {
                        String s1 = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        Log.e("goo", (new StringBuilder("file_url=")).append(avoid).toString());
                        d.setDownloadUrl(avoid);
                        d.setFilePath(s1);
                        Log.e("lklk", avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 4;
                        handler.sendMessage(avoid);
                    }
                    return null;
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public void MydownloadApk_Update(final String id, final String title, final String icon, int i, Bitmap bitmap)
    {
        publicTools.keyid = id;
        final long final_l = (long)Math.floor(System.currentTimeMillis() / 1000L);
        final String final_s1 = publicTools.getCode(id, final_l);
        if (final_s1.equals(""))
        {
            Toast.makeText(this, "Failed to connect server. Please try again.", 0).show();
            return;
        } else
        {
            (new AsyncTask(i, bitmap) {

                String content;
                DownloadMovieItem d;
                HashMap options;
                final MyMainActivity this$0;
                String url;
                private final int val$appserial;
                private final String val$icon;
                private final String val$id;
                private final Bitmap val$mIcon;
                private final String val$title;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    options = default_options;
                    options.put("show_header", Integer.valueOf(1));
                    options.put("redirect", Integer.valueOf(0));
                    options.put("send_cookie", Integer.valueOf(0));
                    content = publicTools.getDataFromURL(url, options);
                    if (!content.contains("Location"))
                    {
                        url = (new StringBuilder(String.valueOf(url))).append("&debug=1").toString();
                        options.put("redirect", Integer.valueOf(1));
                        content = publicTools.getDataFromURL(url, options);
                    }
                    avoid = "";
                    Matcher matcher = Pattern.compile("aio_swf_download_link: ([^\n\r\t]+)").matcher(content);
                    if (matcher.find())
                    {
                        avoid = matcher.group(1);
                    } else
                    {
                        Matcher matcher1 = Pattern.compile("Location: ([^\n\r\t]+)").matcher(content);
                        if (matcher1.find())
                        {
                            avoid = matcher1.group(1);
                        }
                    }
                    Log.v("bbbb", (new StringBuilder(String.valueOf(avoid))).append("*****").toString());
                    if (db.findItemsByWhereAndWhereValue("downloadUrl", avoid, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() > 0)
                    {
                        avoid = new Message();
                        avoid.what = 2;
                        handler.sendMessage(avoid);
                        return null;
                    } else
                    {
                        avoid = (new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getAbsolutePath()))).append(File.separator).append(getPackageName()).toString(), (new StringBuilder(String.valueOf(id))).append(".apk").toString())).getAbsolutePath();
                        d.setDownloadUrl(((DownloadMovieItem)list_update.get(showup)).getLink_url());
                        d.setFilePath(avoid);
                        d.setDownloadState(Integer.valueOf(4));
                        d.setMovieName(title);
                        d.setMovieHeadImagePath(icon);
                        d.setFile_id(id);
                        d.setType("app");
                        d.setTitle(title);
                        d.setSerial(appserial);
                        d.setCreate_time(Long.valueOf(System.currentTimeMillis()));
                        d.setMovieHeadImage(mIcon);
                        toDownload(d);
                        Myutils.getInstance();
                        Myutils.list.add(d);
                        avoid = new Message();
                        avoid.what = 4;
                        handler.sendMessage(avoid);
                        return null;
                    }
                }

                protected volatile void onPostExecute(Object obj)
                {
                    onPostExecute((Void)obj);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    progressWheel.setVisibility(8);
                }

                protected void onPreExecute()
                {
                    super.onPreExecute();
                    progressWheel.setVisibility(0);
                }

            
            {
                this$0 = MyMainActivity.this;
                id = s;
                title = s3;
                icon = s4;
                appserial = i;
                mIcon = bitmap;
                super();
                d = new DownloadMovieItem();
                url = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_get_apk.php?id=")).append(s).append("&stamp=").append(final_s1).append("&time=").append(final_l).append("&version=").append("3.3.9").toString();
                options = new HashMap();
                content = "";
            }
            }).execute(new Void[0]);
            return;
        }
    }

    public String createSDCardDir(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOUPDATE").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath = s.getPath();
            }
        }
        return urlPath;
    }

    public String createSDCardDir_Battery(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOSWF").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath_battery = s.getPath();
            }
        }
        return urlPath_battery;
    }

    public String createSDCardDir_caller(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOSWF").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath_caller = s.getPath();
            }
        }
        return urlPath_caller;
    }

    public String createSDCardDir_cleaner(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOSWF").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath_cleaner = s.getPath();
            }
        }
        return urlPath_cleaner;
    }

    public String createSDCardDir_crush(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOSWF").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath_crush = s.getPath();
            }
        }
        return urlPath_crush;
    }

    public String createSDCardDir_free(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOSWF").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath_free = s.getPath();
            }
        }
        return urlPath_free;
    }

    public String createSDCardDir_gallary(String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            File file = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append("/AIOSWF").toString());
            if (!file.exists())
            {
                file.mkdirs();
            }
            s = new File((new StringBuilder()).append(file).append(File.separator).append(s).toString());
            if (!s.exists())
            {
                try
                {
                    s.createNewFile();
                }
                catch (Exception exception) { }
                urlPath_gallery = s.getPath();
            }
        }
        return urlPath_gallery;
    }

    protected int excuteSuCMD(String s)
    {
        int i;
        try
        {
            Process process = Runtime.getRuntime().exec("su");
            DataOutputStream dataoutputstream = new DataOutputStream(process.getOutputStream());
            dataoutputstream.writeBytes("export LD_LIBRARY_PATH=/vendor/lib:/system/lib\n");
            dataoutputstream.writeBytes((new StringBuilder(String.valueOf(String.valueOf(s)))).append("\n").toString());
            dataoutputstream.flush();
            dataoutputstream.writeBytes("exit\n");
            dataoutputstream.flush();
            process.waitFor();
            i = Integer.valueOf(process.exitValue()).intValue();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return -1;
        }
        return i;
    }

    public void finish()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    public void getAllAppInfo()
    {
        PackageManager packagemanager = getPackageManager();
        List list1 = packagemanager.getInstalledPackages(0);
        Log.e("qew", (new StringBuilder(String.valueOf(list1.size()))).toString());
        jsonArray = new JSONArray();
        new Build();
        new HashMap();
        int i = 0;
        do
        {
            if (i >= list1.size())
            {
                Log.e("qew", (new StringBuilder(String.valueOf(mListInfo.size()))).toString());
                Log.e("qew", (new StringBuilder("jsonArray=")).append(jsonArray).toString());
                return;
            }
            JSONObject jsonobject = new JSONObject();
            AppInfo appinfo = new AppInfo();
            PackageInfo packageinfo = (PackageInfo)list1.get(i);
            ApplicationInfo applicationinfo = packageinfo.applicationInfo;
            if ((applicationinfo.flags & 1) <= 0)
            {
                String s = packagemanager.getApplicationLabel(applicationinfo).toString();
                String s1 = packageinfo.packageName;
                String s3 = packageinfo.versionName;
                Log.i("appname", (new StringBuilder()).append(packagemanager.getApplicationLabel(applicationinfo)).append(packageinfo.packageName).toString());
                appinfo.setAppname(s);
                appinfo.setP_name(s1);
                appinfo.setAvatar(packagemanager.getApplicationIcon(applicationinfo));
                appinfo.setVersion(s3);
                mListInfo.add(appinfo);
                try
                {
                    jsonobject.put("title", s);
                    jsonobject.put("url_id", s1);
                    jsonobject.put("version", s3);
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

    public int getHeight(int i, int j)
    {
        return (getResources().getDisplayMetrics().widthPixels * j) / i;
    }

    public long getmem_UNUSED(Context context)
    {
        context = (ActivityManager)context.getSystemService("activity");
        android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
        context.getMemoryInfo(memoryinfo);
        return memoryinfo.availMem / 1024L;
    }

    public void initView()
    {
        super.initView();
        new FinalDBChen(getmContext(), "download2.db", new DownloadMovieItem(), "downloadtask2", null);
    }

    public void onAdClicked(Ad ad)
    {
        Log.e("qwer", "onAdClicked");
        SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
        apptopgift.setImageResource(0x7f0200d7);
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAdfb != ad) goto _L2; else goto _L1
_L1:
        if (nativeAdfb != null && nativeAdfb == ad) goto _L4; else goto _L3
_L3:
        return;
_L4:
        nativeAdfb.unregisterView();
        facebookad();
        isfbshow = true;
        return;
_L2:
        if (nativeAd == ad && nativeAd != null && nativeAd == ad)
        {
            nativeAd.unregisterView();
            iv_fb_fragment.setVisibility(0);
            try
            {
                NativeAd.downloadAndDisplayImage(nativeAd.getAdCoverImage(), iv_fb_fragment);
                nativeAd.registerViewForInteraction(iv_fb_fragment);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Ad ad)
            {
                return;
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onClick(final View dialog)
    {
        dialog.getId();
        JVM INSTR lookupswitch 31: default 264
    //                   2131165287: 1351
    //                   2131165288: 265
    //                   2131165289: 281
    //                   2131165290: 297
    //                   2131165291: 1223
    //                   2131165292: 1239
    //                   2131165847: 1394
    //                   2131165848: 1420
    //                   2131165849: 1446
    //                   2131165850: 1472
    //                   2131165851: 1498
    //                   2131165852: 1524
    //                   2131165853: 1550
    //                   2131165854: 1576
    //                   2131165855: 1602
    //                   2131165856: 1628
    //                   2131165857: 1654
    //                   2131165858: 1691
    //                   2131165859: 1728
    //                   2131165860: 1765
    //                   2131165861: 1803
    //                   2131165862: 1826
    //                   2131165863: 1850
    //                   2131165864: 1899
    //                   2131165865: 1948
    //                   2131165866: 1255
    //                   2131165867: 1271
    //                   2131165868: 1287
    //                   2131165869: 1303
    //                   2131165871: 1319
    //                   2131165872: 1335;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22 _L23 _L24 _L25 _L26 _L27 _L28 _L29 _L30 _L31 _L32
_L1:
        return;
_L3:
        startActivity(new Intent(this, com/aio/downloader/activity/AppActivity1));
        return;
_L4:
        startActivity(new Intent(this, com/aio/downloader/activity/GameActivity1));
        return;
_L5:
        SharedPreferencesConfig.SetClickTime(getApplicationContext(), System.currentTimeMillis() + 30000L);
        apptopgift.setImageResource(0x7f0200d7);
        if (isfbshow) goto _L1; else goto _L33
_L33:
        mRandom = (int)(Math.random() * 4D) + 1;
        if (mRandom == 1)
        {
            try
            {
                packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
            }
            // Misplaced declaration of an exception variable
            catch (final View dialog)
            {
                dialog.printStackTrace();
            }
            if (packageInfo == null)
            {
                if (PRO_DIR_FOME.exists())
                {
                    dialog = new Intent("android.intent.action.VIEW");
                    dialog.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                    dialog.addFlags(0x10000000);
                    startActivity(dialog);
                    return;
                }
                if (PRO_DIR_TO.exists())
                {
                    (new AsyncTask() {

                        final MyMainActivity this$0;

                        protected volatile transient Object doInBackground(Object aobj[])
                        {
                            return doInBackground((Void[])aobj);
                        }

                        protected transient Void doInBackground(Void avoid[])
                        {
                            Myutils.copyfile(PRO_DIR_TO, PRO_DIR_FOME, Boolean.valueOf(false));
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
                            void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                            void1.addFlags(0x10000000);
                            startActivity(void1);
                        }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
                    }).execute(new Void[0]);
                    return;
                } else
                {
                    dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                    dialog.putExtra("myid", "com.evzapp.cleanmaster");
                    dialog.addFlags(0x10000000);
                    startActivity(dialog);
                    return;
                }
            } else
            {
                dialog = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
                dialog.addFlags(0x10000000);
                startActivity(dialog);
                return;
            }
        }
        if (mRandom != 2) goto _L35; else goto _L34
_L34:
        try
        {
            packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.freepezzle.hexcrush", 0);
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog)
        {
            dialog.printStackTrace();
        }
        if (packageInfo != null) goto _L37; else goto _L36
_L36:
        try
        {
            if (AIOCRUSHAPK.exists() && getFileSizes(AIOCRUSHAPK) >= 0x19ee4cL)
            {
                dialog = new Intent("android.intent.action.VIEW");
                dialog.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCRUSHAPK).toString()), "application/vnd.android.package-archive");
                startActivity(dialog);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog)
        {
            dialog.printStackTrace();
            return;
        }
        if (AIOCRUSHSWF.exists() && getFileSizes(AIOCRUSHSWF) >= 0x19ee4cL)
        {
            (new AsyncTask() {

                final MyMainActivity this$0;

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
                this$0 = MyMainActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        dialog.putExtra("myid", "com.freepezzle.hexcrush");
        startActivity(dialog);
        return;
_L37:
        startActivity(getPackageManager().getLaunchIntentForPackage("com.freepezzle.hexcrush"));
        return;
_L35:
        if (mRandom != 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.allinone.callerid", 0);
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog)
        {
            dialog.printStackTrace();
        }
        if (packageInfo != null) goto _L39; else goto _L38
_L38:
        try
        {
            if (AIOCALLERAPK.exists() && getFileSizes(AIOCALLERAPK) >= 0x357458L)
            {
                dialog = new Intent("android.intent.action.VIEW");
                dialog.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                dialog.addFlags(0x10000000);
                startActivity(dialog);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog)
        {
            dialog.printStackTrace();
            return;
        }
        if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x357458L)
        {
            (new AsyncTask() {

                final MyMainActivity this$0;

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
                    startActivity(void1);
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        dialog.putExtra("myid", "com.allinone.callerid");
        dialog.addFlags(0x10000000);
        startActivity(dialog);
        return;
_L39:
        dialog = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
        dialog.addFlags(0x10000000);
        startActivity(dialog);
        return;
        if (mRandom != 4) goto _L1; else goto _L40
_L40:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog)
        {
            dialog.printStackTrace();
        }
        if (packageInfo != null) goto _L42; else goto _L41
_L41:
        try
        {
            if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
            {
                dialog = new Intent("android.intent.action.VIEW");
                dialog.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                dialog.addFlags(0x10000000);
                startActivity(dialog);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (final View dialog)
        {
            dialog.printStackTrace();
            return;
        }
        if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL)
        {
            (new AsyncTask() {

                final MyMainActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOBATTERY, AIOBATTERYAPK, Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        dialog.putExtra("myid", "com.aioapp.battery");
        dialog.addFlags(0x10000000);
        startActivity(dialog);
        return;
_L42:
        dialog = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
        dialog.addFlags(0x10000000);
        startActivity(dialog);
        return;
_L6:
        startActivity(new Intent(this, com/aio/downloader/activity/AppRecommendKeywordsActivity));
        return;
_L7:
        startActivity(new Intent(this, com/aio/downloader/activity/DownloadAppManager));
        return;
_L27:
        startActivity(new Intent(this, com/aio/downloader/activity/AppActivity1));
        return;
_L28:
        startActivity(new Intent(this, com/aio/downloader/activity/GameActivity1));
        return;
_L29:
        startActivity(new Intent(this, com/aio/downloader/activity/MusthaveActivity));
        return;
_L30:
        startActivity(new Intent(this, com/aio/downloader/activity/FunActivity1));
        return;
_L31:
        startActivity(new Intent(this, com/aio/downloader/activity/TodaysPickActivity));
        return;
_L32:
        startActivity(new Intent(this, com/aio/downloader/activity/PaidforFreeActivity1));
        return;
_L2:
        if (mDrawerLayout.isDrawerOpen(5))
        {
            mDrawerLayout.closeDrawer(5);
        }
        if (mDrawerLayout.isDrawerOpen(3))
        {
            mDrawerLayout.closeDrawer(3);
            return;
        } else
        {
            mDrawerLayout.openDrawer(3);
            return;
        }
_L8:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MyDownloaderList));
        mDrawerLayout.closeDrawer(3);
        return;
_L9:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/UpdateActivity));
        mDrawerLayout.closeDrawer(3);
        return;
_L10:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/Unstall));
        mDrawerLayout.closeDrawer(3);
        return;
_L11:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/DownloadAppManager));
        mDrawerLayout.closeDrawer(3);
        return;
_L12:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/TodaysPickActivity));
        mDrawerLayout.closeDrawer(3);
        return;
_L13:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MusthaveActivity));
        mDrawerLayout.closeDrawer(3);
        return;
_L14:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/AdultActivity1));
        mDrawerLayout.closeDrawer(3);
        return;
_L15:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/PaidforFreeActivity1));
        mDrawerLayout.closeDrawer(3);
        return;
_L16:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/ExclusiveAppsActivity));
        mDrawerLayout.closeDrawer(3);
        return;
_L17:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/FunActivity1));
        mDrawerLayout.closeDrawer(3);
        return;
_L18:
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/FunActivity1);
        dialog.putExtra("current", 3);
        startActivity(dialog);
        mDrawerLayout.closeDrawer(3);
        return;
_L19:
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/FunActivity1);
        dialog.putExtra("current", 4);
        startActivity(dialog);
        mDrawerLayout.closeDrawer(3);
        return;
_L20:
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/FunActivity1);
        dialog.putExtra("current", 5);
        startActivity(dialog);
        mDrawerLayout.closeDrawer(3);
        return;
_L21:
        dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/FunActivity1);
        dialog.putExtra("current", 6);
        startActivity(dialog);
        mDrawerLayout.closeDrawer(3);
        return;
_L22:
        startActivity(new Intent(this, com/aio/downloader/activity/MySettingsActivity));
        mDrawerLayout.closeDrawer(3);
        return;
_L23:
        (new MyAsyncTaskVersion()).execute(new Void[0]);
        mDrawerLayout.closeDrawer(3);
        return;
_L24:
        dialog = new Intent("android.intent.action.SEND");
        dialog.setType("message/rfc822");
        dialog.putExtra("android.intent.extra.EMAIL", new String[] {
            "aio.downloader@yahoo.com.sg"
        });
        startActivity(Intent.createChooser(dialog, "E-mail"));
        return;
_L25:
        dialog = new Intent("android.intent.action.SEND");
        dialog.setType("text/plain");
        dialog.putExtra("android.intent.extra.TEXT", "http://tinyurl.com/allinone-downloader");
        startActivity(Intent.createChooser(dialog, "AIO Downloaded"));
        mDrawerLayout.closeDrawer(3);
        return;
_L26:
        dialog = new AboutCustomDialog(this, 0x7f0c000e);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        ((Button)dialog.findViewById(0x7f07001e)).setOnClickListener(new android.view.View.OnClickListener() {

            final MyMainActivity this$0;
            private final AboutCustomDialog val$dialog;

            public void onClick(View view)
            {
                dialog.dismiss();
            }

            
            {
                this$0 = MyMainActivity.this;
                dialog = aboutcustomdialog;
                super();
            }
        });
        mDrawerLayout.closeDrawer(3);
        return;
    }

    protected void onCreate(final Bundle dialog)
    {
        super.onCreate(dialog);
        setContentView(0x7f030009);
        setmContext(this);
        Log.e("gak", "shouyeonCreate");
        (new Thread() {

            final MyMainActivity this$0;

            public void run()
            {
                ServerSocket serversocket;
                super.run();
                serversocket = null;
                if (false)
                {
                    break MISSING_BLOCK_LABEL_21;
                }
                serversocket = new ServerSocket(12121);
_L3:
                Socket socket = serversocket.accept();
                Object obj2 = "";
                OutputStream outputstream;
                InputStream inputstream;
                BufferedReader bufferedreader;
                outputstream = socket.getOutputStream();
                inputstream = socket.getInputStream();
                bufferedreader = new BufferedReader(new InputStreamReader(inputstream));
_L5:
                String s3 = bufferedreader.readLine();
                if (s3 != null) goto _L2; else goto _L1
_L1:
                try
                {
                    Log.e("write", "write11111");
                    obj2 = ((String) (obj2)).split(" ")[1].trim();
                    String as[] = ((String) (obj2)).split("/?jsonpCallback=");
                    String s = as[as.length - 1].split("&")[0];
                    Log.e("gak", (new StringBuilder(String.valueOf(obj2))).append("====buffer====").append(s).toString());
                    new JSONObject();
                    new JSONArray();
                    obj2 = (new StringBuilder(String.valueOf(s))).append("({name:'aio'})").toString();
                    Log.e("gak", (new StringBuilder("str===")).append(((String) (obj2))).toString());
                    Log.e("write", "write22222");
                    outputstream.write(((String) (obj2)).getBytes("gbk"));
                    outputstream.flush();
                    socket.shutdownOutput();
                    outputstream.close();
                    bufferedreader.close();
                    inputstream.close();
                    socket.close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj2)
                {
                    Log.e("gak", (new StringBuilder("catch1")).append(((IOException) (obj2)).getMessage()).toString());
                    ((IOException) (obj2)).printStackTrace();
                    return;
                }
                  goto _L3
_L2:
                String s1;
                boolean flag1;
                s1 = (new StringBuilder(String.valueOf(obj2))).append(s3).toString();
                Log.e("gak", (new StringBuilder("line=")).append(s3).toString());
                flag1 = s3.equals("");
                obj2 = s1;
                if (!flag1) goto _L5; else goto _L4
_L4:
                obj2 = s1;
                  goto _L1
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        }).start();
        intent_float = new Intent(getApplicationContext(), com/aio/downloader/floatwindow/FloatWindowService);
        boolean flag = getSharedPreferences("floatctri", 0).getBoolean("fctri", true);
        intent_float = new Intent(getApplicationContext(), com/aio/downloader/floatwindow/FloatWindowService);
        Object obj;
        int i;
        if (flag)
        {
            startService(intent_float);
        } else
        {
            stopService(intent_float);
        }
        startService(new Intent(getApplicationContext(), com/aio/downloader/floatwindow/MyFloatService));
        iv_tianchi = (ImageView)findViewById(0x7f07005a);
        iv_tianchi1 = (ImageView)findViewById(0x7f07005b);
        iv_tianchi2 = (ImageView)findViewById(0x7f07005c);
        iv_tianchi3 = (ImageView)findViewById(0x7f07005d);
        iv_tianchi4 = (ImageView)findViewById(0x7f07005e);
        iv_tianchi5 = (ImageView)findViewById(0x7f07005f);
        iv_tianchi6 = (ImageView)findViewById(0x7f070060);
        iv_tianchi7 = (ImageView)findViewById(0x7f070061);
        iv_tianchi8 = (ImageView)findViewById(0x7f070062);
        iv_tianchi9 = (ImageView)findViewById(0x7f070063);
        mNotificationManager8 = (NotificationManager)getSystemService("notification");
        sharedPreferences = getSharedPreferences("countName_first", 0);
        editor = sharedPreferences.edit();
        i = sharedPreferences.getInt("first", 0);
        count();
        Log.e("record", (new StringBuilder("record=")).append(i).toString());
        Myutils.iswidget2 = true;
        Object obj1;
        try
        {
            todayid = getIntent().getStringExtra("todayid");
            id = getIntent().getStringExtra("myid");
            Log.v("rtrt", (new StringBuilder(String.valueOf(id))).append("3333333333333").toString());
            if (id != null)
            {
                dialog = new Intent(this, com/aio/downloader/activity/AppDetailsActivity);
                dialog.putExtra("tuijianboolean", true);
                dialog.putExtra("linkurl", "");
                dialog.putExtra("myid", id);
                startActivity(dialog);
            }
            if (todayid != null)
            {
                dialog = new Intent(this, com/aio/downloader/activity/TodaysPickActivity);
                dialog.putExtra("todayboolean", true);
                dialog.putExtra("todayid", todayid);
                startActivity(dialog);
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        Myutils.packagename = getPackageName();
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append(Myutils.packagename).toString());
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_PICTURE").toString());
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_GIF").toString());
        publicTools.make_path_ready((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_BACKUPAPP").toString());
        Myutils.recoverSetting();
        Myutils.record_run_times();
        Myutils.saveSetting();
        Myutils.detail_save = true;
        Myutils.today_save = true;
        try
        {
            if (!publicTools.isNetworkAvailable(this))
            {
                dialog = new NointentDialog(this, 0x7f0c000e);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                Button button = (Button)dialog.findViewById(0x7f070141);
                Button button1 = (Button)dialog.findViewById(0x7f070142);
                button.setOnClickListener(new android.view.View.OnClickListener() {

                    final MyMainActivity this$0;
                    private final NointentDialog val$dialog;

                    public void onClick(View view)
                    {
                        dialog.dismiss();
                    }

            
            {
                this$0 = MyMainActivity.this;
                dialog = nointentdialog;
                super();
            }
                });
                button1.setOnClickListener(new android.view.View.OnClickListener() {

                    final MyMainActivity this$0;
                    private final NointentDialog val$dialog;

                    public void onClick(View view)
                    {
                        startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
                        dialog.dismiss();
                    }

            
            {
                this$0 = MyMainActivity.this;
                dialog = nointentdialog;
                super();
            }
                });
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        try
        {
            if (publicTools.isNetworkAvailable(this))
            {
                publicTools.set_a_random_user_agent();
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        try
        {
            run_time = Myutils.setting_json.getInt("run_times");
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        initView();
        init();
        buildlistener();
        if (publicTools.isNetworkAvailable(this))
        {
            neiTui();
            Recommed_Url();
            (new Mya3()).execute(new Void[0]);
            (new Mya2()).execute(new Void[0]);
            if (run_time == 1)
            {
                (new Mya1()).execute(new Void[0]);
            }
            (new Mya4()).execute(new Void[0]);
            (new Mya5()).execute(new Void[0]);
            long l = System.currentTimeMillis();
            long l1 = SharedPreferencesConfig.GetPiadTime(getApplicationContext());
            Log.e("qwer", (new StringBuilder("ppp=")).append(l - l1).toString());
            (new Thread() {

                final MyMainActivity this$0;

                public void run()
                {
                    super.run();
                    StringBuffer stringbuffer;
                    Object obj2;
                    InputStream inputstream;
                    InputStreamReader inputstreamreader;
                    BufferedReader bufferedreader;
                    obj2 = (HttpURLConnection)(new URL("http://android.downloadatoz.com/_201409/market/app_list_more_test.php?tab=paid_for_free_featured&page=1")).openConnection();
                    ((HttpURLConnection) (obj2)).setRequestMethod("GET");
                    ((HttpURLConnection) (obj2)).setConnectTimeout(5000);
                    ((HttpURLConnection) (obj2)).setReadTimeout(5000);
                    if (((HttpURLConnection) (obj2)).getResponseCode() != 200)
                    {
                        break MISSING_BLOCK_LABEL_174;
                    }
                    inputstream = ((HttpURLConnection) (obj2)).getInputStream();
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
                            ((HttpURLConnection) (obj2)).disconnect();
                            obj2 = handler.obtainMessage();
                            obj2.what = 250;
                            obj2.obj = stringbuffer.toString();
                            handler.sendMessage(((Message) (obj2)));
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
                this$0 = MyMainActivity.this;
                super();
            }
            }).start();
        }
        nativeAd = new NativeAd(getApplicationContext(), "340186902832477_436045309913302");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
        dialog = new IntentFilter();
        dialog.addAction("homeapp");
        registerReceiver(numbertip, dialog);
        dialog = new IntentFilter();
        dialog.addAction("showhomefeatured");
        registerReceiver(showhomeapp, dialog);
        dialog = new IntentFilter();
        dialog.addAction("hidehomefeatured");
        registerReceiver(hidehomeapp, dialog);
        dialog = new IntentFilter();
        dialog.addAction("homeapp");
        registerReceiver(homeapp, dialog);
        dialog = new IntentFilter();
        dialog.addAction("load_more");
        registerReceiver(load_more, dialog);
        startService(new Intent(this, com/aio/downloader/service/MyService));
        viewtop();
        if (!Myutils.setting_json.getBoolean("shotcut")) goto _L2; else goto _L1
_L1:
        if (Myutils.getVersionName(this).equals("3.3.9")) goto _L4; else goto _L3
_L3:
        Myutils.setting_json.put("shotcut", false);
        Myutils.saveSetting();
_L2:
        createSDCardDir("aioupdate.apk");
        createSDCardDir_Battery("battery.swf");
        createSDCardDir_free("freestore.swf");
        createSDCardDir_gallary("gallery.swf");
        createSDCardDir_cleaner("cleaner.swf");
        createSDCardDir_caller("caller.swf");
        createSDCardDir_crush("crush.swf");
        initupdate();
        initupdate_battery();
        initupdate_free();
        initupdate_gallery();
        initupdate_cleaner();
        initupdate_caller();
        initupdate_crush();
        initDownload();
        initDownload_battery();
        initDownload_free();
        initDownload_gallery();
        initDownload_cleaner();
        initDownload_caller();
        initDownload_crush();
        infos.clear();
        dialog = getPackageManager();
        obj = dialog.getInstalledApplications(8192);
        i = 0;
_L11:
        if (i < ((List) (obj)).size()) goto _L6; else goto _L5
_L5:
        if (AIOUPDATEFILE2.exists())
        {
            AIOUPDATEFILE2.delete();
        }
        if (dbUtils.queryfile("com.allinone.downloader") != null)
        {
            dbUtils.deletefile("com.allinone.downloader");
        }
        try
        {
            if (downloadManager_battery.query(downloadId_battery) == 32 && getFileSizes(AIOBATTERY) < 0x377effL && NetWorkUtil.getAPNType(getApplicationContext()) == 1)
            {
                downloadId_battery = downloadManager_battery.add(request_battery);
                Log.e("download", (new StringBuilder("downloadId_battery=")).append(downloadId_battery).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        try
        {
            if (downloadManager_gallery.query(downloadId_gallery) == 32 && getFileSizes(AIOGALLERY) < 0x1bff04L && NetWorkUtil.getAPNType(getApplicationContext()) == 1)
            {
                downloadId_gallery = downloadManager_gallery.add(request_gallery);
                Log.e("download", (new StringBuilder("downloadId_gallery=")).append(downloadId_gallery).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        try
        {
            if (downloadManager_caller.query(downloadId_caller) == 32 && getFileSizes(AIOCALLERDOWN) < 0x4e87bdL && NetWorkUtil.getAPNType(getApplicationContext()) == 1)
            {
                downloadId_caller = downloadManager_caller.add(request_caller);
                Log.e("download", (new StringBuilder("downloadId_caller=")).append(downloadId_caller).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        try
        {
            if (downloadManager_crush.query(downloadId_crush) == 32 && getFileSizes(AIOCRUSHSWF) < 0x19edc6L && NetWorkUtil.getAPNType(getApplicationContext()) == 1)
            {
                downloadId_crush = downloadManager_crush.add(request_crush);
                Log.e("download", (new StringBuilder("downloadId_crush=")).append(downloadId_crush).toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            dialog.printStackTrace();
        }
        try
        {
            acquire_url_start = getIntent().getStringExtra("acquire_url_start");
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog) { }
        Log.e("acquire_url_start", (new StringBuilder("acquire_url_start=")).append(acquire_url_start).toString());
        if (acquire_url_start.equals("") || acquire_url_start == null) goto _L8; else goto _L7
_L7:
        if (!acquire_url_start.startsWith("aio")) goto _L10; else goto _L9
_L4:
        try
        {
            Myutils.setting_json.put("shotcut", true);
            Myutils.saveSetting();
        }
        // Misplaced declaration of an exception variable
        catch (final Bundle dialog)
        {
            try
            {
                Myutils.setting_json.put("shotcut", false);
                Myutils.saveSetting();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((JSONException) (obj)).printStackTrace();
            }
            dialog.printStackTrace();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj1 = (ApplicationInfo)((List) (obj)).get(i);
        if ((((ApplicationInfo)((List) (obj)).get(i)).flags & 1) == 0)
        {
            obj1 = new Info();
            ((Info) (obj1)).setName(dialog.getApplicationLabel((ApplicationInfo)((List) (obj)).get(i)).toString());
            ((Info) (obj1)).setIcon(((ApplicationInfo)((List) (obj)).get(i)).loadIcon(dialog));
            ((Info) (obj1)).setPackagename(((ApplicationInfo)((List) (obj)).get(i)).packageName);
            infos.add(obj1);
        }
        i++;
          goto _L11
_L9:
        MobclickAgent.onEvent(getApplicationContext(), "acquire_aio");
        dialog = acquire_url_start.split("=");
        version = dialog[dialog.length - 1];
        appid = acquire_url_start.split("bundle_id=")[1].split("&")[0];
        Log.e("goo", (new StringBuilder("++++")).append(appid).toString());
        if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
        {
            downwifi();
            return;
        }
        if (dbUtils.queryfile(appid) == null)
        {
            (new Thread() {

                final MyMainActivity this$0;

                public void run()
                {
                    super.run();
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_aio&action=")).append(appid).toString());
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).start();
            (new AsyncTask() {

                private DownloadMovieItem model_aio;
                final MyMainActivity this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    avoid = (new StringBuilder("http://android.downloadatoz.com/_201409/market/app_detail_more.php?url_id=")).append(appid).toString();
                    Log.e("goo", (new StringBuilder("url=")).append(avoid).toString());
                    avoid = publicTools.getUrl(avoid);
                    if (avoid != null) goto _L2; else goto _L1
_L1:
                    return null;
_L2:
                    if ((avoid = new JSONObject(avoid)).getInt("status") != 1) goto _L1; else goto _L3
_L3:
                    model_aio = new DownloadMovieItem();
                    avoid = avoid.getJSONObject("pdt");
                    model_aio.setTitle(avoid.getString("title"));
                    model_aio.setAuthor_title(avoid.getString("author_title"));
                    model_aio.setIcon(avoid.getString("icon"));
                    model_aio.setVersion(avoid.getString("version"));
                    model_aio.setSerial(avoid.getInt("serial"));
                    return null;
                    avoid;
                    avoid.printStackTrace();
                    return null;
                }

                protected volatile void onPostExecute(Object obj2)
                {
                    onPostExecute((Void)obj2);
                }

                protected void onPostExecute(Void void1)
                {
                    super.onPostExecute(void1);
                    try
                    {
                        MydownloadApk6(appid, model_aio.getTitle(), model_aio.getIcon(), model_aio.getSerial());
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void void1)
                    {
                        return;
                    }
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).execute(new Void[0]);
        } else
        {
            Mydialog();
        }
_L8:
        startService(new Intent(getApplicationContext(), com/aio/downloader/service/BatteryInfoService1));
        startService(new Intent(getApplicationContext(), com/aio/downloader/service/ServiceGallery));
        startService(new Intent(getApplicationContext(), com/aio/downloader/service/ServiceToggle));
        startService(new Intent(getApplicationContext(), com/aio/downloader/service/ServiceCleaner));
        startService(new Intent(getApplicationContext(), com/aio/downloader/service/ServiceUpdate));
        Log.e("qwa", (new StringBuilder(String.valueOf(android.os.Build.VERSION.RELEASE))).append("===").toString());
        getAllAppInfo();
        dEVICE_ID = ((TelephonyManager)getSystemService("phone")).getDeviceId();
        Log.e("gog", (new StringBuilder("DEVICE_ID=")).append(dEVICE_ID).append("\u624B\u673A\u578B\u53F7\uFF1A").append(Build.MODEL).toString());
        getNewApps();
        (new Timer()).schedule(new TimerTask() {

            final MyMainActivity this$0;

            public void run()
            {
                Intent intent = new Intent("\u53D1\u9001\u5E7F\u64AD");
                sendBroadcast(intent);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        }, 1000L, 30000L);
        return;
_L10:
        if ((acquire_url_start.startsWith("http") || acquire_url_start.startsWith("https")) && acquire_url_start.endsWith(".apk"))
        {
            s2 = acquire_url_start.split("/")[1].split(".apk")[0];
            if (s2.equals(""))
            {
                s2 = acquire_url_start;
            }
            Log.e("gak", (new StringBuilder("acquire_url_start____http===========")).append(s2).toString());
            MobclickAgent.onEvent(getApplicationContext(), "acquire_apk");
            if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
            {
                downwifi();
                return;
            }
            if (dbUtils.queryfile(s2) == null)
            {
                (new Thread() {

                    final MyMainActivity this$0;

                    public void run()
                    {
                        super.run();
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_web&action=")).append(s2).toString());
                    }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
                }).start();
                MydownloadApk3(s2, s2, "http://android.downloadatoz.com/_201409/img/aio_default_icon.png", 0x2488f0);
            } else
            {
                Mydialog();
            }
        } else
        if (acquire_url_start.startsWith("market"))
        {
            Log.e("gak", "market");
            apkname = acquire_url_start.split("=")[1].split("&")[0];
            Log.e("gak", (new StringBuilder("s1=")).append(apkname).toString());
            MobclickAgent.onEvent(getApplicationContext(), "acquire__market");
            (new Thread() {

                final MyMainActivity this$0;

                public void run()
                {
                    super.run();
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_market&action=")).append(apkname).toString());
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).start();
            dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            dialog.putExtra("myid", apkname);
            dialog.putExtra("linkurl", "");
            startActivity(dialog);
        } else
        if ((acquire_url_start.startsWith("http") || acquire_url_start.startsWith("https")) && acquire_url_start.contains(".mp3"))
        {
            Log.e("gak", "mp3");
            MobclickAgent.onEvent(getApplicationContext(), "acquire_mp3");
            dialog = acquire_url_start.split("/");
            apkname_mp3 = dialog[dialog.length - 1].split(".mp3")[0];
            if (apkname_mp3.equals(""))
            {
                apkname_mp3 = acquire_url_start;
            }
            try
            {
                apkname_mp3 = URLDecoder.decode(apkname_mp3, "utf-8");
            }
            // Misplaced declaration of an exception variable
            catch (final Bundle dialog)
            {
                dialog.printStackTrace();
            }
            if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
            {
                downwifi();
                return;
            }
            if (dbUtils.queryfile(apkname_mp3) == null)
            {
                (new Thread() {

                    final MyMainActivity this$0;

                    public void run()
                    {
                        super.run();
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_mp3&action=")).append(apkname_mp3).toString());
                    }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
                }).start();
                MydownloadApk4(apkname_mp3, apkname_mp3, "http://android.downloadatoz.com/_201409/market/img/mp3.png", 0x2488f0);
            } else
            {
                Mydialog();
            }
        } else
        if ((acquire_url_start.startsWith("http") || acquire_url_start.startsWith("https")) && acquire_url_start.contains(".mp4"))
        {
            Log.e("gak", "mp4");
            MobclickAgent.onEvent(getApplicationContext(), "acquire_mp4");
            dialog = acquire_url_start.split("/");
            apkname_mp4 = dialog[dialog.length - 1].split(".mp4")[0];
            if (apkname_mp4.equals(""))
            {
                apkname_mp4 = acquire_url_start;
            }
            try
            {
                apkname_mp4 = URLDecoder.decode(apkname_mp4, "utf-8");
            }
            // Misplaced declaration of an exception variable
            catch (final Bundle dialog)
            {
                dialog.printStackTrace();
            }
            if (spnetworkre.getBoolean("isopen", false) && NetWorkUtil.getAPNType(getApplicationContext()) != 1)
            {
                downwifi();
                return;
            }
            if (dbUtils.queryfile(apkname_mp4) == null)
            {
                (new Thread() {

                    final MyMainActivity this$0;

                    public void run()
                    {
                        super.run();
                        publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_mp4&action=")).append(apkname_mp4).toString());
                    }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
                }).start();
                MydownloadApk5(apkname_mp4, apkname_mp4, "http://android.downloadatoz.com/_201409/img/video_icon.png", 0x2488f0);
            } else
            {
                Mydialog();
            }
        } else
        if ((acquire_url_start.startsWith("http") || acquire_url_start.startsWith("https")) && acquire_url_start.contains("play.google.com"))
        {
            Log.e("gak", "market");
            dialog = acquire_url_start.split("id=");
            apkname_google = dialog[dialog.length - 1].split("&")[0];
            Log.e("gak", (new StringBuilder("s1=")).append(apkname_google).toString());
            MobclickAgent.onEvent(getApplicationContext(), "acquire_play");
            (new Thread() {

                final MyMainActivity this$0;

                public void run()
                {
                    super.run();
                    publicTools.getUrl((new StringBuilder("http://android.downloadatoz.com/_201409/market/hits.php?type=downloader_market&action=")).append(apkname_google).toString());
                }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
            }).start();
            dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            dialog.putExtra("myid", apkname_google);
            dialog.putExtra("linkurl", "");
            startActivity(dialog);
        } else
        {
            MobclickAgent.onEvent(getApplicationContext(), "acquire_webview");
            dialog = new Intent(getApplicationContext(), com/aio/downloader/activity/AcquireWebview);
            dialog.putExtra("url_load", acquire_url_start);
            startActivity(dialog);
        }
        if (true) goto _L8; else goto _L12
_L12:
        if (true) goto _L2; else goto _L13
_L13:
    }

    protected void onDestroy()
    {
        super.onDestroy();
        downloadManager.release();
        downloadManager_battery.release();
        downloadManager_free.release();
        downloadManager_gallery.release();
        downloadManager_cleaner.release();
        downloadManager_caller.release();
        downloadManager_crush.release();
        try
        {
            mNotificationManager8.cancel(19);
        }
        catch (Exception exception) { }
        if (interstitialAd != null)
        {
            interstitialAd.destroy();
        }
    }

    public void onDismiss(ListView listview, int ai[])
    {
    }

    public void onError(Ad ad, AdError aderror)
    {
        Log.e("www", (new StringBuilder("error")).append(aderror.getErrorMessage()).toString());
        Myutils.fb_ad = false;
    }

    public void onInterstitialDismissed(Ad ad)
    {
    }

    public void onInterstitialDisplayed(Ad ad)
    {
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4 && keyevent.getRepeatCount() == 0 && mDrawerLayout.isDrawerOpen(3))
        {
            mDrawerLayout.closeDrawer(3);
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onLoad(PullableListView pullablelistview)
    {
        if (list.size() > 0)
        {
            next = ((DownloadMovieItem)((ArrayList)list.get(list.size() - 1)).get(0)).getHas_next_page();
        }
        if (next == 1)
        {
            page = page + 1;
            (new Mya2()).execute(new Void[0]);
            return;
        } else
        {
            listView.setHasMoreData(false);
            return;
        }
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
        windowFocus = false;
        Log.e("www", "onPause");
    }

    public void onResume()
    {
        super.onResume();
        Log.e("gak", "shouyeonResume");
        MobclickAgent.onResume(this);
        windowFocus = true;
        int i;
        try
        {
            publicTools.getKey();
        }
        catch (Exception exception1) { }
        try
        {
            db = new FinalDBChen(this, getDatabasePath("download2.db").getAbsolutePath());
            ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
            i = ds.size();
        }
        catch (Exception exception)
        {
            return;
        }
        if (i == 0) goto _L2; else goto _L1
_L1:
        badgedownimg.setText(String.valueOf(i));
        badgedownimg.show();
        badgedowntv.setText(String.valueOf(i));
        badgedowntv.show();
_L4:
        (new Timer()).schedule(new TimerTask() {

            final MyMainActivity this$0;

            public void run()
            {
                Message message = new Message();
                message.what = 30000;
                handler.sendMessage(message);
            }

            
            {
                this$0 = MyMainActivity.this;
                super();
            }
        }, 3000L, 10000L);
        return;
_L2:
        if (i != 0) goto _L4; else goto _L3
_L3:
        badgedownimg.hide();
        badgedowntv.hide();
          goto _L4
    }

    protected void onStop()
    {
        super.onStop();
        publicTools.tagtanchuang = false;
    }

    public void toDownload(DownloadMovieItem downloadmovieitem)
    {
        downloadmovieitem.setDownloadState(Integer.valueOf(7));
        getMyApp().setStartDownloadMovieItem(downloadmovieitem);
        sendBroadcast((new Intent()).setAction("download_aio"));
        if (db.findItemsByWhereAndWhereValue("movieName", downloadmovieitem.getMovieName(), com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null).size() == 0)
        {
            db.insertObject(downloadmovieitem, "downloadtask2");
            return;
        } else
        {
            db.updateValuesByJavaBean("downloadtask2", "movieName=?", new String[] {
                downloadmovieitem.getMovieName()
            }, downloadmovieitem);
            return;
        }
    }




































































































}
