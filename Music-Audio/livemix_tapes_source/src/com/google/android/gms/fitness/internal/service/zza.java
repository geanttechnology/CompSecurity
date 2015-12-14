// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.internal.service;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.internal.service:
//            FitnessDataSourcesRequest

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(FitnessDataSourcesRequest fitnessdatasourcesrequest, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, fitnessdatasourcesrequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, fitnessdatasourcesrequest.getVersionCode());
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcK(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeD(i);
    }

    public FitnessDataSourcesRequest zzcK(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataType.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new FitnessDataSourcesRequest(i, arraylist);
            }
        } while (true);
    }

    public FitnessDataSourcesRequest[] zzeD(int i)
    {
        return new FitnessDataSourcesRequest[i];
    }
}
