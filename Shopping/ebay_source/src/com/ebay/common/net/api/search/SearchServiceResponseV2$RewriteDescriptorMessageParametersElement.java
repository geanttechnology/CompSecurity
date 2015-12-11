// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class rewriteDescriptor extends com.ebay.nautilus.kernel.util.
{

    String parameterName;
    String parameterValue;
    private final apply rewriteDescriptor;
    final SearchServiceResponseV2 this$0;

    private void apply()
    {
        if (TextUtils.isEmpty(parameterName) || TextUtils.isEmpty(parameterValue))
        {
            return;
        } else
        {
            rewriteDescriptor.rewriteDescriptor.put(parameterName, parameterValue);
            return;
        }
    }

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        byte byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 2: default 32
    //                   3373707: 66
    //                   111972721: 81;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_81;
_L4:
        switch (byte0)
        {
        default:
            return super.(s, s1, s2, attributes);

        case 0: // '\0'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteDescriptorMessageParametersElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    parameterName = s3;
                    apply();
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorMessageParametersElement.this;
                super();
            }
            };

        case 1: // '\001'
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.RewriteDescriptorMessageParametersElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    parameterValue = s3;
                    apply();
                }

            
            {
                this$1 = SearchServiceResponseV2.RewriteDescriptorMessageParametersElement.this;
                super();
            }
            };
        }
_L2:
        if (s1.equals("name"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s1.equals("value"))
        {
            byte0 = 1;
        }
          goto _L4
    }


    public _cls2.this._cls1(_cls2.this._cls1 _pcls1)
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        rewriteDescriptor = _pcls1;
        if (rewriteDescriptor.rewriteDescriptor == null)
        {
            rewriteDescriptor.rewriteDescriptor = new HashMap();
        }
    }
}
