// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.os.Build;
import android.util.Log;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            n

public class m
{

    private static final Set a;
    private static final Map b;
    private static final Set c;
    private static final Set d;

    public static boolean a()
    {
        return a.contains(new n(Build.MANUFACTURER, Build.MODEL));
    }

    public static int b()
    {
        Integer integer = (Integer)b.get(new n(Build.MANUFACTURER, Build.MODEL));
        if (integer == null)
        {
            return -1;
        } else
        {
            return integer.intValue();
        }
    }

    static 
    {
        Log.i("DeviceInfoUtils", (new n(Build.MANUFACTURER, Build.MODEL)).toString());
        a = new HashSet();
        a.add(new n("Sony Ericsson", "MT15i"));
        a.add(new n("samsung", "SCH-I699I"));
        a.add(new n("HUAWEI", "HUAWEI G520-0000"));
        a.add(new n("FIH", "SH530U"));
        b = new HashMap();
        b.put(new n("samsung", "SM-N9108V"), Integer.valueOf(4096));
        b.put(new n("HTC", "HTC_D820u"), Integer.valueOf(4096));
        c = new HashSet();
        c.add(new n("motorola", "Nexus 6"));
        d = new HashSet();
        d.add(new n("HUAWEI", "MediaPad 7 Lite"));
    }
}
