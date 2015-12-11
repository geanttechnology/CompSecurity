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
    private final Status zzSC;
    private final DataType zzapL;

    DataTypeResult(int i, Status status, DataType datatype)
    {
        mVersionCode = i;
        zzSC = status;
        zzapL = datatype;
    }

    public DataTypeResult(Status status, DataType datatype)
    {
        mVersionCode = 2;
        zzSC = status;
        zzapL = datatype;
    }

    public static DataTypeResult zzR(Status status)
    {
        return new DataTypeResult(status, null);
    }

    private boolean zzb(DataTypeResult datatyperesult)
    {
        return zzSC.equals(datatyperesult.zzSC) && zzw.equal(zzapL, datatyperesult.zzapL);
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
        return zzapL;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzSC, zzapL
        });
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("status", zzSC).zzg("dataType", zzapL).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg.zza(this, parcel, i);
    }

}
