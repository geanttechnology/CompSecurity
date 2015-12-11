// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayOrder;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersResponse

private final class response extends com.ebay.nautilus.kernel.util.y
{

    private final EbayResponse response;
    final GetOrdersResponse this$0;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Order".equals(s1))
        {
            s = new EbayOrder();
            ((GetOrdersResponse)response).orders.add(s);
            return new >(GetOrdersResponse.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public (EbayResponse ebayresponse)
    {
        this$0 = GetOrdersResponse.this;
        super();
        response = ebayresponse;
    }
}
