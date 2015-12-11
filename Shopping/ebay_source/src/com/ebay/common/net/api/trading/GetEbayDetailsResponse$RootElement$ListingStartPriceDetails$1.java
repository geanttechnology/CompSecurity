// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

class val.currencyCode extends com.ebay.nautilus.kernel.util._cls1
{

    final val.currencyCode this$2;
    final String val$currencyCode;

    public void text(String s)
        throws SAXException
    {
        cess._mth700(this._cls2.this).Details = new CurrencyAmount(s, val$currencyCode);
    }

    ()
    {
        this$2 = final_;
        val$currencyCode = String.this;
        super();
    }
}
