// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzb

public class ClaimBleDeviceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzb();
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzapC;
    private final BleDevice zzapD;
    private final zznh zzapE;

    ClaimBleDeviceRequest(int i, String s, BleDevice bledevice, IBinder ibinder, String s1)
    {
        mVersionCode = i;
        zzapC = s;
        zzapD = bledevice;
        if (ibinder == null)
        {
            s = null;
        } else
        {
            s = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = s;
        zzOZ = s1;
    }

    public ClaimBleDeviceRequest(String s, BleDevice bledevice, zznh zznh1, String s1)
    {
        mVersionCode = 3;
        zzapC = s;
        zzapD = bledevice;
        zzapE = zznh1;
        zzOZ = s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getDeviceAddress()
    {
        return zzapC;
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
        return String.format("ClaimBleDeviceRequest{%s %s}", new Object[] {
            zzapC, zzapD
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public BleDevice zzsb()
    {
        return zzapD;
    }

    public IBinder zzsc()
    {
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

}
