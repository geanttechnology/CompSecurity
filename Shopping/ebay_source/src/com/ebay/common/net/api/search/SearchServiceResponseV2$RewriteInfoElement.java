// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class rewriteInfo extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.net.api.search.wiremodel.nit> rewriteInfo;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("categoryPath".equals(s1))
        {
            if (rewriteInfo.aths == null)
            {
                rewriteInfo.aths = new ArrayList();
            }
            s = new com.ebay.common.net.api.search.wiremodel.aths();
            rewriteInfo.aths.add(s);
            return new Element(SearchServiceResponseV2.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public (com.ebay.common.net.api.search.wiremodel.Y y)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        rewriteInfo = y;
    }
}
