// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.location.geofence;


// Referenced classes of package com.pointinside.location.geofence:
//            VenueProximityService

private static final class str extends Enum
{

    private static final END_LOCATION_ALARM $VALUES[];
    public static final END_LOCATION_ALARM END_LOCATION_ALARM;
    public static final END_LOCATION_ALARM START;
    public static final END_LOCATION_ALARM STOP;
    private String str;

    public static str toEnum(String s)
    {
        str str1 = null;
        str astr[] = values();
        int j = astr.length;
        for (int i = 0; i < j; i++)
        {
            str str2 = astr[i];
            if (str2.str.equals(s))
            {
                str1 = str2;
            }
        }

        return str1;
    }

    public static str valueOf(String s)
    {
        return (str)Enum.valueOf(com/pointinside/location/geofence/VenueProximityService$ACTION, s);
    }

    public static str[] values()
    {
        return (str[])$VALUES.clone();
    }

    static 
    {
        START = new <init>("START", 0, "com.pointinside.android.action.START_PROXIMITY_DETECTION");
        STOP = new <init>("STOP", 1, "com.pointinside.android.action.STOP_PROXIMITY_DETECTION");
        END_LOCATION_ALARM = new <init>("END_LOCATION_ALARM", 2, "com.pointinside.android.action.LOCATION_ALARM");
        $VALUES = (new .VALUES[] {
            START, STOP, END_LOCATION_ALARM
        });
    }


    private (String s, int i, String s1)
    {
        super(s, i);
        str = s1;
    }
}
