// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.r
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.r get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("BuyerInfo".equals(s1))
            {
                return new nfo(GetItemTransactionsResponse.this, null);
            }
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Buyer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).buyerUserId = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Buyer.this;
                super();
            }
                };
            }
            if ("FeedbackRatingStar".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Buyer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).buyerFeedbackRatingStar = s3;
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Buyer.this;
                super();
            }
                };
            }
            if ("FeedbackPrivate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetItemTransactionsResponse.Buyer this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).buyerFeedbackPrivate = "true".equals(s3);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Buyer.this;
                super();
            }
                };
            }
            if ("FeedbackScore".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetItemTransactionsResponse.Buyer this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).buyerFeedbackScore = Integer.valueOf(i);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Buyer.this;
                super();
            }
                };
            }
            if ("PositiveFeedbackPercent".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                    final GetItemTransactionsResponse.Buyer this$1;

                    public void setValue(float f)
                        throws SAXException
                    {
                        GetItemTransactionsResponse.access$600(this$0).buyerPositiveFeedbackPercent = Float.valueOf(f);
                    }

            
            {
                this$1 = GetItemTransactionsResponse.Buyer.this;
                super();
            }
                };
            }
        }
        return super.r(s, s1, s2, attributes);
    }

    private _cls5.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
