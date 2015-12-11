// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.content.ServiceContentOverride;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.domain.data.SellerTotals;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

public final class GetMyEbayResponse extends EbayResponse
{
    private static final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final HashSet listElementNames = new HashSet();
        final GetMyEbayResponse response;
        final TimestampElement timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(response);
                }
                if ("Timestamp".equals(s1))
                {
                    return timestamp;
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(response, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Summary".equals(s1))
                {
                    s = response;
                    s1 = new SellerTotals();
                    s.sellerTotals = s1;
                    return new SummaryElement(s1);
                }
                if (listElementNames.contains(s1))
                {
                    s1 = response;
                    if (timestamp.hostTime != 0L)
                    {
                        s = new Date(timestamp.hostTime);
                    } else
                    {
                        s = null;
                    }
                    return new ListElement(s1, s);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement(GetMyEbayResponse getmyebayresponse)
        {
            response = getmyebayresponse;
            timestamp = new TimestampElement(getmyebayresponse);
            getmyebayresponse = listElementNames;
            getmyebayresponse.add("ActiveList");
            getmyebayresponse.add("SoldList");
            getmyebayresponse.add("UnsoldList");
            getmyebayresponse.add("ScheduledList");
            getmyebayresponse.add("WatchList");
            getmyebayresponse.add("WonList");
            getmyebayresponse.add("LostList");
            getmyebayresponse.add("BidList");
            getmyebayresponse.add("BestOfferList");
            getmyebayresponse.add("UserDefinedList");
        }
    }

    static final class RootElement.Buyer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final MyEbayListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Buyer this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.buyerUserID = s;
                    }

            
            {
                this$0 = RootElement.Buyer.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.Buyer(MyEbayListItem myebaylistitem)
        {
            item = myebaylistitem;
        }
    }

    static final class RootElement.Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final MyEbayListItem item;
        protected final Date timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BestOfferDetails".equals(s1))
            {
                item.bestOfferEnabled = true;
                return new BestOfferDetails();
            }
            if ("ItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final RootElement.Item this$0;

                    public void setValue(long l)
                        throws SAXException
                    {
                        item.id = l;
                    }

            
            {
                this$0 = RootElement.Item.this;
                super();
            }
                };
            }
            if ("Title".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.title = s;
                    }

            
            {
                this$0 = RootElement.Item.this;
                super();
            }
                };
            }
            if ("PictureDetails".equals(s1))
            {
                return new PictureDetails();
            }
            if ("ListingDetails".equals(s1))
            {
                return new ListingDetails();
            }
            if ("ListingType".equals(s1))
            {
                return new ListingType();
            }
            if ("SellingStatus".equals(s1))
            {
                return new SellingStatus();
            }
            if ("ReservePrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.reservePrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("BiddingDetails".equals(s1))
            {
                return new BiddingDetails();
            }
            if ("BuyItNowPrice".equals(s1))
            {
                item.buyItNowAvailable = true;
                s = item;
                s1 = new ItemCurrency();
                s.buyItNowPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ShippingDetails".equals(s1))
            {
                return new ShippingDetails();
            }
            if ("StartPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.startPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("TimeLeft".equals(s1) && timestamp != null)
            {
                return new TimeLeft();
            }
            if ("Variations".equals(s1))
            {
                return new Variations();
            }
            if ("WatchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.Item this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.watchCount = i;
                    }

            
            {
                this$0 = RootElement.Item.this;
                super();
            }
                };
            }
            if ("Relisted".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final RootElement.Item this$0;

                    protected void setValue(boolean flag)
                        throws SAXException
                    {
                        item.isRelisted = flag;
                    }

            
            {
                this$0 = RootElement.Item.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.Item(MyEbayListItem myebaylistitem, Date date)
        {
            item = myebaylistitem;
            timestamp = date;
        }
    }

    private final class RootElement.Item.BestOfferDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BestOffer".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.bestOfferAmount = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("BestOfferStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.BestOfferDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bestOfferStatus = s;
                    }

            
            {
                this$1 = RootElement.Item.BestOfferDetails.this;
                super();
            }
                };
            }
            if ("BestOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.Item.BestOfferDetails this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bestOfferPendingCount = i;
                    }

            
            {
                this$1 = RootElement.Item.BestOfferDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.BestOfferDetails()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.BiddingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ConvertedMaxBid".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedMaxBidPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("MaxBid".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.maxBidPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.BiddingDetails()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ConvertedBuyItNowPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedBuyItNowPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("StartTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.ListingDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.startDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = RootElement.Item.ListingDetails.this;
                super();
            }
                };
            }
            if ("EndTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.ListingDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.endDate = EbayDateUtils.parseXml(s);
                        item.endTimestamp = item.endDate.getTime();
                    }

            
            {
                this$1 = RootElement.Item.ListingDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.ListingDetails()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final RootElement.Item this$0;

        public void text(String s)
            throws SAXException
        {
            int i = 0;
            if (!s.equals("Chinese") && !s.equals("Dutch")) goto _L2; else goto _L1
_L1:
            i = 2;
_L4:
            item.listingType = i;
            return;
_L2:
            if (s.equals("AdType"))
            {
                i = 1;
            } else
            if (s.equals("FixedPriceItem"))
            {
                i = 5;
            } else
            if (s.equals("StoresFixedPrice"))
            {
                i = 6;
            } else
            if (s.equals("LeadGeneration"))
            {
                i = 4;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private RootElement.Item.ListingType()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final NameValue nameValue;
        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.NameValueList this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.setName(s);
                    }

            
            {
                this$1 = RootElement.Item.NameValueList.this;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.NameValueList this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.addValue(s);
                    }

            
            {
                this$1 = RootElement.Item.NameValueList.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.Item.NameValueList(NameValue namevalue)
        {
            this$0 = RootElement.Item.this;
            super();
            nameValue = namevalue;
        }
    }

    private final class RootElement.Item.PictureDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("GalleryURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.PictureDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageUrl = s;
                    }

            
            {
                this$1 = RootElement.Item.PictureDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.PictureDetails()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.Item.SellingStatus this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bidCount = i;
                    }

            
            {
                this$1 = RootElement.Item.SellingStatus.this;
                super();
            }
                };
            }
            if ("ConvertedCurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.convertedCurrentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("CurrentPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.currentPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("ReserveMet".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final RootElement.Item.SellingStatus this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.reserveMet = flag;
                    }

            
            {
                this$1 = RootElement.Item.SellingStatus.this;
                super();
            }
                };
            }
            if ("HighBidder".equals(s1))
            {
                return new HighBidder();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.SellingStatus()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.SellingStatus.HighBidder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item.SellingStatus this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.SellingStatus.HighBidder this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderId = s;
                    }

            
            {
                this$2 = RootElement.Item.SellingStatus.HighBidder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.SellingStatus.HighBidder()
        {
            this$1 = RootElement.Item.SellingStatus.this;
            super();
        }

    }

    private final class RootElement.Item.ShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ShippingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.Item.ShippingDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        if (s.equals("Freight"))
                        {
                            item.shippingType = "Freight";
                            return;
                        }
                        if (s.equals("NotSpecified"))
                        {
                            item.shippingType = "NotSpecified";
                            return;
                        }
                        if (s.equals("Calculated"))
                        {
                            item.shippingType = "Calculated";
                            return;
                        }
                        if (s.equals("Flat") && item.shippingCost != null && item.shippingCost.value != null && (item.shippingCost.value.equals("0.00") || item.shippingCost.value.equals("0.0") || item.shippingCost.value.equals("0")))
                        {
                            item.shippingType = "Free";
                            return;
                        } else
                        {
                            item.shippingType = null;
                            return;
                        }
                    }

            
            {
                this$1 = RootElement.Item.ShippingDetails.this;
                super();
            }
                };
            }
            if (item.shippingCost == null && "ShippingServiceOptions".equals(s1))
            {
                return new ShippingServiceOptions();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.ShippingDetails()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.ShippingDetails.ShippingServiceOptions extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item.ShippingDetails this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ShippingServiceCost".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.shippingCost = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("LocalPickup".equals(s1))
            {
                item.localPickup = true;
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement.Item.ShippingDetails.ShippingServiceOptions()
        {
            this$1 = RootElement.Item.ShippingDetails.this;
            super();
        }

    }

    private final class RootElement.Item.TimeLeft extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final RootElement.Item this$0;

        public void text(String s)
            throws SAXException
        {
            if (item.endDate != null)
            {
                break MISSING_BLOCK_LABEL_69;
            }
            s = Duration.parse(s, timestamp);
            item.endDate = s.getEndFromStart(timestamp);
            item.endTimestamp = item.endDate.getTime();
            return;
            s;
            throw new SAXNotSupportedException(s.getLocalizedMessage());
        }

        private RootElement.Item.TimeLeft()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("VariationSpecifics".equals(s1))
            {
                return new RootElement.Item.VariationSpecifics();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.Variation()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("NameValueList".equals(s1))
            {
                if (item.nameValueList == null)
                {
                    item.nameValueList = new ArrayList();
                }
                s = new NameValue();
                item.nameValueList.add(s);
                return new RootElement.Item.NameValueList(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.VariationSpecifics()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private final class RootElement.Item.Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Variation".equals(s1))
            {
                return new RootElement.Item.Variation();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.Item.Variations()
        {
            this$0 = RootElement.Item.this;
            super();
        }

    }

    private static final class RootElement.ListElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final GetMyEbayResponse response;
        private final Date timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ItemArray".equals(s1))
            {
                s = response;
                s1 = new ArrayList(response.maxItemCount);
                s.resultItemList = s1;
                return new ItemArray(s1, timestamp);
            }
            if ("PaginationResult".equals(s1))
            {
                return new PaginationResultElement();
            }
            if ("OrderTransactionArray".equals(s1))
            {
                s = response;
                s1 = new ArrayList(response.maxItemCount);
                s.resultItemList = s1;
                return new OrderTransactionArray(s1);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.ListElement(GetMyEbayResponse getmyebayresponse, Date date)
        {
            response = getmyebayresponse;
            timestamp = date;
        }
    }

    private static final class RootElement.ListElement.ItemArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ArrayList items;
        private final Date timestamp;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Item".equals(s1))
            {
                s = new MyEbayListItem();
                items.add(s);
                return new RootElement.Item(s, timestamp);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.ListElement.ItemArray(ArrayList arraylist, Date date)
        {
            items = arraylist;
            timestamp = date;
        }
    }

    private static final class RootElement.ListElement.OrderTransactionArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final ArrayList items;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("OrderTransaction".equals(s1))
            {
                return new OrderTransaction();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.ListElement.OrderTransactionArray(ArrayList arraylist)
        {
            items = arraylist;
        }
    }

    final class RootElement.ListElement.OrderTransactionArray.Order extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public String orderId;
        final RootElement.ListElement.OrderTransactionArray this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            Object obj;
            if ("OrderID".equals(s1))
            {
                obj = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ListElement.OrderTransactionArray.Order this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        orderId = s;
                    }

            
            {
                this$1 = RootElement.ListElement.OrderTransactionArray.Order.this;
                super();
            }
                };
            } else
            {
                obj = this;
                if (!"TransactionArray".equals(s1))
                {
                    if ("Transaction".equals(s1))
                    {
                        s = new MyEbayListItem();
                        items.add(s);
                        s.orderId = orderId;
                        return new RootElement.ListElement.OrderTransactionArray.Transaction(s, orderId);
                    } else
                    {
                        return super.get(s, s1, s2, attributes);
                    }
                }
            }
            return ((com.ebay.nautilus.kernel.util.SaxHandler.Element) (obj));
        }

        RootElement.ListElement.OrderTransactionArray.Order()
        {
            this$0 = RootElement.ListElement.OrderTransactionArray.this;
            super();
            orderId = null;
        }
    }

    private final class RootElement.ListElement.OrderTransactionArray.OrderTransaction extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.ListElement.OrderTransactionArray this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Order".equals(s1))
            {
                return new RootElement.ListElement.OrderTransactionArray.Order();
            }
            if ("Transaction".equals(s1))
            {
                s = new MyEbayListItem();
                items.add(s);
                return new RootElement.ListElement.OrderTransactionArray.Transaction(s, null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.ListElement.OrderTransactionArray.OrderTransaction()
        {
            this$0 = RootElement.ListElement.OrderTransactionArray.this;
            super();
        }

    }

    static final class RootElement.ListElement.OrderTransactionArray.Transaction extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final MyEbayListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("CreatedDate".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.createdDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$0 = RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("TotalTransactionPrice".equals(s1))
            {
                s = item.transaction;
                s1 = new ItemCurrency();
                s.totalTransactionPrice = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("BuyerPaidStatus".equals(s1) || "SellerPaidStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.paidStatus = s;
                    }

            
            {
                this$0 = RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if (!"FeedbackLeft".equals(s1)) goto _L2; else goto _L1
_L1:
            item.transaction.feedbackLeft = true;
_L4:
            return super.get(s, s1, s2, attributes);
_L2:
            if ("FeedbackReceived".equals(s1))
            {
                item.transaction.feedbackReceived = true;
                continue; /* Loop/switch isn't completed */
            }
            if ("QuantityPurchased".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.transaction.quantityPurchased = i;
                    }

            
            {
                this$0 = RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("TransactionID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.transactionId = s;
                    }

            
            {
                this$0 = RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if (!"ShippedTime".equals(s1))
            {
                break; /* Loop/switch isn't completed */
            }
            item.transaction.shipped = true;
            if (true) goto _L4; else goto _L3
_L3:
            if ("Item".equals(s1))
            {
                return new RootElement.Item(item, null);
            }
            if ("Buyer".equals(s1))
            {
                return new RootElement.Buyer(item);
            }
            if ("OrderLineItemID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.orderId = s;
                    }

            
            {
                this$0 = RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("PaidTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.ListElement.OrderTransactionArray.Transaction this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.transaction.paidTime = s;
                    }

            
            {
                this$0 = RootElement.ListElement.OrderTransactionArray.Transaction.this;
                super();
            }
                };
            }
            if ("PickupMethodSelected".equals(s1))
            {
                return new RootElement.PickupMethodSelected(item.transaction);
            }
            if (true) goto _L4; else goto _L5
_L5:
        }

        public RootElement.ListElement.OrderTransactionArray.Transaction(MyEbayListItem myebaylistitem, String s)
        {
            item = myebaylistitem;
            myebaylistitem.transaction = new com.ebay.nautilus.domain.data.MyEbayListItem.Transaction();
            myebaylistitem.transaction.orderId = s;
        }
    }

    private final class RootElement.ListElement.PaginationResultElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.ListElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("TotalNumberOfEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ListElement.PaginationResultElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        response.totalEntries = i;
                    }

            
            {
                this$1 = RootElement.ListElement.PaginationResultElement.this;
                super();
            }
                };
            }
            if ("TotalNumberOfPages".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ListElement.PaginationResultElement this$1;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        response.totalPages = i;
                    }

            
            {
                this$1 = RootElement.ListElement.PaginationResultElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.ListElement.PaginationResultElement()
        {
            this$0 = RootElement.ListElement.this;
            super();
        }

    }

    static final class RootElement.PickupMethodSelected extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final com.ebay.nautilus.domain.data.MyEbayListItem.Transaction tx;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("PickupMethod".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.PickupMethodSelected this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        tx.pickupMethod = s;
                    }

            
            {
                this$0 = RootElement.PickupMethodSelected.this;
                super();
            }
                };
            }
            if ("PickupStoreID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.PickupMethodSelected this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        tx.pickupStoreId = s;
                    }

            
            {
                this$0 = RootElement.PickupMethodSelected.this;
                super();
            }
                };
            }
            if ("PickupStatus".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.PickupMethodSelected this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        tx.pickupStatus = OrderPickupStatus.getByName(s);
                    }

            
            {
                this$0 = RootElement.PickupMethodSelected.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.PickupMethodSelected(com.ebay.nautilus.domain.data.MyEbayListItem.Transaction transaction)
        {
            tx = transaction;
        }
    }

    private static final class RootElement.SummaryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final SellerTotals sellerTotals;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ActiveAuctionCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SummaryElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        sellerTotals.activeAuctionCount = i;
                    }

            
            {
                this$0 = RootElement.SummaryElement.this;
                super();
            }
                };
            }
            if ("AuctionSellingCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SummaryElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        sellerTotals.auctionSellingCount = i;
                    }

            
            {
                this$0 = RootElement.SummaryElement.this;
                super();
            }
                };
            }
            if ("AuctionBidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SummaryElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        sellerTotals.auctionBidCount = i;
                    }

            
            {
                this$0 = RootElement.SummaryElement.this;
                super();
            }
                };
            }
            if ("TotalSoldCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SummaryElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        sellerTotals.totalSoldCount = i;
                    }

            
            {
                this$0 = RootElement.SummaryElement.this;
                super();
            }
                };
            }
            if ("TotalSoldValue".equals(s1))
            {
                s = sellerTotals;
                s1 = new ItemCurrency();
                s.totalSoldValue = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("SoldDurationInDays".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SummaryElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        sellerTotals.soldDurationInDays = i;
                    }

            
            {
                this$0 = RootElement.SummaryElement.this;
                super();
            }
                };
            }
            if ("QuantityLimitRemaining".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.SummaryElement this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        sellerTotals.quantityLimitRemaining = i;
                    }

            
            {
                this$0 = RootElement.SummaryElement.this;
                super();
            }
                };
            }
            if ("AmountLimitRemaining".equals(s1))
            {
                s = sellerTotals;
                s1 = new ItemCurrency();
                s.amountLimitRemaining = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            }
            if ("TotalAuctionSellingValue".equals(s1))
            {
                s = sellerTotals;
                s1 = new ItemCurrency();
                s.totalAuctionSellingValue = s1;
                return new CurrencyElement(s1, "currencyID", attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.SummaryElement(SellerTotals sellertotals)
        {
            sellerTotals = sellertotals;
        }
    }


    final int maxItemCount;
    public ArrayList resultItemList;
    public SellerTotals sellerTotals;
    public int totalEntries;
    public int totalPages;

    public GetMyEbayResponse(int i)
    {
        resultItemList = null;
        totalPages = 0;
        totalEntries = 0;
        maxItemCount = i;
    }

    private void applyOverrides()
    {
        if (resultItemList != null)
        {
            Iterator iterator = resultItemList.iterator();
            while (iterator.hasNext()) 
            {
                MyEbayListItem myebaylistitem = (MyEbayListItem)iterator.next();
                long l = myebaylistitem.id;
                Object obj = ServiceContentOverride.getBidCount(l);
                if (obj != null)
                {
                    myebaylistitem.bidCount = ((Integer) (obj)).intValue();
                }
                obj = ServiceContentOverride.getHighBidder(l);
                if (obj != null)
                {
                    myebaylistitem.highBidderId = ((String) (obj));
                }
                obj = ServiceContentOverride.getCurrentPrice(l);
                if (obj != null)
                {
                    myebaylistitem.currentPrice = ((ItemCurrency) (obj));
                }
                obj = ServiceContentOverride.getConvertedPrice(l);
                if (obj != null)
                {
                    myebaylistitem.convertedCurrentPrice = ((ItemCurrency) (obj));
                }
                if (myebaylistitem.transaction != null)
                {
                    Object obj1 = myebaylistitem.transaction.transactionId;
                    if (ServiceContentOverride.getFeedbackLeft(myebaylistitem.id, ((String) (obj1))))
                    {
                        myebaylistitem.transaction.feedbackLeft = true;
                    }
                    String s = ServiceContentOverride.getPaidStatus(l, ((String) (obj1)));
                    if (s != null)
                    {
                        myebaylistitem.transaction.paidStatus = s;
                    }
                    obj1 = ServiceContentOverride.isShipped(l, ((String) (obj1)));
                    if (obj1 != null)
                    {
                        myebaylistitem.transaction.shipped = ((Boolean) (obj1)).booleanValue();
                    }
                }
            }
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement(this));
        if (totalEntries == 0 && resultItemList != null)
        {
            totalEntries = resultItemList.size();
        }
        if (totalPages == 0 && totalEntries != 0)
        {
            totalPages = 1;
        }
        applyOverrides();
    }
}
