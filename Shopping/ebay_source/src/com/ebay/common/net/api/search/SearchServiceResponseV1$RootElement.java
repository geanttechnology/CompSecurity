// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1, SearchExpansion

private class <init> extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("searchRecord".equals(s1))
        {
            if (SearchServiceResponseV1.access$900(SearchServiceResponseV1.this) == null)
            {
                SearchServiceResponseV1.access$902(SearchServiceResponseV1.this, new ArrayList());
            }
            return new Element(SearchServiceResponseV1.this, null);
        }
        if ("dedupedMatchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV1.RootElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    SearchServiceResponseV1.access$2702(this$0, i);
                }

            
            {
                this$1 = SearchServiceResponseV1.RootElement.this;
                super();
            }
            };
        }
        if ("matchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final SearchServiceResponseV1.RootElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    SearchServiceResponseV1.access$2802(this$0, i);
                }

            
            {
                this$1 = SearchServiceResponseV1.RootElement.this;
                super();
            }
            };
        }
        if ("searchRefinement".equals(s1))
        {
            return new mentElement(SearchServiceResponseV1.this, null);
        }
        if ("searchExpansion".equals(s1))
        {
            if (SearchServiceResponseV1.access$1900(SearchServiceResponseV1.this) == null)
            {
                SearchServiceResponseV1.access$1902(SearchServiceResponseV1.this, new ArrayList());
            }
            return new ionElement(SearchServiceResponseV1.this, new SearchExpansion());
        }
        if ("errorMessage".equals(s1))
        {
            return new Element(SearchServiceResponseV1.this, null);
        }
        if ("sellerOfferDetail".equals(s1))
        {
            return new etailElement(SearchServiceResponseV1.this);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = SearchServiceResponseV1.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
