// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.request:
//            LargeParcelTeleporter

public class zzl
    implements android.os.Parcelable.Creator
{

    public zzl()
    {
    }

    static void zza(LargeParcelTeleporter largeparcelteleporter, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, largeparcelteleporter.mVersionCode);
        zzb.zza(parcel, 2, largeparcelteleporter.zzFc, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzl(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzG(i);
    }

    public LargeParcelTeleporter[] zzG(int i)
    {
        return new LargeParcelTeleporter[i];
    }

    public LargeParcelTeleporter zzl(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        ParcelFileDescriptor parcelfiledescriptor = null;
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
                    parcelfiledescriptor = (ParcelFileDescriptor)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, ParcelFileDescriptor.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new LargeParcelTeleporter(i, parcelfiledescriptor);
            }
        } while (true);
    }
}
