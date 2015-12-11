// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.games.internal.game:
//            GameBadgeEntity

public class GameBadgeEntityCreator
    implements android.os.Parcelable.Creator
{

    public GameBadgeEntityCreator()
    {
    }

    static void zza(GameBadgeEntity gamebadgeentity, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, gamebadgeentity.getType());
        zzb.zzc(parcel, 1000, gamebadgeentity.getVersionCode());
        zzb.zza(parcel, 2, gamebadgeentity.getTitle(), false);
        zzb.zza(parcel, 3, gamebadgeentity.getDescription(), false);
        zzb.zza(parcel, 4, gamebadgeentity.getIconImageUri(), i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzea(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgc(i);
    }

    public GameBadgeEntity zzea(Parcel parcel)
    {
        int i = 0;
        Uri uri = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        String s1 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 1000: 
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, l);
                    break;

                case 4: // '\004'
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, l, Uri.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new GameBadgeEntity(j, i, s1, s, uri);
            }
        } while (true);
    }

    public GameBadgeEntity[] zzgc(int i)
    {
        return new GameBadgeEntity[i];
    }
}
