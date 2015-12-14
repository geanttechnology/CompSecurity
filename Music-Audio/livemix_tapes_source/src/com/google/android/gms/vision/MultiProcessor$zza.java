// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;


// Referenced classes of package com.google.android.gms.vision:
//            MultiProcessor, Tracker

private class <init>
{

    private Tracker zzaVa;
    private int zzaVp;
    final MultiProcessor zzaVq;

    static Tracker zza(<init> <init>1)
    {
        return <init>1.zzaVa;
    }

    static Tracker zza(zzaVa zzava, Tracker tracker)
    {
        zzava.zzaVa = tracker;
        return tracker;
    }

    static int zzb(zzaVa zzava)
    {
        int i = zzava.zzaVp;
        zzava.zzaVp = i + 1;
        return i;
    }

    static int zzc(zzaVp zzavp)
    {
        return zzavp.zzaVp;
    }

    private (MultiProcessor multiprocessor)
    {
        zzaVq = multiprocessor;
        super();
        zzaVp = 0;
    }

    zzaVp(MultiProcessor multiprocessor, zzaVp zzavp)
    {
        this(multiprocessor);
    }
}
