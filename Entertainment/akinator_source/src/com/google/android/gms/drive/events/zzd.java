// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;

// Referenced classes of package com.google.android.gms.drive.events:
//            ChangesAvailableOptions

public class zzd
    implements android.os.Parcelable.Creator
{

    public zzd()
    {
    }

    static void zza(ChangesAvailableOptions changesavailableoptions, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, changesavailableoptions.mVersionCode);
        zzb.zzc(parcel, 2, changesavailableoptions.zzajy);
        zzb.zza(parcel, 3, changesavailableoptions.zzajz);
        zzb.zzc(parcel, 4, changesavailableoptions.zzajA, false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaN(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzct(i);
    }

    public ChangesAvailableOptions zzaN(Parcel parcel)
    {
        boolean flag = false;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        java.util.ArrayList arraylist = null;
        int j = 0;
        int i = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 3: // '\003'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 4: // '\004'
                    arraylist = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l, DriveSpace.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new ChangesAvailableOptions(i, j, flag, arraylist);
            }
        } while (true);
    }

    public ChangesAvailableOptions[] zzct(int i)
    {
        return new ChangesAvailableOptions[i];
    }
}
