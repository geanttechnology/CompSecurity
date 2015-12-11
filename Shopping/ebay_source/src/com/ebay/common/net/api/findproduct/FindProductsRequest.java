// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductService, FindProductsResponse

public class FindProductsRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    protected static final String PRODUCT_ALL_CATS = "ALLCATS";
    protected static final String PRODUCT_ID = "PRODUCT_REFERENCE_ID";
    protected static final String PRODUCT_STOCK_PHOTO_URL = "STOCK_PHOTO_URL";
    protected static final String PRODUCT_TITLE = "TITLE";
    private static final String attrNamespace = "http://www.w3.org/2001/XMLSchema-instance";
    private static final String namespace = "http://www.ebay.com/marketplace/search/v1/services";
    private static final String soaOperationName = "findProducts";
    private final String categoryId;
    private final int fetchOffset;
    private final int fetchSize;
    private final String keywords;
    private final String siteId;

    public FindProductsRequest(FindProductService findproductservice, String s, String s1, int i, int j)
    {
        super("FindProductService", false, "findProducts");
        soaServiceVersion = "1.4.0";
        dataFormat = "XML";
        responseDataFormat = "XML";
        siteId = findproductservice.site.id;
        categoryId = s;
        keywords = s1;
        fetchSize = i;
        fetchOffset = j;
    }

    private static void addReadSet(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        xmlserializer.setPrefix("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "readSet");
        xmlserializer.attribute("http://www.w3.org/2001/XMLSchema-instance", "type", "Member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", s);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "readSet");
    }

    private static void operandCatalogIdEq(XmlSerializer xmlserializer, String s)
        throws IOException
    {
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "CATALOG_ID");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", s);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
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
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "findProductsRequest");
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
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "ALLCATS");
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
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "SITE_ID");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", siteId);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "NOT");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "PRODUCT_CONTROL_FLAGS_BIT_VALUE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", "524288");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "NOT");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "PRODUCT_CONTROL_FLAGS_BIT_VALUE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", "1024");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "NOT");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "PRODUCT_CONTROL_FLAGS_BIT_VALUE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", "4");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "longOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "EQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "PRODUCT_NUKE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "tokenOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", "ALL");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "tokenOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "OR");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "NOT");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "HAS_ATTR");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "EXP_DATE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "AND");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "HAS_ATTR");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "EXP_DATE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "SimpleLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "GEQ");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "namespace", "ProductDictionary");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "name", "EXP_DATE");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "member");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "tokenOperand");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operand", (new SimpleDateFormat("yyyyMMdd", Locale.US)).format(new Date()));
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "tokenOperand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        startTagWithType(xmlserializer, "internalExpression", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "NOT");
        startTagWithType(xmlserializer, "operand", "FieldOperand");
        startTagWithType(xmlserializer, "operand", "CompositeLogicalExpression");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "operator", "OR");
        operandCatalogIdEq(xmlserializer, "97");
        operandCatalogIdEq(xmlserializer, "54");
        operandCatalogIdEq(xmlserializer, "516");
        operandCatalogIdEq(xmlserializer, "109");
        operandCatalogIdEq(xmlserializer, "115");
        operandCatalogIdEq(xmlserializer, "116");
        operandCatalogIdEq(xmlserializer, "133");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "operand");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "internalExpression");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "constraint");
        addReadSet(xmlserializer, "PRODUCT_REFERENCE_ID");
        addReadSet(xmlserializer, "TITLE");
        addReadSet(xmlserializer, "STOCK_PHOTO_URL");
        addReadSet(xmlserializer, "ALLCATS");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "fetchSize", (new StringBuilder()).append("").append(fetchSize).toString());
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "fetchOffset", (new StringBuilder()).append("").append(fetchOffset).toString());
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "sortBy");
        startTagWithType(xmlserializer, "sortType", "BestMatchSortType");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "shiptocty", "0");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "sortType");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "sortOrder", "DECREASING");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "sortBy");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "findProductsRequest");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.findProductService);
    }

    public FindProductsResponse getResponse()
    {
        return new FindProductsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-soa-service-name", "{http://www.ebay.com/marketplace/search/v1/services}FindProductService");
    }
}
