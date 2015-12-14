// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.nearby.messages.internal:
//            zzm, zzc, MessageWrapper

public final class UnpublishRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzm();
    final int mVersionCode;
    public final String zzaCr;
    public final zzc zzaJR;
    public final MessageWrapper zzaKc;
    public final String zzaKe;

    UnpublishRequest(int i, MessageWrapper messagewrapper, IBinder ibinder, String s, String s1)
    {
        mVersionCode = i;
        zzaKc = messagewrapper;
        zzaJR = zzc.zza.zzdi(ibinder);
        zzaCr = s;
        zzaKe = s1;
    }

    UnpublishRequest(MessageWrapper messagewrapper, IBinder ibinder, String s, String s1)
    {
        this(1, messagewrapper, ibinder, s, s1);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzm.zza(this, parcel, i);
    }

    IBinder zzyp()
    {
        return zzaJR.asBinder();
    }

}
