// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal.model.people;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.HashSet;
import java.util.Set;

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(PersonEntity.UrlsEntity urlsentity, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        Set set = urlsentity.zzaLT;
        if (set.contains(Integer.valueOf(1)))
        {
            zzb.zzc(parcel, 1, urlsentity.mVersionCode);
        }
        if (set.contains(Integer.valueOf(3)))
        {
            zzb.zzc(parcel, 3, urlsentity.zzzg());
        }
        if (set.contains(Integer.valueOf(4)))
        {
            zzb.zza(parcel, 4, urlsentity.mValue, true);
        }
        if (set.contains(Integer.valueOf(5)))
        {
            zzb.zza(parcel, 5, urlsentity.zzaID, true);
        }
        if (set.contains(Integer.valueOf(6)))
        {
            zzb.zzc(parcel, 6, urlsentity.zzUS);
        }
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzge(parcel);
    }

    public Object[] newArray(int i)
    {
        return zziT(i);
    }

    public PersonEntity.UrlsEntity zzge(Parcel parcel)
    {
        String s = null;
        int i = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        HashSet hashset = new HashSet();
        int j = 0;
        String s1 = null;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(i1))
                {
                case 2: // '\002'
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(1));
                    break;

                case 3: // '\003'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(3));
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    hashset.add(Integer.valueOf(4));
                    break;

                case 5: // '\005'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    hashset.add(Integer.valueOf(5));
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    hashset.add(Integer.valueOf(6));
                    break;
                }
            } else
            {
                if (parcel.dataPosition() != l)
                {
                    throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
                }
                return new PersonEntity.UrlsEntity(hashset, k, s1, j, s, i);
            }
        } while (true);
    }

    public PersonEntity.UrlsEntity[] zziT(int i)
    {
        return new PersonEntity.UrlsEntity[i];
    }
}
