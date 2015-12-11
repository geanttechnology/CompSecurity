// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class pansionResult extends com.ebay.nautilus.kernel.util.
{

    private final this._cls0 expansionResult;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("item".equals(s1))
        {
            s = new EbaySearchListItem();
            s.isFromSaaS = true;
            expansionResult.expansionResult.add(s);
            return new pansionResult(SearchServiceResponseV1.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public (Y y)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        expansionResult = y;
    }
}
