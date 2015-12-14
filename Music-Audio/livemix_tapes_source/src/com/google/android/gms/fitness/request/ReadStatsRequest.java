// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzne;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzr

public class ReadStatsRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzr();
    private final int mVersionCode;
    private final String zzOZ;
    private final zzne zzaqh;

    ReadStatsRequest(int i, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzaqh = com.google.android.gms.internal.zzne.zza.zzbG(ibinder);
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
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
        return String.format("ReadStatsRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzr.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        return zzaqh.asBinder();
    }

}
