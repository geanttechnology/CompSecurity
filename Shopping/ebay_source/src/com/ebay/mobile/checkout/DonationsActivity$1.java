// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout;


// Referenced classes of package com.ebay.mobile.checkout:
//            DonationsActivity

static class .Operation
{

    static final int $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[];

    static 
    {
        $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation = new int[.Operation.values().length];
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[.Operation.REMOVE_DONATION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$ebay$mobile$checkout$BaseCheckoutActivity$Operation[.Operation.ADD_DONATION.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
