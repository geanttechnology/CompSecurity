// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            GetUserActivitySummary, UserActivitySummary

private final class <init> extends com.ebay.nautilus.kernel.util.nit>
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.nit> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("activeCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingActiveCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("soldCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingSoldCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("unSoldCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingUnsoldCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("scheduledCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingScheduledCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("soldDurationInDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingDurationInDays = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("totalAuctionSellingValue".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;
                final String val$currencyCode;

                public void text(String s3)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).totalAuctionSellingValue = new CurrencyAmount(s3, currencyCode);
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                currencyCode = s;
                super();
            }
            };
        }
        if ("totalSoldValue".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;
                final String val$currencyCode;

                public void text(String s3)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).totalSoldValue = new CurrencyAmount(s3, currencyCode);
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                currencyCode = s;
                super();
            }
            };
        }
        if ("feedbackToSendCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingFeedbackToSend = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("paymentToReceiveCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingPaymentToReceive = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("shippingNeededCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingShippingNeeded = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("bestOfferCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingBestOfferCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        }
        if ("sellEndingSoonCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).sellingSellEndingSoonCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
            };
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private _cls9.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
