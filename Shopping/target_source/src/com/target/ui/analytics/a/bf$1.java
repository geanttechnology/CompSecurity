// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.common.registries.c;

// Referenced classes of package com.target.ui.analytics.a:
//            bf

static class gistries.c
{

    static final int $SwitchMap$com$target$mothership$common$registries$RegistryEventType[];

    static 
    {
        $SwitchMap$com$target$mothership$common$registries$RegistryEventType = new int[c.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.WEDDING.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.COLLEGE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.BABY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.TARGET_LIST.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.UNKNOWN.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
