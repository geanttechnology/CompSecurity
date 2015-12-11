// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetMultipleItemsResponse

protected class this._cls0 extends this._cls0
{

    final GetMultipleItemsResponse this$0;

    public com.ebay.nautilus.kernel.util.RootElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Item".equals(s1))
        {
            item = new EbayItem();
            if (items == null)
            {
                items = new ArrayList();
            }
            items.add(item);
            return new this._cls0(GetMultipleItemsResponse.this);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    protected ()
    {
        this$0 = GetMultipleItemsResponse.this;
        super(GetMultipleItemsResponse.this);
    }
}
