// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            TrackingManager

public static final class  extends Enum
{

    private static final ERROR $VALUES[];
    public static final ERROR BREAKCOMPLETED;
    public static final ERROR BREAKSTARTED;
    public static final ERROR COMPLETED;
    public static final ERROR ERROR;
    public static final ERROR FIRSTQUARTILE;
    public static final ERROR MIDPOINT;
    public static final ERROR STARTED;
    public static final ERROR THIRDQUARTILE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BREAKSTARTED = new <init>("BREAKSTARTED", 0);
        BREAKCOMPLETED = new <init>("BREAKCOMPLETED", 1);
        STARTED = new <init>("STARTED", 2);
        COMPLETED = new <init>("COMPLETED", 3);
        FIRSTQUARTILE = new <init>("FIRSTQUARTILE", 4);
        MIDPOINT = new <init>("MIDPOINT", 5);
        THIRDQUARTILE = new <init>("THIRDQUARTILE", 6);
        ERROR = new <init>("ERROR", 7);
        $VALUES = (new .VALUES[] {
            BREAKSTARTED, BREAKCOMPLETED, STARTED, COMPLETED, FIRSTQUARTILE, MIDPOINT, THIRDQUARTILE, ERROR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
