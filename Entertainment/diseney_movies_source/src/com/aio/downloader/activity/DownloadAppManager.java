// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.aio.downloader.mydownload.ContentValue;
import com.aio.downloader.mydownload.DownloadMovieItem;
import com.aio.downloader.unstall.Move2NOSD;
import com.aio.downloader.unstall.Move2SDActivity;
import com.aio.downloader.unstall.MyAppActivity;
import com.aio.downloader.unstall.Unstall;
import com.aio.downloader.utils.MemoryManager;
import com.aio.downloader.utils.Myutils;
import com.aio.downloader.utils.Updatesize;
import com.aio.downloader.views.BadgeView;
import com.aio.downloader.views.LFrameLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.NativeAd;
import com.umeng.analytics.MobclickAgent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import net.tsz.afinal.FinalDBChen;

// Referenced classes of package com.aio.downloader.activity:
//            UpdateActivity, MyDownloaderList, AppDetailsActivity, BackupActivity

public class DownloadAppManager extends Activity
    implements android.view.View.OnClickListener, ContentValue, AdListener
{

    private File AIOBATTERY;
    private File AIOBATTERYAPK;
    private File AIOCALLERAPK;
    private File AIOCALLERDOWN;
    private File AIOGALLERY;
    private File AIOGALLERYAPK;
    private File PRO_DIR;
    private File PRO_DIR_FOME;
    private File PRO_DIR_TO;
    private BadgeView badgedownimg_downlaod;
    private BadgeView badgedownimg_update;
    private FinalDBChen db;
    private List ds;
    private long firstsd;
    private ImageView iv_fb_manage;
    private ImageView iv_manager_download;
    private ImageView iv_manager_update;
    private LFrameLayout lf_fb_manager;
    private MemoryManager memoryManager;
    private NativeAd nativeAd;
    PackageInfo packageInfo;
    private long sencondsd;
    private TextView tv_fb_tv;

    public DownloadAppManager()
    {
        packageInfo = null;
        PRO_DIR_FOME = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.apk").toString());
        PRO_DIR_TO = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner/cleaner.swf").toString());
        PRO_DIR = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/cleaner").toString());
        AIOBATTERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.swf").toString());
        AIOBATTERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("battery.apk").toString());
        AIOGALLERY = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.swf").toString());
        AIOGALLERYAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("gallery.apk").toString());
        AIOCALLERDOWN = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.swf").toString());
        AIOCALLERAPK = new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().toString()))).append("/AIOSWF").append(File.separator).append("caller.apk").toString());
        sencondsd = 0L;
        firstsd = 0L;
    }

    private boolean ExistSDCard()
    {
        return Environment.getExternalStorageState().equals("mounted");
    }

    private void backupApp(String s)
        throws IOException
    {
        Object obj = new File((new StringBuilder("/data/app/")).append(s).append(".apk").toString());
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/").append("AIO_BACKUPAPP").append("/").append(s).append(".apk").toString());
        file.createNewFile();
        s = new FileInputStream(((File) (obj)));
        obj = new FileOutputStream(file);
        byte abyte0[] = new byte[0x40000];
        do
        {
            int i = s.read(abyte0);
            if (i <= 0)
            {
                s.close();
                ((FileOutputStream) (obj)).flush();
                ((FileOutputStream) (obj)).close();
                return;
            }
            ((FileOutputStream) (obj)).write(abyte0, 0, i);
        } while (true);
    }

    private String backupApplication(String s, String s1)
    {
        if (s != null && s.length() != 0 && s1 != null && s1.length() != 0) goto _L2; else goto _L1
_L1:
        s1 = "illegal parameters";
_L5:
        return s1;
_L2:
        byte abyte0[];
        Object obj1;
        FileInputStream fileinputstream;
        int i;
        s = (new StringBuilder("/data/app/")).append(s).append("-1.apk").toString();
        File file = new File(s);
        if (!file.exists())
        {
            Log.e("backup", "apkfile\u4E3A\u7A7A");
            if (!file.exists())
            {
                return (new StringBuilder(String.valueOf(s))).append(" doesn't exist!").toString();
            }
        }
        try
        {
            fileinputstream = new FileInputStream(file);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return s.getMessage();
        }
        i = s1.lastIndexOf('/');
        if (i != -1)
        {
            (new File(s1.substring(0, i))).mkdirs();
        }
        abyte0 = new byte[1024];
        s = null;
        obj1 = null;
        s1 = new FileOutputStream(s1);
_L3:
        i = fileinputstream.read(abyte0, 0, abyte0.length);
        Object obj;
        if (i == -1)
        {
            if (s1 != null)
            {
                try
                {
                    s1.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return s.getMessage();
                }
            }
            if (fileinputstream != null)
            {
                try
                {
                    fileinputstream.close();
                }
                // Misplaced declaration of an exception variable
                catch (String s)
                {
                    s.printStackTrace();
                    return s.getMessage();
                }
            }
            return "success";
        }
        s1.write(abyte0, 0, i);
          goto _L3
        obj;
_L8:
        s = s1;
        ((IOException) (obj)).printStackTrace();
        s = s1;
        obj = ((IOException) (obj)).getMessage();
        s = ((String) (obj));
        if (s1 != null)
        {
            try
            {
                s1.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return s.getMessage();
            }
        }
        s1 = s;
        if (fileinputstream == null) goto _L5; else goto _L4
_L4:
        try
        {
            fileinputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return s.getMessage();
        }
        return s;
        s1;
_L7:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return s.getMessage();
            }
        }
        if (fileinputstream != null)
        {
            try
            {
                fileinputstream.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return s.getMessage();
            }
        }
        throw s1;
        obj;
        s = s1;
        s1 = ((String) (obj));
        if (true) goto _L7; else goto _L6
