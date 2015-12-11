// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SavedSearchesApi

static final class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("type".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SavedSearchesApi.FindItemsResponse.SearchResult.Item.UnitPrice this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.unitPriceType = s3;
                }

            
            {
                this$0 = SavedSearchesApi.FindItemsResponse.SearchResult.Item.UnitPrice.this;
                super();
            }
            };
        }
        if ("quantity".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SavedSearchesApi.FindItemsResponse.SearchResult.Item.UnitPrice this$0;

                public void text(String s3)
                    throws SAXException
                {
                    item.unitPriceQuantity = s3;
                }

            
            {
                this$0 = SavedSearchesApi.FindItemsResponse.SearchResult.Item.UnitPrice.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    protected _cls2.this._cls0(EbaySearchListItem ebaysearchlistitem)
    {
        item = ebaysearchlistitem;
    }
}
