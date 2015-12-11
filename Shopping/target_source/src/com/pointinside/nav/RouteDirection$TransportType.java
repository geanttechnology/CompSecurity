// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;


// Referenced classes of package com.pointinside.nav:
//            RouteDirection

public static final class  extends Enum
{

    private static final RAMP $VALUES[];
    public static final RAMP ELEVATOR;
    public static final RAMP ESCALATOR;
    public static final RAMP RAMP;
    public static final RAMP STAIRS;
    public static final RAMP WALKING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/nav/RouteDirection$TransportType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        WALKING = new <init>("WALKING", 0);
        ELEVATOR = new <init>("ELEVATOR", 1);
        ESCALATOR = new <init>("ESCALATOR", 2);
        STAIRS = new <init>("STAIRS", 3);
        RAMP = new <init>("RAMP", 4);
        $VALUES = (new .VALUES[] {
            WALKING, ELEVATOR, ESCALATOR, STAIRS, RAMP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
