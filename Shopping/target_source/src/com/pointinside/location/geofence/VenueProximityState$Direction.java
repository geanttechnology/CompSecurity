// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityState

public static final class  extends Enum
{

    private static final leaving $VALUES[];
    public static final leaving approaching;
    public static final leaving leaving;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/location/geofence/VenueProximityState$Direction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        approaching = new <init>("approaching", 0);
        leaving = new <init>("leaving", 1);
        $VALUES = (new .VALUES[] {
            approaching, leaving
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
