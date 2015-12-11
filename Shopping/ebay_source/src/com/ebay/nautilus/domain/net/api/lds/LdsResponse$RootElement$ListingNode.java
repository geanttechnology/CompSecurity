// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.lds;

import com.ebay.nautilus.domain.data.ListingDraft;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.lds:
//            LdsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ngNode
{

    final _cls1 this$1;

    public com.ebay.nautilus.kernel.util.ngNode get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("itemId".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final LdsResponse.RootElement.ListingNode this$2;

                public void text(String s3)
                    throws SAXException
                {
                    draft.itemId = s3;
                }

            
            {
                this$2 = LdsResponse.RootElement.ListingNode.this;
                super();
            }
            };
        } else
        {
            return super.ngNode(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
