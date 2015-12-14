// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznv;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzo

public class ListClaimedBleDevicesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzo();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznv zzaqd;

    ListClaimedBleDevicesRequest(int i, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzaqd = com.google.android.gms.internal.zznv.zza.zzbL(ibinder);
        zzOZ = s;
    }

    public ListClaimedBleDevicesRequest(zznv zznv1, String s)
    {
        mVersionCode = 1;
        zzaqd = zznv1;
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
        return String.format("ListClaimedBleDevicesRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzo.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        return zzaqd.asBinder();
    }

}
