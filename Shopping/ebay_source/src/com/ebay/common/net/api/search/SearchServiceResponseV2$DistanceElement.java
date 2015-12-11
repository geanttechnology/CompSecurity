// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.Distance;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
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
        JVM INSTR lookupswitch 2: default 32
    //                   3594628: 66
    //                   111972721: 81;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_81;
_L4:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.DistanceElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.distance.unit = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.DistanceElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.DoubleElement() {

                final SearchServiceResponseV2.DistanceElement this$1;

                protected void setValue(double d)
                    throws SAXException
                {
                    item.distance.length = d;
                }

            
            {
                this$1 = SearchServiceResponseV2.DistanceElement.this;
                super();
            }
            };
        }
_L2:
        if (s1.equals("unit"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s1.equals("value"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    public _cls2.this._cls1(EbaySearchListItem ebaysearchlistitem)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        item = ebaysearchlistitem;
        item.distance = new Distance();
    }
}
