// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback.commands;


// Referenced classes of package com.rdio.android.core.events.playback.commands:
//            QueueCommand

static class eration
{

    static final int $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[];

    static 
    {
        $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation = new int[eration.values().length];
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[eration.Add.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[eration.Remove.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[eration.Move.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
