// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzl, zzc, zzb

public final class SubscribeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzl();
    final int mVersionCode;
    public final String zzaCr;
    public final boolean zzaJJ;
    public final zzc zzaJR;
    public final Strategy zzaKd;
    public final String zzaKe;
    public final zzb zzaKf;
    public final MessageFilter zzaKg;
    public final PendingIntent zzaKh;
    public final int zzaKi;
    public final byte zzaKj[];

    SubscribeRequest(int i, IBinder ibinder, Strategy strategy, IBinder ibinder1, MessageFilter messagefilter, PendingIntent pendingintent, int j, 
            String s, String s1, byte abyte0[], boolean flag)
    {
        mVersionCode = i;
        zzaKf = zzb.zza.zzdh(ibinder);
        zzaKd = strategy;
        zzaJR = zzc.zza.zzdi(ibinder1);
        zzaKg = messagefilter;
        zzaKh = pendingintent;
        zzaKi = j;
        zzaCr = s;
        zzaKe = s1;
        zzaKj = abyte0;
        zzaJJ = flag;
    }

    public SubscribeRequest(IBinder ibinder, Strategy strategy, IBinder ibinder1, MessageFilter messagefilter, PendingIntent pendingintent, int i, String s, 
            String s1, byte abyte0[], boolean flag)
    {
        this(2, ibinder, strategy, ibinder1, messagefilter, pendingintent, i, s, s1, abyte0, flag);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzl.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        if (zzaJR == null)
        {
            return null;
        } else
        {
            return zzaJR.asBinder();
        }
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
