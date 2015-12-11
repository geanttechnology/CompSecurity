// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class aspect extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.common.model.search.t.this._cls0 aspect;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("aspect".equals(s1))
        {
            return new aspect(SearchServiceResponseV1.this, aspect);
        }
        if ("valueHistogram".equals(s1))
        {
            s = new com.ebay.common.model.search.t.aspect();
            aspect.aspect(s);
            return new init>(SearchServiceResponseV1.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public (com.ebay.common.model.search.t t)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        aspect = t;
    }
}
