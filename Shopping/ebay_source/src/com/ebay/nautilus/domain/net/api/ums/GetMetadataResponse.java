// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.ums;

import com.ebay.nautilus.domain.net.EbayResponse;
import java.io.InputStream;

// Referenced classes of package com.ebay.nautilus.domain.net.api.ums:
//            Metadata

public class GetMetadataResponse extends EbayResponse
{
    public static class ResponseWrapper
    {

        public Metadata metadata;

        public ResponseWrapper()
        {
        }
    }


    public Metadata metadata;

    public GetMetadataResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        inputstream = (ResponseWrapper)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/ums/GetMetadataResponse$ResponseWrapper);
        if (inputstream != null)
        {
            metadata = ((ResponseWrapper) (inputstream)).metadata;
        }
    }
}
