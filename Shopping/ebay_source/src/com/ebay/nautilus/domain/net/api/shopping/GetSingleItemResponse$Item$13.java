// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.EbayItem;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

class val.productIdtype extends com.ebay.nautilus.kernel.util.nse.Item._cls13
{

    final val.productIdtype this$1;
    final String val$productIdtype;

    public void text(String s)
        throws SAXException
    {
        item.productId = s;
        item.productIdType = val$productIdtype;
        if (TextUtils.isEmpty(item.productIdType))
        {
            item.productIdType = "Reference";
        }
    }

    ()
    {
        this$1 = final_;
        val$productIdtype = String.this;
        super();
    }
}
