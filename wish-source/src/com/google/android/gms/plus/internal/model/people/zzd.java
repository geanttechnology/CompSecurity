// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzd
    implements android.os.Parcelable.Creator
{

    public zzd()
    {
    }

    static void zza(PersonEntity.CoverEntity.CoverInfoEntity coverinfoentity, Parcel parcel, int i)
    {
        i = zzb.zzM(parcel);
        Set set = coverinfoentity.zzazD;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, coverinfoentity.zzzH);
        }
        if (set.contains(Integer.valueOf(2)))
        {
            zzb.zzc(parcel, 2, coverinfoentity.zzaAZ);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zzc(parcel, 3, coverinfoentity.zzaBa);
        }
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeX(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhq(i);
    }

    public PersonEntity.CoverEntity.CoverInfoEntity zzeX(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzL(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzK(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaV(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(2));
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
                }
                return new PersonEntity.CoverEntity.CoverInfoEntity(hashset, i, j, k);
            }
        } while (true);
    }

    public PersonEntity.CoverEntity.CoverInfoEntity[] zzhq(int i)
    {
        return new PersonEntity.CoverEntity.CoverInfoEntity[i];
    }
}
