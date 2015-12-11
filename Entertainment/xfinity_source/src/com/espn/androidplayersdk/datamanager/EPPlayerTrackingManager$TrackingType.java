// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.datamanager;


// Referenced classes of package com.espn.androidplayersdk.datamanager:
//            EPPlayerTrackingManager

private static final class  extends Enum
{

    public static final VOD_END AD_COMPLETE;
    public static final VOD_END AD_START;
    public static final VOD_END AUTH_ATTEMPT;
    public static final VOD_END AUTH_SUCCESS;
    private static final VOD_END ENUM$VALUES[];
    public static final VOD_END EVENT_CONCLUDED;
    public static final VOD_END MAP_AFFILIATE;
    public static final VOD_END MILESTONE;
    public static final VOD_END MUTE;
    public static final VOD_END UNMUTE;
    public static final VOD_END VIDEO_PAUSE;
    public static final VOD_END VIDEO_PLAY_FROM_PAUSE;
    public static final VOD_END VIDEO_SCRUBBED;
    public static final VOD_END VIDEO_START;
    public static final VOD_END VIDEO_STOP;
    public static final VOD_END VOD_END;
    public static final VOD_END VOD_MID;
    public static final VOD_END VOD_START;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType, s);
    }

    public static [] values()
    {
         a[] = ENUM$VALUES;
        int i = a.length;
         a1[] = new ENUM.VALUES[i];
        System.arraycopy(a, 0, a1, 0, i);
        return a1;
    }

    static 
    {
        AUTH_ATTEMPT = new <init>("AUTH_ATTEMPT", 0);
        AUTH_SUCCESS = new <init>("AUTH_SUCCESS", 1);
        VIDEO_START = new <init>("VIDEO_START", 2);
        MILESTONE = new <init>("MILESTONE", 3);
        EVENT_CONCLUDED = new <init>("EVENT_CONCLUDED", 4);
        VIDEO_STOP = new <init>("VIDEO_STOP", 5);
        VIDEO_PAUSE = new <init>("VIDEO_PAUSE", 6);
        VIDEO_SCRUBBED = new <init>("VIDEO_SCRUBBED", 7);
        VIDEO_PLAY_FROM_PAUSE = new <init>("VIDEO_PLAY_FROM_PAUSE", 8);
        MUTE = new <init>("MUTE", 9);
        UNMUTE = new <init>("UNMUTE", 10);
        AD_START = new <init>("AD_START", 11);
        AD_COMPLETE = new <init>("AD_COMPLETE", 12);
        MAP_AFFILIATE = new <init>("MAP_AFFILIATE", 13);
        VOD_START = new <init>("VOD_START", 14);
        VOD_MID = new <init>("VOD_MID", 15);
        VOD_END = new <init>("VOD_END", 16);
        ENUM$VALUES = (new ENUM.VALUES[] {
            AUTH_ATTEMPT, AUTH_SUCCESS, VIDEO_START, MILESTONE, EVENT_CONCLUDED, VIDEO_STOP, VIDEO_PAUSE, VIDEO_SCRUBBED, VIDEO_PLAY_FROM_PAUSE, MUTE, 
            UNMUTE, AD_START, AD_COMPLETE, MAP_AFFILIATE, VOD_START, VOD_MID, VOD_END
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
