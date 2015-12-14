// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class h extends BaseEvent
{

    public h(String s, String s1, String s2)
    {
        super("Clicks of consultation button from room");
        HashMap hashmap = new HashMap();
        hashmap.put("type", s);
        hashmap.put("skuGUID", s1);
        hashmap.put("skuItemGUID", s2);
        a(hashmap);
    }
}
