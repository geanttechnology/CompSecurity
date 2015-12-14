// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.fitness.data:
//            Subscription, DataSource, DataType

public static class zzaoF
{

    private DataType zzanl;
    private DataSource zzanm;
    private long zzaoE;
    private int zzaoF;

    static DataType zza(zzaoF zzaof)
    {
        return zzaof.zzanl;
    }

    static DataSource zzb(zzanl zzanl1)
    {
        return zzanl1.zzanm;
    }

    static long zzc(zzanm zzanm1)
    {
        return zzanm1.zzaoE;
    }

    static int zzd(zzaoE zzaoe)
    {
        return zzaoe.zzaoF;
    }

    public zzaoF zzb(DataSource datasource)
    {
        zzanm = datasource;
        return this;
    }

    public zzanm zzb(DataType datatype)
    {
        zzanl = datatype;
        return this;
    }

    public Subscription zzrR()
    {
label0:
        {
            boolean flag1 = false;
            boolean flag;
            if (zzanm != null || zzanl != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            zzx.zza(flag, "Must call setDataSource() or setDataType()");
            if (zzanl != null && zzanm != null)
            {
                flag = flag1;
                if (!zzanl.equals(zzanm.getDataType()))
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
        zzaoE = -1L;
        zzaoF = 2;
    }
}
