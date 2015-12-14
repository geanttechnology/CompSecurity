// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class LauncherPageViewEvent extends BaseEvent
{

    public LauncherPageViewEvent(int i)
    {
        super("LauncherPageView");
        HashMap hashmap = new HashMap();
        hashmap.put("PageIndex", String.valueOf(i));
        a(hashmap);
    }
}
