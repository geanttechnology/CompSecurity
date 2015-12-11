// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.v4.g.l;
import android.util.Log;

public class zze
{

    private final long zzahV;
    private final int zzahW;
    private final l zzahX;

    public zze()
    {
        zzahV = 60000L;
        zzahW = 10;
        zzahX = new l(10);
    }

    public zze(int i, long l1)
    {
        zzahV = l1;
        zzahW = i;
        zzahX = new l();
    }

    private void zzb(long l1, long l2)
    {
        for (int i = zzahX.size() - 1; i >= 0; i--)
        {
            if (l2 - ((Long)zzahX.c(i)).longValue() > l1)
            {
                zzahX.d(i);
            }
        }

    }

    public Long zzcx(String s)
    {
        long l2 = SystemClock.elapsedRealtime();
        long l1 = zzahV;
        this;
        JVM INSTR monitorenter ;
        for (; zzahX.size() >= zzahW; Log.w("ConnectionTracker", (new StringBuilder("The max capacity ")).append(zzahW).append(" is not enough. Current durationThreshold is: ").append(l1).toString()))
        {
            zzb(l1, l2);
            l1 /= 2L;
        }

        break MISSING_BLOCK_LABEL_81;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        s = (Long)zzahX.put(s, Long.valueOf(l2));
        this;
        JVM INSTR monitorexit ;
        return s;
    }

    public boolean zzcy(String s)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        if (zzahX.remove(s) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        this;
        JVM INSTR monitorexit ;
        return flag;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }
}
