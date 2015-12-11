// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzab, zzn, BleScanCallback

public class StopBleScanRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzab();
    private final int mVersionCode;
    private final zzn zzasY;
    private final zzoj zzasb;

    StopBleScanRequest(int i, IBinder ibinder, IBinder ibinder1)
    {
        mVersionCode = i;
        zzasY = zzn.zza.zzbM(ibinder);
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder1);
    }

    public StopBleScanRequest(BleScanCallback blescancallback, zzoj zzoj1)
    {
        this(((zzn) (zza.zza.zzsM().zzb(blescancallback))), zzoj1);
    }

    public StopBleScanRequest(zzn zzn1, zzoj zzoj1)
    {
        mVersionCode = 3;
        zzasY = zzn1;
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

    public void writeToParcel(Parcel parcel, int i)
    {
        zzab.zza(this, parcel, i);
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

    public IBinder zztk()
    {
        return zzasY.asBinder();
    }

}
