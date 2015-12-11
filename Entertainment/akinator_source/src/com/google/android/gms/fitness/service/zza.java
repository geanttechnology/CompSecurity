// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.service;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;

// Referenced classes of package com.google.android.gms.fitness.service:
//            FitnessSensorServiceRequest

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(FitnessSensorServiceRequest fitnesssensorservicerequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, fitnesssensorservicerequest.getDataSource(), i, false);
        zzb.zzc(parcel, 1000, fitnesssensorservicerequest.getVersionCode());
        zzb.zza(parcel, 2, fitnesssensorservicerequest.zztf(), false);
        zzb.zza(parcel, 3, fitnesssensorservicerequest.zzsB());
        zzb.zza(parcel, 4, fitnesssensorservicerequest.zztw());
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdM(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfE(i);
    }

    public FitnessSensorServiceRequest zzdM(Parcel parcel)
    {
        long l = 0L;
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        long l1 = 0L;
        DataSource datasource = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    datasource = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataSource.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;

                case 3: // '\003'
                    l1 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 4: // '\004'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new FitnessSensorServiceRequest(i, datasource, ibinder, l1, l);
            }
        } while (true);
    }

    public FitnessSensorServiceRequest[] zzfE(int i)
    {
        return new FitnessSensorServiceRequest[i];
    }
}
