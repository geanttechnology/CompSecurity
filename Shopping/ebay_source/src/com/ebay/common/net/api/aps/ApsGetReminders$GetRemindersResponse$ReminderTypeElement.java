// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            ApsGetReminders

private final class <init> extends com.ebay.nautilus.kernel.util.nit>
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.nit> get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("item".equals(s1))
        {
            s = new MyEbayListItem();
            s.transaction = new com.ebay.nautilus.domain.data.nit>();
            <init>(this._cls0.this).add(s);
            return new this._cls0(this._cls0.this, s);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    private ()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
