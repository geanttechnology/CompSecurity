// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            ParcelableEventList, ParcelableEvent

public class zzd
    implements android.os.Parcelable.Creator
{

    public zzd()
    {
    }

    static void zza(ParcelableEventList parcelableeventlist, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parcelableeventlist.mVersionCode);
        zzb.zzc(parcel, 2, parcelableeventlist.zzoQ, false);
        zzb.zza(parcel, 3, parcelableeventlist.zzaoV, i, false);
        zzb.zza(parcel, 4, parcelableeventlist.zzaoW);
        zzb.zzb(parcel, 5, parcelableeventlist.zzaoX, false);
        zzb.zza(parcel, 6, parcelableeventlist.zzaoY, i, false);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcw(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzej(i);
    }

    public ParcelableEventList zzcw(Parcel parcel)
    {
        boolean flag = false;
        ParcelableChangeInfo parcelablechangeinfo = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        DataHolder dataholder = null;
        java.util.ArrayList arraylist1 = null;
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
                    arraylist1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, ParcelableEvent.CREATOR);
                    break;

                case 3: // '\003'
                    dataholder = (DataHolder)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, DataHolder.CREATOR);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, k);
                    break;

                case 6: // '\006'
                    parcelablechangeinfo = (ParcelableChangeInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, ParcelableChangeInfo.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ParcelableEventList(i, arraylist1, dataholder, flag, arraylist, parcelablechangeinfo);
            }
        } while (true);
    }

    public ParcelableEventList[] zzej(int i)
    {
        return new ParcelableEventList[i];
    }
}
