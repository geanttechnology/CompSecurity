// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, DeleteMyMessagesResponse, EbayTradingApi

public class DeleteMyMessagesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final int MAX_NUM_MESSAGES = 10;
    public static final String OPERATION_NAME = "DeleteMyMessages";
    private final List messages;

    public DeleteMyMessagesRequest(EbayTradingApi ebaytradingapi, List list)
    {
        super(ebaytradingapi, "DeleteMyMessages");
        messages = list;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "DeleteMyMessagesRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag(null, "MessageIDs");
        for (Iterator iterator = messages.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, null, "MessageID", ((EbayMessage)iterator.next()).messageId)) { }
        xmlserializer.endTag(null, "MessageIDs");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "DeleteMyMessagesRequest");
    }

    public DeleteMyMessagesResponse getResponse()
    {
        return new DeleteMyMessagesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
