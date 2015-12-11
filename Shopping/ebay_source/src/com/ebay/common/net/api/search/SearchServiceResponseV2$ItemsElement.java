// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.net.api.search.wiremodel.SearchResponse;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class <init> extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 6: default 64
    //                   -1606870765: 159
    //                   -224133017: 174
    //                   100526016: 114
    //                   1160481063: 129
    //                   1393618126: 189
    //                   1839258186: 144;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        break; /* Loop/switch isn't completed */
_L6:
        break MISSING_BLOCK_LABEL_189;
_L8:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            if (searchResponse.items == null)
            {
                searchResponse.items = new ArrayList();
            }
            return new lement(SearchServiceResponseV2.this, null);

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV2.ItemsElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    searchResponse.matchCount = i;
                }

            
            {
                this$1 = SearchServiceResponseV2.ItemsElement.this;
                super();
            }
            };

        case 2: // '\002'
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV2.ItemsElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    searchResponse.matchCountWithDupes = i;
                }

            
            {
                this$1 = SearchServiceResponseV2.ItemsElement.this;
                super();
            }
            };

        case 3: // '\003'
            return new entElement(SearchServiceResponseV2.this, null);

        case 4: // '\004'
            return new nt(SearchServiceResponseV2.this, null);

        case 5: // '\005'
            return new tailElement(SearchServiceResponseV2.this);
        }
_L4:
        if (s1.equals("items"))
        {
            byte0 = 0;
        }
          goto _L8
_L5:
        if (s1.equals("dedupedMatchCount"))
        {
            byte0 = 1;
        }
          goto _L8
_L7:
        if (s1.equals("matchCount"))
        {
            byte0 = 2;
        }
          goto _L8
_L2:
        if (s1.equals("searchRefinement"))
        {
            byte0 = 3;
        }
          goto _L8
_L3:
        if (s1.equals("rewrites"))
        {
            byte0 = 4;
        }
          goto _L8
        if (s1.equals("sellerOfferDetail"))
        {
            byte0 = 5;
        }
          goto _L8
    }

    private _cls2.this._cls1()
    {
        this$0 = SearchServiceResponseV2.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
