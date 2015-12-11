// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.data:
//            RawDataSet, RawDataPoint

public class zzo
    implements android.os.Parcelable.Creator
{

    public zzo()
    {
    }

    static void zza(RawDataSet rawdataset, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, rawdataset.zzaqU);
        zzb.zzc(parcel, 1000, rawdataset.mVersionCode);
        zzb.zzc(parcel, 2, rawdataset.zzaqW);
        zzb.zzc(parcel, 3, rawdataset.zzaqX, false);
        zzb.zza(parcel, 4, rawdataset.zzaqa);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcQ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeG(i);
    }

    public RawDataSet zzcQ(Parcel parcel)
    {
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        int i = 0;
        int j = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 1000: 
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 3: // '\003'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1, RawDataPoint.CREATOR);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new RawDataSet(k, j, i, arraylist, flag);
            }
        } while (true);
    }

    public RawDataSet[] zzeG(int i)
    {
        return new RawDataSet[i];
    }
}
