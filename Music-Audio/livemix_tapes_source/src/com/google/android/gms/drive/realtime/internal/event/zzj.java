// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive.realtime.internal.event:
//            ValuesRemovedDetails

public class zzj
    implements android.os.Parcelable.Creator
{

    public zzj()
    {
    }

    static void zza(ValuesRemovedDetails valuesremoveddetails, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, valuesremoveddetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesremoveddetails.mIndex);
        zzb.zzc(parcel, 3, valuesremoveddetails.zzamf);
        zzb.zzc(parcel, 4, valuesremoveddetails.zzamg);
        zzb.zza(parcel, 5, valuesremoveddetails.zzamG, false);
        zzb.zzc(parcel, 6, valuesremoveddetails.zzamH);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzcr(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzeg(i);
    }

    public ValuesRemovedDetails zzcr(Parcel parcel)
    {
        int i = 0;
        int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s = null;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        do
        {
            if (parcel.dataPosition() < j1)
            {
                int k1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 2: // '\002'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 3: // '\003'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 4: // '\004'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k1);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j1).toString(), parcel);
            } else
            {
                return new ValuesRemovedDetails(i1, l, k, j, s, i);
            }
        } while (true);
    }

    public ValuesRemovedDetails[] zzeg(int i)
    {
        return new ValuesRemovedDetails[i];
    }
}
