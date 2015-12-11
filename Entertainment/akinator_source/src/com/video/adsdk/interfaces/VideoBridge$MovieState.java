// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.interfaces;


// Referenced classes of package com.video.adsdk.interfaces:
//            VideoBridge

public static final class  extends Enum
{

    private static final MOVIESTATE_STOPPED_BY_USER $VALUES[];
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_BUFFERING;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_COMPLETED;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_INITIALIZED;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_PAUSED;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_PLAYING_NO_SKIP;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_PLAYING_SKIP;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_RESUMED;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_STARTED;
    public static final MOVIESTATE_STOPPED_BY_USER MOVIESTATE_STOPPED_BY_USER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/video/adsdk/interfaces/VideoBridge$MovieState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MOVIESTATE_INITIALIZED = new <init>("MOVIESTATE_INITIALIZED", 0);
        MOVIESTATE_BUFFERING = new <init>("MOVIESTATE_BUFFERING", 1);
        MOVIESTATE_PLAYING_NO_SKIP = new <init>("MOVIESTATE_PLAYING_NO_SKIP", 2);
        MOVIESTATE_PLAYING_SKIP = new <init>("MOVIESTATE_PLAYING_SKIP", 3);
        MOVIESTATE_PAUSED = new <init>("MOVIESTATE_PAUSED", 4);
        MOVIESTATE_COMPLETED = new <init>("MOVIESTATE_COMPLETED", 5);
        MOVIESTATE_STARTED = new <init>("MOVIESTATE_STARTED", 6);
        MOVIESTATE_RESUMED = new <init>("MOVIESTATE_RESUMED", 7);
        MOVIESTATE_STOPPED_BY_USER = new <init>("MOVIESTATE_STOPPED_BY_USER", 8);
        $VALUES = (new .VALUES[] {
            MOVIESTATE_INITIALIZED, MOVIESTATE_BUFFERING, MOVIESTATE_PLAYING_NO_SKIP, MOVIESTATE_PLAYING_SKIP, MOVIESTATE_PAUSED, MOVIESTATE_COMPLETED, MOVIESTATE_STARTED, MOVIESTATE_RESUMED, MOVIESTATE_STOPPED_BY_USER
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
