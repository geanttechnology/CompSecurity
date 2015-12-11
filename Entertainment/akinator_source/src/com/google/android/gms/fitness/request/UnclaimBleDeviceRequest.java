// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzad

public class UnclaimBleDeviceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzad();
    private final int mVersionCode;
    private final String zzarZ;
    private final zzoj zzasb;

    UnclaimBleDeviceRequest(int i, String s, IBinder ibinder)
    {
        mVersionCode = i;
        zzarZ = s;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public UnclaimBleDeviceRequest(String s, zzoj zzoj1)
    {
        mVersionCode = 5;
        zzarZ = s;
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
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[] {
            zzarZ
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzad.zza(this, parcel, i);
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
