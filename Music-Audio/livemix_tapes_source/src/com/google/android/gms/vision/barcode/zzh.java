// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh
    implements android.os.Parcelable.Creator
{

    public zzh()
    {
    }

    static void zza(Barcode.GeoPoint geopoint, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, geopoint.versionCode);
        zzb.zza(parcel, 2, geopoint.lat);
        zzb.zza(parcel, 3, geopoint.lng);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgt(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjx(i);
    }

    public Barcode.GeoPoint zzgt(Parcel parcel)
    {
        double d = 0.0D;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        double d1 = 0.0D;
        do
        {
            if (parcel.dataPosition() < j)
            {
                int k = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(k))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k);
                    break;

                case 1: // '\001'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, k);
                    break;

                case 2: // '\002'
                    d1 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, k);
                    break;

                case 3: // '\003'
                    d = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Barcode.GeoPoint(i, d1, d);
            }
        } while (true);
    }

    public Barcode.GeoPoint[] zzjx(int i)
    {
        return new Barcode.GeoPoint[i];
    }
}
