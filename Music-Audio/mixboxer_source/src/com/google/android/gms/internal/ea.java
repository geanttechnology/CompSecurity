// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;

// Referenced classes of package com.google.android.gms.internal:
//            eg

public final class ea
{

    private final String pM;

    public ea(String s)
    {
        pM = (String)eg.f(s);
    }

    public boolean K(int i)
    {
        return Log.isLoggable(pM, i);
    }

    public void a(String s, String s1, Throwable throwable)
    {
        if (K(6))
        {
            Log.e(s, s1, throwable);
        }
    }

    public void c(String s, String s1)
    {
        if (K(5))
        {
            Log.w(s, s1);
        }
    }

    public void d(String s, String s1)
    {
        if (K(6))
        {
            Log.e(s, s1);
        }
    }
}
