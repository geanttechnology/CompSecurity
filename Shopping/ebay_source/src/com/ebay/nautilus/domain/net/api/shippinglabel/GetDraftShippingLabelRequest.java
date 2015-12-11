// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippinglabel;

import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippinglabel:
//            ShippingLabelBaseRequest, DraftShippingLabelResponse

public class GetDraftShippingLabelRequest extends ShippingLabelBaseRequest
{
    public static final class LabelParams
    {

        private final Set orderIds = new HashSet();

        public LabelParams(String s, String s1)
        {
            orderIds.add(new OrderParams(s, s1));
        }
    }

    private static class LabelParams.OrderParams
    {

        private final String itemId;
        private final String transactionId;

        LabelParams.OrderParams(String s, String s1)
        {
            itemId = s;
            transactionId = s1;
        }
    }


    private final LabelParams params;
    private final URL url;

    public GetDraftShippingLabelRequest(String s, String s1, String s2, String s3)
    {
        super(SHIPPING_LABEL_SERVICE_NAME, SHIPPING_LABEL_OPERATION_NAME);
        try
        {
            url = new URL(s3);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        iafToken = s2;
        params = new LabelParams(s, s1);
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
        URL url1;
        try
        {
            url1 = new URL((new StringBuilder()).append(url).append(getOperationName()).toString());
        }
        catch (IOException ioexception)
        {
            return url;
        }
        return url1;
    }

    public DraftShippingLabelResponse getResponse()
    {
        return new DraftShippingLabelResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
