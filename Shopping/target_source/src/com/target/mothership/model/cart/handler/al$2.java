// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart.handler;

import com.target.mothership.common.a.b;

// Referenced classes of package com.target.mothership.model.cart.handler:
//            al

static class 
{

    static final int $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[];

    static 
    {
        $SwitchMap$com$target$mothership$common$cart$DeliveryMethod = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Email.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Mobile.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Standard.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
