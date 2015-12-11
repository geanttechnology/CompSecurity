// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.net.api.search.wiremodel.AnswerResponse;
import com.ebay.common.net.api.search.wiremodel.Layout;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class <init> extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("items".equals(s1))
        {
            return new (SearchServiceResponseV2.this, null);
        }
        if ("errorMessage".equals(s1))
        {
            return new Element(SearchServiceResponseV2.this, null);
        }
        if ("answers".equals(s1))
        {
            answers = new AnswerResponse();
            return new nt(SearchServiceResponseV2.this, null);
        }
        if ("layout".equals(s1))
        {
            layout = new Layout();
            return new t(SearchServiceResponseV2.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private t()
    {
        this$0 = SearchServiceResponseV2.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
