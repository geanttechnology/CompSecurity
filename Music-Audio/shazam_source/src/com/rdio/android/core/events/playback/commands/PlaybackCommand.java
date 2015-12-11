// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.events.playback.commands;


public final class PlaybackCommand extends Enum
{

    private static final PlaybackCommand $VALUES[];
    public static final PlaybackCommand Pause;
    public static final PlaybackCommand Play;
    public static final PlaybackCommand Seek;
    public static final PlaybackCommand SkipNext;
    public static final PlaybackCommand SkipPrev;
    public static final PlaybackCommand Stop;
    public static final PlaybackCommand TogglePlay;

    private PlaybackCommand(String s, int i)
    {
        super(s, i);
    }

    public static PlaybackCommand valueOf(String s)
    {
        return (PlaybackCommand)Enum.valueOf(com/rdio/android/core/events/playback/commands/PlaybackCommand, s);
    }

    public static PlaybackCommand[] values()
    {
        return (PlaybackCommand[])$VALUES.clone();
    }

    static 
    {
        TogglePlay = new PlaybackCommand("TogglePlay", 0);
        Play = new PlaybackCommand("Play", 1);
        Pause = new PlaybackCommand("Pause", 2);
        SkipNext = new PlaybackCommand("SkipNext", 3);
        SkipPrev = new PlaybackCommand("SkipPrev", 4);
        Stop = new PlaybackCommand("Stop", 5);
        Seek = new PlaybackCommand("Seek", 6);
        $VALUES = (new PlaybackCommand[] {
            TogglePlay, Play, Pause, SkipNext, SkipPrev, Stop, Seek
        });
    }
}
