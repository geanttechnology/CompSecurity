// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.wallet;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.wallet:
//            Address

public class zza
    implements android.os.Parcelable.Creator
{

    public zza()
    {
    }

    static void zza(Address address, Parcel parcel, int i)
    {
        i = zzb.zzM(parcel);
        zzb.zzc(parcel, 1, address.getVersionCode());
        zzb.zza(parcel, 2, address.name, false);
        zzb.zza(parcel, 3, address.zzapo, false);
        zzb.zza(parcel, 4, address.zzapp, false);
        zzb.zza(parcel, 5, address.zzapq, false);
        zzb.zza(parcel, 6, address.zzBc, false);
        zzb.zza(parcel, 7, address.zzaHQ, false);
        zzb.zza(parcel, 8, address.zzaHR, false);
        zzb.zza(parcel, 9, address.zzapv, false);
        zzb.zza(parcel, 10, address.zzapx, false);
        zzb.zza(parcel, 11, address.zzapy);
        zzb.zza(parcel, 12, address.zzapz, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzfi(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzhN(i);
    }

    public Address zzfi(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzL(parcel);
        int i = 0;
        String s9 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        boolean flag = false;
        String s = null;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzK(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzaV(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    s9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    s8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    s7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 5: // '\005'
                    s6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 6: // '\006'
                    s5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 7: // '\007'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 8: // '\b'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 9: // '\t'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 10: // '\n'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 11: // '\013'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k);
                    break;

                case 12: // '\f'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Address(i, s9, s8, s7, s6, s5, s4, s3, s2, s1, flag, s);
            }
        } while (true);
    }

    public Address[] zzhN(int i)
    {
        return new Address[i];
    }
}
