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

public final class GetMyEbayBuyingRequest extends GetMyEbayRequest
{

    private final String customListName;

    public GetMyEbayBuyingRequest(EbayTradingApi ebaytradingapi, int i, int j, String s)
    {
        this(ebaytradingapi, "UserDefinedList", i, j, s, null);
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("customListName must not be null!");
        } else
        {
            return;
        }
    }

    public GetMyEbayBuyingRequest(EbayTradingApi ebaytradingapi, String s, int i, int j)
    {
        this(ebaytradingapi, s, i, j, null, null);
    }

    public GetMyEbayBuyingRequest(EbayTradingApi ebaytradingapi, String s, int i, int j, String s1)
    {
        this(ebaytradingapi, s, i, j, null, s1);
    }

    private GetMyEbayBuyingRequest(EbayTradingApi ebaytradingapi, String s, int i, int j, String s1, String s2)
    {
        super(ebaytradingapi, s, i, j, "GetMyeBayBuying", s2);
        customListName = s1;
    }

    protected void buildXmlRequest(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
        if ("UserDefinedList".equals(s) || "LostList".equals(s))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Version", apiVersion);
        }
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "OutputSelector", s);
        if ("UserDefinedList".equals(s))
        {
            xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "UserDefinedLists");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeItemCount", "true");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeListContents", "true");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UserDefinedListName", customListName);
            xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "UserDefinedLists");
        }
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WatchList");
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "BidList");
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WonList");
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "LostList");
        writeInclude(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "BestOfferList");
    }
}
