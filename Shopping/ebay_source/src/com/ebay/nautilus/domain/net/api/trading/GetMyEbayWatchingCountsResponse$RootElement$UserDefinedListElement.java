// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayWatchingCountsResponse

private static final class list extends com.ebay.nautilus.kernel.util.istElement
{

    protected final list list;

    public com.ebay.nautilus.kernel.util.istElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ItemCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayWatchingCountsResponse.RootElement.UserDefinedListElement this$0;

                protected void setValue(int i)
                    throws SAXException
                {
                    list.count = i;
                }

            
            {
                this$0 = GetMyEbayWatchingCountsResponse.RootElement.UserDefinedListElement.this;
                super();
            }
            };
        }
        if ("Name".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayWatchingCountsResponse.RootElement.UserDefinedListElement this$0;

                public void text(String s3)
                    throws SAXException
                {
                    list.name = s3;
                }

            
            {
                this$0 = GetMyEbayWatchingCountsResponse.RootElement.UserDefinedListElement.this;
                super();
            }
            };
        } else
        {
            return super.istElement(s, s1, s2, attributes);
        }
    }

    public _cls2.this._cls0(_cls2.this._cls0 _pcls0)
    {
        list = _pcls0;
    }
}
