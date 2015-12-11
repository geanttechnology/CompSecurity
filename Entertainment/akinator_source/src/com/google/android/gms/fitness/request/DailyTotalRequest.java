// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznt;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzc

public class DailyTotalRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private DataType zzapL;
    private final zznt zzasc;

    DailyTotalRequest(int i, IBinder ibinder, DataType datatype)
    {
        mVersionCode = i;
        zzasc = com.google.android.gms.internal.zznt.zza.zzbt(ibinder);
        zzapL = datatype;
    }

    public DailyTotalRequest(zznt zznt1, DataType datatype)
    {
        mVersionCode = 2;
        zzasc = zznt1;
        zzapL = datatype;
    }

    public int describeContents()
    {
        return 0;
    }

    public DataType getDataType()
    {
        return zzapL;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return String.format("DailyTotalRequest{%s}", new Object[] {
            zzapL.zzst()
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        return zzasc.asBinder();
    }

}
