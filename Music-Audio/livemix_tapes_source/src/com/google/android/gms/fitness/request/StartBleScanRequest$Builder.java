// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            StartBleScanRequest, zzn, BleScanCallback

public static class zzaqC
{

    private DataType zzapZ[];
    private zzn zzaqB;
    private int zzaqC;

    static DataType[] zza(zzaqC zzaqc)
    {
        return zzaqc.zzapZ;
    }

    static zzn zzb(zzapZ zzapz)
    {
        return zzapz.zzaqB;
    }

    static int zzc(zzaqB zzaqb)
    {
        return zzaqb.zzaqC;
    }

    public StartBleScanRequest build()
    {
        boolean flag;
        if (zzaqB != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must set BleScanCallback");
        return new StartBleScanRequest(this, null);
    }

    public zzaqB setBleScanCallback(BleScanCallback blescancallback)
    {
        zza(zza().zza(blescancallback));
        return this;
    }

    public transient zza setDataTypes(DataType adatatype[])
    {
        zzapZ = adatatype;
        return this;
    }

    public zzapZ setTimeoutSecs(int i)
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
        zzaqC = i;
        return this;
    }

    public zzaqC zza(zzn zzn)
    {
        zzaqB = zzn;
        return this;
    }

    public ()
    {
        zzapZ = new DataType[0];
        zzaqC = 10;
    }
}
