// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.a;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.LinearLayout;
import com.tremorvideo.sdk.android.videoad.a;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.aw;
import com.tremorvideo.sdk.android.videoad.l;
import com.tremorvideo.sdk.android.videoad.n;
import java.io.File;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.a:
//            a, j, c

public class b
    implements com.tremorvideo.sdk.android.videoad.a.a, l
{
    class a extends TimerTask
    {

        String a;
        final b b;

        public void run()
        {
            b.e.purge();
            b.e.cancel();
            b.e = null;
            b.b(b).runOnUiThread(new Runnable(this) {

                final a a;

                public void run()
                {
                    b.c(a.b).loadUrl(a.a);
                }

            
            {
                a = a1;
                super();
            }
            });
        }

        public a(String s)
        {
            b = b.this;
            super();
            a = s;
        }
    }


    public static n a;
    public static com.tremorvideo.sdk.android.videoad.a.a b;
    boolean c;
    int d;
    Timer e;
    BroadcastReceiver f;
    BroadcastReceiver g;
    BroadcastReceiver h;
    private com.tremorvideo.sdk.android.a.a i;
    private Activity j;
    private WebView k;
    private com.tremorvideo.sdk.android.videoad.a.a l;

    public b()
    {
        c = true;
        d = -1;
        f = new BroadcastReceiver() {

            final b a;

            public void onReceive(Context context, Intent intent)
            {
                a.c = false;
                com.tremorvideo.sdk.android.a.b.a(a).l();
            }

            
            {
                a = b.this;
                super();
            }
        };
        g = new BroadcastReceiver() {

            final b a;

            public void onReceive(Context context, Intent intent)
            {
                a.c = true;
                com.tremorvideo.sdk.android.a.b.a(a).k();
            }

            
            {
                a = b.this;
                super();
            }
        };
        h = new BroadcastReceiver() {

            final b a;

            public void onReceive(Context context, Intent intent)
            {
                if (a.c)
                {
                    com.tremorvideo.sdk.android.a.b.a(a).d();
                }
            }

            
            {
                a = b.this;
                super();
            }
        };
    }

    static com.tremorvideo.sdk.android.a.a a(b b1)
    {
        return b1.i;
    }

    static Activity b(b b1)
    {
        return b1.j;
    }

    static WebView c(b b1)
    {
        return b1.k;
    }

    private Double l()
    {
        return Double.valueOf((new Double(((WindowManager)j.getSystemService("window")).getDefaultDisplay().getWidth())).doubleValue() / (new Double(440D)).doubleValue());
    }

    public int a(aw aw)
    {
        return l.a(aw, -1);
    }

    public int a(aw aw, int i1)
    {
        return l.a(aw, i1);
    }

    public int a(aw aw, int i1, List list)
    {
        return l.a(aw, i1, list);
    }

    public void a()
    {
        i.a();
    }

    public void a(float f1, float f2, int i1)
    {
    }

    public void a(int i1)
    {
        l.a(i1);
    }

    public void a(int i1, int j1, Intent intent)
    {
    }

    public void a(Configuration configuration)
    {
    }

    public void a(Bundle bundle, Activity activity)
    {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            final b a;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                ad.a(throwable.getStackTrace());
                ad.d(throwable.getMessage());
                b.b(a).finish();
            }

            
            {
                a = b.this;
                super();
            }
        });
        j = activity;
        i = new com.tremorvideo.sdk.android.a.a(this, j, a);
        j.requestWindowFeature(1);
        j.getWindow().setFlags(1024, 1024);
        k = new j(j, this);
        bundle = new File((new StringBuilder()).append(a.y().h().getAbsolutePath()).append("/index.html").toString());
        activity = l();
        k.setPadding(0, 0, 0, 0);
        if (activity.doubleValue() >= 1.0D)
        {
            float f1 = j.getResources().getDisplayMetrics().density;
            activity = new android.widget.LinearLayout.LayoutParams((int)((float)440 * f1), (int)((float)320 * f1));
            activity.gravity = 17;
            LinearLayout linearlayout = new LinearLayout(j);
            linearlayout.setGravity(17);
            k.setInitialScale((int)(f1 * 100F));
            e = new Timer();
            e.schedule(new a((new StringBuilder()).append("file://").append(bundle.getAbsolutePath()).toString()), 1000L);
            linearlayout.addView(k, activity);
            j.setContentView(linearlayout);
        } else
        {
            float f2 = ad.J();
            k.setInitialScale((int)(f2 * 100F));
            e = new Timer();
            e.schedule(new a((new StringBuilder()).append("file://").append(bundle.getAbsolutePath()).toString()), 1000L);
            j.setContentView(k);
        }
        l = b;
        j.registerReceiver(f, new IntentFilter("android.intent.action.SCREEN_OFF"));
        j.registerReceiver(g, new IntentFilter("android.intent.action.SCREEN_ON"));
        j.registerReceiver(h, new IntentFilter("android.intent.action.USER_PRESENT"));
    }

    public void a(com.tremorvideo.sdk.android.videoad.a a1)
    {
        j.setResult(100, new Intent());
        j.finish();
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        return false;
    }

    public void b()
    {
        i.b();
    }

    public void b(int i1)
    {
        d = i1;
    }

    public void c()
    {
        i.c();
    }

    public boolean d()
    {
        return false;
    }

    public void e()
    {
    }

    public void f()
    {
        ad.d("BuyItNowWebView - onDestroy");
        if (i != null)
        {
            i.f();
            i = null;
        }
        j.unregisterReceiver(f);
        j.unregisterReceiver(g);
        j.unregisterReceiver(h);
        System.gc();
    }

    public n g()
    {
        return a;
    }

    public Context h()
    {
        return j;
    }

    public int i()
    {
        return Resources.getSystem().getConfiguration().orientation != 2 ? 1 : 0;
    }

    public int j()
    {
        return d;
    }

    public com.tremorvideo.sdk.android.a.a k()
    {
        return i;
    }
}
