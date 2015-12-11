// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.cast;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.cast:
//            JoinOptions

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(JoinOptions joinoptions, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, joinoptions.getVersionCode());
        zzb.zzc(parcel, 2, joinoptions.getConnectionType());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzY(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaP(i);
    }

    public JoinOptions zzY(Parcel parcel)
    {
        int j = 0;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
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
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new JoinOptions(i, j);
            }
        } while (true);
    }

    public JoinOptions[] zzaP(int i)
    {
        return new JoinOptions[i];
    }
}
