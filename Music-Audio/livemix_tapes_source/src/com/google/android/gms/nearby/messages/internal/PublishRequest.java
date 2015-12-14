// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzk, zzc, MessageWrapper

public final class PublishRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzk();
    final int mVersionCode;
    public final String zzaCr;
    public final boolean zzaJJ;
    public final zzc zzaJR;
    public final MessageWrapper zzaKc;
    public final Strategy zzaKd;
    public final String zzaKe;

    PublishRequest(int i, MessageWrapper messagewrapper, Strategy strategy, IBinder ibinder, String s, String s1, boolean flag)
    {
        mVersionCode = i;
        zzaKc = messagewrapper;
        zzaKd = strategy;
        zzaJR = zzc.zza.zzdi(ibinder);
        zzaCr = s;
        zzaKe = s1;
        zzaJJ = flag;
    }

    PublishRequest(MessageWrapper messagewrapper, Strategy strategy, IBinder ibinder, String s, String s1, boolean flag)
    {
        this(1, messagewrapper, strategy, ibinder, s, s1, flag);
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
        return zzaJR.asBinder();
    }

}
