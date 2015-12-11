// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.EbayAppCredentials;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.LogTrackError;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            EbayShoppingApi

public abstract class EbayShoppingRequest extends EbayRequest
{

    private static final String API_APP_ID = "x-ebay-api-app-id";
    private static final String API_REQUEST_ENCODING = "x-ebay-api-request-encoding";
    private static final String API_SITE_ID_SHOPPING = "x-ebay-api-site-id";
    private static final String API_VERSION = "x-ebay-api-version";
    public static final String SUPPORTED_API_VERSION = "933";
    public final String apiVersion;
    public final EbaySite site;

    protected EbayShoppingRequest(EbayShoppingApi ebayshoppingapi, String s)
    {
        this(ebayshoppingapi, s, "933");
    }

    protected EbayShoppingRequest(EbayShoppingApi ebayshoppingapi, String s, String s1)
    {
        if (ebayshoppingapi == null)
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
            setServiceName("Shopping");
            site = ebayshoppingapi.site;
            apiVersion = s1;
            return;
        }
    }

    public void appendErrorData(LogTrackError logtrackerror, EbayResponse ebayresponse, IOException ioexception)
    {
label0:
        {
            super.appendErrorData(logtrackerror, ebayresponse, ioexception);
            EbayRequest.addSiteInfo(logtrackerror, site);
            ebayresponse = getFirstResponseError(ebayresponse);
            if (ebayresponse != null)
            {
                if (!(ebayresponse instanceof EbayResponseError))
                {
                    break label0;
                }
                ebayresponse = (EbayResponseError)ebayresponse;
                logtrackerror.setErrorCode((new StringBuilder()).append("S").append(((EbayResponseError) (ebayresponse)).code).toString());
            }
            return;
        }
        logtrackerror.setErrorCode((new StringBuilder()).append("S").append(ebayresponse.getId()).toString());
    }

    public volatile void appendErrorData(LogTrackError logtrackerror, Response response, IOException ioexception)
    {
        appendErrorData(logtrackerror, (EbayResponse)response, ioexception);
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.shoppingApiUrl);
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        EbayAppCredentials ebayappcredentials = EbayAppCredentials.get(getEbayContext());
        iheaders.setHeader("Content-Type", "text/xml");
        iheaders.setHeader("x-ebay-api-app-id", ebayappcredentials.appId);
        iheaders.setHeader("x-ebay-api-version", apiVersion);
        iheaders.setHeader("x-ebay-api-site-id", site.id);
        iheaders.setHeader("x-ebay-api-request-encoding", "XML");
        iheaders.setHeader("x-ebay-api-call-name", getOperationName());
        super.onAddHeaders(iheaders);
    }
}
