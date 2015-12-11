// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.model.EbayProduct;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shopping:
//            FindProductsResponse

class this._cls2 extends com.ebay.nautilus.kernel.util.._cls3
{

    final this._cls2 this$2;

    public void text(String s)
        throws SAXException
    {
        cess._mth300(this._cls2.this).stockPhotoUrl = s;
    }

    Q()
    {
        this$2 = this._cls2.this;
        super();
    }
}
