// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.rtm;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.rtm:
//            RtmHelper

private final class parameter extends com.ebay.nautilus.kernel.util.
{

    private final parameter parameter;
    final parameter this$1;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("key".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.ParameterElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    parameter.key = s3;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.ParameterElement.this;
                super();
            }
            };
        }
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final RtmHelper.parseCampaign.ParameterElement this$2;

                public void text(String s3)
                    throws SAXException
                {
                    parameter.value = s3;
                }

            
            {
                this$2 = RtmHelper.parseCampaign.ParameterElement.this;
                super();
            }
            };
        } else
        {
            return super.(s, s1, s2, attributes);
        }
    }


    public _cls2.this._cls2(_cls2.this._cls2 _pcls2_1)
    {
        this$1 = this._cls1.this;
        super();
        parameter = _pcls2_1;
    }
}
