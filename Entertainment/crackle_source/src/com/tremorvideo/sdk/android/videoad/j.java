// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            l, ad, s, t, 
//            au, u, n, Playvideo

public class j
    implements au.c, l
{

    Activity a;
    int b;
    int c;
    long d;
    boolean e;
    n f;
    boolean g;
    boolean h;
    Handler i;
    au j;
    Runnable k;

    public j()
    {
        b = -1;
        c = 0;
        e = true;
        i = new Handler();
        j = ad.A();
        k = new Runnable() {

            final j a;

            public void run()
            {
                ad.d("ASSET DOWNLOAD TIMEOUT");
                if (a.f != null)
                {
                    if ((a.f instanceof s) || (a.f instanceof u) && !a.f.p || (a.f instanceof t) && !a.f.p)
                    {
                        if (a.c > 1)
                        {
                            a.j.b();
                            a.i();
                            return;
                        } else
                        {
                            a.j.b();
                            a.f = null;
                            a.g();
                            return;
                        }
                    } else
                    {
                        a.j.b();
                        a.i();
                        return;
                    }
                } else
                {
                    a.j.b();
                    a.i();
                    return;
                }
            }

            
            {
                a = j.this;
                super();
            }
        };
    }

    public void a()
    {
        ad.d("ActiveAdProgress onStart");
        if (!g)
        {
            g();
        }
        g = false;
    }

    public void a(float f1, float f2, int i1)
    {
    }

    public void a(int i1, int j1, Intent intent)
    {
    }

    public void a(Configuration configuration)
    {
        a.getWindow().setFlags(1024, 1024);
    }

    public void a(Bundle bundle, Activity activity)
    {
        ad.d("ActivityAdProgress onCreate");
        a = activity;
        c = 0;
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            final j a;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                ad.a(throwable.getStackTrace());
                ad.d(throwable.getMessage());
                a.a.finish();
            }

            
            {
                a = j.this;
                super();
            }
        });
        a.requestWindowFeature(1);
        a.getWindow().setFlags(1024, 1024);
        bundle = new LinearLayout(a);
        activity = new ProgressBar(a, null, 0x101007a);
        activity.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        bundle.setGravity(17);
        bundle.addView(activity);
        if (ad.q() >= 9)
        {
            a.setRequestedOrientation(6);
        } else
        {
            a.setRequestedOrientation(0);
        }
        a.setContentView(bundle);
    }

    public void a(n n1)
    {
        ad.d("onCurrentAdDownloadFlowStart");
        f = n1;
        if (f instanceof s)
        {
            ad.d("onCurrentAdDownloadFlowStart : AdRichMedia");
        } else
        if (f instanceof t)
        {
            ad.d("onCurrentAdDownloadFlowStart : AdVAST");
            return;
        }
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        return i1 == 4;
    }

    public void b()
    {
        g = true;
        ad.d("ActiveAdProgress onPause");
    }

    public void c()
    {
        g = false;
        if (h)
        {
            h = false;
            k();
        }
        ad.d("ActiveAdProgress onResume");
    }

    public boolean d()
    {
        return false;
    }

    public void e()
    {
        ad.d("ActiveAdProgress onStop");
    }

    public void f()
    {
        ad.d("ActiveAdProgress onDestroy");
    }

    public void g()
    {
        if (c == 0)
        {
            f = j.e();
            if (f != null && ((f instanceof s) || (f instanceof u) && !f.p || (f instanceof t) && !f.p))
            {
                c = 1;
                j.b();
                f = null;
            }
        }
        if (i != null)
        {
            i.removeCallbacks(k);
        }
        if (c == 0 || c == 1)
        {
            d = SystemClock.elapsedRealtime();
            if (c == 1)
            {
                try
                {
                    Thread.sleep(1000L);
                    ad.d("downloadManager.start call streaming true");
                    j.a(true, this);
                }
                catch (Exception exception) { }
            } else
            {
                ad.d("downloadManager.start call streaming false");
                j.c = null;
                j.a(false, this);
            }
            c = c + 1;
            i.postDelayed(k, (long)ad.f + ad.g);
        } else
        {
            i();
        }
        ad.d((new StringBuilder()).append("attempt=").append(c).toString());
    }

    public void h()
    {
        ad.d("onRequestDownloadComplete");
    }

    public void i()
    {
        if (i != null)
        {
            i.removeCallbacks(k);
        }
        TremorAdapterCalls.onGetAdFailed();
        a.finish();
    }

    public void j()
    {
        ad.d("onRequestDownloadTimeout");
        i();
    }

    public void k()
    {
        this;
        JVM INSTR monitorenter ;
        if (!e) goto _L2; else goto _L1
_L1:
        ad.d("onAsssetDownloadComplete showAd loop");
        if (ad.A().e(ad.o())) goto _L4; else goto _L3
_L3:
        ad.d("Progress: Failed to Start the Ad");
        i();
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        e = false;
        Intent intent = new Intent(a, com/tremorvideo/sdk/android/videoad/Playvideo);
        intent.putExtra("tremorVideoType", "ad");
        a.startActivityForResult(intent, 131);
        a.finish();
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    public void l()
    {
        ad.d("onAsssetDownloadComplete");
        i.removeCallbacks(k);
        if (g)
        {
            h = true;
            return;
        } else
        {
            k();
            return;
        }
    }

    public void m()
    {
        if (e)
        {
            i();
        }
    }

    public void n()
    {
        g();
    }
}
