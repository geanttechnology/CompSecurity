// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.internal.zzpa;

// Referenced classes of package com.google.android.gms.nearby.bootstrap.request:
//            zzg

public class StartScanRequest
    implements SafeParcelable
{

    public static final zzg CREATOR = new zzg();
    final int versionCode;
    private final zzoy zzaJe;
    private final zzpa zzaJh;

    StartScanRequest(int i, IBinder ibinder, IBinder ibinder1)
    {
        versionCode = i;
        zzx.zzv(ibinder);
        zzaJh = com.google.android.gms.internal.zzpa.zza.zzdd(ibinder);
        zzx.zzv(ibinder1);
        zzaJe = com.google.android.gms.internal.zzoy.zza.zzdb(ibinder1);
    }

    public int describeContents()
    {
        zzg zzg1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzg zzg1 = CREATOR;
        zzg.zza(this, parcel, i);
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

    public IBinder zzyj()
    {
        if (zzaJh == null)
        {
            return null;
        } else
        {
            return zzaJh.asBinder();
        }
    }

}
