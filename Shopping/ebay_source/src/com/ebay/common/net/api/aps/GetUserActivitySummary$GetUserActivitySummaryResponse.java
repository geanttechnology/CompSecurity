// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            GetUserActivitySummary, UserActivitySummary

private static final class <init> extends EbayResponse
{
    private final class BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummary.GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getUserActivitySummaryResponse".equals(s1))
            {
                return new GetUserActivitySummaryElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BodyElement()
        {
            this$0 = GetUserActivitySummary.GetUserActivitySummaryResponse.this;
            super();
        }

        BodyElement(GetUserActivitySummary._cls1 _pcls1)
        {
            this();
        }
    }

    private final class BuyingSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummary.GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("biddingCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingBiddingCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("winningCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWinningCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("totalWinningCost".equals(s1))
            {
                return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final BuyingSummaryElement this$1;
                    final String val$currencyCode;

                    public void text(String s)
                        throws SAXException
                    {
                        summary.totalWinningCost = new CurrencyAmount(s, currencyCode);
                    }

            
            {
                this$1 = final_buyingsummaryelement;
                currencyCode = String.this;
                super();
            }
                };
            }
            if ("wonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWonCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("wonDurationInDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWonDurationInDays = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("bestOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingBestOfferCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("watchingCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWatchCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("feedbackToSendCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingFeedbackToSend = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("outbidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingOutbidCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("paymentToSendCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingPaymentToSend = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("bidEndingSoonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingBidEndingSoonCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("secondChanceOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingSecondChanceOfferCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("watchEndingSoonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWatchEndingSoonCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("pickupReadyCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingPickupReadyCount = i;
                    }

            
            {
                this$1 = BuyingSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BuyingSummaryElement()
        {
            this$0 = GetUserActivitySummary.GetUserActivitySummaryResponse.this;
            super();
        }

        BuyingSummaryElement(GetUserActivitySummary._cls1 _pcls1)
        {
            this();
        }
    }

    private final class GetUserActivitySummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummary.GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetUserActivitySummary.GetUserActivitySummaryResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(GetUserActivitySummary.GetUserActivitySummaryResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetUserActivitySummary.GetUserActivitySummaryResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/services");
            }
            if ("buyingSummary".equals(s1))
            {
                return new BuyingSummaryElement(null);
            }
            if ("sellingSummary".equals(s1))
            {
                return new SellingSummaryElement(null);
            }
            if ("messageSummary".equals(s1))
            {
                return new MessageSummaryElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryElement()
        {
            this$0 = GetUserActivitySummary.GetUserActivitySummaryResponse.this;
            super();
        }

        GetUserActivitySummaryElement(GetUserActivitySummary._cls1 _pcls1)
        {
            this();
        }
    }

    private final class MessageSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummary.GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("newAlertCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final MessageSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.messagesNewAlertCount = i;
                    }

            
            {
                this$1 = MessageSummaryElement.this;
                super();
            }
                };
            }
            if ("newMessageCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final MessageSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.messagesNewMessageCount = i;
                    }

            
            {
                this$1 = MessageSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private MessageSummaryElement()
        {
            this$0 = GetUserActivitySummary.GetUserActivitySummaryResponse.this;
            super();
        }

        MessageSummaryElement(GetUserActivitySummary._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummary.GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new BodyElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = GetUserActivitySummary.GetUserActivitySummaryResponse.this;
            super();
        }

        RootElement(GetUserActivitySummary._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SellingSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummary.GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("activeCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingActiveCount = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("soldCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingSoldCount = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("unSoldCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingUnsoldCount = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("scheduledCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingScheduledCount = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("soldDurationInDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingDurationInDays = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("totalAuctionSellingValue".equals(s1))
            {
                return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellingSummaryElement this$1;
                    final String val$currencyCode;

                    public void text(String s)
                        throws SAXException
                    {
                        summary.totalAuctionSellingValue = new CurrencyAmount(s, currencyCode);
                    }

            
            {
                this$1 = final_sellingsummaryelement;
                currencyCode = String.this;
                super();
            }
                };
            }
            if ("totalSoldValue".equals(s1))
            {
                return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellingSummaryElement this$1;
                    final String val$currencyCode;

                    public void text(String s)
                        throws SAXException
                    {
                        summary.totalSoldValue = new CurrencyAmount(s, currencyCode);
                    }

            
            {
                this$1 = final_sellingsummaryelement;
                currencyCode = String.this;
                super();
            }
                };
            }
            if ("feedbackToSendCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingFeedbackToSend = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("paymentToReceiveCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingPaymentToReceive = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("shippingNeededCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingShippingNeeded = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("bestOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingBestOfferCount = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("sellEndingSoonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingSellEndingSoonCount = i;
                    }

            
            {
                this$1 = SellingSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SellingSummaryElement()
        {
            this$0 = GetUserActivitySummary.GetUserActivitySummaryResponse.this;
            super();
        }

        SellingSummaryElement(GetUserActivitySummary._cls1 _pcls1)
        {
            this();
        }
    }


    private final UserActivitySummary summary;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.ellingSummaryElement
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }


    private SellingSummaryElement()
    {
        summary = new UserActivitySummary();
    }

    summary(summary summary1)
    {
        this();
    }
}
