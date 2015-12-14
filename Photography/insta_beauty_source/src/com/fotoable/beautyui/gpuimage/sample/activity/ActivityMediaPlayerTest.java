// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.beautyui.gpuimage.sample.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.MediaController;
import atq;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.beautyui.other.BeautyVideoView;
import com.fotoable.fotobeauty.WantuActivity;
import java.io.File;
import jp.co.cyberagent.android.gpuimage.grafika.AspectFrameLayout;
import pd;
import pe;
import pf;
import pg;
import ph;
import pi;
import pj;
import pk;
import pl;
import pm;
import xl;

// Referenced classes of package com.fotoable.beautyui.gpuimage.sample.activity:
//            CustomShareUtil

public class ActivityMediaPlayerTest extends Activity
    implements android.view.View.OnClickListener, xl
{

    MediaController a;
    public boolean b;
    private final String c = "ActivityMediaPlayerTest";
    private final String d = "PlayerRecentShare";
    private BeautyVideoView e;
    private ImageView f;
    private ImageView g;
    private ImageView h;
    private ImageView i;
    private ImageView j;
    private ImageView k;
    private ImageView l;
    private ImageView m;
    private ImageView n;
    private ImageView o;
    private ImageView p;
    private ImageView q;
    private String r;
    private AspectFrameLayout s;
    private FrameLayout t;
    private FrameLayout u;
    private FrameLayout v;
    private int w;
    private int x;
    private CustomShareUtil.EnumRecentShare y;
    private AlertDialog z;

    public ActivityMediaPlayerTest()
    {
        b = false;
    }

    public static AlertDialog a(ActivityMediaPlayerTest activitymediaplayertest, AlertDialog alertdialog)
    {
        activitymediaplayertest.z = alertdialog;
        return alertdialog;
    }

    private void a(int i1)
    {
        AnimationSet animationset = new AnimationSet(true);
        v.setVisibility(0);
        Log.e("ActivityMediaPlayerTest", (new StringBuilder()).append("mCustomShareBar.getHeight()=").append(v.getHeight()).toString());
        TranslateAnimation translateanimation;
        if (b)
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, v.getHeight(), 0.0F);
            v.setClickable(true);
            v.setFocusable(true);
        } else
        {
            translateanimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, v.getHeight());
            v.setClickable(false);
            v.setFocusable(false);
        }
        translateanimation.setFillAfter(true);
        translateanimation.setDuration(i1);
        translateanimation.setAnimationListener(new pk(this));
        animationset.addAnimation(translateanimation);
        v.startAnimation(animationset);
    }

    public static void a(ActivityMediaPlayerTest activitymediaplayertest)
    {
        activitymediaplayertest.j();
    }

    private void a(CustomShareUtil.EnumRecentShare enumrecentshare)
    {
        b();
        pg.a[enumrecentshare.ordinal()];
        JVM INSTR tableswitch 1 5: default 48
    //                   1 56
    //                   2 73
    //                   3 90
    //                   4 107
    //                   5 124;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
        t.invalidate();
        return;
_L2:
        h.setBackgroundResource(0x7f020141);
        y = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L3:
        h.setBackgroundResource(0x7f020142);
        y = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L4:
        h.setBackgroundResource(0x7f020145);
        y = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L5:
        h.setBackgroundResource(0x7f020146);
        y = enumrecentshare;
        continue; /* Loop/switch isn't completed */
_L6:
        h.setBackgroundResource(0x7f020143);
        y = enumrecentshare;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private boolean a(String s1)
    {
        Uri.parse(r);
        i();
        return atq.a(this, r, "sync_facebook", null, new pd(this));
    }

    public static FrameLayout b(ActivityMediaPlayerTest activitymediaplayertest)
    {
        return activitymediaplayertest.v;
    }

    private void b()
    {
    }

    private boolean b(String s1)
    {
        s1 = Uri.parse(r);
        i();
        return atq.c(this, s1, "sync_qq", null, new ph(this));
    }

    public static String c(ActivityMediaPlayerTest activitymediaplayertest)
    {
        return activitymediaplayertest.r;
    }

    private void c()
    {
        try
        {
            System.gc();
            Intent intent = new Intent();
            intent.setClass(this, com/fotoable/fotobeauty/WantuActivity);
            intent.setFlags(0x4000000);
            startActivity(intent);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            Crashlytics.logException(activitynotfoundexception);
        }
    }

    private boolean c(String s1)
    {
        s1 = Uri.parse(r);
        i();
        return atq.a(this, s1, "sync_line", null, new pi(this));
    }

    public static AlertDialog d(ActivityMediaPlayerTest activitymediaplayertest)
    {
        return activitymediaplayertest.z;
    }

    private void d()
    {
        b = false;
        a(500);
    }

    private boolean d(String s1)
    {
        s1 = Uri.parse(r);
        i();
        return atq.b(this, s1, "sync_instagram", null, new pj(this));
    }

    public static AspectFrameLayout e(ActivityMediaPlayerTest activitymediaplayertest)
    {
        return activitymediaplayertest.s;
    }

    private void e()
    {
        b = true;
        a(500);
    }

    private boolean e(String s1)
    {
        i();
        FlurryAgent.logEvent("PhotoSharebyWechat");
        return atq.b(this, r, "sync_wechat", null, new pf(this));
    }

    public static FrameLayout f(ActivityMediaPlayerTest activitymediaplayertest)
    {
        return activitymediaplayertest.t;
    }

    private void f()
    {
        z = (new android.app.AlertDialog.Builder(this)).create();
        z.getWindow().clearFlags(2);
        z.setCanceledOnTouchOutside(true);
        z.show();
        View view = LayoutInflater.from(this).inflate(0x7f0300e7, null);
        android.view.ViewGroup.LayoutParams layoutparams = new android.view.ViewGroup.LayoutParams(getResources().getDisplayMetrics().widthPixels - 200, -1);
        ((Button)view.findViewById(0x7f0d0373)).setOnClickListener(new pl(this));
        ((Button)view.findViewById(0x7f0d0374)).setOnClickListener(new pm(this));
        z.setContentView(view, layoutparams);
    }

    public static FrameLayout g(ActivityMediaPlayerTest activitymediaplayertest)
    {
        return activitymediaplayertest.u;
    }

    private void g()
    {
        switch (pg.a[y.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            a(r);
            return;

        case 2: // '\002'
            d(r);
            return;

        case 3: // '\003'
            b(r);
            return;

        case 5: // '\005'
            c(r);
            return;

        case 4: // '\004'
            e(r);
            return;
        }
    }

    private void h()
    {
        Uri uri = Uri.parse(r);
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("video/*");
        intent.putExtra("android.intent.extra.SUBJECT", "Share");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setFlags(0x10000000);
        startActivity(Intent.createChooser(intent, getTitle()));
    }

    private void i()
    {
        showDialog(1);
    }

    private void j()
    {
        removeDialog(1);
    }

    private void k()
    {
        s.getViewTreeObserver().addOnGlobalLayoutListener(new pe(this));
    }

    public void a()
    {
        if (b)
        {
            d();
        }
    }

    public void a(File file)
    {
        if (!file.exists()) goto _L2; else goto _L1
_L1:
        if (!file.isFile()) goto _L4; else goto _L3
_L3:
        file.delete();
_L6:
        file.delete();
_L2:
        return;
_L4:
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            int i1 = 0;
            while (i1 < afile.length) 
            {
                a(afile[i1]);
                i1++;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR tableswitch 2131558779 2131558794: default 84
    //                   2131558779 90
    //                   2131558780 95
    //                   2131558781 84
    //                   2131558782 84
    //                   2131558783 84
    //                   2131558784 85
    //                   2131558785 100
    //                   2131558786 105
    //                   2131558787 110
    //                   2131558788 84
    //                   2131558789 120
    //                   2131558790 182
    //                   2131558791 244
    //                   2131558792 213
    //                   2131558793 151
    //                   2131558794 115;
           goto _L1 _L2 _L3 _L1 _L1 _L1 _L4 _L5 _L6 _L7 _L1 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        return;
_L4:
        f();
        return;
_L2:
        finish();
        return;
_L3:
        c();
        return;
_L5:
        g();
        return;
_L6:
        e();
        return;
_L7:
        h();
        return;
_L13:
        d();
        return;
_L8:
        if (e(r))
        {
            y = CustomShareUtil.EnumRecentShare.SHARE_WECHAT;
            CustomShareUtil.a().a(y, "PlayerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L12:
        if (c(r))
        {
            y = CustomShareUtil.EnumRecentShare.SHARE_LINE;
            CustomShareUtil.a().a(y, "PlayerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        if (b(r))
        {
            y = CustomShareUtil.EnumRecentShare.SHARE_QQ;
            CustomShareUtil.a().a(y, "PlayerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L11:
        if (d(r))
        {
            y = CustomShareUtil.EnumRecentShare.SHARE_INSTAGRAM;
            CustomShareUtil.a().a(y, "PlayerRecentShare");
            return;
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (a(r))
        {
            y = CustomShareUtil.EnumRecentShare.SHARE_FB;
            CustomShareUtil.a().a(y, "PlayerRecentShare");
            return;
        }
        if (true) goto _L1; else goto _L14
_L14:
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        setContentView(0x7f03003e);
        s = (AspectFrameLayout)findViewById(0x7f0d017d);
        e = (BeautyVideoView)findViewById(0x7f0d017e);
        f = (ImageView)findViewById(0x7f0d017b);
        g = (ImageView)findViewById(0x7f0d017c);
        t = (FrameLayout)findViewById(0x7f0d017f);
        u = (FrameLayout)findViewById(0x7f0d017a);
        v = (FrameLayout)findViewById(0x7f0d0184);
        v.setVisibility(4);
        j = (ImageView)findViewById(0x7f0d0180);
        l = (ImageView)findViewById(0x7f0d0185);
        m = (ImageView)findViewById(0x7f0d0186);
        o = (ImageView)findViewById(0x7f0d0187);
        n = (ImageView)findViewById(0x7f0d0188);
        p = (ImageView)findViewById(0x7f0d0189);
        i = (ImageView)findViewById(0x7f0d0183);
        k = (ImageView)findViewById(0x7f0d0182);
        q = (ImageView)findViewById(0x7f0d018a);
        h = (ImageView)findViewById(0x7f0d0181);
        CustomShareUtil.a().a(getApplicationContext());
        y = CustomShareUtil.a().a("PlayerRecentShare");
        e.setVideoViewTouchListener(this);
        g.setOnClickListener(this);
        f.setOnClickListener(this);
        j.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        o.setOnClickListener(this);
        n.setOnClickListener(this);
        p.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        k.setOnClickListener(this);
        q.setOnClickListener(this);
        a = new MediaController(this);
        bundle = getIntent().getExtras();
        r = bundle.getString("movie_name");
        x = bundle.getInt("video_height");
        w = bundle.getInt("video_width");
        k();
        bundle = new File(r);
        if (bundle.exists())
        {
            e.setVideoPath(bundle.getAbsolutePath());
            e.setMediaController(a);
            a.setMediaPlayer(e);
            e.requestFocus();
        }
    }

    protected void onDestroy()
    {
        if (e != null)
        {
            e.stopPlayback();
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            KeyEvent keyevent = new KeyEvent(0, 127);
            if (a != null)
            {
                a.dispatchKeyEvent(keyevent);
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
        }
        super.onPause();
    }

    protected void onResume()
    {
        a(y);
        super.onResume();
        android.view.WindowManager.LayoutParams layoutparams = getWindow().getAttributes();
        layoutparams.screenBrightness = 0.7F;
        getWindow().setAttributes(layoutparams);
        FlurryAgent.onPageView();
        if (e == null)
        {
            return;
        } else
        {
            e.start();
            return;
        }
    }
}
