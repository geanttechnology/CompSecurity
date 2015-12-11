// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.mobile.analytics:
//            RoiTrackEventResponse

public class RoiTrackEventRequest extends EbaySoaRequest
    implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
{
    public static final class ItemData
    {

        private final String itemId;
        private final ItemCurrency orderTotal;
        private final String primaryCategoryId;
        private final String quantity;
        private final String secondaryCategoryId;
        private final String sellerName;
        private final String uniqueTransactionId;

        final void add(XmlSerializer xmlserializer)
            throws IOException
        {
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "sellerName", sellerName);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "itemId", itemId);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "uniqueTransactionId", uniqueTransactionId);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "quantity", quantity);
            if (orderTotal != null)
            {
                xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "orderTotal");
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "currencyId", orderTotal.code);
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "amount", orderTotal.value);
                xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "orderTotal");
            }
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "primaryCategoryId", primaryCategoryId);
            if (!TextUtils.isEmpty(secondaryCategoryId))
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "secondaryCategoryId", secondaryCategoryId);
            }
        }

        public ItemData(String s, String s1, String s2, String s3, ItemCurrency itemcurrency, String s4, String s5)
        {
            sellerName = s;
            itemId = s1;
            uniqueTransactionId = s2;
            quantity = s3;
            orderTotal = itemcurrency;
            primaryCategoryId = s4;
            secondaryCategoryId = s5;
            if (TextUtils.isEmpty(s))
            {
                throw new NullPointerException("sellerName");
            }
            if (TextUtils.isEmpty(s1))
            {
                throw new NullPointerException("itemId");
            }
            if (TextUtils.isEmpty(s2))
            {
                throw new NullPointerException("uniqueTransactionId");
            }
            if (TextUtils.isEmpty(s3))
            {
                throw new NullPointerException("quantity");
            }
            if (TextUtils.isEmpty(s4))
            {
                throw new NullPointerException("primaryCategoryId");
            } else
            {
                return;
            }
        }
    }


    private final ItemData itemData;
    private final String trackingAppId;
    private final String transactionType;
    private final String userId;

    public RoiTrackEventRequest(String s, EbaySite ebaysite, String s1)
    {
        this("Reg-MobileApp", s, ebaysite, null, s1, null);
    }

    public RoiTrackEventRequest(String s, String s1, EbaySite ebaysite, String s2, String s3, ItemData itemdata)
    {
        super("MobileTrackingService", true, "roiTrackEvent");
        soaGlobalId = ebaysite.idString;
        soaAppIdHeaderName = "x-ebay-soa-security-appname";
        iafToken = s2;
        trackingAppId = s1;
        transactionType = s;
        userId = s3;
        itemData = itemdata;
        if (TextUtils.isEmpty(s))
        {
            throw new NullPointerException("transactionType");
        }
        if (TextUtils.isEmpty(s1))
        {
            throw new NullPointerException("trackingAppId");
        }
        if (TextUtils.isEmpty(s2) && TextUtils.isEmpty(s3))
        {
            throw new NullPointerException("iafToken or userId");
        } else
        {
            return;
        }
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return XmlSerializerHelper.buildXmlRequest(this);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobile/v1/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "roiTrackEventRequest");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "roiFactory");
        xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "inputParams");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "transactionType", transactionType);
        if (itemData != null)
        {
            itemData.add(xmlserializer);
        }
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "client", "ebay");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "vendorName", "Mediaplex");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "inputParams");
        if (!TextUtils.isEmpty(userId))
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "optionalParams");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingParameter");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "key", "username");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobile/v1/services", "value", userId);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "trackingParameter");
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "optionalParams");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "roiFactory");
        xmlserializer.endTag("http://www.ebay.com/marketplace/mobile/v1/services", "roiTrackEventRequest");
    }

    public URL getRequestUrl()
    {
        Object obj = "https://svcs.ebay.com/services/mobile/v1/MobileTrackingService";
        if (NautilusKernel.isQaMode())
        {
            obj = "http://mobitrack.qa.ebay.com/services/mobile/v1/MobileTrackingService";
        }
        try
        {
            obj = new URL(((String) (obj)));
        }
        catch (MalformedURLException malformedurlexception)
        {
            malformedurlexception.printStackTrace();
            return null;
        }
        return ((URL) (obj));
    }

    public RoiTrackEventResponse getResponse()
    {
        return new RoiTrackEventResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        iheaders.setHeader("x-ebay-mobile-mts-appid", trackingAppId);
    }
}
