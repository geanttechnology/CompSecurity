// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlr;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzk

public static final class zzOV
{

    private final Object zzOV;
    private final zzlr zzOW;
    private Object zzOX;

    static zzOV zzA(String s, int i)
    {
        return zzo(s, i, i);
    }

    static zzo zzJ(String s, String s1)
    {
        return zzj(s, s1, s1);
    }

    static zzj zzb(String s, long l, long l1)
    {
        return new <init>(zzlr.zza(s, Long.valueOf(l1)), Long.valueOf(l));
    }

    static <init> zzb(String s, boolean flag, boolean flag1)
    {
        return new <init>(zzlr.zzg(s, flag1), Boolean.valueOf(flag));
    }

    static <init> zzf(String s, long l)
    {
        return zzb(s, l, l);
    }

    static zzb zzi(String s, boolean flag)
    {
        return zzb(s, flag, flag);
    }

    static zzb zzj(String s, String s1, String s2)
    {
        return new <init>(zzlr.zzu(s, s2), s1);
    }

    static <init> zzo(String s, int i, int j)
    {
        return new <init>(zzlr.zza(s, Integer.valueOf(j)), Integer.valueOf(i));
    }

    public Object get()
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

    private _cls9(zzlr zzlr1, Object obj)
    {
        zzx.zzw(zzlr1);
        zzOW = zzlr1;
        zzOV = obj;
    }
}
