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
//            GetShippingLabelResponse

public class GetShippingLabelRequest extends ShippingLabelBaseRequest
{

    private final String workOrderID;

    GetShippingLabelRequest(String s, String s1)
    {
        super(SHIPPING_LABEL_SERVICE_NAME, SHIPPING_LABEL_OPERATION_NAME);
        workOrderID = s;
        iafToken = s1;
    }

    public String getHttpMethod()
    {
        return "GET";
    }

    public URL getRequestUrl()
    {
        URL url;
        try
        {
            url = new URL(ApiSettings.getUrl(EbaySettings.printShippingLabelUrl), (new StringBuilder("label")).append("/").append(workOrderID).toString());
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
