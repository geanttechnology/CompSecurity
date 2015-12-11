// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.a.g;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.a.w;
import com.smule.pianoandroid.a.z;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{

    private static final String a = com/smule/pianoandroid/e/d.getName();
    private static d b = null;
    private static Context c = null;
    private long d;
    private AtomicBoolean e;
    private AtomicBoolean f;
    private boolean g;

    private d()
    {
        d = 0L;
        e = new AtomicBoolean(false);
        f = new AtomicBoolean(false);
    }

    public static d a()
    {
        com/smule/pianoandroid/e/d;
        JVM INSTR monitorenter ;
        d d1;
        if (b == null)
        {
            b = new d();
        }
        d1 = b;
        com/smule/pianoandroid/e/d;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(d d1)
    {
        d1.h();
    }

    private void a(boolean flag)
    {
        p.a(z.a().b().edit().putBoolean("game.data.fetched", flag));
        g = flag;
    }

    static String e()
    {
        return a;
    }

    static Context f()
    {
        return c;
    }

    private void g()
    {
        aa.d(a, "Starting game data sync");
        com.smule.android.f.h.a().a("game.data.sync", new Object[0]);
        if (r.a(c))
        {
            d = System.currentTimeMillis();
        }
    }

    private void h()
    {
        aa.c(a, "Fetching game data");
        o o1 = com.smule.android.network.a.g.b();
        if (o1.j == null || !o1.a())
        {
            com.smule.android.f.h.a().a("game.data.error", new Object[0]);
            aa.b(a, "Error fetching game data.");
        } else
        {
            com.smule.android.f.h.a().a("game.data.available", new Object[] {
                "game.data.param", o1
            });
            a(true);
            aa.c(a, "Done fetching game data.");
        }
        f.set(false);
    }

    private boolean i()
    {
        return z.a().b().getBoolean("game.data.fetched", false);
    }

    public void a(Context context)
    {
        c = context;
        g = i();
        context = new BroadcastReceiver() {

            final d a;

            public void onReceive(Context context1, Intent intent)
            {
                aa.c(d.e(), "Network connectivity changed.");
                if (r.a(d.f()))
                {
                    aa.c(d.e(), "Network just connected");
                    w.a(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            a.a.b();
                        }

            
            {
                a = _pcls1;
                super();
            }
                    });
                }
            }

            
            {
                a = d.this;
                super();
            }
        };
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        c.registerReceiver(context, intentfilter);
    }

    public void b()
    {
        if (d + 60000L > System.currentTimeMillis())
        {
            return;
        } else
        {
            c();
            return;
        }
    }

    public void c()
    {
        if (e.getAndSet(true))
        {
            return;
        }
        g();
        e.set(false);
        return;
        Exception exception;
        exception;
        e.set(false);
        throw exception;
    }

    public void d()
    {
        if (!g && UserManager.n().h() && !f.getAndSet(true))
        {
            com.smule.android.network.core.b.a(new Runnable() {

                final d a;

                public void run()
                {
                    d.a(a);
                }

            
            {
                a = d.this;
                super();
            }
            });
        }
    }

}
