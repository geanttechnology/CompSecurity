// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayCountsResponse

class this._cls0 extends com.ebay.nautilus.kernel.util.tElement._cls1
{

    private final com.ebay.nautilus.kernel.util.tElement._cls1.entries entries = new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

        final GetMyEbayCountsResponse.RootElement.ListElement._cls1 this$1;

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
                this$1 = GetMyEbayCountsResponse.RootElement.ListElement._cls1.this;
                super();
            }
    };
    final ta this$0;

    public com.ebay.nautilus.kernel.util.tElement._cls1 get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("TotalNumberOfEntries".equals(s1))
        {
            return entries;
        } else
        {
            return super.entries(s, s1, s2, attributes);
        }
    }

    _cls1.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }
}
