// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf
    implements android.os.Parcelable.Creator
{

    public zzf()
    {
    }

    static void zza(Barcode.DriverLicense driverlicense, Parcel parcel, int i)
    {
        i = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, driverlicense.versionCode);
        zzb.zza(parcel, 2, driverlicense.documentType, false);
        zzb.zza(parcel, 3, driverlicense.firstName, false);
        zzb.zza(parcel, 4, driverlicense.middleName, false);
        zzb.zza(parcel, 5, driverlicense.lastName, false);
        zzb.zza(parcel, 6, driverlicense.gender, false);
        zzb.zza(parcel, 7, driverlicense.addressStreet, false);
        zzb.zza(parcel, 8, driverlicense.addressCity, false);
        zzb.zza(parcel, 9, driverlicense.addressState, false);
        zzb.zza(parcel, 10, driverlicense.addressZip, false);
        zzb.zza(parcel, 11, driverlicense.licenseNumber, false);
        zzb.zza(parcel, 12, driverlicense.issueDate, false);
        zzb.zza(parcel, 13, driverlicense.expiryDate, false);
        zzb.zza(parcel, 14, driverlicense.birthDate, false);
        zzb.zza(parcel, 15, driverlicense.issuingCountry, false);
        zzb.zzH(parcel, i);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgr(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjv(i);
    }

    public Barcode.DriverLicense zzgr(Parcel parcel)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String s13 = null;
        String s12 = null;
        String s11 = null;
        String s10 = null;
        String s9 = null;
        String s8 = null;
        String s7 = null;
        String s6 = null;
        String s5 = null;
        String s4 = null;
        String s3 = null;
        String s2 = null;
        String s1 = null;
        String s = null;
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
                    s13 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 3: // '\003'
                    s12 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    s11 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 5: // '\005'
                    s10 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 6: // '\006'
                    s9 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 7: // '\007'
                    s8 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 8: // '\b'
                    s7 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 9: // '\t'
                    s6 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 10: // '\n'
                    s5 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 11: // '\013'
                    s4 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 12: // '\f'
                    s3 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 13: // '\r'
                    s2 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 14: // '\016'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 15: // '\017'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Barcode.DriverLicense(i, s13, s12, s11, s10, s9, s8, s7, s6, s5, s4, s3, s2, s1, s);
            }
        } while (true);
    }

    public Barcode.DriverLicense[] zzjv(int i)
    {
        return new Barcode.DriverLicense[i];
    }
}
