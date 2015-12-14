// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class v extends BaseEvent
{

    public v(String s, String s1, String s2, String s3, String s4, String s5)
    {
        super("YMK_Clicks_PromotionPage");
        HashMap hashmap = new HashMap();
        hashmap.put("source_type", s);
        hashmap.put("source_id", s1);
        hashmap.put("sku_guid", s2);
        hashmap.put("item_guid", s3);
        hashmap.put("page_id", s4);
        hashmap.put("button_name", s5);
        a(hashmap);
    }
}
