// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.maps.model:
//            Tile

public class zzn
    implements android.os.Parcelable.Creator
{

    public zzn()
    {
    }

    static void zza(Tile tile, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, tile.getVersionCode());
        zzb.zzc(parcel, 2, tile.width);
        zzb.zzc(parcel, 3, tile.height);
        zzb.zza(parcel, 4, tile.data, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfu(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhS(i);
    }

    public Tile zzfu(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        byte abyte0[] = null;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    abyte0 = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(l).toString(), parcel);
            } else
            {
                return new Tile(i, j, k, abyte0);
            }
        } while (true);
    }

    public Tile[] zzhS(int i)
    {
        return new Tile[i];
    }
}
