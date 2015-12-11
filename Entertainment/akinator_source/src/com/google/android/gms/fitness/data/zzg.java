// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.data:
//            DataType, Field

public class zzg
    implements android.os.Parcelable.Creator
{

    public zzg()
    {
    }

    static void zza(DataType datatype, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, datatype.getName(), false);
        zzb.zzc(parcel, 1000, datatype.getVersionCode());
        zzb.zzc(parcel, 2, datatype.getFields(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcK(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeA(i);
    }

    public DataType zzcK(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s = null;
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
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, Field.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DataType(i, s, arraylist);
            }
        } while (true);
    }

    public DataType[] zzeA(int i)
    {
        return new DataType[i];
    }
}
