// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc
    implements android.os.Parcelable.Creator
{

    public zzc()
    {
    }

    static void zza(Barcode.CalendarDateTime calendardatetime, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, calendardatetime.versionCode);
        zzb.zzc(parcel, 2, calendardatetime.year);
        zzb.zzc(parcel, 3, calendardatetime.month);
        zzb.zzc(parcel, 4, calendardatetime.day);
        zzb.zzc(parcel, 5, calendardatetime.hours);
        zzb.zzc(parcel, 6, calendardatetime.minutes);
        zzb.zzc(parcel, 7, calendardatetime.seconds);
        zzb.zza(parcel, 8, calendardatetime.isUtc);
        zzb.zza(parcel, 9, calendardatetime.rawValue, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgo(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjs(i);
    }

    public Barcode.CalendarDateTime zzgo(Parcel parcel)
    {
        boolean flag = false;
        int l1 = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s = null;
        int i = 0;
        int j = 0;
        int k = 0;
        int l = 0;
        int i1 = 0;
        int j1 = 0;
        int k1 = 0;
        do
        {
            if (parcel.dataPosition() < l1)
            {
                int i2 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(i2))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i2);
                    break;

                case 1: // '\001'
                    k1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 2: // '\002'
                    j1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 3: // '\003'
                    i1 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 4: // '\004'
                    l = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 5: // '\005'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 6: // '\006'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 7: // '\007'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i2);
                    break;

                case 8: // '\b'
                    flag = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i2);
                    break;

                case 9: // '\t'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i2);
                    break;
                }
            } else
            if (parcel.dataPosition() != l1)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l1).toString(), parcel);
            } else
            {
                return new Barcode.CalendarDateTime(k1, j1, i1, l, k, j, i, flag, s);
            }
        } while (true);
    }

    public Barcode.CalendarDateTime[] zzjs(int i)
    {
        return new Barcode.CalendarDateTime[i];
    }
}
