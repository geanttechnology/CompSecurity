// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shippinglabel;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.api.shippinglabel.ShippingLabelBaseRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.shippinglabel:
//            GetShippingLabelResponse

public class CancelShippingLabelRequest extends ShippingLabelBaseRequest
{
    private static final class LabelParams
    {

        private final String labelId;
        private final String reason;

        public LabelParams(String s, String s1)
        {
            labelId = s;
            reason = s1;
        }
    }


    private final LabelParams params;

    CancelShippingLabelRequest(String s, String s1, String s2)
    {
        super(SHIPPING_LABEL_SERVICE_NAME, SHIPPING_LABEL_OPERATION_NAME);
        iafToken = s1;
        params = new LabelParams(s, s2);
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
        URL url;
        try
        {
            url = new URL(ApiSettings.getUrl(EbaySettings.printShippingLabelUrl), "label/cancel");
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException();
        }
        return url;
    }

    public GetShippingLabelResponse getResponse()
    {
        return new GetShippingLabelResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
