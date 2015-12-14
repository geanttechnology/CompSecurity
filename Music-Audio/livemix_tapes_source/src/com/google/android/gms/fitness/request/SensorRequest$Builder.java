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

public static class zzaqr
{

    private DataType zzanl;
    private DataSource zzanm;
    private long zzaoE;
    private int zzaoF;
    private long zzaql;
    private long zzaqm;
    private long zzaqr;
    private boolean zzaqs;

    static DataSource zza(zzaqr zzaqr1)
    {
        return zzaqr1.zzanm;
    }

    static DataType zzb(zzanm zzanm1)
    {
        return zzanm1.zzanl;
    }

    static long zzc(zzanl zzanl1)
    {
        return zzanl1.zzaoE;
    }

    static long zzd(zzaoE zzaoe)
    {
        return zzaoe.zzaqm;
    }

    static long zze(zzaqm zzaqm1)
    {
        return zzaqm1.zzaql;
    }

    static int zzf(zzaql zzaql1)
    {
        return zzaql1.zzaoF;
    }

    static long zzg(zzaoF zzaof)
    {
        return zzaof.zzaqr;
    }

    public SensorRequest build()
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
        return new SensorRequest(this, null);
    }

    public zzanm setAccuracyMode(int i)
    {
        zzaoF = SensorRequest.zzeW(i);
        return this;
    }

    public zzaoF setDataSource(DataSource datasource)
    {
        zzanm = datasource;
        return this;
    }

    public zzanm setDataType(DataType datatype)
    {
        zzanl = datatype;
        return this;
    }

    public zzanl setFastestRate(int i, TimeUnit timeunit)
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
        zzaqs = true;
        zzaqm = timeunit.toMicros(i);
        return this;
    }

    public zzaqm setMaxDeliveryLatency(int i, TimeUnit timeunit)
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
        zzaql = timeunit.toMicros(i);
        return this;
    }

    public zzaql setSamplingRate(long l, TimeUnit timeunit)
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
        zzaoE = timeunit.toMicros(l);
        if (!zzaqs)
        {
            zzaqm = zzaoE / 2L;
        }
        return this;
    }

    public zzaoE setTimeout(long l, TimeUnit timeunit)
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
        zzaqr = timeunit.toMicros(l);
        return this;
    }

    public ()
    {
        zzaoE = -1L;
        zzaqm = 0L;
        zzaql = 0L;
        zzaqs = false;
        zzaoF = 2;
        zzaqr = 0x7fffffffffffffffL;
    }
}
