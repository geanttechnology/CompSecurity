// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.nearby.bootstrap.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.nearby.bootstrap.request:
//            DisableTargetRequest

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(DisableTargetRequest disabletargetrequest, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zza(parcel, 1, disabletargetrequest.zzsc(), false);
        zzb.zzc(parcel, 1000, disabletargetrequest.versionCode);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfp(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhX(i);
    }

    public DisableTargetRequest zzfp(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        android.os.IBinder ibinder = null;
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
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
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
                return new DisableTargetRequest(i, ibinder);
            }
        } while (true);
    }

    public DisableTargetRequest[] zzhX(int i)
    {
        return new DisableTargetRequest[i];
    }
}
