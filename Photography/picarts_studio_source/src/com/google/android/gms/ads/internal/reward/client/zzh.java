// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.reward.client:
//            RewardedVideoAdRequestParcel

public class zzh
    implements android.os.Parcelable.Creator
{

    public zzh()
    {
    }

    static void zza(RewardedVideoAdRequestParcel rewardedvideoadrequestparcel, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, rewardedvideoadrequestparcel.versionCode);
        zzb.zza(parcel, 2, rewardedvideoadrequestparcel.zzEn, i, false);
        zzb.zza(parcel, 3, rewardedvideoadrequestparcel.zzqh, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzn(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzJ(i);
    }

    public RewardedVideoAdRequestParcel[] zzJ(int i)
    {
        return new RewardedVideoAdRequestParcel[i];
    }

    public RewardedVideoAdRequestParcel zzn(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        AdRequestParcel adrequestparcel = null;
        int i = 0;
        String s = null;
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
                    adrequestparcel = (AdRequestParcel)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, AdRequestParcel.CREATOR);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new RewardedVideoAdRequestParcel(i, adrequestparcel, s);
            }
        } while (true);
    }
}
