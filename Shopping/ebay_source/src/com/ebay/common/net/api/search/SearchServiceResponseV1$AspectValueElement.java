// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV1

private class aspectValue extends com.ebay.nautilus.kernel.util.
{

    private final com.ebay.common.model.search.t aspectValue;
    final SearchServiceResponseV1 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.AspectValueElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    aspectValue.serviceValue = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.AspectValueElement.this;
                super();
            }
            };
        }
        if ("displayName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.AspectValueElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(aspectValue.value))
                    {
                        aspectValue.value = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV1.AspectValueElement.this;
                super();
            }
            };
        }
        if ("localizedName".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV1.AspectValueElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    aspectValue.value = s3;
                }

            
            {
                this$1 = SearchServiceResponseV1.AspectValueElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls3.this._cls1(com.ebay.common.model.search.t t)
    {
        this$0 = SearchServiceResponseV1.this;
        super();
        aspectValue = t;
    }
}
