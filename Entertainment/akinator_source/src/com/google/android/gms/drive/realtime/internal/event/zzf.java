// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            TextDeletedDetails

public class zzf
    implements android.os.Parcelable.Creator
{

    public zzf()
    {
    }

    static void zza(TextDeletedDetails textdeleteddetails, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, textdeleteddetails.mVersionCode);
        zzb.zzc(parcel, 2, textdeleteddetails.mIndex);
        zzb.zzc(parcel, 3, textdeleteddetails.zzapd);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcy(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzel(i);
    }

    public TextDeletedDetails zzcy(Parcel parcel)
    {
        int k = 0;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
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
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new TextDeletedDetails(i, j, k);
            }
        } while (true);
    }

    public TextDeletedDetails[] zzel(int i)
    {
        return new TextDeletedDetails[i];
    }
}
