// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.em.Seller._cls4
{

    final this._cls2 this$2;

    public void setValue(float f)
        throws SAXException
    {
        item.sellerPositiveFeedbackPercent = f;
    }

    ()
    {
        this$2 = this._cls2.this;
        super();
    }
}
