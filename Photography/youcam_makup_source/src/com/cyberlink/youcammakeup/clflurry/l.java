// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class l extends BaseEvent
{

    public l(boolean flag)
    {
        super("LipcolorPageView");
        HashMap hashmap = new HashMap();
        hashmap.put("hasSku", String.valueOf(flag));
        a(hashmap);
    }
}
