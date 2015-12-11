// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            UserAttributeParcel

public class zzaf
    implements android.os.Parcelable.Creator
{

    public zzaf()
    {
    }

    static void zza(UserAttributeParcel userattributeparcel, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, userattributeparcel.versionCode);
        zzb.zza(parcel, 2, userattributeparcel.name, false);
        zzb.zza(parcel, 3, userattributeparcel.zzaOz);
        zzb.zza(parcel, 4, userattributeparcel.zzaOA, false);
        zzb.zza(parcel, 5, userattributeparcel.zzaOB, false);
        zzb.zza(parcel, 6, userattributeparcel.zzagS, false);
        zzb.zza(parcel, 7, userattributeparcel.zzaMl, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfA(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzig(i);
    }

    public UserAttributeParcel zzfA(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        long l = 0L;
        String s1 = null;
        Float float1 = null;
        Long long1 = null;
        String s2 = null;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 4: // '\004'
                    long1 = com.google.android.gms.common.internal.safeparcel.zza.zzj(parcel, k);
                    break;

                case 5: // '\005'
                    float1 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, k);
                    break;

                case 6: // '\006'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 7: // '\007'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new UserAttributeParcel(i, s2, l, long1, float1, s1, s);
            }
        } while (true);
    }

    public UserAttributeParcel[] zzig(int i)
    {
        return new UserAttributeParcel[i];
    }
}
