// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.location:
//            LocationSettingsRequest, LocationRequest

public class zzf
    implements android.os.Parcelable.Creator
{

    public zzf()
    {
    }

    static void zza(LocationSettingsRequest locationsettingsrequest, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, locationsettingsrequest.zztd(), false);
        zzb.zzc(parcel, 1000, locationsettingsrequest.getVersionCode());
        zzb.zza(parcel, 2, locationsettingsrequest.zzwx());
        zzb.zza(parcel, 3, locationsettingsrequest.zzwy());
        zzb.zza(parcel, 4, locationsettingsrequest.zzwz());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzeC(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzgS(i);
    }

    public LocationSettingsRequest zzeC(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        boolean flag1 = false;
        boolean flag2 = false;
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
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k, LocationRequest.CREATOR);
                    break;

                case 1000: 
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    flag2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 3: // '\003'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LocationSettingsRequest(i, arraylist, flag2, flag1, flag);
            }
        } while (true);
    }

    public LocationSettingsRequest[] zzgS(int i)
    {
        return new LocationSettingsRequest[i];
    }
}
