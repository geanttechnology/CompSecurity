// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast.internal;

import android.os.SystemClock;

// Referenced classes of package com.google.android.gms.cast.internal:
//            zzc

private class <init>
    implements Runnable
{

    final zzc zzWJ;

    public void run()
    {
        zzWJ.zzWI = false;
        long l = SystemClock.elapsedRealtime();
        boolean flag = zzWJ.zzz(l);
        zzWJ.zzU(flag);
    }

    private (zzc zzc1)
    {
        zzWJ = zzc1;
        super();
    }

    zzWJ(zzc zzc1, zzWJ zzwj)
    {
        this(zzc1);
    }
}
