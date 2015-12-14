// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.stats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.games.stats:
//            PlayerStatsEntity

public class PlayerStatsEntityCreator
    implements android.os.Parcelable.Creator
{

    public PlayerStatsEntityCreator()
    {
    }

    static void zza(PlayerStatsEntity playerstatsentity, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zza(parcel, 1, playerstatsentity.zzvd());
        zzb.zzc(parcel, 1000, playerstatsentity.getVersionCode());
        zzb.zza(parcel, 2, playerstatsentity.zzve());
        zzb.zzc(parcel, 3, playerstatsentity.zzvf());
        zzb.zzc(parcel, 4, playerstatsentity.zzvg());
        zzb.zzc(parcel, 5, playerstatsentity.zzvh());
        zzb.zza(parcel, 6, playerstatsentity.zzvi());
        zzb.zza(parcel, 7, playerstatsentity.zzvj());
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeg(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgq(i);
    }

    public PlayerStatsEntity zzeg(Parcel parcel)
    {
        int i = 0;
        float f = 0.0F;
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        float f1 = 0.0F;
        int j = 0;
        int k = 0;
        float f2 = 0.0F;
        float f3 = 0.0F;
        int l = 0;
        do
        {
            if (parcel.dataPosition() < i1)
            {
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(j1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, j1);
                    break;

                case 1: // '\001'
                    f3 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, j1);
                    break;

                case 1000: 
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 2: // '\002'
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, j1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, j1);
                    break;

                case 6: // '\006'
                    f1 = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, j1);
                    break;

                case 7: // '\007'
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, j1);
                    break;
                }
            } else
            if (parcel.dataPosition() != i1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(i1).toString(), parcel);
            } else
            {
                return new PlayerStatsEntity(l, f3, f2, k, j, i, f1, f);
            }
        } while (true);
    }

    public PlayerStatsEntity[] zzgq(int i)
    {
        return new PlayerStatsEntity[i];
    }
}
