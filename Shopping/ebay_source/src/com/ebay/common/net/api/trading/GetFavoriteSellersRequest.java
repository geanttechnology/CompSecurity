// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFavoriteSellersResponse

public final class GetFavoriteSellersRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public GetFavoriteSellersRequest(EbayTradingApi ebaytradingapi)
    {
        super(ebaytradingapi, "GetMyeBayBuying");
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetMyeBayBuying");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "FavoriteSellers");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Include", "true");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "FavoriteSellers");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetMyeBayBuying");
    }

    public GetFavoriteSellersResponse getResponse()
    {
        return new GetFavoriteSellersResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
