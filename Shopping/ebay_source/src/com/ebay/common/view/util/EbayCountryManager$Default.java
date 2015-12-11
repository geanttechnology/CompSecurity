// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view.util;

import android.content.res.Resources;
import com.ebay.mobile.MyApp;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.kernel.NautilusKernel;

// Referenced classes of package com.ebay.common.view.util:
//            EbayCountryManager

public static class 
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
    //                   0: 364
    //                   2: 364
    //                   3: 364
    //                   15: 364
    //                   71: 364
    //                   77: 364
    //                   101: 364
    //                   186: 364
    //                   210: 364;
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
    //                   2128: 91
    //                   2156: 106
    //                   2627: 76;
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

    private ()
    {
    }
}
