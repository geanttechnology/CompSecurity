// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class this._cls1 extends com.ebay.nautilus.kernel.util.llerAddress
{

    final _cls11 this$1;

    public com.ebay.nautilus.kernel.util.llerAddress get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("CompanyName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsCompanyName = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("FirstName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsFirstName = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("LastName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsLastName = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("CityName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsCityName = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsName = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("Phone".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsPhone = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("PostalCode".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsPostalCode = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("StateOrProvince".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsStateOrProvince = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("CountryName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsCountryName = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("Street1".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsStreet1 = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        }
        if ("Street2".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetSingleItemResponse.Item.BusinessSellerAddress this$2;

                public void text(String s3)
                    throws SAXException
                {
                    item.bsStreet2 = s3;
                }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerAddress.this;
                super();
            }
            };
        } else
        {
            return super.llerAddress(s, s1, s2, attributes);
        }
    }

    public _cls9.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }
}
