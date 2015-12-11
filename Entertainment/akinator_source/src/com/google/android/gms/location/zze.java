// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location:
//            LocationResult

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(LocationResult locationresult, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, locationresult.getLocations(), false);
        zzb.zzc(parcel, 1000, locationresult.getVersionCode());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeB(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgR(i);
    }

    public LocationResult zzeB(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        Object obj = LocationResult.zzaEJ;
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
                    obj = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, Location.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LocationResult(i, ((java.util.List) (obj)));
            }
        } while (true);
    }

    public LocationResult[] zzgR(int i)
    {
        return new LocationResult[i];
    }
}
