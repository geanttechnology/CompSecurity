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
        if ("biddingCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingBiddingCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("winningCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingWinningCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("totalWinningCost".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;
                final String val$currencyCode;

                public void text(String s3)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).totalWinningCost = new CurrencyAmount(s3, currencyCode);
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                currencyCode = s;
                super();
            }
            };
        }
        if ("wonCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingWonCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("wonDurationInDays".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingWonDurationInDays = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("bestOfferCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingBestOfferCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("watchingCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingWatchCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("feedbackToSendCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingFeedbackToSend = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("outbidCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingOutbidCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("paymentToSendCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingPaymentToSend = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("bidEndingSoonCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingBidEndingSoonCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("secondChanceOfferCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingSecondChanceOfferCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("watchEndingSoonCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingWatchEndingSoonCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
            };
        }
        if ("pickupReadyCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    GetUserActivitySummary.GetUserActivitySummaryResponse.access$000(this$0).buyingPickupReadyCount = i;
                }

            
            {
                this$1 = GetUserActivitySummary.GetUserActivitySummaryResponse.BuyingSummaryElement.this;
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
