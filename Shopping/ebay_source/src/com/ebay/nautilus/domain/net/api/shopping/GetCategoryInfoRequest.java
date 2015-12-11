// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            EbayShoppingRequest, GetCategoryInfoResponse, EbayShoppingApi

public final class GetCategoryInfoRequest extends EbayShoppingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final long categoryId;
    public boolean includeChildCategories;

    public GetCategoryInfoRequest(EbayShoppingApi ebayshoppingapi, long l)
    {
        super(ebayshoppingapi, "GetCategoryInfo");
        includeChildCategories = false;
        categoryId = l;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetCategoryInfoRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CategoryID", String.valueOf(categoryId));
        if (includeChildCategories)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeSelector", "ChildCategories");
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetCategoryInfoRequest");
    }

    public GetCategoryInfoResponse getResponse()
    {
        return new GetCategoryInfoResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
