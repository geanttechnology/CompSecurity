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
import com.google.android.gms.internal.zznj;
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
    private final DataSource zzapM;
    private long zzaqb;
    private long zzaqc;
    private final Value zzaqd[];
    private DataSource zzaqe;
    private long zzaqf;
    private long zzaqg;

    DataPoint(int i, DataSource datasource, long l, long l1, Value avalue[], 
            DataSource datasource1, long l2, long l3)
    {
        mVersionCode = i;
        zzapM = datasource;
        zzaqe = datasource1;
        zzaqb = l;
        zzaqc = l1;
        zzaqd = avalue;
        zzaqf = l2;
        zzaqg = l3;
    }

    private DataPoint(DataSource datasource)
    {
        mVersionCode = 4;
        zzapM = (DataSource)zzx.zzb(datasource, "Data source cannot be null");
        datasource = datasource.getDataType().getFields();
        zzaqd = new Value[datasource.size()];
        datasource = datasource.iterator();
        for (int i = 0; datasource.hasNext(); i++)
        {
            Field field = (Field)datasource.next();
            zzaqd[i] = new Value(field.getFormat());
        }

    }

    public DataPoint(DataSource datasource, DataSource datasource1, RawDataPoint rawdatapoint)
    {
        this(4, datasource, zza(Long.valueOf(rawdatapoint.zzaqb), 0L), zza(Long.valueOf(rawdatapoint.zzaqc), 0L), rawdatapoint.zzaqd, datasource1, zza(Long.valueOf(rawdatapoint.zzaqf), 0L), zza(Long.valueOf(rawdatapoint.zzaqg), 0L));
    }

    DataPoint(List list, RawDataPoint rawdatapoint)
    {
        this(zza(list, rawdatapoint.zzaqU), zza(list, rawdatapoint.zzaqV), rawdatapoint);
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
        return zzw.equal(zzapM, datapoint.zzapM) && zzaqb == datapoint.zzaqb && zzaqc == datapoint.zzaqc && Arrays.equals(zzaqd, datapoint.zzaqd) && zzw.equal(zzaqe, datapoint.zzaqe);
    }

    private void zzew(int i)
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

    private boolean zzsj()
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
        return zzapM;
    }

    public DataType getDataType()
    {
        return zzapM.getDataType();
    }

    public long getEndTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzaqb, TimeUnit.NANOSECONDS);
    }

    public DataSource getOriginalDataSource()
    {
        return zzaqe;
    }

    public long getStartTime(TimeUnit timeunit)
    {
        return timeunit.convert(zzaqc, TimeUnit.NANOSECONDS);
    }

    public long getTimestamp(TimeUnit timeunit)
    {
        return timeunit.convert(zzaqb, TimeUnit.NANOSECONDS);
    }

    public long getTimestampNanos()
    {
        return zzaqb;
    }

    public Value getValue(Field field)
    {
        int i = getDataType().indexOf(field);
        return zzaqd[i];
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapM, Long.valueOf(zzaqb), Long.valueOf(zzaqc)
        });
    }

    public transient DataPoint setFloatValues(float af[])
    {
        zzew(af.length);
        for (int i = 0; i < af.length; i++)
        {
            zzaqd[i].setFloat(af[i]);
        }

        return this;
    }

    public transient DataPoint setIntValues(int ai[])
    {
        zzew(ai.length);
        for (int i = 0; i < ai.length; i++)
        {
            zzaqd[i].setInt(ai[i]);
        }

        return this;
    }

    public DataPoint setTimeInterval(long l, long l1, TimeUnit timeunit)
    {
        zzaqc = timeunit.toNanos(l);
        zzaqb = timeunit.toNanos(l1);
        return this;
    }

    public DataPoint setTimestamp(long l, TimeUnit timeunit)
    {
        zzaqb = timeunit.toNanos(l);
        if (zzsj() && zznj.zza(timeunit))
        {
            Log.w("Fitness", "Storing location at more than millisecond granularity is not supported. Extra precision is lost as the value is converted to milliseconds.");
            zzaqb = zznj.zza(zzaqb, TimeUnit.NANOSECONDS, TimeUnit.MILLISECONDS);
        }
        return this;
    }

    public String toString()
    {
        String s1 = Arrays.toString(zzaqd);
        long l = zzaqc;
        long l1 = zzaqb;
        long l2 = zzaqf;
        long l3 = zzaqg;
        String s2 = zzapM.toDebugString();
        String s;
        if (zzaqe != null)
        {
            s = zzaqe.toDebugString();
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

    public Value[] zzsk()
    {
        return zzaqd;
    }

    public long zzsl()
    {
        return zzaqf;
    }

    public long zzsm()
    {
        return zzaqg;
    }

    public void zzsn()
    {
        DataSource datasource = getDataSource();
        zzx.zzb(getDataType().getName().equals(datasource.getDataType().getName()), "Conflicting data types found %s vs %s", new Object[] {
            getDataType(), getDataType()
        });
        boolean flag;
        if (zzaqb > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "Data point does not have the timestamp set: %s", new Object[] {
            this
        });
        if (zzaqc <= zzaqb)
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

    public long zzso()
    {
        return zzaqc;
    }

}
