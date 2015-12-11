// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.net.api.currency.CurrencyConversionDataManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.text.ParseException;
import java.util.Date;

// Referenced classes of package com.ebay.common:
//            Preferences

public final class CurrencyConversionCache
{

    private static final CurrencyConversionRate INVALID_RATE;

    public CurrencyConversionCache()
    {
    }

    public static CurrencyConversionRate getConversionRate(EbayContext ebaycontext, String s)
    {
        return getConversionRate(ebaycontext, s, MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode());
    }

    public static CurrencyConversionRate getConversionRate(EbayContext ebaycontext, String s, String s1)
    {
        NautilusKernel.verifyMain();
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.CurrencyConversion))
        {
            return INVALID_RATE;
        } else
        {
            s = new com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams(s, s1, MyApp.getPrefs().getCurrentCountry().site, null, null);
            return getManager(ebaycontext).getConversionRate(s);
        }
    }

    private static CurrencyConversionDataManager getManager(EbayContext ebaycontext)
    {
        com/ebay/common/CurrencyConversionCache;
        JVM INSTR monitorenter ;
        ebaycontext = (CurrencyConversionDataManager)DataManager.get(ebaycontext, CurrencyConversionDataManager.KEY);
        com/ebay/common/CurrencyConversionCache;
        JVM INSTR monitorexit ;
        return ebaycontext;
        ebaycontext;
        throw ebaycontext;
    }

    public static boolean loadConversionRate(EbayContext ebaycontext, com.ebay.common.net.api.currency.CurrencyConversionDataManager.Observer observer, String s, String s1, Date date)
    {
        NautilusKernel.verifyMain();
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.CurrencyConversion))
        {
            return false;
        } else
        {
            s = new com.ebay.common.net.api.currency.CurrencyConversionRequest.ConversionRequestParams(s, s1, MyApp.getPrefs().getCurrentCountry().site, null, date);
            getManager(ebaycontext).loadConversionRate(observer, s);
            return true;
        }
    }

    public static boolean willFetch(EbayContext ebaycontext, String s, String s1)
    {
        NautilusKernel.verifyMain();
        if (DeviceConfiguration.getAsync().get(DcsBoolean.CurrencyConversion))
        {
            return getManager(ebaycontext).willFetch(s, s1);
        } else
        {
            return false;
        }
    }

    static 
    {
        try
        {
            INVALID_RATE = new CurrencyConversionRate(System.currentTimeMillis() + 0x395d1827c000L, "1.0", "invalid", "invalid", false);
        }
        catch (ParseException parseexception)
        {
            throw new RuntimeException("Failed to parse INVALID_RATE");
        }
    }
}
