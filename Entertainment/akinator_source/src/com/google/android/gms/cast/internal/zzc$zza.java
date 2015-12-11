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

    final zzc zzYB;

    public void run()
    {
        zzYB.zzYA = false;
        long l = SystemClock.elapsedRealtime();
        boolean flag = zzYB.zzz(l);
        zzYB.zzV(flag);
    }

    private (zzc zzc1)
    {
        zzYB = zzc1;
        super();
    }

    zzYB(zzc zzc1, zzYB zzyb)
    {
        this(zzc1);
    }
}
