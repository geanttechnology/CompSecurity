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
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, playerstatsentity.getAverageSessionLength());
        zzb.zzc(parcel, 1000, playerstatsentity.getVersionCode());
        zzb.zza(parcel, 2, playerstatsentity.zzvT());
        zzb.zzc(parcel, 3, playerstatsentity.getDaysSinceLastPlayed());
        zzb.zzc(parcel, 4, playerstatsentity.getNumberOfPurchases());
        zzb.zzc(parcel, 5, playerstatsentity.getNumberOfSessions());
        zzb.zza(parcel, 6, playerstatsentity.getSessionPercentile());
        zzb.zza(parcel, 7, playerstatsentity.getSpendPercentile());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzer(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgz(i);
    }

    public PlayerStatsEntity zzer(Parcel parcel)
    {
        int i = 0;
        float f = 0.0F;
        int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
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
                int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(j1))
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

    public PlayerStatsEntity[] zzgz(int i)
    {
        return new PlayerStatsEntity[i];
    }
}
