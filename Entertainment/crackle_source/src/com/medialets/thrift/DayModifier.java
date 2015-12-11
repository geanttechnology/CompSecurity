// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.IntRangeSet;

// Referenced classes of package com.medialets.thrift:
//            v

public class DayModifier
{

    public static final int MMFriday = 6;
    public static final int MMMonday = 2;
    public static final int MMSaturday = 7;
    public static final int MMSunday = 1;
    public static final int MMThursday = 5;
    public static final int MMTuesday = 3;
    public static final int MMWednesday = 4;
    public static final int MMWeekday = 8;
    public static final int MMWeekend = 0;
    public static final IntRangeSet VALID_VALUES = new IntRangeSet(new int[] {
        0, 1, 2, 3, 4, 5, 6, 7, 8
    });
    public static final Map VALUES_TO_NAMES = new v();

    public DayModifier()
    {
    }


    // Unreferenced inner class com/medialets/thrift/v
    final class v extends HashMap
    {

            v()
            {
                put(Integer.valueOf(0), "MMWeekend");
                put(Integer.valueOf(1), "MMSunday");
                put(Integer.valueOf(2), "MMMonday");
                put(Integer.valueOf(3), "MMTuesday");
                put(Integer.valueOf(4), "MMWednesday");
                put(Integer.valueOf(5), "MMThursday");
                put(Integer.valueOf(6), "MMFriday");
                put(Integer.valueOf(7), "MMSaturday");
                put(Integer.valueOf(8), "MMWeekday");
            }
    }

}
