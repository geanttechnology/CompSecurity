// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class requestDifference extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.net.api.search.wiremodel.egoryId requestDifference;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("categoryId".equals(s1))
        {
            requestDifference.egoryId = new com.ebay.common.net.api.search.wiremodel.egoryId();
            return new Element(SearchServiceResponseV2.this, requestDifference.egoryId);
        } else
        {
            return super.categoryId(s, s1, s2, attributes);
        }
    }

    public erence(com.ebay.common.net.api.search.wiremodel. )
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        requestDifference = ;
    }
}
