// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import com.cyberlink.youcammakeup.utility.MakeupMode;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class UsageOfCategoryEvent extends BaseEvent
{

    public UsageOfCategoryEvent(MakeupMode makeupmode)
    {
        super("Usage of Category");
        HashMap hashmap = new HashMap();
        hashmap.put("CategoryName", makeupmode.a());
        a(hashmap);
    }
}
