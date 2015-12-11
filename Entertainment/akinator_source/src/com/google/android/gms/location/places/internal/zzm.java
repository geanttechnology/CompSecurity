// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location.places.internal:
//            PlaceLikelihoodEntity, PlaceImpl

public class zzm
    implements android.os.Parcelable.Creator
{

    public zzm()
    {
    }

    static void zza(PlaceLikelihoodEntity placelikelihoodentity, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, placelikelihoodentity.zzaHA, i, false);
        zzb.zzc(parcel, 1000, placelikelihoodentity.mVersionCode);
        zzb.zza(parcel, 2, placelikelihoodentity.zzaHB);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeW(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhu(i);
    }

    public PlaceLikelihoodEntity zzeW(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        PlaceImpl placeimpl = null;
        float f = 0.0F;
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
                    placeimpl = (PlaceImpl)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, PlaceImpl.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new PlaceLikelihoodEntity(i, placeimpl, f);
            }
        } while (true);
    }

    public PlaceLikelihoodEntity[] zzhu(int i)
    {
        return new PlaceLikelihoodEntity[i];
    }
}
