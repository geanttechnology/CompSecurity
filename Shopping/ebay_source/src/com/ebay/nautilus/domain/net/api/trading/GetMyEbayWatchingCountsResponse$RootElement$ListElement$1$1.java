// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayWatchingCountsResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.lement._cls1._cls1
{

    final t this$1;

    public void text(String s)
        throws SAXException
    {
        try
        {
            .t = Integer.parseInt(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/ebay/nautilus/domain/net/api/trading/GetMyEbayWatchingCountsResponse$RootElement$ListElement$1

/* anonymous class */
    class GetMyEbayWatchingCountsResponse.RootElement.ListElement._cls1 extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final com.ebay.nautilus.kernel.util.SaxHandler.TextElement entries = new GetMyEbayWatchingCountsResponse.RootElement.ListElement._cls1._cls1();
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
    }

}
