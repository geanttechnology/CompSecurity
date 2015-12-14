// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzac

public class SubscribeRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzac();
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final Subscription zzaqD;
    private final boolean zzaqE;

    SubscribeRequest(int i, Subscription subscription, boolean flag, IBinder ibinder, String s)
    {
        mVersionCode = i;
        zzaqD = subscription;
        zzaqE = flag;
        if (ibinder == null)
        {
            subscription = null;
        } else
        {
            subscription = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder);
        }
        zzapE = subscription;
        zzOZ = s;
    }

    public SubscribeRequest(Subscription subscription, boolean flag, zznh zznh1, String s)
    {
        mVersionCode = 2;
        zzaqD = subscription;
        zzaqE = flag;
        zzapE = zznh1;
        zzOZ = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getPackageName()
    {
        return zzOZ;
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public String toString()
    {
        return zzw.zzu(this).zzg("subscription", zzaqD).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzac.zza(this, parcel, i);
    }

    public boolean zzsA()
    {
        return zzaqE;
    }

    public IBinder zzsc()
    {
        if (zzapE == null)
        {
            return null;
        } else
        {
            return zzapE.asBinder();
        }
    }

    public Subscription zzsz()
    {
        return zzaqD;
    }

}
