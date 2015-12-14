// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import com.inmobi.commons.a.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.List;

// Referenced classes of package com.inmobi.signals.b:
//            b

public class c
{
    public static interface a
    {

        public abstract void a();

        public abstract void a(List list);
    }


    private static final String a = com/inmobi/signals/b/c.getSimpleName();
    private static Context b = null;
    private static a c = null;
    private static Handler d = null;
    private static boolean e = false;
    private static final IntentFilter f = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private static List g;
    private static Runnable h = new Runnable() {

        public void run()
        {
            a a1 = c.b();
            c.c();
            if (a1 != null)
            {
                a1.a();
            }
        }

    };
    private static final BroadcastReceiver i = new BroadcastReceiver() {

        public void onReceive(Context context, Intent intent)
        {
            context = c.b();
            intent = (WifiManager)c.d().getSystemService("wifi");
            c.c();
            if (context != null)
            {
                com.inmobi.signals.b.c.a(com.inmobi.signals.b.b.a(intent.getScanResults()));
                context.a(c.e());
            }
        }

    };

    public c()
    {
    }

    public static List a()
    {
        return g;
    }

    static List a(List list)
    {
        g = list;
        return list;
    }

    private static boolean a(Looper looper, a a1, long l, boolean flag)
    {
        com/inmobi/signals/b/c;
        JVM INSTR monitorenter ;
        Object obj = d;
        if (obj == null) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        com/inmobi/signals/b/c;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        obj = (WifiManager)com.inmobi.commons.a.a.b().getSystemService("wifi");
        if (!((WifiManager) (obj)).isWifiEnabled())
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        c = a1;
        d = new Handler(looper);
        d.postDelayed(h, l);
        h();
        flag = ((WifiManager) (obj)).startScan();
        if (true) goto _L4; else goto _L3
_L3:
        looper;
        throw looper;
    }

    public static boolean a(a a1)
    {
        b = com.inmobi.commons.a.a.b();
        return a(Looper.myLooper(), a1, 10000L, false);
    }

    static a b()
    {
        return c;
    }

    static void c()
    {
        f();
    }

    static Context d()
    {
        return b;
    }

    static List e()
    {
        return g;
    }

    private static void f()
    {
        com/inmobi/signals/b/c;
        JVM INSTR monitorenter ;
        Handler handler = d;
        if (handler != null) goto _L2; else goto _L1
_L1:
        com/inmobi/signals/b/c;
        JVM INSTR monitorexit ;
        return;
_L2:
        d.removeCallbacks(h);
        g();
        d = null;
        c = null;
        b = null;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private static void g()
    {
        if (!e)
        {
            return;
        }
        e = false;
        try
        {
            b.unregisterReceiver(i);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Failed to register for Wifi scanning.");
        }
    }

    private static void h()
    {
        if (e)
        {
            return;
        } else
        {
            e = true;
            b.registerReceiver(i, f, null, d);
            return;
        }
    }

}
