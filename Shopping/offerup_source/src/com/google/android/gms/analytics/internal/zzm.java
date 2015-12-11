// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


public final class zzm extends Enum
{

    public static final zzm zzNF;
    public static final zzm zzNG;
    public static final zzm zzNH;
    public static final zzm zzNI;
    public static final zzm zzNJ;
    public static final zzm zzNK;
    private static final zzm zzNL[];

    private zzm(String s, int i)
    {
        super(s, i);
    }

    public static zzm valueOf(String s)
    {
        return (zzm)Enum.valueOf(com/google/android/gms/analytics/internal/zzm, s);
    }

    public static zzm[] values()
    {
        return (zzm[])zzNL.clone();
    }

    public static zzm zzbj(String s)
    {
        if ("BATCH_BY_SESSION".equalsIgnoreCase(s))
        {
            return zzNG;
        }
        if ("BATCH_BY_TIME".equalsIgnoreCase(s))
        {
            return zzNH;
        }
        if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(s))
        {
            return zzNI;
        }
        if ("BATCH_BY_COUNT".equalsIgnoreCase(s))
        {
            return zzNJ;
        }
        if ("BATCH_BY_SIZE".equalsIgnoreCase(s))
        {
            return zzNK;
        } else
        {
            return zzNF;
        }
    }

    static 
    {
        zzNF = new zzm("NONE", 0);
        zzNG = new zzm("BATCH_BY_SESSION", 1);
        zzNH = new zzm("BATCH_BY_TIME", 2);
        zzNI = new zzm("BATCH_BY_BRUTE_FORCE", 3);
        zzNJ = new zzm("BATCH_BY_COUNT", 4);
        zzNK = new zzm("BATCH_BY_SIZE", 5);
        zzNL = (new zzm[] {
            zzNF, zzNG, zzNH, zzNI, zzNJ, zzNK
        });
    }
}
