// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotobeauty;

import acp;
import acq;
import acr;
import acs;
import act;
import acu;
import acv;
import acw;
import acx;
import acy;
import acz;
import ada;
import adb;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import anz;
import aoc;
import aoo;
import apn;
import apq;
import aqe;
import aqx;
import axw;
import bgx;
import bic;
import bie;
import biv;
import bos;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.FotoAdStrategy;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.ad.HeartBeatAsyncTask;
import com.fotoable.ad.HomeWallFactory;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.adbuttonlib.TAdButtonGroup;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.alertAd.TAlertAdActivity;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCamera;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNew;
import com.fotoable.beautyui.gpuimage.sample.activity.ActivityCameraNoRealtime;
import com.fotoable.beautyui.newui.MNewFotoBeautyActivity;
import com.fotoable.comlib.util.ImageCache;
import com.fotoable.fullscreenad.FullScreenAdView;
import com.instabeauty.application.InstaBeautyApplication;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.wantu.activity.guide.GuideViewAcitivity;
import com.wantu.activity.mainpage.MainViewPagerAdapter;
import com.wantu.activity.photoselector.InstaRandomPhotoSelectorActivity;
import com.wantu.activity.photoselector.MultiPhotoSelectorActivity;
import com.wantu.activity.photoselector.SinglePhotoSelectorActivity;
import hk;
import ho;
import hp;
import hu;
import hz;
import ie;
import java.io.File;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;
import pt;
import yp;

// Referenced classes of package com.fotoable.fotobeauty:
//            FullscreenActivity, NewPhotoShareActivity

