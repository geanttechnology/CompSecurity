// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wallet:
//            CountrySpecification

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(CountrySpecification countryspecification, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, countryspecification.getVersionCode());
        zzb.zza(parcel, 2, countryspecification.zzFF, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgG(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjL(i);
    }

    public CountrySpecification zzgG(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s = null;
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
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new CountrySpecification(i, s);
            }
        } while (true);
    }

    public CountrySpecification[] zzjL(int i)
    {
        return new CountrySpecification[i];
    }
}
