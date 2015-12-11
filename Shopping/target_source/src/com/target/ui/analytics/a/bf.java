// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.common.registries.c;
import java.util.Collections;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s

public class bf extends f
{

    private static final long LOAD_TIME_INSTANTANEOUS = 0L;
    private c mRegistryEventType;

    public bf(c c1)
    {
        mRegistryEventType = c1;
    }

    protected Map b()
    {
        Map map = super.b();
        static class _cls1
        {

            static final int $SwitchMap$com$target$mothership$common$registries$RegistryEventType[];

            static 
            {
                $SwitchMap$com$target$mothership$common$registries$RegistryEventType = new int[com.target.mothership.common.registries.c.values().length];
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

        switch (_cls1..SwitchMap.com.target.mothership.common.registries.RegistryEventType[mRegistryEventType.ordinal()])
        {
        default:
            return map;

        case 1: // '\001'
            map.put("productFindingMethod", "wedding registry");
            return map;

        case 3: // '\003'
            map.put("productFindingMethod", "baby registry");
            return map;

        case 2: // '\002'
            map.put("productFindingMethod", "college registry");
            return map;
        }
    }

    protected s c()
    {
        switch (_cls1..SwitchMap.com.target.mothership.common.registries.RegistryEventType[mRegistryEventType.ordinal()])
        {
        default:
            return s.Unknown;

        case 1: // '\001'
            return s.RegistryListWedding;

        case 2: // '\002'
            return s.RegistryListCollege;

        case 3: // '\003'
            return s.RegistryListBaby;

        case 4: // '\004'
            return s.RegistryListTargetList;
        }
    }

    protected List d()
    {
        return Collections.emptyList();
    }

    protected Long i()
    {
        return Long.valueOf(0L);
    }
}
