// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoe;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzp

public class ListSubscriptionsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzp();
    private final int mVersionCode;
    private final DataType zzapL;
    private final zzoe zzasB;

    ListSubscriptionsRequest(int i, DataType datatype, IBinder ibinder)
    {
        mVersionCode = i;
        zzapL = datatype;
        zzasB = com.google.android.gms.internal.zzoe.zza.zzbE(ibinder);
    }

    public ListSubscriptionsRequest(DataType datatype, zzoe zzoe1)
    {
        mVersionCode = 3;
        zzapL = datatype;
        zzasB = zzoe1;
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

    public void writeToParcel(Parcel parcel, int i)
    {
        zzp.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasB == null)
        {
            return null;
        } else
        {
            return zzasB.asBinder();
        }
    }

}
