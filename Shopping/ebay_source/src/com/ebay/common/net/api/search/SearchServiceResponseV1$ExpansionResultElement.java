// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class expansionResult extends com.ebay.nautilus.kernel.util.
{

    private final expansionResult expansionResult;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("attribute".equals(s1))
        {
            return new nt(SearchServiceResponseV1.this, expansionResult);
        }
        if ("searchRecord".equals(s1))
        {
            return new ement(SearchServiceResponseV1.this, expansionResult);
        } else
        {
            return super.expansionResult(s, s1, s2, attributes);
        }
    }

    public ement(ement ement)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        expansionResult = ement;
    }
}
