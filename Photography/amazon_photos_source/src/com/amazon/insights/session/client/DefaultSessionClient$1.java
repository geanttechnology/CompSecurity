// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.session.client;


// Referenced classes of package com.amazon.insights.session.client:
//            DefaultSessionClient

static class ssionState
{

    static final int $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[];

    static 
    {
        $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState = new int[ssionState.values().length];
        try
        {
            $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[ssionState.INACTIVE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[ssionState.ACTIVE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$amazon$insights$session$client$DefaultSessionClient$SessionState[ssionState.PAUSED.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