public class WantuActivity extends FullscreenActivity
    implements anz, bie, biv, com.fotoable.ad.HomeWallFactory.HomeWallClickListener, com.fotoable.ad.HomeWallFactory.fotoHomeWalladListener, hp
{

    public static String a = "WantuActivity";
    private hz A;
    private FullScreenAdView B;
    String b;
    String c;
    ImageView d;
    ImageView e;
    ViewPager f;
    MainViewPagerAdapter g;
    String h;
    FrameLayout i;
    bic j;
    boolean k;
    RelativeLayout l;
    boolean m;
    String n;
    DownloadManager o;
    long p;
    BroadcastReceiver q;
    public Handler r;
    public int s;
    public adb t;
    private FrameLayout u;
    private View v;
    private View w;
    private IWXAPI x;
    private boolean y;
    private ho z;

    public WantuActivity()
    {
        b = "AlertAd";
        c = "alertTime";
        y = false;
        h = "";
        j = null;
        k = false;
        z = null;
        A = new acz(this);
        m = true;
        n = "";
        p = -1L;
        r = new acq(this);
        s = 1000;
        t = new adb(this);
    }

    public static FullScreenAdView a(WantuActivity wantuactivity, FullScreenAdView fullscreenadview)
    {
        wantuactivity.B = fullscreenadview;
        return fullscreenadview;
    }

    public static hz a(WantuActivity wantuactivity)
    {
        return wantuactivity.A;
    }

    private void a(int i1, int j1, Intent intent)
    {
        if (intent == null)
        {
            return;
        } else
        {
            c(intent.getData());
            return;
        }
    }

    private void a(long l1)
    {
        if (l1 != -1L)
        {
            t.a = l1;
            r.postDelayed(t, s);
        }
    }

    private void a(Uri uri)
    {
        FlurryAgent.logEvent("pipmodel1BtnClicked");
        Intent intent = new Intent(this, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
        intent.putExtra(MNewFotoBeautyActivity.b, uri.toString());
        intent.putExtra(MNewFotoBeautyActivity.a, 2);
        intent.putExtra(MNewFotoBeautyActivity.g, 12);
        startActivity(intent);
    }

    private void a(View view)
    {
        FlurryAgent.logEvent("HomeButton_ContinuClick");
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            if (pt.b(pt.h, this, true))
            {
                view = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCamera);
                view.putExtra(ActivityCamera.a, false);
                startActivity(view);
                return;
            } else
            {
                view = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNoRealtime);
                view.putExtra(ActivityCameraNoRealtime.e, false);
                startActivity(view);
                return;
            }
        }
        if (pt.b(pt.h, this, true))
        {
            Log.e("yyy1", "ActivityCameraNew");
            ActivityCameraNew.c(this, 1111);
            return;
        } else
        {
            Log.e("yyy1", "ActivityCameraNoRealtime");
            view = new Intent(this, com/fotoable/beautyui/gpuimage/sample/activity/ActivityCameraNoRealtime);
            view.putExtra(ActivityCameraNoRealtime.e, false);
            startActivity(view);
            return;
        }
    }

    public static void a(WantuActivity wantuactivity, long l1)
    {
        wantuactivity.b(l1);
    }

    public static void a(WantuActivity wantuactivity, String s1)
    {
        wantuactivity.c(s1);
    }

    public static boolean a(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 0xf) == 1;
    }

    public static boolean a(WantuActivity wantuactivity, boolean flag)
    {
        wantuactivity.y = flag;
        return flag;
    }

    private Dialog b(Context context)
    {
        context = new android.app.AlertDialog.Builder(context);
        context.setIcon(0x7f02034c);
        context.setTitle(getResources().getString(0x7f0602f5));
        context.setMessage(getResources().getString(0x7f060161));
        context.setPositiveButton(getResources().getString(0x7f06014a), null);
        return context.create();
    }

    public static FullScreenAdView b(WantuActivity wantuactivity)
    {
        return wantuactivity.B;
    }

    private void b(int i1, int j1, Intent intent)
    {
        intent = Uri.fromFile(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/capture.jpg").toString()));
        Log.v("url", intent.toString());
        try
        {
            intent.getPath();
            b(((Uri) (intent)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Crashlytics.logException(intent);
        }
        System.out.println(intent.getMessage());
        intent.getMessage();
    }

    private void b(long l1)
    {
        Cursor cursor = o.query((new android.app.DownloadManager.Query()).setFilterById(new long[] {
            l1
        }));
        if (cursor == null)
        {
            Toast.makeText(this, "Download not found!", 1).show();
            return;
        }
        if (!cursor.moveToFirst())
        {
            cursor.close();
            return;
        } else
        {
            Log.d(a, (new StringBuilder()).append("Column_id : ").append(cursor.getLong(cursor.getColumnIndex("_id"))).toString());
            Log.d(a, (new StringBuilder()).append("Column_bytes_downloaded so far : ").append(cursor.getLong(cursor.getColumnIndex("bytes_so_far"))).toString());
            Log.d(a, (new StringBuilder()).append("Column last modified timestamp : ").append(cursor.getLong(cursor.getColumnIndex("last_modified_timestamp"))).toString());
            Log.d(a, (new StringBuilder()).append("Column local uri : ").append(cursor.getString(cursor.getColumnIndex("local_uri"))).toString());
            Log.d(a, (new StringBuilder()).append("Column statue : ").append(cursor.getInt(cursor.getColumnIndex("status"))).toString());
            Log.d(a, (new StringBuilder()).append("Column reason : ").append(cursor.getInt(cursor.getColumnIndex("reason"))).toString());
            cursor.getInt(cursor.getColumnIndex("status"));
            cursor.close();
            return;
        }
    }

    private void b(Uri uri)
    {
        Intent intent = new Intent(this, com/fotoable/beautyui/newui/MNewFotoBeautyActivity);
        intent.putExtra(MNewFotoBeautyActivity.b, uri.toString());
        startActivity(intent);
    }

    private void c(Uri uri)
    {
        if (uri == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        if (uri.toString().length() > 0)
        {
            Log.v("url", uri.toString());
            a(uri);
            return;
        }
        try
        {
            FlurryAgent.onError((new StringBuilder()).append(a).append("002").toString(), "unexpected", "002");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            Crashlytics.logException(uri);
        }
        uri.printStackTrace();
        return;
    }

    public static void c(WantuActivity wantuactivity)
    {
        wantuactivity.j();
    }

    private void c(String s1)
    {
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (s1.length() <= 0)
        {
            return;
        }
        try
        {
            Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
            intent.putExtra("webUriString", s1);
            startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
    }

    public static void d(WantuActivity wantuactivity)
    {
        wantuactivity.h();
    }

    private void d(String s1)
    {
        if (s1 == null || s1.length() == 0)
        {
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = InstaBeautyApplication.a().b().getSharedPreferences("config", 0).edit();
            editor.putString("instamaglastupdatetime", s1);
            editor.apply();
            return;
        }
    }

    private Uri e(String s1)
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/download").toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        return Uri.fromFile(new File(file, s1));
    }

    private void g()
    {
        int i1 = aqx.a(this, "appOpenedTimes", 0) + 1;
        aqx.b(this, "appOpenedTimes", i1);
        FotoAdMediationDB.setUserRecord(this, i1);
    }

    private void h()
    {
        try
        {
            x = WXAPIFactory.createWXAPI(this, "wx283019eeca171807", false);
            if (x.registerApp("wx283019eeca171807"))
            {
                Log.v(a, "regist we chat success");
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    private void i()
    {
        try
        {
            TAdButtonGroup.instance(getApplication()).removeAllAdButton();
        }
        catch (Exception exception1) { }
        try
        {
            HomeWallFactory.clearView();
            HomeWallFactory.clearNativeView();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void j()
    {
        (new Handler()).postDelayed(new acy(this), 500L);
    }

    private boolean k()
    {
        SharedPreferences sharedpreferences;
        boolean flag1;
        aoc.a(this).a();
        sharedpreferences = getSharedPreferences("isNeedGotoGuideView", 0);
        flag1 = sharedpreferences.getBoolean("guideViewShown", false);
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_225;
        }
        if (!m || !aoc.a(this).f())
        {
            break MISSING_BLOCK_LABEL_225;
        }
        if (B == null)
        {
            B = new FullScreenAdView(this);
        }
        B.setOnAdviewListener(new ada(this));
        if (!aoc.a(this).g()) goto _L2; else goto _L1
_L1:
        B.loadImage();
_L3:
        if (!yp.a())
        {
            break MISSING_BLOCK_LABEL_212;
        }
        B.setLogo(0x7f02029e);
_L5:
        l.removeView(B);
        B.handleDismissAction();
        l.addView(B);
        aoc.a(this).d();
        Exception exception;
        for (boolean flag = true; !flag1; flag = false)
        {
            break MISSING_BLOCK_LABEL_165;
        }

        FotoAdFactory.createFBInterstial(InstaBeautyApplication.a, true);
        sharedpreferences.edit().putBoolean("guideViewShown", false).apply();
_L4:
        m = true;
        return flag;
_L2:
        B.loadDefaultImage();
          goto _L3
        exception;
        exception.printStackTrace();
        flag = false;
          goto _L4
        B.setLogo(0x7f02029f);
          goto _L5
    }

    private void l()
    {
        if (pt.b(pt.r, this, true))
        {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
            builder.setMessage(0x7f0601d4);
            builder.setTitle(0x7f0602ae);
            builder.setPositiveButton(0x7f06030c, new acr(this));
            builder.setNegativeButton(0x7f0600a8, new acs(this));
            builder.create().show();
            return;
        } else
        {
            Log.e("Hello", "startNewCameraClicked1");
            ActivityCameraNew.c(this, 1113);
            return;
        }
    }

    private void m()
    {
        (new Handler()).postDelayed(new act(this), 2000L);
    }

    public void OnAdBtnClicked(View view)
    {
    }

    public void OnAviaryBtnClicked(View view)
    {
        try
        {
            a();
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crashlytics.logException(view);
            Toast.makeText(this, 0x7f0601aa, 1).show();
        }
        FlurryAgent.logEvent("AviaryClciked");
    }

    public void OnInstaMagClicked(View view)
    {
        if (g != null && h != null && h.length() > 0)
        {
            d(h);
        }
        startActivity(new Intent(this, com/wantu/activity/photoselector/InstaRandomPhotoSelectorActivity));
        overridePendingTransition(0x7f04001c, 0x7f040025);
        FlurryAgent.logEvent("OnInstaMagPhotoslicked");
    }

    public void OnRequsetBtnClicked(View view)
    {
        FlurryAgent.logEvent("RequsetBtnClicked");
    }

    public void OnSettingBtnClicked(View view)
    {
    }

    public void OnThumbChooseBtnClicked(View view)
    {
        startActivity(new Intent(this, com/wantu/activity/photoselector/MultiPhotoSelectorActivity));
        FlurryAgent.logEvent("gifLibrary");
    }

    protected void a()
    {
        boolean flag1 = false;
        boolean flag;
        if (android.os.Build.VERSION.SDK_INT >= 15)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        new BeautyCameraGLSurfaceView(this);
        flag1 = true;
_L2:
        if (!flag || !flag1)
        {
            pt.b(pt.h, this, true);
            ActivityCameraNoRealtime.a(this, 1112);
            return;
        }
        if (pt.b(pt.h, this, true))
        {
            ActivityCameraNew.b(this, 1111);
            return;
        } else
        {
            ActivityCameraNoRealtime.a(this, 1112);
            return;
        }
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void a(int i1)
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/Download/").append("InstaMag_2_9_3.apk").toString());
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch -1 1: default 72
    //                   -1 121
    //                   0 78
    //                   1 96;
           goto _L2 _L3 _L4 _L5
_L2:
        j = null;
        return;
_L4:
        Log.i("PIPCameraActivity", "apk download canceled");
        file.delete();
        continue; /* Loop/switch isn't completed */
_L5:
        Log.i("PIPCameraActivity", "apk download finished");
        a(file);
        FlurryAgent.logEvent("ib_guide_finish_dowmload");
        continue; /* Loop/switch isn't completed */
_L3:
        Log.i("PIPCameraActivity", "apk download failed");
        file.delete();
        FlurryAgent.logEvent("ib_guide_failed_dowmload");
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void a(View view, String s1)
    {
        if (s1.compareTo("insta_mag") != 0) goto _L2; else goto _L1
_L1:
        OnInstaMagClicked(view);
_L4:
        if (s1.compareTo("prev_page") == 0)
        {
            f.setCurrentItem(0);
        }
        return;
_L2:
        if (s1.compareTo("pip") == 0)
        {
            pipAlbumBtnClicked(view);
        } else
        if (s1.compareTo("proedit") == 0)
        {
            OnAviaryBtnClicked(view);
        } else
        if (s1.compareTo("material") != 0)
        {
            if (s1.compareTo("continuscapture") == 0)
            {
                a(view);
            } else
            if (s1.compareTo("newcamera") == 0)
            {
                l();
            } else
            if (s1.compareTo("recordvideo") == 0)
            {
                b();
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(hk hk1)
    {
        if (hk1 != null)
        {
            hk1 = hk.a(hk1);
            if (hk1 != null)
            {
                Intent intent = new Intent(this, com/fotoable/alertAd/TAlertAdActivity);
                intent.putExtra("alertItemJson", hk1);
                startActivity(intent);
            }
        }
    }

    public void a(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public void a(String s1)
    {
        a("https://ad.apps.fm/HapKlUioEp5R_ay3kwbqXgPB6WEzBdlyL36ols3y74nvQMGv5ek5uhfXgwwOUiP7EIAZiIW7fK0MfPlil7T9EqgehOG-11deIgAp78WQRwg", "\u7F8E\u840C", "MeiMeng.apk");
    }

    public void a(String s1, String s2, String s3)
    {
        o = (DownloadManager)getSystemService("download");
        try
        {
            s1 = new android.app.DownloadManager.Request(Uri.parse(s1));
            s1.setTitle(s2);
            s1.setDestinationUri(e(s3));
            s1.setMimeType("application/cn.trinea.download.file");
            p = o.enqueue(s1);
            getSharedPreferences("SystemDownloadTask", 0).edit().putLong("downloadID", p).apply();
            FlurryAgent.logEvent("ib_guide_start_dowmload");
            Toast.makeText(this, (new StringBuilder()).append(s2).append("\u5F00\u59CB\u4E0B\u8F7D").toString(), 0).show();
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            return;
        }
        a(p);
    }

    protected void b()
    {
        FlurryAgent.logEvent("HomeButton_MovieClicked");
        ActivityCameraNew.d(this, 1111);
    }

    public void b(String s1)
    {
        if (aoo.b())
        {
            StaticFlurryEvent.logGCMEventWithKV("pushkey", "push_registered_success");
            StaticFlurryEvent.logGCMEventUnique(InstaBeautyApplication.a, "pushkey_Unique", "push_registered_success_Unique");
            HeartBeatAsyncTask.beat(this, true);
        }
    }

    public void c()
    {
        try
        {
            z = new ho(this, "instabeauty");
            z.a(this);
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public boolean d()
    {
        Object obj = (new StringBuilder()).append("isGuideNeedDownloadApp_");
        apq.c();
        obj = getSharedPreferences(((StringBuilder) (obj)).append(apq.a).toString(), 0);
        if (((SharedPreferences) (obj)).getString("activity", "") == "GuideViewActivity")
        {
            boolean flag = ((SharedPreferences) (obj)).getBoolean("isNeedDownloadApp", true);
            n = ((SharedPreferences) (obj)).getString("appName", "");
            obj = ((SharedPreferences) (obj)).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putString("activity", "no");
            ((android.content.SharedPreferences.Editor) (obj)).putBoolean("isNeedDownloadApp", false);
            ((android.content.SharedPreferences.Editor) (obj)).putString("appName", "");
            ((android.content.SharedPreferences.Editor) (obj)).apply();
            if (flag && n.equalsIgnoreCase(ie.i))
            {
                android.content.pm.PackageInfo packageinfo;
                try
                {
                    packageinfo = getPackageManager().getPackageInfo(n, 0);
                }
                catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
                {
                    namenotfoundexception.printStackTrace();
                    namenotfoundexception = null;
                }
                if (packageinfo == null)
                {
                    a(n);
                    return true;
                }
            }
        }
        return false;
    }

    public void e()
    {
    }

    public void f()
    {
        aoo.a().a(this, this, "847715203438");
        if (aoo.b())
        {
            break MISSING_BLOCK_LABEL_62;
        }
        FotoCustomReport.xgToken = aoo.a().a(getApplicationContext());
_L1:
        android.content.SharedPreferences.Editor editor = getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        editor.putBoolean("com.wantu.android.google.key", true);
        editor.apply();
        return;
        try
        {
            StaticFlurryEvent.logGCMEventWithKV("pushkey", "push_try_register");
            StaticFlurryEvent.logGCMEventUnique(InstaBeautyApplication.a, "pushkey_Unique", "push_try_register_Unique");
            FotoCustomReport.googleToken = aoo.a().a(getApplicationContext());
        }
        catch (Exception exception)
        {
            android.content.SharedPreferences.Editor editor1 = getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
            editor1.putBoolean("com.wantu.android.google.key", true);
            editor1.apply();
            Crashlytics.logException(exception);
            return;
        }
          goto _L1
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        if (j1 == -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log.v("resultCode", String.valueOf(j1));
        Log.v("requestCode", String.valueOf(i1));
        i1;
        JVM INSTR lookupswitch 3: default 64
    //                   168: 102
    //                   3021: 82
    //                   3023: 92;
           goto _L3 _L4 _L5 _L6
_L4:
        break MISSING_BLOCK_LABEL_102;
_L3:
        break; /* Loop/switch isn't completed */
_L5:
        break; /* Loop/switch isn't completed */
_L8:
        if (NativeAdWrapper.nativeAdHandleResult(i1, j1, intent, this))
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        a(i1, j1, intent);
          goto _L8
_L6:
        b(i1, j1, intent);
          goto _L8
        Object obj = intent.getData();
        String s1 = ((Uri) (obj)).toString();
        Log.v("mImageUri", ((Uri) (obj)).toString());
        try
        {
            obj = new File(new URI(s1.replace(" ", "%20")));
        }
        catch (URISyntaxException urisyntaxexception)
        {
            urisyntaxexception.printStackTrace();
            Crashlytics.logException(urisyntaxexception);
            urisyntaxexception = null;
        }
        if (obj != null)
        {
            try
            {
                obj = new Intent(this, com/fotoable/fotobeauty/NewPhotoShareActivity);
                ((Intent) (obj)).putExtra("PhotoShareActivity_ToShareImageUri", s1);
                startActivity(((Intent) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((Exception) (obj)).printStackTrace();
                Crashlytics.logException(((Throwable) (obj)));
            }
        }
          goto _L8
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03002c);
        if (getIntent().getBooleanExtra("onlineGCM", false))
        {
            StaticFlurryEvent.logGCMEventWithKV("pushkey", "PushMsgClickNotify");
            StaticFlurryEvent.logGCMEventUnique(InstaBeautyApplication.a, "pushkey_Unique", "PushMsgClickNotify_Unique");
        }
        l = (RelativeLayout)findViewById(0x7f0d00ec);
        int i1 = axw.a(this);
        int j1 = axw.b(this);
        g = new MainViewPagerAdapter(this);
        g.a(i1, j1 - 70 - 50);
        g.a(this);
        g.a(this);
        f = (ViewPager)findViewById(0x7f0d00f0);
        f.setAdapter(g);
        f.setCurrentItem(0);
        float f1;
        long l1;
        try
        {
            MediaScannerConnection.scanFile(this, new String[] {
                (new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/tencent/").toString()
            }, new String[] {
                "image/*"
            }, null);
            bundle = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            bundle.setData(Uri.fromFile(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/tencent/").toString())));
            sendBroadcast(bundle);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            Crashlytics.logException(bundle);
        }
        v = findViewById(0x7f0d00f4);
        v.setVisibility(4);
        w = findViewById(0x7f0d00ed);
        aoc.a(this).e();
        FotoAdStrategy.clearLoadInfo(this);
        aqx.a(getApplicationContext(), b, c, String.valueOf(0));
        ImageCache.a = android.graphics.Bitmap.CompressFormat.PNG;
        if (!"mounted".equals(Environment.getExternalStorageState()) && ImageCache.f())
        {
            break MISSING_BLOCK_LABEL_361;
        }
        l1 = ImageCache.a(Environment.getExternalStorageDirectory());
        if (l1 < 0x1400000L)
        {
            try
            {
                b(this).show();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                try
                {
                    Crashlytics.logException(bundle);
                }
                // Misplaced declaration of an exception variable
                catch (Bundle bundle)
                {
                    Crashlytics.logException(bundle);
                }
            }
        }
        u = (FrameLayout)findViewById(0x7f0d00d2);
        TAdButtonGroup.instance(getApplication()).setAcitivity(this);
        m();
        FotoAdMediationDB.UpdateMediaionDB(this);
        d = (ImageView)findViewById(0x7f0d00f2);
        e = (ImageView)findViewById(0x7f0d00f3);
        e.setOnClickListener(new acp(this));
        if (getResources().getDisplayMetrics().densityDpi >= 159)
        {
            i1 = getResources().getDisplayMetrics().heightPixels / 12;
            i = (FrameLayout)findViewById(0x7f0d00ee);
            bundle = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            bundle.height = i1;
            i.setLayoutParams(bundle);
        }
        f1 = (float)axw.a(this) / 320F;
        bundle = (android.widget.RelativeLayout.LayoutParams)w.getLayoutParams();
        bundle.height = axw.a(this, 243F * f1);
        bundle.setMargins(0, 0, 0, 0);
        w.requestLayout();
        new GuideViewAcitivity();
        if (GuideViewAcitivity.a != null)
        {
            GuideViewAcitivity.a.finish();
            GuideViewAcitivity.a = null;
        }
        if (!apq.a())
        {
            k = d();
        }
        apn.a().c();
        (new Handler()).postDelayed(new acu(this), 10L);
        g();
        return;
    }

    public void onDestroy()
    {
        if (q != null)
        {
            unregisterReceiver(q);
        }
        super.onDestroy();
    }

    public void onHomeWallClicked(String s1)
    {
        Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
        intent.putExtra("webUriString", s1);
        startActivity(intent);
    }

    public void onHomeWallLoadfailed()
    {
    }

    public void onHomeWallReceived(aqe aqe)
    {
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4 && keyevent.getRepeatCount() == 0)
        {
            if (!y)
            {
                Toast.makeText(this, 0x7f0600f8, 0).show();
                y = true;
                (new Handler()).postDelayed(new acv(this), 2000L);
                return true;
            }
            if (j != null)
            {
                j.cancel(true);
            }
            i();
            finish();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    public void onPause()
    {
        super.onPause();
        try
        {
            TAdButtonGroup.instance(getApplication()).stopAllButtonShow();
            if (!a(this) && getResources().getDisplayMetrics().heightPixels > 480 && HomeWallFactory.IsHomawallLoaded)
            {
                HomeWallFactory.stopCirclePlay();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
        }
        HomeWallFactory.setHasLeft(true);
        hu.b(this);
    }

    public void onResume()
    {
        super.onResume();
        FlurryAgent.onPageView();
        boolean flag = k();
        TAdButtonGroup.instance(getApplication()).setAcitivity(this);
        TAdButtonGroup.instance(getApplication()).setOnAdButtonClcikedLisener(new acw(this));
        TAdButtonGroup.instance(getApplication()).request();
        TAdButtonGroup.instance(getApplication()).resumeAllButtonShow();
        if (!k && !flag && aqx.a(this, "appOpenedTimes", 0) > 3)
        {
            c();
            j();
        }
        (new Handler()).postDelayed(new acx(this), 100L);
        HomeWallFactory.setHasLeft(false);
        if (!HomeWallFactory.IsHomawallLoaded) goto _L2; else goto _L1
_L1:
        HomeWallFactory.createHomeWallAdView(this, u, 1, null, null, this);
_L4:
        FotoCustomReport.StartReportDataInMainActivity(this);
        FlurryAgent.onPageView();
        return;
_L2:
        try
        {
            if (!a(this) && getResources().getDisplayMetrics().heightPixels > 480)
            {
                HomeWallFactory.createHomeWallAdView(this, u, 1, bgx.a(), this, this);
            }
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onStop()
    {
        super.onStop();
        boolean flag;
        if (!ApplicationState.isAppOnForeground(this))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        m = flag;
        if (m)
        {
            FotoAdMediationDB.setUserRecord(getApplicationContext(), -1);
        }
    }

    public void pipAlbumBtnClicked(View view)
    {
        bos.a().b();
        startActivityForResult(new Intent(this, com/wantu/activity/photoselector/SinglePhotoSelectorActivity), 3021);
        FlurryAgent.logEvent("pipLibrary");
    }

}
