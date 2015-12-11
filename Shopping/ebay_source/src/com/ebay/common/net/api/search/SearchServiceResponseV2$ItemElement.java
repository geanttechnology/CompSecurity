// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.common.net.api.search.wiremodel.SearchResponse;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2, SearchConfiguration

private class item extends com.ebay.nautilus.kernel.util.
{

    final EbaySearchListItem item;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 13: default 120
    //                   -1178662002: 198
    //                   -486196699: 304
    //                   -398774404: 273
    //                   -397503281: 336
    //                   110371416: 213
    //                   123954077: 384
    //                   288459765: 368
    //                   592621906: 258
    //                   725876637: 320
    //                   1355399510: 288
    //                   1369632792: 352
    //                   1423034070: 228
    //                   1561374562: 243;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14
_L1:
        break; /* Loop/switch isn't completed */
_L7:
        break MISSING_BLOCK_LABEL_384;
_L15:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.ItemElement this$1;

                protected void setValue(long l)
                    throws SAXException
                {
                    searchResponse.itemIds.add(Long.valueOf(l));
                    item.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV2.ItemElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(item.title))
                    {
                        item.title = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.ItemElement.this;
                super();
            }
            };

        case 2: // '\002'
            return new oElement(SearchServiceResponseV2.this, item);

        case 3: // '\003'
            return new sElement(SearchServiceResponseV2.this, item);

        case 4: // '\004'
            return new lement(SearchServiceResponseV2.this, item);

        case 5: // '\005'
            return new Element(SearchServiceResponseV2.this, item);

        case 6: // '\006'
            return new eInfoElement(SearchServiceResponseV2.this, item);

        case 7: // '\007'
            return new oElement(SearchServiceResponseV2.this, item);

        case 8: // '\b'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (config.isEEKEnabled)
                    {
                        item.eekRating = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.ItemElement.this;
                super();
            }
            };

        case 9: // '\t'
            return new ent(SearchServiceResponseV2.this, item);

        case 10: // '\n'
            return new onListingInfo(SearchServiceResponseV2.this, item);

        case 11: // '\013'
            return new ent(SearchServiceResponseV2.this, item);

        case 12: // '\f'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (config.isItemTitleTranslationEnabled)
                    {
                        item.title = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.ItemElement.this;
                super();
            }
            };
        }
_L2:
        if (s1.equals("itemId"))
        {
            byte0 = 0;
        }
          goto _L15
_L6:
        if (s1.equals("title"))
        {
            byte0 = 1;
        }
          goto _L15
_L13:
        if (s1.equals("itemImageInfo"))
        {
            byte0 = 2;
        }
          goto _L15
_L14:
        if (s1.equals("sellingStatus"))
        {
            byte0 = 3;
        }
          goto _L15
_L9:
        if (s1.equals("listingInfo"))
        {
            byte0 = 4;
        }
          goto _L15
_L4:
        if (s1.equals("shippingInfo"))
        {
            byte0 = 5;
        }
          goto _L15
_L11:
        if (s1.equals("discountPriceInfo"))
        {
            byte0 = 6;
        }
          goto _L15
_L3:
        if (s1.equals("unitPrice"))
        {
            byte0 = 7;
        }
          goto _L15
_L10:
        if (s1.equals("eekStatus"))
        {
            byte0 = 8;
        }
          goto _L15
_L5:
        if (s1.equals("ebayPlus"))
        {
            byte0 = 9;
        }
          goto _L15
_L12:
        if (s1.equals("multiVariationListingInfo"))
        {
            byte0 = 10;
        }
          goto _L15
_L8:
        if (s1.equals("distance"))
        {
            byte0 = 11;
        }
          goto _L15
        if (s1.equals("localizedTitle"))
        {
            byte0 = 12;
        }
          goto _L15
    }

    public _cls4.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
    }
}
