// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzac

public class SubscribeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzac();
    private final int mVersionCode;
    private final zzoj zzasb;
    private Subscription zzata;
    private final boolean zzatb;

    SubscribeRequest(int i, Subscription subscription, boolean flag, IBinder ibinder)
    {
        mVersionCode = i;
        zzata = subscription;
        zzatb = flag;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder);
    }

    public SubscribeRequest(Subscription subscription, boolean flag, zzoj zzoj1)
    {
        mVersionCode = 3;
        zzata = subscription;
        zzatb = flag;
        zzasb = zzoj1;
    }

    public int describeContents()
    {
        return 0;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return zzw.zzv(this).zzg("subscription", zzata).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzac.zza(this, parcel, i);
    }

    public IBinder zzsO()
    {
        if (zzasb == null)
        {
            return null;
        } else
        {
            return zzasb.asBinder();
        }
    }

    public Subscription zztl()
    {
        return zzata;
    }

    public boolean zztm()
    {
        return zzatb;
    }

}
