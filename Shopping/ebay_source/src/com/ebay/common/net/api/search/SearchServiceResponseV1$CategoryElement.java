// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class category extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.common.model.search.t category;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("id".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV1.CategoryElement this$1;

                protected void setValue(long l)
                    throws SAXException
                {
                    category.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV1.CategoryElement.this;
                super();
            }
            };
        }
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.CategoryElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(category.name))
                    {
                        category.name = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.CategoryElement.this;
                super();
            }
            };
        }
        if ("localizedName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.CategoryElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    category.name = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.CategoryElement.this;
                super();
            }
            };
        }
        if ("parentCategory".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

                final SearchServiceResponseV1.CategoryElement this$1;

                public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s3, String s4, String s5, Attributes attributes1)
                    throws SAXException
                {
                    if ("id".equals(s4))
                    {
                        return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                            final _cls4 this$2;

                            protected void setValue(long l)
                                throws SAXException
                            {
                                category.parentId = l;
                            }

            
            {
                this$2 = _cls4.this;
                super();
            }
                        };
                    } else
                    {
                        return super.get(s3, s4, s5, attributes1);
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.CategoryElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls4.this._cls1(com.ebay.common.model.search.t t)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        category = t;
    }
}
