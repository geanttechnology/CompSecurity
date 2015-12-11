// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.nautilus.domain:
//            EbaySite, EbayCurrency

public final class EbayCountry
    implements Parcelable
{
    private static final class Internal
    {

        static final Map instances;

        static 
        {
            instances = new HashMap();
            Iterator iterator = EbaySite.getAvailableInstances().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                EbaySite ebaysite = (EbaySite)iterator.next();
                EbayCountry ebaycountry = new EbayCountry(ebaysite);
                instances.put(ebaysite.localeCountry, ebaycountry);
                instances.put(ebaysite.idString, ebaycountry);
                if (EbayCountry.log.isLoggable)
                {
                    EbayCountry.log.log((new StringBuilder()).append("Created new country: ").append(ebaycountry).toString());
                }
            } while (true);
        }

        private Internal()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public EbayCountry createFromParcel(Parcel parcel)
        {
            return EbayCountry.deserialize(parcel.readString());
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public EbayCountry[] newArray(int i)
        {
            return new EbayCountry[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private static final Pattern LANGUAGE_CODE_PATTERN = Pattern.compile("[a-z]{2}");
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EbayCountry", 3, "eBay country class debug messages");
    private static final Set nonMetric = new HashSet(Arrays.asList(new String[] {
        "GB", "US", "HK"
    }));
    private final String countryCode;
    private final EbayCurrency currency;
    private final boolean isSite;
    public final EbaySite site;
    private final boolean usesMetric;

    private EbayCountry(EbaySite ebaysite)
    {
        boolean flag = true;
        super();
        site = ebaysite;
        countryCode = ebaysite.getLocale().getCountry();
        currency = EbayCurrency.getInstance(Currency.getInstance(ebaysite.getLocale()).getCurrencyCode());
        isSite = true;
        if (nonMetric.contains(countryCode))
        {
            flag = false;
        }
        usesMetric = flag;
    }


    private EbayCountry(String s)
    {
        boolean flag = false;
        super();
        String s1 = normalizeCountryCode(s);
        countryCode = s1;
        if (s1 == null)
        {
            log.logAsWarning((new StringBuilder()).append("Failed to create EbayCountry for country code: ").append(s).toString());
            currency = EbayCurrency.getInstance(s);
        } else
        {
            currency = EbayCurrency.getInstance(Currency.getInstance(new Locale("", s)).getCurrencyCode());
        }
        site = EbaySite.US;
        isSite = false;
        if (!nonMetric.contains(countryCode))
        {
            flag = true;
        }
        usesMetric = flag;
    }

    public static EbayCountry deserialize(String s)
    {
        EbaySite ebaysite = EbaySite.getInstanceFromId(s);
        if (ebaysite == null)
        {
            return getInstance(s);
        } else
        {
            return getInstance(ebaysite);
        }
    }

    public static EbayCountry getInstance(EbaySite ebaysite)
    {
        com/ebay/nautilus/domain/EbayCountry;
        JVM INSTR monitorenter ;
        if (ebaysite != null) goto _L2; else goto _L1
_L1:
        EbayCountry ebaycountry = null;
_L7:
        com/ebay/nautilus/domain/EbayCountry;
        JVM INSTR monitorexit ;
        return ebaycountry;
_L2:
        EbayCountry ebaycountry1 = (EbayCountry)Internal.instances.get(serialize(ebaysite));
        ebaycountry = ebaycountry1;
        if (ebaycountry1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        ebaysite.idInt;
        JVM INSTR lookupswitch 2: default 95
    //                   100: 68
    //                   215: 68;
           goto _L3 _L4 _L4
_L3:
        if (false)
        {
            if (false)
            {
            }
            break; /* Loop/switch isn't completed */
        }
          goto _L5
_L4:
        ebaycountry = (EbayCountry)Internal.instances.get(serialize(EbaySite.US));
        break; /* Loop/switch isn't completed */
        ebaysite;
        throw ebaysite;
_L5:
        ebaycountry = ebaycountry1;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public static EbayCountry getInstance(String s)
    {
        com/ebay/nautilus/domain/EbayCountry;
        JVM INSTR monitorenter ;
        s = getInstance(s, Locale.getDefault().getLanguage());
        com/ebay/nautilus/domain/EbayCountry;
        JVM INSTR monitorexit ;
        return s;
        s;
        throw s;
    }

    public static EbayCountry getInstance(String s, String s1)
    {
        com/ebay/nautilus/domain/EbayCountry;
        JVM INSTR monitorenter ;
        String s2 = normalizeCountryCode(s);
        if (s2 != null) goto _L2; else goto _L1
_L1:
        s = null;
_L4:
        com/ebay/nautilus/domain/EbayCountry;
        JVM INSTR monitorexit ;
        return s;
_L2:
        boolean flag;
        if (!"CA".equals(s2) && !"BE".equals(s2))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        flag = "fr".equals(normalizeLanguageCode(s1));
        if (!"CA".equals(s2))
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        s = getInstance(EbaySite.CAFR);
        continue; /* Loop/switch isn't completed */
        s = getInstance(EbaySite.CA);
        continue; /* Loop/switch isn't completed */
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = getInstance(EbaySite.FRBE);
        continue; /* Loop/switch isn't completed */
        s = getInstance(EbaySite.NLBE);
        continue; /* Loop/switch isn't completed */
        s1 = (EbayCountry)Internal.instances.get(s2);
        s = s1;
        if (s1 != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        s1 = new EbayCountry(s2);
        Internal.instances.put(s2, s1);
        s = s1;
        if (!log.isLoggable)
        {
            continue; /* Loop/switch isn't completed */
        }
        log.log((new StringBuilder()).append("Created new country: ").append(s1).toString());
        s = s1;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    public static final boolean isValidCountryCode(String s)
    {
        return normalizeCountryCode(s) != null;
    }

    public static final String normalizeCountryCode(String s)
    {
        String s1 = null;
        if (s != null)
        {
            try
            {
                s1 = s.trim().toUpperCase(Locale.US);
                Currency.getInstance(new Locale("", s1));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return null;
            }
        }
        return s1;
    }

    public static final String normalizeLanguageCode(String s)
    {
        Object obj = null;
        String s1 = obj;
        if (s != null)
        {
            s = LANGUAGE_CODE_PATTERN.matcher(s.trim().toLowerCase(Locale.US));
            s1 = obj;
            if (s.matches())
            {
                s1 = s.group();
            }
        }
        return s1;
    }

    public static String serialize(EbaySite ebaysite)
    {
        if (ebaysite == null)
        {
            return "";
        } else
        {
            return ebaysite.idString;
        }
    }

    public static String serialize(String s)
    {
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        return s1;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj instanceof EbayCountry)
        {
            return serialize().equals(((EbayCountry)obj).serialize());
        } else
        {
            return false;
        }
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public EbayCurrency getCurrency()
    {
        return currency;
    }

    public EbaySite getSite()
    {
        return site;
    }

    public String getSiteApiName()
    {
        return site.name;
    }

    public String getSiteCountryCode()
    {
        return site.getLocale().getCountry();
    }

    public EbayCurrency getSiteCurrency()
    {
        return site.getCurrency();
    }

    public String getSiteDomain()
    {
        return site.getDomain();
    }

    public String getSiteGlobalId()
    {
        return site.idString;
    }

    public int getSiteId()
    {
        return site.idInt;
    }

    public String getSiteLanguageCode()
    {
        return site.getLocale().getLanguage();
    }

    public Locale getSiteLocale()
    {
        return site.getLocale();
    }

    public int hashCode()
    {
        return serialize().hashCode();
    }

    public boolean isSite()
    {
        return isSite;
    }

    public String serialize()
    {
        if (isSite)
        {
            return serialize(site);
        } else
        {
            return serialize(countryCode);
        }
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append(":").append(countryCode).append("/").append(site.idString).toString();
    }

    public boolean usesMetric()
    {
        return usesMetric;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(serialize());
    }

}
