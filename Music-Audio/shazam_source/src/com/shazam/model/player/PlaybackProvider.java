// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;


public final class PlaybackProvider extends Enum
{

    private static final PlaybackProvider $VALUES[];
    public static final PlaybackProvider PREVIEW;
    public static final PlaybackProvider RDIO;
    public static final PlaybackProvider SPOTIFY;

    private PlaybackProvider(String s, int i)
    {
        super(s, i);
    }

    public static PlaybackProvider valueOf(String s)
    {
        return (PlaybackProvider)Enum.valueOf(com/shazam/model/player/PlaybackProvider, s);
    }

    public static PlaybackProvider[] values()
    {
        return (PlaybackProvider[])$VALUES.clone();
    }

    static 
    {
        RDIO = new PlaybackProvider("RDIO", 0);
        SPOTIFY = new PlaybackProvider("SPOTIFY", 1);
        PREVIEW = new PlaybackProvider("PREVIEW", 2);
        $VALUES = (new PlaybackProvider[] {
            RDIO, SPOTIFY, PREVIEW
        });
    }
}
