// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;

// Referenced classes of package com.a:
//            g, c, a

public final class f
{

    private String a;
    private String b;
    private Activity c;
    private a d;

    public f(Activity activity)
    {
        c = activity;
    }

    private boolean a()
    {
        NetworkInfo networkinfo;
        int i;
        boolean flag;
        try
        {
            networkinfo = ((ConnectivityManager)c.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        }
        catch (Exception exception)
        {
            int j = g.f;
            return false;
        }
        if (networkinfo == null) goto _L2; else goto _L1
_L1:
        if (!networkinfo.isConnectedOrConnecting()) goto _L2; else goto _L3
_L3:
        flag = true;
_L5:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        i = g.a;
        return flag;
_L2:
        flag = false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final void a(String s)
    {
        a = s;
    }

    public final void a(String s, long l)
    {
label0:
        {
            if (d == null && a())
            {
                String s1 = a;
                String s2 = b;
                int i;
                if (s1 == null || !s1.matches("^https?://[\\w-]+(\\.[\\w-]+)+(/[^?]*)?$"))
                {
                    i = g.b;
                    i = 0;
                } else
                if (s2 == null || !s2.matches("^\\d{1,6}$"))
                {
                    i = g.c;
                    i = 0;
                } else
                if (s == null || !s.matches("^[\\w-]{1,32}$"))
                {
                    i = g.d;
                    i = 0;
                } else
                {
                    i = 1;
                }
                if (i != 0)
                {
                    d = new c(c, null, null);
                    d.a(-1L);
                    if (android.os.Build.VERSION.SDK_INT <= 10)
                    {
                        break label0;
                    }
                    d.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] {
                        a, b, s
                    });
                }
            }
            return;
        }
        d.execute(new String[] {
            a, b, s
        });
    }

    public final void b(String s)
    {
        b = s;
    }
}
