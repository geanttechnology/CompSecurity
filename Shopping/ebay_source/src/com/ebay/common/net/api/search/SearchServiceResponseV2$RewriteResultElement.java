// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.data.EbaySearchListItem;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class lt extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.common.net.api.search.wiremodel.ult rewriteResult;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("attribute".equals(s1))
        {
            return new nt(SearchServiceResponseV2.this, rewriteResult.ult);
        }
        if ("descriptor".equals(s1))
        {
            return new ent(SearchServiceResponseV2.this, rewriteResult.ult);
        }
        if ("info".equals(s1))
        {
            rewriteResult.ult = new com.ebay.common.net.api.search.wiremodel.ult();
            return new nit>(SearchServiceResponseV2.this, rewriteResult.ult);
        }
        if ("item".equals(s1))
        {
            if (rewriteResult.ult == null)
            {
                rewriteResult.ult = new ArrayList();
            }
            s = new EbaySearchListItem();
            s.isFromSaaS = true;
            rewriteResult.ult.add(s);
            return new rewriteResult(SearchServiceResponseV2.this, s);
        }
        if ("matchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.RewriteResultElement this$1;

                public void setValue(long l)
                    throws SAXException
                {
                    rewriteResult.matchCount = l;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteResultElement.this;
                super();
            }
            };
        }
        if ("modifiedRequest".equals(s1))
        {
            rewriteResult.ult = new com.ebay.common.net.api.search.wiremodel.ult();
            return new tElement(SearchServiceResponseV2.this, rewriteResult.ult);
        }
        if ("requestDifference".equals(s1))
        {
            rewriteResult.ult = new com.ebay.common.net.api.search.wiremodel.();
            return new ent(SearchServiceResponseV2.this, rewriteResult.ult);
        } else
        {
            return super.rence(s, s1, s2, attributes);
        }
    }


    public _cls1.this._cls1(com.ebay.common.net.api.search.wiremodel. )
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        rewriteResult = ;
        rewriteResult.ult = new lt();
    }
}
