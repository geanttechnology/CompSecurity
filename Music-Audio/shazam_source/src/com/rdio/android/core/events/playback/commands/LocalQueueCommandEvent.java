// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback.commands;


// Referenced classes of package com.rdio.android.core.events.playback.commands:
//            QueueCommand

public class LocalQueueCommandEvent
{

    private final QueueCommand command;
    private final Class sequencerUnitType;

    public LocalQueueCommandEvent(QueueCommand queuecommand, Class class1)
    {
        command = queuecommand;
        sequencerUnitType = class1;
    }

    public QueueCommand getCommand()
    {
        return command;
    }

    public Class getSequencerUnitType()
    {
        return sequencerUnitType;
    }
}
