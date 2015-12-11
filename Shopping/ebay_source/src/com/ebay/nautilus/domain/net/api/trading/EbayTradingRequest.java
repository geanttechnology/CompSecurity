// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayErrorUtil;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingApi

public abstract class EbayTradingRequest extends EbayRequest
    implements com.ebay.nautilus.kernel.net.Request.Recoverable
{

    private static final String API_APP_NAME = "x-ebay-api-app-name";
    private static final String API_CERT_NAME = "x-ebay-api-cert-name";
    private static final String API_COMPAT_LEVEL = "x-ebay-api-compatibility-level";
    private static final String API_DEV_NAME = "x-ebay-api-dev-name";
    private static final String API_IAF_TOKEN = "x-ebay-api-iaf-token";
    private static final String API_SITE_ID = "x-ebay-api-siteid";
    public static final String SUPPORTED_API_VERSION = "933";
    public final String apiVersion;
    protected transient String contentType;
    public final String iafToken;
    public final EbaySite site;

    protected EbayTradingRequest()
    {
        contentType = "text/xml";
        iafToken = null;
        site = null;
        apiVersion = null;
    }

    protected EbayTradingRequest(EbayTradingApi ebaytradingapi, String s)
    {
        this(ebaytradingapi, s, "933");
    }

    protected EbayTradingRequest(EbayTradingApi ebaytradingapi, String s, String s1)
    {
        contentType = "text/xml";
        if (ebaytradingapi == null)
        {
            throw new NullPointerException("api");
        }
        if (s == null)
        {
            throw new NullPointerException("callName");
        }
        if (s1 == null)
        {
            throw new NullPointerException("apiVersion");
        } else
        {
            setOperationName(s);
            setServiceName("Trading");
            iafToken = ebaytradingapi.iafToken;
            site = ebaytradingapi.site;
            apiVersion = s1;
            return;
        }
    }

    public void appendErrorData(LogTrackError logtrackerror, EbayResponse ebayresponse, IOException ioexception)
    {
        super.appendErrorData(logtrackerror, ebayresponse, ioexception);
        EbayRequest.addSiteInfo(logtrackerror, site);
        ebayresponse = getFirstResponseError(ebayresponse);
        if (ebayresponse != null)
        {
            logtrackerror.setErrorCode((new StringBuilder()).append("T").append(ebayresponse.getId()).toString());
        }
    }

    public volatile void appendErrorData(LogTrackError logtrackerror, Response response, IOException ioexception)
    {
        appendErrorData(logtrackerror, (EbayResponse)response, ioexception);
    }

    public void clearResponse()
    {
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.tradingApiUrl);
    }

    public int getRetryCount()
    {
        return 2;
    }

    public boolean hasRecoverableError(Response response, IOException ioexception)
    {
        if (response != null)
        {
            if ((response = response.getResultStatus().getFirstMessage()) instanceof EbayResponseError)
            {
                return EbayTradingApi.isRecoverableError(((EbayResponseError)response).code);
            }
        }
        return false;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        EbayAppCredentials ebayappcredentials = EbayAppCredentials.get(getEbayContext());
        iheaders.setHeader("Content-Type", contentType);
        iheaders.setHeader("x-ebay-api-compatibility-level", apiVersion);
        iheaders.setHeader("x-ebay-api-siteid", site.id);
        iheaders.setHeader("x-ebay-api-iaf-token", iafToken);
        iheaders.setHeader("x-ebay-api-dev-name", ebayappcredentials.developerId);
        iheaders.setHeader("x-ebay-api-app-name", ebayappcredentials.appId);
        iheaders.setHeader("x-ebay-api-cert-name", ebayappcredentials.certId);
        iheaders.setHeader("x-ebay-api-call-name", getOperationName());
        super.onAddHeaders(iheaders);
    }

    public void validateFailure(EbayContext ebaycontext, Response response)
        throws InterruptedException
    {
        if (site == null)
        {
            return;
        } else
        {
            EbayErrorUtil.validateInvalidIafTokenError(ebaycontext, iafToken, site.idString, response);
            return;
        }
    }
}
