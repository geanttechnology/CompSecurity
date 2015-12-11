// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.triggers;


// Referenced classes of package com.poshmark.triggers:
//            RateAppTrigger

static class State
{

    static final int $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[];

    static 
    {
        $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState = new int[State.values().length];
        try
        {
            $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[State.INITIAL.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[State.IGNORED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[State.INTERACTED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$poshmark$triggers$PMTrigger$TriggerState[State.DISMISSED.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
