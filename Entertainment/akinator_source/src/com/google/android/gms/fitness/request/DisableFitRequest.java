// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzl

public class DisableFitRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    private final int mVersionCode;
    private final zzoj zzasb;

    DisableFitRequest(int i, IBinder ibinder)
    {
        mVersionCode = i;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public DisableFitRequest(zzoj zzoj1)
    {
        mVersionCode = 2;
        zzasb = zzoj1;
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
        return String.format("DisableFitRequest", new Object[0]);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        return zzasb.asBinder();
    }

}
