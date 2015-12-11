// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayWatchingCountsResponse

private static final class data extends com.ebay.nautilus.kernel.util.istElement
{

    protected final pagination data;
    private final com.ebay.nautilus.kernel.util.efinedList pagination = new com.ebay.nautilus.kernel.util.SaxHandler.Element() {

        private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new _cls1();
        final GetMyEbayWatchingCountsResponse.RootElement.ListElement this$0;

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
                this$0 = GetMyEbayWatchingCountsResponse.RootElement.ListElement.this;
                super();
            }
    };

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

    public _cls1.this._cls0(_cls1.this._cls0 _pcls0)
    {
        data = _pcls0;
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayWatchingCountsResponse$RootElement$ListElement$1$1

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
