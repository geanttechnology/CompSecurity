// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzmr;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzc

public class DailyTotalRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzc();
    private final int mVersionCode;
    private final String zzOZ;
    private final DataType zzanl;
    private final zzmr zzapF;

    DailyTotalRequest(int i, IBinder ibinder, DataType datatype, String s)
    {
        mVersionCode = i;
        zzapF = com.google.android.gms.internal.zzmr.zza.zzbt(ibinder);
        zzanl = datatype;
        zzOZ = s;
    }

    public DailyTotalRequest(zzmr zzmr1, DataType datatype, String s)
    {
        mVersionCode = 1;
        zzapF = zzmr1;
        zzanl = datatype;
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public DataType getDataType()
    {
        return zzanl;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return String.format("DailyTotalRequest{%s}", new Object[] {
            zzanl.zzrH()
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzc.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        return zzapF.asBinder();
    }

}
