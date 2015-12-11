// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.shipping.AddressEu;
import com.groupon.models.shipping.Location;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            ShippingAddressEu

class this._cls0
    implements Function1
{

    final ShippingAddressEu this$0;

    public void execute(AddressEu addresseu)
    {
        setResultAndFinish(-1, addresseu.location.id);
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((AddressEu)obj);
    }

    ()
    {
        this$0 = ShippingAddressEu.this;
        super();
    }
}
