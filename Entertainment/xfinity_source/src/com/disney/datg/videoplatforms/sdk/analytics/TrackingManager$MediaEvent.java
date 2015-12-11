// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            TrackingManager

public static final class  extends Enum
{

    private static final PING $VALUES[];
    public static final PING COMPLETE;
    public static final PING ERROR;
    public static final PING FIRST_QUARTER;
    public static final PING FORWARD;
    public static final PING MID_POINT;
    public static final PING PAUSED;
    public static final PING PING;
    public static final PING RESUMED;
    public static final PING REWIND;
    public static final PING STARTED;
    public static final PING STATEUPDATED;
    public static final PING STOPPED;
    public static final PING THIRD_QUARTER;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STARTED = new <init>("STARTED", 0);
        PAUSED = new <init>("PAUSED", 1);
        RESUMED = new <init>("RESUMED", 2);
        FORWARD = new <init>("FORWARD", 3);
        REWIND = new <init>("REWIND", 4);
        STOPPED = new <init>("STOPPED", 5);
        STATEUPDATED = new <init>("STATEUPDATED", 6);
        ERROR = new <init>("ERROR", 7);
        FIRST_QUARTER = new <init>("FIRST_QUARTER", 8);
        MID_POINT = new <init>("MID_POINT", 9);
        THIRD_QUARTER = new <init>("THIRD_QUARTER", 10);
        COMPLETE = new <init>("COMPLETE", 11);
        PING = new <init>("PING", 12);
        $VALUES = (new .VALUES[] {
            STARTED, PAUSED, RESUMED, FORWARD, REWIND, STOPPED, STATEUPDATED, ERROR, FIRST_QUARTER, MID_POINT, 
            THIRD_QUARTER, COMPLETE, PING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
