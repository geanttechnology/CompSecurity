// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.ads.conversiontracking:
//            e, j

public class f
    implements Runnable
{

    private static final long a;
    private static final long b;
    private static Object c = new Object();
    private static f d;
    private final long e;
    private final long f;
    private final e g;
    private final Context h;
    private final HandlerThread i = new HandlerThread("Google Conversion SDK", 10);
    private final Object j = new Object();
    private final Set k = new HashSet();
    private final Map l = new HashMap();
    private final SharedPreferences m;
    private long n;
    private Handler o;

    f(Context context, long l1, long l2, e e1)
    {
        h = context;
        f = l1;
        e = l2;
        g = e1;
        m = h.getSharedPreferences("google_auto_usage", 0);
        d();
        i.start();
        o = new Handler(i.getLooper());
        c();
    }

    public static f a(Context context)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        f f1 = d;
        if (f1 != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        d = new f(context, a, b, new e(context));
_L1:
        obj;
        JVM INSTR monitorexit ;
        return d;
        context;
        Log.e("GoogleConversionReporter", "Error starting automated usage thread", context);
          goto _L1
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private long b()
    {
        long l2 = com.google.ads.conversiontracking.j.a();
        long l1 = 0L;
        if (l2 >= n)
        {
            l1 = (l2 - n) / f + 1L;
        }
        l2 = n;
        return l1 * f + l2;
    }

    private void b(long l1)
    {
        m.edit().putLong("end_of_interval", l1).commit();
        n = l1;
    }

    private void c()
    {
        synchronized (j)
        {
            a(b() - com.google.ads.conversiontracking.j.a());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void d()
    {
        if (n == 0L)
        {
            long l1 = com.google.ads.conversiontracking.j.a();
            long l2 = f;
            n = m.getLong("end_of_interval", l1 + l2);
        }
    }

    protected void a(long l1)
    {
        synchronized (j)
        {
            if (o != null)
            {
                o.removeCallbacks(this);
                o.postDelayed(this, l1);
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(String s)
    {
label0:
        {
            synchronized (j)
            {
                if (!k.contains(s) && !l.containsKey(s))
                {
                    break label0;
                }
            }
            return;
        }
        g.a(s, n);
        l.put(s, Long.valueOf(n));
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    protected boolean a()
    {
        Object obj = (ActivityManager)h.getSystemService("activity");
        KeyguardManager keyguardmanager = (KeyguardManager)h.getSystemService("keyguard");
        PowerManager powermanager = (PowerManager)h.getSystemService("power");
        for (obj = ((ActivityManager) (obj)).getRunningAppProcesses().iterator(); ((Iterator) (obj)).hasNext();)
        {
            android.app.ActivityManager.RunningAppProcessInfo runningappprocessinfo = (android.app.ActivityManager.RunningAppProcessInfo)((Iterator) (obj)).next();
            if (Process.myPid() == runningappprocessinfo.pid && runningappprocessinfo.importance == 100 && !keyguardmanager.inKeyguardRestrictedInputMode() && powermanager.isScreenOn())
            {
                return true;
            }
        }

        return false;
    }

    public boolean b(String s)
    {
        return l.containsKey(s);
    }

    public void run()
    {
        if (!a())
        {
            a(e);
            return;
        }
        Object obj = j;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = l.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String s = (String)entry.getKey();
            if (((Long)entry.getValue()).longValue() < n)
            {
                entry.setValue(Long.valueOf(n));
                g.a(s, n);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_123;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        obj;
        JVM INSTR monitorexit ;
        c();
        b(b());
        return;
    }

    static 
    {
        a = TimeUnit.SECONDS.toMillis(3600L);
        b = TimeUnit.SECONDS.toMillis(30L);
    }
}
