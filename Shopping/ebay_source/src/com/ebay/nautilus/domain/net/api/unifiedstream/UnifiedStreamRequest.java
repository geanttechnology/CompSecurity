// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.data.UnifiedStream.PaginationInput;
import com.ebay.nautilus.domain.data.UnifiedStream.RequestContext;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.unifiedstream:
//            UnifiedStreamResponse

public class UnifiedStreamRequest extends EbayCosRequest
{
    public static class Params
    {

        public boolean blended;
        public List categoryId;
        public String channel;
        public String department;
        public String lastRefreshedTag;
        public List outputSelector;
        public PaginationInput paginationInput;
        public RequestContext requestContext;

        public Params()
        {
            blended = false;
        }
    }


    private final Params params;

    public UnifiedStreamRequest(String s, EbayCountry ebaycountry, Params params1)
    {
        super("unifiedstream", "content", CosVersionType.V3);
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        territory = ebaycountry.getCountryCode();
        marketPlaceId = ebaycountry.getSiteGlobalId();
        iafToken = s;
        params = params1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(params).getBytes();
    }

    public String getHttpMethod()
    {
        return "POST";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.unifiedStreamUrl);
    }

    public UnifiedStreamResponse getResponse()
    {
        return new UnifiedStreamResponse();
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
