// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.result:
//            zzg

public class DataTypeResult
    implements Result, SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzg();
    private final int mVersionCode;
    private final Status zzQA;
    private final DataType zzanl;

    DataTypeResult(int i, Status status, DataType datatype)
    {
        mVersionCode = i;
        zzQA = status;
        zzanl = datatype;
    }

    public DataTypeResult(Status status, DataType datatype)
    {
        mVersionCode = 2;
        zzQA = status;
        zzanl = datatype;
    }

    public static DataTypeResult zzS(Status status)
    {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult datatyperesult)
    {
        return zzQA.equals(datatyperesult.zzQA) && zzw.equal(zzanl, datatyperesult.zzanl);
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof DataTypeResult) && zzb((DataTypeResult)obj);
    }

    public DataType getDataType()
    {
        return zzanl;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzQA, zzanl
        });
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("status", zzQA).zzg("dataType", zzanl).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
