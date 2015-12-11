// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.data:
//            zzn, DataPoint, zzs, Value

public final class RawDataPoint
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    public final int zzaqU;
    public final int zzaqV;
    public final long zzaqb;
    public final long zzaqc;
    public final Value zzaqd[];
    public final long zzaqf;
    public final long zzaqg;

    public RawDataPoint(int i, long l, long l1, Value avalue[], int j, 
            int k, long l2, long l3)
    {
        mVersionCode = i;
        zzaqb = l;
        zzaqc = l1;
        zzaqU = j;
        zzaqV = k;
        zzaqf = l2;
        zzaqg = l3;
        zzaqd = avalue;
    }

    RawDataPoint(DataPoint datapoint, List list)
    {
        mVersionCode = 4;
        zzaqb = datapoint.getTimestamp(TimeUnit.NANOSECONDS);
        zzaqc = datapoint.getStartTime(TimeUnit.NANOSECONDS);
        zzaqd = datapoint.zzsk();
        zzaqU = zzs.zza(datapoint.getDataSource(), list);
        zzaqV = zzs.zza(datapoint.getOriginalDataSource(), list);
        zzaqf = datapoint.zzsl();
        zzaqg = datapoint.zzsm();
    }

    private boolean zza(RawDataPoint rawdatapoint)
    {
        return zzaqb == rawdatapoint.zzaqb && zzaqc == rawdatapoint.zzaqc && Arrays.equals(zzaqd, rawdatapoint.zzaqd) && zzaqU == rawdatapoint.zzaqU && zzaqV == rawdatapoint.zzaqV && zzaqf == rawdatapoint.zzaqf;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof RawDataPoint) && zza((RawDataPoint)obj);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(zzaqb), Long.valueOf(zzaqc)
        });
    }

    public String toString()
    {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] {
            Arrays.toString(zzaqd), Long.valueOf(zzaqc), Long.valueOf(zzaqb), Integer.valueOf(zzaqU), Integer.valueOf(zzaqV)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

}
