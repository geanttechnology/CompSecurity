// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.model.search.EbayCategorySummary;
import java.util.Map;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            EbayFindingApi

final class this._cls1 extends com.ebay.nautilus.kernel.util.
{

    final this._cls1 this$1;

    public void text(String s)
        throws SAXException
    {
        if (_fld1._fld1 != null)
        {
            this._mth1(this._cls1.this, (EbayCategorySummary)_fld1._fld1.remove(s));
            if (_fld1._fld1.isEmpty())
            {
                _fld1._fld1 = null;
            }
            _mth1();
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
