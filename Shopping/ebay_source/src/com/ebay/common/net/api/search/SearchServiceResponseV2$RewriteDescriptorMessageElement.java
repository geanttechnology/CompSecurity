// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class rewriteDescriptor extends com.ebay.nautilus.kernel.util.
{

    final rewriteDescriptor rewriteDescriptor;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   3355: 78
    //                   458736106: 108
    //                   653058492: 93;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_108;
_L5:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                final SearchServiceResponseV2.RewriteDescriptorMessageElement this$1;

                public void setValue(long l)
                    throws SAXException
                {
                    rewriteDescriptor.id = l;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorMessageElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteDescriptorMessageElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    rewriteDescriptor.userMessage = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorMessageElement.this;
                super();
            }
            };

        case 2: // '\002'
            return new rsElement(SearchServiceResponseV2.this, rewriteDescriptor);
        }
_L2:
        if (s1.equals("id"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s1.equals("userMessage"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s1.equals("parameters"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public _cls2.this._cls1(_cls2.this._cls1 _pcls1)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        rewriteDescriptor = _pcls1;
    }
}
