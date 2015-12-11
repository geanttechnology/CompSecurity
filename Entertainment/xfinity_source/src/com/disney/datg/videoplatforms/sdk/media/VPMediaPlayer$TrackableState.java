// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMediaPlayer

protected static final class  extends Enum
{

    private static final PING $VALUES[];
    public static final PING AD_BREAK_END;
    public static final PING AD_BREAK_START;
    public static final PING AD_END;
    public static final PING AD_ERROR;
    public static final PING AD_START;
    public static final PING AUTHORIZATION_FAIL;
    public static final PING AUTHORIZATION_START;
    public static final PING AUTHORIZATION_SUCCESS;
    public static final PING COMPLETE;
    public static final PING COMPLETE_25;
    public static final PING COMPLETE_50;
    public static final PING COMPLETE_75;
    public static final PING MEDIA_ERROR;
    public static final PING PING;
    public static final PING PROGRAM_END;
    public static final PING PROGRAM_FORWARD;
    public static final PING PROGRAM_PAUSED;
    public static final PING PROGRAM_RESUME;
    public static final PING PROGRAM_REWIND;
    public static final PING PROGRAM_START;
    public static final PING PROGRAM_STOPPED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$TrackableState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PROGRAM_START = new <init>("PROGRAM_START", 0);
        PROGRAM_RESUME = new <init>("PROGRAM_RESUME", 1);
        PROGRAM_PAUSED = new <init>("PROGRAM_PAUSED", 2);
        PROGRAM_STOPPED = new <init>("PROGRAM_STOPPED", 3);
        PROGRAM_END = new <init>("PROGRAM_END", 4);
        PROGRAM_FORWARD = new <init>("PROGRAM_FORWARD", 5);
        PROGRAM_REWIND = new <init>("PROGRAM_REWIND", 6);
        AUTHORIZATION_START = new <init>("AUTHORIZATION_START", 7);
        AUTHORIZATION_FAIL = new <init>("AUTHORIZATION_FAIL", 8);
        AUTHORIZATION_SUCCESS = new <init>("AUTHORIZATION_SUCCESS", 9);
        COMPLETE = new <init>("COMPLETE", 10);
        COMPLETE_75 = new <init>("COMPLETE_75", 11);
        COMPLETE_50 = new <init>("COMPLETE_50", 12);
        COMPLETE_25 = new <init>("COMPLETE_25", 13);
        AD_START = new <init>("AD_START", 14);
        AD_END = new <init>("AD_END", 15);
        AD_BREAK_START = new <init>("AD_BREAK_START", 16);
        AD_BREAK_END = new <init>("AD_BREAK_END", 17);
        AD_ERROR = new <init>("AD_ERROR", 18);
        MEDIA_ERROR = new <init>("MEDIA_ERROR", 19);
        PING = new <init>("PING", 20);
        $VALUES = (new .VALUES[] {
            PROGRAM_START, PROGRAM_RESUME, PROGRAM_PAUSED, PROGRAM_STOPPED, PROGRAM_END, PROGRAM_FORWARD, PROGRAM_REWIND, AUTHORIZATION_START, AUTHORIZATION_FAIL, AUTHORIZATION_SUCCESS, 
            COMPLETE, COMPLETE_75, COMPLETE_50, COMPLETE_25, AD_START, AD_END, AD_BREAK_START, AD_BREAK_END, AD_ERROR, MEDIA_ERROR, 
            PING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
