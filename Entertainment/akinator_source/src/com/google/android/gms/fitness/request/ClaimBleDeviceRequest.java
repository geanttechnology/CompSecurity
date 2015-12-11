// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzb

public class ClaimBleDeviceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final String zzarZ;
    private final BleDevice zzasa;
    private final zzoj zzasb;

    ClaimBleDeviceRequest(int i, String s, BleDevice bledevice, IBinder ibinder)
    {
        mVersionCode = i;
        zzarZ = s;
        zzasa = bledevice;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public ClaimBleDeviceRequest(String s, BleDevice bledevice, zzoj zzoj1)
    {
        mVersionCode = 4;
        zzarZ = s;
        zzasa = bledevice;
        zzasb = zzoj1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDeviceAddress()
    {
        return zzarZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[] {
            zzarZ, zzasa
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public BleDevice zzsN()
    {
        return zzasa;
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

}
