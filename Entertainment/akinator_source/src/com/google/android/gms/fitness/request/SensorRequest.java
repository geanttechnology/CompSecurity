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

        private DataType zzapL;
        private DataSource zzapM;
        private long zzarc;
        private int zzard;
        private long zzasI;
        private long zzasJ;
        private long zzasO;
        private boolean zzasP;

        static DataSource zza(Builder builder)
        {
            return builder.zzapM;
        }

        static DataType zzb(Builder builder)
        {
            return builder.zzapL;
        }

        static long zzc(Builder builder)
        {
            return builder.zzarc;
        }

        static long zzd(Builder builder)
        {
            return builder.zzasJ;
        }

        static long zze(Builder builder)
        {
            return builder.zzasI;
        }

        static int zzf(Builder builder)
        {
            return builder.zzard;
        }

        static long zzg(Builder builder)
        {
            return builder.zzasO;
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
            return new SensorRequest(this);
        }

        public Builder setAccuracyMode(int i)
        {
            zzard = SensorRequest.zzff(i);
            return this;
        }

        public Builder setDataSource(DataSource datasource)
        {
            zzapM = datasource;
            return this;
        }

        public Builder setDataType(DataType datatype)
        {
            zzapL = datatype;
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
            zzasP = true;
            zzasJ = timeunit.toMicros(i);
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
            zzasI = timeunit.toMicros(i);
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
            zzarc = timeunit.toMicros(l);
            if (!zzasP)
            {
                zzasJ = zzarc / 2L;
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
            zzasO = timeunit.toMicros(l);
            return this;
        }

        public Builder()
        {
            zzarc = -1L;
            zzasJ = 0L;
            zzasI = 0L;
            zzasP = false;
            zzard = 2;
            zzasO = 0x7fffffffffffffffL;
        }
    }


    public static final int ACCURACY_MODE_DEFAULT = 2;
    public static final int ACCURACY_MODE_HIGH = 3;
    public static final int ACCURACY_MODE_LOW = 1;
    private final DataType zzapL;
    private final DataSource zzapM;
    private final long zzarc;
    private final int zzard;
    private final long zzasI;
    private final long zzasJ;
    private final LocationRequest zzasN;
    private final long zzasO;

    private SensorRequest(DataSource datasource, LocationRequest locationrequest)
    {
        zzasN = locationrequest;
        zzarc = TimeUnit.MILLISECONDS.toMicros(locationrequest.getInterval());
        zzasJ = TimeUnit.MILLISECONDS.toMicros(locationrequest.getFastestInterval());
        zzasI = zzarc;
        zzapL = datasource.getDataType();
        zzard = zza(locationrequest);
        zzapM = datasource;
        long l = locationrequest.getExpirationTime();
        if (l == 0x7fffffffffffffffL)
        {
            zzasO = 0x7fffffffffffffffL;
            return;
        } else
        {
            zzasO = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
            return;
        }
    }

    private SensorRequest(Builder builder)
    {
        zzapM = Builder.zza(builder);
        zzapL = Builder.zzb(builder);
        zzarc = Builder.zzc(builder);
        zzasJ = Builder.zzd(builder);
        zzasI = Builder.zze(builder);
        zzard = Builder.zzf(builder);
        zzasN = null;
        zzasO = Builder.zzg(builder);
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
        return zzw.equal(zzapM, sensorrequest.zzapM) && zzw.equal(zzapL, sensorrequest.zzapL) && zzarc == sensorrequest.zzarc && zzasJ == sensorrequest.zzasJ && zzasI == sensorrequest.zzasI && zzard == sensorrequest.zzard && zzw.equal(zzasN, sensorrequest.zzasN) && zzasO == sensorrequest.zzasO;
    }

    public static int zzff(int i)
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
        return zzard;
    }

    public DataSource getDataSource()
    {
        return zzapM;
    }

    public DataType getDataType()
    {
        return zzapL;
    }

    public long getFastestRate(TimeUnit timeunit)
    {
        return timeunit.convert(zzasJ, TimeUnit.MICROSECONDS);
    }

    public long getMaxDeliveryLatency(TimeUnit timeunit)
    {
        return timeunit.convert(zzasI, TimeUnit.MICROSECONDS);
    }

    public long getSamplingRate(TimeUnit timeunit)
    {
        return timeunit.convert(zzarc, TimeUnit.MICROSECONDS);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapM, zzapL, Long.valueOf(zzarc), Long.valueOf(zzasJ), Long.valueOf(zzasI), Integer.valueOf(zzard), zzasN, Long.valueOf(zzasO)
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("dataSource", zzapM).zzg("dataType", zzapL).zzg("samplingRateMicros", Long.valueOf(zzarc)).zzg("deliveryLatencyMicros", Long.valueOf(zzasI)).zzg("timeOutMicros", Long.valueOf(zzasO)).toString();
    }

    public long zztg()
    {
        return zzasO;
    }
}
