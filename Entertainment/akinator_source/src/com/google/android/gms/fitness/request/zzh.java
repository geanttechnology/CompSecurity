// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataSourcesRequest

public class zzh
    implements android.os.Parcelable.Creator
{

    public zzh()
    {
    }

    static void zza(DataSourcesRequest datasourcesrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, datasourcesrequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, datasourcesrequest.getVersionCode());
        zzb.zza(parcel, 2, datasourcesrequest.zzsX(), false);
        zzb.zza(parcel, 3, datasourcesrequest.zzsY());
        zzb.zza(parcel, 4, datasourcesrequest.zzsO(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdd(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeU(i);
    }

    public DataSourcesRequest zzdd(Parcel parcel)
    {
        boolean flag = false;
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        java.util.ArrayList arraylist1 = null;
        int i = 0;
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
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataType.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzC(parcel, k);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DataSourcesRequest(i, arraylist1, arraylist, flag, ibinder);
            }
        } while (true);
    }

    public DataSourcesRequest[] zzeU(int i)
    {
        return new DataSourcesRequest[i];
    }
}
