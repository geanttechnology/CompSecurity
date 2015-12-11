// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.LdsField;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.dValue
{

    final this._cls2 this$2;

    public com.ebay.nautilus.kernel.util.dValue get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

            final LdsResponse.RootElement.FieldNode.SelectedValue this$3;

            public void text(String s3)
                throws SAXException
            {
                LdsResponse.RootElement.FieldNode.access$1200(this$2).addSelectedValue(s3);
            }

            
            {
                this$3 = LdsResponse.RootElement.FieldNode.SelectedValue.this;
                super();
            }
        };
    }

    private _cls1.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
    }

    this._cls2(this._cls2 _pcls2_1)
    {
        this();
    }
}
