// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzad

public class UnclaimBleDeviceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzad();
    private final int mVersionCode;
    private final String zzOZ;
    private final String zzapC;
    private final zznh zzapE;

    UnclaimBleDeviceRequest(int i, String s, IBinder ibinder, String s1)
    {
        mVersionCode = i;
        zzapC = s;
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

    public UnclaimBleDeviceRequest(String s, zznh zznh1, String s1)
    {
        mVersionCode = 4;
        zzapC = s;
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
        return String.format("UnclaimBleDeviceRequest{%s}", new Object[] {
            zzapC
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzad.zza(this, parcel, i);
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
