// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.registry;

import com.target.mothership.common.registries.c;
import com.target.mothership.common.registries.e;

// Referenced classes of package com.target.ui.model.registry:
//            RegistryRefineModel

static class 
{

    static final int $SwitchMap$com$target$mothership$common$registries$RegistryEventType[];
    static final int $SwitchMap$com$target$mothership$common$registries$RegistrySort[];

    static 
    {
        $SwitchMap$com$target$mothership$common$registries$RegistryEventType = new int[c.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.COLLEGE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.WEDDING.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistryEventType[c.BABY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$target$mothership$common$registries$RegistrySort = new int[e.values().length];
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistrySort[e.FIRST_NAME.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistrySort[e.CITY.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$target$mothership$common$registries$RegistrySort[e.EVENT_DATE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
