// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.util.client;

import android.util.Log;
import com.google.android.gms.internal.zzbu;
import com.google.android.gms.internal.zzby;

public final class zzb
{

    public static void e(String s)
    {
        if (zzN(6))
        {
            Log.e("Ads", s);
        }
    }

    public static void v(String s)
    {
        if (zzN(2))
        {
            Log.v("Ads", s);
        }
    }

    public static boolean zzN(int i)
    {
        return (i >= 5 || Log.isLoggable("Ads", i)) && (i != 2 || zzgU());
    }

    public static void zza(String s, Throwable throwable)
    {
        if (zzN(3))
        {
            Log.d("Ads", s, throwable);
        }
    }

    public static void zzaF(String s)
    {
        if (zzN(3))
        {
            Log.d("Ads", s);
        }
    }

    public static void zzaG(String s)
    {
        if (zzN(4))
        {
            Log.i("Ads", s);
        }
    }

    public static void zzaH(String s)
    {
        if (zzN(5))
        {
            Log.w("Ads", s);
        }
    }

    public static void zzb(String s, Throwable throwable)
    {
        if (zzN(6))
        {
            Log.e("Ads", s, throwable);
        }
    }

    public static void zzc(String s, Throwable throwable)
    {
        if (zzN(4))
        {
            Log.i("Ads", s, throwable);
        }
    }

    public static void zzd(String s, Throwable throwable)
    {
        if (zzN(5))
        {
            Log.w("Ads", s, throwable);
        }
    }

    public static boolean zzgU()
    {
        return ((Boolean)zzby.zzvl.get()).booleanValue();
    }
}
