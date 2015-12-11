// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.b.a.b;
import com.b.e.k;
import com.b.e.n;
import java.util.Calendar;
import java.util.HashMap;

// Referenced classes of package com.b.b:
//            d

public final class e extends BroadcastReceiver
{

    final String a;
    protected final long b = 0x5265c00L;
    protected long c;
    protected long d;
    public boolean e;
    private b f;
    private boolean g;

    public e(b b1)
    {
        c = -1L;
        e = false;
        g = false;
        d = b;
        f = b1;
        a = (new StringBuilder()).append(getClass().getName()).append(".").append(b1.u()).toString();
        IntentFilter intentfilter = new IntentFilter(a);
        b1.ab.registerReceiver(this, intentfilter);
    }

    private static long a(n n1)
    {
        long l1 = 0L;
        n1 = n1.b("lastTransmission");
        long l = l1;
        if (n1 != null)
        {
            l = l1;
            if (n1.length() > 0)
            {
                try
                {
                    l = Long.parseLong(n1);
                }
                // Misplaced declaration of an exception variable
                catch (n n1)
                {
                    return 0L;
                }
            }
        }
        return l;
    }

    private void a(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(c);
        ((AlarmManager)context.getSystemService("alarm")).setRepeating(0, calendar.getTimeInMillis(), b, c());
        g = true;
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private PendingIntent c()
    {
        return PendingIntent.getBroadcast(f.ab, 0, new Intent(a), 0x10000000);
    }

    public final void a()
    {
        a(b);
    }

    public final void a(int i)
    {
        Context context;
label0:
        {
            b();
            e = true;
            (new StringBuilder("start(")).append(i).append(")");
            if (f.ae)
            {
                context = f.ab;
                if (context != null)
                {
                    break label0;
                }
            }
            return;
        }
        long l = System.currentTimeMillis();
        if (c < l)
        {
            c = l + (long)i;
        }
        a(context);
    }

    public final void a(long l)
    {
        b();
        c = System.currentTimeMillis() + l;
        d = l;
        if (e)
        {
            a(0);
        }
    }

    public final void a(boolean flag)
    {
        if (f.ae)
        {
            k k1 = f.a;
            long l = a(f.b);
            l = System.currentTimeMillis() - l;
            (new StringBuilder("processKeepAlive(")).append(flag).append(") timeSinceLastTransmission=").append(l).append(" currentTimeout=").append(d);
            if (l > d - 1000L)
            {
                if (!flag)
                {
                    f.a(d.f, new HashMap(), true);
                } else
                {
                    k1.a(d.f, null);
                }
                f.b.a("lastTransmission", String.valueOf(System.currentTimeMillis()));
            }
        }
    }

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        Context context = f.ab;
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        ((AlarmManager)context.getSystemService("alarm")).cancel(c());
        g = false;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void onReceive(Context context, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        if (g)
        {
            a(false);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }
}
