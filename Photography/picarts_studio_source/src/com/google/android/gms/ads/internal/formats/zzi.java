// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.formats:
//            NativeAdOptionsParcel

public class zzi
    implements android.os.Parcelable.Creator
{

    public zzi()
    {
    }

    static void zza(NativeAdOptionsParcel nativeadoptionsparcel, Parcel parcel, int i)
    {
        i = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, nativeadoptionsparcel.versionCode);
        zzb.zza(parcel, 2, nativeadoptionsparcel.zzwR);
        zzb.zzc(parcel, 3, nativeadoptionsparcel.zzwS);
        zzb.zza(parcel, 4, nativeadoptionsparcel.zzwT);
        zzb.zzI(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zze(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzo(i);
    }

    public NativeAdOptionsParcel zze(Parcel parcel)
    {
        boolean flag1 = false;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        int j = 0;
        boolean flag = false;
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
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;

                case 3: // '\003'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 4: // '\004'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(k).toString(), parcel);
            } else
            {
                return new NativeAdOptionsParcel(i, flag, j, flag1);
            }
        } while (true);
    }

    public NativeAdOptionsParcel[] zzo(int i)
    {
        return new NativeAdOptionsParcel[i];
    }
}
