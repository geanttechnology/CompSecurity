// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbayDetail;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetEbayDetailsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.e
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        if (s.equals("Chinese"))
        {
            detail.auctionDetails = <init>(this._cls2.this);
        } else
        if (s.equals("FixedPriceItem"))
        {
            detail.fixedPriceDetails = this._mth2(this._cls2.this);
            return;
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
