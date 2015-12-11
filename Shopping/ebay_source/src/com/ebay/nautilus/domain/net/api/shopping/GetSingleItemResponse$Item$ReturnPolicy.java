// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util.eturnPolicy
{

    final _cls10 this$1;

    public com.ebay.nautilus.kernel.util.eturnPolicy get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Description".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpDescription = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("EAN".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpEAN = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("RestockingFeeValue".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpRestockingFee = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("Refund".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpRefund = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("ReturnsAccepted".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpReturnsAccepted = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("ReturnsWithin".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpReturnsWithin = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("ShippingCostPaidBy".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpShippingCostPaidBy = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("WarrantyDuration".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpWarrantyDuration = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("WarrantyOffered".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpWarrantyOffered = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
            if ("WarrantyType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.ReturnPolicy this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.rpWarrantyType = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.ReturnPolicy.this;
                super();
            }
                };
            }
        }
        return super.eturnPolicy(s, s1, s2, attributes);
    }

    private _cls9.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
