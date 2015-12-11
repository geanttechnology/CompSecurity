// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import aaa;
import ac;
import ahs;
import ajf;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import avw;
import bmo;
import com.google.android.apps.youtube.kids.application.KidsApplication;
import j;
import java.util.concurrent.CountDownLatch;
import m;
import mj;
import r;
import wg;
import yc;
import zb;
import zc;
import zd;
import zf;
import zg;
import zi;

// Referenced classes of package com.google.android.apps.youtube.kids.activities:
//            BrowseActivity, ScalingVideoView

public class SplashScreenActivity extends m
{

    private CountDownLatch f;
    private Handler g;
    private wg h;
    private KidsApplication i;
    private ScalingVideoView j;
    private mj k;
    private Runnable l;
    private android.media.MediaPlayer.OnCompletionListener m;
    private Runnable n;
    private Runnable o;

    public SplashScreenActivity()
    {
        k = new zb(this);
        l = new zc(this);
        m = new zd(this);
        n = new zf(this);
        o = new zg(this);
    }

    public static CountDownLatch a(SplashScreenActivity splashscreenactivity)
    {
        return splashscreenactivity.f;
    }

    public static wg a(SplashScreenActivity splashscreenactivity, wg wg)
    {
        splashscreenactivity.h = wg;
        return wg;
    }

    public static KidsApplication b(SplashScreenActivity splashscreenactivity)
    {
        return splashscreenactivity.i;
    }

    public static mj c(SplashScreenActivity splashscreenactivity)
    {
        return splashscreenactivity.k;
    }

    public static wg d(SplashScreenActivity splashscreenactivity)
    {
        return splashscreenactivity.h;
    }

    public static Handler e(SplashScreenActivity splashscreenactivity)
    {
        return splashscreenactivity.g;
    }

    public static void f(SplashScreenActivity splashscreenactivity)
    {
        splashscreenactivity.g.removeCallbacksAndMessages(null);
        splashscreenactivity.startActivity(new Intent(splashscreenactivity, com/google/android/apps/youtube/kids/activities/BrowseActivity));
    }

    public void onActivityResult(int i1, int j1, Intent intent)
    {
        if (i1 == 1)
        {
            finish();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f04005e);
        g = new Handler();
        int i1 = avw.a(this);
        if (i1 != 0)
        {
            bundle = new j();
            super.b.a().a(bundle, "").a();
            avw.a(i1, this, bundle, 1, new zi(this));
            return;
        }
        if (!isTaskRoot())
        {
            bundle = getIntent();
            String s = bundle.getAction();
            if (bundle.hasCategory("android.intent.category.LAUNCHER") && s != null && s.equals("android.intent.action.MAIN"))
            {
                bmo.c("SplashScreenActivity not started as root task! Finishing...");
                finish();
                return;
            }
        }
        f = new CountDownLatch(2);
        (new Thread(o)).start();
        i = (KidsApplication)getApplicationContext();
        g.post(l);
        if (i.i())
        {
            i.h().n.e().a(new yc(i));
        }
        j = (ScalingVideoView)findViewById(0x7f1001a4);
        bundle = getResources().openRawResourceFd(0x7f08000b);
        j.setClickable(false);
        j.a(bundle);
        j.a = m;
        g.postDelayed(n, 5000L);
    }

    protected void onPause()
    {
        if (j != null)
        {
            j.b();
        }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        if (j != null)
        {
            j.a();
        }
    }

    public void onStop()
    {
        super.onStop();
        if (g != null)
        {
            g.removeCallbacksAndMessages(null);
        }
    }
}
