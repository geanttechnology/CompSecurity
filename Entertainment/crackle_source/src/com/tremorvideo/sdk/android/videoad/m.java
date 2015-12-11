// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            l, ad, aq

public class m
    implements l
{
    class a extends TimerTask
    {

        final m a;

        public void run()
        {
            a.d.purge();
            a.d.cancel();
            a.d = null;
            a.a.runOnUiThread(new Runnable(this) {

                final a a;

                public void run()
                {
                    if (a.a.b != null)
                    {
                        a.a.b.a(a.a.c);
                    }
                }

            
            {
                a = a1;
                super();
            }
            });
        }

        a()
        {
            a = m.this;
            super();
        }
    }


    Activity a;
    aq b;
    String c;
    Timer d;

    public m()
    {
    }

    public void a()
    {
    }

    public void a(float f1, float f2, int i)
    {
    }

    public void a(int i, int j, Intent intent)
    {
    }

    public void a(Configuration configuration)
    {
    }

    public void a(Bundle bundle, Activity activity)
    {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            final m a;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                ad.a(throwable.getStackTrace());
                ad.d(throwable.getMessage());
                a.a.finish();
            }

            
            {
                a = m.this;
                super();
            }
        });
        a = activity;
        a.requestWindowFeature(1);
        a.getWindow().setFlags(1024, 1024);
        ad.a(a.getWindow());
        c = a.getIntent().getExtras().getString("tremorVideoURL");
        b = ad.a(a);
        b.f();
        d = new Timer();
        d.schedule(new a(), 1500L);
        a.setContentView(b);
    }

    public boolean a(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            b.c();
            b.g();
        }
        return false;
    }

    public void b()
    {
        b.e();
    }

    public void c()
    {
        b.d();
    }

    public boolean d()
    {
        return false;
    }

    public void e()
    {
        b.c();
    }

    public void f()
    {
        ad.d("ActivityWebView - onDestroy");
        b.g();
        b = null;
    }
}
