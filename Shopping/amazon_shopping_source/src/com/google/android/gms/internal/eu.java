// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.util.Log;

public final class eu
{

    public static void D(String s)
    {
        if (p(5))
        {
            Log.w("Ads", s);
        }
    }

    public static boolean p(int i)
    {
        return (i >= 5 || Log.isLoggable("Ads", i)) && i != 2;
    }

    public static void z(String s)
    {
        if (p(3))
        {
            Log.d("Ads", s);
        }
    }
}
