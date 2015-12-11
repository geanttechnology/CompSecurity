// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

public final class zzOV
{

    private final Object zzOV;
    private final zzlr zzOW;
    private Object zzOX;

    static zzOV zza(String s, float f)
    {
        return zza(s, f, f);
    }

    static zza zza(String s, float f, float f1)
    {
        return new <init>(zzlr.zza(s, Float.valueOf(f1)), Float.valueOf(f));
    }

    static <init> zza(String s, int i, int j)
    {
        return new <init>(zzlr.zza(s, Integer.valueOf(j)), Integer.valueOf(i));
    }

    static <init> zza(String s, long l, long l1)
    {
        return new <init>(zzlr.zza(s, Long.valueOf(l1)), Long.valueOf(l));
    }

    static <init> zza(String s, boolean flag, boolean flag1)
    {
        return new <init>(zzlr.zzg(s, flag1), Boolean.valueOf(flag));
    }

    static <init> zzc(String s, long l)
    {
        return zza(s, l, l);
    }

    static zza zzd(String s, String s1, String s2)
    {
        return new <init>(zzlr.zzu(s, s2), s1);
    }

    static <init> zzd(String s, boolean flag)
    {
        return zza(s, flag, flag);
    }

    static zza zze(String s, int i)
    {
        return zza(s, i, i);
    }

    static zza zzn(String s, String s1)
    {
        return zzd(s, s1, s1);
    }

    public final Object get()
    {
        if (zzOX != null)
        {
            return zzOX;
        }
        if (zzd.zzaeK && zzlr.isInitialized())
        {
            return zzOW.zzop();
        } else
        {
            return zzOV;
        }
    }

    private (zzlr zzlr1, Object obj)
    {
        zzx.zzw(zzlr1);
        zzOW = zzlr1;
        zzOV = obj;
    }
}
