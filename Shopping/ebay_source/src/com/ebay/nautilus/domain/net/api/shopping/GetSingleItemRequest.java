// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            EbayShoppingRequest, GetSingleItemResponse, EbayShoppingApi

public final class GetSingleItemRequest extends EbayShoppingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String OPERATION_NAME = "GetSingleItem";
    private final long itemId;
    private final String selector;

    public GetSingleItemRequest(EbayShoppingApi ebayshoppingapi, long l, String s)
    {
        super(ebayshoppingapi, "GetSingleItem");
        itemId = l;
        selector = s;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetSingleItemRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MobileClient", "true");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(itemId));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeSelector", selector);
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetSingleItemRequest");
    }

    public GetSingleItemResponse getResponse()
    {
        return new GetSingleItemResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
