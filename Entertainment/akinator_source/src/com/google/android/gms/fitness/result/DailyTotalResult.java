// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzb

public class DailyTotalResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final Status zzSC;
    private final DataSet zzarb;

    DailyTotalResult(int i, Status status, DataSet dataset)
    {
        mVersionCode = i;
        zzSC = status;
        zzarb = dataset;
    }

    public DailyTotalResult(DataSet dataset, Status status)
    {
        mVersionCode = 1;
        zzSC = status;
        zzarb = dataset;
    }

    public static DailyTotalResult zza(Status status, DataType datatype)
    {
        return new DailyTotalResult(DataSet.create((new com.google.android.gms.fitness.data.DataSource.Builder()).setDataType(datatype).setType(1).build()), status);
    }

    private boolean zzb(DailyTotalResult dailytotalresult)
    {
        return zzSC.equals(dailytotalresult.zzSC) && zzw.equal(zzarb, dailytotalresult.zzarb);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DailyTotalResult) && zzb((DailyTotalResult)obj);
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public DataSet getTotal()
    {
        return zzarb;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzSC, zzarb
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("dataPoint", zzarb).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.result.zzb.zza(this, parcel, i);
    }

}
