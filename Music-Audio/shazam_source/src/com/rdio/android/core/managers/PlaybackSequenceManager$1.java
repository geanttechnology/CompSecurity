// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.rdio.android.core.events.playback.commands.PlaybackCommand;

// Referenced classes of package com.rdio.android.core.managers:
//            PlaybackSequenceManager

static class nd.Operation
{

    static final int $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand[];
    static final int $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[];

    static 
    {
        $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand = new int[PlaybackCommand.values().length];
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand[PlaybackCommand.SkipNext.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$PlaybackCommand[PlaybackCommand.SkipPrev.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation = new int[com.rdio.android.core.events.playback.commands.ues().length];
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[com.rdio.android.core.events.playback.commands..inal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[com.rdio.android.core.events.playback.commands.ove.inal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$rdio$android$core$events$playback$commands$QueueCommand$Operation[com.rdio.android.core.events.playback.commands.e.inal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
