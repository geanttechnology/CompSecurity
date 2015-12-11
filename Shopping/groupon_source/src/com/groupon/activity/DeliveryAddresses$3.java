// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.LocationsContainer;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class this._cls0
    implements Function1
{

    final DeliveryAddresses this$0;

    public void execute(LocationsContainer locationscontainer)
    {
        DeliveryAddresses.access$000(DeliveryAddresses.this, locationscontainer.getLocations());
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((LocationsContainer)obj);
    }

    ()
    {
        this$0 = DeliveryAddresses.this;
        super();
    }
}
