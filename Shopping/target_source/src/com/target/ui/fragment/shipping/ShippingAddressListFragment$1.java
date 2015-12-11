// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping;

import com.target.ui.fragment.shipping.a.g;

// Referenced classes of package com.target.ui.fragment.shipping:
//            ShippingAddressListFragment

static class 
{

    static final int $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[];

    static 
    {
        $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode = new int[g.values().length];
        try
        {
            $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[g.ACCOUNT.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[g.CHECKOUT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
