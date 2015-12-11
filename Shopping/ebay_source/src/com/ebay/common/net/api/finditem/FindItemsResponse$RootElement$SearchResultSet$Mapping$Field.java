// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finditem;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finditem:
//            FindItemsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ld
{

    final this._cls3 this$3;

    public com.ebay.nautilus.kernel.util.ld get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final FindItemsResponse.RootElement.SearchResultSet.Mapping.Field this$4;

                public void text(String s3)
                    throws SAXException
                {
                    FindItemsResponse.RootElement.SearchResultSet.Mapping.access$502(this$3, s3);
                }

            
            {
                this$4 = FindItemsResponse.RootElement.SearchResultSet.Mapping.Field.this;
                super();
            }
            };
        } else
        {
            return super.ld(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls4()
    {
        this$3 = this._cls3.this;
        super();
    }

    this._cls3(this._cls3 _pcls3_1)
    {
        this();
    }
}
