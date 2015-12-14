// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;

// Referenced classes of package com.google.android.gms.drive.realtime.internal:
//            ParcelableChangeInfo

public class zzp
    implements android.os.Parcelable.Creator
{

    public zzp()
    {
    }

    static void zza(ParcelableChangeInfo parcelablechangeinfo, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, parcelablechangeinfo.mVersionCode);
        zzb.zza(parcel, 2, parcelablechangeinfo.zzXR);
        zzb.zzc(parcel, 3, parcelablechangeinfo.zzoP, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcf(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzdU(i);
    }

    public ParcelableChangeInfo zzcf(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        long l = 0L;
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
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;

                case 3: // '\003'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, ParcelableEvent.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new ParcelableChangeInfo(i, l, arraylist);
            }
        } while (true);
    }

    public ParcelableChangeInfo[] zzdU(int i)
    {
        return new ParcelableChangeInfo[i];
    }
}
