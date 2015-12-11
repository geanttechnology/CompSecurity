// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.text.ParseException;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionResponse

protected static class  extends BaseApiResponse
{

    protected String conversionDate;
    protected String currencyConversionRate;

    protected CurrencyConversionRate createCurrencyConversionRate(CurrencyConversionResponse currencyconversionresponse)
        throws com.ebay.nautilus.kernel.net.ata
    {
        if (conversionDate != null) goto _L2; else goto _L1
_L1:
        Object obj = new Date();
_L5:
        long l = EbayResponse.getClientTime(((Date) (obj)).getTime());
        if (currencyConversionRate != null) goto _L4; else goto _L3
_L3:
        double d = 0.0D;
_L6:
        String s;
        String s1;
        obj = currencyConversionRate;
        s = currencyconversionresponse.fromCurrency;
        s1 = currencyconversionresponse.toCurrency;
        boolean flag;
        if (!currencyconversionresponse.getResultStatus().hasError() && d > 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new CurrencyConversionRate(l, ((String) (obj)), s, s1, flag);
_L2:
        obj = EbayDateFormat.parse(conversionDate);
          goto _L5
_L4:
        d = Double.valueOf(currencyConversionRate).doubleValue();
          goto _L6
        currencyconversionresponse;
        throw new com.ebay.nautilus.kernel.net.ata.currencyConversionRate(currencyconversionresponse);
          goto _L5
    }

    protected ()
    {
    }
}
