// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.IntRangeSet;

// Referenced classes of package com.medialets.thrift:
//            u

public class adExitEnum
{

    public static final int MMAdAdTimeout = 5;
    public static final int MMAdAppTerminated = 4;
    public static final int MMAdClickthrough = 1;
    public static final int MMAdExited = 3;
    public static final int MMAdSkipped = 2;
    public static final int MMAppCrash = 6;
    public static final int MMExitUnkown = 0;
    public static final IntRangeSet VALID_VALUES = new IntRangeSet(new int[] {
        0, 1, 2, 3, 4, 5, 6
    });
    public static final Map VALUES_TO_NAMES = new u();

    public adExitEnum()
    {
    }


    // Unreferenced inner class com/medialets/thrift/u
    final class u extends HashMap
    {

            u()
            {
                put(Integer.valueOf(0), "MMExitUnkown");
                put(Integer.valueOf(1), "MMAdClickthrough");
                put(Integer.valueOf(2), "MMAdSkipped");
                put(Integer.valueOf(3), "MMAdExited");
                put(Integer.valueOf(4), "MMAdAppTerminated");
                put(Integer.valueOf(5), "MMAdAdTimeout");
                put(Integer.valueOf(6), "MMAppCrash");
            }
    }

}
