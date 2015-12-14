// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.nearby.sharing.internal:
//            zzk, zzc

public final class TrustedDevicesRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    final int versionCode;
    public zzc zzaKu;
    public String zzaKw;
    public byte zzaKx[];

    TrustedDevicesRequest(int i, String s, byte abyte0[], IBinder ibinder)
    {
        versionCode = i;
        zzaKw = (String)zzx.zzv(s);
        zzaKx = (byte[])zzx.zzv(abyte0);
        zzaKu = zzc.zza.zzdn(ibinder);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzk.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        return zzaKu.asBinder();
    }

}
