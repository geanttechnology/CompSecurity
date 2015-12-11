// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shippinglabel;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.api.shippinglabel.ShippingLabelBaseRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.common.net.api.shippinglabel:
//            GenerateShippingLabelResponse

public class GenerateShippingLabelRequest extends ShippingLabelBaseRequest
{

    private final String labelId;

    GenerateShippingLabelRequest(String s, String s1)
    {
        super(SHIPPING_LABEL_SERVICE_NAME, SHIPPING_LABEL_OPERATION_NAME);
        labelId = s;
        iafToken = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return "{}".getBytes();
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
            url = new URL(ApiSettings.getUrl(EbaySettings.printShippingLabelUrl), (new StringBuilder()).append("draftlabel/").append(labelId).append("/generate").toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException();
        }
        return url;
    }

    public GenerateShippingLabelResponse getResponse()
    {
        return new GenerateShippingLabelResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
