// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.ad.FotoAdFactory;
import com.fotoable.ad.FotoAdMediationDB;
import com.fotoable.ad.FotoAdStrategy;
import com.fotoable.ad.HeartBeatAsyncTask;
import com.fotoable.ad.HomeWallFactory;
import com.fotoable.ad.NativeAdWrapper;
import com.fotoable.ad.StaticFlurryEvent;
import com.fotoable.adbuttonlib.TAdButtonGroup;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.alertAd.TAlertAdActivity;
import com.fotoable.fotoproedit.activity.ProEditMainActivity;
import com.fotoable.fullscreenad.FullScreenAdView;
import com.fotoable.global.ItemPicView;
import com.fotoable.global.NewAlertDialogFragment;
import com.fotoable.photocollage.activity.photoselector.PhotoSelectorActivity;
import com.instamag.activity.lib.MagLibActivity;
import com.pipcamera.activity.guide.GuideViewAcitivity;
import com.pipcamera.activity.mainViewPager.MainViewPagerAdapter;
import com.pipcamera.activity.photoselector.SinglePhotoSelectorActivity;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import com.pipcamera.activity.pip.PipFreeStyleActivity;
import com.pipcamera.activity.pip.PipStyleActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.EOnlineResType;
import com.wantu.piprender.ESceneMode;
import eh;
import ej;
import ek;
import en;
import eo;
import es;
import ew;
import gb;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jd;
import jg;
import jh;
import jj;
import kc;
import kd;
import kf;
import kp;
import lb;
import pb;
import ru;
import rv;
import rw;
import sh;
import si;
import sl;
import tu;
import tv;
import tw;
import uc;
import uw;
import yg;

// Referenced classes of package com.pipcamera.activity:
//            FullscreenActivity, SettingActivity

