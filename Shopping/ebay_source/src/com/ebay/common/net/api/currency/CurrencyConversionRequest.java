// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.currency;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.datamapping.ImmutableDataMapped;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

// Referenced classes of package com.ebay.common.net.api.currency:
//            CurrencyConversionResponse, CurrencyConversionDataManager

public class CurrencyConversionRequest extends EbaySoaRequest
    implements com.ebay.nautilus.kernel.net.Request.Recoverable
{
    public static final class ConversionRequestParams extends ImmutableDataMapped
    {

        public final String fromCurr;
        public final Date historicalDate;
        private final String iafToken;
        public final EbaySite site;
        public final String toCurr;

        public String getHistoricalDate()
        {
            if (historicalDate == null)
            {
                return null;
            } else
            {
                return EbayDateFormat.format(historicalDate);
            }
        }

        public boolean isHistorical()
        {
            return historicalDate != null;
        }


        public ConversionRequestParams(String s, String s1, EbaySite ebaysite, String s2, Date date)
        {
            if (s == null || s1 == null)
            {
                throw new IllegalArgumentException("Currencies must not be null");
            }
            if (ebaysite == null)
            {
                throw new IllegalArgumentException("Site must not be null");
            } else
            {
                fromCurr = s;
                toCurr = s1;
                site = ebaysite;
                iafToken = s2;
                historicalDate = date;
                return;
            }
        }
    }

    private static final class RequestWrapper
    {

        protected final CurrencyConversionRequest request;

        public RequestWrapper(CurrencyConversionRequest currencyconversionrequest)
        {
            request = currencyconversionrequest;
        }
    }


    public static final String NAMESPACE = "http://www.ebay.com/marketplace/billing/v1/services";
    public static final String OPERATION_NAME = "getCurrencyConversionRate";
    private final String fromCurrency;
    private final String historicalDate;
    private final String toCurrency;

    public CurrencyConversionRequest(ConversionRequestParams conversionrequestparams)
    {
        super("CurrencyRateService", false, "getCurrencyConversionRate");
        super.iafToken = conversionrequestparams.iafToken;
        super.soaContentType = "application/json";
        super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
        super.soaGlobalId = conversionrequestparams.site.idString;
        super.dataFormat = "JSON";
        fromCurrency = russianBugFix(conversionrequestparams.fromCurr);
        toCurrency = russianBugFix(conversionrequestparams.toCurr);
        if (conversionrequestparams.historicalDate == null)
        {
            conversionrequestparams = null;
        } else
        {
            conversionrequestparams = EbayDateFormat.format(conversionrequestparams.historicalDate);
        }
        historicalDate = conversionrequestparams;
    }

    private String russianBugFix(String s)
    {
        String s1 = s;
        if (s == "RUB")
        {
            s1 = "RUR";
        }
        return s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return defaultRequestMapper.toJson(new RequestWrapper(this)).getBytes();
    }

    public void clearResponse()
    {
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.currencyConversionApiUrl);
    }

    public CurrencyConversionResponse getResponse()
    {
        return new CurrencyConversionResponse(fromCurrency, toCurrency);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public int getRetryCount()
    {
        return 2;
    }

    public boolean hasRecoverableError(Response response, IOException ioexception)
    {
        if (response == null || isRetriableException(ioexception))
        {
            return true;
        } else
        {
            return CurrencyConversionDataManager.treatableAsError(response.getResultStatus());
        }
    }
}
