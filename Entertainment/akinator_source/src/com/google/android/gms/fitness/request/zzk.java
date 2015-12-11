// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DeleteAllUserDataRequest

public class zzk
    implements android.os.Parcelable.Creator
{

    public zzk()
    {
    }

    static void zza(DeleteAllUserDataRequest deletealluserdatarequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, deletealluserdatarequest.zzsO(), false);
        zzb.zzc(parcel, 1000, deletealluserdatarequest.getVersionCode());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdg(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeX(i);
    }

    public DeleteAllUserDataRequest zzdg(Parcel parcel)
    {
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
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new DeleteAllUserDataRequest(i, ibinder);
            }
        } while (true);
    }

    public DeleteAllUserDataRequest[] zzeX(int i)
    {
        return new DeleteAllUserDataRequest[i];
    }
}
