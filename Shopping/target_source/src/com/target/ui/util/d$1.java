// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import com.target.mothership.common.a.b;

// Referenced classes of package com.target.ui.util:
//            d

static class ror
{

    static final int $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[];

    static 
    {
        $SwitchMap$com$target$mothership$common$cart$DeliveryMethod = new int[b.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Standard.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror12) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Email.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror11) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Mobile.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror10) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.None.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror9) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Premium.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Express.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Rush.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.Seasonal.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.ToTheDoor.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.InsideTheDoor.ordinal()] = 10;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.RoomOfChoice.ordinal()] = 11;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.WhiteGlove.ordinal()] = 12;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$cart$DeliveryMethod[b.WhiteGloveAssembly.ordinal()] = 13;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
