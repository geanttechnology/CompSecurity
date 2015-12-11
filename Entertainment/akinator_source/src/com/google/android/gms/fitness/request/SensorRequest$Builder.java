// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SensorRequest

public static class zzasO
{

    private DataType zzapL;
    private DataSource zzapM;
    private long zzarc;
    private int zzard;
    private long zzasI;
    private long zzasJ;
    private long zzasO;
    private boolean zzasP;

    static DataSource zza(zzasO zzaso)
    {
        return zzaso.zzapM;
    }

    static DataType zzb(zzapM zzapm)
    {
        return zzapm.zzapL;
    }

    static long zzc(zzapL zzapl)
    {
        return zzapl.zzarc;
    }

    static long zzd(zzarc zzarc1)
    {
        return zzarc1.zzasJ;
    }

    static long zze(zzasJ zzasj)
    {
        return zzasj.zzasI;
    }

    static int zzf(zzasI zzasi)
    {
        return zzasi.zzard;
    }

    static long zzg(zzard zzard1)
    {
        return zzard1.zzasO;
    }

    public SensorRequest build()
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
        return new SensorRequest(this, null);
    }

    public zzapM setAccuracyMode(int i)
    {
        zzard = SensorRequest.zzff(i);
        return this;
    }

    public zzard setDataSource(DataSource datasource)
    {
        zzapM = datasource;
        return this;
    }

    public zzapM setDataType(DataType datatype)
    {
        zzapL = datatype;
        return this;
    }

    public zzapL setFastestRate(int i, TimeUnit timeunit)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Cannot use a negative interval");
        zzasP = true;
        zzasJ = timeunit.toMicros(i);
        return this;
    }

    public zzasJ setMaxDeliveryLatency(int i, TimeUnit timeunit)
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Cannot use a negative delivery interval");
        zzasI = timeunit.toMicros(i);
        return this;
    }

    public zzasI setSamplingRate(long l, TimeUnit timeunit)
    {
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Cannot use a negative sampling interval");
        zzarc = timeunit.toMicros(l);
        if (!zzasP)
        {
            zzasJ = zzarc / 2L;
        }
        return this;
    }

    public zzarc setTimeout(long l, TimeUnit timeunit)
    {
        boolean flag1 = true;
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid time out value specified: %d", new Object[] {
            Long.valueOf(l)
        });
        if (timeunit != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Invalid time unit specified");
        zzasO = timeunit.toMicros(l);
        return this;
    }

    public ()
    {
        zzarc = -1L;
        zzasJ = 0L;
        zzasI = 0L;
        zzasP = false;
        zzard = 2;
        zzasO = 0x7fffffffffffffffL;
    }
}
