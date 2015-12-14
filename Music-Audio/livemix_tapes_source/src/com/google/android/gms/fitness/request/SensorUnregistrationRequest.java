// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.zzj;
import com.google.android.gms.internal.zznh;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzt

public class SensorUnregistrationRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zzt();
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final String zzOZ;
    private final zznh zzapE;
    private final zzj zzaqi;

    SensorUnregistrationRequest(int i, IBinder ibinder, PendingIntent pendingintent, IBinder ibinder1, String s)
    {
        mVersionCode = i;
        if (ibinder == null)
        {
            ibinder = null;
        } else
        {
            ibinder = com.google.android.gms.fitness.data.zzj.zza.zzbl(ibinder);
        }
        zzaqi = ibinder;
        mPendingIntent = pendingintent;
        zzapE = com.google.android.gms.internal.zznh.zza.zzbJ(ibinder1);
        zzOZ = s;
    }

    public SensorUnregistrationRequest(zzj zzj1, PendingIntent pendingintent, zznh zznh1, String s)
    {
        mVersionCode = 3;
        zzaqi = zzj1;
        mPendingIntent = pendingintent;
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
        return String.format("SensorUnregistrationRequest{%s}", new Object[] {
            zzaqi
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzt.zza(this, parcel, i);
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

    public PendingIntent zzso()
    {
        return mPendingIntent;
    }

    IBinder zzst()
    {
        if (zzaqi == null)
        {
            return null;
        } else
        {
            return zzaqi.asBinder();
        }
    }

}
