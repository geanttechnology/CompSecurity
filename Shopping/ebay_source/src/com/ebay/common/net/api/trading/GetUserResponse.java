// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.UserDetail;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.IResponseHeaderHandler;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.net.URLDecoder;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetUserResponse extends EbayResponse
    implements IResponseHeaderHandler
{
    static final class Address extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        com.ebay.common.model.UserDetail.Address address;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CityName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.cityName = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("CompanyName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.companyName = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("Country".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.country = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("CountryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.countryName = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("Name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.name = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("Phone".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.phone = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("PostalCode".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.postalCode = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("StateOrProvince".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.stateOrProvince = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("Street".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.street = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("Street1".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.street1 = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
                if ("Street2".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Address this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            address.street2 = s;
                        }

            
            {
                this$0 = Address.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        Address(com.ebay.common.model.UserDetail.Address address1)
        {
            address = address1;
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetUserResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetUserResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetUserResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("User".equals(s1))
                {
                    return new User();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetUserResponse.this;
            super();
        }

    }

    private final class RootElement.User extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Email".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.email = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("Site".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.site = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("Status".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.status = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.userId = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("SellerInfo".equals(s1))
                {
                    s = detail;
                    s1 = new com.ebay.common.model.UserDetail.SellerInfo();
                    s.sellerInfo = s1;
                    return new SellerInfo(s1);
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.feedbackRatingStar = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("RegistrationAddress".equals(s1))
                {
                    detail.registrationAddress = new com.ebay.common.model.UserDetail.Address();
                    return new Address(detail.registrationAddress);
                }
                if ("PayPalAccountLevel".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.payPalAccountLevel = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("PayPalAccountStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.payPalAccountStatus = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("PayPalAccountType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.payPalAccountType = s;
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
                if ("BusinessRole".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.User this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            detail.isPpa = "Shopper".equals(s);
                        }

            
            {
                this$2 = RootElement.User.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement.User()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    static final class SellerInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.UserDetail.SellerInfo data;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("SellerBusinessType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SellerInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            data.sellerBusinessType = s;
                        }

            
            {
                this$0 = SellerInfo.this;
                super();
            }
                    };
                }
                if ("PaymentMethod".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SellerInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            data.paymentMethod = s;
                        }

            
            {
                this$0 = SellerInfo.this;
                super();
            }
                    };
                }
                if ("SellerPaymentAddress".equals(s1))
                {
                    data.sellerPaymentAddress = new com.ebay.common.model.UserDetail.Address();
                    return new Address(data.sellerPaymentAddress);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        SellerInfo(com.ebay.common.model.UserDetail.SellerInfo sellerinfo)
        {
            data = sellerinfo;
        }
    }


    public UserDetail detail;

    public GetUserResponse()
    {
        detail = new UserDetail();
    }

    public IResponseHeaderHandler getHeaderHandler()
    {
        return this;
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }

    public void readHeaders(IHeaders iheaders)
    {
        iheaders = iheaders.getLastHeader("x-ebay-api-msuuid");
        if (iheaders != null)
        {
            detail.msuuid = URLDecoder.decode(iheaders);
        }
    }
}
