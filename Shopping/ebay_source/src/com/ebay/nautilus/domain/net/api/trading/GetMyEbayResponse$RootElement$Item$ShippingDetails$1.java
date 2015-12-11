// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

class this._cls1 extends com.ebay.nautilus.kernel.util.gDetails._cls1
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        if (s.equals("Freight"))
        {
            _fld1.shippingType = "Freight";
            return;
        }
        if (s.equals("NotSpecified"))
        {
            _fld1.shippingType = "NotSpecified";
            return;
        }
        if (s.equals("Calculated"))
        {
            _fld1.shippingType = "Calculated";
            return;
        }
        if (s.equals("Flat") && _fld1.shippingCost != null && _fld1.shippingCost.value != null && (_fld1.shippingCost.value.equals("0.00") || _fld1.shippingCost.value.equals("0.0") || _fld1.shippingCost.value.equals("0")))
        {
            _fld1.shippingType = "Free";
            return;
        } else
        {
            _fld1.shippingType = null;
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
