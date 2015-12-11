// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.AllBiddersData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersResponse

private final class allBidders extends com.ebay.nautilus.kernel.util.y
{

    private final AllBiddersData allBidders;
    final GetAllBiddersResponse this$0;

    public com.ebay.nautilus.kernel.util.y get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Offer".equals(s1))
        {
            return new it>(GetAllBiddersResponse.this, allBidders);
        } else
        {
            return super.allBidders(s, s1, s2, attributes);
        }
    }

    public (AllBiddersData allbiddersdata)
    {
        this$0 = GetAllBiddersResponse.this;
        super();
        allBidders = allbiddersdata;
    }
}
