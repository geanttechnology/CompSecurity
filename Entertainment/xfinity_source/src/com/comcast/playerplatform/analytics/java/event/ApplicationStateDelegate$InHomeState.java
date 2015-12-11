// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.analytics.java.event;


// Referenced classes of package com.comcast.playerplatform.analytics.java.event:
//            ApplicationStateDelegate

public static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN IN_HOME;
    public static final UNKNOWN OUT_OF_HOME;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/analytics/java/event/ApplicationStateDelegate$InHomeState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OUT_OF_HOME = new <init>("OUT_OF_HOME", 0);
        IN_HOME = new <init>("IN_HOME", 1);
        UNKNOWN = new <init>("UNKNOWN", 2);
        $VALUES = (new .VALUES[] {
            OUT_OF_HOME, IN_HOME, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
