// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.AllBiddersData;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetAllBiddersResponse extends EbayResponse
{
    private final class BidArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final AllBiddersData allBidders;
        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Offer".equals(s1))
            {
                return new Offer(allBidders);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public BidArray(AllBiddersData allbiddersdata)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            allBidders = allbiddersdata;
        }
    }

    private final class BiddingSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.AllBiddersData.Offer.BiddingSummary biddingSummary;
        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("BidActivityWithSeller".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final BiddingSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            biddingSummary.bidActivityWithSeller = i;
                        }

            
            {
                this$1 = BiddingSummary.this;
                super();
            }
                    };
                }
                if ("BidRetractions".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final BiddingSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            biddingSummary.bidRetractions = i;
                        }

            
            {
                this$1 = BiddingSummary.this;
                super();
            }
                    };
                }
                if ("BidsToUniqueCategories".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final BiddingSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            biddingSummary.bidsToUniqueCategories = i;
                        }

            
            {
                this$1 = BiddingSummary.this;
                super();
            }
                    };
                }
                if ("BidsToUniqueSellers".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final BiddingSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            biddingSummary.bidsToUniqueSellers = i;
                        }

            
            {
                this$1 = BiddingSummary.this;
                super();
            }
                    };
                }
                if ("ItemBidDetails".equals(s1))
                {
                    return new ItemBidDetails(biddingSummary);
                }
                if ("SummaryDays".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final BiddingSummary this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            biddingSummary.summaryDays = s;
                        }

            
            {
                this$1 = BiddingSummary.this;
                super();
            }
                    };
                }
                if ("TotalBids".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final BiddingSummary this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            biddingSummary.totalBids = i;
                        }

            
            {
                this$1 = BiddingSummary.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public BiddingSummary(com.ebay.common.model.AllBiddersData.Offer.BiddingSummary biddingsummary)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            biddingSummary = biddingsummary;
        }
    }

    private final class BuyerInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.AllBiddersData.Offer.BuyerInfo buyerInfo;
        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "ShippingAddress".equals(s1))
            {
                return new ShippingAddress(buyerInfo.shippingAddress);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public BuyerInfo(com.ebay.common.model.AllBiddersData.Offer.BuyerInfo buyerinfo)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            buyerInfo = buyerinfo;
        }
    }

    private final class ItemBidDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.AllBiddersData.Offer.ItemBidDetail itemBidDetail = new com.ebay.common.model.AllBiddersData.Offer.ItemBidDetail();
        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("BidCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final ItemBidDetails this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            itemBidDetail.bidCount = i;
                        }

            
            {
                this$1 = ItemBidDetails.this;
                super();
            }
                    };
                }
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ItemBidDetails this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemBidDetail.categoryId = s;
                        }

            
            {
                this$1 = ItemBidDetails.this;
                super();
            }
                    };
                }
                if ("ItemID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ItemBidDetails this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemBidDetail.itemId = s;
                        }

            
            {
                this$1 = ItemBidDetails.this;
                super();
            }
                    };
                }
                if ("LastBidTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ItemBidDetails this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemBidDetail.lastBidTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = ItemBidDetails.this;
                super();
            }
                    };
                }
                if ("SellerID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ItemBidDetails this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            itemBidDetail.sellerId = s;
                        }

            
            {
                this$1 = ItemBidDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ItemBidDetails(com.ebay.common.model.AllBiddersData.Offer.BiddingSummary biddingsummary)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            biddingsummary.itemBidDetails.add(itemBidDetail);
        }
    }

    private final class Offer extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.AllBiddersData.Offer offer = new com.ebay.common.model.AllBiddersData.Offer();
        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Action".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Offer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.action = s;
                        }

            
            {
                this$1 = Offer.this;
                super();
            }
                    };
                }
                if ("ConvertedPrice".equals(s1))
                {
                    s = offer;
                    s1 = new ItemCurrency();
                    s.convertedPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("Currency".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Offer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.currency = s;
                        }

            
            {
                this$1 = Offer.this;
                super();
            }
                    };
                }
                if ("HighestBid".equals(s1))
                {
                    s = offer;
                    s1 = new ItemCurrency();
                    s.highestBid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("MaxBid".equals(s1))
                {
                    s = offer;
                    s1 = new ItemCurrency();
                    s.maxBid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("MyMaxBid".equals(s1))
                {
                    s = offer;
                    s1 = new ItemCurrency();
                    s.myMaxBid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("Quantity".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Offer this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            offer.quantity = i;
                        }

            
            {
                this$1 = Offer.this;
                super();
            }
                    };
                }
                if ("SecondChanceEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Offer this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            offer.secondChanceEnabled = flag;
                        }

            
            {
                this$1 = Offer.this;
                super();
            }
                    };
                }
                if ("SiteCurrency".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Offer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.siteCurrency = s;
                        }

            
            {
                this$1 = Offer.this;
                super();
            }
                    };
                }
                if ("TimeBid".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Offer this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            offer.timeBid = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = Offer.this;
                super();
            }
                    };
                }
                if ("User".equals(s1))
                {
                    return new User(offer.user);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Offer(AllBiddersData allbiddersdata)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            allbiddersdata.offers.add(offer);
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetAllBiddersResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetAllBiddersResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetAllBiddersResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Version".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            allBidders.setVersion(s);
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("Build".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            allBidders.setBuild(s);
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("BidArray".equals(s1))
                {
                    return new BidArray(allBidders);
                }
                if ("HighBidder".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            allBidders.highBidder = s;
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("HighestBid ".equals(s1))
                {
                    s = allBidders;
                    s1 = new ItemCurrency();
                    s.highestBid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ListingStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            allBidders.listingStatus = s;
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public RootElement()
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            allBidders = new AllBiddersData();
        }
    }

    private final class ShippingAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.common.model.AllBiddersData.Offer.ShippingAddress shippingAddress;
        final GetAllBiddersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Country".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            shippingAddress.country = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
                if ("PostalCode".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final ShippingAddress this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            shippingAddress.postalCode = s;
                        }

            
            {
                this$1 = ShippingAddress.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public ShippingAddress(com.ebay.common.model.AllBiddersData.Offer.ShippingAddress shippingaddress)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            shippingAddress = shippingaddress;
        }
    }

    private final class User extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetAllBiddersResponse this$0;
        private final com.ebay.common.model.AllBiddersData.Offer.User user;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("AboutMePage".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.aboutMePage = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("BiddingSummary".equals(s1))
                {
                    return new BiddingSummary(user.biddingSummary);
                }
                if ("BuyerInfo".equals(s1))
                {
                    return new BuyerInfo(user.buyerInfo);
                }
                if ("eBayGoodStanding".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.eBayGoodStanding = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("Email".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.email = s;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("FeedbackPrivate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.feedbackPrivate = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.feedbackRatingStar = s;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final User this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            user.feedbackScore = i;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("IDVerified".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.IdVerified = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("NewUser".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.newUser = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("PositiveFeedbackPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final User this$1;

                        public void setValue(float f)
                            throws SAXException
                        {
                            user.positiveFeedbackPercent = f;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("RegistrationDate".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.registrationDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("Site".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.site = s;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("Status".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.status = s;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("UserAnonymized".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.userAnonymized = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.userId = s;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("UserIDChanged".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final User this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            user.userIdChanged = flag;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("UserIDLastChanged".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.userIdLastChanged = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
                if ("VATStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final User this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            user.vatStatus = s;
                        }

            
            {
                this$1 = User.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public User(com.ebay.common.model.AllBiddersData.Offer.User user1)
        {
            this$0 = GetAllBiddersResponse.this;
            super();
            user = user1;
        }
    }


    public AllBiddersData allBidders;

    public GetAllBiddersResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
