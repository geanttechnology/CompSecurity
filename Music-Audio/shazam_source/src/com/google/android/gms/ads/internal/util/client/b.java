// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;

public final class b
{

    public static void a(String s)
    {
        if (a(6))
        {
            Log.e("Ads", s);
        }
    }

    public static void a(String s, Throwable throwable)
    {
        if (a(6))
        {
            Log.e("Ads", s, throwable);
        }
    }

    public static boolean a(int i)
    {
label0:
        {
            if (i < 5 && !Log.isLoggable("Ads", i))
            {
                break label0;
            }
            if (i == 2)
            {
                com.google.android.gms.d.au au = ay.ab;
                if (!((Boolean)p.n().a(au)).booleanValue())
                {
                    break label0;
                }
            }
            return true;
        }
        return false;
    }
}
