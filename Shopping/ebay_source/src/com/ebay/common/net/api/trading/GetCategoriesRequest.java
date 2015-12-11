// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetCategoriesResponse

public final class GetCategoriesRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final EbayCategory parentCategory;

    public GetCategoriesRequest(EbayTradingApi ebaytradingapi, EbayCategory ebaycategory)
    {
        super(ebaytradingapi, "GetCategories");
        parentCategory = ebaycategory;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetCategoriesRequest");
        int i = 1;
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        if (parentCategory != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CategoryParent", String.valueOf(parentCategory.id));
            i = 1 + parentCategory.level;
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "LevelLimit", String.valueOf(i));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ViewAllNodes", "true");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnAll");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetCategoriesRequest");
    }

    public GetCategoriesResponse getResponse()
    {
        return new GetCategoriesResponse(false);
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
