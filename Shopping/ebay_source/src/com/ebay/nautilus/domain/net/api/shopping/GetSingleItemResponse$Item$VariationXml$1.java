// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.Variation;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopping:
//            GetSingleItemResponse

class val.variation extends com.ebay.nautilus.kernel.util.iationXml._cls1
{

    final val.variation this$2;
    final Variation val$variation;

    public void setValue(int i)
        throws SAXException
    {
        val$variation.setQuantity(i);
    }

    Y()
    {
        this$2 = final_y;
        val$variation = Variation.this;
        super();
    }
}
