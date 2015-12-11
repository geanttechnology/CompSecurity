// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.model.UserDetail;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.kernel.NautilusKernel;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class EbayCountryManager
{
    public static class CountryResources
    {

        private static List allCountryResources;
        private static Locale allCountryResourcesLocale;
        private final String countryName;
        private final int flagResourceId;
        private final String serializedEbayCountry;

        private static void createCountryResources(Resources resources, String s, String s1, String s2)
        {
            int i = EbayCountryManager.getFlagResourceId(resources, s, s1);
            resources = EbayCountryManager.getCountryWithLanguageName(resources, s, s1, s2);
            allCountryResources.add(new CountryResources(s, i, resources));
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

        private CountryResources(String s, int i, String s1)
        {
            serializedEbayCountry = s;
            flagResourceId = i;
            countryName = s1;
        }
    }

    public static class CountryResources.Comparator
        implements java.util.Comparator
    {

        private final Collator collator;

        public int compare(CountryResources countryresources, CountryResources countryresources1)
        {
            return collator.compare(countryresources.getCountryName(), countryresources1.getCountryName());
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((CountryResources)obj, (CountryResources)obj1);
        }

        public CountryResources.Comparator(Collator collator1)
        {
            collator = collator1;
        }
    }

    public static class Default
    {

        private static String buyerRegFlowBaseUrl(EbayCountry ebaycountry)
        {
            if (NautilusKernel.isQaMode())
            {
                switch (ebaycountry.getSiteId())
                {
                default:
                    return "https://www.scgi.stratus.qa.ebay.com/reg/";

                case 16: // '\020'
                    return "https://scgi.at.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 193: 
                    return "https://scgi.ch.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 23: // '\027'
                    return "https://scgi.befr.be.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 205: 
                    return "https://scgi.ie.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 203: 
                    return "https://scgi.in.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 207: 
                    return "https://scgi.my.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 146: 
                    return "https://scgi.nl.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 123: // '{'
                    return "https://scgi.benl.be.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 211: 
                    return "https://scgi.ph.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 212: 
                    return "https://scgi.pl.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 216: 
                    return "https://scgi.sg.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 71: // 'G'
                    return "https://www.fr.scgi.stratus.qa.ebay.com/reg/";

                case 101: // 'e'
                    return "https://www.it.scgi.stratus.qa.ebay.com/reg/";

                case 186: 
                    return "https://www.es.scgi.stratus.qa.ebay.com/reg/";

                case 3: // '\003'
                    return "https://www.uk.scgi.stratus.qa.ebay.com/reg/";

                case 15: // '\017'
                    return "https://www.au.scgi.stratus.qa.ebay.com/reg/";

                case 2: // '\002'
                    return "https://www.ca.scgi.stratus.qa.ebay.com/reg/";

                case 210: 
                    return "https://www.cafr.scgi.stratus.qa.ebay.com/reg/";

                case 77: // 'M'
                    return "https://www.de.scgi.stratus.qa.ebay.com/reg/";

                case 0: // '\0'
                    return "https://www.scgi.stratus.qa.ebay.com/reg/";
                }
            }
            ebaycountry.getSiteId();
            JVM INSTR lookupswitch 9: default 328
        //                       0: 364
        //                       2: 364
        //                       3: 364
        //                       15: 364
        //                       71: 364
        //                       77: 364
        //                       101: 364
        //                       186: 364
        //                       210: 364;
               goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2
_L1:
            String s = "https://scgi.%s/ws/eBayISAPI.dll";
_L4:
            String s1 = ebaycountry.getSiteDomain();
            ebaycountry = s1;
            if (s1 == null)
            {
                ebaycountry = EbayCountry.getInstance("US").getSiteDomain();
            }
            return String.format(s, new Object[] {
                ebaycountry
            });
_L2:
            s = "https://reg.%s/reg/";
            if (true) goto _L4; else goto _L3
_L3:
        }

        public static String changePasswordUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry != null) goto _L2; else goto _L1
_L1:
            return null;
_L2:
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 0: // '\0'
                return "https://signin.ebay.com/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 15: // '\017'
                return "https://signin.ebay.com.au/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 16: // '\020'
                return "https://signin.ebay.at/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 2: // '\002'
                return "https://signin.ebay.ca/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 210: 
                return "https://signin.cafr.ebay.ca/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 71: // 'G'
                return "https://signin.ebay.fr/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 77: // 'M'
                return "https://signin.ebay.de/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 203: 
                return "https://signin.ebay.in/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 205: 
                return "https://signin.ebay.ie/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 101: // 'e'
                return "https://signin.ebay.it/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 207: 
                return "https://signin.ebay.com.my/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 146: 
                return "https://signin.ebay.nl/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 211: 
                return "https://signin.ebay.ph/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 212: 
                return "https://signin.ebay.pl/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 216: 
                return "https://signin.ebay.com.sg/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 186: 
                return "https://signin.ebay.es/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 193: 
                return "https://signin.ebay.ch/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 3: // '\003'
                return "https://signin.ebay.co.uk/ws/eBayISAPI.dll?ChangePasswordAndCreateHint";

            case 23: // '\027'
            case 123: // '{'
                break;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public static String dealsUrl(EbayCountry ebaycountry)
        {
            return null;
        }

        public static String dealsUrlScope(EbayCountry ebaycountry)
        {
            return null;
        }

        public static String eBayNowTermsOfServiceUrlFormat(EbayCountry ebaycountry)
        {
            if (ebaycountry == null || ebaycountry.site == null)
            {
                return null;
            }
            switch (ebaycountry.getSiteId())
            {
            case 1: // '\001'
            case 2: // '\002'
            default:
                return null;

            case 0: // '\0'
                return "http://pages.ebay.com/ebaynow/terms.html?lang=%s";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/scheduleddelivery/index.html?lang=%s";
            }
        }

        public static String ebayGivingCharityInfoUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            } else
            {
                ebaycountry.getSiteId();
                return "http://donations.ebay.com/charity/charity.jsp?NP_ID=";
            }
        }

        public static String ebayGivingLearnMoreUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            } else
            {
                ebaycountry.getSiteId();
                return "http://givingworks.ebay.com/about.html";
            }
        }

        public static String ebayGivingWorksCreditFeesUrl(EbayCountry ebaycountry)
        {
            switch (ebaycountry.getSiteId())
            {
            default:
                return "http://pages.ebay.com/help/sell/GivingWorks-fee-policy.html";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/help/sell/charity-fee-credits.html";
            }
        }

        public static String ebayGivingWorksTnCUrl(EbayCountry ebaycountry)
        {
            switch (ebaycountry.getSiteId())
            {
            default:
                return "http://givingworks.ebay.com/terms-and-conditions/";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/ebayforcharity/termsandconditions.html";
            }
        }

        public static String feedUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry != null)
            {
                if ((ebaycountry = ebaycountry.getSiteDomain()) != null)
                {
                    return String.format("http://m.%s/mweb/feed?_mode=high", new Object[] {
                        ebaycountry
                    });
                }
            }
            return null;
        }

        public static String forgotPasswordUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return "https://scgi.ebay.com/ws/eBayISAPI.dll?FYPShow";

            case 15: // '\017'
                return "https://scgi.ebay.com.au/ws/eBayISAPI.dll?FYPShow";

            case 16: // '\020'
                return "https://scgi.ebay.at/ws/eBayISAPI.dll?FYPShow";

            case 123: // '{'
                return "https://scgi.benl.ebay.be/ws/eBayISAPI.dll?FYPShow";

            case 23: // '\027'
                return "https://scgi.befr.ebay.be/ws/eBayISAPI.dll?FYPShow";

            case 2: // '\002'
                return "https://scgi.ebay.ca/ws/eBayISAPI.dll?FYPShow";

            case 210: 
                return "https://scgi.cafr.ebay.ca/ws/eBayISAPI.dll?FYPShow";

            case 71: // 'G'
                return "https://scgi.ebay.fr/ws/eBayISAPI.dll?FYPShow";

            case 77: // 'M'
                return "https://scgi.ebay.de/ws/eBayISAPI.dll?FYPShow";

            case 203: 
                return "https://scgi.ebay.in/ws/eBayISAPI.dll?FYPShow";

            case 205: 
                return "https://scgi.ebay.ie/ws/eBayISAPI.dll?FYPShow";

            case 101: // 'e'
                return "https://scgi.ebay.it/ws/eBayISAPI.dll?FYPShow";

            case 207: 
                return "https://scgi.ebay.com.my/ws/eBayISAPI.dll?FYPShow";

            case 146: 
                return "https://scgi.ebay.nl/ws/eBayISAPI.dll?FYPShow";

            case 211: 
                return "https://scgi.ebay.ph/ws/eBayISAPI.dll?FYPShow";

            case 212: 
                return "https://scgi.ebay.pl/ws/eBayISAPI.dll?FYPShow";

            case 216: 
                return "https://scgi.ebay.com.sg/ws/eBayISAPI.dll?FYPShow";

            case 186: 
                return "https://scgi.ebay.es/ws/eBayISAPI.dll?FYPShow";

            case 193: 
                return "https://scgi.ebay.ch/ws/eBayISAPI.dll?FYPShow";

            case 3: // '\003'
                return "https://scgi.ebay.co.uk/ws/eBayISAPI.dll?FYPShow";
            }
        }

        public static String forgotUserUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return "https://scgi.ebay.com/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 15: // '\017'
                return "https://scgi.ebay.com.au/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 16: // '\020'
                return "https://scgi.ebay.at/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 123: // '{'
                return "https://scgi.benl.ebay.be/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 23: // '\027'
                return "https://scgi.befr.ebay.be/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 2: // '\002'
                return "https://scgi.ebay.ca/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 210: 
                return "https://scgi.cafr.ebay.ca/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 71: // 'G'
                return "https://scgi.ebay.fr/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 77: // 'M'
                return "https://scgi.ebay.de/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 203: 
                return "https://scgi.ebay.in/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 205: 
                return "https://scgi.ebay.ie/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 101: // 'e'
                return "https://scgi.ebay.it/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 207: 
                return "https://scgi.ebay.com.my/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 146: 
                return "https://scgi.ebay.nl/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 211: 
                return "https://scgi.ebay.ph/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 212: 
                return "https://scgi.ebay.pl/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 216: 
                return "https://scgi.ebay.com.sg/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 186: 
                return "https://scgi.ebay.es/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 193: 
                return "https://scgi.ebay.ch/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 3: // '\003'
                return "https://scgi.ebay.co.uk/ws/eBayISAPI.dll?UserIdRecognizerShow";

            case 0: // '\0'
                return "https://scgi.ebay.com/ws/eBayISAPI.dll?UserIdRecognizerShow";
            }
        }

        public static String fpaRegistrationUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            String s = buyerRegFlowBaseUrl(ebaycountry);
            switch (ebaycountry.getSiteId())
            {
            default:
                return (new StringBuilder()).append(s).append("?RegisterEnterInfo").toString();

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 71: // 'G'
            case 77: // 'M'
            case 101: // 'e'
            case 186: 
            case 210: 
                return (new StringBuilder()).append(s).append("FullReg").toString();
            }
        }

        public static String getBuyerGspTermsAndConditionsDefault(EbaySite ebaysite)
        {
            switch (ebaysite.idInt)
            {
            default:
                return "http://pages.ebay.com/shipping/globalshipping/buyer-tnc.html";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/shipping/globalshipping/buyer-tnc.html#programfees";

            case 205: 
                return "http://pages.ebay.ie/shipping/globalshipping/buyer-tnc.html#programfees";

            case 146: 
                return "http://pages.ebay.nl/shipping/globalshipping/buyer-tnc.html#programfees";

            case 123: // '{'
                return "http://pages.benl.ebay.be/shipping/globalshipping/buyer-tnc.html#programfees";

            case 71: // 'G'
                return "http://pages.ebay.fr/shipping/globalshipping/buyer-tnc.html#programfees";

            case 23: // '\027'
                return "http://pages.befr.ebay.be/shipping/globalshipping/buyer-tnc.html#programfees";

            case 212: 
                return "http://pages.ebay.pl/shipping/globalshipping/buyer-tnc.html#programfees";

            case 101: // 'e'
                return "http://pages.ebay.it/shipping/globalshipping/buyer-tnc.html#programfees";

            case 16: // '\020'
            case 77: // 'M'
                return "http://pages.ebay.de/shipping/globalshipping/buyer-tnc.html#programfees";

            case 193: 
                return "http://pages.ebay.ch/shipping/globalshipping/buyer-tnc.html#programfees";

            case 186: 
                return "http://pages.ebay.es/shipping/globalshipping/buyer-tnc.html";

            case 15: // '\017'
                return "http://pages.ebay.com.au/shipping/globalshipping/buyer-tnc.html";

            case 2: // '\002'
                return "http://pages.ebay.ca/shipping/globalshipping/buyer-tnc.html";

            case 210: 
                return "http://pages.cafr.ebay.ca/shipping/globalshipping/buyer-tnc.html";
            }
        }

        public static String getEndItemEarlyUrlDefault(EbaySite ebaysite)
        {
            switch (ebaysite.idInt)
            {
            default:
                return "http://pages.ebay.com/help/sell/end_early.html";

            case 77: // 'M'
                return "http://pages.ebay.de/help/sell/end_early.html";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/help/sell/end_early.html";
            }
        }

        public static String getEulaLearnMoreUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return "http://pages.ebay.com/ebaypaypalupdates";
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return "http://pages.ebay.com/ebaypaypalupdates";

            case 0: // '\0'
                return getEulaLearnMoreUrlGbh(ebaycountry);

            case 2: // '\002'
                return "http://pages.ebay.ca/ebaypaypalupdates";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/ebaypaypalupdates";

            case 15: // '\017'
                return "http://pages.ebay.com.au/ebaypaypalupdates";

            case 16: // '\020'
                return "http://pages.ebay.at/ebaypaypalupdates";

            case 23: // '\027'
                return "http://pages.befr.ebay.be/ebaypaypalupdates";

            case 71: // 'G'
                return "http://pages.ebay.fr/ebaypaypalupdates";

            case 77: // 'M'
                return "http://pages.ebay.de/ebaypaypalupdates";

            case 101: // 'e'
                return "http://pages.ebay.it/ebaypaypalupdates";

            case 123: // '{'
                return "http://pages.benl.ebay.be/ebaypaypalupdates";

            case 146: 
                return "http://pages.ebay.nl/ebaypaypalupdates";

            case 186: 
                return "http://pages.ebay.es/ebaypaypalupdates";

            case 193: 
                return "http://pages.ebay.ch/ebaypaypalupdates";

            case 201: 
                return "http://pages.ebay.com.hk/ebaypaypalupdates";

            case 203: 
                return "http://pages.ebay.in/ebaypaypalupdates";

            case 205: 
                return "http://pages.ebay.ie/ebaypaypalupdates";

            case 207: 
                return "http://pages.ebay.com.my/ebaypaypalupdates";

            case 210: 
                return "http://pages.cafr.ebay.ca/ebaypaypalupdates";

            case 211: 
                return "http://pages.ebay.ph/ebaypaypalupdates";

            case 212: 
                return "http://pages.ebay.pl/ebaypaypalupdates";

            case 216: 
                return "http://pages.ebay.com.sg/ebaypaypalupdates";
            }
        }

        private static String getEulaLearnMoreUrlGbh(EbayCountry ebaycountry)
        {
            byte byte0;
            ebaycountry = ebaycountry.getCountryCode();
            byte0 = -1;
            ebaycountry.hashCode();
            JVM INSTR lookupswitch 3: default 44
        //                       2128: 91
        //                       2156: 106
        //                       2627: 76;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_106;
_L5:
            switch (byte0)
            {
            default:
                return "http://pages.ebay.com/ebaypaypalupdates";

            case 0: // '\0'
                return "http://pages.ebay.com/ru/ru-ru/ebaypaypalupdates";

            case 1: // '\001'
                return "http://pages.ebay.com/br/pt-br/ebaypaypalupdates";

            case 2: // '\002'
                return "http://pages.ebay.com/co/es-co/ebaypaypalupdates";
            }
_L4:
            if (ebaycountry.equals("RU"))
            {
                byte0 = 0;
            }
              goto _L5
_L2:
            if (ebaycountry.equals("BR"))
            {
                byte0 = 1;
            }
              goto _L5
            if (ebaycountry.equals("CO"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        public static String getEulaUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return MyApp.getApp().getResources().getString(0x7f070ce0);
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return MyApp.getApp().getResources().getString(0x7f070ce0);

            case 16: // '\020'
                return "http://pages.ebay.at/help/policies/user-agreement.html?rt=nc";

            case 15: // '\017'
                return "http://pages.ebay.com.au/help/policies/user-agreement.html?rt=nc";

            case 2: // '\002'
                return "http://pages.ebay.ca/help/policies/user-agreement.html?rt=nc";

            case 210: 
                return "http://pages.cafr.ebay.ca/help/policies/user-agreement.html?rt=nc";

            case 193: 
                return "http://pages.ebay.ch/help/policies/user-agreement.html?rt=nc";

            case 77: // 'M'
                return "http://pages.ebay.de/help/policies/user-agreement.html?rt=nc";

            case 186: 
                return "http://pages.ebay.es/help/policies/user-agreement.html?rt=nc";

            case 71: // 'G'
                return "http://pages.ebay.fr/help/policies/user-agreement.html?rt=nc";

            case 23: // '\027'
                return "http://pages.befr.ebay.be/help/policies/user-agreement.html?rt=nc";

            case 201: 
                return "http://pages.ebay.com.hk/help/policies/user-agreement.html?rt=nc";

            case 205: 
                return "http://pages.ebay.ie/help/policies/user-agreement.html?rt=nc";

            case 203: 
                return "http://pages.ebay.in/help/policies/user-agreement.html?rt=nc";

            case 101: // 'e'
                return "http://pages.ebay.it/help/policies/user-agreement.html?rt=nc";

            case 207: 
                return "http://pages.ebay.com.my/help/policies/user-agreement.html?rt=nc";

            case 146: 
                return "http://pages.ebay.nl/help/policies/user-agreement.html?rt=nc";

            case 123: // '{'
                return "http://pages.benl.ebay.be/help/policies/user-agreement.html?rt=nc";

            case 211: 
                return "http://pages.ebay.ph/help/policies/user-agreement.html?rt=nc";

            case 212: 
                return "http://pages.ebay.pl/help/policies/user-agreement.html?rt=nc";

            case 215: 
                return "http://pages.ebay.com/ru/ru-ru/help/policies/user-agreement.html?rt=nc";

            case 216: 
                return "http://pages.ebay.com.sg/help/policies/user-agreement.html?rt=nc";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/help/policies/user-agreement.html?rt=nc";
            }
        }

        public static String getOcsUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            int i = ebaycountry.getSiteId();
            if (NautilusKernel.isQaMode())
            {
                switch (i)
                {
                default:
                    return null;

                case 0: // '\0'
                    return "https://www.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 16: // '\020'
                    return "https://www.at.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 15: // '\017'
                    return "https://www.au.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 2: // '\002'
                    return "https://www.ca.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 210: 
                    return "https://www.cafr.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 77: // 'M'
                    return "https://www.de.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 186: 
                    return "https://www.es.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 71: // 'G'
                    return "https://www.fr.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 203: 
                    return "https://www.in.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 101: // 'e'
                    return "https://www.it.ocsnext.stratus.qa.ebay.com/ocs/home";

                case 3: // '\003'
                    return "https://www.uk.ocsnext.stratus.qa.ebay.com/ocs/home";
                }
            }
            switch (i)
            {
            default:
                return null;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 16: // '\020'
            case 71: // 'G'
            case 77: // 'M'
            case 101: // 'e'
            case 186: 
            case 203: 
            case 210: 
                return String.format("https://ocsnext.%s/ocs/home", new Object[] {
                    ebaycountry.getSiteDomain()
                });
            }
        }

        public static String getPrivacyUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return MyApp.getApp().getResources().getString(0x7f070ce1);
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return MyApp.getApp().getResources().getString(0x7f070ce1);

            case 16: // '\020'
                return "http://pages.ebay.at/help/policies/privacy-policy.html?rt=nc";

            case 15: // '\017'
                return "http://pages.ebay.com.au/help/policies/privacy-policy.html?rt=nc";

            case 2: // '\002'
                return "http://pages.ebay.ca/help/policies/privacy-policy.html?rt=nc";

            case 210: 
                return "http://pages.cafr.ebay.ca/help/policies/privacy-policy.html?rt=nc";

            case 193: 
                return "http://pages.ebay.ch/help/policies/privacy-policy.html?rt=nc";

            case 77: // 'M'
                return "http://pages.ebay.de/help/policies/privacy-policy.html?rt=nc";

            case 186: 
                return "http://pages.ebay.es/help/policies/privacy-policy.html?rt=nc";

            case 71: // 'G'
                return "http://pages.ebay.fr/help/policies/privacy-policy.html?rt=nc";

            case 23: // '\027'
                return "http://pages.befr.ebay.be/help/policies/privacy-policy.html?rt=nc";

            case 201: 
                return "http://pages.ebay.com.hk/help/policies/privacy-policy.html?rt=nc";

            case 205: 
                return "http://pages.ebay.ie/help/policies/privacy-policy.html?rt=nc";

            case 203: 
                return "http://pages.ebay.in/help/policies/privacy-policy.html?rt=nc";

            case 101: // 'e'
                return "http://pages.ebay.it/help/policies/privacy-policy.html?rt=nc";

            case 207: 
                return "http://pages.ebay.com.my/help/policies/privacy-policy.html?rt=nc";

            case 146: 
                return "http://pages.ebay.nl/help/policies/privacy-policy.html?rt=nc";

            case 123: // '{'
                return "http://pages.benl.ebay.be/help/policies/privacy-policy.html?rt=nc";

            case 211: 
                return "http://pages.ebay.ph/help/policies/privacy-policy.html?rt=nc";

            case 212: 
                return "http://pages.ebay.pl/help/policies/privacy-policy.html?rt=nc";

            case 215: 
                return "http://pages.ebay.com/ru/ru-ru/help/policies/privacy-policy.html?rt=nc";

            case 216: 
                return "http://pages.ebay.com.sg/help/policies/privacy-policy.html?rt=nc";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/help/policies/privacy-policy.html?rt=nc";
            }
        }

        public static String getSellerGspTermsAndConditionsDefault(EbaySite ebaysite)
        {
            return "http://pages.ebay.com/shipping/globalshipping/seller-tnc.html";
        }

        public static String inStorePickupTermsOfServiceUrlFormat(EbayCountry ebaycountry)
        {
            if (ebaycountry == null || ebaycountry.site == null)
            {
                return null;
            }
            switch (ebaycountry.getSiteId())
            {
            case 1: // '\001'
            case 2: // '\002'
            default:
                return null;

            case 0: // '\0'
                return "http://pages.ebay.com/instorepickup/terms.html?lang=%s";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/clickandcollect/terms.html?lang=%s";
            }
        }

        public static boolean isBuyerRegistrationMobileWeb(EbayCountry ebaycountry)
        {
            return false;
        }

        public static boolean isDistanceSearchAvailable(EbayCountry ebaycountry)
        {
            if (ebaycountry != null) goto _L2; else goto _L1
_L1:
            return false;
_L2:
            switch (ebaycountry.getSiteId())
            {
            default:
                return true;

            case 205: 
            case 207: 
            case 211: 
            case 216: 
                break;
            }
            if (true) goto _L1; else goto _L3
_L3:
        }

        public static boolean isFeedEnabled(EbayCountry ebaycountry)
        {
_L2:
            return false;
            if (ebaycountry == null || NautilusKernel.isQaMode()) goto _L2; else goto _L1
_L1:
            switch (ebaycountry.getSiteId())
            {
            default:
                return true;

            case 23: // '\027'
            case 77: // 'M'
            case 123: // '{'
            case 203: 
            case 210: 
            case 212: 
                break;
            }
            if (true) goto _L2; else goto _L3
_L3:
        }

        public static boolean isPhoneSupportAvailable(EbayCountry ebaycountry)
        {
            while (ebaycountry == null || !"US".equals(ebaycountry.getSiteCountryCode()) && !"CA".equals(ebaycountry.getCountryCode())) 
            {
                return false;
            }
            return true;
        }

        public static String payPalGuestCheckoutTnCUrl(EbayCountry ebaycountry)
        {
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 77: // 'M'
                return "https://cms.paypal.com/de/cgi-bin/?cmd=_render-content&content_ID=ua/ServiceDescription_full&locale.x=DE";
            }
        }

        public static String ppaRegistrationUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            String s = buyerRegFlowBaseUrl(ebaycountry);
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 71: // 'G'
            case 77: // 'M'
            case 101: // 'e'
            case 186: 
            case 210: 
                return (new StringBuilder()).append(s).append("PartialReg").toString();
            }
        }

        public static String ppaUpgradeUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            String s = buyerRegFlowBaseUrl(ebaycountry);
            switch (ebaycountry.getSiteId())
            {
            default:
                return (new StringBuilder()).append(s).append("?UpgradeBusinessRoleApp").toString();

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 71: // 'G'
            case 77: // 'M'
            case 101: // 'e'
            case 186: 
            case 210: 
                return (new StringBuilder()).append(s).append("Upgrade").toString();
            }
        }

        public static String proxGuestXoCreditCheckUrl(EbayCountry ebaycountry)
        {
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 77: // 'M'
                return "https://www.paypal.com/de/cgi-bin/merchantpaymentweb?cmd=xpt/Marketing/popup/UnconfirmedELV-outside";
            }
        }

        public static String proxGuestXoPrivacyNoticesUrl(EbayCountry ebaycountry)
        {
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 77: // 'M'
                return "http://pages.ebay.de/help/policies/data-protection.html";
            }
        }

        private static String resonsiveFlowBaseUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            if (NautilusKernel.isQaMode())
            {
                switch (ebaycountry.getSiteId())
                {
                default:
                    return "https://scgi.qa.ebay.com/ws/eBayISAPI.dll";

                case 71: // 'G'
                    return "https://scgi.fr.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 101: // 'e'
                    return "https://scgi.it.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 186: 
                    return "https://scgi.es.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 3: // '\003'
                    return "https://scgi.uk.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 16: // '\020'
                    return "https://scgi.at.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 15: // '\017'
                    return "https://scgi.au.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 2: // '\002'
                    return "https://scgi.ca.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 210: 
                    return "https://scgi.cafr.ca.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 193: 
                    return "https://scgi.ch.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 77: // 'M'
                    return "https://scgi.de.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 23: // '\027'
                    return "https://scgi.befr.be.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 205: 
                    return "https://scgi.ie.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 203: 
                    return "https://scgi.in.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 207: 
                    return "https://scgi.my.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 146: 
                    return "https://scgi.nl.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 123: // '{'
                    return "https://scgi.benl.be.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 211: 
                    return "https://scgi.ph.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 212: 
                    return "https://scgi.pl.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 216: 
                    return "https://scgi.sg.paradise.qa.ebay.com/ws/eBayISAPI.dll";

                case 0: // '\0'
                    return "https://scgi.qa.ebay.com/ws/eBayISAPI.dll";
                }
            }
            String s = ebaycountry.getSiteDomain();
            ebaycountry = s;
            if (s == null)
            {
                ebaycountry = EbayCountry.getInstance("US").getSiteDomain();
            }
            return String.format("https://scgi.%s/ws/eBayISAPI.dll", new Object[] {
                ebaycountry
            });
        }

        public static String savePaymentMethodInfoUrl(EbayCountry ebaycountry)
        {
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 77: // 'M'
                return "http://pages.ebay.de/help/buy/contextual/remember-payment-data.html";
            }
        }

        public static String sellerFeesUrl(int i)
        {
            switch (i)
            {
            default:
                return null;

            case 15: // '\017'
                return "http://pages.ebay.com.au/help/sell/fees.html";

            case 16: // '\020'
                return "http://pages.ebay.at/help/sell/seller-fees.html";

            case 2: // '\002'
                return "http://pages.ebay.ca/help/sell/fees.html";

            case 210: 
                return "http://pages.cafr.ebay.ca/help/sell/fees.html";

            case 71: // 'G'
                return "http://pages.ebay.fr/help/sell/fees.html";

            case 77: // 'M'
                return "http://pages.ebay.de/help/sell/fees.html";

            case 203: 
                return "http://pages.ebay.in/help/sell/seller-fees.html";

            case 3: // '\003'
                return "http://pages.ebay.co.uk/help/sell/fees.html";

            case 0: // '\0'
                return "http://pages.ebay.com/help/sell/fees.html";

            case 100: // 'd'
                return "http://pages.ebay.com/help/sell/motorfees.html";

            case 205: 
                return "http://pages.ebay.ie/help/sell/fees.html";

            case 101: // 'e'
                return "http://pages.ebay.it/help/sell/fees.html";

            case 207: 
                return "http://pages.ebay.com.my/help/sell/fees.html";

            case 211: 
                return "http://pages.ebay.ph/help/sell/fees.html";

            case 216: 
                return "http://pages.ebay.com.sg/help/sell/fees.html";

            case 186: 
                return "http://pages.ebay.es/help/sell/fees.html";
            }
        }

        public static String sellerFeesUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            } else
            {
                return sellerFeesUrl(ebaycountry.getSiteId());
            }
        }

        public static String sellerRegistrationUrl(EbayCountry ebaycountry)
        {
            ebaycountry = resonsiveFlowBaseUrl(ebaycountry);
            if (ebaycountry == null)
            {
                return null;
            } else
            {
                return (new StringBuilder()).append(ebaycountry).append("?SellerSignIn2").toString();
            }
        }

        public static String shipToFundInfoUrl(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return null;
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return null;

            case 0: // '\0'
                return "http://pages.ebay.com/help/pay/payment_hold.html";

            case 2: // '\002'
                return "http://pages.ebay.com/help/pay/payment_hold.html";

            case 210: 
                return "http://pages.ebay.com/help/pay/payment_hold.html";
            }
        }

        public static boolean supportsBestOffer(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return false;
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return false;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 16: // '\020'
            case 23: // '\027'
            case 71: // 'G'
            case 77: // 'M'
            case 101: // 'e'
            case 123: // '{'
            case 146: 
            case 186: 
            case 193: 
            case 203: 
            case 205: 
            case 207: 
            case 210: 
            case 211: 
            case 216: 
                return true;
            }
        }

        public static boolean supportsBestOfferTerms(EbayCountry ebaycountry)
        {
            if (!supportsBestOffer(ebaycountry))
            {
                return false;
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return false;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 23: // '\027'
            case 71: // 'G'
            case 101: // 'e'
            case 123: // '{'
            case 186: 
            case 203: 
            case 205: 
            case 207: 
            case 210: 
            case 216: 
                return true;
            }
        }

        public static boolean supportsCategorySuggestions(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return false;
            }
            switch (ebaycountry.getSiteId())
            {
            default:
                return false;

            case 0: // '\0'
            case 2: // '\002'
            case 3: // '\003'
            case 15: // '\017'
            case 77: // 'M'
            case 101: // 'e'
                return true;
            }
        }

        public static boolean supportsMotors(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return false;
            } else
            {
                return "US".equals(ebaycountry.getSiteCountryCode());
            }
        }

        public static boolean supportsMotorsSelling(EbayCountry ebaycountry)
        {
            if (ebaycountry == null)
            {
                return false;
            } else
            {
                return "US".equals(ebaycountry.getSiteCountryCode());
            }
        }

        public static boolean supportsPaymentIntermediation(EbaySite ebaysite)
        {
            return ebaysite != null && (EbaySite.AT.equals(ebaysite) || EbaySite.DE.equals(ebaysite));
        }

        public static boolean supportsSellPrefillSpecifics(EbayCountry ebaycountry)
        {
            return ebaycountry != null && supportsSellPrefillSpecifics(ebaycountry.getSite());
        }

        public static boolean supportsSellPrefillSpecifics(EbaySite ebaysite)
        {
            if (ebaysite == null)
            {
                return false;
            }
            switch (ebaysite.idInt)
            {
            default:
                return false;

            case 0: // '\0'
            case 3: // '\003'
            case 15: // '\017'
            case 77: // 'M'
            case 100: // 'd'
            case 203: 
                return true;
            }
        }

        public static boolean supportsSellingGuidance(EbayCountry ebaycountry)
        {
            return ebaycountry != null && supportsSellingGuidance(ebaycountry.site);
        }

        public static boolean supportsSellingGuidance(EbaySite ebaysite)
        {
            if (ebaysite == null)
            {
                return false;
            }
            switch (ebaysite.idInt)
            {
            default:
                return false;

            case 0: // '\0'
            case 3: // '\003'
            case 15: // '\017'
            case 77: // 'M'
            case 100: // 'd'
                return true;
            }
        }

        private Default()
        {
        }
    }


    private static final Map countryToCountryWithLanguageResourceId = new HashMap();
    private static final Map countryToFlagResourceId = new HashMap();
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo detectLog = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CountryAutoDetect", 3, "Country Auto-Detect mode");
    private static final Map shippingEnumToRegionResourceId;

    private EbayCountryManager()
    {
    }

    public static String addMobileWebParams(Context context, String s)
    {
        if (context == null || TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            s = Uri.parse(s);
            String s1 = Locale.getDefault().getLanguage();
            return s.buildUpon().appendQueryParameter("srcAppId", "2571").appendQueryParameter("rmvHdr", "true").appendQueryParameter("native-app-embedded", "1").appendQueryParameter("appVer", NautilusKernel.getAppVersionName(context)).appendQueryParameter("OS", "Android").appendQueryParameter("OSVer", android.os.Build.VERSION.RELEASE).appendQueryParameter("rmvFtr", "true").appendQueryParameter("langId", s1).appendQueryParameter("lan", s1).build().toString();
        }
    }

    public static String addResponsiveFlowParams(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        } else
        {
            s = Uri.parse(s);
            String s1 = Locale.getDefault().getLanguage();
            return s.buildUpon().appendQueryParameter("srcAppId", "2571").appendQueryParameter("rmvHdr", "true").appendQueryParameter("mobile", "1").appendQueryParameter("lang", s1).appendQueryParameter("clientapptype", "12").build().toString();
        }
    }

    public static EbayCountry detectCountry()
    {
        return detectCountry(true);
    }

    public static EbayCountry detectCountry(boolean flag)
    {
        Object obj = null;
        Object obj1 = obj;
        if (flag)
        {
            PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
            obj1 = obj;
            if (postalcodespecification != null)
            {
                obj = EbayCountry.getInstance(postalcodespecification.countryCode);
                obj1 = obj;
                if (detectLog.isLoggable)
                {
                    detectLog.log(String.format("Detected country from shipping address: %s", new Object[] {
                        obj
                    }));
                    obj1 = obj;
                }
            }
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj = UserCache.getUserDetails();
            EbayCountry ebaycountry1 = ((EbayCountry) (obj1));
            if (obj != null)
            {
                ebaycountry1 = ((EbayCountry) (obj1));
                if (((UserDetail) (obj)).registrationAddress != null)
                {
                    ebaycountry1 = EbayCountry.getInstance(((UserDetail) (obj)).registrationAddress.country);
                }
            }
            obj = ebaycountry1;
            if (detectLog.isLoggable)
            {
                detectLog.log(String.format("Detected country from reg address: %s", new Object[] {
                    ebaycountry1
                }));
                obj = ebaycountry1;
            }
        }
        Object obj3 = MyApp.getApp().getApplicationContext();
        obj1 = obj;
        if (obj == null)
        {
            obj1 = obj;
            if (obj3 != null)
            {
                Object obj2 = null;
                obj3 = (TelephonyManager)((Context) (obj3)).getSystemService("phone");
                obj1 = obj2;
                if (TextUtils.isEmpty(null))
                {
                    obj1 = obj2;
                    if (((TelephonyManager) (obj3)).getPhoneType() != 2)
                    {
                        obj1 = ((TelephonyManager) (obj3)).getNetworkCountryIso().toUpperCase(Locale.US);
                    }
                }
                obj2 = obj1;
                if (TextUtils.isEmpty(((CharSequence) (obj1))))
                {
                    obj2 = obj1;
                    if (((TelephonyManager) (obj3)).getSimState() == 5)
                    {
                        obj2 = ((TelephonyManager) (obj3)).getSimCountryIso().toUpperCase(Locale.US);
                    }
                }
                if (!TextUtils.isEmpty(((CharSequence) (obj2))))
                {
                    obj = EbayCountry.getInstance(((String) (obj2)));
                }
                obj1 = obj;
                if (detectLog.isLoggable)
                {
                    detectLog.log(String.format("Detected country from telephony manager: %s", new Object[] {
                        obj
                    }));
                    obj1 = obj;
                }
            }
        }
        obj = obj1;
        if (obj1 == null)
        {
            obj1 = EbayCountry.getInstance(Locale.getDefault().getCountry().toUpperCase(Locale.US));
            obj = obj1;
            if (detectLog.isLoggable)
            {
                detectLog.log(String.format("Detected country from device locale: %s", new Object[] {
                    obj1
                }));
                obj = obj1;
            }
        }
        obj1 = obj;
        if (obj == null)
        {
            EbayCountry ebaycountry = EbayCountry.getInstance("US");
            obj1 = ebaycountry;
            if (detectLog.isLoggable)
            {
                detectLog.log(String.format("Detected country from default: %s", new Object[] {
                    ebaycountry
                }));
                obj1 = ebaycountry;
            }
        }
        return ((EbayCountry) (obj1));
    }

    public static int getBuyerProtectionPageTitle()
    {
        switch (EbaySite.getInstanceFromId(MyApp.getCurrentSite()).idInt)
        {
        default:
            return 0x7f070b06;

        case 77: // 'M'
            return 0x7f0700d5;

        case 3: // '\003'
            return 0x7f0700d6;
        }
    }

    public static String getCountryName(Resources resources, EbayCountry ebaycountry)
    {
        return getCountryName(resources, ebaycountry.getCountryCode());
    }

    public static String getCountryName(Resources resources, String s)
    {
        resources = EbayCountry.normalizeCountryCode(s);
        if (resources == null)
        {
            return s;
        } else
        {
            return (new Locale("", resources)).getDisplayCountry();
        }
    }

    public static String getCountryWithLanguageName(Resources resources, EbayCountry ebaycountry)
    {
        if (resources == null || ebaycountry == null)
        {
            return null;
        } else
        {
            return getCountryWithLanguageName(resources, ebaycountry.serialize(), ebaycountry.getCountryCode(), ebaycountry.getSiteLanguageCode());
        }
    }

    private static String getCountryWithLanguageName(Resources resources, String s, String s1, String s2)
    {
        Integer integer1 = (Integer)countryToCountryWithLanguageResourceId.get(s);
        Integer integer = integer1;
        if (integer1 == null)
        {
            integer = Integer.valueOf(getCountryWithLanguageNameId(s1, s2));
            countryToCountryWithLanguageResourceId.put(s, integer);
        }
        if (integer.intValue() == 0)
        {
            return getCountryName(resources, s1);
        } else
        {
            return resources.getString(integer.intValue());
        }
    }

    private static int getCountryWithLanguageNameId(String s, String s1)
    {
        if (s == null || s.length() != 2 || s1 == null || s1.length() != 2)
        {
            return 0;
        }
        switch (s1.charAt(0) << 24 | s1.charAt(1) << 16 | s.charAt(0) << 8 | s.charAt(1))
        {
        default:
            return 0;

        case 1718764101: 
            return 0x7f07026e;

        case 1852588613: 
            return 0x7f07026f;

        case 1718764353: 
            return 0x7f070270;
        }
    }

    public static int getDistanceResourceId(EbayCountry ebaycountry)
    {
        return ebaycountry != null && !ebaycountry.usesMetric() ? 0x7f070637 : 0x7f070514;
    }

    public static String getDistanceString(Resources resources, EbayCountry ebaycountry)
    {
        if (resources == null)
        {
            return null;
        } else
        {
            return resources.getString(getDistanceResourceId(ebaycountry));
        }
    }

    public static int getFlagResourceId(Resources resources, EbayCountry ebaycountry)
    {
        return getFlagResourceId(resources, ebaycountry.serialize(), ebaycountry.getCountryCode());
    }

    private static int getFlagResourceId(Resources resources, String s, String s1)
    {
        Integer integer = (Integer)countryToFlagResourceId.get(s);
        resources = integer;
        if (integer == null)
        {
            s1 = Integer.valueOf(getFlagResourceId(s1));
            resources = s1;
            if (s1.intValue() == 0)
            {
                resources = Integer.valueOf(0x7f020183);
            }
            countryToFlagResourceId.put(s, resources);
        }
        return resources.intValue();
    }

    private static int getFlagResourceId(String s)
    {
        if (s == null || s.length() != 2)
        {
            return 0;
        }
        s = s.toLowerCase(Locale.US);
        switch (s.charAt(0) << 8 | s.charAt(1))
        {
        default:
            return 0;

        case 24932: 
            return 0x7f0200b7;

        case 24933: 
            return 0x7f0200b8;

        case 24934: 
            return 0x7f0200b9;

        case 24935: 
            return 0x7f0200ba;

        case 24937: 
            return 0x7f0200bb;

        case 24940: 
            return 0x7f0200bc;

        case 24941: 
            return 0x7f0200bd;

        case 24942: 
            return 0x7f0200be;

        case 24943: 
            return 0x7f0200bf;

        case 24946: 
            return 0x7f0200c0;

        case 24947: 
            return 0x7f0200c1;

        case 24948: 
            return 0x7f0200c2;

        case 24949: 
            return 0x7f0200c3;

        case 24951: 
            return 0x7f0200c4;

        case 24954: 
            return 0x7f0200c5;

        case 25185: 
            return 0x7f0200c6;

        case 25186: 
            return 0x7f0200c7;

        case 25188: 
            return 0x7f0200c8;

        case 25189: 
            return 0x7f0200c9;

        case 25190: 
            return 0x7f0200ca;

        case 25191: 
            return 0x7f0200cb;

        case 25192: 
            return 0x7f0200cc;

        case 25193: 
            return 0x7f0200cd;

        case 25194: 
            return 0x7f0200ce;

        case 25197: 
            return 0x7f0200cf;

        case 25198: 
            return 0x7f0200d0;

        case 25199: 
            return 0x7f0200d1;

        case 25202: 
            return 0x7f0200d2;

        case 25203: 
            return 0x7f0200d3;

        case 25204: 
            return 0x7f0200d4;

        case 25207: 
            return 0x7f0200d5;

        case 25210: 
            return 0x7f0200d6;

        case 25441: 
            return 0x7f0200d7;

        case 25446: 
            return 0x7f0200d8;

        case 25448: 
            return 0x7f0200d9;

        case 25451: 
            return 0x7f0200da;

        case 25452: 
            return 0x7f0200db;

        case 25453: 
            return 0x7f0200dc;

        case 25454: 
            return 0x7f0200dd;

        case 25455: 
            return 0x7f0200de;

        case 25458: 
            return 0x7f0200df;

        case 25462: 
            return 0x7f0200e0;

        case 25465: 
            return 0x7f0200e1;

        case 25466: 
            return 0x7f0200e2;

        case 25701: 
            return 0x7f0200e3;

        case 25706: 
            return 0x7f0200e4;

        case 25707: 
            return 0x7f0200e5;

        case 25709: 
            return 0x7f0200e6;

        case 25711: 
            return 0x7f0200e7;

        case 25722: 
            return 0x7f0200e8;

        case 25955: 
            return 0x7f0200e9;

        case 25957: 
            return 0x7f0200ea;

        case 25959: 
            return 0x7f0200eb;

        case 25960: 
            return 0x7f0200ec;

        case 25970: 
            return 0x7f0200ed;

        case 25971: 
            return 0x7f0200ee;

        case 25972: 
            return 0x7f0200ef;

        case 26217: 
            return 0x7f0200f0;

        case 26218: 
            return 0x7f0200f1;

        case 26219: 
            return 0x7f0200f2;

        case 26221: 
            return 0x7f0200f3;

        case 26226: 
            return 0x7f0200f4;

        case 26465: 
            return 0x7f0200f5;

        case 26466: 
            return 0x7f0200f6;

        case 26468: 
            return 0x7f0200f7;

        case 26469: 
            return 0x7f0200f8;

        case 26470: 
        case 26480: 
            return 0x7f0200f9;

        case 26471: 
            return 0x7f0200fa;

        case 26472: 
            return 0x7f0200fb;

        case 26473: 
            return 0x7f0200fc;

        case 26476: 
            return 0x7f0200fd;

        case 26477: 
            return 0x7f0200fe;

        case 26478: 
            return 0x7f0200ff;

        case 26481: 
            return 0x7f020100;

        case 26482: 
            return 0x7f020101;

        case 26484: 
            return 0x7f020102;

        case 26485: 
            return 0x7f020103;

        case 26487: 
            return 0x7f020104;

        case 26489: 
            return 0x7f020105;

        case 26731: 
            return 0x7f020106;

        case 26734: 
            return 0x7f020107;

        case 26738: 
            return 0x7f020108;

        case 26740: 
            return 0x7f020109;

        case 26741: 
            return 0x7f02010a;

        case 26980: 
        case 28003: 
            return 0x7f02010b;

        case 26981: 
            return 0x7f02010c;

        case 26988: 
            return 0x7f02010d;

        case 26990: 
            return 0x7f02010e;

        case 26995: 
            return 0x7f02010f;

        case 26996: 
            return 0x7f020110;

        case 27237: 
            return 0x7f020111;

        case 27245: 
            return 0x7f020112;

        case 27247: 
            return 0x7f020113;

        case 27248: 
            return 0x7f020114;

        case 27493: 
            return 0x7f020115;

        case 27495: 
            return 0x7f020116;

        case 27496: 
            return 0x7f020117;

        case 27497: 
            return 0x7f020118;

        case 27501: 
            return 0x7f020119;

        case 27502: 
            return 0x7f02011a;

        case 27506: 
            return 0x7f02011b;

        case 27511: 
            return 0x7f02011c;

        case 27513: 
            return 0x7f02011d;

        case 27514: 
            return 0x7f02011e;

        case 27745: 
            return 0x7f02011f;

        case 27746: 
            return 0x7f020120;

        case 27753: 
            return 0x7f020121;

        case 27755: 
            return 0x7f020122;

        case 27764: 
            return 0x7f020123;

        case 27765: 
            return 0x7f020124;

        case 27766: 
            return 0x7f020125;

        case 28001: 
            return 0x7f020126;

        case 28004: 
            return 0x7f020127;

        case 28005: 
            return 0x7f020128;

        case 28007: 
            return 0x7f020129;

        case 28008: 
            return 0x7f02012a;

        case 28011: 
            return 0x7f02012b;

        case 28012: 
            return 0x7f02012c;

        case 28014: 
            return 0x7f02012d;

        case 28015: 
            return 0x7f02012e;

        case 28017: 
            return 0x7f02012f;

        case 28018: 
            return 0x7f020130;

        case 28019: 
            return 0x7f020131;

        case 28020: 
            return 0x7f020132;

        case 28021: 
            return 0x7f020133;

        case 28022: 
            return 0x7f020134;

        case 28023: 
            return 0x7f020135;

        case 28024: 
            return 0x7f020136;

        case 28025: 
            return 0x7f020137;

        case 28026: 
            return 0x7f020138;

        case 28257: 
            return 0x7f020139;

        case 28259: 
            return 0x7f02013a;

        case 28261: 
            return 0x7f02013b;

        case 28263: 
            return 0x7f02013c;

        case 28265: 
            return 0x7f02013d;

        case 28268: 
            return 0x7f02013e;

        case 28271: 
            return 0x7f02013f;

        case 28272: 
            return 0x7f020140;

        case 28274: 
            return 0x7f020141;

        case 28277: 
            return 0x7f020142;

        case 28282: 
            return 0x7f020143;

        case 28525: 
            return 0x7f020144;

        case 28769: 
            return 0x7f020145;

        case 28773: 
            return 0x7f020146;

        case 28774: 
            return 0x7f020147;

        case 28775: 
            return 0x7f020148;

        case 28776: 
            return 0x7f020149;

        case 28779: 
            return 0x7f02014a;

        case 28780: 
            return 0x7f02014b;

        case 28781: 
            return 0x7f02014c;

        case 28786: 
            return 0x7f02014d;

        case 28788: 
            return 0x7f02014e;

        case 28791: 
            return 0x7f02014f;

        case 28793: 
            return 0x7f020150;

        case 29025: 
            return 0x7f020151;

        case 29285: 
            return 0x7f020152;

        case 29295: 
            return 0x7f020153;

        case 29299: 
            return 0x7f020154;

        case 29301: 
            return 0x7f020155;

        case 29303: 
            return 0x7f020156;

        case 29537: 
            return 0x7f020157;

        case 29538: 
            return 0x7f020158;

        case 29539: 
            return 0x7f020159;

        case 29541: 
            return 0x7f02015a;

        case 29543: 
            return 0x7f02015b;

        case 29544: 
            return 0x7f02015c;

        case 29545: 
            return 0x7f02015d;

        case 29547: 
            return 0x7f02015e;

        case 29548: 
            return 0x7f02015f;

        case 29549: 
            return 0x7f020160;

        case 29550: 
            return 0x7f020161;

        case 29554: 
            return 0x7f020162;

        case 29558: 
            return 0x7f020163;

        case 29562: 
            return 0x7f020164;

        case 29795: 
            return 0x7f020165;

        case 29796: 
            return 0x7f020166;

        case 29799: 
            return 0x7f020167;

        case 29800: 
            return 0x7f020168;

        case 29802: 
            return 0x7f020169;

        case 29805: 
            return 0x7f02016a;

        case 29806: 
            return 0x7f02016b;

        case 29807: 
            return 0x7f02016c;

        case 29810: 
            return 0x7f02016d;

        case 29812: 
            return 0x7f02016e;

        case 29814: 
            return 0x7f02016f;

        case 29815: 
            return 0x7f020170;

        case 29818: 
            return 0x7f020171;

        case 30049: 
            return 0x7f020172;

        case 30055: 
            return 0x7f020173;

        case 30067: 
            return 0x7f020174;

        case 30073: 
            return 0x7f020175;

        case 30074: 
            return 0x7f020176;

        case 30307: 
            return 0x7f020177;

        case 30309: 
            return 0x7f020178;

        case 30311: 
            return 0x7f020179;

        case 30313: 
            return 0x7f02017a;

        case 30318: 
            return 0x7f02017b;

        case 30325: 
            return 0x7f02017c;

        case 30566: 
            return 0x7f02017d;

        case 30579: 
            return 0x7f02017e;

        case 31077: 
            return 0x7f02017f;

        case 31092: 
            return 0x7f020180;

        case 31329: 
            return 0x7f020181;

        case 31341: 
            return 0x7f020182;
        }
    }

    public static List getGbhCountryCodes()
    {
        return Arrays.asList(new String[] {
            "AF", "AL", "DZ", "AS", "AD", "AO", "AI", "AG", "AR", "AM", 
            "AW", "AZ", "BS", "BH", "BD", "BB", "BZ", "BJ", "BM", "BT", 
            "BO", "BA", "BW", "BR", "BN", "BG", "BF", "BI", "KH", "CM", 
            "CV", "KY", "CF", "TD", "CL", "CN", "CO", "KM", "CK", "CR", 
            "HR", "CY", "CZ", "DK", "DJ", "DM", "DO", "EC", "EG", "SV", 
            "GQ", "ER", "EE", "ET", "FK", "FJ", "FI", "GF", "PF", "GA", 
            "GM", "GE", "GH", "GI", "GR", "GL", "GD", "GP", "GU", "GT", 
            "GG", "GN", "GW", "GY", "HT", "HN", "HK", "HU", "IS", "ID", 
            "IL", "JM", "JP", "JE", "JO", "KZ", "KE", "KI", "KR", "KW", 
            "KG", "LA", "LV", "LB", "LI", "LT", "LU", "MO", "MK", "MG", 
            "MW", "MV", "ML", "MT", "MH", "MQ", "MR", "MU", "YT", "MX", 
            "FM", "MD", "MC", "MN", "ME", "MS", "MA", "MZ", "NA", "NR", 
            "NP", "NC", "NZ", "NI", "NE", "NG", "NU", "NO", "OM", "PK", 
            "PW", "PA", "PG", "PY", "PE", "PT", "PR", "QA", "RO", "RU", 
            "RW", "RE", "SH", "KN", "PM", "VC", "WS", "SM", "SA", "SN", 
            "RS", "SC", "SL", "SK", "SI", "SB", "ZA", "LK", "SR", "SZ", 
            "SE", "TW", "TJ", "TZ", "TH", "TG", "TO", "TT", "TN", "TR", 
            "TM", "TC", "TV", "UG", "UA", "AE", "UY", "UZ", "VU", "VE", 
            "VN", "VG", "VI", "WF", "EH", "YE", "ZM"
        });
    }

    public static String getShippingRegionsMapping(Resources resources, String s)
    {
        s = (Integer)shippingEnumToRegionResourceId.get(s);
        if (s != null)
        {
            return resources.getString(s.intValue());
        } else
        {
            return null;
        }
    }

    public static String mobileWebSsoScope(EbayCountry ebaycountry)
    {
        if (ebaycountry == null) goto _L2; else goto _L1
_L1:
        ebaycountry.getSiteId();
        JVM INSTR lookupswitch 15: default 140
    //                   2: 152
    //                   3: 200
    //                   15: 148
    //                   16: 144
    //                   71: 172
    //                   77: 164
    //                   101: 180
    //                   146: 188
    //                   186: 168
    //                   193: 160
    //                   205: 176
    //                   207: 184
    //                   210: 156
    //                   211: 192
    //                   216: 196;
           goto _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L2:
        return "//EBAYSSO/EBAYMOBILEWEB";
_L6:
        return "//EBAYSSO/EBAYMOBILEWEB_AT";
_L5:
        return "//EBAYSSO/EBAYMOBILEWEB_AU";
_L3:
        return "//EBAYSSO/EBAYMOBILEWEB_CA";
_L15:
        return "//EBAYSSO/EBAYMOBILEWEB_CAFR";
_L12:
        return "//EBAYSSO/EBAYMOBILEWEB_CH";
_L8:
        return "//EBAYSSO/EBAYMOBILEWEB_DE";
_L11:
        return "//EBAYSSO/EBAYMOBILEWEB_ES";
_L7:
        return "//EBAYSSO/EBAYMOBILEWEB_FR";
_L13:
        return "//EBAYSSO/EBAYMOBILEWEB_IE";
_L9:
        return "//EBAYSSO/EBAYMOBILEWEB_IT";
_L14:
        return "//EBAYSSO/EBAYMOBILEWEB_MY";
_L10:
        return "//EBAYSSO/EBAYMOBILEWEB_NL";
_L16:
        return "//EBAYSSO/EBAYMOBILEWEB_PH";
_L17:
        return "//EBAYSSO/EBAYMOBILEWEB_SG";
_L4:
        return "//EBAYSSO/EBAYMOBILEWEB_UK";
    }

    static 
    {
        shippingEnumToRegionResourceId = new HashMap();
        shippingEnumToRegionResourceId.put("Americas", Integer.valueOf(0x7f0708ff));
        shippingEnumToRegionResourceId.put("Asia", Integer.valueOf(0x7f0708f9));
        shippingEnumToRegionResourceId.put("Caribbean", Integer.valueOf(0x7f0708fa));
        shippingEnumToRegionResourceId.put("Europe", Integer.valueOf(0x7f0708fb));
        shippingEnumToRegionResourceId.put("EuropeanUnion", Integer.valueOf(0x7f0708fc));
        shippingEnumToRegionResourceId.put("LatinAmerica", Integer.valueOf(0x7f0708fd));
        shippingEnumToRegionResourceId.put("MiddleEast", Integer.valueOf(0x7f0708fe));
        shippingEnumToRegionResourceId.put("NorthAmerica", Integer.valueOf(0x7f070900));
        shippingEnumToRegionResourceId.put("Oceania", Integer.valueOf(0x7f070900));
        shippingEnumToRegionResourceId.put("SouthAmerica", Integer.valueOf(0x7f070901));
        shippingEnumToRegionResourceId.put("Worldwide", Integer.valueOf(0x7f070902));
        shippingEnumToRegionResourceId.put("UK", Integer.valueOf(0x7f070271));
        shippingEnumToRegionResourceId.put("WillNotShip", Integer.valueOf(0x7f07010f));
    }


}
