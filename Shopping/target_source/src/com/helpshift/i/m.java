// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;

public final class m
{

    Runnable a;
    private Handler b;
    private float c;
    private float d;
    private float e;
    private Boolean f;
    private Context g;

    public m(Handler handler, int i, Boolean boolean1, Context context)
    {
        e = 60000F;
        f = Boolean.valueOf(false);
        g = null;
        a = new Runnable() {

            final m a;

            public void run()
            {
                m.a(a).sendMessage(m.a(a).obtainMessage());
                m.a(a).postDelayed(a.a, (long)m.b(a));
                if (m.c(a).booleanValue())
                {
                    a.a(m.b(a));
                }
            }

            
            {
                a = m.this;
                super();
            }
        };
        b = handler;
        c = i * 1000;
        d = i * 1000;
        f = boolean1;
        g = context;
    }

    static Handler a(m m1)
    {
        return m1.b;
    }

    private static Float a(Intent intent)
    {
        int i = intent.getIntExtra("level", -1);
        int j = intent.getIntExtra("scale", -1);
        return Float.valueOf((float)i / (float)j);
    }

    private static String a(Context context)
    {
        NetworkInfo networkinfo = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        context = "Unknown";
        if (networkinfo != null)
        {
            context = networkinfo.getTypeName();
        }
        return context;
    }

    static float b(m m1)
    {
        return m1.c;
    }

    static Boolean c(m m1)
    {
        return m1.f;
    }

    public void a()
    {
        c = d;
        b.removeCallbacks(a);
        b.postDelayed(a, (long)c);
    }

    public void a(float f1)
    {
        if (f1 >= e) goto _L2; else goto _L1
_L1:
        float f2;
        f2 = d;
        IntentFilter intentfilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        f2 = (f2 + f1) * 1.618F * (2.0F - a(g.registerReceiver(null, intentfilter)).floatValue());
        boolean flag = a(g).equals("WIFI");
        f1 = f2;
        if (!flag)
        {
            f1 = f2 * 1.618F;
        }
_L4:
        if (f1 <= e)
        {
            break; /* Loop/switch isn't completed */
        }
        c = e;
_L2:
        return;
        SecurityException securityexception;
        securityexception;
        Log.d("HelpShiftDebug", "No permission for Network Access", securityexception);
        f1 = f2;
        if (true) goto _L4; else goto _L3
_L3:
        c = f1;
        return;
    }

    public void b()
    {
        a.run();
    }

    public void c()
    {
        b.removeCallbacks(a);
    }
}
