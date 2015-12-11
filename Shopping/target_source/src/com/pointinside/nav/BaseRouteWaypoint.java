// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.nav;


// Referenced classes of package com.pointinside.nav:
//            IRouteWaypoint

public abstract class BaseRouteWaypoint
    implements IRouteWaypoint
{
    public static final class WaypointType extends Enum
    {

        private static final WaypointType $VALUES[];
        public static final WaypointType DefaultEnd;
        public static final WaypointType DefaultStart;
        public static final WaypointType GEOPOINT;
        public static final WaypointType MAPPOINT;
        public static final WaypointType METAPRODUCTID;
        public static final WaypointType PLACE;
        public static final WaypointType PRODUCTID;
        public static final WaypointType SERVICETYPEID;
        public static final WaypointType TERM;

        public static WaypointType valueOf(String s)
        {
            return (WaypointType)Enum.valueOf(com/pointinside/nav/BaseRouteWaypoint$WaypointType, s);
        }

        public static WaypointType[] values()
        {
            return (WaypointType[])$VALUES.clone();
        }

        static 
        {
            PLACE = new WaypointType("PLACE", 0);
            MAPPOINT = new WaypointType("MAPPOINT", 1);
            GEOPOINT = new WaypointType("GEOPOINT", 2);
            PRODUCTID = new WaypointType("PRODUCTID", 3);
            METAPRODUCTID = new WaypointType("METAPRODUCTID", 4);
            TERM = new WaypointType("TERM", 5);
            SERVICETYPEID = new WaypointType("SERVICETYPEID", 6);
            DefaultStart = new WaypointType("DefaultStart", 7);
            DefaultEnd = new WaypointType("DefaultEnd", 8);
            $VALUES = (new WaypointType[] {
                PLACE, MAPPOINT, GEOPOINT, PRODUCTID, METAPRODUCTID, TERM, SERVICETYPEID, DefaultStart, DefaultEnd
            });
        }

        private WaypointType(String s, int i)
        {
            super(s, i);
        }
    }


    protected WaypointType mType;

    public BaseRouteWaypoint()
    {
    }
}
