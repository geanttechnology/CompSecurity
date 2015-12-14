// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze
    implements android.os.Parcelable.Creator
{

    public zze()
    {
    }

    static void zza(Barcode.ContactInfo contactinfo, Parcel parcel, int i)
    {
        int j = zzb.zzak(parcel);
        zzb.zzc(parcel, 1, contactinfo.versionCode);
        zzb.zza(parcel, 2, contactinfo.name, i, false);
        zzb.zza(parcel, 3, contactinfo.organization, false);
        zzb.zza(parcel, 4, contactinfo.title, false);
        zzb.zza(parcel, 5, contactinfo.phones, i, false);
        zzb.zza(parcel, 6, contactinfo.emails, i, false);
        zzb.zza(parcel, 7, contactinfo.urls, false);
        zzb.zza(parcel, 8, contactinfo.addresses, i, false);
        zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgq(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzju(i);
    }

    public Barcode.ContactInfo zzgq(Parcel parcel)
    {
        Barcode.Address aaddress[] = null;
        int j = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int i = 0;
        String as[] = null;
        Barcode.Email aemail[] = null;
        Barcode.Phone aphone[] = null;
        String s = null;
        String s1 = null;
        Barcode.PersonName personname = null;
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
                    personname = (Barcode.PersonName)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, k, Barcode.PersonName.CREATOR);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, k);
                    break;

                case 5: // '\005'
                    aphone = (Barcode.Phone[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k, Barcode.Phone.CREATOR);
                    break;

                case 6: // '\006'
                    aemail = (Barcode.Email[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k, Barcode.Email.CREATOR);
                    break;

                case 7: // '\007'
                    as = com.google.android.gms.common.internal.safeparcel.zza.zzA(parcel, k);
                    break;

                case 8: // '\b'
                    aaddress = (Barcode.Address[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, k, Barcode.Address.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != j)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(j).toString(), parcel);
            } else
            {
                return new Barcode.ContactInfo(i, personname, s1, s, aphone, aemail, as, aaddress);
            }
        } while (true);
    }

    public Barcode.ContactInfo[] zzju(int i)
    {
        return new Barcode.ContactInfo[i];
    }
}
