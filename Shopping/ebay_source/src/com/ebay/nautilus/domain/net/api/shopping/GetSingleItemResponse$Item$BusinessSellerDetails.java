// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class this._cls1 extends com.ebay.nautilus.kernel.util.llerDetails
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.llerDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("AdditionalContactInformation".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.BusinessSellerDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.bsAdditionalContactInformation = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerDetails.this;
                super();
            }
                };
            }
            if ("Address".equals(s1))
            {
                return new <init>(this._cls1.this);
            }
            if ("Email".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.BusinessSellerDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.bsEmail = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerDetails.this;
                super();
            }
                };
            }
            if ("LegalInvoice".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetSingleItemResponse.Item.BusinessSellerDetails this$2;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.bsLegalInvoice = flag;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerDetails.this;
                super();
            }
                };
            }
            if ("TermsAndConditions".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.BusinessSellerDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.bsTermsAndConditions = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerDetails.this;
                super();
            }
                };
            }
            if ("TradeRegistrationNumber".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.BusinessSellerDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.bsTradeRegistrationNumber = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerDetails.this;
                super();
            }
                };
            }
            if ("Fax".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.BusinessSellerDetails this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.bsFax = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.BusinessSellerDetails.this;
                super();
            }
                };
            }
            if ("VATDetails".equals(s1))
            {
                return new _cls6(this._cls1.this, null);
            }
        }
        return super._mth1(s, s1, s2, attributes);
    }

    public _cls6.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
        item.bsDetailsExists = true;
    }
}
