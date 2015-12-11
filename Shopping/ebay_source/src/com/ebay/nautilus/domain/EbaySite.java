// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.ebay.nautilus.domain:
//            EbayCurrency

public final class EbaySite
    implements Parcelable
{
    private static final class Internal
    {

        static final Map domainToSiteMap;
        static final Map variousToSiteMap;

        static 
        {
            domainToSiteMap = new HashMap();
            variousToSiteMap = new HashMap();
            EbaySite aebaysite[] = new EbaySite[22];
            aebaysite[0] = EbaySite.AU;
            aebaysite[1] = EbaySite.AT;
            aebaysite[2] = EbaySite.NLBE;
            aebaysite[3] = EbaySite.FRBE;
            aebaysite[4] = EbaySite.CA;
            aebaysite[5] = EbaySite.CAFR;
            aebaysite[6] = EbaySite.MOTOR;
            aebaysite[7] = EbaySite.FR;
            aebaysite[8] = EbaySite.DE;
            aebaysite[9] = EbaySite.IN;
            aebaysite[10] = EbaySite.IE;
            aebaysite[11] = EbaySite.IT;
            aebaysite[12] = EbaySite.MY;
            aebaysite[13] = EbaySite.NL;
            aebaysite[14] = EbaySite.PH;
            aebaysite[15] = EbaySite.PL;
            aebaysite[16] = EbaySite.SG;
            aebaysite[17] = EbaySite.ES;
            aebaysite[18] = EbaySite.CH;
            aebaysite[19] = EbaySite.UK;
            aebaysite[20] = EbaySite.RU;
            aebaysite[21] = EbaySite.US;
            int j = aebaysite.length;
            for (int i = 0; i < j; i++)
            {
                EbaySite ebaysite = aebaysite[i];
                domainToSiteMap.put(ebaysite.domain, ebaysite);
                variousToSiteMap.put(ebaysite.name, ebaysite);
                variousToSiteMap.put(ebaysite.id, ebaysite);
                variousToSiteMap.put(ebaysite.idString, ebaysite);
            }

        }

        private Internal()
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
        public static final int RU = 215;
        public static final int SG = 216;
        public static final int UK = 3;
        public static final int US = 0;
    }


    public static final EbaySite AT = new EbaySite("ebay.at", "Austria", 16, "EBAY-AT", "AT", "de");
    public static final EbaySite AU = new EbaySite("ebay.com.au", "Australia", 15, "EBAY-AU", "AU", "en");
    public static final EbaySite CA = new EbaySite("ebay.ca", "Canada", 2, "EBAY-ENCA", "CA", "en");
    public static final EbaySite CAFR = new EbaySite("cafr.ebay.ca", "CanadaFrench", 210, "EBAY-FRCA", "CA", "fr");
    public static final EbaySite CH = new EbaySite("ebay.ch", "Switzerland", 193, "EBAY-CH", "CH", "de");
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbaySite createFromParcel(Parcel parcel)
        {
            return EbaySite.getInstanceFromId(parcel.readInt());
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
    public static final EbaySite DE = new EbaySite("ebay.de", "Germany", 77, "EBAY-DE", "DE", "de");
    public static final EbaySite ES = new EbaySite("ebay.es", "Spain", 186, "EBAY-ES", "ES", "es");
    public static final EbaySite FR = new EbaySite("ebay.fr", "France", 71, "EBAY-FR", "FR", "fr");
    public static final EbaySite FRBE = new EbaySite("befr.ebay.be", "Belgium_French", 23, "EBAY-FRBE", "BE", "fr");
    public static final EbaySite IE = new EbaySite("ebay.ie", "Ireland", 205, "EBAY-IE", "IE", "en");
    public static final EbaySite IN = new EbaySite("ebay.in", "India", 203, "EBAY-IN", "IN", "en");
    public static final EbaySite IT = new EbaySite("ebay.it", "Italy", 101, "EBAY-IT", "IT", "it");
    public static final EbaySite MOTOR = new EbaySite("ebay.com", "eBayMotors", 100, "EBAY-MOTOR", "US", "en");
    public static final EbaySite MY = new EbaySite("ebay.com.my", "Malaysia", 207, "EBAY-MY", "MY", "en");
    public static final EbaySite NL = new EbaySite("ebay.nl", "Netherlands", 146, "EBAY-NL", "NL", "nl");
    public static final EbaySite NLBE = new EbaySite("benl.ebay.be", "Belgium_Dutch", 123, "EBAY-NLBE", "BE", "nl");
    public static final EbaySite PH = new EbaySite("ebay.ph", "Philippines", 211, "EBAY-PH", "PH", "en");
    public static final EbaySite PL = new EbaySite("ebay.pl", "Poland", 212, "EBAY-PL", "PL", "pl");
    public static final EbaySite RU = new EbaySite("ebay.com", "Russia", 215, "EBAY-RU", "RU", "ru");
    public static final EbaySite SG = new EbaySite("ebay.com.sg", "Singapore", 216, "EBAY-SG", "SG", "en");
    public static final EbaySite UK = new EbaySite("ebay.co.uk", "UK", 3, "EBAY-GB", "GB", "en");
    public static final EbaySite US = new EbaySite("ebay.com", "US", 0, "EBAY-US", "US", "en");
    private final transient EbayCurrency currency;
    private final String domain;
    public final transient String id;
    public final int idInt;
    public final transient String idString;
    private final transient Locale locale;
    public final transient String localeCountry;
    public final transient String localeLanguage;
    public final transient String name;

    private EbaySite(String s, String s1, int i, String s2, String s3, String s4)
    {
        domain = s;
        name = s1;
        id = String.valueOf(i);
        idInt = i;
        idString = s2;
        localeCountry = s3;
        localeLanguage = s4;
        locale = new Locale(s4, s3);
        currency = EbayCurrency.getInstance(Currency.getInstance(locale).getCurrencyCode());
    }

    public static Collection getAvailableInstances()
    {
        return Internal.domainToSiteMap.values();
    }

    public static EbaySite getInstanceFromDomain(String s)
    {
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        return s;
_L2:
        String s1 = s.toLowerCase(Locale.getDefault());
label0:
        do
        {
label1:
            {
                if (s1.length() <= 0)
                {
                    break label1;
                }
                EbaySite ebaysite = (EbaySite)Internal.domainToSiteMap.get(s1);
                s = ebaysite;
                if (ebaysite != null)
                {
                    break label0;
                }
                int i = s1.indexOf(".");
                if (i < 0 || i + 1 >= s1.length())
                {
                    return null;
                }
                s1 = s1.substring(i + 1);
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public static EbaySite getInstanceFromDomain(String s, EbaySite ebaysite)
    {
        s = getInstanceFromDomain(s);
        if (s != null)
        {
            return s;
        } else
        {
            return ebaysite;
        }
    }

    public static EbaySite getInstanceFromId(int i)
    {
        switch (i)
        {
        default:
            return null;

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

        case 193: 
            return CH;

        case 3: // '\003'
            return UK;

        case 0: // '\0'
            return US;

        case 215: 
            return RU;
        }
    }

    public static EbaySite getInstanceFromId(String s)
    {
        return (EbaySite)Internal.variousToSiteMap.get(s);
    }

    public static EbaySite getInstanceFromMarketplaceId(com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum marketplaceidenum, String s, EbaySite ebaysite)
    {
        if (marketplaceidenum == null) goto _L2; else goto _L1
_L1:
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum = new int[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_US.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_AU.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_AT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_BE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_CA.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_MOTORS_US.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_FR.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_DE.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_IN.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_IE.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_IT.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_MY.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_NL.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_PH.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_PL.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_SG.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_ES.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_CH.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_GB.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$BaseListingType$MarketplaceIdEnum[com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum.EBAY_RU.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum[marketplaceidenum.ordinal()];
        JVM INSTR tableswitch 1 20: default 108
    //                   1 110
    //                   2 114
    //                   3 118
    //                   4 122
    //                   5 154
    //                   6 186
    //                   7 190
    //                   8 194
    //                   9 198
    //                   10 202
    //                   11 206
    //                   12 210
    //                   13 214
    //                   14 218
    //                   15 222
    //                   16 226
    //                   17 230
    //                   18 234
    //                   19 238
    //                   20 242;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17 _L18 _L19 _L20 _L21 _L22
_L2:
        return ebaysite;
_L3:
        return US;
_L4:
        return AU;
_L5:
        return AT;
_L6:
        if (s != null && (s.equalsIgnoreCase("fr_BE") || s.equalsIgnoreCase("fr-BE")))
        {
            return FRBE;
        } else
        {
            return NLBE;
        }
_L7:
        if (s != null && (s.equalsIgnoreCase("fr_CA") || s.equalsIgnoreCase("fr-CA")))
        {
            return CAFR;
        } else
        {
            return CA;
        }
_L8:
        return MOTOR;
_L9:
        return FR;
_L10:
        return DE;
_L11:
        return IN;
_L12:
        return IE;
_L13:
        return IT;
_L14:
        return MY;
_L15:
        return NL;
_L16:
        return PH;
_L17:
        return PL;
_L18:
        return SG;
_L19:
        return ES;
_L20:
        return CH;
_L21:
        return UK;
_L22:
        return RU;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof EbaySite)
            {
                if (idInt != ((EbaySite) (obj = (EbaySite)obj)).idInt)
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public EbayCurrency getCurrency()
    {
        return currency;
    }

    public String getDomain()
    {
        return domain;
    }

    public Locale getLocale()
    {
        return locale;
    }

    public String getViewItemUrl(long l)
    {
        return String.format(Locale.US, "http://www.%s/itm/%d", new Object[] {
            domain, Long.valueOf(l)
        });
    }

    public int hashCode()
    {
        return idInt;
    }

    public boolean isEuSite()
    {
        switch (idInt)
        {
        default:
            return false;

        case 3: // '\003'
        case 16: // '\020'
        case 23: // '\027'
        case 71: // 'G'
        case 77: // 'M'
        case 101: // 'e'
        case 123: // '{'
        case 146: 
        case 186: 
        case 193: 
        case 205: 
        case 212: 
            return true;
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append("Site:").append(name).toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(idInt);
    }


}
