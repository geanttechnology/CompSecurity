// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataSourcesRequest

public static class zzasu
{

    private boolean zzasu;
    private DataType zzasw[];
    private int zzasx[] = {
        0, 1
    };

    static DataType[] zza(zzasu zzasu1)
    {
        return zzasu1.zzasw;
    }

    static int[] zzb(zzasw zzasw1)
    {
        return zzasw1.zzasx;
    }

    static boolean zzc(zzasx zzasx1)
    {
        return zzasx1.zzasu;
    }

    public DataSourcesRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (zzasw.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must add at least one data type");
        if (zzasx.length > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must add at least one data source type");
        return new DataSourcesRequest(this, null);
    }

    public transient zzasx setDataSourceTypes(int ai[])
    {
        zzasx = ai;
        return this;
    }

    public transient zzasx setDataTypes(DataType adatatype[])
    {
        zzasw = adatatype;
        return this;
    }

    public ()
    {
        zzasw = new DataType[0];
        zzasu = false;
    }
}
