// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback;

import com.rdio.android.core.events.playback.commands.QueueCommand;

public class QueueChangedEvent
{

    private final QueueCommand command;

    public QueueChangedEvent(QueueCommand queuecommand)
    {
        command = queuecommand;
    }

    public QueueCommand getCommand()
    {
        return command;
    }
}
