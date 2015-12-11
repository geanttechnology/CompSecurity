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

private final class <init> extends com.ebay.nautilus.kernel.util.ingDetails
{

    final this._cls0 this$0;

    public com.ebay.nautilus.kernel.util.ingDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("ConvertedMaxBid".equals(s1))
        {
            s = this._cls0.this.<init>;
            s1 = new ItemCurrency();
            s.convertedMaxBidPrice = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("MaxBid".equals(s1))
        {
            s = _fld0;
            s1 = new ItemCurrency();
            s.maxBidPrice = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        } else
        {
            return super.(s, s1, s2, attributes);
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
