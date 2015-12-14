// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmh;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzd, DataSource, DataType, Value, 
//            Field, RawDataPoint

public final class DataPoint
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzd();
    private final int mVersionCode;
    private long zzanB;
    private long zzanC;
    private final Value zzanD[];
    private DataSource zzanE;
    private long zzanF;
    private long zzanG;
    private final DataSource zzanm;

    DataPoint(int i, DataSource datasource, long l, long l1, Value avalue[], 
            DataSource datasource1, long l2, long l3)
    {
        mVersionCode = i;
        zzanm = datasource;
        zzanE = datasource1;
        zzanB = l;
        zzanC = l1;
        zzanD = avalue;
        zzanF = l2;
        zzanG = l3;
    }

    private DataPoint(DataSource datasource)
    {
        mVersionCode = 4;
        zzanm = (DataSource)zzx.zzb(datasource, "Data source cannot be null");
        datasource = datasource.getDataType().getFields();
        zzanD = new Value[datasource.size()];
        datasource = datasource.iterator();
        for (int i = 0; datasource.hasNext(); i++)
        {
            Field field = (Field)datasource.next();
            zzanD[i] = new Value(field.getFormat());
        }

    }

    public DataPoint(DataSource datasource, DataSource datasource1, RawDataPoint rawdatapoint)
    {
        this(4, datasource, zza(Long.valueOf(rawdatapoint.zzanB), 0L), zza(Long.valueOf(rawdatapoint.zzanC), 0L), rawdatapoint.zzanD, datasource1, zza(Long.valueOf(rawdatapoint.zzanF), 0L), zza(Long.valueOf(rawdatapoint.zzanG), 0L));
    }

    DataPoint(List list, RawDataPoint rawdatapoint)
    {
        this(zza(list, rawdatapoint.zzaow), zza(list, rawdatapoint.zzaox), rawdatapoint);
    }

    public static DataPoint create(DataSource datasource)
    {
        return new DataPoint(datasource);
    }

    public static DataPoint extract(Intent intent)
    {
        if (intent == null)
        {
            return null;
        } else
        {
            return (DataPoint)zzc.zza(intent, "com.google.android.gms.fitness.EXTRA_DATA_POINT", CREATOR);
        }
    }

    private static long zza(Long long1, long l)
    {
        if (long1 != null)
        {
            l = long1.longValue();
        }
        return l;
    }

    private static DataSource zza(List list, int i)
    {
        if (i >= 0 && i < list.size())
        {
            return (DataSource)list.get(i);
        } else
        {
            return null;
        }
    }

    private boolean zza(DataPoint datapoint)
    {
        return zzw.equal(zzanm, datapoint.zzanm) && zzanB == datapoint.zzanB && zzanC == datapoint.zzanC && Arrays.equals(zzanD, datapoint.zzanD) && zzw.equal(zzanE, datapoint.zzanE);
    }

    private void zzen(int i)
    {
        List list = getDataType().getFields();
        int j = list.size();
        boolean flag;
        if (i == j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Attempting to insert %s values, but needed %s: %s", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), list
        });
    }

    private boolean zzrx()
    {
        return getDataType() == DataType.TYPE_LOCATION_SAMPLE;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DataPoint) && zza((DataPoint)obj);
    }

    public DataSource getDataSource()
    {
        return zzanm;
    }

    public DataType getDataType()
    {
        return zzanm.getDataType();
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzanB, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource()
    {
        return zzanE;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzanC, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeunit)
    {
        return timeunit.convert(zzanB, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos()
    {
        return zzanB;
    }

    public Value getValue(Field field)
    {
        int i = getDataType().indexOf(field);
        return zzanD[i];
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm, Long.valueOf(zzanB), Long.valueOf(zzanC)
        });
    }

    public transient DataPoint setFloatValues(float af[])
    {
        zzen(af.length);
        for (int i = 0; i < af.length; i++)
        {
            zzanD[i].setFloat(af[i]);
        }

        return this;
    }

    public transient DataPoint setIntValues(int ai[])
    {
        zzen(ai.length);
        for (int i = 0; i < ai.length; i++)
        {
            zzanD[i].setInt(ai[i]);
        }

        return this;
    }

    public DataPoint setTimeInterval(long l, long l1, TimeUnit timeunit)
    {
        zzanC = timeunit.toNanos(l);
        zzanB = timeunit.toNanos(l1);
        return this;
    }

    public DataPoint setTimestamp(long l, TimeUnit timeunit)
    {
        zzanB = timeunit.toNanos(l);
        if (zzrx() && zzmh.zza(timeunit))
        {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            zzanB = zzmh.zza(zzanB, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString()
    {
        String s1 = Arrays.toString(zzanD);
        long l = zzanC;
        long l1 = zzanB;
        long l2 = zzanF;
        long l3 = zzanG;
        String s2 = zzanm.toDebugString();
        String s;
        if (zzanE != null)
        {
            s = zzanE.toDebugString();
        } else
        {
            s = "N/A";
        }
        return String.format("DataPoint{%s@[%s, %s,raw=%s,insert=%s](%s %s)}", new Object[] {
            s1, Long.valueOf(l), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), s2, s
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    public long zzrA()
    {
        return zzanG;
    }

    public void zzrB()
    {
        DataSource datasource = getDataSource();
        zzx.zzb(getDataType().getName().equals(datasource.getDataType().getName()), "Conflicting data types found %s vs %s", new Object[] {
            getDataType(), getDataType()
        });
        boolean flag;
        if (zzanB > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Data point does not have the timestamp set: %s", new Object[] {
            this
        });
        if (zzanC <= zzanB)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Data point with start time greater than end time found: %s", new Object[] {
            this
        });
    }

    public long zzrC()
    {
        return zzanC;
    }

    public Value[] zzry()
    {
        return zzanD;
    }

    public long zzrz()
    {
        return zzanF;
    }

}
