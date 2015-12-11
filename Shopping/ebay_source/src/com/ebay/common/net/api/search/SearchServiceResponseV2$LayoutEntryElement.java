// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class layoutEntry extends com.ebay.nautilus.kernel.util.
{

    com.ebay.common.net.api.search.wiremodel.y layoutEntry;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("locator".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.LayoutEntryElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    layoutEntry.locator = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.LayoutEntryElement.this;
                super();
            }
            };
        }
        if ("type".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.LayoutEntryElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    layoutEntry.type = com.ebay.common.net.api.search.wiremodel.Layout.LayoutEntryType.valueOf(s3);
                }

            
            {
                this$1 = SearchServiceResponseV2.LayoutEntryElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }

    _cls2.this._cls1(com.ebay.common.net.api.search.wiremodel._cls1_01_ _pcls1_01_)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        layoutEntry = _pcls1_01_;
    }
}
