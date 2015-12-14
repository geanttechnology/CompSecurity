// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class s extends BaseEvent
{

    public s(String s1, String s2, String s3)
    {
        super("YMK_Click_FeatureRoom_PromotionButton");
        HashMap hashmap = new HashMap();
        hashmap.put("sku_guid", s1);
        hashmap.put("item_guid", s2);
        hashmap.put("button_name", s3);
        a(hashmap);
    }
}
