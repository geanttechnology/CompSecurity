// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.notifications:
//            PollServiceListCache

private static final class  extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.
{

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.ItemArray.Item.ItemID");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.ItemArray.Item.TimeLeft");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "WatchList.ItemArray.Item.ListingDetails.EndTime");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "BidList.ItemArray.Item.TimeLeft");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", "BidList.ItemArray.Item.ListingDetails.EndTime");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "HideVariations", "true");
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WatchList", 200);
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "BidList", 1);
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WonList", 0);
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "LostList", 0);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", s);
    }

    public  getResponse()
    {
        return new (null);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected final void writeInclude(XmlSerializer xmlserializer, String s, String s1, int i)
        throws IOException
    {
        xmlserializer.startTag(s, s1);
        if (i <= 0)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, s, "Include", "false");
        } else
        {
            XmlSerializerHelper.writePagination(xmlserializer, s, 1, i);
            XmlSerializerHelper.writeSimple(xmlserializer, s, "Sort", "TimeLeft");
        }
        xmlserializer.endTag(s, s1);
    }

    public (EbayTradingApi ebaytradingapi)
    {
        super(ebaytradingapi, "GetMyeBayBuying");
    }
}
