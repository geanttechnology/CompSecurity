// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzok;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzm

public class GetSyncInfoRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    private final int mVersionCode;
    private final zzok zzasz;

    GetSyncInfoRequest(int i, IBinder ibinder)
    {
        mVersionCode = i;
        zzasz = com.google.android.gms.internal.zzok.zza.zzbK(ibinder);
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
        return String.format("GetSyncInfoRequest {%d, %s, %s}", new Object[] {
            Integer.valueOf(mVersionCode), zzasz
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        return zzasz.asBinder();
    }

}
