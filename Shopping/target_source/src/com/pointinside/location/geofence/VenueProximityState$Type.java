// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityState

public static final class  extends Enum
{

    private static final IN_VENUE_CONFIRMED $VALUES[];
    public static final IN_VENUE_CONFIRMED DISABLED;
    public static final IN_VENUE_CONFIRMED IN_VENUE_CONFIRMED;
    public static final IN_VENUE_CONFIRMED NEAR_VENUE;
    public static final IN_VENUE_CONFIRMED OUT_OF_VENUE;
    public static final IN_VENUE_CONFIRMED UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/location/geofence/VenueProximityState$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DISABLED = new <init>("DISABLED", 0);
        UNKNOWN = new <init>("UNKNOWN", 1);
        OUT_OF_VENUE = new <init>("OUT_OF_VENUE", 2);
        NEAR_VENUE = new <init>("NEAR_VENUE", 3);
        IN_VENUE_CONFIRMED = new <init>("IN_VENUE_CONFIRMED", 4);
        $VALUES = (new .VALUES[] {
            DISABLED, UNKNOWN, OUT_OF_VENUE, NEAR_VENUE, IN_VENUE_CONFIRMED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
