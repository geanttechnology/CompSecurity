// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.inventory;

import com.ebay.common.util.EbayDateFormat;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.inventory:
//            GetLocationDetailsResponse

class this._cls0 extends com.ebay.nautilus.kernel.util.t._cls1
{

    final this._cls0 this$0;

    public void text(String s)
        throws SAXException
    {
        cess._mth100(this._cls0.this)._fld0 = EbayDateFormat.parseInventoryDate(s);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }
}
