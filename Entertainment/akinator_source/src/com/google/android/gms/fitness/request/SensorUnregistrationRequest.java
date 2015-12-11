// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zzoj;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzt

public class SensorUnregistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzt();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final zzj zzasF;
    private final zzoj zzasb;

    SensorUnregistrationRequest(int i, IBinder ibinder, PendingIntent pendingintent, IBinder ibinder1)
    {
        mVersionCode = i;
        if (ibinder == null)
        {
            ibinder = null;
        } else
        {
            ibinder = com.google.android.gms.fitness.data.zzj.zza.zzbl(ibinder);
        }
        zzasF = ibinder;
        mPendingIntent = pendingintent;
        zzasb = com.google.android.gms.internal.zzoj.zza.zzbJ(ibinder1);
    }

    public SensorUnregistrationRequest(zzj zzj1, PendingIntent pendingintent, zzoj zzoj1)
    {
        mVersionCode = 4;
        zzasF = zzj1;
        mPendingIntent = pendingintent;
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
        return String.format("SensorUnregistrationRequest{%s}", new Object[] {
            zzasF
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzt.zza(this, parcel, i);
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

    public PendingIntent zzta()
    {
        return mPendingIntent;
    }

    IBinder zztf()
    {
        if (zzasF == null)
        {
            return null;
        } else
        {
            return zzasF.asBinder();
        }
    }

}
