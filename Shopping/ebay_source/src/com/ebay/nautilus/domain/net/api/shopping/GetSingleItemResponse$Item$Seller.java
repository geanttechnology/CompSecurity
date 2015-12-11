// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

private final class <init> extends com.ebay.nautilus.kernel.util.Item.Seller
{

    final _cls4 this$1;

    public com.ebay.nautilus.kernel.util.Item.Seller get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.Seller this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.sellerUserId = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Seller.this;
                super();
            }
                };
            }
            if ("FeedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetSingleItemResponse.Item.Seller this$2;

                    public void text(String s3)
                        throws SAXException
                    {
                        item.sellerFeedbackRatingStar = s3;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Seller.this;
                super();
            }
                };
            }
            if ("FeedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetSingleItemResponse.Item.Seller this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.sellerFeedbackScore = i;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Seller.this;
                super();
            }
                };
            }
            if ("PositiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetSingleItemResponse.Item.Seller this$2;

                    public void setValue(float f)
                        throws SAXException
                    {
                        item.sellerPositiveFeedbackPercent = f;
                    }

            
            {
                this$2 = GetSingleItemResponse.Item.Seller.this;
                super();
            }
                };
            }
        }
        return super.Seller(s, s1, s2, attributes);
    }

    private _cls4.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
