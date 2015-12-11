// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            UnclaimBleDeviceRequest

public class zzad
    implements android.os.Parcelable.Creator
{

    public zzad()
    {
    }

    static void zza(UnclaimBleDeviceRequest unclaimbledevicerequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1000, unclaimbledevicerequest.getVersionCode());
        zzb.zza(parcel, 2, unclaimbledevicerequest.getDeviceAddress(), false);
        zzb.zza(parcel, 3, unclaimbledevicerequest.zzsO(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdy(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfq(i);
    }

    public UnclaimBleDeviceRequest zzdy(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s = null;
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

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new UnclaimBleDeviceRequest(i, s, ibinder);
            }
        } while (true);
    }

    public UnclaimBleDeviceRequest[] zzfq(int i)
    {
        return new UnclaimBleDeviceRequest[i];
    }
}
