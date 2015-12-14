// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.service;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.zzj;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.fitness.service:
//            zza, zzb, SensorEventDispatcher

public class FitnessSensorServiceRequest
    implements SafeParcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new zza();
    public static final int UNSPECIFIED = -1;
    private final int mVersionCode;
    private final DataSource zzanm;
    private final long zzaqR;
    private final long zzaqS;
    private final zzj zzaqi;

    FitnessSensorServiceRequest(int i, DataSource datasource, IBinder ibinder, long l, long l1)
    {
        mVersionCode = i;
        zzanm = datasource;
        zzaqi = com.google.android.gms.fitness.data.zzj.zza.zzbl(ibinder);
        zzaqR = l;
        zzaqS = l1;
    }

    private boolean zza(FitnessSensorServiceRequest fitnesssensorservicerequest)
    {
        return zzw.equal(zzanm, fitnesssensorservicerequest.zzanm) && zzaqR == fitnesssensorservicerequest.zzaqR && zzaqS == fitnesssensorservicerequest.zzaqS;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return this == obj || (obj instanceof FitnessSensorServiceRequest) && zza((FitnessSensorServiceRequest)obj);
    }

    public long getBatchInterval(TimeUnit timeunit)
    {
        return timeunit.convert(zzaqS, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource()
    {
        return zzanm;
    }

    public SensorEventDispatcher getDispatcher()
    {
        return new zzb(zzaqi);
    }

    public long getSamplingRate(TimeUnit timeunit)
    {
        if (zzaqR == -1L)
        {
            return -1L;
        } else
        {
            return timeunit.convert(zzaqR, TimeUnit.MICROSECONDS);
        }
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzanm, Long.valueOf(zzaqR), Long.valueOf(zzaqS)
        });
    }

    public String toString()
    {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[] {
            zzanm
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.service.zza.zza(this, parcel, i);
    }

    public long zzrP()
    {
        return zzaqR;
    }

    public long zzsJ()
    {
        return zzaqS;
    }

    IBinder zzst()
    {
        return zzaqi.asBinder();
    }

}
