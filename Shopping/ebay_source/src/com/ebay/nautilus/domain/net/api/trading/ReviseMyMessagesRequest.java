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
//            EbayTradingRequest, ReviseMyMessagesResponse, EbayTradingApi

public final class ReviseMyMessagesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final int MAX_NUM_MESSAGES = 10;
    public static final String OPERATION_NAME = "ReviseMyMessages";
    private final Boolean isFlagged;
    private final Boolean isRead;
    private final List messages;
    private final Long targetFolderId;

    public ReviseMyMessagesRequest(EbayTradingApi ebaytradingapi, List list, Long long1, Boolean boolean1, Boolean boolean2)
    {
        super(ebaytradingapi, "ReviseMyMessages");
        messages = list;
        isRead = boolean1;
        isFlagged = boolean2;
        targetFolderId = long1;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "ReviseMyMessagesRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnMessages");
        xmlserializer.startTag(null, "MessageIDs");
        for (Iterator iterator = messages.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MessageID", ((EbayMessage)iterator.next()).messageId)) { }
        xmlserializer.endTag(null, "MessageIDs");
        if (targetFolderId != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "FolderID", Long.toString(targetFolderId.longValue()));
        }
        if (isFlagged != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Flagged", isFlagged.toString());
        }
        if (isRead != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Read", isRead.toString());
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "ReviseMyMessagesRequest");
    }

    public ReviseMyMessagesResponse getResponse()
    {
        return new ReviseMyMessagesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