public class PIPCameraActivity extends FullscreenActivity
    implements com.fotoable.ad.HomeWallFactory.HomeWallClickListener, com.fotoable.ad.HomeWallFactory.fotoHomeWalladListener, ek, jd, rv, si, sl, tw
{

    private static final File C = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory()).append("/DCIM/Camera").toString());
    public rw A;
    private final String B = "PIPCameraActivity";
    private File D;
    private final List E = new ArrayList();
    private final Boolean F = Boolean.valueOf(true);
    private boolean G;
    private FrameLayout H;
    private View I;
    private View J;
    private boolean K;
    private boolean L;
    private ej M;
    private boolean N;
    private eo O;
    private FullScreenAdView P;
    tv a;
    ESceneMode b;
    MainViewPagerAdapter c;
    int d;
    int e;
    boolean f;
    View g;
    View h;
    View i;
    ViewPager j;
    String k;
    String l;
    sh m;
    DownloadManager n;
    long o;
    ru p;
    String q;
    String r;
    Boolean s;
    boolean t;
    Handler u;
    boolean v;
    RelativeLayout w;
    ItemPicView x;
    public Handler y;
    public int z;

    public PIPCameraActivity()
    {
        b = ESceneMode.SCENE_MODE1;
        d = 320;
        e = 480;
        f = false;
        k = "AdButtonGroup";
        l = "adRequestTime";
        G = true;
        m = null;
        o = -1L;
        p = null;
        s = Boolean.valueOf(true);
        t = false;
        K = false;
        L = false;
        v = false;
        N = true;
        O = new eo() {

            final PIPCameraActivity a;

            public void a(String s1)
            {
                if (s1.startsWith("http://") || s1.startsWith("https://"))
                {
                    PIPCameraActivity.a(a, s1);
                }
            }

            public void b(String s1)
            {
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        };
        y = new Handler() {

            final PIPCameraActivity a;

            public void handleMessage(Message message)
            {
                super.handleMessage(message);
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        };
        z = 1000;
        A = new rw(this);
    }

    static FullScreenAdView a(PIPCameraActivity pipcameraactivity, FullScreenAdView fullscreenadview)
    {
        pipcameraactivity.P = fullscreenadview;
        return fullscreenadview;
    }

    static eo a(PIPCameraActivity pipcameraactivity)
    {
        return pipcameraactivity.O;
    }

    private void a(long l1)
    {
        if (l1 != -1L)
        {
            A.a = l1;
            y.postDelayed(A, z);
        }
    }

    private void a(Uri uri)
    {
        if (b == ESceneMode.SCENE_MODE1)
        {
            FlurryAgent.logEvent("pipmodel1BtnClicked");
            Intent intent = new Intent(this, com/pipcamera/activity/pip/PipStyleActivity);
            intent.putExtra("SelectedImageUri", uri.toString());
            startActivity(intent);
        } else
        {
            if (b == ESceneMode.SCENE_MODE2)
            {
                FlurryAgent.logEvent("pipmodel2BtnClicked");
                Intent intent1 = new Intent(this, com/pipcamera/activity/pip/Pip2FragmentActivity);
                intent1.putExtra("SelectedImageUri", uri.toString());
                startActivity(intent1);
                return;
            }
            if (b == ESceneMode.SCENE_MODE3)
            {
                FlurryAgent.logEvent("pipmodel3BtnClicked");
                Intent intent2 = new Intent(this, com/pipcamera/activity/pip/PipFreeStyleActivity);
                intent2.putExtra("SelectedImageUri", uri.toString());
                startActivity(intent2);
                return;
            }
        }
    }

    public static void a(PIPCameraActivity pipcameraactivity, long l1)
    {
        pipcameraactivity.b(l1);
    }

    static void a(PIPCameraActivity pipcameraactivity, String s1)
    {
        pipcameraactivity.c(s1);
    }

    public static boolean a(Context context)
    {
        return (context.getResources().getConfiguration().screenLayout & 0xf) == 1;
    }

    static boolean a(PIPCameraActivity pipcameraactivity, boolean flag)
    {
        pipcameraactivity.N = flag;
        return flag;
    }

    static FullScreenAdView b(PIPCameraActivity pipcameraactivity)
    {
        return pipcameraactivity.P;
    }

    private void b(long l1)
    {
        Cursor cursor = n.query((new android.app.DownloadManager.Query()).setFilterById(new long[] {
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
            Log.d("PIPCameraActivity", (new StringBuilder()).append("Column_id : ").append(cursor.getLong(cursor.getColumnIndex("_id"))).toString());
            Log.d("PIPCameraActivity", (new StringBuilder()).append("Column_bytes_downloaded so far : ").append(cursor.getLong(cursor.getColumnIndex("bytes_so_far"))).toString());
            Log.d("PIPCameraActivity", (new StringBuilder()).append("Column last modified timestamp : ").append(cursor.getLong(cursor.getColumnIndex("last_modified_timestamp"))).toString());
            Log.d("PIPCameraActivity", (new StringBuilder()).append("Column local uri : ").append(cursor.getString(cursor.getColumnIndex("local_uri"))).toString());
            Log.d("PIPCameraActivity", (new StringBuilder()).append("Column statue : ").append(cursor.getInt(cursor.getColumnIndex("status"))).toString());
            Log.d("PIPCameraActivity", (new StringBuilder()).append("Column reason : ").append(cursor.getInt(cursor.getColumnIndex("reason"))).toString());
            cursor.getInt(cursor.getColumnIndex("status"));
            cursor.close();
            return;
        }
    }

    private void c(int i1)
    {
        if (J != null)
        {
            float f1 = (float)pb.a(this) / 320F;
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)J.getLayoutParams();
            layoutparams.height = pb.a(this, 243F * f1);
            layoutparams.setMargins(0, 0, 0, pb.a(this, i1));
            J.requestLayout();
        }
        if (I != null && i1 == 0)
        {
            I.setVisibility(4);
        } else
        if (I != null)
        {
            I.setVisibility(0);
            return;
        }
    }

    static void c(PIPCameraActivity pipcameraactivity)
    {
        pipcameraactivity.k();
    }

    private void c(String s1)
    {
        if (s1 == null || s1.length() <= 0)
        {
            return;
        } else
        {
            Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
            intent.putExtra("webUriString", s1);
            startActivity(intent);
            return;
        }
    }

    private Uri d(String s1)
    {
        File file = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getAbsolutePath()).append("/download").toString());
        if (!file.exists())
        {
            file.mkdirs();
        }
        return Uri.fromFile(new File(file, s1));
    }

    static View d(PIPCameraActivity pipcameraactivity)
    {
        return pipcameraactivity.J;
    }

    private void i()
    {
        int i1 = lb.a("appOpenedTimes", 0) + 1;
        lb.b("appOpenedTimes", i1);
        FotoAdMediationDB.setUserRecord(getApplicationContext(), i1);
    }

    private void j()
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

    private void k()
    {
        (new Handler()).postDelayed(new Runnable() {

            final PIPCameraActivity a;

            public void run()
            {
                en.a(a, "home", PIPCameraActivity.a(a));
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        }, 500L);
    }

    private boolean l()
    {
        boolean flag;
        boolean flag1;
        try
        {
            m();
            jg.a(this).a();
            flag = jg.a(this).g();
            flag1 = jg.a(this).a(this, true);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return false;
        }
        if (!flag && !flag1) goto _L2; else goto _L1
_L1:
        if (!jg.a(this).f()) goto _L2; else goto _L3
_L3:
        if (P == null)
        {
            P = new FullScreenAdView(this);
        }
        P.setOnAdviewListener(new jh() {

            final PIPCameraActivity a;

            public void a()
            {
                if (PIPCameraActivity.b(a) != null)
                {
                    PIPCameraActivity.b(a).destroyView();
                    PIPCameraActivity.a(a, null);
                }
                PIPCameraActivity.c(a);
            }

            public void a(String s1)
            {
                PIPCameraActivity.a(a, s1);
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        });
        if (!flag) goto _L5; else goto _L4
_L4:
        P.loadImage();
_L10:
        if (!ew.a()) goto _L7; else goto _L6
_L6:
        P.setLogo(0x7f02018a);
_L8:
        w.removeView(P);
        P.handleDismissAction();
        w.addView(P);
        jg.a(this).d();
        return true;
_L5:
        P.loadDefaultImage();
        continue; /* Loop/switch isn't completed */
_L7:
        P.setLogo(0x7f02018b);
          goto _L8
_L2:
        return false;
        if (true) goto _L10; else goto _L9
_L9:
    }

    private void m()
    {
        try
        {
            SharedPreferences sharedpreferences = getSharedPreferences("isNeedGotoGuideView", 0);
            if (sharedpreferences.getBoolean("guideViewShown", false))
            {
                jg.a(this).d();
                FotoAdFactory.createFBInterstial(PIPCameraApplication.a, true);
            }
            sharedpreferences.edit().putBoolean("guideViewShown", false).apply();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public void OnAdBtnClicked(View view)
    {
        Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
        view = "http://fotorus2.fotoable.com/pipstyle/PIPCamera_en.html";
        Locale locale = Locale.getDefault();
        if (String.format("%s-%s", new Object[] {
    locale.getLanguage(), locale.getCountry()
}).equalsIgnoreCase("zh-CN"))
        {
            view = "http://fotorus2.fotoable.com/pipstyle/PIPCamera_cn.html";
        }
        intent.putExtra("webUriString", view);
        startActivity(intent);
    }

    public void OnCollageBtnClicked(View view)
    {
        FlurryAgent.logEvent("maglibraryClicked");
        startActivity(new Intent(this, com/instamag/activity/lib/MagLibActivity));
    }

    public void OnFreeCollageBtnClicked(View view)
    {
        if (!gb.h())
        {
            Toast.makeText(getApplicationContext(), 0x7f0600e5, 0).show();
            return;
        } else
        {
            startActivity(new Intent(this, com/fotoable/photocollage/activity/photoselector/PhotoSelectorActivity));
            FlurryAgent.logEvent("freeCollageButtonClick");
            return;
        }
    }

    public void OnSettingBtnClicked(View view)
    {
        startActivity(new Intent(this, com/pipcamera/activity/SettingActivity));
        FlurryAgent.logEvent("settingButtonClick");
    }

    public void a()
    {
    }

    public void a(int i1)
    {
        File file;
        Log.i("CopyFile", (new StringBuilder()).append("CopyFileFinished..  state ...").append(i1).toString());
        file = new File((new StringBuilder()).append(r).append(q).toString());
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        i1;
        JVM INSTR tableswitch -1 1: default 92
    //                   -1 124
    //                   0 116
    //                   1 98;
           goto _L2 _L3 _L4 _L5
_L2:
        p = null;
        return;
_L5:
        if (s.booleanValue())
        {
            a(file);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        file.delete();
        continue; /* Loop/switch isn't completed */
_L3:
        file.delete();
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void a(View view, String s1)
    {
        if (s1.compareTo("item_classic") != 0) goto _L2; else goto _L1
_L1:
        a(true);
        FlurryAgent.logEvent("ClassicMainClicked");
_L4:
        System.out.println("tag");
        return;
_L2:
        if (s1.compareTo("item_collage") == 0)
        {
            OnCollageBtnClicked(view);
        } else
        if (s1.compareTo("prev_page") == 0)
        {
            j.setCurrentItem(0);
        } else
        if (s1.compareTo("item_freecollage") == 0)
        {
            OnFreeCollageBtnClicked(view);
        } else
        if (s1.compareTo("item_proedit") == 0)
        {
            onProEditClicked(view);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(eh eh1)
    {
        if (eh1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        if (eh1.l() != 0)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        eh1 = eh.a(eh1);
        if (eh1 != null)
        {
            try
            {
                Intent intent = new Intent(this, com/fotoable/alertAd/TAlertAdActivity);
                intent.putExtra("alertItemJson", eh1);
                startActivity(intent);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (eh eh1)
            {
                Crashlytics.logException(eh1);
            }
        }
        break MISSING_BLOCK_LABEL_58;
        b(eh1);
        return;
    }

    public void a(File file)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        startActivity(intent);
    }

    public void a(String s1)
    {
        if (jj.b())
        {
            HeartBeatAsyncTask.beat(getApplicationContext(), true);
        }
    }

    public void a(HashMap hashmap)
    {
        if (hashmap == null)
        {
            c.a(false);
            return;
        }
        Boolean boolean1 = Boolean.valueOf(false);
        if (tv.a(EOnlineResType.PIP_SCENE, hashmap).booleanValue() || tv.a(EOnlineResType.PIP_SCENE2, hashmap).booleanValue())
        {
            boolean1 = Boolean.valueOf(true);
        }
        c.a(boolean1.booleanValue());
    }

    public void a(boolean flag)
    {
        if (x == null)
        {
            x = new ItemPicView(this);
            x.setItemPicLisener(new kc() {

                final PIPCameraActivity a;

                public void a(int i1)
                {
                    a.a(false);
                    if (i1 == 1)
                    {
                        a.b = ESceneMode.SCENE_MODE1;
                        a.f();
                    } else
                    if (i1 == 2)
                    {
                        a.b = ESceneMode.SCENE_MODE1;
                        a.d();
                        return;
                    }
                }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
            });
            addContentView(x, new android.view.ViewGroup.LayoutParams(-1, -1));
        }
        if (flag)
        {
            x.setVisibility(0);
            android.view.animation.Animation animation = AnimationUtils.loadAnimation(PIPCameraApplication.a, 0x7f040012);
            x.startAnimation(animation);
            x.ShowBtnTagSelAnim();
            return;
        } else
        {
            x.setVisibility(4);
            x.HiddenBtnTagSelAnim();
            return;
        }
    }

    protected void b()
    {
        try
        {
            a = new tv();
            a.a(this);
            ArrayList arraylist = new ArrayList(2);
            arraylist.add(tu.getStringByResType(EOnlineResType.PIP_SCENE));
            arraylist.add(tu.getStringByResType(EOnlineResType.PIP_SCENE2));
            a.a(arraylist);
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    public void b(int i1)
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
        m = null;
        return;
_L4:
        Log.i("PIPCameraActivity download", "apk download canceled");
        file.delete();
        continue; /* Loop/switch isn't completed */
_L5:
        Log.i("PIPCameraActivity download", "apk download finished");
        a(file);
        FlurryAgent.logEvent("guide_finish_dowmload");
        continue; /* Loop/switch isn't completed */
_L3:
        Log.i("PIPCameraActivity download", "apk download failed");
        file.delete();
        FlurryAgent.logEvent("guide_failed_dowmload");
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void b(eh eh1)
    {
        if (eh1 == null)
        {
            return;
        }
        try
        {
            HashMap hashmap = new HashMap();
            hashmap.put("adId", String.valueOf(eh1.a()));
            FlurryAgent.logEvent("AlertAdShow_New", hashmap);
            NewAlertDialogFragment newalertdialogfragment = new NewAlertDialogFragment();
            newalertdialogfragment.a(eh1);
            newalertdialogfragment.a(new kd(eh1, hashmap, newalertdialogfragment) {

                final eh a;
                final HashMap b;
                final NewAlertDialogFragment c;
                final PIPCameraActivity d;

                public void a()
                {
                    Intent intent = new Intent(d, com/fotoable/adbuttonlib/TWebBrowActivity);
                    intent.putExtra("webUriString", a.d());
                    d.startActivity(intent);
                    FlurryAgent.logEvent("AlertAdClicked_New", b);
                    c.dismiss();
                }

                public void b()
                {
                    FlurryAgent.logEvent("AlertAdCanceled_New", b);
                    c.dismiss();
                }

            
            {
                d = PIPCameraActivity.this;
                a = eh1;
                b = hashmap;
                c = newalertdialogfragment;
                super();
            }
            });
            (new Handler()).postDelayed(new Runnable(newalertdialogfragment) {

                final NewAlertDialogFragment a;
                final PIPCameraActivity b;

                public void run()
                {
                    a.show(b.getSupportFragmentManager(), "PIPCameraActivity");
                }

            
            {
                b = PIPCameraActivity.this;
                a = newalertdialogfragment;
                super();
            }
            }, 1000L);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (eh eh1)
        {
            Crashlytics.logException(eh1);
        }
    }

    public void b(boolean flag)
    {
        n = (DownloadManager)getSystemService("download");
        Object obj = "https://ad.apps.fm/5lHRbUcQ8URe6SdvqQWDHQPB6WEzBdlyL36ols3y74nvQMGv5ek5uhfXgwwOUiP7pOgZ-jdaG7Cq7auyZ1ycV14pEVF99gec6trmi6voxWM";
        String s3 = "\u7F8E\u840C";
        String s2 = "Girls.apk";
        String s1 = "\u7F8E\u840C\u5F00\u59CB\u4E0B\u8F7D";
        if (!flag)
        {
            obj = "http://ad.apps.fm/J2CFlRPS1Tr_Lp3z3xxDdQPB6WEzBdlyL36ols3y74k_WKj8rtFfr14-WVk496G-b1SbbiXpO_F44MO-njgRLfFD__51hU9Kan7XfIaAw_c";
            s3 = "\u62FC\u7ACB\u5F97";
            s2 = "Instamag.apk";
            s1 = "\u62FC\u7ACB\u5F97\u5F00\u59CB\u4E0B\u8F7D";
        }
        try
        {
            obj = new android.app.DownloadManager.Request(Uri.parse(((String) (obj))));
            ((android.app.DownloadManager.Request) (obj)).setTitle(s3);
            ((android.app.DownloadManager.Request) (obj)).setDestinationUri(d(s2));
            if (gb.c())
            {
                ((android.app.DownloadManager.Request) (obj)).allowScanningByMediaScanner();
            }
            ((android.app.DownloadManager.Request) (obj)).setMimeType("application/cn.trinea.download.file");
            o = n.enqueue(((android.app.DownloadManager.Request) (obj)));
            getSharedPreferences("SystemDownloadTask", 0).edit().putLong("downloadID", o).commit();
            FlurryAgent.logEvent("guide_start_dowmload");
            Toast.makeText(this, s1, 0).show();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return;
        }
        a(o);
    }

    public boolean b(String s1)
    {
        try
        {
            s1 = getPackageManager().getPackageInfo(s1, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            s1.printStackTrace();
            Crashlytics.logException(s1);
            s1 = null;
        }
        return s1 != null;
    }

    protected void c()
    {
        (new Thread(new Runnable() {

            final PIPCameraActivity a;

            public void run()
            {
                try
                {
                    jj.a().a(a, a, "847715203438");
                    return;
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                    Crashlytics.logException(exception);
                    return;
                }
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        })).start();
    }

    protected void d()
    {
        try
        {
            if ("mounted".equals(Environment.getExternalStorageState()))
            {
                Object obj = new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/").toString());
                ((File) (obj)).mkdirs();
                D = new File(((File) (obj)), "capture.jpg");
                obj = Uri.fromFile(D);
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra("output", ((android.os.Parcelable) (obj)));
                intent.putExtra("output", ((android.os.Parcelable) (obj)));
                startActivityForResult(intent, 3023);
                return;
            }
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(this, 0x7f060187, 1).show();
            Crashlytics.logException(activitynotfoundexception);
            return;
        }
        (new android.app.AlertDialog.Builder(this)).setMessage(getResources().getString(0x7f060174)).setCancelable(true).create().show();
        return;
    }

    public void e()
    {
        try
        {
            if (M == null)
            {
                M = new ej(this, "pipcam");
            }
            M.a(this);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    protected void f()
    {
        try
        {
            startActivityForResult(g(), 3021);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Toast.makeText(this, 0x7f060188, 1).show();
            Crashlytics.logException(activitynotfoundexception);
            return;
        }
    }

    public Intent g()
    {
        return new Intent(this, com/pipcamera/activity/photoselector/SinglePhotoSelectorActivity);
    }

    public boolean h()
    {
        Object obj = getSharedPreferences((new StringBuilder()).append("isGuideNeedInstallApp_").append(kf.a).toString(), 0);
        if (((SharedPreferences) (obj)).getString("activity", "") != "GuideViewActivity") goto _L2; else goto _L1
_L1:
        String s1;
        s = Boolean.valueOf(((SharedPreferences) (obj)).getBoolean("isNeedDownloadApp", true));
        s1 = ((SharedPreferences) (obj)).getString("PresentAppName", "");
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putString("activity", "no");
        ((android.content.SharedPreferences.Editor) (obj)).putString("PresentAppName", "");
        ((android.content.SharedPreferences.Editor) (obj)).putBoolean("isNeedDownloadApp", false);
        ((android.content.SharedPreferences.Editor) (obj)).commit();
        if (s.booleanValue()) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        if (s1.compareToIgnoreCase(es.i) != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (b(es.i)) goto _L2; else goto _L4
_L4:
        b(true);
        return true;
        if (s1.compareToIgnoreCase(es.a) != 0 || b(es.a)) goto _L2; else goto _L5
_L5:
        b(false);
        return true;
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
    //                   3021: 82
    //                   3023: 125
    //                   3028: 167;
           goto _L3 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_167;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L8:
        if (NativeAdWrapper.nativeAdHandleResult(i1, j1, intent, this))
        {
            super.onActivityResult(i1, j1, intent);
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        if (intent == null)
        {
            Toast.makeText(this, "Load photo from gallery failed", 1).show();
            return;
        }
        Uri uri = intent.getData();
        Log.v("url", uri.toString());
        a(uri);
          goto _L8
_L5:
        a(Uri.fromFile(new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append("/.tmp/capture.jpg").toString())));
          goto _L8
        if (intent == null)
        {
            Toast.makeText(this, "Load photo from gallery failed", 1).show();
            return;
        }
        Uri uri1 = intent.getData();
        if (uri1 != null)
        {
            FlurryAgent.logEvent("proEditPhotoFinishChoose");
            Intent intent1 = new Intent(this, com/fotoable/fotoproedit/activity/ProEditMainActivity);
            intent1.putExtra("ChooseStyleId", 0);
            intent1.putExtra("uri", uri1.toString());
            startActivity(intent1);
        }
          goto _L8
    }

    public boolean onContextItemSelected(MenuItem menuitem)
    {
        String s1;
        String s2;
        s1 = getResources().getString(0x7f06019a);
        s2 = getResources().getString(0x7f060264);
        if (!menuitem.getTitle().toString().equalsIgnoreCase(s1)) goto _L2; else goto _L1
_L1:
        if (g == null || menuitem.getItemId() != g.getId()) goto _L4; else goto _L3
_L3:
        Log.v("btnModel1 menuitemselected", "item1");
        b = ESceneMode.SCENE_MODE1;
_L8:
        f();
_L6:
        return true;
_L4:
        if (h != null && menuitem.getItemId() == h.getId())
        {
            b = ESceneMode.SCENE_MODE2;
            Log.v("btnModel2 menuitemselected", "item1");
        } else
        if (i != null && menuitem.getItemId() == i.getId())
        {
            b = ESceneMode.SCENE_MODE3;
            Log.v("btnModel3 menuitemselected", "item1");
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!menuitem.getTitle().toString().equalsIgnoreCase(s2))
        {
            break; /* Loop/switch isn't completed */
        }
        if (g != null && menuitem.getItemId() == g.getId())
        {
            b = ESceneMode.SCENE_MODE1;
            Log.v("btnModel1 menuitemselected", "item2");
        } else
        if (h != null && menuitem.getItemId() == h.getId())
        {
            b = ESceneMode.SCENE_MODE2;
            Log.v("btnModel2 menuitemselected", "item2");
        } else
        if (i != null && menuitem.getItemId() == i.getId())
        {
            b = ESceneMode.SCENE_MODE3;
            Log.v("btnModel3 menuitemselected", "item3");
        }
        d();
        if (true) goto _L6; else goto _L5
_L5:
        return false;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03001b);
        if (getIntent().getBooleanExtra("onlineGCM", false))
        {
            StaticFlurryEvent.logGCMEventWithKV("onlineGCM", "Push_Clicked");
        }
        w = (RelativeLayout)findViewById(0x7f0c0072);
        I = findViewById(0x7f0c0050);
        J = findViewById(0x7f0c0075);
        c = new MainViewPagerAdapter(this);
        c.a(this);
        c.a(this);
        j = (ViewPager)findViewById(0x7f0c0077);
        j.setAdapter(c);
        j.setCurrentItem(1);
        u = new Handler();
        jg.a(this).e();
        HomeWallFactory.clearView();
        TAdButtonGroup.instance(getApplication()).setAcitivity(this);
        FotoAdStrategy.clearLoadInfo(this);
        if (!a(this) && getResources().getDisplayMetrics().heightPixels > 480)
        {
            H = (FrameLayout)findViewById(0x7f0c005a);
            HomeWallFactory.createHomeWallAdView(this, H, 1, uc.a(), this, this);
        }
        b();
        c();
        FotoAdMediationDB.UpdateMediaionDB(this);
        new GuideViewAcitivity();
        if (GuideViewAcitivity.a != null)
        {
            GuideViewAcitivity.a.finish();
        }
        c(0);
        if (!kf.a())
        {
            Log.i("create shortcut", "create shortcut check");
            v = h();
        }
        i();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        HomeWallFactory.stopCirclePlay();
    }

    public void onHomeWallClicked(String s1)
    {
        Intent intent = new Intent(this, com/fotoable/adbuttonlib/TWebBrowActivity);
        intent.putExtra("webUriString", s1);
        startActivity(intent);
        FlurryAgent.logEvent("PIP_HomeWallClicked");
    }

    public void onHomeWallLoadfailed()
    {
        runOnUiThread(new Runnable() {

            final PIPCameraActivity a;

            public void run()
            {
                a.t = false;
                if (PIPCameraActivity.d(a) != null)
                {
                    float f1 = (float)pb.a(a) / 320F;
                    ((android.widget.RelativeLayout.LayoutParams)PIPCameraActivity.d(a).getLayoutParams()).height = pb.a(a, 243F * f1);
                    PIPCameraActivity.d(a).requestLayout();
                }
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        });
    }

    public void onHomeWallReceived(kp kp)
    {
        t = true;
        c(0);
        Log.v("PIPCameraActivity", "receiveAd succed!");
        FlurryAgent.logEvent("PIP_HomeWallDisplayed");
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 == 4)
        {
            if (x != null && x.getVisibility() == 0)
            {
                a(false);
                return true;
            }
            if (N)
            {
                N = false;
                Toast.makeText(this, 0x7f0600e7, 0).show();
                (new Handler()).postDelayed(new Runnable() {

                    final PIPCameraActivity a;

                    public void run()
                    {
                        PIPCameraActivity.a(a, true);
                    }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
                }, 2000L);
                return true;
            }
            if (m != null)
            {
                m.cancel(true);
            }
            j();
            finish();
            return true;
        } else
        {
            return super.onKeyDown(i1, keyevent);
        }
    }

    protected void onPause()
    {
        try
        {
            if (!a(this) && getResources().getDisplayMetrics().heightPixels > 480)
            {
                HomeWallFactory.stopCirclePlay();
            }
        }
        catch (Exception exception)
        {
            Log.e("PIPCameraActivity", (new StringBuilder()).append("PIPCameraActivity").append(exception.toString()).toString());
            Crashlytics.logException(exception);
        }
        Log.e("PIPCameraActivity", "PIPCameraActivityonPause invoked");
        TAdButtonGroup.instance(getApplication()).cancelTimer();
        super.onPause();
        en.b(this);
    }

    public void onProEditClicked(View view)
    {
        FlurryAgent.logEvent("MainProEditClicked");
        startActivityForResult(g(), 3028);
    }

    public void onResume()
    {
        boolean flag;
        super.onResume();
        Log.v("PIPCameraActivity", "PIPCameraActivity :onResume");
        flag = l();
        if (!PIPCameraApplication.a() && !PIPCameraApplication.a(PIPCameraApplication.a))
        {
            (new uw(this)).a(null);
        }
        FotoAdStrategy.loadStrategyOnceOnStartRemoved(this);
        if (!HomeWallFactory.IsHomawallLoaded) goto _L2; else goto _L1
_L1:
        HomeWallFactory.createHomeWallAdView(this, H, 1, null, null, this);
_L4:
        HomeWallFactory.startCirclePlay();
_L5:
        TAdButtonGroup.instance(getApplication()).setAcitivity(this);
        TAdButtonGroup.instance(getApplication()).setOnAdButtonClcikedLisener(new com.fotoable.adbuttonlib.TAdButtonGroup.OnAdButtonClickedLisener() {

            final PIPCameraActivity a;

            public void onAdButtonClicked(String s1)
            {
                PIPCameraActivity.a(a, s1);
            }

            
            {
                a = PIPCameraActivity.this;
                super();
            }
        });
        TAdButtonGroup.instance(getApplication()).request();
        if (!G)
        {
            TAdButtonGroup.instance(getApplication()).activeTimer();
        }
        int i1 = lb.a("appOpenedTimes", 0);
        if (!v && !flag && i1 > 2)
        {
            e();
            k();
        }
        FotoAdFactory.createFBInterstial(getApplicationContext(), true);
        G = false;
        return;
_L2:
        if (a(this) || getResources().getDisplayMetrics().heightPixels <= 480) goto _L4; else goto _L3
_L3:
        HomeWallFactory.createHomeWallAdView(this, H, 1, uc.a(), this, this);
          goto _L4
        Exception exception;
        exception;
        Crashlytics.logException(exception);
          goto _L5
    }

    protected void onStart()
    {
        super.onStart();
        Log.v("PIPCameraActivity", "PIPCameraActivity :onStart");
        TAdButtonGroup.instance(getApplication()).resumeAllButtonShow();
    }

    protected void onStop()
    {
        super.onStop();
        Log.v("PIPCameraActivity", "PIPCameraActivity :onStop");
        TAdButtonGroup.instance(getApplication()).stopAllButtonShow();
        if (!ApplicationState.isAppOnForeground(getApplicationContext()))
        {
            FotoAdMediationDB.setUserRecord(getApplicationContext(), -1);
        }
    }

    public void pipModel1BtnClicked(View view)
    {
        yg.a().b();
        f();
    }

    public void pipModel2BtnClicked(View view)
    {
        yg.a().b();
        f();
    }

}
