// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            FindPopularSearchesResponse

private class <init> extends com.ebay.nautilus.kernel.util.
{

    final FindPopularSearchesResponse this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(FindPopularSearchesResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(FindPopularSearchesResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(FindPopularSearchesResponse.this);
            }
            if ("PopularSearchResult".equals(s1))
            {
                return new tSearchElement(FindPopularSearchesResponse.this, null);
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    private tSearchElement()
    {
        this$0 = FindPopularSearchesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
