// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class category extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.net.api.search.wiremodel.y category;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("id".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.RewriteCategoryPathElement this$1;

                protected void setValue(long l)
                    throws SAXException
                {
                    category.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteCategoryPathElement.this;
                super();
            }
            };
        }
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteCategoryPathElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    category.name = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteCategoryPathElement.this;
                super();
            }
            };
        }
        if ("localizedName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteCategoryPathElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    category.localizedName = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteCategoryPathElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    public _cls3.this._cls1(com.ebay.common.net.api.search.wiremodel.y y)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        category = y;
    }
}
