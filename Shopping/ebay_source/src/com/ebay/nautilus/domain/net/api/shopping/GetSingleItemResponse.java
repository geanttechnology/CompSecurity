// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import android.text.TextUtils;
import com.ebay.nautilus.domain.Duration;
import com.ebay.nautilus.domain.data.EbayItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.Variation;
import com.ebay.nautilus.domain.data.VariationPictureSet;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetSingleItemResponse extends EbayResponse
{
    protected final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("ItemID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Item this$1;

                        public void setValue(long l)
                            throws SAXException
                        {
                            item.id = l;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Site".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.site = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.title = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("TopRatedListing".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.topRatedListing = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.description = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("PrimaryCategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Item this$1;

                        public void setValue(long l)
                            throws SAXException
                        {
                            item.primaryCategoryId = l;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("PrimaryCategoryIDPath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.primaryCategoryIdPath = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("PrimaryCategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.primaryCategoryName = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("SecondaryCategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Item this$1;

                        public void setValue(long l)
                            throws SAXException
                        {
                            item.secondaryCategoryId = l;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("SecondaryCategoryIDPath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.secondaryCategoryIdPath = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("SecondaryCategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.secondaryCategoryName = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ConvertedBuyItNowPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedBuyItNowPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ConvertedCurrentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedCurrentPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("ListingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.listingType = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ProductID".equals(s1))
                {
                    return attributes.getValue("type"). new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;
                        final String val$productIdtype;

                        public void text(String s)
                            throws SAXException
                        {
                            item.productId = s;
                            item.productIdType = productIdtype;
                            if (TextUtils.isEmpty(item.productIdType))
                            {
                                item.productIdType = "Reference";
                            }
                        }

            
            {
                this$1 = final_item1;
                productIdtype = String.this;
                super();
            }
                    };
                }
                if ("ListingStatus".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.listingStatus = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("PromotionalSaleDetails".equals(s1))
                {
                    return new PromotionalSaleDetails();
                }
                if ("PictureURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.pictureUrls.add(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Seller".equals(s1))
                {
                    return new Seller();
                }
                if ("ItemSpecifics".equals(s1))
                {
                    return new ItemSpecifics();
                }
                if ("Variations".equals(s1))
                {
                    return new Variations();
                }
                if ("Title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.title = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Subtitle".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.subTitle = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("TimeLeft".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.timeLeft = Duration.parseXml(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ListingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.listingType = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("EndTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.endDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("StartTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.startDate = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Location".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            if (s != null)
                            {
                                item.location = s.trim();
                            }
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Site".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.site = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("PaymentMethods".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.paymentMethods.add(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("GalleryURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.galleryUrl = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("HandlingTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.handlingTime = Integer.valueOf(i);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Quantity".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.quantity = i;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("QuantitySold".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.quantitySold = i;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("HighBidder".equals(s1))
                {
                    return new HighBidder();
                }
                if ("BidCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.bidCount = i;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("CurrentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.currentPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("BuyItNowPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.buyItNowPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("BuyItNowAvailable".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.buyItNowAvailable = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("Charity".equals(s1))
                {
                    return new Charity();
                }
                if ("ReserveMet".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.reserveMet = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ShipToLocations".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shipToLocations.add(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ExcludeShipToLocation".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.excludeShipToLocations.add(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ShippingCostSummary".equals(s1))
                {
                    return new shippingCostSummary();
                }
                if ("HitCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.hitCount = i;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("AutoPay".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.autoPay = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ViewItemURLForNaturalSearch".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.viewItemUrlForNaturalSearch = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("MinimumToBid".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.minimumToBid = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("EmbeddedMobileCheckoutEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.embeddedMobileCheckoutEnabled = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("PrimaryCategoryIDPath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.primaryCategoryIdPath = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("BusinessSellerDetails".equals(s1))
                {
                    return new BusinessSellerDetails();
                }
                if ("DiscountPriceInfo".equals(s1))
                {
                    return new DiscountPriceInfo();
                }
                if ("Country".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.country = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("BestOfferEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.bestOfferEnabled = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ReturnPolicy".equals(s1))
                {
                    return new ReturnPolicy();
                }
                if ("GlobalShipping".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item this$1;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.globalShipping = flag;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ConditionID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.conditionId = i;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ConditionDisplayName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.conditionDisplayName = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("ConditionDescription".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.conditionDescription = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("UnitInfo".equalsIgnoreCase(s1))
                {
                    return new UnitInfo();
                }
                if ("PickupInStoreDetails".equals(s1))
                {
                    return new PickupInStoreDetails();
                }
                if ("SKU".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.sku = s;
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("AvailableForPickupInStore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.availableForPickupInStore = "true".equals(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("eBayNowEligible".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.availableForEbayNow = "true".equals(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("IgnoreQuantity".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            item.ignoreQuantity = "true".equals(s);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
                if ("LotSize".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item this$1;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.lotSize = Integer.valueOf(i);
                        }

            
            {
                this$1 = Item.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        protected Item()
        {
            this$0 = GetSingleItemResponse.this;
            super();
        }
    }

    private final class Item.BusinessSellerAddress extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("CompanyName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsCompanyName = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("FirstName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsFirstName = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("LastName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsLastName = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("CityName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsCityName = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsName = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Phone".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsPhone = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("PostalCode".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsPostalCode = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("StateOrProvince".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsStateOrProvince = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("CountryName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsCountryName = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Street1".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsStreet1 = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            }
            if ("Street2".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.BusinessSellerAddress this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.bsStreet2 = s;
                    }

            
            {
                this$2 = Item.BusinessSellerAddress.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Item.BusinessSellerAddress()
        {
            this$1 = Item.this;
            super();
        }
    }

    private final class Item.BusinessSellerDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("AdditionalContactInformation".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsAdditionalContactInformation = s;
                        }

            
            {
                this$2 = Item.BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("Address".equals(s1))
                {
                    return new Item.BusinessSellerAddress();
                }
                if ("Email".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsEmail = s;
                        }

            
            {
                this$2 = Item.BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("LegalInvoice".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item.BusinessSellerDetails this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.bsLegalInvoice = flag;
                        }

            
            {
                this$2 = Item.BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("TermsAndConditions".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsTermsAndConditions = s;
                        }

            
            {
                this$2 = Item.BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("TradeRegistrationNumber".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsTradeRegistrationNumber = s;
                        }

            
            {
                this$2 = Item.BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("Fax".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.BusinessSellerDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsFax = s;
                        }

            
            {
                this$2 = Item.BusinessSellerDetails.this;
                super();
            }
                    };
                }
                if ("VATDetails".equals(s1))
                {
                    return new Item.VatDetails();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Item.BusinessSellerDetails()
        {
            this$1 = Item.this;
            super();
            item.bsDetailsExists = true;
        }
    }

    private final class Item.Charity extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CharityID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item.Charity this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.charityId = i;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
                if ("CharityName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityName = s;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
                if ("CharityNumber".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item.Charity this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.charityNumber = i;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
                if ("DonationPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final Item.Charity this$2;

                        public void setValue(float f)
                            throws SAXException
                        {
                            item.charityDonationPercent = f;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
                if ("LogoURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityLogoUrl = s;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
                if ("Mission".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityMission = s;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
                if ("Status".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Charity this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.charityStatus = s;
                        }

            
            {
                this$2 = Item.Charity.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.Charity()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.DiscountPriceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("MinimumAdvertisedPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.dpiMinimumAdvertisedPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("MinimumAdvertisedPriceExposure".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.DiscountPriceInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.dpiMinimumAdvertisedPriceExposure = s;
                        }

            
            {
                this$2 = Item.DiscountPriceInfo.this;
                super();
            }
                    };
                }
                if ("OriginalRetailPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.originalRetailPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("PricingTreatment".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.DiscountPriceInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.pricingTreatment = s;
                        }

            
            {
                this$2 = Item.DiscountPriceInfo.this;
                super();
            }
                    };
                }
                if ("SoldOffeBay".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item.DiscountPriceInfo this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.dpiSoldOffEbay = flag;
                        }

            
            {
                this$2 = Item.DiscountPriceInfo.this;
                super();
            }
                    };
                }
                if ("SoldOneBay".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item.DiscountPriceInfo this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.dpiSoldOnEbay = flag;
                        }

            
            {
                this$2 = Item.DiscountPriceInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.DiscountPriceInfo()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.HighBidder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.HighBidder this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderUserId = s;
                    }

            
            {
                this$2 = Item.HighBidder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Item.HighBidder()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.ItemSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new Item.NameValueList(item.itemSpecifics);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Item.ItemSpecifics()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.NameValueList extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        ArrayList list;
        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                NameValue namevalue = (NameValue)list.get(list.size() - 1);
                if ("Name".equals(s1))
                {
                    return namevalue. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.NameValueList this$2;
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

                        final Item.NameValueList this$2;
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
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Item.NameValueList(ArrayList arraylist)
        {
            this$1 = Item.this;
            super();
            list = arraylist;
            arraylist.add(new NameValue());
        }
    }

    private final class Item.PickupInStoreDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("EligibleForPickupInStore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.PickupInStoreDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.eligibleForPickupInStore = "true".equals(s);
                        }

            
            {
                this$2 = Item.PickupInStoreDetails.this;
                super();
            }
                    };
                }
                if ("AvailableForPickupInStore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.PickupInStoreDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.availableForPickupInStore = "true".equals(s);
                        }

            
            {
                this$2 = Item.PickupInStoreDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.PickupInStoreDetails()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.Pictures extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("VariationSpecificName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Pictures this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.variationPicturesSpecificName = s;
                        }

            
            {
                this$2 = Item.Pictures.this;
                super();
            }
                    };
                }
                if ("VariationSpecificPictureSet".equals(s1))
                {
                    return new Item.VariationSpecificPictureSet();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.Pictures()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.PromotionalSaleDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("OriginalPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.promotionalSaleOriginalPrice = s1;
                    return new CurrencyElement(s1, "currencyID", attributes);
                }
                if ("StartTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.PromotionalSaleDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.promotionalSaleStartTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$2 = Item.PromotionalSaleDetails.this;
                super();
            }
                    };
                }
                if ("EndTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.PromotionalSaleDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.promotionalSaleEndTime = EbayDateUtils.parseXml(s);
                        }

            
            {
                this$2 = Item.PromotionalSaleDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.PromotionalSaleDetails()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.ReturnPolicy extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Description".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpDescription = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("EAN".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpEAN = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("RestockingFeeValue".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpRestockingFee = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("Refund".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpRefund = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("ReturnsAccepted".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpReturnsAccepted = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("ReturnsWithin".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpReturnsWithin = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("ShippingCostPaidBy".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpShippingCostPaidBy = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("WarrantyDuration".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpWarrantyDuration = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("WarrantyOffered".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpWarrantyOffered = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
                if ("WarrantyType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ReturnPolicy this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.rpWarrantyType = s;
                        }

            
            {
                this$2 = Item.ReturnPolicy.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.ReturnPolicy()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.Seller extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UserID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Seller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.sellerUserId = s;
                        }

            
            {
                this$2 = Item.Seller.this;
                super();
            }
                    };
                }
                if ("FeedbackRatingStar".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.Seller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.sellerFeedbackRatingStar = s;
                        }

            
            {
                this$2 = Item.Seller.this;
                super();
            }
                    };
                }
                if ("FeedbackScore".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item.Seller this$2;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.sellerFeedbackScore = i;
                        }

            
            {
                this$2 = Item.Seller.this;
                super();
            }
                    };
                }
                if ("PositiveFeedbackPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.FloatElement() {

                        final Item.Seller this$2;

                        public void setValue(float f)
                            throws SAXException
                        {
                            item.sellerPositiveFeedbackPercent = f;
                        }

            
            {
                this$2 = Item.Seller.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.Seller()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;
        final Variation variation;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "QuantitySold".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final Item.SellingStatus this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        variation.setQuantitySold(i);
                    }

            
            {
                this$2 = Item.SellingStatus.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Item.SellingStatus(Variation variation1)
        {
            this$1 = Item.this;
            super();
            variation = variation1;
        }
    }

    private final class Item.UnitInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UnitType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.UnitInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.unitPriceType = s;
                        }

            
            {
                this$2 = Item.UnitInfo.this;
                super();
            }
                    };
                }
                if ("UnitQuantity".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.UnitInfo this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.unitPriceQuantity = s;
                        }

            
            {
                this$2 = Item.UnitInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.UnitInfo()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.VariationSpecificPictureSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                VariationPictureSet variationpictureset = (VariationPictureSet)item.variationPictureSets.get(item.variationPictureSets.size() - 1);
                if ("VariationSpecificValue".equals(s1))
                {
                    return variationpictureset. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.VariationSpecificPictureSet this$2;
                        final VariationPictureSet val$vps;

                        public void text(String s)
                            throws SAXException
                        {
                            vps.specificName = s;
                        }

            
            {
                this$2 = final_variationspecificpictureset;
                vps = VariationPictureSet.this;
                super();
            }
                    };
                }
                if ("PictureURL".equals(s1))
                {
                    return variationpictureset. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.VariationSpecificPictureSet this$2;
                        final VariationPictureSet val$vps;

                        public void text(String s)
                            throws SAXException
                        {
                            vps.pictureUrls.add(s);
                        }

            
            {
                this$2 = final_variationspecificpictureset;
                vps = VariationPictureSet.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Item.VariationSpecificPictureSet()
        {
            this$1 = Item.this;
            super();
            item.variationPictureSets.add(new VariationPictureSet());
        }
    }

    private final class Item.VariationSpecifics extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;
        final Variation variation;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new Item.NameValueList(variation.getNameValueList());
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public Item.VariationSpecifics(Variation variation1)
        {
            this$1 = Item.this;
            super();
            variation = variation1;
        }
    }

    private final class Item.VariationSpecificsSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "NameValueList".equals(s1))
            {
                return new Item.NameValueList(item.variationSpecifics);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Item.VariationSpecificsSet()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.VariationXml extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                Variation variation = (Variation)item.variations.get(item.variations.size() - 1);
                if ("Quantity".equals(s1))
                {
                    return variation. new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item.VariationXml this$2;
                        final Variation val$variation;

                        public void setValue(int i)
                            throws SAXException
                        {
                            variation.setQuantity(i);
                        }

            
            {
                this$2 = final_variationxml;
                variation = Variation.this;
                super();
            }
                    };
                }
                if ("SellingStatus".equals(s1))
                {
                    return new Item.SellingStatus(variation);
                }
                if ("VariationSpecifics".equals(s1))
                {
                    return new Item.VariationSpecifics(variation);
                }
                if ("SKU".equals(s1))
                {
                    return variation. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.VariationXml this$2;
                        final Variation val$variation;

                        public void text(String s)
                            throws SAXException
                        {
                            variation.setSKU(s);
                        }

            
            {
                this$2 = final_variationxml;
                variation = Variation.this;
                super();
            }
                    };
                }
                if ("".equals(s1))
                {
                    return variation. new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.VariationXml this$2;
                        final Variation val$variation;

                        public void text(String s)
                            throws SAXException
                        {
                            variation.setSKU(s);
                        }

            
            {
                this$2 = final_variationxml;
                variation = Variation.this;
                super();
            }
                    };
                }
                if ("StartPrice".equals(s1))
                {
                    return new CurrencyElement(variation.getStartPrice(), "currencyID", attributes);
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        public Item.VariationXml()
        {
            this$1 = Item.this;
            super();
            item.variations.add(new Variation());
        }
    }

    private final class Item.Variations extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Pictures".equals(s1))
                {
                    return new Item.Pictures();
                }
                if ("Variation".equals(s1))
                {
                    return new Item.VariationXml();
                }
                if ("VariationSpecificsSet".equals(s1))
                {
                    return new Item.VariationSpecificsSet();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.Variations()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.VatDetails extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("VATID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.VatDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsVatId = s;
                        }

            
            {
                this$2 = Item.VatDetails.this;
                super();
            }
                    };
                }
                if ("VATSite".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.VatDetails this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.bsVatSite = s;
                        }

            
            {
                this$2 = Item.VatDetails.this;
                super();
            }
                    };
                }
                if ("VATPercent".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                        final Item.VatDetails this$2;

                        public void setValue(double d)
                            throws SAXException
                        {
                            item.bsVatPercent = d;
                        }

            
            {
                this$2 = Item.VatDetails.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.VatDetails()
        {
            this$1 = Item.this;
            super();
        }

    }

    private final class Item.shippingCostSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Item this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
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
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.shippingCostSummary this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.isLocalPickup = "true".equals(s);
                        }

            
            {
                this$2 = Item.shippingCostSummary.this;
                super();
            }
                    };
                }
                if ("ShippingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.shippingCostSummary this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shippingType = s;
                        }

            
            {
                this$2 = Item.shippingCostSummary.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private Item.shippingCostSummary()
        {
            this$1 = Item.this;
            super();
        }

    }

    protected class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSingleItemResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetSingleItemResponse.this);
                }
                if ("Version".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement this$1;

                        public void text(String s)
                            throws SAXException
                        {
                            if (item != null)
                            {
                                item.version = s;
                            }
                        }

            
            {
                this$1 = RootElement.this;
                super();
            }
                    };
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetSingleItemResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("Item".equals(s1))
                {
                    return new Item();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        protected RootElement()
        {
            this$0 = GetSingleItemResponse.this;
            super();
        }
    }


    public EbayItem item;

    public GetSingleItemResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        item = new EbayItem();
        SaxHandler.parseXml(inputstream, new RootElement());
        postParseProcess();
    }

    protected void postParseProcess()
    {
        if (item != null)
        {
            if (item.timeLeft != null && (0L != item.timeLeft.timeInSeconds || item.endDate == null))
            {
                item.endDate = new Date(EbayResponse.currentHostTime() + item.timeLeft.timeInSeconds * 1000L);
            }
            if (TextUtils.isEmpty(item.title))
            {
                Iterator iterator = item.itemSpecifics.iterator();
                while (iterator.hasNext()) 
                {
                    NameValue namevalue = (NameValue)iterator.next();
                    if ("Title".equals(namevalue.getName()))
                    {
                        item.title = namevalue.getValue();
                        return;
                    }
                    if ("SubTitle".equals(namevalue.getName()))
                    {
                        item.title = namevalue.getValue();
                    }
                }
            }
        }
    }
}
