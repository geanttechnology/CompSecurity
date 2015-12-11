// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.DataType;

// Referenced classes of package com.google.android.gms.fitness.request:
//            ListSubscriptionsRequest

public class zzp
    implements android.os.Parcelable.Creator
{

    public zzp()
    {
    }

    static void zza(ListSubscriptionsRequest listsubscriptionsrequest, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zza(parcel, 1, listsubscriptionsrequest.getDataType(), i, false);
        zzb.zzc(parcel, 1000, listsubscriptionsrequest.getVersionCode());
        zzb.zza(parcel, 2, listsubscriptionsrequest.zzsO(), false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzdk(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzfb(i);
    }

    public ListSubscriptionsRequest zzdk(Parcel parcel)
    {
        android.os.IBinder ibinder = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        DataType datatype = null;
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
                    datatype = (DataType)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataType.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    ibinder = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ListSubscriptionsRequest(i, datatype, ibinder);
            }
        } while (true);
    }

    public ListSubscriptionsRequest[] zzfb(int i)
    {
        return new ListSubscriptionsRequest[i];
    }
}
