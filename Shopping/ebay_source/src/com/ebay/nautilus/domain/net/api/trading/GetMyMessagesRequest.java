// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.EbayMessage;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            EbayTradingRequest, GetMyMessagesResponse, EbayTradingApi

public final class GetMyMessagesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final int MAX_NUM_MESSAGES = 10;
    public static final String OPERATION_NAME = "GetMyMessages";
    private final long daysToFetch;
    private final Long folderId;
    private final EbayMessage message;

    public GetMyMessagesRequest(EbayTradingApi ebaytradingapi, Long long1, EbayMessage ebaymessage, long l)
    {
        super(ebaytradingapi, "GetMyMessages");
        folderId = long1;
        message = ebaymessage;
        daysToFetch = l;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetMyMessagesRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        Date date = new Date();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.00'Z'");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("gmt"));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "EndTime", simpledateformat.format(date));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "StartTime", simpledateformat.format(new Date(date.getTime() - 0x5265c00L * daysToFetch)));
        if (message != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnMessages");
            xmlserializer.startTag(null, "MessageIDs");
            XmlSerializerHelper.writeSimple(xmlserializer, null, "MessageID", message.messageId);
            xmlserializer.endTag(null, "MessageIDs");
        } else
        if (folderId != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnHeaders");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "FolderID", Long.toString(folderId.longValue()));
        } else
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnSummary");
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetMyMessagesRequest");
    }

    public GetMyMessagesResponse getResponse()
    {
        return new GetMyMessagesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
