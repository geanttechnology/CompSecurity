// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.drive:
//            Permission

public class zzi
    implements android.os.Parcelable.Creator
{

    public zzi()
    {
    }

    static void zza(Permission permission, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, permission.mVersionCode);
        zzb.zza(parcel, 2, permission.zzqY(), false);
        zzb.zzc(parcel, 3, permission.zzqZ());
        zzb.zza(parcel, 4, permission.zzra(), false);
        zzb.zza(parcel, 5, permission.zzrb(), false);
        zzb.zzc(parcel, 6, permission.getRole());
        zzb.zza(parcel, 7, permission.zzrc());
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzaI(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzco(i);
    }

    public Permission zzaI(Parcel parcel)
    {
        String s = null;
        boolean flag = false;
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int i = 0;
        String s1 = null;
        int j = 0;
        String s2 = null;
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
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 4: // '\004'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i1);
                    break;

                case 6: // '\006'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 7: // '\007'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i1);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new Permission(k, s2, j, s1, s, i, flag);
            }
        } while (true);
    }

    public Permission[] zzco(int i)
    {
        return new Permission[i];
    }
}
