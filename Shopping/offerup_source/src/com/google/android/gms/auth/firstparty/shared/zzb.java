// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.auth.firstparty.shared:
//            FACLData, FACLConfig

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(FACLData facldata, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzaq(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, facldata.version);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, facldata.zzTD, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, facldata.zzTE, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, facldata.zzTF);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, facldata.zzTG, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzU(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaL(i);
    }

    public FACLData zzU(Parcel parcel)
    {
        boolean flag = false;
        String s = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        String s1 = null;
        FACLConfig faclconfig = null;
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
                    faclconfig = (FACLConfig)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, FACLConfig.CREATOR);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;

                case 4: // '\004'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j).toString(), parcel);
            } else
            {
                return new FACLData(i, faclconfig, s1, flag, s);
            }
        } while (true);
    }

    public FACLData[] zzaL(int i)
    {
        return new FACLData[i];
    }
}
