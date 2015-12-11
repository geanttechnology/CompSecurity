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
    private final DataSource zzapM;
    private final zzj zzasF;
    private final long zzatp;
    private final long zzatq;

    FitnessSensorServiceRequest(int i, DataSource datasource, IBinder ibinder, long l, long l1)
    {
        mVersionCode = i;
        zzapM = datasource;
        zzasF = com.google.android.gms.fitness.data.zzj.zza.zzbl(ibinder);
        zzatp = l;
        zzatq = l1;
    }

    private boolean zza(FitnessSensorServiceRequest fitnesssensorservicerequest)
    {
        return zzw.equal(zzapM, fitnesssensorservicerequest.zzapM) && zzatp == fitnesssensorservicerequest.zzatp && zzatq == fitnesssensorservicerequest.zzatq;
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
        return timeunit.convert(zzatq, TimeUnit.MICROSECONDS);
    }

    public DataSource getDataSource()
    {
        return zzapM;
    }

    public SensorEventDispatcher getDispatcher()
    {
        return new zzb(zzasF);
    }

    public long getSamplingRate(TimeUnit timeunit)
    {
        if (zzatp == -1L)
        {
            return -1L;
        } else
        {
            return timeunit.convert(zzatp, TimeUnit.MICROSECONDS);
        }
    }

    int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            zzapM, Long.valueOf(zzatp), Long.valueOf(zzatq)
        });
    }

    public String toString()
    {
        return String.format("FitnessSensorServiceRequest{%s}", new Object[] {
            zzapM
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        com.google.android.gms.fitness.service.zza.zza(this, parcel, i);
    }

    public long zzsB()
    {
        return zzatp;
    }

    IBinder zztf()
    {
        return zzasF.asBinder();
    }

    public long zztw()
    {
        return zzatq;
    }

}
