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
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, datasourcesrequest.getDataTypes(), false);
        zzb.zzc(parcel, 1000, datasourcesrequest.getVersionCode());
        zzb.zza(parcel, 2, datasourcesrequest.zzsl(), false);
        zzb.zza(parcel, 3, datasourcesrequest.zzsm());
        zzb.zza(parcel, 4, datasourcesrequest.zzsc(), false);
        zzb.zza(parcel, 5, datasourcesrequest.getPackageName(), false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcS(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeL(i);
    }

    public DataSourcesRequest zzcS(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        android.os.IBinder ibinder = null;
        java.util.ArrayList arraylist = null;
        java.util.ArrayList arraylist1 = null;
        int i = 0;
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
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataType.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzB(parcel, k);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DataSourcesRequest(i, arraylist1, arraylist, flag, ibinder, s);
            }
        } while (true);
    }

    public DataSourcesRequest[] zzeL(int i)
    {
        return new DataSourcesRequest[i];
    }
}
