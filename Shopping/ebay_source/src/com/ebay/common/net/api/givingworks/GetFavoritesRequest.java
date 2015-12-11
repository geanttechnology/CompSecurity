// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FundRaisingRequest, FindNonProfitResponse

public class GetFavoritesRequest extends FundRaisingRequest
{

    public static final String OPERATION_NAME = "getFavorites";
    private static final String REQUEST_NAME = "getFavoritesRequest";
    public final String detailLevel = "Full";
    private final List outputSelector = Arrays.asList(new String[] {
        "Address", "FavoriteCount"
    });
    public final String userName;

    public GetFavoritesRequest(Authentication authentication, EbaySite ebaysite)
    {
        super(ebaysite, false, "getFavorites");
        super.iafToken = authentication.iafToken;
        userName = authentication.user;
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/fundraising/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v1/services", "getFavoritesRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "userName", userName);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "detailLevel", "Full");
        if (outputSelector != null)
        {
            for (Iterator iterator = outputSelector.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v1/services", "outputSelector", (String)iterator.next())) { }
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v1/services", "getFavoritesRequest");
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.fundRaisingUserUrl);
    }

    public FindNonProfitResponse getResponse()
    {
        return new FindNonProfitResponse("http://www.ebay.com/marketplace/fundraising/v1/services");
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
