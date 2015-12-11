// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            Subscription, DataSource, DataType

public static class zzard
{

    private DataType zzapL;
    private DataSource zzapM;
    private long zzarc;
    private int zzard;

    static DataType zza(zzard zzard1)
    {
        return zzard1.zzapL;
    }

    static DataSource zzb(zzapL zzapl)
    {
        return zzapl.zzapM;
    }

    static long zzc(zzapM zzapm)
    {
        return zzapm.zzarc;
    }

    static int zzd(zzarc zzarc1)
    {
        return zzarc1.zzard;
    }

    public zzard zzb(DataSource datasource)
    {
        zzapM = datasource;
        return this;
    }

    public zzapM zzb(DataType datatype)
    {
        zzapL = datatype;
        return this;
    }

    public Subscription zzsD()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (zzapM != null || zzapL != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must call setDataSource() or setDataType()");
            if (zzapL != null && zzapM != null)
            {
                flag = flag1;
                if (!zzapL.equals(zzapM.getDataType()))
                {
                    break label0;
                }
            }
            flag = true;
        }
        zzx.zza(flag, "Specified data type is incompatible with specified data source");
        return new Subscription(this, null);
    }

    public ()
    {
        zzarc = -1L;
        zzard = 2;
    }
}
