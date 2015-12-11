// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;


// Referenced classes of package com.pointinside.nav:
//            BaseRouteWaypoint

public static final class  extends Enum
{

    private static final DefaultEnd $VALUES[];
    public static final DefaultEnd DefaultEnd;
    public static final DefaultEnd DefaultStart;
    public static final DefaultEnd GEOPOINT;
    public static final DefaultEnd MAPPOINT;
    public static final DefaultEnd METAPRODUCTID;
    public static final DefaultEnd PLACE;
    public static final DefaultEnd PRODUCTID;
    public static final DefaultEnd SERVICETYPEID;
    public static final DefaultEnd TERM;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/nav/BaseRouteWaypoint$WaypointType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PLACE = new <init>("PLACE", 0);
        MAPPOINT = new <init>("MAPPOINT", 1);
        GEOPOINT = new <init>("GEOPOINT", 2);
        PRODUCTID = new <init>("PRODUCTID", 3);
        METAPRODUCTID = new <init>("METAPRODUCTID", 4);
        TERM = new <init>("TERM", 5);
        SERVICETYPEID = new <init>("SERVICETYPEID", 6);
        DefaultStart = new <init>("DefaultStart", 7);
        DefaultEnd = new <init>("DefaultEnd", 8);
        $VALUES = (new .VALUES[] {
            PLACE, MAPPOINT, GEOPOINT, PRODUCTID, METAPRODUCTID, TERM, SERVICETYPEID, DefaultStart, DefaultEnd
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
