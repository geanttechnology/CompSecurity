// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ecas;

import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.net.ResponseWrapper;
import com.ebay.nautilus.domain.net.api.ecas.models.EcasCheckoutResponse;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.io.InputStream;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ecas:
//            EcasApiResponse

public class CheckoutResponse extends EcasApiResponse
{
    public static class Wrapper extends BaseDataMapped
        implements ResponseWrapper
    {

        private EcasCheckoutResponse callResponse;

        public EcasCheckoutResponse getResponse()
        {
            return callResponse;
        }

        public volatile BaseApiResponse getResponse()
        {
            return getResponse();
        }

        public Wrapper()
        {
        }
    }


    public CheckoutResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (Wrapper)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/ecas/CheckoutResponse$Wrapper);
        if (inputstream != null)
        {
            super.setCasResponse(inputstream.getResponse());
        }
    }
}
