// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayRequest;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public final class GetMyEbaySellerTotalsSellingRequest extends GetMyEbayRequest
{

    public GetMyEbaySellerTotalsSellingRequest(EbayTradingApi ebaytradingapi, String s, int i, int j)
    {
        super(ebaytradingapi, s, i, j, "GetMyeBaySelling");
    }

    protected void buildXmlRequest(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "SellingSummary");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Include", "true");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "SellingSummary");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "SoldList");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Include", "true");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "SoldList");
    }
}
