// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.safetynet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.safetynet:
//            AttestationData

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(AttestationData attestationdata, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, attestationdata.mVersionCode);
        zzb.zza(parcel, 2, attestationdata.getJwsResult(), false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgf(parcel);
    }

    public Object[] newArray(int i)
    {
        return zziU(i);
    }

    public AttestationData zzgf(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new AttestationData(i, s);
            }
        } while (true);
    }

    public AttestationData[] zziU(int i)
    {
        return new AttestationData[i];
    }
}
