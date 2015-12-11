// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayAspectHistogram;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class this._cls0 extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("aspect".equals(s1))
        {
            s = new com.ebay.common.model.search.t();
            SearchServiceResponseV1.access$1600(SearchServiceResponseV1.this).add(s);
            return new <init>(SearchServiceResponseV1.this, s);
        }
        if ("scope".equals(s1))
        {
            return new it>(SearchServiceResponseV1.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public ()
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        if (SearchServiceResponseV1.access$1600(SearchServiceResponseV1.this) == null)
        {
            SearchServiceResponseV1.access$1602(SearchServiceResponseV1.this, new EbayAspectHistogram());
            SearchServiceResponseV1.access$1600(SearchServiceResponseV1.this).domainDisplayName = "";
            SearchServiceResponseV1.access$1600(SearchServiceResponseV1.this).domainName = "";
        }
    }
}
