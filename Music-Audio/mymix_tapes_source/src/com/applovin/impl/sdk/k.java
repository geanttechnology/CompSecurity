// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.sdk:
//            bw, bz, l

class k
    implements AppLovinLogger
{

    private bz a;
    private l b;

    k()
    {
    }

    void a(bz bz1)
    {
        a = bz1;
    }

    void a(l l1)
    {
        b = l1;
    }

    boolean a()
    {
        if (a != null)
        {
            return ((Boolean)a.a(bw.j)).booleanValue();
        } else
        {
            return false;
        }
    }

    public void d(String s, String s1)
    {
        if (a())
        {
            Log.d("AppLovinSdk", (new StringBuilder()).append("[").append(s).append("] ").append(s1).toString());
        }
        if (b != null)
        {
            b.a((new StringBuilder()).append("DEBUG  [").append(s).append("] ").append(s1).toString());
        }
    }

    public void e(String s, String s1)
    {
        e(s, s1, null);
    }

    public void e(String s, String s1, Throwable throwable)
    {
        if (a())
        {
            Log.e("AppLovinSdk", (new StringBuilder()).append("[").append(s).append("] ").append(s1).toString(), throwable);
        }
        if (b != null)
        {
            l l1 = b;
            s1 = (new StringBuilder()).append("ERROR  [").append(s).append("] ").append(s1);
            if (throwable != null)
            {
                s = (new StringBuilder()).append(": ").append(throwable.getMessage()).toString();
            } else
            {
                s = "";
            }
            l1.a(s1.append(s).toString());
        }
    }

    public void i(String s, String s1)
    {
        if (a())
        {
            Log.i("AppLovinSdk", (new StringBuilder()).append("[").append(s).append("] ").append(s1).toString());
        }
        if (b != null)
        {
            b.a((new StringBuilder()).append("INFO  [").append(s).append("] ").append(s1).toString());
        }
    }

    public void userError(String s, String s1)
    {
        userError(s, s1, null);
    }

    public void userError(String s, String s1, Throwable throwable)
    {
        Log.e("AppLovinSdk", (new StringBuilder()).append("[").append(s).append("] ").append(s1).toString(), throwable);
        if (b != null)
        {
            l l1 = b;
            s1 = (new StringBuilder()).append("USER  [").append(s).append("] ").append(s1);
            if (throwable != null)
            {
                s = (new StringBuilder()).append(": ").append(throwable.getMessage()).toString();
            } else
            {
                s = "";
            }
            l1.a(s1.append(s).toString());
        }
    }

    public void w(String s, String s1)
    {
        w(s, s1, null);
    }

    public void w(String s, String s1, Throwable throwable)
    {
        if (a())
        {
            Log.w("AppLovinSdk", (new StringBuilder()).append("[").append(s).append("] ").append(s1).toString(), throwable);
        }
        if (b != null)
        {
            b.a((new StringBuilder()).append("WARN  [").append(s).append("] ").append(s1).toString());
        }
    }
}
