// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            DateUtils

static class ME_UNIT
{

    static final int $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[];

    static 
    {
        $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT = new int[ME_UNIT.values().length];
        try
        {
            $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[ME_UNIT.SECONDS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[ME_UNIT.MINUTES.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[ME_UNIT.HOURS.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[ME_UNIT.DAYS.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[ME_UNIT.WEEKS.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$utils$DateUtils$TIME_UNIT[ME_UNIT.MONTHS.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
