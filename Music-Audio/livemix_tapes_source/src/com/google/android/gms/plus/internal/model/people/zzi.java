// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzi
    implements android.os.Parcelable.Creator
{

    public zzi()
    {
    }

    static void zza(PersonEntity.PlacesLivedEntity placeslivedentity, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        Set set = placeslivedentity.zzaLT;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, placeslivedentity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zza(parcel, 2, placeslivedentity.zzaNx);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zza(parcel, 3, placeslivedentity.mValue, true);
        }
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgd(parcel);
    }

    public Object[] newArray(int i)
    {
        return zziS(i);
    }

    public PersonEntity.PlacesLivedEntity zzgd(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        HashSet hashset = new HashSet();
        String s = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    hashset.add(Integer.valueOf(3));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != j)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
                }
                return new PersonEntity.PlacesLivedEntity(hashset, i, flag, s);
            }
        } while (true);
    }

    public PersonEntity.PlacesLivedEntity[] zziS(int i)
    {
        return new PersonEntity.PlacesLivedEntity[i];
    }
}
