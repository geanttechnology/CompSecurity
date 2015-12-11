// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            SensorUnregistrationRequest

public class zzt
    implements android.os.Parcelable.Creator
{

    public zzt()
    {
    }

    static void zza(SensorUnregistrationRequest sensorunregistrationrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, sensorunregistrationrequest.zztf(), false);
        zzb.zzc(parcel, 1000, sensorunregistrationrequest.getVersionCode());
        zzb.zza(parcel, 2, sensorunregistrationrequest.zzta(), i, false);
        zzb.zza(parcel, 3, sensorunregistrationrequest.zzsO(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdo(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfg(i);
    }

    public SensorUnregistrationRequest zzdo(Parcel parcel)
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
        android.os.IBinder ibinder1 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
        obj = obj1;
        obj1 = ibinder1;
          goto _L8
_L5:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        PendingIntent pendingintent = (PendingIntent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, PendingIntent.CREATOR);
        obj1 = obj;
        obj = pendingintent;
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
            return new SensorUnregistrationRequest(i, ((android.os.IBinder) (obj)), ((PendingIntent) (obj1)), ibinder);
        }
    }

    public SensorUnregistrationRequest[] zzfg(int i)
    {
        return new SensorUnregistrationRequest[i];
    }
}
