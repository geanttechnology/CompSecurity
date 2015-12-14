// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.nearby.sharing.internal:
//            zzj, zzc

public final class StopProvidingContentRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzj();
    final int versionCode;
    public long zzaKt;
    public zzc zzaKu;

    StopProvidingContentRequest()
    {
        versionCode = 1;
    }

    StopProvidingContentRequest(int i, long l, IBinder ibinder)
    {
        versionCode = i;
        zzaKt = l;
        zzaKu = zzc.zza.zzdn(ibinder);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        return zzaKu.asBinder();
    }

}
