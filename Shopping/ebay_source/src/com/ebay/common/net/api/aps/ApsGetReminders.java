// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import android.text.TextUtils;
import com.ebay.common.model.RemindersList;
import com.ebay.common.net.EbayRequestHelper;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.EbaySettings;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.CurrencyElement;
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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xmlpull.v1.XmlSerializer;

public final class ApsGetReminders
{
    public static final class GetRemindersRequest extends EbaySoaRequest
        implements com.ebay.nautilus.domain.net.XmlSerializerHelper.IXmlRequestBuilder
    {

        private static final String API_VERSION = "835";
        private final int entriesPerPage;
        private final String includeSelector;
        private final String nextPageLocator;
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
            xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getRemindersRequest");
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "includeSelector", includeSelector);
            XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "userID", userId);
            if (entriesPerPage > 0 || !TextUtils.isEmpty(nextPageLocator))
            {
                xmlserializer.startTag("http://www.ebay.com/marketplace/mobileor/v1/services", "page");
                if (entriesPerPage > 0)
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "entriesPerPage", String.valueOf(entriesPerPage));
                }
                if (!TextUtils.isEmpty(nextPageLocator))
                {
                    XmlSerializerHelper.writeSimple(xmlserializer, "http://www.ebay.com/marketplace/mobileor/v1/services", "nextPageLocator", nextPageLocator);
                }
                xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/services", "page");
            }
            xmlserializer.endTag("http://www.ebay.com/marketplace/mobileor/v1/services", "getRemindersRequest");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Body");
            xmlserializer.endTag("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
        }

        public URL getRequestUrl()
        {
            return ApiSettings.getUrl(EbaySettings.applicationProcessSvc);
        }

        public GetRemindersResponse getResponse()
        {
            return new GetRemindersResponse();
        }

        public volatile Response getResponse()
        {
            return getResponse();
        }

        public void onAddHeaders(IHeaders iheaders)
        {
            super.onAddHeaders(iheaders);
            iheaders.setHeader("x-ebay-api-version", "835");
        }

        public GetRemindersRequest(String s, EbaySite ebaysite, String s1, String s2, int i, String s3)
        {
            super("IPhoneApplicationProcessService", true, "getReminders");
            super.iafToken = s;
            super.soaAppIdHeaderName = "x-ebay-soa-security-appname";
            super.soaGlobalId = ebaysite.idString;
            super.soaSoapAction = (new StringBuilder()).append("\"http://www.ebay.com/marketplace/mobileor/v1/services/").append(getOperationName()).append('"').toString();
            userId = s1;
            includeSelector = s2;
            entriesPerPage = i;
            nextPageLocator = s3;
        }
    }

    private static final class GetRemindersResponse extends EbayResponse
    {

        private final List items;
        private final RemindersList listResult;

        public void parse(InputStream inputstream)
            throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
        {
            SaxHandler.parseXml(inputstream, new RootElement());
        }



        private GetRemindersResponse()
        {
            listResult = new RemindersList();
            items = listResult.list;
        }

    }

    private final class GetRemindersResponse.BodyElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("getRemindersResponse".equals(s1))
            {
                return new GetRemindersResponse.GetRemindersResponseElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.BodyElement()
        {
            this$0 = GetRemindersResponse.this;
            super();
        }

    }

    private final class GetRemindersResponse.GetRemindersResponseElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(GetRemindersResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(GetRemindersResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(GetRemindersResponse.this, "http://www.ebay.com/marketplace/mobileor/v1/services");
            }
            if ("buyingReminder".equals(s1) || "sellingReminder".equals(s1))
            {
                return new GetRemindersResponse.ReminderElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.GetRemindersResponseElement()
        {
            this$0 = GetRemindersResponse.this;
            super();
        }

    }

    private final class GetRemindersResponse.ItemElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final MyEbayListItem item;
        final GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("itemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.title = s;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("galleryURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageUrl = s;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("listingType".equals(s1))
            {
                return new ListingType(item);
            }
            if ("convertedCurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("currentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.currentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("shippingServiceCost".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("bestOfferPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.bestOfferAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("timeLeft".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (item.endDate != null)
                        {
                            return;
                        } else
                        {
                            item.endDate = new Date(EbayResponse.currentHostTime() + EbayDateFormat.millisFromISO8601Duration(s));
                            return;
                        }
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("endTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            item.endDate = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("transactionCreatedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        try
                        {
                            item.transaction.createdDate = EbayDateFormat.parse(s);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            throw new SAXNotRecognizedException(s.getLocalizedMessage());
                        }
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("transactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.transactionId = s;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("paidStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.paidStatus = s;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("feedbackLeft".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.transaction.feedbackLeft = flag;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("quantityPurchased".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.transaction.quantityPurchased = i;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("totalTransactionPrice".equals(s1))
            {
                s = item.transaction;
                s1 = new ItemCurrency();
                s.totalTransactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("shippedTime".equals(s1))
            {
                item.transaction.shipped = true;
                return super.get(s, s1, s2, attributes);
            }
            if ("bidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bidCount = i;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("watchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.watchCount = i;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("reserveMet".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.reserveMet = flag;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("buyerUserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderId = s;
                    }

            
            {
                this$1 = GetRemindersResponse.ItemElement.this;
                super();
            }
                };
            }
            if ("Variations".equals(s1))
            {
                return new Variations();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public GetRemindersResponse.ItemElement(MyEbayListItem myebaylistitem)
        {
            this$0 = GetRemindersResponse.this;
            super();
            item = myebaylistitem;
        }
    }

    final class GetRemindersResponse.ItemElement.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final MyEbayListItem item;
        final GetRemindersResponse.ItemElement this$1;

        public void text(String s)
            throws SAXException
        {
            item.listingType = 0;
            s.length();
            JVM INSTR tableswitch 7 16: default 68
        //                       7 69
        //                       8 87
        //                       9 68
        //                       10 105
        //                       11 68
        //                       12 68
        //                       13 68
        //                       14 141
        //                       15 68
        //                       16 196;
               goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1 _L5 _L1 _L6
_L1:
            return;
_L2:
            if (s.equals("Chinese"))
            {
                item.listingType = 2;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (s.equals("AdFormat"))
            {
                item.listingType = 1;
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
            if (s.equals("Classified"))
            {
                item.listingType = 4;
                return;
            }
            if (s.equals("FixedPrice"))
            {
                item.listingType = 5;
                return;
            }
            if (true)
            {
                continue; /* Loop/switch isn't completed */
            }
_L5:
            if (s.equals("AuctionWithBIN"))
            {
                item.listingType = 3;
                return;
            }
            if (s.equals("FixedPriceItem"))
            {
                item.listingType = 5;
                return;
            }
            if (s.equals("StoreInventory"))
            {
                item.listingType = 6;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (s.equals("StoresFixedPrice"))
            {
                item.listingType = 5;
                return;
            }
            if (true) goto _L1; else goto _L7
_L7:
        }

        public GetRemindersResponse.ItemElement.ListingType(MyEbayListItem myebaylistitem)
        {
            this$1 = GetRemindersResponse.ItemElement.this;
            super();
            item = myebaylistitem;
        }
    }

    private final class GetRemindersResponse.ItemElement.NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            NameValue namevalue = (NameValue)item.nameValueList.get(item.nameValueList.size() - 1);
            if ("Name".equals(s1))
            {
                return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement.NameValueList this$2;
                    final NameValue val$nameValue;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.setName(s);
                    }

            
            {
                this$2 = final_namevaluelist;
                nameValue = NameValue.this;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final GetRemindersResponse.ItemElement.NameValueList this$2;
                    final NameValue val$nameValue;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.addValue(s);
                    }

            
            {
                this$2 = final_namevaluelist;
                nameValue = NameValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public GetRemindersResponse.ItemElement.NameValueList()
        {
            this$1 = GetRemindersResponse.ItemElement.this;
            super();
            if (item.nameValueList == null)
            {
                item.nameValueList = new ArrayList();
            }
            item.nameValueList.add(new NameValue());
        }
    }

    private final class GetRemindersResponse.ItemElement.Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("VariationSpecifics".equals(s1))
            {
                return new GetRemindersResponse.ItemElement.VariationSpecifics();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.ItemElement.Variation()
        {
            this$1 = GetRemindersResponse.ItemElement.this;
            super();
        }

    }

    private final class GetRemindersResponse.ItemElement.VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("NameValueList".equals(s1))
            {
                return new GetRemindersResponse.ItemElement.NameValueList();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.ItemElement.VariationSpecifics()
        {
            this$1 = GetRemindersResponse.ItemElement.this;
            super();
        }

    }

    private final class GetRemindersResponse.ItemElement.Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse.ItemElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Variation".equals(s1))
            {
                return new GetRemindersResponse.ItemElement.Variation();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.ItemElement.Variations()
        {
            this$1 = GetRemindersResponse.ItemElement.this;
            super();
        }

    }

    private final class GetRemindersResponse.ReminderElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("paymentToSend".equals(s1) || "watchEndingSoon".equals(s1) || "feedbackToSend".equals(s1) || "outbid".equals(s1) || "bidEndingSoon".equals(s1) || "paymentToReceive".equals(s1) || "bestOffer".equals(s1) || "shippingNeeded".equals(s1) || "sellEndingSoon".equals(s1) || "secondChanceOffer".equals(s1) || "pickupReady".equals(s1))
            {
                listResult.count = Integer.valueOf(attributes.getValue("count")).intValue();
                listResult.nextPageLocator = attributes.getValue("nextPageLocator");
                s = listResult;
                boolean flag;
                if (attributes.getValue("hasMore") != null && attributes.getValue("hasMore").equals("true"))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s.hasMore = flag;
                return new GetRemindersResponse.ReminderTypeElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.ReminderElement()
        {
            this$0 = GetRemindersResponse.this;
            super();
        }

    }

    private final class GetRemindersResponse.ReminderTypeElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("item".equals(s1))
            {
                s = new MyEbayListItem();
                s.transaction = new com.ebay.nautilus.domain.data.MyEbayListItem.Transaction();
                items.add(s);
                return new GetRemindersResponse.ItemElement(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.ReminderTypeElement()
        {
            this$0 = GetRemindersResponse.this;
            super();
        }

    }

    private final class GetRemindersResponse.RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetRemindersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://schemas.xmlsoap.org/soap/envelope/".equals(s) && "Body".equals(s1))
            {
                return new GetRemindersResponse.BodyElement();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private GetRemindersResponse.RootElement()
        {
            this$0 = GetRemindersResponse.this;
            super();
        }

    }


    private static final String API_VERSION_HEADER = "x-ebay-api-version";
    public static final int BUYING_REMINDER_BEST_OFFER = 5;
    public static final String BUYING_REMINDER_BEST_OFFER_SEL = "buyingReminder.bestOffer";
    public static final int BUYING_REMINDER_BIDDING_ENDING = 3;
    public static final String BUYING_REMINDER_BIDDING_ENDING_SEL = "buyingReminder.bidEndingSoon";
    public static final int BUYING_REMINDER_FEEDBACK_TO_SEND = 0;
    public static final String BUYING_REMINDER_FEEDBACK_TO_SEND_SEL = "buyingReminder.feedbackToSend";
    public static final int BUYING_REMINDER_OUTBID = 4;
    public static final String BUYING_REMINDER_OUTBID_SEL = "buyingReminder.outbid";
    public static final int BUYING_REMINDER_PAYMENT_TO_SEND = 1;
    public static final String BUYING_REMINDER_PAYMENT_TO_SEND_SEL = "buyingReminder.paymentToSend";
    public static final int BUYING_REMINDER_PICKUP_READY = 7;
    public static final String BUYING_REMINDER_PICKUP_READY_SEL = "buyingReminder.pickupReady";
    public static final int BUYING_REMINDER_SECOND_CHANCE_OFFER = 6;
    public static final String BUYING_REMINDER_SECOND_CHANCE_OFFER_SEL = "buyingReminder.secondChanceOffer";
    public static final int BUYING_REMINDER_WATCHING_ENDING = 2;
    public static final String BUYING_REMINDER_WATCHING_ENDING_SEL = "buyingReminder.watchEndingSoon";
    public static final int SELLING_REMINDER_BEST_OFFER = 14;
    public static final String SELLING_REMINDER_BEST_OFFER_SEL = "sellingReminder.bestOffer";
    public static final int SELLING_REMINDER_FEEDBACK_TO_SEND = 10;
    public static final String SELLING_REMINDER_FEEDBACK_TO_SEND_SEL = "sellingReminder.feedbackToSend";
    public static final int SELLING_REMINDER_PAYMENT_TO_RECEIVE = 11;
    public static final String SELLING_REMINDER_PAYMENT_TO_RECEIVE_SEL = "sellingReminder.paymentToReceive";
    public static final int SELLING_REMINDER_SELL_ENDING = 13;
    public static final String SELLING_REMINDER_SELL_ENDING_SEL = "sellingReminder.sellEndingSoon";
    public static final int SELLING_REMINDER_SHIPPING_NEEDED = 12;
    public static final String SELLING_REMINDER_SHIPPING_NEEDED_SEL = "sellingReminder.shippingNeeded";

    public ApsGetReminders()
    {
    }

    public static final RemindersList getReminderItems(EbayContext ebaycontext, String s, EbaySite ebaysite, String s1, int i, int j, String s2)
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        i;
        JVM INSTR tableswitch 0 14: default 76
    //                   0 107
    //                   1 114
    //                   2 142
    //                   3 121
    //                   4 135
    //                   5 128
    //                   6 149
    //                   7 156
    //                   8 76
    //                   9 76
    //                   10 163
    //                   11 170
    //                   12 177
    //                   13 191
    //                   14 184;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L1 _L1 _L10 _L11 _L12 _L13 _L14
_L1:
        String s3 = "buyingReminder.feedbackToSend";
_L16:
        return ((GetRemindersResponse)EbayRequestHelper.sendRequest(ebaycontext, new GetRemindersRequest(s, ebaysite, s1, s3, j, s2))).listResult;
_L2:
        s3 = "buyingReminder.feedbackToSend";
        continue; /* Loop/switch isn't completed */
_L3:
        s3 = "buyingReminder.paymentToSend";
        continue; /* Loop/switch isn't completed */
_L5:
        s3 = "buyingReminder.bidEndingSoon";
        continue; /* Loop/switch isn't completed */
_L7:
        s3 = "buyingReminder.bestOffer";
        continue; /* Loop/switch isn't completed */
_L6:
        s3 = "buyingReminder.outbid";
        continue; /* Loop/switch isn't completed */
_L4:
        s3 = "buyingReminder.watchEndingSoon";
        continue; /* Loop/switch isn't completed */
_L8:
        s3 = "buyingReminder.secondChanceOffer";
        continue; /* Loop/switch isn't completed */
_L9:
        s3 = "buyingReminder.pickupReady";
        continue; /* Loop/switch isn't completed */
_L10:
        s3 = "sellingReminder.feedbackToSend";
        continue; /* Loop/switch isn't completed */
_L11:
        s3 = "sellingReminder.paymentToReceive";
        continue; /* Loop/switch isn't completed */
_L12:
        s3 = "sellingReminder.shippingNeeded";
        continue; /* Loop/switch isn't completed */
_L14:
        s3 = "sellingReminder.bestOffer";
        continue; /* Loop/switch isn't completed */
_L13:
        s3 = "sellingReminder.sellEndingSoon";
        if (true) goto _L16; else goto _L15
_L15:
    }
}
