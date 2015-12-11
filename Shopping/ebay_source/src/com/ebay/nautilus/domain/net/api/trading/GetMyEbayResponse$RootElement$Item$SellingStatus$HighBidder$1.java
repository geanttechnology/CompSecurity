// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.MyEbayListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.ghBidder._cls1
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        _fld2.highBidderId = s;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
