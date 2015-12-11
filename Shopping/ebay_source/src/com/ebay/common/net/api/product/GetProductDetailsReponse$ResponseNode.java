// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.product;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.product:
//            GetProductDetailsReponse

private final class <init> extends com.ebay.nautilus.kernel.util.e
{

    final GetProductDetailsReponse this$0;

    public com.ebay.nautilus.kernel.util.e get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ack".equals(s1))
        {
            return new AckElement(GetProductDetailsReponse.this);
        }
        if ("timestamp".equals(s1))
        {
            return new TimestampElement(GetProductDetailsReponse.this);
        }
        if ("errorMessage".equals(s1))
        {
            return new essage(GetProductDetailsReponse.this, null);
        }
        if ("product".equals(s1))
        {
            return new >(GetProductDetailsReponse.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private essage()
    {
        this$0 = GetProductDetailsReponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
