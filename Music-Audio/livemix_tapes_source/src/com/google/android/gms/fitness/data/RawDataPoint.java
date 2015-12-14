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
    public final long zzanB;
    public final long zzanC;
    public final Value zzanD[];
    public final long zzanF;
    public final long zzanG;
    public final int zzaow;
    public final int zzaox;

    public RawDataPoint(int i, long l, long l1, Value avalue[], int j, 
            int k, long l2, long l3)
    {
        mVersionCode = i;
        zzanB = l;
        zzanC = l1;
        zzaow = j;
        zzaox = k;
        zzanF = l2;
        zzanG = l3;
        zzanD = avalue;
    }

    RawDataPoint(DataPoint datapoint, List list)
    {
        mVersionCode = 4;
        zzanB = datapoint.getTimestamp(TimeUnit.NANOSECONDS);
        zzanC = datapoint.getStartTime(TimeUnit.NANOSECONDS);
        zzanD = datapoint.zzry();
        zzaow = zzs.zza(datapoint.getDataSource(), list);
        zzaox = zzs.zza(datapoint.getOriginalDataSource(), list);
        zzanF = datapoint.zzrz();
        zzanG = datapoint.zzrA();
    }

    private boolean zza(RawDataPoint rawdatapoint)
    {
        return zzanB == rawdatapoint.zzanB && zzanC == rawdatapoint.zzanC && Arrays.equals(zzanD, rawdatapoint.zzanD) && zzaow == rawdatapoint.zzaow && zzaox == rawdatapoint.zzaox && zzanF == rawdatapoint.zzanF;
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
            Long.valueOf(zzanB), Long.valueOf(zzanC)
        });
    }

    public String toString()
    {
        return String.format("RawDataPoint{%s@[%s, %s](%d,%d)}", new Object[] {
            Arrays.toString(zzanD), Long.valueOf(zzanC), Long.valueOf(zzanB), Integer.valueOf(zzaow), Integer.valueOf(zzaox)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

}
