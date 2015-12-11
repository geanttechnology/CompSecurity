// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.model.EbayProductDomain;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.shopping:
//            FindProductsResponse

public final class FindProductsRequest extends EbayShoppingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final String categoryId;
    private final List domains;
    private final String maxEntries;
    private final String productId;
    private final String productIdType;
    private final String queryKeywords;
    private final boolean singleProduct;

    public FindProductsRequest(EbayShoppingApi ebayshoppingapi, long l)
    {
        super(ebayshoppingapi, "FindProducts");
        productId = null;
        productIdType = null;
        maxEntries = "100";
        singleProduct = false;
        domains = null;
        categoryId = Long.toString(l);
        queryKeywords = null;
    }

    public FindProductsRequest(EbayShoppingApi ebayshoppingapi, String s)
    {
        super(ebayshoppingapi, "FindProducts");
        productId = null;
        productIdType = null;
        maxEntries = "200";
        singleProduct = false;
        categoryId = null;
        domains = null;
        queryKeywords = s;
    }

    public FindProductsRequest(EbayShoppingApi ebayshoppingapi, String s, String s1)
    {
        super(ebayshoppingapi, "FindProducts");
        productId = s;
        productIdType = s1;
        queryKeywords = null;
        maxEntries = "1";
        domains = null;
        categoryId = null;
        singleProduct = true;
    }

    public FindProductsRequest(EbayShoppingApi ebayshoppingapi, String s, List list)
    {
        super(ebayshoppingapi, "FindProducts");
        productId = null;
        productIdType = null;
        maxEntries = "200";
        singleProduct = false;
        categoryId = null;
        queryKeywords = s;
        domains = list;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "FindProductsRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MaxEntries", maxEntries);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "HideDuplicateItems", "true");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "AvailableItemsOnly", "false");
        if (!singleProduct) goto _L2; else goto _L1
_L1:
        XmlSerializerHelper.writeTagWithAttribute(xmlserializer, null, "ProductID", productId, "type", productIdType);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ProductSort", "Title");
_L4:
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "FindProductsRequest");
        return;
_L2:
        if (queryKeywords != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "QueryKeywords", queryKeywords);
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeSelector", "DomainHistogram");
            if (domains != null)
            {
                for (Iterator iterator = domains.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DomainName", ((EbayProductDomain)iterator.next()).toString())) { }
            }
        }
        if (categoryId != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CategoryID", categoryId);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public FindProductsResponse getResponse()
    {
        return new FindProductsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
