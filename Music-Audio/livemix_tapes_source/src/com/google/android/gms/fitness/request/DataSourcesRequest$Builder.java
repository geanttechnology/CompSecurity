// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataSourcesRequest

public static class zzapX
{

    private boolean zzapX;
    private DataType zzapZ[];
    private int zzaqa[] = {
        0, 1
    };

    static DataType[] zza(zzapX zzapx)
    {
        return zzapx.zzapZ;
    }

    static int[] zzb(zzapZ zzapz)
    {
        return zzapz.zzaqa;
    }

    static boolean zzc(zzaqa zzaqa1)
    {
        return zzaqa1.zzapX;
    }

    public DataSourcesRequest build()
    {
        boolean flag1 = true;
        boolean flag;
        if (zzapZ.length > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must add at least one data type");
        if (zzaqa.length > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "Must add at least one data source type");
        return new DataSourcesRequest(this, null);
    }

    public transient zzaqa setDataSourceTypes(int ai[])
    {
        zzaqa = ai;
        return this;
    }

    public transient zzaqa setDataTypes(DataType adatatype[])
    {
        zzapZ = adatatype;
        return this;
    }

    public ()
    {
        zzapZ = new DataType[0];
        zzapX = false;
    }
}
