// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityManager

public static final class  extends Enum
{

    private static final update $VALUES[];
    public static final update enter;
    public static final update exit;
    public static final update update;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/pointinside/location/geofence/VenueProximityManager$VenueProximityEvent$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        exit = new <init>("exit", 0);
        enter = new <init>("enter", 1);
        update = new <init>("update", 2);
        $VALUES = (new .VALUES[] {
            exit, enter, update
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
