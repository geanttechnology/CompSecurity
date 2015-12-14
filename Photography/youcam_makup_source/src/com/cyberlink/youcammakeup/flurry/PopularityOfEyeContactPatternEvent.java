// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class PopularityOfEyeContactPatternEvent extends BaseEvent
{

    public PopularityOfEyeContactPatternEvent(String s)
    {
        super("Popularity of eye color pattern");
        HashMap hashmap = new HashMap();
        hashmap.put("GUID", s);
        a(hashmap);
    }
}
