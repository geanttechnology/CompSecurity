// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            EventParcel, EventParams

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(EventParcel eventparcel, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, eventparcel.versionCode);
        zzb.zza(parcel, 2, eventparcel.name, false);
        zzb.zza(parcel, 3, eventparcel.zzaMk, i, false);
        zzb.zza(parcel, 4, eventparcel.zzaMl, false);
        zzb.zza(parcel, 5, eventparcel.zzaMm);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfz(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzif(i);
    }

    public EventParcel zzfz(Parcel parcel)
    {
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        long l = 0L;
        EventParams eventparams = null;
        String s1 = null;
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
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 3: // '\003'
                    eventparams = (EventParams)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, EventParams.CREATOR);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 5: // '\005'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new EventParcel(i, s1, eventparams, s, l);
            }
        } while (true);
    }

    public EventParcel[] zzif(int i)
    {
        return new EventParcel[i];
    }
}
