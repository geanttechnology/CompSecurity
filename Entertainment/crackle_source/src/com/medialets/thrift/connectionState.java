// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.thrift;

import java.util.HashMap;
import java.util.Map;
import org.apache.thrift.IntRangeSet;

// Referenced classes of package com.medialets.thrift:
//            d

public class connectionState
{

    public static final int MMCDNConnection = 2;
    public static final int MMNoConnection = 0;
    public static final int MMUnknownConnection = 1;
    public static final int MMWiFiConnection = 3;
    public static final IntRangeSet VALID_VALUES = new IntRangeSet(new int[] {
        0, 1, 2, 3
    });
    public static final Map VALUES_TO_NAMES = new d();

    public connectionState()
    {
    }


    // Unreferenced inner class com/medialets/thrift/d
    final class d extends HashMap
    {

            d()
            {
                put(Integer.valueOf(0), "MMNoConnection");
                put(Integer.valueOf(1), "MMUnknownConnection");
                put(Integer.valueOf(2), "MMCDNConnection");
                put(Integer.valueOf(3), "MMWiFiConnection");
            }
    }

}
