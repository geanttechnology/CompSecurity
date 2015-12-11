// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityManager

private static final class  extends Enum
{

    private static final STOP_SERVICE $VALUES[];
    public static final STOP_SERVICE START_SERVICE;
    public static final STOP_SERVICE STOP_SERVICE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/location/geofence/VenueProximityManager$ACTIONS, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        START_SERVICE = new <init>("START_SERVICE", 0);
        STOP_SERVICE = new <init>("STOP_SERVICE", 1);
        $VALUES = (new .VALUES[] {
            START_SERVICE, STOP_SERVICE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
