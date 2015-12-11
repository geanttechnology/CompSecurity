// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.content.res.Configuration;
import android.content.res.Resources;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.common.view.util:
//            EbayCountryManager

public static class countryName
{
    public static class Comparator
        implements java.util.Comparator
    {

        private final Collator collator;

        public int compare(EbayCountryManager.CountryResources countryresources, EbayCountryManager.CountryResources countryresources1)
        {
            return collator.compare(countryresources.getCountryName(), countryresources1.getCountryName());
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((EbayCountryManager.CountryResources)obj, (EbayCountryManager.CountryResources)obj1);
        }

        public Comparator(Collator collator1)
        {
            collator = collator1;
        }
    }


    private static List allCountryResources;
    private static Locale allCountryResourcesLocale;
    private final String countryName;
    private final int flagResourceId;
    private final String serializedEbayCountry;

    private static void createCountryResources(Resources resources, String s, String s1, String s2)
    {
        int i = EbayCountryManager.access$000(resources, s, s1);
        resources = EbayCountryManager.access$100(resources, s, s1, s2);
        allCountryResources.add(new <init>(s, i, resources));
    }

    public static List getAvailableInstances(Resources resources)
    {
        com/ebay/common/view/util/EbayCountryManager$CountryResources;
        JVM INSTR monitorenter ;
        Locale locale = resources.getConfiguration().locale;
        if (allCountryResources != null && allCountryResourcesLocale != null && allCountryResourcesLocale.equals(locale))
        {
            break MISSING_BLOCK_LABEL_141;
        }
        allCountryResourcesLocale = locale;
        allCountryResources = new ArrayList();
        EbaySite ebaysite;
        for (Iterator iterator = EbaySite.getAvailableInstances().iterator(); iterator.hasNext(); createCountryResources(resources, EbayCountry.serialize(ebaysite), ebaysite.localeCountry, ebaysite.localeLanguage))
        {
            ebaysite = (EbaySite)iterator.next();
        }

        break MISSING_BLOCK_LABEL_100;
        resources;
        throw resources;
        String s;
        for (Iterator iterator1 = EbayCountryManager.getGbhCountryCodes().iterator(); iterator1.hasNext(); createCountryResources(resources, EbayCountry.serialize(s), s, null))
        {
            s = (String)iterator1.next();
        }

        resources = allCountryResources;
        com/ebay/common/view/util/EbayCountryManager$CountryResources;
        JVM INSTR monitorexit ;
        return resources;
    }

    public boolean belongsToCountry(EbayCountry ebaycountry)
    {
        return ebaycountry != null && ebaycountry.serialize().equals(serializedEbayCountry);
    }

    public EbayCountry getCountry()
    {
        return EbayCountry.deserialize(serializedEbayCountry);
    }

    public String getCountryName()
    {
        return countryName;
    }

    public int getFlagResourceId()
    {
        return flagResourceId;
    }

    public String toString()
    {
        return countryName;
    }

    private Comparator.collator(String s, int i, String s1)
    {
        serializedEbayCountry = s;
        flagResourceId = i;
        countryName = s1;
    }
}
