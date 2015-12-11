// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.data;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.data:
//            MapValue

public class zzl
    implements android.os.Parcelable.Creator
{

    public zzl()
    {
    }

    static void zza(MapValue mapvalue, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, mapvalue.getFormat());
        zzb.zzc(parcel, 1000, mapvalue.getVersionCode());
        zzb.zza(parcel, 2, mapvalue.zzsy());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcN(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeD(i);
    }

    public MapValue zzcN(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        float f = 0.0F;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new MapValue(i, j, f);
            }
        } while (true);
    }

    public MapValue[] zzeD(int i)
    {
        return new MapValue[i];
    }
}
