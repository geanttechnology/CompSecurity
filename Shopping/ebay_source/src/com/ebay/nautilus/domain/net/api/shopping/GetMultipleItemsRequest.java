// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            EbayShoppingRequest, GetMultipleItemsResponse, EbayShoppingApi

public final class GetMultipleItemsRequest extends EbayShoppingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final List itemIds;
    private final String selector;

    public GetMultipleItemsRequest(EbayShoppingApi ebayshoppingapi, List list, String s)
    {
        super(ebayshoppingapi, "GetMultipleItems");
        itemIds = list;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetMultipleItemsRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MobileClient", "true");
        for (Iterator iterator = itemIds.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", ((Long)iterator.next()).toString())) { }
        if (!TextUtils.isEmpty(selector))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeSelector", selector);
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetMultipleItemsRequest");
    }

    public GetMultipleItemsResponse getResponse()
    {
        return new GetMultipleItemsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
