// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class d extends BaseEvent
{

    public d(String s, String s1, String s2)
    {
        super("Clicks of BannerPromoPage Back");
        HashMap hashmap = new HashMap();
        hashmap.put("type", s);
        hashmap.put("skuGUID", s1);
        hashmap.put("skuItemGUID", s2);
        a(hashmap);
    }
}
