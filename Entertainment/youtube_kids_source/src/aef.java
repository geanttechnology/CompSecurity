// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aef extends Enum
{

    private static final aef $VALUES[];
    public static final aef INIT;
    public static final aef PLAYBACK_LOADED;
    public static final aef PLAYING;
    public static final aef PLAY_PENDING;
    public static final aef VIDEO_VIEW_PREPARED;

    private aef(String s, int i)
    {
        super(s, i);
    }

    public static aef max(aef aef1, aef aef2)
    {
        if (aef1.ordinal() > aef2.ordinal())
        {
            return aef1;
        } else
        {
            return aef2;
        }
    }

    public static aef valueOf(String s)
    {
        return (aef)Enum.valueOf(aef, s);
    }

    public static aef[] values()
    {
        return (aef[])$VALUES.clone();
    }

    public final boolean isCurrentOrPast(aef aef1)
    {
        return ordinal() >= aef1.ordinal();
    }

    static 
    {
        INIT = new aef("INIT", 0);
        PLAY_PENDING = new aef("PLAY_PENDING", 1);
        VIDEO_VIEW_PREPARED = new aef("VIDEO_VIEW_PREPARED", 2);
        PLAYBACK_LOADED = new aef("PLAYBACK_LOADED", 3);
        PLAYING = new aef("PLAYING", 4);
        $VALUES = (new aef[] {
            INIT, PLAY_PENDING, VIDEO_VIEW_PREPARED, PLAYBACK_LOADED, PLAYING
        });
    }
}
