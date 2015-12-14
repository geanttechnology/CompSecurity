// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
    public static class Builder
    {

        private DataType zzanl;
        private DataSource zzanm;
        private long zzaoE;
        private int zzaoF;
        private long zzaql;
        private long zzaqm;
        private long zzaqr;
        private boolean zzaqs;

        static DataSource zza(Builder builder)
        {
            return builder.zzanm;
        }

        static DataType zzb(Builder builder)
        {
            return builder.zzanl;
        }

        static long zzc(Builder builder)
        {
            return builder.zzaoE;
        }

        static long zzd(Builder builder)
        {
            return builder.zzaqm;
        }

        static long zze(Builder builder)
        {
            return builder.zzaql;
        }

        static int zzf(Builder builder)
        {
            return builder.zzaoF;
        }

        static long zzg(Builder builder)
        {
            return builder.zzaqr;
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
            return new SensorRequest(this);
        }

        public Builder setAccuracyMode(int i)
        {
            zzaoF = SensorRequest.zzeW(i);
            return this;
        }

        public Builder setDataSource(DataSource datasource)
        {
            zzanm = datasource;
            return this;
        }

        public Builder setDataType(DataType datatype)
        {
            zzanl = datatype;
            return this;
        }

        public Builder setFastestRate(int i, TimeUnit timeunit)
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

        public Builder setMaxDeliveryLatency(int i, TimeUnit timeunit)
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

        public Builder setSamplingRate(long l, TimeUnit timeunit)
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

        public Builder setTimeout(long l, TimeUnit timeunit)
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

        public Builder()
        {
            zzaoE = -1L;
            zzaqm = 0L;
            zzaql = 0L;
            zzaqs = false;
            zzaoF = 2;
            zzaqr = 0x7fffffffffffffffL;
        }
    }


    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType zzanl;
    private final DataSource zzanm;
    private final long zzaoE;
    private final int zzaoF;
    private final long zzaql;
    private final long zzaqm;
    private final LocationRequest zzaqq;
    private final long zzaqr;

    private SensorRequest(DataSource datasource, LocationRequest locationrequest)
    {
        zzaqq = locationrequest;
        zzaoE = TimeUnit.MILLISECONDS.toMicros(locationrequest.getInterval());
        zzaqm = TimeUnit.MILLISECONDS.toMicros(locationrequest.getFastestInterval());
        zzaql = zzaoE;
        zzanl = datasource.getDataType();
        zzaoF = zza(locationrequest);
        zzanm = datasource;
        long l = locationrequest.getExpirationTime();
        if (l == 0x7fffffffffffffffL)
        {
            zzaqr = 0x7fffffffffffffffL;
            return;
        } else
        {
            zzaqr = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
            return;
        }
    }

    private SensorRequest(Builder builder)
    {
        zzanm = Builder.zza(builder);
        zzanl = Builder.zzb(builder);
        zzaoE = Builder.zzc(builder);
        zzaqm = Builder.zzd(builder);
        zzaql = Builder.zze(builder);
        zzaoF = Builder.zzf(builder);
        zzaqq = null;
        zzaqr = Builder.zzg(builder);
    }


    public static SensorRequest fromLocationRequest(DataSource datasource, LocationRequest locationrequest)
    {
        return new SensorRequest(datasource, locationrequest);
    }

    private static int zza(LocationRequest locationrequest)
    {
        switch (locationrequest.getPriority())
        {
        default:
            return 2;

        case 100: // 'd'
            return 3;

        case 104: // 'h'
            return 1;
        }
    }

    private boolean zza(SensorRequest sensorrequest)
    {
        return zzw.equal(zzanm, sensorrequest.zzanm) && zzw.equal(zzanl, sensorrequest.zzanl) && zzaoE == sensorrequest.zzaoE && zzaqm == sensorrequest.zzaqm && zzaql == sensorrequest.zzaql && zzaoF == sensorrequest.zzaoF && zzw.equal(zzaqq, sensorrequest.zzaqq) && zzaqr == sensorrequest.zzaqr;
    }

    public static int zzeW(int i)
    {
        int j = i;
        switch (i)
        {
        case 2: // '\002'
        default:
            j = 2;
            // fall through

        case 1: // '\001'
        case 3: // '\003'
            return j;
        }
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof SensorRequest) && zza((SensorRequest)obj);
    }

    public int getAccuracyMode()
    {
        return zzaoF;
    }

    public DataSource getDataSource()
    {
        return zzanm;
    }

    public DataType getDataType()
    {
        return zzanl;
    }

    public long getFastestRate(TimeUnit timeunit)
    {
        return timeunit.convert(zzaqm, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeunit)
    {
        return timeunit.convert(zzaql, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeunit)
    {
        return timeunit.convert(zzaoE, TimeUnit.MICROSECONDS);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm, zzanl, Long.valueOf(zzaoE), Long.valueOf(zzaqm), Long.valueOf(zzaql), Integer.valueOf(zzaoF), zzaqq, Long.valueOf(zzaqr)
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("dataSource", zzanm).zzg("dataType", zzanl).zzg("samplingRateMicros", Long.valueOf(zzaoE)).zzg("deliveryLatencyMicros", Long.valueOf(zzaql)).zzg("timeOutMicros", Long.valueOf(zzaqr)).toString();
    }

    public long zzsu()
    {
        return zzaqr;
    }
}
