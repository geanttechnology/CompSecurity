// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.search:
//            FindPopularSearchesResponse

public final class FindPopularSearchesRequest extends EbayShoppingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String MAX_RELATED_SEARCHES = "10";
    public static final String OPERATION_NAME = "FindPopularSearches";
    private final List categories;
    private final String keywords;

    public FindPopularSearchesRequest(EbayShoppingApi ebayshoppingapi, String s, List list)
    {
        super(ebayshoppingapi, "FindPopularSearches");
        keywords = s;
        categories = list;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "FindPopularSearchesRequest");
        if (!TextUtils.isEmpty(keywords))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "QueryKeywords", keywords);
        }
        if (categories != null)
        {
            for (Iterator iterator = categories.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CategoryID", String.valueOf(((EbayCategorySummary)iterator.next()).id))) { }
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MaxKeywords", "10");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "FindPopularSearchesRequest");
    }

    public FindPopularSearchesResponse getResponse()
    {
        return new FindPopularSearchesResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
