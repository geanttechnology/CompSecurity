// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;


// Referenced classes of package com.ebay.mobile.checkout:
//            AddressListActivity

static class peration
{

    static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

    static 
    {
        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[peration.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[peration.SET_SHIPPING_ADDRESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[peration.GET_ADDRESSES.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[peration.REFRESH_ADDRESSES.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
