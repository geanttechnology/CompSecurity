// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            AdSizeParcel

public class zzi
    implements android.os.Parcelable.Creator
{

    public zzi()
    {
    }

    static void zza(AdSizeParcel adsizeparcel, Parcel parcel, int i)
    {
        int j = zzb.zzaq(parcel);
        zzb.zzc(parcel, 1, adsizeparcel.versionCode);
        zzb.zza(parcel, 2, adsizeparcel.zzte, false);
        zzb.zzc(parcel, 3, adsizeparcel.height);
        zzb.zzc(parcel, 4, adsizeparcel.heightPixels);
        zzb.zza(parcel, 5, adsizeparcel.zztf);
        zzb.zzc(parcel, 6, adsizeparcel.width);
        zzb.zzc(parcel, 7, adsizeparcel.widthPixels);
        zzb.zza(parcel, 8, adsizeparcel.zztg, i, false);
        zzb.zza(parcel, 9, adsizeparcel.zzth);
        zzb.zza(parcel, 10, adsizeparcel.zzti);
        zzb.zzI(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzc(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzl(i);
    }

    public AdSizeParcel zzc(Parcel parcel)
    {
        AdSizeParcel aadsizeparcel[] = null;
        boolean flag = false;
        int j1 = com.google.android.gms.common.internal.safeparcel.zza.zzap(parcel);
        boolean flag1 = false;
        int i = 0;
        int j = 0;
        boolean flag2 = false;
        int k = 0;
        int l = 0;
        String s = null;
        int i1 = 0;
        do
        {
            if (parcel.dataPosition() < j1)
            {
                int k1 = com.google.android.gms.common.internal.safeparcel.zza.zzao(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbM(k1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k1);
                    break;

                case 1: // '\001'
                    i1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 2: // '\002'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, k1);
                    break;

                case 3: // '\003'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 4: // '\004'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 5: // '\005'
                    flag2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k1);
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k1);
                    break;

                case 8: // '\b'
                    aadsizeparcel = (AdSizeParcel[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k1, AdSizeParcel.CREATOR);
                    break;

                case 9: // '\t'
                    flag1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k1);
                    break;

                case 10: // '\n'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, k1);
                    break;
                }
            } else
            if (parcel.dataPosition() != j1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder("Overread allowed size end=")).append(j1).toString(), parcel);
            } else
            {
                return new AdSizeParcel(i1, s, l, k, flag2, j, i, aadsizeparcel, flag1, flag);
            }
        } while (true);
    }

    public AdSizeParcel[] zzl(int i)
    {
        return new AdSizeParcel[i];
    }
}
