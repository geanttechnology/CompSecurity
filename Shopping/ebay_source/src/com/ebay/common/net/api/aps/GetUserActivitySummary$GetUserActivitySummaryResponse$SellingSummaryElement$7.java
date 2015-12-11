// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.aps;

import com.ebay.nautilus.domain.data.CurrencyAmount;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.aps:
//            GetUserActivitySummary, UserActivitySummary

class val.currencyCode extends com.ebay.nautilus.kernel.util.l.currencyCode
{

    final val.currencyCode this$1;
    final String val$currencyCode;

    public void text(String s)
        throws SAXException
    {
        val.currencyCode(_fld0).totalSoldValue = new CurrencyAmount(s, val$currencyCode);
    }

    ()
    {
        this$1 = final_;
        val$currencyCode = String.this;
        super();
    }
}
