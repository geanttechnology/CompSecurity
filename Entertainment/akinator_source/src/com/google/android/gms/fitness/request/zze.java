// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSet;

// Referenced classes of package com.google.android.gms.fitness.request:
//            DataInsertRequest

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(DataInsertRequest datainsertrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, datainsertrequest.zzsA(), i, false);
        zzb.zzc(parcel, 1000, datainsertrequest.getVersionCode());
        zzb.zza(parcel, 2, datainsertrequest.zzsO(), false);
        zzb.zza(parcel, 4, datainsertrequest.zzsS());
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzda(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeR(i);
    }

    public DataInsertRequest zzda(Parcel parcel)
    {
        Object obj;
        Object obj1;
        int i;
        int j;
        boolean flag;
        obj1 = null;
        flag = false;
        j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        obj = null;
        i = 0;
_L7:
        int k;
        if (parcel.dataPosition() >= j)
        {
            break MISSING_BLOCK_LABEL_181;
        }
        k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
        com.google.android.gms.common.internal.safeparcel.zza.zzbM(k);
        JVM INSTR lookupswitch 4: default 80
    //                   1: 105
    //                   2: 146
    //                   4: 162
    //                   1000: 127;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_162;
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
        DataSet dataset = (DataSet)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataSet.CREATOR);
        obj = obj1;
        obj1 = dataset;
          goto _L8
_L5:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        android.os.IBinder ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
        obj1 = obj;
        obj = ibinder;
          goto _L8
        flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
        Object obj5 = obj;
        obj = obj1;
        obj1 = obj5;
          goto _L8
        if (parcel.dataPosition() != j)
        {
            throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
        } else
        {
            return new DataInsertRequest(i, ((DataSet) (obj)), ((android.os.IBinder) (obj1)), flag);
        }
    }

    public DataInsertRequest[] zzeR(int i)
    {
        return new DataInsertRequest[i];
    }
}
