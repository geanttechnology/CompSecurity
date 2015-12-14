// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.sharing.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

// Referenced classes of package com.google.android.gms.nearby.sharing.internal:
//            zzf, zzc, zzb

public final class ProvideContentRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzf();
    final int versionCode;
    public IBinder zzaKq;
    public zzb zzaKr;
    public List zzaKs;
    public long zzaKt;
    public zzc zzaKu;

    ProvideContentRequest()
    {
        versionCode = 1;
    }

    ProvideContentRequest(int i, IBinder ibinder, IBinder ibinder1, List list, long l, IBinder ibinder2)
    {
        versionCode = i;
        zzaKq = ibinder;
        zzaKr = zzb.zza.zzdm(ibinder1);
        zzaKs = list;
        zzaKt = l;
        zzaKu = zzc.zza.zzdn(ibinder2);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        return zzaKu.asBinder();
    }

    IBinder zzyx()
    {
        if (zzaKr == null)
        {
            return null;
        } else
        {
            return zzaKr.asBinder();
        }
    }

}
