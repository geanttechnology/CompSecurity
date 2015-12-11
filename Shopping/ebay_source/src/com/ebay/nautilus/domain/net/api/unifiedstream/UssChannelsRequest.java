// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Response;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.unifiedstream:
//            UssChannelsResponse

public class UssChannelsRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "channel";

    public UssChannelsRequest(String s, EbayCountry ebaycountry)
    {
        super("unifiedstream", "channel", CosVersionType.V3);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
    }

    public String getHttpMethod()
    {
        return "GET";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.ussChannelsUrl);
    }

    public UssChannelsResponse getResponse()
    {
        return new UssChannelsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected void initialize(ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        super.initialize(resultstatusowner);
        endUserContext = buildEndUserContext(territory, null, null, null, true);
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
