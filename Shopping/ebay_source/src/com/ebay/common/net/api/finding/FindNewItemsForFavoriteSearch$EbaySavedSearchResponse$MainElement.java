// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finding:
//            FindNewItemsForFavoriteSearch

private final class <init> extends com.ebay.nautilus.kernel.util.t
{

    final _cls1 this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("totalEntries".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.MainElement this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    count = i;
                }

            
            {
                this$1 = FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.MainElement.this;
                super();
            }
            };
        } else
        {
            return super.t(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
