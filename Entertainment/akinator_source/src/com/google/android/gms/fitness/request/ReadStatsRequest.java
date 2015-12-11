// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzog;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzr

public class ReadStatsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzr();
    private final int mVersionCode;
    private final zzog zzasE;

    ReadStatsRequest(int i, IBinder ibinder)
    {
        mVersionCode = i;
        zzasE = com.google.android.gms.internal.zzog.zza.zzbG(ibinder);
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzr.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        return zzasE.asBinder();
    }

}
