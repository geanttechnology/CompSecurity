// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;

// Referenced classes of package com.google.android.gms.nearby.bootstrap.request:
//            zzh

public class StopScanRequest
    implements SafeParcelable
{

    public static final zzh CREATOR = new zzh();
    final int versionCode;
    private final zzoy zzaJe;

    StopScanRequest(int i, IBinder ibinder)
    {
        versionCode = i;
        zzx.zzv(ibinder);
        zzaJe = com.google.android.gms.internal.zzoy.zza.zzdb(ibinder);
    }

    public int describeContents()
    {
        zzh zzh1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzh zzh1 = CREATOR;
        zzh.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        if (zzaJe == null)
        {
            return null;
        } else
        {
            return zzaJe.asBinder();
        }
    }

}
