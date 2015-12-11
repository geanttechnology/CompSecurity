// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


public final class zzo extends Enum
{

    public static final zzo zzNP;
    public static final zzo zzNQ;
    private static final zzo zzNR[];

    private zzo(String s, int i)
    {
        super(s, i);
    }

    public static zzo valueOf(String s)
    {
        return (zzo)Enum.valueOf(com/google/android/gms/analytics/internal/zzo, s);
    }

    public static zzo[] values()
    {
        return (zzo[])zzNR.clone();
    }

    public static zzo zzbk(String s)
    {
        if ("GZIP".equalsIgnoreCase(s))
        {
            return zzNQ;
        } else
        {
            return zzNP;
        }
    }

    static 
    {
        zzNP = new zzo("NONE", 0);
        zzNQ = new zzo("GZIP", 1);
        zzNR = (new zzo[] {
            zzNP, zzNQ
        });
    }
}
