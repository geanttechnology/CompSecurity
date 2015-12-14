// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent, ag

public class r extends BaseEvent
{

    public r(Map map, Map map1, YMKFeatures.FeatureName featurename)
    {
        super("YMK_Click_FeatureRoom_Brand_List");
        HashMap hashmap = new HashMap();
        map = ag.b(map);
        if (map != null && !map.isEmpty())
        {
            hashmap.put("vendor_guid", map);
        }
        map = ag.b(map1);
        if (map != null && !map.isEmpty())
        {
            hashmap.put("vendor_name", map);
        }
        hashmap.put("FeatureName", featurename.a());
        a(hashmap);
    }
}
