// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location.internal:
//            FusedLocationProviderResult

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(FusedLocationProviderResult fusedlocationproviderresult, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, fusedlocationproviderresult.getStatus(), i, false);
        zzb.zzc(parcel, 1000, fusedlocationproviderresult.getVersionCode());
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeG(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgY(i);
    }

    public FusedLocationProviderResult zzeG(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        Status status = null;
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
                    status = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Status.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new FusedLocationProviderResult(i, status);
            }
        } while (true);
    }

    public FusedLocationProviderResult[] zzgY(int i)
    {
        return new FusedLocationProviderResult[i];
    }
}
