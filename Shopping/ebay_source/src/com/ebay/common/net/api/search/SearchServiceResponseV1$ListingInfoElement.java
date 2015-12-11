// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.util.EbayDateFormat;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("bestOfferEnabled".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final SearchServiceResponseV1.ListingInfoElement this$1;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    item.bestOfferEnabled = flag;
                }

            
            {
                this$1 = SearchServiceResponseV1.ListingInfoElement.this;
                super();
            }
            };
        }
        if ("buyItNowAvailable".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final SearchServiceResponseV1.ListingInfoElement this$1;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    item.buyItNowAvailable = flag;
                }

            
            {
                this$1 = SearchServiceResponseV1.ListingInfoElement.this;
                super();
            }
            };
        }
        if ("buyItNowPrice".equals(s1))
        {
            s = SearchServiceResponseV1.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.buyItNowPrice = s2;
            return new it>(s, s2);
        }
        if ("buyItNowConvertedPrice".equals(s1))
        {
            s = SearchServiceResponseV1.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.convertedBuyItNowPrice = s2;
            return new it>(s, s2);
        }
        if ("endTime".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ListingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.endDate = EbayDateFormat.parseSaasDate(s3);
                }

            
            {
                this$1 = SearchServiceResponseV1.ListingInfoElement.this;
                super();
            }
            };
        }
        if ("listingType".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ListingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.listingType = 0;
                    if ("Auction".equals(s3))
                    {
                        item.listingType = 2;
                    } else
                    {
                        if ("AdFormat".equals(s3))
                        {
                            item.listingType = 1;
                            return;
                        }
                        if ("Classified".equals(s3))
                        {
                            item.listingType = 4;
                            return;
                        }
                        if ("FixedPrice".equals(s3))
                        {
                            item.listingType = 5;
                            return;
                        }
                        if ("AuctionWithBIN".equals(s3))
                        {
                            item.listingType = 3;
                            return;
                        }
                        if ("StoreInventory".equals(s3))
                        {
                            item.listingType = 6;
                            return;
                        }
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.ListingInfoElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        item = ebaysearchlistitem;
    }
}
