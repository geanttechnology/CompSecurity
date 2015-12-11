// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class modifiedRequest extends com.ebay.nautilus.kernel.util.
{

    com.ebay.common.net.api.search.wiremodel.quest modifiedRequest;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("categoryId".equals(s1))
        {
            modifiedRequest.quest = new ArrayList();
            return new Ids(SearchServiceResponseV2.this, modifiedRequest.quest);
        }
        break MISSING_BLOCK_LABEL_42;
        if (!"constraints".equals(s1) && !"excludeCategoryId".equals(s1) && !"feature".equals(s1))
        {
            if ("keyword".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SearchServiceResponseV2.RewriteModifiedRequestElement this$1;

                    public void text(String s3)
                        throws SAXException
                    {
                        modifiedRequest.keyword = s3;
                    }

            
            {
                this$1 = SearchServiceResponseV2.RewriteModifiedRequestElement.this;
                super();
            }
                };
            }
            if ("outputSelector".equals(s1) || "paginationInput".equals(s1) || "requestConfig".equals(s1) || "scope".equals(s1) || "sellerName".equals(s1) || "shipToLocation".equals(s1) || "sortOrder".equals(s1) || !"userContext".equals(s1));
        }
        return super.(s, s1, s2, attributes);
    }

    _cls1.this._cls1(com.ebay.common.net.api.search.wiremodel. )
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        modifiedRequest = ;
    }
}
