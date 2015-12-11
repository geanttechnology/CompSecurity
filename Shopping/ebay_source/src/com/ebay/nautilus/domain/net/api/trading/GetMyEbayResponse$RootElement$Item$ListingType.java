// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.istingType
{

    final this._cls0 this$0;

    public void text(String s)
        throws SAXException
    {
        int i = 0;
        if (!s.equals("Chinese") && !s.equals("Dutch")) goto _L2; else goto _L1
_L1:
        i = 2;
_L4:
        this._cls0.this.<init>.listingType = i;
        return;
_L2:
        if (s.equals("AdType"))
        {
            i = 1;
        } else
        if (s.equals("FixedPriceItem"))
        {
            i = 5;
        } else
        if (s.equals("StoresFixedPrice"))
        {
            i = 6;
        } else
        if (s.equals("LeadGeneration"))
        {
            i = 4;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
