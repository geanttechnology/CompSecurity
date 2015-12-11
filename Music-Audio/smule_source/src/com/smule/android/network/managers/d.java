// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.LocalBroadcastManager;
import com.smule.android.c.aa;
import com.smule.android.f.h;
import com.smule.android.f.p;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.r;
import java.util.concurrent.TimeUnit;

public class d
{

    private static final String a = com/smule/android/network/managers/d.getName();
    private static d b;
    private Context c;
    private boolean d;
    private int e;
    private long f;

    private d()
    {
        d = false;
        f = 0L;
    }

    public static d a()
    {
        com/smule/android/network/managers/d;
        JVM INSTR monitorenter ;
        d d1;
        if (b == null)
        {
            b = new d();
        }
        d1 = b;
        com/smule/android/network/managers/d;
        JVM INSTR monitorexit ;
        return d1;
        Exception exception;
        exception;
        throw exception;
    }

    static void a(d d1, int i)
    {
        d1.b(i);
    }

    private void a(String s)
    {
        Intent intent = new Intent();
        intent.setAction(s);
        LocalBroadcastManager.getInstance(c).sendBroadcast(intent);
    }

    private void b(int i)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d();
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        d = true;
        Object obj;
        i = f();
        obj = c.getSharedPreferences(com.smule.android.network.core.b.d().o(), 0);
        if (i < 0) goto _L4; else goto _L3
_L3:
        obj = ((SharedPreferences) (obj)).edit();
        ((android.content.SharedPreferences.Editor) (obj)).putInt("credits", i);
        p.a(((android.content.SharedPreferences.Editor) (obj)));
_L7:
        if (i == e) goto _L6; else goto _L5
_L5:
        e = i;
        h.a().a("BALANCE_UPDATE_EVENT", new Object[0]);
        a("BALANCE_UPDATE_EVENT");
_L8:
        f = System.currentTimeMillis();
_L9:
        d = false;
          goto _L1
        obj;
        throw obj;
_L4:
        i = ((SharedPreferences) (obj)).getInt("credits", 0);
          goto _L7
_L6:
        h.a().a("BALANCE_SAME_EVENT", new Object[0]);
        a("BALANCE_SAME_EVENT");
          goto _L8
        Exception exception;
        exception;
        aa.c(a, "Problem retrieving balance", exception);
          goto _L9
    }

    private int f()
    {
        o o1;
        if (r.a(c))
        {
            if ((o1 = com.smule.android.network.a.b.a()) != null)
            {
                return o1.a("amount", -1);
            }
        }
        return -1;
    }

    public void a(int i)
    {
        a(i, ((Runnable) (null)));
    }

    public void a(int i, Runnable runnable)
    {
        com.smule.android.network.core.b.a(new Runnable(i, runnable) {

            final int a;
            final Runnable b;
            final d c;

            public void run()
            {
                d.a(c, a);
                if (b != null)
                {
                    b.run();
                }
            }

            
            {
                c = d.this;
                a = i;
                b = runnable;
                super();
            }
        });
    }

    public void a(Context context)
    {
        c = context;
        e = c.getSharedPreferences(com.smule.android.network.core.b.d().o(), 0).getInt("credits", 0);
    }

    public void b()
    {
        com.smule.android.network.core.b.a(new Runnable() {

            final d a;

            public void run()
            {
                d.a(a, 1);
            }

            
            {
                a = d.this;
                super();
            }
        }, 5L, TimeUnit.SECONDS);
    }

    public void c()
    {
        if (System.currentTimeMillis() > f + 0x493e0L)
        {
            a(0, ((Runnable) (null)));
        }
    }

    public boolean d()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public int e()
    {
        if (e < 0)
        {
            return 0;
        } else
        {
            return e;
        }
    }

}
