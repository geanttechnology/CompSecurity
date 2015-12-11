// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.text.TextUtils;
import com.ebay.nautilus.domain.NautilusDomain;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingRequest;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.trading:
//            PlaceOfferResponse

public class PlaceOfferRequest extends EbayTradingRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{

    public static final ArrayList AVAILABLE_ACTIONS;
    private final String action;
    private final String bestOfferId;
    private final String bestOfferTermsToSeller;
    private final ItemCurrency bid;
    private final boolean isUserConsentRequired;
    private final long itemId;
    private final List nameValueList;
    private final int quantity;
    private final boolean requestTrackingPartnerCode;

    public PlaceOfferRequest(EbayTradingApi ebaytradingapi, long l, String s, ItemCurrency itemcurrency, int i, List list, 
            String s1, String s2, boolean flag, boolean flag1)
    {
        super(ebaytradingapi, "PlaceOffer");
        itemId = l;
        action = s;
        bid = itemcurrency;
        quantity = i;
        nameValueList = list;
        requestTrackingPartnerCode = flag;
        bestOfferId = s1;
        bestOfferTermsToSeller = s2;
        isUserConsentRequired = flag1;
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
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "PlaceOfferRequest");
        XmlSerializerHelper.writeErrorLocale(xmlserializer, "urn:ebay:apis:eBLBaseComponents");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "ItemID", String.valueOf(itemId));
        xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "Offer");
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Action", action);
        if (!TextUtils.isEmpty(bestOfferId))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "BestOfferID", bestOfferId);
        }
        if (bid != null && !TextUtils.isEmpty(bid.value))
        {
            XmlSerializerHelper.writeTagWithAttribute(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MaxBid", bid.value, "currencyID", bid.code);
        }
        if (!TextUtils.isEmpty(bestOfferTermsToSeller))
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Message", bestOfferTermsToSeller);
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Quantity", String.valueOf(quantity));
        if (isUserConsentRequired)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "UserConsent", "true");
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "Offer");
        if (nameValueList != null && !nameValueList.isEmpty())
        {
            xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "VariationSpecifics");
            for (Iterator iterator = nameValueList.iterator(); iterator.hasNext(); xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "NameValueList"))
            {
                NameValue namevalue = (NameValue)iterator.next();
                xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "NameValueList");
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Name", namevalue.getName());
                XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "Value", namevalue.getValue());
            }

            xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "VariationSpecifics");
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "EndUserIP", "192.168.0.2");
        if (requestTrackingPartnerCode)
        {
            xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "RoverROI");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "TrackingPartnerCode", "eBayTrackingMediaPlex");
            xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "RoverROI");
        }
        String s = NautilusDomain.getMachineGroupId(getContext());
        if (s != null)
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "MachineGroupValue", s);
            xmlserializer.startTag("urn:ebay:apis:eBLBaseComponents", "MachineTagTypes");
            XmlSerializerHelper.writeSimple(xmlserializer, "urn:ebay:apis:eBLBaseComponents", "TagType", "NoTag");
            xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "MachineTagTypes");
        }
        xmlserializer.endTag("urn:ebay:apis:eBLBaseComponents", "PlaceOfferRequest");
    }

    public PlaceOfferResponse getResponse()
    {
        return new PlaceOfferResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    static 
    {
        AVAILABLE_ACTIONS = new ArrayList();
        AVAILABLE_ACTIONS.add("Bid");
        AVAILABLE_ACTIONS.add("Purchase");
        AVAILABLE_ACTIONS.add("Accept");
        AVAILABLE_ACTIONS.add("Counter");
        AVAILABLE_ACTIONS.add("Decline");
        AVAILABLE_ACTIONS.add("Offer");
    }
}
