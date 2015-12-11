// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

class zzac
{

    private final zzmn zzpW;
    private long zzzB;

    public zzac(zzmn zzmn1)
    {
        zzx.zzw(zzmn1);
        zzpW = zzmn1;
    }

    public void clear()
    {
        zzzB = 0L;
    }

    public void start()
    {
        zzzB = zzpW.elapsedRealtime();
    }

    public boolean zzv(long l)
    {
        while (zzzB == 0L || zzpW.elapsedRealtime() - zzzB >= l) 
        {
            return true;
        }
        return false;
    }
}
