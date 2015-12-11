// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.givingworks:
//            SetUserDonationDetailsResponse

private final class data extends com.ebay.nautilus.kernel.util.ement
{

    private final ionDetailsResponseData data;
    final SetUserDonationDetailsResponse this$0;

    public com.ebay.nautilus.kernel.util.ement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/fundraising/v3/services".equals(s))
        {
            if ("ack".equals(s1))
            {
                return new AckElement(SetUserDonationDetailsResponse.this);
            }
            if ("version".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SetUserDonationDetailsResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        setVersion(s3);
                    }

            
            {
                this$1 = SetUserDonationDetailsResponse.RootElement.this;
                super();
            }
                };
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(SetUserDonationDetailsResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(SetUserDonationDetailsResponse.this, "http://www.ebay.com/marketplace/fundraising/v3/services");
            }
            if ("output".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SetUserDonationDetailsResponse.RootElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        data.output = s3;
                    }

            
            {
                this$1 = SetUserDonationDetailsResponse.RootElement.this;
                super();
            }
                };
            }
        }
        return super.ement(s, s1, s2, attributes);
    }


    public ionDetailsResponseData(ionDetailsResponseData iondetailsresponsedata)
    {
        this$0 = SetUserDonationDetailsResponse.this;
        super();
        data = iondetailsresponsedata;
    }
}
