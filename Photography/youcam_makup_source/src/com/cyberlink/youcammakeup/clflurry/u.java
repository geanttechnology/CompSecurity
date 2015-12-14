// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class u extends BaseEvent
{

    public u(String s)
    {
        super("YMK_Clicks_AD_Launcher_Banner");
        HashMap hashmap = new HashMap();
        hashmap.put("Banner ID", s);
        a(hashmap);
    }
}
