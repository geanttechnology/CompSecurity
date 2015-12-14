// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.fitness.request:
//            ReadRawRequest, DataSourceQueryParams

public class zzq
    implements android.os.Parcelable.Creator
{

    public zzq()
    {
    }

    static void zza(ReadRawRequest readrawrequest, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zza(parcel, 1, readrawrequest.zzsc(), false);
        zzb.zzc(parcel, 1000, readrawrequest.getVersionCode());
        zzb.zza(parcel, 2, readrawrequest.getPackageName(), false);
        zzb.zzc(parcel, 3, readrawrequest.zzsn(), false);
        zzb.zza(parcel, 4, readrawrequest.zzsi());
        zzb.zza(parcel, 5, readrawrequest.zzsh());
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzda(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeT(i);
    }

    public ReadRawRequest zzda(Parcel parcel)
    {
        java.util.ArrayList arraylist = null;
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        boolean flag1 = false;
        String s = null;
        android.os.IBinder ibinder = null;
        int i = 0;
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

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, DataSourceQueryParams.CREATOR);
                    break;

                case 4: // '\004'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ReadRawRequest(i, ibinder, s, arraylist, flag1, flag);
            }
        } while (true);
    }

    public ReadRawRequest[] zzeT(int i)
    {
        return new ReadRawRequest[i];
    }
}
