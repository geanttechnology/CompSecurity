// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class y extends BaseEvent
{

    private long b;
    private long c;

    public y(String s)
    {
        super(s);
        b = 0L;
        c = 0L;
    }

    public y a(String s, String s1, String s2, String s3, String s4)
    {
        HashMap hashmap = new HashMap();
        long l = c - b;
        if (l <= 0L)
        {
            return this;
        } else
        {
            hashmap.put("duration", String.valueOf(l));
            hashmap.put("source_type", s);
            hashmap.put("source_id", s1);
            hashmap.put("page_id", s2);
            hashmap.put("sku_guid", s3);
            hashmap.put("sku_item_guid", s4);
            b = 0L;
            a(((Map) (hashmap)));
            return this;
        }
    }

    public void d()
    {
        b = System.currentTimeMillis();
    }

    public void e()
    {
        c = System.currentTimeMillis();
    }
}
