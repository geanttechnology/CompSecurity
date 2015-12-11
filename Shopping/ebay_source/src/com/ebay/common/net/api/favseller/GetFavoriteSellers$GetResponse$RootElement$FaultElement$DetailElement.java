// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.favseller;

import com.ebay.nautilus.domain.net.ErrorMessageElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.favseller:
//            GetFavoriteSellers

private final class <init> extends com.ebay.nautilus.kernel.util.ent
{

    final this._cls2 this$2;

    public com.ebay.nautilus.kernel.util.ent get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("errorMessage".equals(s1))
        {
            return new ErrorMessageElement(this._cls2.this.<init>.<init>, "http://www.ebay.com/marketplace/services");
        } else
        {
            return super._mth2(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$2 = this._cls2.this;
        super();
    }

    this._cls2(this._cls2 _pcls2_1)
    {
        this();
    }
}
