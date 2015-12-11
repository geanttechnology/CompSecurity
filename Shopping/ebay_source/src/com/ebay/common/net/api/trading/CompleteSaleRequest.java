// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.ShipmentTracking;
import com.ebay.nautilus.domain.data.ShipmentTrackingDetail;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            CompleteSaleResponse

public class CompleteSaleRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    private static final String CALL_NAME = "CompleteSale";
    private final long itemId;
    private final Boolean markAsPaid;
    private final Boolean shipped;
    public final ShipmentTracking tracking;
    private final Long transactionId;

    public CompleteSaleRequest(EbayTradingApi ebaytradingapi, long l, Long long1, ShipmentTracking shipmenttracking, Boolean boolean1, Boolean boolean2)
    {
        super(ebaytradingapi, "CompleteSale");
        itemId = l;
        transactionId = long1;
        tracking = shipmenttracking;
        shipped = boolean1;
        markAsPaid = boolean2;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "CompleteSale");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "");
        XmlSerializerHelper.writeSimple(xmlserializer, null, "Version", apiVersion);
        XmlSerializerHelper.writeSimple(xmlserializer, null, "ItemID", String.valueOf(itemId));
        if (tracking != null)
        {
            xmlserializer.startTag(null, "Shipment");
            for (Iterator iterator = tracking.details.iterator(); iterator.hasNext(); xmlserializer.endTag(null, "ShipmentTrackingDetails"))
            {
                ShipmentTrackingDetail shipmenttrackingdetail = (ShipmentTrackingDetail)iterator.next();
                xmlserializer.startTag(null, "ShipmentTrackingDetails");
                XmlSerializerHelper.writeSimple(xmlserializer, null, "ShipmentTrackingNumber", shipmenttrackingdetail.trackingNumber);
                XmlSerializerHelper.writeSimple(xmlserializer, null, "ShippingCarrierUsed", shipmenttrackingdetail.carrier);
            }

            xmlserializer.endTag(null, "Shipment");
        }
        if (shipped != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "Shipped", shipped.toString());
        }
        if (transactionId != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "TransactionID", String.valueOf(transactionId.longValue()));
        }
        if (markAsPaid != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, null, "Paid", markAsPaid.toString());
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "CompleteSale");
    }

    public CompleteSaleResponse getResponse()
    {
        return new CompleteSaleResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
