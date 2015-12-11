// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, GetMemberMessagesResponse, EbayTradingApi

public final class GetMemberMessagesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final String messageId;

    public GetMemberMessagesRequest(EbayTradingApi ebaytradingapi, String s)
    {
        super(ebaytradingapi, "GetMemberMessages");
        messageId = s;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetMemberMessagesRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "WarningLevel", "High");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MailMessageType", "All");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", messageId);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetMemberMessagesRequest");
    }

    public GetMemberMessagesResponse getResponse()
    {
        return new GetMemberMessagesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
