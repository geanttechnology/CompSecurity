// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.givingworks;

import android.os.Parcel;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class SetUserDonationDetailsResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final SetUserDonationDetailsResponseData data;
        final SetUserDonationDetailsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            setVersion(s);
                        }

            
            {
                this$1 = RootElement.this;
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

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            data.output = s;
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement(SetUserDonationDetailsResponseData setuserdonationdetailsresponsedata)
        {
            this$0 = SetUserDonationDetailsResponse.this;
            super();
            data = setuserdonationdetailsresponsedata;
        }
    }

    public static class SetUserDonationDetailsResponseData extends BaseApiResponse
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SetUserDonationDetailsResponseData createFromParcel(Parcel parcel)
            {
                return (SetUserDonationDetailsResponseData)DataMapperFactory.readParcelJson(parcel, com/ebay/common/net/api/givingworks/SetUserDonationDetailsResponse$SetUserDonationDetailsResponseData);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SetUserDonationDetailsResponseData[] newArray(int i)
            {
                return new SetUserDonationDetailsResponseData[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String output;


        public SetUserDonationDetailsResponseData()
        {
        }
    }


    public SetUserDonationDetailsResponseData responseData;

    public SetUserDonationDetailsResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SetUserDonationDetailsResponseData setuserdonationdetailsresponsedata = new SetUserDonationDetailsResponseData();
        responseData = setuserdonationdetailsresponsedata;
        SaxHandler.parseXml(inputstream, new RootElement(setuserdonationdetailsresponsedata));
    }
}
