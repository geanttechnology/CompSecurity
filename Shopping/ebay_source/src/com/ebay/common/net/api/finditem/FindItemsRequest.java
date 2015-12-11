// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.finditem:
//            FindItemService, FindItemsResponse

public class FindItemsRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    protected static final String ITEM_BID_COUNT = "BID_COUNT";
    protected static final String ITEM_BIN_PRICE = "BIN_PRICE";
    protected static final String ITEM_BUYER_FIXED_SHIPPING_COST = "BUYER_FIXED_SHIPPING_COST";
    protected static final String ITEM_CONDITION_NEW = "ITEM_CONDITION_NEW";
    protected static final String ITEM_CURRENCY = "CURRENCY";
    protected static final String ITEM_CURRENT_PRICE = "CURRENT_PRICE";
    protected static final String ITEM_END_TIME = "END_TIME";
    protected static final String ITEM_FLAT_SHIP_COST = "FLAT_SHIP_COST";
    protected static final String ITEM_FULL_CALCULATED_SHIPPING = "FULL_CALCULATED_SHIPPING";
    protected static final String ITEM_ID = "ITEM_ID";
    protected static final String ITEM_IS_FREE_SHIPPING = "IS_FREE_SHIPPING";
    protected static final String ITEM_IS_INSURANCE_REQUIRED = "IS_INSURANCE_REQUIRED";
    protected static final String ITEM_LEAF_CATS = "LEAF_CATS";
    protected static final String ITEM_MD5_IMAGE = "MD5_IMAGE";
    protected static final String ITEM_PRODUCT_REFID = "PRODUCT_REFID";
    protected static final String ITEM_SAFE_START_TIME = "SAFE_START_TIME";
    protected static final String ITEM_SALE_TYPE = "SALE_TYPE";
    protected static final String ITEM_SHIPPING_FLAG = "SHIPPING_FLAG";
    protected static final String ITEM_SITE = "SITE";
    protected static final String ITEM_SOLD_AS_BIN = "SOLD_AS_BIN";
    protected static final String ITEM_START_PRICE = "START_PRICE";
    protected static final String ITEM_TITLE = "TITLE";
    private static final String attrNamespace = "http://www.w3.org/2001/XMLSchema-instance";
    private static final String namespace = "http://www.ebay.com/marketplace/search/v1/services";
    private static final String soaOperationName = "findItems";
    private final String categoryId;
    private final int fetchOffset;
    private final int fetchSize;
    private final String keywords;
    private final String siteId;

    public FindItemsRequest(FindItemService finditemservice, String s, String s1, int i, int j)
    {
        super("FindItemService", false, "findItems");
        soaServiceVersion = "1.4.0";
        dataFormat = "XML";
        responseDataFormat = "XML";
        soaGlobalId = finditemservice.site.idString;
        siteId = finditemservice.site.id;
        categoryId = s;
        keywords = s1;
        fetchOffset = j;
        fetchSize = i;
    }

    private static void addReadSet(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        xmlserializer.setPrefix("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "readSet");
        xmlserializer.attribute("http://www.w3.org/2001/XMLSchema-instance", "type", "Member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ItemDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", s);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "readSet");
    }

    private static void startTagWithType(XmlSerializer xmlserializer, String s, String s1)
        throws IOException
    {
        xmlserializer.setPrefix("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", s);
        xmlserializer.attribute("http://www.w3.org/2001/XMLSchema-instance", "type", s1);
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "findItemsRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "itemSearchScope", "ActiveTitle");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "fetchOffset", (new StringBuilder()).append("").append(fetchOffset).toString());
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "fetchSize", (new StringBuilder()).append("").append(fetchSize).toString());
        addReadSet(xmlserializer, "ITEM_ID");
        addReadSet(xmlserializer, "TITLE");
        addReadSet(xmlserializer, "LEAF_CATS");
        addReadSet(xmlserializer, "SITE");
        addReadSet(xmlserializer, "PRODUCT_REFID");
        addReadSet(xmlserializer, "ITEM_CONDITION_NEW");
        addReadSet(xmlserializer, "BIN_PRICE");
        addReadSet(xmlserializer, "CURRENT_PRICE");
        addReadSet(xmlserializer, "CURRENCY");
        addReadSet(xmlserializer, "BID_COUNT");
        addReadSet(xmlserializer, "SALE_TYPE");
        addReadSet(xmlserializer, "SAFE_START_TIME");
        addReadSet(xmlserializer, "END_TIME");
        addReadSet(xmlserializer, "BUYER_FIXED_SHIPPING_COST");
        addReadSet(xmlserializer, "FLAT_SHIP_COST");
        addReadSet(xmlserializer, "FULL_CALCULATED_SHIPPING");
        addReadSet(xmlserializer, "MD5_IMAGE");
        addReadSet(xmlserializer, "IS_FREE_SHIPPING");
        addReadSet(xmlserializer, "SHIPPING_FLAG");
        addReadSet(xmlserializer, "IS_INSURANCE_REQUIRED");
        addReadSet(xmlserializer, "SOLD_AS_BIN");
        addReadSet(xmlserializer, "START_PRICE");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "KeywordLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "CONTAINS");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", keywords);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ItemDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "LEAF_CATS");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", categoryId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ItemDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "SITE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", siteId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "GT");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ItemDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "SEARCH_PICTURE_VERSION");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", "0");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "sortBy");
        startTagWithType(xmlserializer, "sortType", "BestMatchSortType");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "shiptocty", "0");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "sortType");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "sortOrder", "DECREASING");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "sortBy");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "findItemsRequest");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.findItemService);
    }

    public FindItemsResponse getResponse()
    {
        return new FindItemsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-soa-service-name", "{http://www.ebay.com/marketplace/search/v1/services}FindItemService");
    }
}
