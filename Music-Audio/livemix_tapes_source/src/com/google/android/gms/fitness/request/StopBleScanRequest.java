// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzab, zzn, BleScanCallback

public class StopBleScanRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzab();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final zzn zzaqB;

    StopBleScanRequest(int i, IBinder ibinder, IBinder ibinder1, String s)
    {
        mVersionCode = i;
        zzaqB = zzn.zza.zzbM(ibinder);
        if (ibinder1 == null)
        {
            ibinder = null;
        } else
        {
            ibinder = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder1);
        }
        zzapE = ibinder;
        zzOZ = s;
    }

    public StopBleScanRequest(BleScanCallback blescancallback, zznh zznh1, String s)
    {
        this(((zzn) (zza.zza.zzsa().zzb(blescancallback))), zznh1, s);
    }

    public StopBleScanRequest(zzn zzn1, zznh zznh1, String s)
    {
        mVersionCode = 2;
        zzaqB = zzn1;
        zzapE = zznh1;
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

    public void writeToParcel(Parcel parcel, int i)
    {
        zzab.zza(this, parcel, i);
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

    public IBinder zzsy()
    {
        return zzaqB.asBinder();
    }

}
