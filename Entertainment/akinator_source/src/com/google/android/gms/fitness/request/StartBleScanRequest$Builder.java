// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            StartBleScanRequest, zzn, BleScanCallback

public static class zzasZ
{

    private zzn zzasY;
    private int zzasZ;
    private DataType zzasw[];

    static DataType[] zza(zzasZ zzasz)
    {
        return zzasz.zzasw;
    }

    static zzn zzb(zzasw zzasw1)
    {
        return zzasw1.zzasY;
    }

    static int zzc(zzasY zzasy)
    {
        return zzasy.zzasZ;
    }

    public StartBleScanRequest build()
    {
        boolean flag;
        if (zzasY != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set BleScanCallback");
        return new StartBleScanRequest(this, null);
    }

    public zzasY setBleScanCallback(BleScanCallback blescancallback)
    {
        zza(zza().zza(blescancallback));
        return this;
    }

    public transient zza setDataTypes(DataType adatatype[])
    {
        zzasw = adatatype;
        return this;
    }

    public zzasw setTimeoutSecs(int i)
    {
        boolean flag1 = true;
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Stop time must be greater than zero");
        if (i <= 60)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Stop time must be less than 1 minute");
        zzasZ = i;
        return this;
    }

    public zzasZ zza(zzn zzn)
    {
        zzasY = zzn;
        return this;
    }

    public ()
    {
        zzasw = new DataType[0];
        zzasZ = 10;
    }
}
