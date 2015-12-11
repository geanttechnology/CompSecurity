// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class timestamp extends com.ebay.nautilus.kernel.util.t
{

    private final EbayResponse response;
    final GetOrdersResponse this$0;
    private final TimestampElement timestamp;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Ack".equals(s1))
        {
            return new AckElement(response);
        }
        if ("Timestamp".equals(s1))
        {
            return timestamp;
        }
        if ("Errors".equals(s1))
        {
            return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
        }
        if ("OrderArray".equals(s1))
        {
            orders = new ArrayList();
            return new init>(GetOrdersResponse.this, response);
        } else
        {
            return super.response(s, s1, s2, attributes);
        }
    }

    public (EbayResponse ebayresponse)
    {
        this$0 = GetOrdersResponse.this;
        super();
        response = ebayresponse;
        timestamp = new TimestampElement(ebayresponse);
    }
}
