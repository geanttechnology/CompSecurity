// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.tremorvideo.sdk.android.adapter.TremorAdapterCalls;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            l, n, b, a, 
//            d, c, ad, au, 
//            az, ay, aw, y, 
//            e, u, h, s, 
//            f, q, g, r, 
//            be

public class i
    implements a.a, e.a, l
{

    boolean a;
    boolean b;
    boolean c;
    int d;
    ay.b e;
    boolean f;
    BroadcastReceiver g;
    BroadcastReceiver h;
    BroadcastReceiver i;
    HashMap j;
    private Activity k;
    private a l;
    private n m;
    private ay n;

    public i()
    {
        a = false;
        b = true;
        c = false;
        d = -1;
        f = false;
        g = new BroadcastReceiver() {

            final i a;

            public void onReceive(Context context, Intent intent)
            {
                a.b = false;
                i.a(a).l();
            }

            
            {
                a = i.this;
                super();
            }
        };
        h = new BroadcastReceiver() {

            final i a;

            public void onReceive(Context context, Intent intent)
            {
                a.b = true;
                i.a(a).k();
            }

            
            {
                a = i.this;
                super();
            }
        };
        i = new BroadcastReceiver() {

            final i a;

            public void onReceive(Context context, Intent intent)
            {
                if (a.b)
                {
                    i.a(a).d();
                }
            }

            
            {
                a = i.this;
                super();
            }
        };
        j = new HashMap();
    }

    static a a(i i1)
    {
        return i1.l;
    }

    private void a(a.b b1)
    {
        if (b1 != a.b.a) goto _L2; else goto _L1
_L1:
        if (!m.v()) goto _L4; else goto _L3
_L3:
        b(new b(this, k, m, true));
        l.a();
_L6:
        return;
_L4:
        a(a.b.d);
        return;
_L2:
        if (b1 == a.b.b)
        {
            if (c || !l.j())
            {
                a(a.b.c);
                return;
            }
            if (a(m.u()))
            {
                b(new d(this, k, m));
                return;
            } else
            {
                a(a.b.c);
                return;
            }
        }
        if (b1 == a.b.c)
        {
            if (a(m.s()))
            {
                b(new c(this, k, m));
                return;
            } else
            {
                a(a.b.a);
                return;
            }
        }
        if (b1 == a.b.d)
        {
            ad.d("<<< Ad End");
            if (f)
            {
                b1 = new Intent();
                b1.putExtra("TREMOR_VAST_RESULT", "Vast Tag Playback Success");
                k.setResult(-1, b1);
                k.finish();
                return;
            }
            ad.A().h();
            b1 = k;
            byte byte0;
            if (c)
            {
                byte0 = 101;
            } else
            {
                byte0 = 100;
            }
            b1.setResult(byte0, new Intent());
            k.finish();
            TremorAdapterCalls.onAdFinished();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean a(az az1)
    {
        return az1 != null && az1.d() != null;
    }

    private boolean a(be be)
    {
        return be != null;
    }

    static Activity b(i i1)
    {
        return i1.k;
    }

    private void b(a a1)
    {
        l = a1;
    }

    private void c(int i1)
    {
label0:
        {
            ay.a a1 = n.b(i1);
            if (a1 != null)
            {
                if (a1.c.c().equals("-1"))
                {
                    break label0;
                }
                a1.c.a(a1);
            }
            return;
        }
        ad.d("Event had ID of -1: not fired");
    }

    private void n()
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(k);
        builder.setTitle("Tremor Video Integration Error");
        builder.setMessage("You must disable hardware acceleration for the \"com.tremorvideo.sdk.android.videoad.Playvideo\" Activity in AndroidManifest.xml:\n\nPlease consult the supplied documentation for more information.");
        builder.create().show();
    }

    public int a(aw aw1)
    {
        return a(aw1, -1, ((List) (null)));
    }

    public int a(aw aw1, int i1)
    {
        return a(aw1, i1, ((List) (null)));
    }

    public int a(aw aw1, int i1, List list)
    {
        int j1 = -1;
        if (aw1 != null)
        {
            if (aw1.a() == aw.b.v)
            {
                c = true;
            }
            ad.d((new StringBuilder()).append("Starting Event: ").append(ad.D()).append("ms ").append(aw1.a().toString()).append(" ").append(aw1.h()).append(" ").append(aw1.c()).toString());
            i1 = n.a(aw1, i1, e, list);
            j1 = i1;
            if (aw1.g())
            {
                c(i1);
                j1 = i1;
            }
        }
        return j1;
    }

    public void a()
    {
        if (l != null)
        {
            l.a();
        }
    }

    public void a(float f1, float f2, int i1)
    {
        if (l.m() && i1 == 0)
        {
            View view = k.getWindow().getDecorView();
            if (view != null)
            {
                e = new ay.b(f1, f2, view.getWidth(), view.getHeight());
            }
            if (m.n != null)
            {
                a(a(m.n));
            }
        }
    }

    public void a(int i1)
    {
        if (i1 != -1)
        {
            n.a(i1);
            ay.a a1 = n.b(i1);
            aw aw1 = a1.c;
            ad.d((new StringBuilder()).append("Ending Event: ").append(a1.e).append("ms ").append(aw1.a().toString()).append(" ").append(aw1.h()).append(" ").append(aw1.c()).toString());
            if (!aw1.g())
            {
                c(i1);
            }
        }
    }

    public void a(int i1, int j1, Intent intent)
    {
        ad.d("activity returned");
        if (intent != null)
        {
            int k1 = intent.getIntExtra("endEventId", -1);
            if (k1 > -1)
            {
                a(k1);
            }
        }
        if (l != null)
        {
            l.a(i1, j1, intent);
        }
    }

    public void a(Configuration configuration)
    {
        l.a(configuration);
    }

    public void a(Bundle bundle, Activity activity)
    {
        ad.d("ActivityAd - onCreate");
        k = activity;
        boolean flag;
        if (k.getIntent().getExtras().getString("vastURL") != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            final i a;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                ad.a(throwable.getStackTrace());
                ad.d(throwable.getMessage());
                i.b(a).finish();
                TremorAdapterCalls.onAdFinished();
            }

            
            {
                a = i.this;
                super();
            }
        });
        try
        {
            if (ad.v() == null)
            {
                ad.d("Calling application has been force killed, exiting...");
                k.finish();
                TremorAdapterCalls.onAdFinished();
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ad.a(bundle);
            k.finish();
            TremorAdapterCalls.onAdFinished();
            return;
        }
        try
        {
            k();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            ad.d((new StringBuilder()).append(" Exception onAdDownloaded").append(bundle).toString());
        }
        k.registerReceiver(g, new IntentFilter("android.intent.action.SCREEN_OFF"));
        k.registerReceiver(h, new IntentFilter("android.intent.action.SCREEN_ON"));
        k.registerReceiver(i, new IntentFilter("android.intent.action.USER_PRESENT"));
    }

    public void a(a a1)
    {
        this;
        JVM INSTR monitorenter ;
        if (j != null && !j.containsKey(a1))
        {
            j.put(a1, Boolean.valueOf(true));
            a.b b1 = a1.n();
            a1.o();
            a(b1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        a1;
        throw a1;
    }

    public void a(n n1)
    {
        m = n1;
    }

    public boolean a(int i1, KeyEvent keyevent)
    {
        while (i1 == 84 || i1 == 82 || l.a(i1, keyevent)) 
        {
            return true;
        }
        return false;
    }

    public void b()
    {
        if (l != null)
        {
            l.b();
        }
    }

    public void b(int i1)
    {
        d = i1;
    }

    public void c()
    {
        if (l != null)
        {
            l.c();
        }
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
        if (m != null)
        {
            m.c();
        }
        System.gc();
        try
        {
            k.unregisterReceiver(g);
            k.unregisterReceiver(h);
            k.unregisterReceiver(i);
            return;
        }
        catch (Exception exception)
        {
            ad.d((new StringBuilder()).append("UnregisterReceiver: ").append(exception).toString());
        }
    }

    public n g()
    {
        return m;
    }

    public Context h()
    {
        return k;
    }

    public int i()
    {
        return Resources.getSystem().getConfiguration().orientation != 2 ? 1 : 0;
    }

    public int j()
    {
        return d;
    }

    public boolean k()
        throws Exception
    {
        boolean flag;
        n = new ay();
        n.a();
        flag = ad.a(k);
        ad.d(">>> Ad Start");
        if (!f)
        {
            m = ad.A().f();
            if (!m.b())
            {
                m.a(k);
            }
            (new y(k.getFilesDir())).c(m);
        }
        if (!f) goto _L2; else goto _L1
_L1:
        TremorAdapterCalls.setActivity(this);
        b(new e(k, this, null, f, this));
_L4:
        if (flag)
        {
            n();
        }
        return true;
_L2:
        if (m.g() == n.b.b || m.g() == n.b.e)
        {
            TremorAdapterCalls.setActivity(this);
            b(new e(k, this, (u)m, f, null));
        } else
        if (m.g() == n.b.c)
        {
            TremorAdapterCalls.setActivity(this);
            b(new h(this, k, (s)m));
        } else
        if (m.g() == n.b.d)
        {
            b(new f(this, k, (q)m));
        } else
        if (m.g() == n.b.f)
        {
            b(new g(this, k, (r)m));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public int l()
    {
        if (l != null && m != null)
        {
            if (m.g() == n.b.b || m.g() == n.b.e)
            {
                return ((e)l).e();
            }
            if (m.g() == n.b.c)
            {
                return ((h)l).s();
            }
        }
        return -1;
    }

    public int m()
    {
        if (m != null)
        {
            if (l != null && m.g() == n.b.c)
            {
                return ((h)l).t();
            } else
            {
                return m.A();
            }
        } else
        {
            return -1;
        }
    }
}
