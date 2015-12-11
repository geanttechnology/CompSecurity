// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.net.api.search.wiremodel.Rewrite;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class rewrite extends com.ebay.nautilus.kernel.util.
{

    final Rewrite rewrite;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("result".equals(s1))
        {
            rewrite.rewriteResults = new ArrayList();
            s = new com.ebay.common.net.api.search.wiremodel.();
            rewrite.rewriteResults.add(s);
            return new ement(SearchServiceResponseV2.this, s);
        }
        if ("type".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    rewrite.type = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls1(Rewrite rewrite1)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        rewrite = rewrite1;
    }
}
