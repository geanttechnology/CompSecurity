// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zza;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            Barcode

public class zzb
    implements android.os.Parcelable.Creator
{

    public zzb()
    {
    }

    static void zza(Barcode barcode, Parcel parcel, int i)
    {
        int j = com.google.android.gms.common.internal.safeparcel.zzb.zzak(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, barcode.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, barcode.format);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, barcode.rawValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, barcode.displayValue, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, barcode.valueFormat);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, barcode.cornerPoints, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, barcode.email, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, barcode.phone, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, barcode.sms, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 10, barcode.wifi, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 11, barcode.url, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 12, barcode.geoPoint, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 13, barcode.calendarEvent, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 14, barcode.contactInfo, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 15, barcode.driverLicense, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzH(parcel, j);
    }

    public Object createFromParcel(Parcel parcel)
    {
        return zzgn(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzjr(i);
    }

    public Barcode zzgn(Parcel parcel)
    {
        int l = com.google.android.gms.common.internal.safeparcel.zza.zzaj(parcel);
        int k = 0;
        int j = 0;
        String s1 = null;
        String s = null;
        int i = 0;
        Point apoint[] = null;
        Barcode.Email email = null;
        Barcode.Phone phone = null;
        Barcode.Sms sms = null;
        Barcode.WiFi wifi = null;
        Barcode.UrlBookmark urlbookmark = null;
        Barcode.GeoPoint geopoint = null;
        Barcode.CalendarEvent calendarevent = null;
        Barcode.ContactInfo contactinfo = null;
        Barcode.DriverLicense driverlicense = null;
        do
        {
            if (parcel.dataPosition() < l)
            {
                int i1 = com.google.android.gms.common.internal.safeparcel.zza.zzai(parcel);
                switch (com.google.android.gms.common.internal.safeparcel.zza.zzbH(i1))
                {
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1);
                    break;

                case 1: // '\001'
                    k = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 2: // '\002'
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 3: // '\003'
                    s1 = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    break;

                case 4: // '\004'
                    s = com.google.android.gms.common.internal.safeparcel.zza.zzo(parcel, i1);
                    break;

                case 5: // '\005'
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i1);
                    break;

                case 6: // '\006'
                    apoint = (Point[])com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, i1, Point.CREATOR);
                    break;

                case 7: // '\007'
                    email = (Barcode.Email)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.Email.CREATOR);
                    break;

                case 8: // '\b'
                    phone = (Barcode.Phone)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.Phone.CREATOR);
                    break;

                case 9: // '\t'
                    sms = (Barcode.Sms)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.Sms.CREATOR);
                    break;

                case 10: // '\n'
                    wifi = (Barcode.WiFi)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.WiFi.CREATOR);
                    break;

                case 11: // '\013'
                    urlbookmark = (Barcode.UrlBookmark)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.UrlBookmark.CREATOR);
                    break;

                case 12: // '\f'
                    geopoint = (Barcode.GeoPoint)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.GeoPoint.CREATOR);
                    break;

                case 13: // '\r'
                    calendarevent = (Barcode.CalendarEvent)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.CalendarEvent.CREATOR);
                    break;

                case 14: // '\016'
                    contactinfo = (Barcode.ContactInfo)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.ContactInfo.CREATOR);
                    break;

                case 15: // '\017'
                    driverlicense = (Barcode.DriverLicense)com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, i1, Barcode.DriverLicense.CREATOR);
                    break;
                }
            } else
            if (parcel.dataPosition() != l)
            {
                throw new com.google.android.gms.common.internal.safeparcel.zza.zza((new StringBuilder()).append("Overread allowed size end=").append(l).toString(), parcel);
            } else
            {
                return new Barcode(k, j, s1, s, i, apoint, email, phone, sms, wifi, urlbookmark, geopoint, calendarevent, contactinfo, driverlicense);
            }
        } while (true);
    }

    public Barcode[] zzjr(int i)
    {
        return new Barcode[i];
    }
}
