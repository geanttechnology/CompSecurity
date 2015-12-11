// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.result:
//            ReadRawResult

public class zzi
    implements android.os.Parcelable.Creator
{

    public zzi()
    {
    }

    static void zza(ReadRawResult readrawresult, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, readrawresult.zzrh(), i, false);
        zzb.zzc(parcel, 1000, readrawresult.getVersionCode());
        zzb.zzc(parcel, 2, readrawresult.zzts(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdI(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfA(i);
    }

    public ReadRawResult zzdI(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        DataHolder dataholder = null;
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
                    dataholder = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataHolder.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataHolder.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ReadRawResult(i, dataholder, arraylist);
            }
        } while (true);
    }

    public ReadRawResult[] zzfA(int i)
    {
        return new ReadRawResult[i];
    }
}