_L6:
        obj;
        s1 = obj1;
          goto _L8
    }

    private void facebookad()
    {
        NativeAd.downloadAndDisplayImage(nativeAd.getAdIcon(), iv_fb_manage);
        tv_fb_tv.setText(nativeAd.getAdTitle());
        nativeAd.registerViewForInteraction(lf_fb_manager);
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

    public void onAdClicked(Ad ad)
    {
    }

    public void onAdLoaded(Ad ad)
    {
        if (nativeAd == null || nativeAd != ad)
        {
            return;
        } else
        {
            nativeAd.unregisterView();
            facebookad();
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131165950 2131165967: default 92
    //                   2131165950 169
    //                   2131165951 150
    //                   2131165952 92
    //                   2131165953 112
    //                   2131165954 92
    //                   2131165955 92
    //                   2131165956 92
    //                   2131165957 92
    //                   2131165958 93
    //                   2131165959 131
    //                   2131165960 1236
    //                   2131165961 1344
    //                   2131165962 174
    //                   2131165963 374
    //                   2131165964 598
    //                   2131165965 822
    //                   2131165966 917
    //                   2131165967 1012;
           goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1 _L1 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        return;
_L5:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/Unstall));
        return;
_L4:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/UpdateActivity));
        return;
_L6:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/MyAppActivity));
        return;
_L3:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/MyDownloaderList));
        return;
_L2:
        finish();
        return;
_L9:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.evzapp.cleanmaster", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo == null)
        {
            if (PRO_DIR_FOME.exists())
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(PRO_DIR).append(File.separator).append("cleaner.apk").toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
            if (PRO_DIR_TO.exists())
            {
                (new AsyncTask() {

                    final DownloadAppManager this$0;

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
                this$0 = DownloadAppManager.this;
                super();
            }
                }).execute(new Void[0]);
                return;
            } else
            {
                view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
                view.putExtra("myid", "com.evzapp.cleanmaster");
                view.addFlags(0x10000000);
                startActivity(view);
                return;
            }
        } else
        {
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.cleanmaster");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
        }
