// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class aspect extends com.ebay.nautilus.kernel.util.
{

    final com.ebay.common.model.search.t aspect;
    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   3373707: 78
    //                   696548518: 108
    //                   1714148973: 93;
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
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.AspectElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    aspect.serviceName = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.AspectElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.AspectElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    if (TextUtils.isEmpty(aspect.name))
                    {
                        aspect.name = s3;
                    }
                }

            
            {
                this$1 = SearchServiceResponseV2.AspectElement.this;
                super();
            }
            };

        case 2: // '\002'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.AspectElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    aspect.name = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.AspectElement.this;
                super();
            }
            };
        }
_L2:
        if (s1.equals("name"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s1.equals("displayName"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s1.equals("localizedName"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public _cls3.this._cls1(com.ebay.common.model.search.t t)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        aspect = t;
    }
}
