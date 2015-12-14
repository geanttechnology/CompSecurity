// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import android.os.Build;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class x extends BaseEvent
{

    public x(String s, boolean flag, boolean flag1)
    {
        super("YMK_Device_Info");
        HashMap hashmap = new HashMap();
        if (s != null && !s.isEmpty())
        {
            hashmap.put("errorMsg", s);
        }
        hashmap.put("isARMARch", String.valueOf(flag));
        hashmap.put("isSupportNeon", String.valueOf(flag1));
        hashmap.put("Build.BRAND", Build.BRAND);
        hashmap.put("Build.MANUFACTURER", Build.MANUFACTURER);
        hashmap.put("Build.DEVICE", Build.DEVICE);
        hashmap.put("Build.VERSION.SDK_INT", String.valueOf(android.os.Build.VERSION.SDK_INT));
        a(hashmap);
    }
}
