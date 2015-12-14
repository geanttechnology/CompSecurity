// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoy;
import com.google.android.gms.nearby.bootstrap.Device;

// Referenced classes of package com.google.android.gms.nearby.bootstrap.request:
//            zzd

public class DisconnectRequest
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    final int versionCode;
    private final Device zzaJb;
    private final zzoy zzaJe;

    DisconnectRequest(int i, Device device, IBinder ibinder)
    {
        versionCode = i;
        zzaJb = (Device)zzx.zzv(device);
        zzx.zzv(ibinder);
        zzaJe = com.google.android.gms.internal.zzoy.zza.zzdb(ibinder);
    }

    public int describeContents()
    {
        zzd zzd1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd zzd1 = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public IBinder zzsc()
    {
        return zzaJe.asBinder();
    }

    public Device zzye()
    {
        return zzaJb;
    }

}
