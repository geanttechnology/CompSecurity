// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.internal:
//            OnListEntriesResponse

public class zzbd
    implements android.os.Parcelable.Creator
{

    public zzbd()
    {
    }

    static void zza(OnListEntriesResponse onlistentriesresponse, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, onlistentriesresponse.mVersionCode);
        zzb.zza(parcel, 2, onlistentriesresponse.zzamk, i, false);
        zzb.zza(parcel, 3, onlistentriesresponse.zzakB);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzby(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdk(i);
    }

    public OnListEntriesResponse zzby(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        DataHolder dataholder = null;
        int i = 0;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    dataholder = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataHolder.CREATOR);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new OnListEntriesResponse(i, dataholder, flag);
            }
        } while (true);
    }

    public OnListEntriesResponse[] zzdk(int i)
    {
        return new OnListEntriesResponse[i];
    }
}
