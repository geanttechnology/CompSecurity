// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.games.internal.player:
//            MostRecentGameInfoEntity

public class MostRecentGameInfoEntityCreator
    implements android.os.Parcelable.Creator
{

    public MostRecentGameInfoEntityCreator()
    {
    }

    static void zza(MostRecentGameInfoEntity mostrecentgameinfoentity, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, mostrecentgameinfoentity.zzvw(), false);
        zzb.zzc(parcel, 1000, mostrecentgameinfoentity.getVersionCode());
        zzb.zza(parcel, 2, mostrecentgameinfoentity.zzvx(), false);
        zzb.zza(parcel, 3, mostrecentgameinfoentity.zzvy());
        zzb.zza(parcel, 4, mostrecentgameinfoentity.zzvz(), i, false);
        zzb.zza(parcel, 5, mostrecentgameinfoentity.zzvA(), i, false);
        zzb.zza(parcel, 6, mostrecentgameinfoentity.zzvB(), i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzec(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgh(i);
    }

    public MostRecentGameInfoEntity zzec(Parcel parcel)
    {
        Uri uri = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        long l = 0L;
        Uri uri1 = null;
        Uri uri2 = null;
        String s = null;
        String s1 = null;
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
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 4: // '\004'
                    uri2 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Uri.CREATOR);
                    break;

                case 5: // '\005'
                    uri1 = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Uri.CREATOR);
                    break;

                case 6: // '\006'
                    uri = (Uri)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Uri.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new MostRecentGameInfoEntity(i, s1, s, l, uri2, uri1, uri);
            }
        } while (true);
    }

    public MostRecentGameInfoEntity[] zzgh(int i)
    {
        return new MostRecentGameInfoEntity[i];
    }
}
