// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.common.a.f;
import com.target.mothership.common.tender.a;

// Referenced classes of package com.target.ui.analytics.a:
//            bc

static class nder.a
{

    static final int $SwitchMap$com$target$mothership$common$cart$FulfillmentType[];
    static final int $SwitchMap$com$target$mothership$common$tender$CardType[];

    static 
    {
        $SwitchMap$com$target$mothership$common$cart$FulfillmentType = new int[f.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.ShipToHome.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.StorePickup.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.Special.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.Electronic.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$FulfillmentType[f.NONE_SELECTED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        $SwitchMap$com$target$mothership$common$tender$CardType = new int[a.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$tender$CardType[a.TARGET_GIFT_CARD.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
