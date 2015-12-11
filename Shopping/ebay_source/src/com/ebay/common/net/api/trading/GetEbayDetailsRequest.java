// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

public final class GetEbayDetailsRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final ArrayList details;

    public GetEbayDetailsRequest(EbayTradingApi ebaytradingapi, ArrayList arraylist)
    {
        super(ebaytradingapi, "GetEbayDetails");
        details = arraylist;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GeteBayDetailsRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        if (details != null)
        {
            for (Iterator iterator = details.iterator(); iterator.hasNext(); XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailName", (String)iterator.next())) { }
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GeteBayDetailsRequest");
    }

    public GetEbayDetailsResponse getResponse()
    {
        return new GetEbayDetailsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
