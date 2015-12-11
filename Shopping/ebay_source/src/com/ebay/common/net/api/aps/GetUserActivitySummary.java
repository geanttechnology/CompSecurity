// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.domain.net.XmlSerializerHelper;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

// Referenced classes of package com.ebay.common.net.api.aps:
//            UserActivitySummary

public final class GetUserActivitySummary
{
    public static final class GetUserActivitySummaryRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String API_VERSION = "835";
        private final String userId;

        public byte[] buildRequest()
            throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
        {
            return XmlSerializerHelper.buildXmlRequest(this);
        }

        public void buildXmlRequest(XmlSerializer xmlserializer)
            throws IOException
        {
            xmlserializer.setPrefix("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
            xmlserializer.setPrefix(null, "http://www.ebay.com/marketplace/mobileor/v1/services");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            xmlserializer.startTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getUserActivitySummary");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "clientID", userId);
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getUserActivitySummary");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.applicationProcessSvc);
        }

        public GetUserActivitySummaryResponse getResponse()
        {
            return new GetUserActivitySummaryResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            super.onAddHeaders(iheaders);
            iheaders.setHeader("x-ebay-api-compatibility-level", "835");
            iheaders.setHeader("x-ebay-api-version", "835");
        }

        public GetUserActivitySummaryRequest(String s, EbaySite ebaysite, String s1)
        {
            super("IPhoneApplicationProcessService", true, "getUserActivitySummary");
            super.iafToken = s;
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.soaGlobalId = ebaysite.idString;
            super.soaSoapAction = (new StringBuilder()).append("\"http://www.ebay.com/marketplace/mobileor/v1/services/").append(getOperationName()).append('"').toString();
            super.timeout = 0x2bf20;
            userId = s1;
        }
    }

    private static final class GetUserActivitySummaryResponse extends EbayResponse
    {

        private final UserActivitySummary summary;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }


        private GetUserActivitySummaryResponse()
        {
            summary = new UserActivitySummary();
        }

    }

    private final class GetUserActivitySummaryResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getUserActivitySummaryResponse".equals(s1))
            {
                return new GetUserActivitySummaryResponse.GetUserActivitySummaryElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryResponse.BodyElement()
        {
            this$0 = GetUserActivitySummaryResponse.this;
            super();
        }

    }

    private final class GetUserActivitySummaryResponse.BuyingSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("biddingCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingBiddingCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("winningCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWinningCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("totalWinningCost".equals(s1))
            {
                return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;
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

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWonCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("wonDurationInDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWonDurationInDays = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("bestOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingBestOfferCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("watchingCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWatchCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("feedbackToSendCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingFeedbackToSend = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("outbidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingOutbidCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("paymentToSendCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingPaymentToSend = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("bidEndingSoonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingBidEndingSoonCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("secondChanceOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingSecondChanceOfferCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("watchEndingSoonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingWatchEndingSoonCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            }
            if ("pickupReadyCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.BuyingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.buyingPickupReadyCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.BuyingSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryResponse.BuyingSummaryElement()
        {
            this$0 = GetUserActivitySummaryResponse.this;
            super();
        }

    }

    private final class GetUserActivitySummaryResponse.GetUserActivitySummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetUserActivitySummaryResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(GetUserActivitySummaryResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetUserActivitySummaryResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/services");
            }
            if ("buyingSummary".equals(s1))
            {
                return new GetUserActivitySummaryResponse.BuyingSummaryElement();
            }
            if ("sellingSummary".equals(s1))
            {
                return new GetUserActivitySummaryResponse.SellingSummaryElement();
            }
            if ("messageSummary".equals(s1))
            {
                return new GetUserActivitySummaryResponse.MessageSummaryElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryResponse.GetUserActivitySummaryElement()
        {
            this$0 = GetUserActivitySummaryResponse.this;
            super();
        }

    }

    private final class GetUserActivitySummaryResponse.MessageSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("newAlertCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.MessageSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.messagesNewAlertCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.MessageSummaryElement.this;
                super();
            }
                };
            }
            if ("newMessageCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.MessageSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.messagesNewMessageCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.MessageSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryResponse.MessageSummaryElement()
        {
            this$0 = GetUserActivitySummaryResponse.this;
            super();
        }

    }

    private final class GetUserActivitySummaryResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new GetUserActivitySummaryResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryResponse.RootElement()
        {
            this$0 = GetUserActivitySummaryResponse.this;
            super();
        }

    }

    private final class GetUserActivitySummaryResponse.SellingSummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetUserActivitySummaryResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("activeCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingActiveCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("soldCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingSoldCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("unSoldCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingUnsoldCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("scheduledCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingScheduledCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("soldDurationInDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingDurationInDays = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("totalAuctionSellingValue".equals(s1))
            {
                return attributes.getValue("currencyID"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;
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

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;
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

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingFeedbackToSend = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("paymentToReceiveCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingPaymentToReceive = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("shippingNeededCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingShippingNeeded = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("bestOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingBestOfferCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            }
            if ("sellEndingSoonCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserActivitySummaryResponse.SellingSummaryElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        summary.sellingSellEndingSoonCount = i;
                    }

            
            {
                this$1 = GetUserActivitySummaryResponse.SellingSummaryElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetUserActivitySummaryResponse.SellingSummaryElement()
        {
            this$0 = GetUserActivitySummaryResponse.this;
            super();
        }

    }


    public static final String API_COMPATIBILITY_HEADER = "x-ebay-api-compatibility-level";
    public static final String API_VERSION_HEADER = "x-ebay-api-version";

    public GetUserActivitySummary()
    {
    }

    public static final UserActivitySummary getUserActivitySummary(EbayContext ebaycontext, String s, EbaySite ebaysite, String s1)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        return ((GetUserActivitySummaryResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetUserActivitySummaryRequest(s, ebaysite, s1))).summary;
    }
}
