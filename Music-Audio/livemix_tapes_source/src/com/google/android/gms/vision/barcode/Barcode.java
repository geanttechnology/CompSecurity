// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

// Referenced classes of package com.google.android.gms.vision.barcode:
//            zzb, zza, zzc, zzd, 
//            zze, zzf, zzg, zzh, 
//            zzi, zzj, zzk, zzl, 
//            zzm

public class Barcode
    implements SafeParcelable
{
    public static class Address
        implements SafeParcelable
    {

        public static final zza CREATOR = new zza();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String addressLines[];
        public int type;
        final int versionCode;

        public int describeContents()
        {
            zza zza1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zza zza1 = CREATOR;
            zza.zza(this, parcel, i);
        }


        public Address()
        {
            versionCode = 1;
        }

        public Address(int i, int j, String as[])
        {
            versionCode = i;
            type = j;
            addressLines = as;
        }
    }

    public static class CalendarDateTime
        implements SafeParcelable
    {

        public static final zzc CREATOR = new zzc();
        public int day;
        public int hours;
        public boolean isUtc;
        public int minutes;
        public int month;
        public String rawValue;
        public int seconds;
        final int versionCode;
        public int year;

        public int describeContents()
        {
            zzc zzc1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzc zzc1 = CREATOR;
            zzc.zza(this, parcel, i);
        }


        public CalendarDateTime()
        {
            versionCode = 1;
        }

        public CalendarDateTime(int i, int j, int k, int l, int i1, int j1, int k1, 
                boolean flag, String s)
        {
            versionCode = i;
            year = j;
            month = k;
            day = l;
            hours = i1;
            minutes = j1;
            seconds = k1;
            isUtc = flag;
            rawValue = s;
        }
    }

    public static class CalendarEvent
        implements SafeParcelable
    {

        public static final zzd CREATOR = new zzd();
        public String description;
        public CalendarDateTime end;
        public String location;
        public String organizer;
        public CalendarDateTime start;
        public String status;
        public String summary;
        final int versionCode;

        public int describeContents()
        {
            zzd zzd1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzd zzd1 = CREATOR;
            zzd.zza(this, parcel, i);
        }


        public CalendarEvent()
        {
            versionCode = 1;
        }

        public CalendarEvent(int i, String s, String s1, String s2, String s3, String s4, CalendarDateTime calendardatetime, 
                CalendarDateTime calendardatetime1)
        {
            versionCode = i;
            summary = s;
            description = s1;
            location = s2;
            organizer = s3;
            status = s4;
            start = calendardatetime;
            end = calendardatetime1;
        }
    }

    public static class ContactInfo
        implements SafeParcelable
    {

        public static final zze CREATOR = new zze();
        public Address addresses[];
        public Email emails[];
        public PersonName name;
        public String organization;
        public Phone phones[];
        public String title;
        public String urls[];
        final int versionCode;

        public int describeContents()
        {
            zze zze1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zze zze1 = CREATOR;
            zze.zza(this, parcel, i);
        }


        public ContactInfo()
        {
            versionCode = 1;
        }

        public ContactInfo(int i, PersonName personname, String s, String s1, Phone aphone[], Email aemail[], String as[], 
                Address aaddress[])
        {
            versionCode = i;
            name = personname;
            organization = s;
            title = s1;
            phones = aphone;
            emails = aemail;
            urls = as;
            addresses = aaddress;
        }
    }

    public static class DriverLicense
        implements SafeParcelable
    {

        public static final zzf CREATOR = new zzf();
        public String addressCity;
        public String addressState;
        public String addressStreet;
        public String addressZip;
        public String birthDate;
        public String documentType;
        public String expiryDate;
        public String firstName;
        public String gender;
        public String issueDate;
        public String issuingCountry;
        public String lastName;
        public String licenseNumber;
        public String middleName;
        final int versionCode;

        public int describeContents()
        {
            zzf zzf1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzf zzf1 = CREATOR;
            zzf.zza(this, parcel, i);
        }


        public DriverLicense()
        {
            versionCode = 1;
        }

        public DriverLicense(int i, String s, String s1, String s2, String s3, String s4, String s5, 
                String s6, String s7, String s8, String s9, String s10, String s11, String s12, 
                String s13)
        {
            versionCode = i;
            documentType = s;
            firstName = s1;
            middleName = s2;
            lastName = s3;
            gender = s4;
            addressStreet = s5;
            addressCity = s6;
            addressState = s7;
            addressZip = s8;
            licenseNumber = s9;
            issueDate = s10;
            expiryDate = s11;
            birthDate = s12;
            issuingCountry = s13;
        }
    }

    public static class Email
        implements SafeParcelable
    {

        public static final zzg CREATOR = new zzg();
        public static final int HOME = 2;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String address;
        public String body;
        public String subject;
        public int type;
        final int versionCode;

        public int describeContents()
        {
            zzg zzg1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzg zzg1 = CREATOR;
            zzg.zza(this, parcel, i);
        }


        public Email()
        {
            versionCode = 1;
        }

        public Email(int i, int j, String s, String s1, String s2)
        {
            versionCode = i;
            type = j;
            address = s;
            subject = s1;
            body = s2;
        }
    }

    public static class GeoPoint
        implements SafeParcelable
    {

        public static final zzh CREATOR = new zzh();
        public double lat;
        public double lng;
        final int versionCode;

        public int describeContents()
        {
            zzh zzh1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzh zzh1 = CREATOR;
            zzh.zza(this, parcel, i);
        }


        public GeoPoint()
        {
            versionCode = 1;
        }

        public GeoPoint(int i, double d, double d1)
        {
            versionCode = i;
            lat = d;
            lng = d1;
        }
    }

    public static class PersonName
        implements SafeParcelable
    {

        public static final zzi CREATOR = new zzi();
        public String first;
        public String formattedName;
        public String last;
        public String middle;
        public String prefix;
        public String pronunciation;
        public String suffix;
        final int versionCode;

        public int describeContents()
        {
            zzi zzi1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzi zzi1 = CREATOR;
            zzi.zza(this, parcel, i);
        }


        public PersonName()
        {
            versionCode = 1;
        }

        public PersonName(int i, String s, String s1, String s2, String s3, String s4, String s5, 
                String s6)
        {
            versionCode = i;
            formattedName = s;
            pronunciation = s1;
            prefix = s2;
            first = s3;
            middle = s4;
            last = s5;
            suffix = s6;
        }
    }

    public static class Phone
        implements SafeParcelable
    {

        public static final zzj CREATOR = new zzj();
        public static final int FAX = 3;
        public static final int HOME = 2;
        public static final int MOBILE = 4;
        public static final int UNKNOWN = 0;
        public static final int WORK = 1;
        public String number;
        public int type;
        final int versionCode;

        public int describeContents()
        {
            zzj zzj1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzj zzj1 = CREATOR;
            zzj.zza(this, parcel, i);
        }


        public Phone()
        {
            versionCode = 1;
        }

        public Phone(int i, int j, String s)
        {
            versionCode = i;
            type = j;
            number = s;
        }
    }

    public static class Sms
        implements SafeParcelable
    {

        public static final zzk CREATOR = new zzk();
        public String message;
        public String phoneNumber;
        final int versionCode;

        public int describeContents()
        {
            zzk zzk1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzk zzk1 = CREATOR;
            zzk.zza(this, parcel, i);
        }


        public Sms()
        {
            versionCode = 1;
        }

        public Sms(int i, String s, String s1)
        {
            versionCode = i;
            message = s;
            phoneNumber = s1;
        }
    }

    public static class UrlBookmark
        implements SafeParcelable
    {

        public static final zzl CREATOR = new zzl();
        public String title;
        public String url;
        final int versionCode;

        public int describeContents()
        {
            zzl zzl1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzl zzl1 = CREATOR;
            zzl.zza(this, parcel, i);
        }


        public UrlBookmark()
        {
            versionCode = 1;
        }

        public UrlBookmark(int i, String s, String s1)
        {
            versionCode = i;
            title = s;
            url = s1;
        }
    }

    public static class WiFi
        implements SafeParcelable
    {

        public static final zzm CREATOR = new zzm();
        public static final int OPEN = 1;
        public static final int WEP = 3;
        public static final int WPA = 2;
        public int encryptionType;
        public String password;
        public String ssid;
        final int versionCode;

        public int describeContents()
        {
            zzm zzm1 = CREATOR;
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            zzm zzm1 = CREATOR;
            zzm.zza(this, parcel, i);
        }


        public WiFi()
        {
            versionCode = 1;
        }

        public WiFi(int i, String s, String s1, int j)
        {
            versionCode = i;
            ssid = s;
            password = s1;
            encryptionType = j;
        }
    }


    public static final int CALENDAR_EVENT = 11;
    public static final int CODABAR = 8;
    public static final int CODE_128 = 1;
    public static final int CODE_39 = 2;
    public static final int CODE_93 = 4;
    public static final int CONTACT_INFO = 1;
    public static final zzb CREATOR = new zzb();
    public static final int DATA_MATRIX = 16;
    public static final int DRIVER_LICENSE = 12;
    public static final int EAN_13 = 32;
    public static final int EAN_8 = 64;
    public static final int EMAIL = 2;
    public static final int GEO = 10;
    public static final int ISBN = 3;
    public static final int ITF = 128;
    public static final int PDF417 = 2048;
    public static final int PHONE = 4;
    public static final int PRODUCT = 5;
    public static final int QR_CODE = 256;
    public static final int SMS = 6;
    public static final int TEXT = 7;
    public static final int UPC_A = 512;
    public static final int UPC_E = 1024;
    public static final int URL = 8;
    public static final int WIFI = 9;
    public CalendarEvent calendarEvent;
    public ContactInfo contactInfo;
    public Point cornerPoints[];
    public String displayValue;
    public DriverLicense driverLicense;
    public Email email;
    public int format;
    public GeoPoint geoPoint;
    public Phone phone;
    public String rawValue;
    public Sms sms;
    public UrlBookmark url;
    public int valueFormat;
    final int versionCode;
    public WiFi wifi;

    public Barcode()
    {
        versionCode = 1;
    }

    public Barcode(int i, int j, String s, String s1, int k, Point apoint[], Email email1, 
            Phone phone1, Sms sms1, WiFi wifi1, UrlBookmark urlbookmark, GeoPoint geopoint, CalendarEvent calendarevent, ContactInfo contactinfo, 
            DriverLicense driverlicense)
    {
        versionCode = i;
        format = j;
        rawValue = s;
        displayValue = s1;
        valueFormat = k;
        cornerPoints = apoint;
        email = email1;
        phone = phone1;
        sms = sms1;
        wifi = wifi1;
        url = urlbookmark;
        geoPoint = geopoint;
        calendarEvent = calendarevent;
        contactInfo = contactinfo;
        driverLicense = driverlicense;
    }

    public int describeContents()
    {
        zzb zzb1 = CREATOR;
        return 0;
    }

    public Rect getBoundingBox()
    {
        int k = 0x7fffffff;
        int j = 0x80000000;
        int i = 0;
        int l = 0x80000000;
        int i1 = 0x7fffffff;
        for (; i < cornerPoints.length; i++)
        {
            Point point = cornerPoints[i];
            i1 = Math.min(i1, point.x);
            l = Math.max(l, point.x);
            k = Math.min(k, point.y);
            j = Math.max(j, point.y);
        }

        return new Rect(i1, k, l, j);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb zzb1 = CREATOR;
        zzb.zza(this, parcel, i);
    }

}
