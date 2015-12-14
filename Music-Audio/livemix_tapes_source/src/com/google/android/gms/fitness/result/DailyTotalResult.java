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

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzb

public class DailyTotalResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final Status zzQA;
    private final DataSet zzaoD;

    DailyTotalResult(int i, Status status, DataSet dataset)
    {
        mVersionCode = i;
        zzQA = status;
        zzaoD = dataset;
    }

    public DailyTotalResult(DataSet dataset, Status status)
    {
        mVersionCode = 1;
        zzQA = status;
        zzaoD = dataset;
    }

    public static DailyTotalResult zzQ(Status status)
    {
        return new DailyTotalResult(null, status);
    }

    private boolean zzb(DailyTotalResult dailytotalresult)
    {
        return zzQA.equals(dailytotalresult.zzQA) && zzw.equal(zzaoD, dailytotalresult.zzaoD);
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
        return zzQA;
    }

    public DataSet getTotal()
    {
        return zzaoD;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzQA, zzaoD
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("dataPoint", zzaoD).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.result.zzb.zza(this, parcel, i);
    }

}
