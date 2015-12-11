// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import android.text.TextUtils;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsResponse

class this._cls4 extends com.ebay.nautilus.kernel.util.lue._cls1
{

    final is._cls3 this$4;

    public void text(String s)
        throws SAXException
    {
        if ("PRODUCT_REFERENCE_ID".equals(this._mth4(_fld3)))
        {
            _fld3._fld3 = s;
        } else
        {
            if ("TITLE".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("STOCK_PHOTO_URL".equals(is._mth3(_fld3)))
            {
                _fld3._fld3 = s;
                return;
            }
            if ("ALLCATS".equals(is._mth3(_fld3)))
            {
                if (TextUtils.isEmpty(_fld3._fld3))
                {
                    _fld3._fld3 = s;
                    return;
                } else
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    this._cls4 _lcls4 = _fld3;
                    _lcls4._fld3 = stringbuilder.append(_lcls4._fld3).append(":").append(s).toString();
                    return;
                }
            }
        }
    }

    ()
    {
        this$4 = this._cls4.this;
        super();
    }
}
