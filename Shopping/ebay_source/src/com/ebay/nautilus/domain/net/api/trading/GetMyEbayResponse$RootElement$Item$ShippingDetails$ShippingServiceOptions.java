// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.iceOptions
{

    final this._cls1 this$1;

    public com.ebay.nautilus.kernel.util.iceOptions get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ShippingServiceCost".equals(s1))
        {
            s = this._cls1.this.<init>.<init>;
            s1 = new ItemCurrency();
            s.shippingCost = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("LocalPickup".equals(s1))
        {
            _fld1.localPickup = true;
        }
        return super._mth1(s, s1, s2, attributes);
    }

    private ()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
