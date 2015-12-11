// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            TrackingManager

public static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR ACTIVITYSTART;
    public static final ERROR ACTIVITYSTOP;
    public static final ERROR APPSTATE;
    public static final ERROR ERROR;
    public static final ERROR LAUNCH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LAUNCH = new <init>("LAUNCH", 0);
        ACTIVITYSTART = new <init>("ACTIVITYSTART", 1);
        ACTIVITYSTOP = new <init>("ACTIVITYSTOP", 2);
        APPSTATE = new <init>("APPSTATE", 3);
        ERROR = new <init>("ERROR", 4);
        $VALUES = (new .VALUES[] {
            LAUNCH, ACTIVITYSTART, ACTIVITYSTOP, APPSTATE, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
