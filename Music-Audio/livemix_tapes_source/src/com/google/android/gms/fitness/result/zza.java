// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.result;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.BleDevice;

// Referenced classes of package com.google.android.gms.fitness.result:
//            BleDevicesResult

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(BleDevicesResult bledevicesresult, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, bledevicesresult.getClaimedBleDevices(), false);
        zzb.zzc(parcel, 1000, bledevicesresult.getVersionCode());
        zzb.zza(parcel, 2, bledevicesresult.getStatus(), i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdp(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfj(i);
    }

    public BleDevicesResult zzdp(Parcel parcel)
    {
        Status status = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        java.util.ArrayList arraylist = null;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, BleDevice.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    status = (Status)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Status.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new BleDevicesResult(i, arraylist, status);
            }
        } while (true);
    }

    public BleDevicesResult[] zzfj(int i)
    {
        return new BleDevicesResult[i];
    }
}
