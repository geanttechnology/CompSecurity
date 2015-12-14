// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class q extends BaseEvent
{

    public q(String s, YMKFeatures.FeatureName featurename)
    {
        super("YMK_Click_FeatureRoom_Brand_Icon");
        HashMap hashmap = new HashMap();
        if (s == null)
        {
            s = "Perfect Style";
        }
        hashmap.put("sku_guid", s);
        hashmap.put("FeatureName", featurename.a());
        a(hashmap);
    }
}
