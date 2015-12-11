// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.common.util.IncrementingInt;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.net.CurrencyElement;
import java.text.ParseException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

static final class fixedPriceItemCount extends com.ebay.nautilus.kernel.util.
{
    static final class ListingType extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
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

        public ListingType(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
        {
            item = ebaysearchlistitem;
            auctionItemCount = incrementingint;
            fixedPriceItemCount = incrementingint1;
        }
    }


    private final IncrementingInt auctionItemCount;
    private final IncrementingInt fixedPriceItemCount;
    private final EbaySearchListItem item;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("http://www.ebay.com/marketplace/search/v1/services".equals(s))
        {
            if ("bestOfferEnabled".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.bestOfferEnabled = flag;
                    }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                };
            }
            if ("buyItNowAvailable".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.buyItNowAvailable = flag;
                    }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo.this;
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

                    final EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                    public void text(String s3)
                        throws SAXException
                    {
                        try
                        {
                            item.endDate = EbayDateFormat.parse(s3);
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s3)
                        {
                            throw new SAXNotRecognizedException(s3.getLocalizedMessage());
                        }
                    }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                };
            }
            if ("gift".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                    final EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo this$0;

                    public void setValue(boolean flag)
                        throws SAXException
                    {
                        item.gift = flag;
                    }

            
            {
                this$0 = EbayFindingApi.FindItemsResponse.SearchResult.Item.ListingInfo.this;
                super();
            }
                };
            }
            if ("listingType".equals(s1))
            {
                return new ListingType(item, auctionItemCount, fixedPriceItemCount);
            }
        }
        return super.fixedPriceItemCount(s, s1, s2, attributes);
    }


    protected _cls4.this._cls0(EbaySearchListItem ebaysearchlistitem, IncrementingInt incrementingint, IncrementingInt incrementingint1)
    {
        item = ebaysearchlistitem;
        auctionItemCount = incrementingint;
        fixedPriceItemCount = incrementingint1;
    }
}
