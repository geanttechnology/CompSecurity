// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsOption;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util..Value
{

    final this._cls3 this$3;

    public com.ebay.nautilus.kernel.util..Value get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("stringValue".equals(s1) || "intValue".equals(s1) || "doubleValue".equals(s1) || "dateValue".equals(s1) || "booleanValue".equals(s1) || "longValue".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.FieldNode.OptionValue.Value this$4;

                public void text(String s3)
                    throws SAXException
                {
                    LdsResponse.RootElement.FieldNode.OptionValue.access$1400(this$3).value = s3;
                }

            
            {
                this$4 = LdsResponse.RootElement.FieldNode.OptionValue.Value.this;
                super();
            }
            };
        } else
        {
            return super.Value(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls4()
    {
        this$3 = this._cls3.this;
        super();
    }

    this._cls3(this._cls3 _pcls3_1)
    {
        this();
    }
}
