// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.shippinglabel;

import com.ebay.nautilus.domain.data.ShippingOption;
import java.util.Comparator;

// Referenced classes of package com.ebay.mobile.sell.shippinglabel:
//            ShippingLabelActivity

class this._cls0
    implements Comparator
{

    final ShippingLabelActivity this$0;

    public int compare(ShippingOption shippingoption, ShippingOption shippingoption1)
    {
        int i = shippingoption.attributes.serviceDisplayOrder;
        int j = shippingoption1.attributes.serviceDisplayOrder;
        if (i < j)
        {
            return -1;
        }
        return i != j ? 1 : 0;
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((ShippingOption)obj, (ShippingOption)obj1);
    }

    utes()
    {
        this$0 = ShippingLabelActivity.this;
        super();
    }
}
