// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategoryHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.PaginationElement;
import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.IncrementingInt;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.CurrencyElement;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

private static final class response extends com.ebay.nautilus.kernel.util.
{
    static final class AspectHistogram extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final Aspect aspect = new Aspect();
        private final EbayAspectHistogram data;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("aspect".equals(s1))
            {
                return aspect.add(data, attributes);
            }
            if ("domainName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectHistogram this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        data.domainName = s;
                    }

            
            {
                this$0 = AspectHistogram.this;
                super();
            }
                };
            }
            if ("domainDisplayName".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final AspectHistogram this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        data.domainDisplayName = s;
                    }

            
            {
                this$0 = AspectHistogram.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        public AspectHistogram(EbayAspectHistogram ebayaspecthistogram)
        {
            data = ebayaspecthistogram;
        }
    }

    static final class AspectHistogram.Aspect extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.Aspect a;
        private final Value value = new Value();

        AspectHistogram.Aspect add(ArrayList arraylist, Attributes attributes)
        {
            com.ebay.common.model.search.EbayAspectHistogram.Aspect aspect = new com.ebay.common.model.search.EbayAspectHistogram.Aspect();
            a = aspect;
            arraylist.add(aspect);
            a.name = attributes.getValue("name");
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("valueHistogram".equals(s1))
            {
                return value.add(a, attributes);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        AspectHistogram.Aspect()
        {
            a = null;
        }
    }

    static final class AspectHistogram.Aspect.Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private com.ebay.common.model.search.EbayAspectHistogram.AspectValue v;

        AspectHistogram.Aspect.Value add(ArrayList arraylist, Attributes attributes)
        {
            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
            v = aspectvalue;
            arraylist.add(aspectvalue);
            v.value = attributes.getValue("valueName");
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("count".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final AspectHistogram.Aspect.Value this$0;

                    public void setValue(int i)
                        throws SAXException
                    {
                        v.count = i;
                    }

            
            {
                this$0 = AspectHistogram.Aspect.Value.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        AspectHistogram.Aspect.Value()
        {
            v = null;
        }
    }

    static final class CategoryHistogram extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final ParentCategoryElement child = new ParentCategoryElement(null);
        private final EbayCategoryHistogram data;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "categoryHistogram".equals(s1))
            {
                return child.add(data.categories);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public CategoryHistogram(EbayCategoryHistogram ebaycategoryhistogram)
        {
            data = ebaycategoryhistogram;
        }
    }

    private static class CategoryHistogram.CategoryElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        protected com.ebay.common.model.search.EbayCategoryHistogram.Category category;
        private final FieldElement field;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
            {
                if ("categoryId".equals(s1))
                {
                    return field.getId();
                }
                if ("categoryName".equals(s1))
                {
                    return field.getName();
                }
                if ("count".equals(s1))
                {
                    return field.getCount();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private CategoryHistogram.CategoryElement()
        {
            category = null;
            field = new FieldElement(null);
        }

        CategoryHistogram.CategoryElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    private final class CategoryHistogram.CategoryElement.FieldElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        private int field;
        final CategoryHistogram.CategoryElement this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getCount()
        {
            field = 2;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getId()
        {
            field = 0;
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element getName()
        {
            field = 1;
            return this;
        }

        public void text(String s)
            throws SAXException
        {
            switch (field)
            {
            default:
                return;

            case 0: // '\0'
                category.id = Long.parseLong(s);
                return;

            case 1: // '\001'
                category.name = s;
                return;

            case 2: // '\002'
                category.count = Integer.parseInt(s);
                break;
            }
        }

        private CategoryHistogram.CategoryElement.FieldElement()
        {
            this$0 = CategoryHistogram.CategoryElement.this;
            super();
            field = 0;
        }

        CategoryHistogram.CategoryElement.FieldElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class CategoryHistogram.ChildCategoryElement extends CategoryHistogram.CategoryElement
    {

        public final com.ebay.nautilus.kernel.util.SaxHandler.Element add(ArrayList arraylist)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.Category category = new com.ebay.common.model.search.EbayCategoryHistogram.Category();
            this.category = category;
            arraylist.add(category);
            return this;
        }

        private CategoryHistogram.ChildCategoryElement()
        {
            super(null);
        }

        CategoryHistogram.ChildCategoryElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    private static final class CategoryHistogram.ParentCategoryElement extends CategoryHistogram.CategoryElement
    {

        private final CategoryHistogram.ChildCategoryElement child;

        public final com.ebay.nautilus.kernel.util.SaxHandler.Element add(ArrayList arraylist)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
            category = parentcategory;
            arraylist.add(parentcategory);
            return this;
        }

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("http://www.ebay.com/marketplace/search/v1/services".equals(s) && "childCategoryHistogram".equals(s1))
            {
                return child.add(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)category).children);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private CategoryHistogram.ParentCategoryElement()
        {
            super(null);
            child = new CategoryHistogram.ChildCategoryElement(null);
        }

        CategoryHistogram.ParentCategoryElement(SavedSearchesApi._cls1 _pcls1)
        {
            this();
        }
    }

    static final class SearchResult extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public final IncrementingInt auctionItemCount;
        public int count;
        public final IncrementingInt fixedPriceItemCount;
        public final ArrayList itemIds;
        public final ArrayList items;
        public final SavedSearchesApi.EbaySavedSearchResponse response;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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

        public SearchResult(Attributes attributes, ArrayList arraylist, IncrementingInt incrementingint, IncrementingInt incrementingint1, SavedSearchesApi.EbaySavedSearchResponse ebaysavedsearchresponse)
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
            response = ebaysavedsearchresponse;
        }
    }

    static final class SearchResult.Item extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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

                        final SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.title = s;
                        }

            
            {
                this$0 = SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("pictureURLLarge".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.masterImageUrl = s;
                        }

            
            {
                this$0 = SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("pictureURLSuperSize".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.superSizeImageUrl = s;
                        }

            
            {
                this$0 = SearchResult.Item.this;
                super();
            }
                    };
                }
                if ("galleryURL".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SearchResult.Item this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.imageUrl = s;
                        }

            
            {
                this$0 = SearchResult.Item.this;
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


        protected SearchResult.Item(EbaySearchListItem ebaysearchlistitem, ArrayList arraylist, IncrementingInt incrementingint, IncrementingInt incrementingint1, SavedSearchesApi.EbaySavedSearchResponse ebaysavedsearchresponse)
        {
            item = ebaysearchlistitem;
            itemIds = arraylist;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
            response = ebaysavedsearchresponse;
        }
    }

    static final class SearchResult.Item.DiscountPriceInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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

                    final SearchResult.Item.DiscountPriceInfo this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.pricingTreatment = s;
                    }

            
            {
                this$0 = SearchResult.Item.DiscountPriceInfo.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        protected SearchResult.Item.DiscountPriceInfo(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class SearchResult.Item.ItemId extends com.ebay.nautilus.kernel.util.SaxHandler.LongElement
    {

        private final EbaySearchListItem item;
        private final ArrayList itemIds;

        protected void setValue(long l)
            throws SAXException
        {
            item.id = l;
            itemIds.add(Long.valueOf(l));
        }

        public SearchResult.Item.ItemId(EbaySearchListItem ebaysearchlistitem, ArrayList arraylist)
        {
            item = ebaysearchlistitem;
            itemIds = arraylist;
        }
    }

    static final class SearchResult.Item.ListingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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

                        final SearchResult.Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.bestOfferEnabled = flag;
                        }

            
            {
                this$0 = SearchResult.Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("buyItNowAvailable".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final SearchResult.Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.buyItNowAvailable = flag;
                        }

            
            {
                this$0 = SearchResult.Item.ListingInfo.this;
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

                        final SearchResult.Item.ListingInfo this$0;

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
                this$0 = SearchResult.Item.ListingInfo.this;
                super();
            }
                    };
                }
                if ("gift".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final SearchResult.Item.ListingInfo this$0;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            item.gift = flag;
                        }

            
            {
                this$0 = SearchResult.Item.ListingInfo.this;
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


        protected SearchResult.Item.ListingInfo(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }

    static final class SearchResult.Item.ListingInfo.ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
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

        public SearchResult.Item.ListingInfo.ListingType(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }

    final class SearchResult.Item.PrimaryCategory extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private EbayCategorySummary category;
        private String categoryName;
        final SearchResult.Item this$0;

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
        static EbayCategorySummary access$302(SearchResult.Item.PrimaryCategory primarycategory, EbayCategorySummary ebaycategorysummary)
        {
            primarycategory.category = ebaycategorysummary;
            return ebaycategorysummary;
        }

*/


/*
        static String access$402(SearchResult.Item.PrimaryCategory primarycategory, String s)
        {
            primarycategory.categoryName = s;
            return s;
        }

*/

        SearchResult.Item.PrimaryCategory()
        {
            this$0 = SearchResult.Item.this;
            super();
            category = null;
            categoryName = null;
        }
    }

    final class SearchResult.Item.PrimaryCategory.CategoryId extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SearchResult.Item.PrimaryCategory this$1;

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

        SearchResult.Item.PrimaryCategory.CategoryId()
        {
            this$1 = SearchResult.Item.PrimaryCategory.this;
            super();
        }
    }

    final class SearchResult.Item.PrimaryCategory.CategoryName extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final SearchResult.Item.PrimaryCategory this$1;

        public void text(String s)
            throws SAXException
        {
            categoryName = s;
            test();
        }

        SearchResult.Item.PrimaryCategory.CategoryName()
        {
            this$1 = SearchResult.Item.PrimaryCategory.this;
            super();
        }
    }

    static final class SearchResult.Item.SellingStatus extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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

                        final SearchResult.Item.SellingStatus this$0;

                        public void setValue(int i)
                            throws SAXException
                        {
                            item.bidCount = i;
                        }

            
            {
                this$0 = SearchResult.Item.SellingStatus.this;
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


        protected SearchResult.Item.SellingStatus(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class SearchResult.Item.SellingStatus.State extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
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

        public SearchResult.Item.SellingStatus.State(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class SearchResult.Item.ShippingInfo extends com.ebay.nautilus.kernel.util.SaxHandler.Element
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

                        final SearchResult.Item.ShippingInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shippingType = s;
                        }

            
            {
                this$0 = SearchResult.Item.ShippingInfo.this;
                super();
            }
                    };
                }
                if ("shipToLocations".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final SearchResult.Item.ShippingInfo this$0;

                        public void text(String s)
                            throws SAXException
                        {
                            item.shipToLocation = s;
                        }

            
            {
                this$0 = SearchResult.Item.ShippingInfo.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        protected SearchResult.Item.ShippingInfo(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }

    static final class SearchResult.Item.UnitPrice extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySearchListItem item;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("type".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SearchResult.Item.UnitPrice this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceType = s;
                    }

            
            {
                this$0 = SearchResult.Item.UnitPrice.this;
                super();
            }
                };
            }
            if ("quantity".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SearchResult.Item.UnitPrice this$0;

                    public void text(String s)
                        throws SAXException
                    {
                        item.unitPriceQuantity = s;
                    }

            
            {
                this$0 = SearchResult.Item.UnitPrice.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        protected SearchResult.Item.UnitPrice(EbaySearchListItem ebaysearchlistitem)
        {
            item = ebaysearchlistitem;
        }
    }


    public EbayAspectHistogram aspects;
    public final IncrementingInt auctionItemCount = new IncrementingInt();
    public EbayCategoryHistogram categories;
    public final IncrementingInt fixedPriceItemCount = new IncrementingInt();
    public final ArrayList itemIds = new ArrayList();
    public PaginationElement paginationOutput;
    public final ponse response;
    public String savedSearchQuery;
    public SearchResult searchResult;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
        {
            if ("ack".equals(s1))
            {
                return new AckElement(response);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(response);
            }
            if ("error".equals(s1))
            {
                return new >(response, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(response, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("searchResult".equals(s1))
            {
                s = new SearchResult(attributes, itemIds, auctionItemCount, fixedPriceItemCount, response);
                searchResult = s;
                return s;
            }
            if ("paginationOutput".equals(s1))
            {
                s = new PaginationElement();
                paginationOutput = s;
                return s;
            }
            if ("categoryHistogramContainer".equals(s1))
            {
                s = new EbayCategoryHistogram();
                categories = s;
                return new CategoryHistogram(s);
            }
            if ("aspectHistogramContainer".equals(s1))
            {
                s = new EbayAspectHistogram();
                aspects = s;
                return new AspectHistogram(s);
            }
            if ("itemSearchURL".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SavedSearchesApi.FindItemsResponse this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        savedSearchQuery = s3;
                    }

            
            {
                this$0 = SavedSearchesApi.FindItemsResponse.this;
                super();
            }
                };
            }
        }
        return super.(s, s1, s2, attributes);
    }

    public ponse(ponse ponse)
    {
        searchResult = null;
        paginationOutput = null;
        categories = null;
        aspects = null;
        savedSearchQuery = null;
        response = ponse;
    }
}
