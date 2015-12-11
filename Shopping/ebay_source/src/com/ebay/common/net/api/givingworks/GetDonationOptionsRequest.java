// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.net.Response;
import java.io.IOException;
import java.net.URL;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FundRaisingRequest, FindNonProfitResponse

public class GetDonationOptionsRequest extends FundRaisingRequest
{
    private static final class Item
    {

        public final String itemId;

        public Item(String s)
        {
            itemId = s;
        }
    }


    public static final String OPERATION_NAME = "getDonationOptions";
    private static final String REQUEST_NAME = "getDonationOptionsRequest";
    public final String buyingCurrency;
    private final Item item = new Item(null);
    public final String userLoginName;

    public GetDonationOptionsRequest(Authentication authentication, EbaySite ebaysite, EbayCurrency ebaycurrency)
    {
        super(ebaysite, false, "getDonationOptions");
        super.soaServiceVersion = "3.0.0";
        super.iafToken = authentication.iafToken;
        userLoginName = authentication.user;
        buyingCurrency = ebaycurrency.getCurrencyCode();
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/fundraising/v3/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v3/services", "getDonationOptionsRequest");
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v3/services", "userLoginName", userLoginName);
        XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v3/services", "buyingCurrency", buyingCurrency);
        if (item != null && item.itemId != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v3/services", "item");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v3/services", "itemId", item.itemId);
            xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v3/services", "item");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v3/services", "getDonationOptionsRequest");
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.fundRaisingUrl);
    }

    public FindNonProfitResponse getResponse()
    {
        return new FindNonProfitResponse("http://www.ebay.com/marketplace/fundraising/v3/services");
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
