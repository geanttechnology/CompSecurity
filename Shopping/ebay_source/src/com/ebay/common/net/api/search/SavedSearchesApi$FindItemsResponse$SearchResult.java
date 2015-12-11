// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.IncrementingInt;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

static final class response extends com.ebay.nautilus.kernel.util.
{
    static final class Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final IncrementingInt auctionItemCount;
        private final IncrementingInt fixedPriceItemCount;
        private final EbaySearchListItem item;
        private final ArrayList itemIds;
        public final SavedSearchesApi.EbaySavedSearchResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("itemId".equals(s1))
                {
                    return new ItemId(item, itemIds);
                }
                if ("title".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.title = s;
                        }

            
            {
                this$0 = Item.this;
                super();
            }
                    };
                }
                if ("pictureURLLarge".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.masterImageUrl = s;
                        }

            
            {
                this$0 = Item.this;
                super();
            }
                    };
                }
                if ("pictureURLSuperSize".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.superSizeImageUrl = s;
                        }

            
            {
                this$0 = Item.this;
                super();
            }
                    };
                }
                if ("galleryURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.imageUrl = s;
                        }

            
            {
                this$0 = Item.this;
                super();
            }
                    };
                }
                if ("sellingStatus".equals(s1))
                {
                    return new SellingStatus(item);
                }
                if ("listingInfo".equals(s1))
                {
                    return new ListingInfo(item, auctionItemCount, fixedPriceItemCount);
                }
                if ("shippingInfo".equals(s1))
                {
                    return new ShippingInfo(item);
                }
                if ("discountPriceInfo".equals(s1))
                {
                    return new DiscountPriceInfo(item);
                }
                if ("unitPrice".equals(s1))
                {
                    return new UnitPrice(item);
                }
                if ("primaryCategory".equals(s1) && response.fillCategories != null)
                {
                    return new PrimaryCategory();
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected Item(EbaySearchListItem ebaysearchlistitem, ArrayList arraylist, IncrementingInt incrementingint, IncrementingInt incrementingint1, SavedSearchesApi.EbaySavedSearchResponse ebaysavedsearchresponse)
        {
            item = ebaysearchlistitem;
            itemIds = arraylist;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
            response = ebaysavedsearchresponse;
        }
    }

    static final class Item.DiscountPriceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("originalRetailPrice".equals(s1))
            {
                s = item;
                s1 = new ItemCurrency();
                s.originalRetailPrice = s1;
                return new CurrencyElement(s1, "currencyId", attributes);
            }
            if ("pricingTreatment".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.DiscountPriceInfo this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.pricingTreatment = s;
                    }

            
            {
                this$0 = Item.DiscountPriceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        protected Item.DiscountPriceInfo(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class Item.ItemId extends com.ebay.nautilus.kernel.util.SaxHandler.LongElement
    {

        private final EbaySearchListItem item;
        private final ArrayList itemIds;

        protected void setValue(long l)
            throws SAXException
        {
            item.id = l;
            itemIds.add(Long.valueOf(l));
        }

        public Item.ItemId(EbaySearchListItem ebaysearchlistitem, ArrayList arraylist)
        {
            item = ebaysearchlistitem;
            itemIds = arraylist;
        }
    }

    static final class Item.ListingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final IncrementingInt auctionItemCount;
        private final IncrementingInt fixedPriceItemCount;
        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("bestOfferEnabled".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.bestOfferEnabled = flag;
                        }

            
            {
                this$0 = Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("buyItNowAvailable".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.buyItNowAvailable = flag;
                        }

            
            {
                this$0 = Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("buyItNowPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.buyItNowPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("convertedBuyItNowPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedBuyItNowPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("endTime".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ListingInfo this$0;

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
                this$0 = Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("gift".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.gift = flag;
                        }

            
            {
                this$0 = Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("listingType".equals(s1))
                {
                    return new ListingType(item, auctionItemCount, fixedPriceItemCount);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected Item.ListingInfo(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }

    static final class Item.ListingInfo.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final IncrementingInt auctionItemCount;
        private final IncrementingInt fixedPriceItemCount;
        private final EbaySearchListItem item;

        public void text(String s)
            throws SAXException
        {
            item.listingType = 0;
            s.length();
            JVM INSTR tableswitch 7 14: default 60
        //                       7 61
        //                       8 86
        //                       9 60
        //                       10 104
        //                       11 60
        //                       12 60
        //                       13 60
        //                       14 147;
               goto _L1 _L2 _L3 _L1 _L4 _L1 _L1 _L1 _L5
_L1:
            return;
_L2:
            if (s.equals("Auction"))
            {
                item.listingType = 2;
                auctionItemCount.increment();
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
                fixedPriceItemCount.increment();
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
                auctionItemCount.increment();
                fixedPriceItemCount.increment();
                return;
            }
            if (s.equals("StoreInventory"))
            {
                item.listingType = 6;
                fixedPriceItemCount.increment();
                return;
            }
            if (true) goto _L1; else goto _L6
_L6:
        }

        public Item.ListingInfo.ListingType(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }

    final class Item.PrimaryCategory extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private EbayCategorySummary category;
        private String categoryName;
        final Item this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("categoryId".equals(s1))
            {
                return new CategoryId();
            }
            if ("categoryName".equals(s1))
            {
                return new CategoryName();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        void test()
        {
            if (category != null && categoryName != null)
            {
                category.name = categoryName;
            }
        }


/*
        static EbayCategorySummary access$302(Item.PrimaryCategory primarycategory, EbayCategorySummary ebaycategorysummary)
        {
            primarycategory.category = ebaycategorysummary;
            return ebaycategorysummary;
        }

*/


/*
        static String access$402(Item.PrimaryCategory primarycategory, String s)
        {
            primarycategory.categoryName = s;
            return s;
        }

*/

        Item.PrimaryCategory()
        {
            this$0 = Item.this;
            super();
            category = null;
            categoryName = null;
        }
    }

    final class Item.PrimaryCategory.CategoryId extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            if (response.fillCategories != null)
            {
                category = (EbayCategorySummary)response.fillCategories.remove(s);
                if (response.fillCategories.isEmpty())
                {
                    response.fillCategories = null;
                }
                test();
            }
        }

        Item.PrimaryCategory.CategoryId()
        {
            this$1 = Item.PrimaryCategory.this;
            super();
        }
    }

    final class Item.PrimaryCategory.CategoryName extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            categoryName = s;
            test();
        }

        Item.PrimaryCategory.CategoryName()
        {
            this$1 = Item.PrimaryCategory.this;
            super();
        }
    }

    static final class Item.SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("bidCount".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final Item.SellingStatus this$0;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.bidCount = i;
                        }

            
            {
                this$0 = Item.SellingStatus.this;
                super();
            }
                    };
                }
                if ("convertedCurrentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.convertedCurrentPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("currentPrice".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.currentPrice = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("sellingState".equals(s1))
                {
                    return new State(item);
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected Item.SellingStatus(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class Item.SellingStatus.State extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private final EbaySearchListItem item;

        public void text(String s)
            throws SAXException
        {
            item.sellingState = 0;
            s.length();
            JVM INSTR lookupswitch 5: default 64
        //                       5: 65
        //                       6: 83
        //                       8: 101
        //                       14: 119
        //                       17: 137;
               goto _L1 _L2 _L3 _L4 _L5 _L6
_L1:
            return;
_L2:
            if (s.equals("Ended"))
            {
                item.sellingState = 3;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L3:
            if (s.equals("Active"))
            {
                item.sellingState = 1;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            if (s.equals("Canceled"))
            {
                item.sellingState = 2;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L5:
            if (s.equals("EndedWithSales"))
            {
                item.sellingState = 4;
                return;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            if (s.equals("EndedWithoutSales"))
            {
                item.sellingState = 5;
                return;
            }
            if (true) goto _L1; else goto _L7
_L7:
        }

        public Item.SellingStatus.State(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class Item.ShippingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if (item.shippingCost == null && "shippingServiceCost".equals(s1))
                {
                    s = item;
                    s1 = new ItemCurrency();
                    s.shippingCost = s1;
                    return new CurrencyElement(s1, "currencyId", attributes);
                }
                if ("shippingType".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ShippingInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shippingType = s;
                        }

            
            {
                this$0 = Item.ShippingInfo.this;
                super();
            }
                    };
                }
                if ("shipToLocations".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Item.ShippingInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shipToLocation = s;
                        }

            
            {
                this$0 = Item.ShippingInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected Item.ShippingInfo(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class Item.UnitPrice extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.UnitPrice this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceType = s;
                    }

            
            {
                this$0 = Item.UnitPrice.this;
                super();
            }
                };
            }
            if ("quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Item.UnitPrice this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceQuantity = s;
                    }

            
            {
                this$0 = Item.UnitPrice.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        protected Item.UnitPrice(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }


    public final IncrementingInt auctionItemCount;
    public int count;
    public final IncrementingInt fixedPriceItemCount;
    public final ArrayList itemIds;
    public final ArrayList items;
    public final response response;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if (!"http://www.ebay.com/marketplace/search/v1/services".equals(s) || !"item".equals(s1))
        {
            throw new SAXNotRecognizedException(s1);
        } else
        {
            s = new EbaySearchListItem();
            items.add(s);
            return new Item(s, itemIds, auctionItemCount, fixedPriceItemCount, response);
        }
    }

    public Item.response(Attributes attributes, ArrayList arraylist, IncrementingInt incrementingint, IncrementingInt incrementingint1, Item.response response1)
    {
        count = -1;
        int j = attributes.getLength();
        for (int i = 0; i < j; i++)
        {
            if ("count".equals(attributes.getLocalName(i)))
            {
                count = Integer.parseInt(attributes.getValue(i));
            }
        }

        if (count > 0)
        {
            attributes = new ArrayList(count);
        } else
        {
            attributes = new ArrayList();
        }
        items = attributes;
        itemIds = arraylist;
        auctionItemCount = incrementingint;
        fixedPriceItemCount = incrementingint1;
        response = response1;
    }
}
