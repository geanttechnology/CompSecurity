// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import java.util.List;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetCategoryFeaturesResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.Category._cls2
{

    final this._cls2 this$2;

    public void setValue(boolean flag)
        throws SAXException
    {
        if (flag && cess._mth200(this._cls2.this) > 0L)
        {
            categoriesRequiringConsent.add(Long.valueOf(cess._mth200(this._cls2.this)));
        }
    }

    a()
    {
        this$2 = this._cls2.this;
        super();
    }
}
