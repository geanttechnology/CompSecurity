// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.deals;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.deals:
//            EbayDealsApi

static final class itemElement extends com.ebay.nautilus.kernel.util.Element
{

    com.ebay.nautilus.kernel.util. imageUrlElement;
    com.ebay.common.model.ent.item item;
    private final item itemElement;
    com.ebay.nautilus.kernel.util. titleElement;

    itemElement get(List list)
    {
        item = new com.ebay.common.model.ent.item();
        item.item = -1L;
        list.add(item);
        return this;
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Title".equals(s1))
        {
            return titleElement;
        }
        if ("StaticImage140x140".equals(s1))
        {
            return imageUrlElement;
        }
        if ("Item".equals(s1))
        {
            if (item.item == null)
            {
                item.item = new ArrayList();
            }
            return itemElement.itemElement(item.item, attributes);
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public _cls2.this._cls0(_cls2.this._cls0 _pcls0)
    {
        item = null;
        titleElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

            final EbayDealsApi.DealsResponse.MultiSkuElement this$0;

            public void text(String s)
                throws SAXException
            {
                item.title = s;
            }

            
            {
                this$0 = EbayDealsApi.DealsResponse.MultiSkuElement.this;
                super();
            }
        };
        imageUrlElement = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

            final EbayDealsApi.DealsResponse.MultiSkuElement this$0;

            public void text(String s)
                throws SAXException
            {
                item.imageUrl = s;
            }

            
            {
                this$0 = EbayDealsApi.DealsResponse.MultiSkuElement.this;
                super();
            }
        };
        itemElement = _pcls0;
    }
}
