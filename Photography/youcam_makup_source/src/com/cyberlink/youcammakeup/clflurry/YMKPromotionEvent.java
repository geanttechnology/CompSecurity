// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKPromotionEvent extends BaseEvent
{

    private static String b = "1";

    public YMKPromotionEvent(String s, String s1, String s2, String s3)
    {
        super("YMK_Promotion_Page");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", s);
        if (s1 != null)
        {
            hashmap.put("skuID", s1);
        }
        if (s2 != null)
        {
            hashmap.put("pageID", s2);
        }
        if (s3 != null)
        {
            hashmap.put("source", s3);
        }
        hashmap.put("ver", b);
        a(hashmap);
    }

}
