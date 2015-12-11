// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer

protected static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR ERROR;
    public static final ERROR IDLE;
    public static final ERROR INITIALIZED;
    public static final ERROR PAUSED;
    public static final ERROR PLAYBACK_COMPLETED;
    public static final ERROR PREPARED;
    public static final ERROR STARTED;
    public static final ERROR STOPPED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        IDLE = new <init>("IDLE", 0);
        INITIALIZED = new <init>("INITIALIZED", 1);
        STOPPED = new <init>("STOPPED", 2);
        PREPARED = new <init>("PREPARED", 3);
        STARTED = new <init>("STARTED", 4);
        PAUSED = new <init>("PAUSED", 5);
        PLAYBACK_COMPLETED = new <init>("PLAYBACK_COMPLETED", 6);
        ERROR = new <init>("ERROR", 7);
        $VALUES = (new .VALUES[] {
            IDLE, INITIALIZED, STOPPED, PREPARED, STARTED, PAUSED, PLAYBACK_COMPLETED, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
