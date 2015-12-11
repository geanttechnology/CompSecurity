// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayCountsResponse

private static final class <init> extends com.ebay.nautilus.kernel.util.istElement
{

    protected data data;
    private final com.ebay.nautilus.kernel.util.istElement.data pagination;

    public com.ebay.nautilus.kernel.util.istElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("PaginationResult".equals(s1))
        {
            return pagination;
        } else
        {
            return super.pagination(s, s1, s2, attributes);
        }
    }

    public final pagination set(pagination pagination1)
    {
        data = pagination1;
        return this;
    }

    private _cls1.this._cls0()
    {
        data = null;
        pagination = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

            private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new _cls1();
            final GetMyEbayCountsResponse.RootElement.ListElement this$0;

            public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
                throws SAXException
            {
                if ("TotalNumberOfEntries".equals(s1))
                {
                    return entries;
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            }

            
            {
                this$0 = GetMyEbayCountsResponse.RootElement.ListElement.this;
                super();
            }
        };
    }

    _cls1(_cls1 _pcls1)
    {
        this();
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayCountsResponse$RootElement$ListElement$1$1

/* anonymous class */
    class _cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
    {

        final _cls1 this$1;

        public void text(String s)
            throws SAXException
        {
            try
            {
                data.count = Integer.parseInt(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new SAXNotRecognizedException(s.getLocalizedMessage());
            }
        }

            
            {
                this$1 = _cls1.this;
                super();
            }
    }

}
