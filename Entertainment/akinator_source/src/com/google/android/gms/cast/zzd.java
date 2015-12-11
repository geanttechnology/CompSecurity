// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.cast:
//            LaunchOptions

public class zzd
    implements android.os.Parcelable.Creator
{

    public zzd()
    {
    }

    static void zza(LaunchOptions launchoptions, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, launchoptions.getVersionCode());
        zzb.zza(parcel, 2, launchoptions.getRelaunchIfRunning());
        zzb.zza(parcel, 3, launchoptions.getLanguage(), false);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzZ(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaQ(i);
    }

    public LaunchOptions zzZ(Parcel parcel)
    {
        boolean flag = false;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s = null;
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
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 3: // '\003'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new LaunchOptions(i, flag, s);
            }
        } while (true);
    }

    public LaunchOptions[] zzaQ(int i)
    {
        return new LaunchOptions[i];
    }
}
