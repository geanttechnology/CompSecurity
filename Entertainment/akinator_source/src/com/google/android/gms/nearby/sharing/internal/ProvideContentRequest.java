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
    public IBinder zzaRq;
    public zzb zzaRr;
    public List zzaRs;
    public long zzaRt;
    public zzc zzaRu;

    ProvideContentRequest()
    {
        versionCode = 1;
    }

    ProvideContentRequest(int i, IBinder ibinder, IBinder ibinder1, List list, long l, IBinder ibinder2)
    {
        versionCode = i;
        zzaRq = ibinder;
        zzaRr = zzb.zza.zzds(ibinder1);
        zzaRs = list;
        zzaRt = l;
        zzaRu = zzc.zza.zzdt(ibinder2);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzf.zza(this, parcel, i);
    }

    IBinder zzBd()
    {
        return zzaRu.asBinder();
    }

    IBinder zzBo()
    {
        if (zzaRr == null)
        {
            return null;
        } else
        {
            return zzaRr.asBinder();
        }
    }

}
