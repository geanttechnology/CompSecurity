// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            UnsubscribeRequest

public class zzae
    implements android.os.Parcelable.Creator
{

    public zzae()
    {
    }

    static void zza(UnsubscribeRequest unsubscriberequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, unsubscriberequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, unsubscriberequest.getVersionCode());
        zzb.zza(parcel, 2, unsubscriberequest.getDataSource(), i, false);
        zzb.zza(parcel, 3, unsubscriberequest.zzsO(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdz(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfr(i);
    }

    public UnsubscribeRequest zzdz(Parcel parcel)
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
            break MISSING_BLOCK_LABEL_197;
        }
        k = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
        com.google.android.gms.common.internal.safeparcel.zza.zzbM(k);
        JVM INSTR lookupswitch 4: default 80
    //                   1: 109
    //                   2: 154
    //                   3: 177
    //                   1000: 133;
           goto _L1 _L2 _L3 _L4 _L5
_L4:
        break MISSING_BLOCK_LABEL_177;
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
        DataType datatype = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataType.CREATOR);
        obj = obj1;
        obj1 = datatype;
          goto _L8
_L5:
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
          goto _L8
_L3:
        DataSource datasource = (DataSource)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataSource.CREATOR);
        obj1 = obj;
        obj = datasource;
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
            return new UnsubscribeRequest(i, ((DataType) (obj)), ((DataSource) (obj1)), ibinder);
        }
    }

    public UnsubscribeRequest[] zzfr(int i)
    {
        return new UnsubscribeRequest[i];
    }
}
