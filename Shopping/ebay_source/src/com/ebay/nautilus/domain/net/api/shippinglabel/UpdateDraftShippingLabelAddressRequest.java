// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shippinglabel;

import com.ebay.nautilus.domain.data.ShippingLabelContact;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shippinglabel:
//            ShippingLabelBaseRequest, DraftShippingLabelResponse

public class UpdateDraftShippingLabelAddressRequest extends ShippingLabelBaseRequest
{
    private static final class LabelRequestParams
    {

        private final ShippingLabelContact address;
        private final com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType addressType;

        public LabelRequestParams(ShippingLabelContact shippinglabelcontact, com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType shippingaddresstype)
        {
            address = shippinglabelcontact;
            addressType = shippingaddresstype;
        }
    }


    private static final String ADDRESS = "/address";
    private final String labelId;
    private final LabelRequestParams params;
    private final URL url;

    public UpdateDraftShippingLabelAddressRequest(ShippingLabelContact shippinglabelcontact, com.ebay.nautilus.domain.data.ShippingLabelContact.ShippingAddressType shippingaddresstype, String s, String s1, URL url1)
    {
        super(SHIPPING_LABEL_SERVICE_NAME, SHIPPING_LABEL_OPERATION_NAME);
        params = new LabelRequestParams(shippinglabelcontact, shippingaddresstype);
        url = url1;
        labelId = s;
        iafToken = s1;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(params).getBytes();
    }

    public String getHttpMethod()
    {
        return "PUT";
    }

    public URL getRequestUrl()
    {
        URL url1;
        try
        {
            url1 = new URL(url, (new StringBuilder(getOperationName())).append("/").append(labelId).append("/address").toString());
        }
        catch (MalformedURLException malformedurlexception)
        {
            throw new RuntimeException();
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
