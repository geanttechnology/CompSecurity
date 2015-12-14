// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzn, zzc, zzb

public final class UnsubscribeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzn();
    final int mVersionCode;
    public final String zzaCr;
    public final zzc zzaJR;
    public final String zzaKe;
    public final zzb zzaKf;
    public final PendingIntent zzaKh;
    public final int zzaKi;

    UnsubscribeRequest(int i, IBinder ibinder, IBinder ibinder1, PendingIntent pendingintent, int j, String s, String s1)
    {
        mVersionCode = i;
        zzaKf = zzb.zza.zzdh(ibinder);
        zzaJR = zzc.zza.zzdi(ibinder1);
        zzaKh = pendingintent;
        zzaKi = j;
        zzaCr = s;
        zzaKe = s1;
    }

    UnsubscribeRequest(IBinder ibinder, IBinder ibinder1, PendingIntent pendingintent, int i, String s, String s1)
    {
        this(1, ibinder, ibinder1, pendingintent, i, s, s1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzn.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        return zzaJR.asBinder();
    }

    IBinder zzyq()
    {
        if (zzaKf == null)
        {
            return null;
        } else
        {
            return zzaKf.asBinder();
        }
    }

}
