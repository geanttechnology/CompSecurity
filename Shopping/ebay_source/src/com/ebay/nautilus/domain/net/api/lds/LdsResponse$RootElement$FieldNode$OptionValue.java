// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.domain.data.LdsOption;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class option extends com.ebay.nautilus.kernel.util.nValue
{
    private final class Value extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final LdsResponse.RootElement.FieldNode.OptionValue this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("stringValue".equals(s1) || "intValue".equals(s1) || "doubleValue".equals(s1) || "dateValue".equals(s1) || "booleanValue".equals(s1) || "longValue".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Value this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        option.value = s;
                    }

            
            {
                this$4 = Value.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Value()
        {
            this$3 = LdsResponse.RootElement.FieldNode.OptionValue.this;
            super();
        }

        Value(LdsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    private final LdsOption option = new LdsOption();
    final Value this$2;

    public com.ebay.nautilus.kernel.util.nValue get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("caption".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.FieldNode.OptionValue this$3;

                public void text(String s3)
                    throws SAXException
                {
                    option.caption = s3;
                }

            
            {
                this$3 = LdsResponse.RootElement.FieldNode.OptionValue.this;
                super();
            }
            };
        }
        if ("value".equals(s1))
        {
            return new Value(null);
        } else
        {
            return super.nValue(s, s1, s2, attributes);
        }
    }


    public _cls1.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
        this._mth2(this._cls2.this).options.add(option);
    }
}
