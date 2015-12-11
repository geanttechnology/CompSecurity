// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import java.util.ArrayList;
import java.util.Date;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotSupportedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

static final class timestamp extends com.ebay.nautilus.kernel.util.ement.Item
{
    private final class BestOfferDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

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

                    final BestOfferDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bestOfferStatus = s;
                    }

            
            {
                this$1 = BestOfferDetails.this;
                super();
            }
                };
            }
            if ("BestOfferCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final BestOfferDetails this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bestOfferPendingCount = i;
                    }

            
            {
                this$1 = BestOfferDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private BestOfferDetails()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        BestOfferDetails(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class BiddingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

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

        private BiddingDetails()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        BiddingDetails(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ListingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

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

                    final ListingDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.startDate = EbayDateUtils.parseXml(s);
                    }

            
            {
                this$1 = ListingDetails.this;
                super();
            }
                };
            }
            if ("EndTime".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ListingDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.endDate = EbayDateUtils.parseXml(s);
                        item.endTimestamp = item.endDate.getTime();
                    }

            
            {
                this$1 = ListingDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ListingDetails()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        ListingDetails(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final GetMyEbayResponse.RootElement.Item this$0;

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

        private ListingType()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        ListingType(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected final NameValue nameValue;
        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final NameValueList this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.setName(s);
                    }

            
            {
                this$1 = NameValueList.this;
                super();
            }
                };
            }
            if ("Value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final NameValueList this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        nameValue.addValue(s);
                    }

            
            {
                this$1 = NameValueList.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public NameValueList(NameValue namevalue)
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
            nameValue = namevalue;
        }
    }

    private final class PictureDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("GalleryURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final PictureDetails this$1;

                    public void text(String s)
                        throws SAXException
                    {
                        item.imageUrl = s;
                    }

            
            {
                this$1 = PictureDetails.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private PictureDetails()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        PictureDetails(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("BidCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final SellingStatus this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        item.bidCount = i;
                    }

            
            {
                this$1 = SellingStatus.this;
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

                    final SellingStatus this$1;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.reserveMet = flag;
                    }

            
            {
                this$1 = SellingStatus.this;
                super();
            }
                };
            }
            if ("HighBidder".equals(s1))
            {
                return new HighBidder(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SellingStatus()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        SellingStatus(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SellingStatus.HighBidder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SellingStatus this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SellingStatus.HighBidder this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderId = s;
                    }

            
            {
                this$2 = SellingStatus.HighBidder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SellingStatus.HighBidder()
        {
            this$1 = SellingStatus.this;
            super();
        }

        SellingStatus.HighBidder(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ShippingType".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final ShippingDetails this$1;

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
                this$1 = ShippingDetails.this;
                super();
            }
                };
            }
            if (item.shippingCost == null && "ShippingServiceOptions".equals(s1))
            {
                return new ShippingServiceOptions(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ShippingDetails()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        ShippingDetails(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class ShippingDetails.ShippingServiceOptions extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final ShippingDetails this$1;

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

        private ShippingDetails.ShippingServiceOptions()
        {
            this$1 = ShippingDetails.this;
            super();
        }

        ShippingDetails.ShippingServiceOptions(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class TimeLeft extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final GetMyEbayResponse.RootElement.Item this$0;

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

        private TimeLeft()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        TimeLeft(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Variation extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("VariationSpecifics".equals(s1))
            {
                return new VariationSpecifics(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Variation()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        Variation(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

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
                return new NameValueList(s);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private VariationSpecifics()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        VariationSpecifics(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("Variation".equals(s1))
            {
                return new Variation(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Variations()
        {
            this$0 = GetMyEbayResponse.RootElement.Item.this;
            super();
        }

        Variations(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }


    protected final MyEbayListItem item;
    protected final Date timestamp;

    public com.ebay.nautilus.kernel.util.ement.Item get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("BestOfferDetails".equals(s1))
        {
            item.bestOfferEnabled = true;
            return new BestOfferDetails(null);
        }
        if ("ItemID".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final GetMyEbayResponse.RootElement.Item this$0;

                public void setValue(long l)
                    throws SAXException
                {
                    item.id = l;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.Item.this;
                super();
            }
            };
        }
        if ("Title".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Item this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.title = s3;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.Item.this;
                super();
            }
            };
        }
        if ("PictureDetails".equals(s1))
        {
            return new PictureDetails(null);
        }
        if ("ListingDetails".equals(s1))
        {
            return new ListingDetails(null);
        }
        if ("ListingType".equals(s1))
        {
            return new ListingType(null);
        }
        if ("SellingStatus".equals(s1))
        {
            return new SellingStatus(null);
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
            return new BiddingDetails(null);
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
            return new ShippingDetails(null);
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
            return new TimeLeft(null);
        }
        if ("Variations".equals(s1))
        {
            return new Variations(null);
        }
        if ("WatchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.Item this$0;

                public void setValue(int i)
                    throws SAXException
                {
                    item.watchCount = i;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.Item.this;
                super();
            }
            };
        }
        if ("Relisted".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final GetMyEbayResponse.RootElement.Item this$0;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    item.isRelisted = flag;
                }

            
            {
                this$0 = GetMyEbayResponse.RootElement.Item.this;
                super();
            }
            };
        } else
        {
            return super.Item(s, s1, s2, attributes);
        }
    }

    public _cls4.this._cls0(MyEbayListItem myebaylistitem, Date date)
    {
        item = myebaylistitem;
        timestamp = date;
    }
}
