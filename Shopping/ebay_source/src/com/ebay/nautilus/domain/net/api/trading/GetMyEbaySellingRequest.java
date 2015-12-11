// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayRequest, EbayTradingApi

public final class GetMyEbaySellingRequest extends GetMyEbayRequest
{

    protected final String filter;

    public GetMyEbaySellingRequest(EbayTradingApi ebaytradingapi, String s, int i, int j, String s1, String s2)
    {
        super(ebaytradingapi, s, i, j, "GetMyeBaySelling", s1);
        filter = s2;
    }

    protected void buildXmlRequest(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", s);
        if ("ActiveList".equals(s) || "UnsoldList".equals(s))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "HideVariations", "true");
        }
        if ("ActiveList".equals(s) && !TextUtils.isEmpty(filter))
        {
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ActiveList", "ListingType", filter);
        } else
        {
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ActiveList");
        }
        if ("SoldList".equals(s) && !TextUtils.isEmpty(filter))
        {
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "SoldList", "OrderStatusFilter", filter);
        } else
        {
            writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "SoldList");
        }
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UnsoldList");
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ScheduledList");
    }
}
