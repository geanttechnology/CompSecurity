// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.f.a;

import com.target.mothership.model.common.c;

// Referenced classes of package com.target.mothership.services.apigee.f.a:
//            h

static class 
{

    static final int $SwitchMap$com$target$mothership$model$common$PhoneNumberType[];

    static 
    {
        $SwitchMap$com$target$mothership$model$common$PhoneNumberType = new int[c.values().length];
        try
        {
            $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Home.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Mobile.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Work.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$model$common$PhoneNumberType[c.Other.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
