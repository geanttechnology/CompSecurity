// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.SavedSearch;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import java.io.IOException;
import java.util.Date;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi, SearchParameters

public static final class iafToken extends iafToken
{

    private final int pageIndex;
    public final SavedSearch savedSearch;

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        SavedSearch savedsearch = savedSearch;
        int i = pageIndex;
        String s = (new StringBuilder()).append(getOperationName()).append("Request").toString();
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/search/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/search/v1/services", s);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "searchId", savedsearch.id);
        if (savedsearch.newItemsOnly && savedsearch.since > 0L)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", "startTimeFrom", EbayDateUtils.formatIso8601DateTime(new Date(savedsearch.since)));
        }
        XmlSerializerHelper.writePaginationInput(xmlserializer, "http://www.ebay.com/marketplace/search/v1/services", i, savedsearch.searchParameters.maxCountPerPage);
        xmlserializer.endTag("http://www.ebay.com/marketplace/search/v1/services", s);
    }

    public (SavedSearch savedsearch, int i)
    {
        super("findItemsForFavoriteSearch");
        savedSearch = savedsearch;
        pageIndex = i / savedsearch.searchParameters.maxCountPerPage + 1;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        iafToken = savedsearch.searchParameters.iafToken;
    }
}
