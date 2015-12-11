// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMapError

public static final class  extends Enum
{

    private static final ROUTE $VALUES[];
    public static final ROUTE MAP_FEATURE;
    public static final ROUTE ROUTE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/maps/PIMapError$Kind, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MAP_FEATURE = new <init>("MAP_FEATURE", 0);
        ROUTE = new <init>("ROUTE", 1);
        $VALUES = (new .VALUES[] {
            MAP_FEATURE, ROUTE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
