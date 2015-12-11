// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;


// Referenced classes of package com.pointinside.nav:
//            RouteDestination

public static final class  extends Enum
{

    private static final AHEAD $VALUES[];
    public static final AHEAD AHEAD;
    public static final AHEAD LEFT;
    public static final AHEAD RIGHT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/nav/RouteDestination$OrientationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LEFT = new <init>("LEFT", 0);
        RIGHT = new <init>("RIGHT", 1);
        AHEAD = new <init>("AHEAD", 2);
        $VALUES = (new .VALUES[] {
            LEFT, RIGHT, AHEAD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
