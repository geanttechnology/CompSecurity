// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.productsV3.a;

import com.target.mothership.common.product.o;

// Referenced classes of package com.target.mothership.services.apigee.productsV3.a:
//            a

static class 
{

    static final int $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[];

    static 
    {
        $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType = new int[o.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[o.PICKUP_IN_STORE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[o.SHIP_TO_STORE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$product$ProductAvailabilityType[o.ANY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
