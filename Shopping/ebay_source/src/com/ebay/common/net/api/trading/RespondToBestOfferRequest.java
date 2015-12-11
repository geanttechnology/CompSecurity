// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            RespondToBestOfferResponse

public class RespondToBestOfferRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final String ACTION_ACCEPT = "Accept";
    public static final String ACTION_COUNTER = "Counter";
    public static final String ACTION_DECLINE = "Decline";
    private final String action;
    private final long bestOfferId;
    private final String counterOfferCode;
    private final Double counterOfferPrice;
    private final int counterOfferQuantity;
    private final long itemId;
    private final String sellerResponse;

    public RespondToBestOfferRequest(EbayTradingApi ebaytradingapi, String s, long l, long l1, String s1, 
            Double double1, String s2, int i)
    {
        super(ebaytradingapi, "RespondToBestOffer");
        action = s;
        itemId = l;
        bestOfferId = l1;
        sellerResponse = s1;
        counterOfferPrice = double1;
        counterOfferCode = s2;
        counterOfferQuantity = i;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "RespondToBestOfferRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Action", action);
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(itemId));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "BestOfferID", String.valueOf(bestOfferId));
        if (counterOfferPrice != null)
        {
            XmlSerializerHelper.writeTagWithAttribute(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CounterOfferPrice", (new StringBuilder()).append("").append(counterOfferPrice).toString(), "currencyID", counterOfferCode);
        }
        if (counterOfferQuantity > 0)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "CounterOfferQuantity", String.valueOf(counterOfferQuantity));
        }
        if (!TextUtils.isEmpty(sellerResponse))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "SellerResponse", sellerResponse);
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "RespondToBestOfferRequest");
    }

    public RespondToBestOfferResponse getResponse()
    {
        return new RespondToBestOfferResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
