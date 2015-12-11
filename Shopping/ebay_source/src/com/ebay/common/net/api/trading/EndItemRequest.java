// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            EndItemResponse

public final class EndItemRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String CALL_NAME = "EndItem";
    long itemID;
    String reason;

    public EndItemRequest(EbayTradingApi ebaytradingapi, long l, String s)
    {
        super(ebaytradingapi, "EndItem");
        itemID = l;
        reason = s;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "EndItem");
        XmlSerializerHelper.writeSimple(xmlserializer, null, "Version", apiVersion);
        XmlSerializerHelper.writeSimple(xmlserializer, null, "EndingReason", reason);
        XmlSerializerHelper.writeSimple(xmlserializer, null, "ItemID", String.valueOf(itemID));
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "EndItem");
    }

    public EndItemResponse getResponse()
    {
        return new EndItemResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
