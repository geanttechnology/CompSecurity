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
//            GetItemTransactionsResponse

public final class GetItemTransactionsRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private final long itemId;
    private final long transactionId;

    public GetItemTransactionsRequest(EbayTradingApi ebaytradingapi, long l, long l1)
    {
        super(ebaytradingapi, "GetItemTransactions");
        itemId = l;
        transactionId = l1;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "GetItemTransactions");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "DetailLevel", "ReturnAll");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(itemId));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "TransactionID", String.valueOf(transactionId));
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "IncludeContainingOrder", "true");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Version", "933");
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "GetItemTransactions");
    }

    public GetItemTransactionsResponse getResponse()
    {
        return new GetItemTransactionsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
