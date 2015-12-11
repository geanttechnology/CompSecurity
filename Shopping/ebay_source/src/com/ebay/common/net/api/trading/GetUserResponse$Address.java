// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserResponse

static final class address extends com.ebay.nautilus.kernel.util.s
{

    com.ebay.common.model.nt.get address;

    public com.ebay.nautilus.kernel.util.s get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("CityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.cityName = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("CompanyName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.companyName = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("Country".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.country = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.countryName = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.name = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.phone = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.postalCode = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.stateOrProvince = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("Street".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.street = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("Street1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.street1 = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
            if ("Street2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserResponse.Address this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        address.street2 = s3;
                    }

            
            {
                this$0 = GetUserResponse.Address.this;
                super();
            }
                };
            }
        }
        return super.s(s, s1, s2, attributes);
    }

    it>(com.ebay.common.model.e.Address address1)
    {
        address = address1;
    }
}
