// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;

// Referenced classes of package com.ebay.common.model:
//            EbayCurrency

public final class EbaySite
    implements Parcelable
{
    private static final class Mapping
    {

        static final HashMap mapSiteIdToSite;

        static 
        {
            EbaySite aebaysite[] = new EbaySite[23];
            aebaysite[0] = EbaySite.AU;
            aebaysite[1] = EbaySite.AT;
            aebaysite[2] = EbaySite.NLBE;
            aebaysite[3] = EbaySite.FRBE;
            aebaysite[4] = EbaySite.CA;
            aebaysite[5] = EbaySite.CAFR;
            aebaysite[6] = EbaySite.MOTOR;
            aebaysite[7] = EbaySite.FR;
            aebaysite[8] = EbaySite.DE;
            aebaysite[9] = EbaySite.HK;
            aebaysite[10] = EbaySite.IN;
            aebaysite[11] = EbaySite.IE;
            aebaysite[12] = EbaySite.IT;
            aebaysite[13] = EbaySite.MY;
            aebaysite[14] = EbaySite.NL;
            aebaysite[15] = EbaySite.PH;
            aebaysite[16] = EbaySite.PL;
            aebaysite[17] = EbaySite.SG;
            aebaysite[18] = EbaySite.ES;
            aebaysite[19] = EbaySite.SE;
            aebaysite[20] = EbaySite.CH;
            aebaysite[21] = EbaySite.UK;
            aebaysite[22] = EbaySite.US;
            HashMap hashmap = new HashMap(aebaysite.length * 3);
            int j = aebaysite.length;
            for (int i = 0; i < j; i++)
            {
                EbaySite ebaysite = aebaysite[i];
                hashmap.put(ebaysite.idString, ebaysite);
                hashmap.put(ebaysite.id, ebaysite);
                hashmap.put(ebaysite.name, ebaysite);
            }

            mapSiteIdToSite = hashmap;
        }

        private Mapping()
        {
        }
    }

    public static interface SITE_ID
    {

        public static final int AT = 16;
        public static final int AU = 15;
        public static final int CA = 2;
        public static final int CAFR = 210;
        public static final int CH = 193;
        public static final int DE = 77;
        public static final int ES = 186;
        public static final int FR = 71;
        public static final int FRBE = 23;
        public static final int HK = 201;
        public static final int IE = 205;
        public static final int IN = 203;
        public static final int IT = 101;
        public static final int MOTOR = 100;
        public static final int MY = 207;
        public static final int NL = 146;
        public static final int NLBE = 123;
        public static final int PH = 211;
        public static final int PL = 212;
        public static final int SE = 218;
        public static final int SG = 216;
        public static final int UK = 3;
        public static final int US = 0;
    }


    public static final EbaySite AT;
    public static final EbaySite AU;
    public static final EbaySite CA;
    public static final EbaySite CAFR;
    public static final EbaySite CH;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbaySite createFromParcel(Parcel parcel)
        {
            return EbaySite.getSiteFromId(parcel.readInt());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbaySite[] newArray(int i)
        {
            return new EbaySite[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final EbaySite DE;
    public static final EbaySite ES;
    public static final EbaySite FR;
    public static final EbaySite FRBE;
    public static final EbaySite HK;
    public static final EbaySite IE;
    public static final EbaySite IN;
    public static final EbaySite IT;
    public static final EbaySite MOTOR;
    public static final EbaySite MY;
    public static final EbaySite NL;
    public static final EbaySite NLBE;
    public static final EbaySite PH;
    public static final EbaySite PL;
    public static final EbaySite SE;
    public static final EbaySite SG;
    public static final EbaySite UK;
    public static final EbaySite US;
    public final EbayCurrency currency;
    public final String id;
    public final int idInt;
    public final String idString;
    public final String localeCountry;
    public final String localeLanguage;
    public final String name;

    private EbaySite(String s, int i, String s1, EbayCurrency ebaycurrency, String s2, String s3)
    {
        name = s;
        id = String.valueOf(i);
        idInt = i;
        idString = s1;
        currency = ebaycurrency;
        localeCountry = s2;
        localeLanguage = s3;
    }

    public static EbaySite getSiteFromId(int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("siteId");

        case 15: // '\017'
            return AU;

        case 16: // '\020'
            return AT;

        case 123: // '{'
            return NLBE;

        case 23: // '\027'
            return FRBE;

        case 2: // '\002'
            return CA;

        case 210: 
            return CAFR;

        case 100: // 'd'
            return MOTOR;

        case 71: // 'G'
            return FR;

        case 77: // 'M'
            return DE;

        case 201: 
            return HK;

        case 203: 
            return IN;

        case 205: 
            return IE;

        case 101: // 'e'
            return IT;

        case 207: 
            return MY;

        case 146: 
            return NL;

        case 211: 
            return PH;

        case 212: 
            return PL;

        case 216: 
            return SG;

        case 186: 
            return ES;

        case 218: 
            return SE;

        case 193: 
            return CH;

        case 3: // '\003'
            return UK;

        case 0: // '\0'
            return US;
        }
    }

    public static EbaySite getSiteFromId(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            return (EbaySite)Mapping.mapSiteIdToSite.get(s);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof EbaySite)
        {
            obj = (EbaySite)obj;
            flag = flag1;
            if (idInt == ((EbaySite) (obj)).idInt)
            {
                flag = true;
            }
        }
        return flag;
    }

    public int hashCode()
    {
        return idInt;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Site:").append(name).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(idInt);
    }

    static 
    {
        AU = new EbaySite("Australia", 15, "EBAY-AU", EbayCurrency.AUD, "AU", "en");
        AT = new EbaySite("Austria", 16, "EBAY-AT", EbayCurrency.EUR, "AT", "de");
        NLBE = new EbaySite("Belgium_Dutch", 123, "EBAY-NLBE", EbayCurrency.EUR, "BE", "nl");
        FRBE = new EbaySite("Belgium_French", 23, "EBAY-FRBE", EbayCurrency.EUR, "BE", "fr");
        CA = new EbaySite("Canada", 2, "EBAY-ENCA", EbayCurrency.CAD, "CA", "en");
        CAFR = new EbaySite("CanadaFrench", 210, "EBAY-FRCA", EbayCurrency.CAD, "CA", "fr");
        MOTOR = new EbaySite("eBayMotors", 100, "EBAY-MOTOR", EbayCurrency.USD, "MOTORS", "en");
        FR = new EbaySite("France", 71, "EBAY-FR", EbayCurrency.EUR, "FR", "fr");
        DE = new EbaySite("Germany", 77, "EBAY-DE", EbayCurrency.EUR, "DE", "de");
        HK = new EbaySite("HongKong", 201, "EBAY-HK", EbayCurrency.HKD, "HK", "zh");
        IN = new EbaySite("India", 203, "EBAY-IN", EbayCurrency.INR, "IN", "en");
        IE = new EbaySite("Ireland", 205, "EBAY-IE", EbayCurrency.EUR, "IE", "en");
        IT = new EbaySite("Italy", 101, "EBAY-IT", EbayCurrency.EUR, "IT", "it");
        MY = new EbaySite("Malaysia", 207, "EBAY-MY", EbayCurrency.MYR, "MY", "en");
        NL = new EbaySite("Netherlands", 146, "EBAY-NL", EbayCurrency.EUR, "NL", "nl");
        PH = new EbaySite("Philippines", 211, "EBAY-PH", EbayCurrency.PHP, "PH", "en");
        PL = new EbaySite("Poland", 212, "EBAY-PL", EbayCurrency.PLN, "PL", "pl");
        SG = new EbaySite("Singapore", 216, "EBAY-SG", EbayCurrency.SGD, "SG", "en");
        ES = new EbaySite("Spain", 186, "EBAY-ES", EbayCurrency.EUR, "ES", "es");
        SE = new EbaySite("Sweden", 218, "EBAY-SE", EbayCurrency.SEK, "SE", "sv");
        CH = new EbaySite("Switzerland", 193, "EBAY-CH", EbayCurrency.CHF, "CH", "de");
        UK = new EbaySite("UK", 3, "EBAY-GB", EbayCurrency.GBP, "GB", "en");
        US = new EbaySite("US", 0, "EBAY-US", EbayCurrency.USD, "US", "en");
    }
}
