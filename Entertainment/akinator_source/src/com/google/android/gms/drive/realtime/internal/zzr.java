// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal:
//            ParcelableIndexReference

public class zzr
    implements android.os.Parcelable.Creator
{

    public zzr()
    {
    }

    static void zza(ParcelableIndexReference parcelableindexreference, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, parcelableindexreference.mVersionCode);
        zzb.zza(parcel, 2, parcelableindexreference.zzaoB, false);
        zzb.zzc(parcel, 3, parcelableindexreference.mIndex);
        zzb.zza(parcel, 4, parcelableindexreference.zzaoC);
        zzb.zzc(parcel, 5, parcelableindexreference.zzaoD);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcs(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzef(i);
    }

    public ParcelableIndexReference zzcs(Parcel parcel)
    {
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
        int i = -1;
        int j = 0;
        int k = 0;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new ParcelableIndexReference(k, s, j, flag, i);
            }
        } while (true);
    }

    public ParcelableIndexReference[] zzef(int i)
    {
        return new ParcelableIndexReference[i];
    }
}
