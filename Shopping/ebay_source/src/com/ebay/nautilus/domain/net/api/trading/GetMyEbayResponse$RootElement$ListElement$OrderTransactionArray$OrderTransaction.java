// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ransaction
{

    final > this$0;

    public com.ebay.nautilus.kernel.util.ransaction get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Order".equals(s1))
        {
            return new <init>(this._cls0.this);
        }
        if ("Transaction".equals(s1))
        {
            s = new MyEbayListItem();
            _fld0.add(s);
            return new >(s, null);
        } else
        {
            return super.ction(s, s1, s2, attributes);
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