_L10:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.battery", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L16; else goto _L15
_L15:
        try
        {
            if (AIOBATTERYAPK.exists() && getFileSizes(AIOBATTERYAPK) >= 0x377effL)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOBATTERYAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
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
        if (AIOBATTERY.exists() && getFileSizes(AIOBATTERY) >= 0x377effL)
        {
            (new AsyncTask() {

                final DownloadAppManager this$0;

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
                this$0 = DownloadAppManager.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.aioapp.battery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L16:
        view = getPackageManager().getLaunchIntentForPackage("com.aioapp.battery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L11:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.gallery", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L18; else goto _L17
_L17:
        try
        {
            if (AIOGALLERYAPK.exists() && getFileSizes(AIOGALLERYAPK) >= 0x1bff04L)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
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
        if (AIOGALLERY.exists() && getFileSizes(AIOGALLERYAPK) >= 0x1bff04L)
        {
            (new AsyncTask() {

                final DownloadAppManager this$0;

                protected volatile transient Object doInBackground(Object aobj[])
                {
                    return doInBackground((Void[])aobj);
                }

                protected transient Void doInBackground(Void avoid[])
                {
                    Myutils.copyfile(AIOGALLERY, AIOGALLERYAPK, Boolean.valueOf(false));
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
                    void1.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOGALLERYAPK).toString()), "application/vnd.android.package-archive");
                    void1.addFlags(0x10000000);
                    startActivity(void1);
                }

            
            {
                this$0 = DownloadAppManager.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.androidapp.gallary3d");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L18:
        view = getPackageManager().getLaunchIntentForPackage("com.aioapp.gallery");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L12:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.aioapp.wallpaper", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo == null)
        {
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.aioapp.wallpaper");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
        } else
        {
            view = getPackageManager().getLaunchIntentForPackage("com.aioapp.wallpaper");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
        }
_L13:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.evzapp.mydiylocker", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo == null)
        {
            view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
            view.putExtra("myid", "com.evzapp.mydiylocker");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
        } else
        {
            view = getPackageManager().getLaunchIntentForPackage("com.evzapp.mydiylocker");
            view.addFlags(0x10000000);
            startActivity(view);
            return;
        }
_L14:
        try
        {
            packageInfo = getPackageManager().getPackageInfo("com.allinone.callerid", 0);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
        }
        if (packageInfo != null) goto _L20; else goto _L19
_L19:
        try
        {
            if (AIOCALLERAPK.exists() && getFileSizes(AIOCALLERAPK) >= 0x357458L)
            {
                view = new Intent("android.intent.action.VIEW");
                view.setDataAndType(Uri.parse((new StringBuilder("file://")).append(AIOCALLERAPK).toString()), "application/vnd.android.package-archive");
                view.addFlags(0x10000000);
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
        if (AIOCALLERDOWN.exists() && getFileSizes(AIOCALLERDOWN) >= 0x357458L)
        {
            (new AsyncTask() {

                final DownloadAppManager this$0;

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
                this$0 = DownloadAppManager.this;
                super();
            }
            }).execute(new Void[0]);
            return;
        }
        view = new Intent(getApplicationContext(), com/aio/downloader/activity/AppDetailsActivity);
        view.putExtra("myid", "com.allinone.callerid");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L20:
        view = getPackageManager().getLaunchIntentForPackage("com.allinone.callerid");
        view.addFlags(0x10000000);
        startActivity(view);
        return;
_L7:
        if (sencondsd == 0L)
        {
            startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/Move2NOSD));
        } else
        {
            startActivity(new Intent(getApplicationContext(), com/aio/downloader/unstall/Move2SDActivity));
        }
        Log.e("qqq", (new StringBuilder("diyi=")).append(memoryManager.getSDTotalSize()).append("dier=").append(memoryManager.getSecondSDTotalSize()).append("guangfang=").append(ExistSDCard()).toString());
        return;
_L8:
        startActivity(new Intent(getApplicationContext(), com/aio/downloader/activity/BackupActivity));
        return;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030081);
        lf_fb_manager = (LFrameLayout)findViewById(0x7f070303);
        iv_fb_manage = (ImageView)findViewById(0x7f070304);
        tv_fb_tv = (TextView)findViewById(0x7f070305);
        bundle = (LFrameLayout)findViewById(0x7f070306);
        LFrameLayout lframelayout = (LFrameLayout)findViewById(0x7f070301);
        LFrameLayout lframelayout1 = (LFrameLayout)findViewById(0x7f070307);
        LFrameLayout lframelayout2 = (LFrameLayout)findViewById(0x7f0702ff);
        memoryManager = new MemoryManager(getApplicationContext());
        sencondsd = memoryManager.getSecondSDTotalSize();
        firstsd = memoryManager.getSDTotalSize();
        findViewById(0x7f0702fe).setOnClickListener(this);
        findViewById(0x7f070308).setOnClickListener(this);
        findViewById(0x7f070309).setOnClickListener(this);
        findViewById(0x7f07030a).setOnClickListener(this);
        findViewById(0x7f07030b).setOnClickListener(this);
        findViewById(0x7f07030c).setOnClickListener(this);
        findViewById(0x7f07030d).setOnClickListener(this);
        findViewById(0x7f07030e).setOnClickListener(this);
        findViewById(0x7f07030f).setOnClickListener(this);
        iv_manager_download = (ImageView)findViewById(0x7f070300);
        iv_manager_update = (ImageView)findViewById(0x7f070302);
        bundle.setOnClickListener(this);
        lframelayout.setOnClickListener(this);
        lframelayout1.setOnClickListener(this);
        lframelayout2.setOnClickListener(this);
        badgedownimg_downlaod = new BadgeView(getApplicationContext(), iv_manager_download);
        badgedownimg_update = new BadgeView(getApplicationContext(), iv_manager_update);
        nativeAd = new NativeAd(getApplicationContext(), "340186902832477_436045399913293");
        nativeAd.setAdListener(this);
        nativeAd.loadAd(com.facebook.ads.NativeAd.MediaCacheFlag.ALL);
    }

    public void onError(Ad ad, AdError aderror)
    {
    }

    public void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    public void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
        int i;
        try
        {
            db = new FinalDBChen(getApplicationContext(), getDatabasePath("download2.db").getAbsolutePath());
            ds = db.findItemsByWhereAndWhereValue(null, null, com/aio/downloader/mydownload/DownloadMovieItem, "downloadtask2", null);
        }
        catch (Exception exception) { }
        i = ds.size();
        if (i == 0) goto _L2; else goto _L1
_L1:
        badgedownimg_downlaod.setText(String.valueOf(i));
        badgedownimg_downlaod.show();
_L8:
        i = Updatesize.getUpdatesize().list_update.size();
        if (i == 0) goto _L4; else goto _L3
_L3:
        badgedownimg_update.setText(String.valueOf(i));
        badgedownimg_update.show();
_L6:
        return;
_L2:
        if (i == 0)
        {
            badgedownimg_downlaod.hide();
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (i != 0) goto _L6; else goto _L5
_L5:
        badgedownimg_update.hide();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }









}
