// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1, SearchConfiguration

private class item extends com.ebay.nautilus.kernel.util.
{

    private final EbaySearchListItem item;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("itemId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV1.ItemElement this$1;

                protected void setValue(long l)
                    throws SAXException
                {
                    SearchServiceResponseV1.access$700(this$0).add(Long.valueOf(l));
                    item.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV1.ItemElement.this;
                super();
            }
            };
        }
        if ("title".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(item.title))
                    {
                        item.title = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.ItemElement.this;
                super();
            }
            };
        }
        if ("itemImageInfo".equals(s1))
        {
            return new oElement(SearchServiceResponseV1.this, item);
        }
        if ("sellingStatus".equals(s1))
        {
            return new sElement(SearchServiceResponseV1.this, item);
        }
        if ("listingInfo".equals(s1))
        {
            return new lement(SearchServiceResponseV1.this, item);
        }
        if ("shippingInfo".equals(s1))
        {
            return new Element(SearchServiceResponseV1.this, item);
        }
        if ("discountPriceInfo".equals(s1))
        {
            return new eInfoElement(SearchServiceResponseV1.this, item);
        }
        if ("unitPrice".equals(s1))
        {
            return new oElement(SearchServiceResponseV1.this, item);
        }
        if ("eekStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (config.isEEKEnabled)
                    {
                        item.eekRating = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.ItemElement.this;
                super();
            }
            };
        }
        if ("localizedTitle".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.ItemElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (config.isItemTitleTranslationEnabled)
                    {
                        item.title = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.ItemElement.this;
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
