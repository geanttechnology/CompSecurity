// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.ads;

import com.rdio.android.core.events.playback.commands.PlaybackCommand;

public class AdPlayerCommandEvent
{

    private final PlaybackCommand command;

    public AdPlayerCommandEvent(PlaybackCommand playbackcommand)
    {
        command = playbackcommand;
    }

    public PlaybackCommand getCommand()
    {
        return command;
    }
}
