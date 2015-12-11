// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            StopBleScanRequest

public class zzab
    implements android.os.Parcelable.Creator
{

    public zzab()
    {
    }

    static void zza(StopBleScanRequest stopblescanrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, stopblescanrequest.zztk(), false);
        zzb.zzc(parcel, 1000, stopblescanrequest.getVersionCode());
        zzb.zza(parcel, 2, stopblescanrequest.zzsO(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdw(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfo(i);
    }

    public StopBleScanRequest zzdw(Parcel parcel)
    {
        android.os.IBinder ibinder1 = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        android.os.IBinder ibinder = null;
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
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    ibinder1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new StopBleScanRequest(i, ibinder, ibinder1);
            }
        } while (true);
    }

    public StopBleScanRequest[] zzfo(int i)
    {
        return new StopBleScanRequest[i];
    }
}
