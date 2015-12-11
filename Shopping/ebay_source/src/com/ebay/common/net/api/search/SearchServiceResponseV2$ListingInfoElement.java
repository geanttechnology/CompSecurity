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
//            SearchServiceResponseV2

private class item extends com.ebay.nautilus.kernel.util.
{

    final EbaySearchListItem item;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 6: default 64
    //                   -1607243192: 174
    //                   -1373294204: 129
    //                   443857148: 159
    //                   592960478: 189
    //                   606772553: 114
    //                   1887563140: 144;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_189;
_L8:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final SearchServiceResponseV2.ListingInfoElement this$1;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    item.bestOfferEnabled = flag;
                }

            
            {
                this$1 = SearchServiceResponseV2.ListingInfoElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final SearchServiceResponseV2.ListingInfoElement this$1;

                protected void setValue(boolean flag)
                    throws SAXException
                {
                    item.buyItNowAvailable = flag;
                }

            
            {
                this$1 = SearchServiceResponseV2.ListingInfoElement.this;
                super();
            }
            };

        case 2: // '\002'
            s = SearchServiceResponseV2.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.buyItNowPrice = s2;
            return new it>(s, s2);

        case 3: // '\003'
            s = SearchServiceResponseV2.this;
            s1 = item;
            s2 = new ItemCurrency();
            s1.convertedBuyItNowPrice = s2;
            return new it>(s, s2);

        case 4: // '\004'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ListingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.endDate = EbayDateFormat.parseSaasDate(s3);
                }

            
            {
                this$1 = SearchServiceResponseV2.ListingInfoElement.this;
                super();
            }
            };

        case 5: // '\005'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ListingInfoElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    byte byte1;
                    byte1 = 0;
                    item.listingType = 0;
                    s3.hashCode();
                    JVM INSTR lookupswitch 6: default 76
                //                               -2015334886: 129
                //                               -1626286402: 171
                //                               -607502763: 157
                //                               1002796579: 117
                //                               1377925531: 185
                //                               1711994419: 143;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
                    byte1 = -1;
                      goto _L8
_L5:
                    if (!s3.equals("Auction")) goto _L1; else goto _L8
_L2:
                    if (!s3.equals("AdFormat")) goto _L1; else goto _L9
_L9:
                    byte1 = 1;
                      goto _L8
_L7:
                    if (!s3.equals("Classified")) goto _L1; else goto _L10
_L10:
                    byte1 = 2;
                      goto _L8
_L4:
                    if (!s3.equals("FixedPrice")) goto _L1; else goto _L11
_L11:
                    byte1 = 3;
                      goto _L8
_L3:
                    if (!s3.equals("AuctionWithBIN")) goto _L1; else goto _L12
_L12:
                    byte1 = 4;
                      goto _L8
_L6:
                    if (!s3.equals("StoreInventory")) goto _L1; else goto _L13
_L13:
                    byte1 = 5;
_L8:
                    switch (byte1)
                    {
                    default:
                        return;

                    case 0: // '\0'
                        item.listingType = 2;
                        return;

                    case 1: // '\001'
                        item.listingType = 1;
                        return;

                    case 2: // '\002'
                        item.listingType = 4;
                        return;

                    case 3: // '\003'
                        item.listingType = 5;
                        return;

                    case 4: // '\004'
                        item.listingType = 3;
                        return;

                    case 5: // '\005'
                        item.listingType = 6;
                        break;
                    }
                    return;
                }

            
            {
                this$1 = SearchServiceResponseV2.ListingInfoElement.this;
                super();
            }
            };
        }
_L6:
        if (s1.equals("bestOfferEnabled"))
        {
            byte0 = 0;
        }
          goto _L8
_L3:
        if (s1.equals("buyItNowAvailable"))
        {
            byte0 = 1;
        }
          goto _L8
_L7:
        if (s1.equals("buyItNowPrice"))
        {
            byte0 = 2;
        }
          goto _L8
_L4:
        if (s1.equals("buyItNowConvertedPrice"))
        {
            byte0 = 3;
        }
          goto _L8
_L2:
        if (s1.equals("endTime"))
        {
            byte0 = 4;
        }
          goto _L8
        if (s1.equals("listingType"))
        {
            byte0 = 5;
        }
          goto _L8
    }

    public _cls4.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
