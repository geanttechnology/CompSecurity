// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.sample.castcompanionlibrary.cast;


// Referenced classes of package com.google.sample.castcompanionlibrary.cast:
//            BaseCastManager

static class connectionStatus
{

    static final int $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[];

    static 
    {
        $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus = new int[connectionStatus.values().length];
        try
        {
            $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[connectionStatus.STARTED.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[connectionStatus.IN_PROGRESS.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$google$sample$castcompanionlibrary$cast$BaseCastManager$ReconnectionStatus[connectionStatus.FINALIZE.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
