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
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            FundRaisingRequest, SetUserDonationDetailsResponse

public class SetUserDonationDetailsRequest extends FundRaisingRequest
{
    private static final class BuyerDonationDetails
    {

        public final int enableDonationAtCheckout = 1;
        public final String preferredNonprofitId[];

        public BuyerDonationDetails(String as[])
        {
            preferredNonprofitId = as;
        }
    }

    private static final class SellerDonationDetails
    {

        public final String preferredNonprofitId[];

        public SellerDonationDetails(String as[])
        {
            preferredNonprofitId = as;
        }
    }


    public static final String OPERATION_NAME = "setUserDonationDetails";
    private static final String REQUEST_NAME = "setUserDonationDetailsRequest";
    public final BuyerDonationDetails buyerDonationDetails;
    public final SellerDonationDetails sellerDonationDetails;

    public SetUserDonationDetailsRequest(Authentication authentication, EbaySite ebaysite, String as[])
    {
        super(ebaysite, true, "setUserDonationDetails");
        super.soaServiceVersion = "3.0.0";
        super.iafToken = authentication.iafToken;
        buyerDonationDetails = new BuyerDonationDetails(as);
        sellerDonationDetails = new SellerDonationDetails(as);
    }

    public void buildXmlRequest(XmlSerializer xmlserializer)
        throws IOException
    {
        xmlserializer.setPrefix("", "http://www.ebay.com/marketplace/fundraising/v3/services");
        xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v3/services", "setUserDonationDetailsRequest");
        if (buyerDonationDetails != null && buyerDonationDetails.preferredNonprofitId != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v3/services", "BuyerDonationDetails");
            buyerDonationDetails.getClass();
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v3/services", "enableDonationAtCheckout", "true");
            String as[] = buyerDonationDetails.preferredNonprofitId;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v3/services", "preferredNonprofitId", as[i]);
            }

            xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v3/services", "BuyerDonationDetails");
        }
        if (sellerDonationDetails != null && sellerDonationDetails.preferredNonprofitId != null)
        {
            xmlserializer.startTag("http://www.ebay.com/marketplace/fundraising/v3/services", "SellerDonationDetails");
            String as1[] = sellerDonationDetails.preferredNonprofitId;
            int l = as1.length;
            for (int j = 0; j < l; j++)
            {
                XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/fundraising/v3/services", "preferredNonprofitId", as1[j]);
            }

            xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v3/services", "SellerDonationDetails");
        }
        xmlserializer.endTag("http://www.ebay.com/marketplace/fundraising/v3/services", "setUserDonationDetailsRequest");
    }

    protected String getErrorLanguage()
    {
        return null;
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(EbaySettings.fundRaisingUrl);
    }

    public SetUserDonationDetailsResponse getResponse()
    {
        return new SetUserDonationDetailsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }
}
