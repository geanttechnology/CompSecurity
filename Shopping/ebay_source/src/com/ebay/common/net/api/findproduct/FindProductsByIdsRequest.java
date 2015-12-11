// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsByIdsResponse, FindProductService

public class FindProductsByIdsRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    protected static final String PRODUCT_ALL_CATS = "ALLCATS";
    protected static final String PRODUCT_ID = "PRODUCT_REFERENCE_ID";
    protected static final String PRODUCT_STOCK_PHOTO_URL = "STOCK_PHOTO_URL";
    protected static final String PRODUCT_TITLE = "TITLE";
    private static final String attrNamespace = "http://www.w3.org/2001/XMLSchema-instance";
    private static final String namespace = "http://www.ebay.com/marketplace/search/v1/services";
    private static final String soaOperationName = "findProductsByIds";
    private final ArrayList ids;

    public FindProductsByIdsRequest(FindProductService findproductservice, ArrayList arraylist)
    {
        super("FindProductService", false, "findProductsByIds");
        soaServiceVersion = "1.4.0";
        dataFormat = "XML";
        responseDataFormat = "XML";
        ids = arraylist;
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

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", "findProductsByIdsRequest");
        for (Iterator iterator = ids.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "id", (String)iterator.next())) { }
        addReadSet(xmlserializer, "PRODUCT_REFERENCE_ID");
        addReadSet(xmlserializer, "TITLE");
        addReadSet(xmlserializer, "STOCK_PHOTO_URL");
        addReadSet(xmlserializer, "ALLCATS");
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", "findProductsByIdsRequest");
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.findProductService);
    }

    public FindProductsByIdsResponse getResponse()
    {
        return new FindProductsByIdsResponse();
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
