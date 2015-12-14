// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg
    implements android.os.Parcelable.Creator
{

    public zzg()
    {
    }

    static void zza(Barcode.Email email, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, email.versionCode);
        zzb.zzc(parcel, 2, email.type);
        zzb.zza(parcel, 3, email.address, false);
        zzb.zza(parcel, 4, email.subject, false);
        zzb.zza(parcel, 5, email.body, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgs(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjw(i);
    }

    public Barcode.Email zzgs(Parcel parcel)
    {
        int i = 0;
        String s = null;
        int k = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        String s1 = null;
        String s2 = null;
        int j = 0;
        do
        {
            if (parcel.dataPosition() < k)
            {
                int l = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(l))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, l);
                    break;

                case 1: // '\001'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 2: // '\002'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, l);
                    break;

                case 3: // '\003'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 4: // '\004'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;

                case 5: // '\005'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, l);
                    break;
                }
            } else
            if (parcel.dataPosition() != k)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(k).toString(), parcel);
            } else
            {
                return new Barcode.Email(j, i, s2, s1, s);
            }
        } while (true);
    }

    public Barcode.Email[] zzjw(int i)
    {
        return new Barcode.Email[i];
    }
}
