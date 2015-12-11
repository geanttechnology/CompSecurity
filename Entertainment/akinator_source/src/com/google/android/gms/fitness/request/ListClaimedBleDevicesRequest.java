// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzow;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzo

public class ListClaimedBleDevicesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzo();
    private final int mVersionCode;
    private final zzow zzasA;

    ListClaimedBleDevicesRequest(int i, IBinder ibinder)
    {
        mVersionCode = i;
        zzasA = com.google.android.gms.internal.zzow.zza.zzbL(ibinder);
    }

    public ListClaimedBleDevicesRequest(zzow zzow1)
    {
        mVersionCode = 2;
        zzasA = zzow1;
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        return zzasA.asBinder();
    }

}
