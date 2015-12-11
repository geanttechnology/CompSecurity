// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;


// Referenced classes of package com.pointinside.maps:
//            PIMap

static final class id extends Enum
{

    private static final ROUTE_WITH_ANIMATION $VALUES[];
    public static final ROUTE_WITH_ANIMATION HIDE_ZONE_SELECTOR;
    public static final ROUTE_WITH_ANIMATION LOAD_SVG_LOAD_ZONE;
    public static final ROUTE_WITH_ANIMATION LOAD_SVG_SET_CAMERA;
    public static final ROUTE_WITH_ANIMATION POST_CAMERA_SET;
    public static final ROUTE_WITH_ANIMATION ROUTE_WITH_ANIMATION;
    public static final ROUTE_WITH_ANIMATION STATIC_ZONE_SELECTOR;
    public static final ROUTE_WITH_ANIMATION UNKNOWN;
    final int id;

    static id fromId(int i)
    {
        id aid[] = values();
        int k = aid.length;
        for (int j = 0; j < k; j++)
        {
            id id1 = aid[j];
            if (id1.id == i)
            {
                return id1;
            }
        }

        return UNKNOWN;
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/pointinside/maps/PIMap$EventHandlerActions, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, 0);
        LOAD_SVG_SET_CAMERA = new <init>("LOAD_SVG_SET_CAMERA", 1, 1);
        LOAD_SVG_LOAD_ZONE = new <init>("LOAD_SVG_LOAD_ZONE", 2, 2);
        POST_CAMERA_SET = new <init>("POST_CAMERA_SET", 3, 3);
        STATIC_ZONE_SELECTOR = new <init>("STATIC_ZONE_SELECTOR", 4, 4);
        HIDE_ZONE_SELECTOR = new <init>("HIDE_ZONE_SELECTOR", 5, 5);
        ROUTE_WITH_ANIMATION = new <init>("ROUTE_WITH_ANIMATION", 6, 6);
        $VALUES = (new .VALUES[] {
            UNKNOWN, LOAD_SVG_SET_CAMERA, LOAD_SVG_LOAD_ZONE, POST_CAMERA_SET, STATIC_ZONE_SELECTOR, HIDE_ZONE_SELECTOR, ROUTE_WITH_ANIMATION
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        id = j;
    }
}
