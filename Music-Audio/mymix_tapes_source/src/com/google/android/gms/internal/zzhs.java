// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Future;

public final class zzhs
{

    static SharedPreferences zzH(Context context)
    {
        return zzv(context);
    }

    public static Future zza(Context context, int i)
    {
        return (new _cls3(context, i)).zzgn();
    }

    public static Future zza(Context context, zzb zzb1)
    {
        return (new _cls2(context, zzb1)).zzgn();
    }

    public static Future zza(Context context, boolean flag)
    {
        return (new _cls1(context, flag)).zzgn();
    }

    public static Future zzb(Context context, zzb zzb1)
    {
        return (new _cls4(context, zzb1)).zzgn();
    }

    private static SharedPreferences zzv(Context context)
    {
        return context.getSharedPreferences("admob", 0);
    }

    // Unreferenced inner class com/google/android/gms/internal/zzhs$zza
    /* block-local class not found */
    class zza {}


    // Unreferenced inner class com/google/android/gms/internal/zzhs$zzb
    /* block-local class not found */
    class zzb {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}

}
