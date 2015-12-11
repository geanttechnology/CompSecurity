// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps.model;


// Referenced classes of package com.pointinside.maps.model:
//            MapRouteStyle

public static final class id extends Enum
{

    private static final DOTTED $VALUES[];
    public static final DOTTED DOTTED;
    public static final DOTTED SOLID;
    private final int id;

    public static id valueOf(String s)
    {
        return (id)Enum.valueOf(com/pointinside/maps/model/MapRouteStyle$RouteLineStyle, s);
    }

    public static id[] values()
    {
        return (id[])$VALUES.clone();
    }

    public int getId()
    {
        return id;
    }

    static 
    {
        SOLID = new <init>("SOLID", 0, 0);
        DOTTED = new <init>("DOTTED", 1, 1);
        $VALUES = (new .VALUES[] {
            SOLID, DOTTED
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}
