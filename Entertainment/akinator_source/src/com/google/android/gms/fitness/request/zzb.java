// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.fitness.data.BleDevice;

// Referenced classes of package com.google.android.gms.fitness.request:
//            ClaimBleDeviceRequest

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(ClaimBleDeviceRequest claimbledevicerequest, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, claimbledevicerequest.getDeviceAddress(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, claimbledevicerequest.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, claimbledevicerequest.zzsN(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, claimbledevicerequest.zzsO(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcX(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeO(i);
    }

    public ClaimBleDeviceRequest zzcX(Parcel parcel)
    {
        android.os.IBinder ibinder;
        Object obj;
        Object obj1;
        int i;
        int j;
        ibinder = null;
        j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        i = 0;
        obj1 = null;
        obj = null;
_L7:
        int k;
        if (parcel.dataPosition() >= j)
        {
            break MISSING_BLOCK_LABEL_191;
        }
        k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
        com.google.android.gms.common.internal.safeparcel.zza.zzbM(k);
        JVM INSTR lookupswitch 4: default 80
    //                   1: 109
    //                   2: 148
    //                   3: 171
    //                   1000: 127;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_171;
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
        Object obj2 = obj1;
        obj1 = obj;
        obj = obj2;
_L8:
        Object obj3 = obj1;
        obj1 = obj;
        obj = obj3;
        if (true) goto _L7; else goto _L6
_L6:
        String s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
        obj = obj1;
        obj1 = s;
          goto _L8
_L5:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        BleDevice bledevice = (BleDevice)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, BleDevice.CREATOR);
        obj1 = obj;
        obj = bledevice;
          goto _L8
        ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L8
        if (parcel.dataPosition() != j)
        {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
        } else
        {
            return new ClaimBleDeviceRequest(i, ((String) (obj)), ((BleDevice) (obj1)), ibinder);
        }
    }

    public ClaimBleDeviceRequest[] zzeO(int i)
    {
        return new ClaimBleDeviceRequest[i];
    }
}
