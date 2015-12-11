// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.analytics;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.analytics:
//            TrackerFactory

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN OMNITURE;
    public static final UNKNOWN SLOGGER;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OMNITURE = new <init>("OMNITURE", 0);
        SLOGGER = new <init>("SLOGGER", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            OMNITURE, SLOGGER, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
