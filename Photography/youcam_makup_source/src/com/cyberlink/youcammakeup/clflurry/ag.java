// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class ag extends BaseEvent
{

    public ag(Map map, Map map1, YMKFeatures.FeatureName featurename)
    {
        super("YMK_Impression_FeatureRoom_Brand_List");
        HashMap hashmap = new HashMap();
        map = b(map);
        if (map != null && !map.isEmpty())
        {
            hashmap.put("vendor_guid", map);
        }
        map = b(map1);
        if (map != null && !map.isEmpty())
        {
            hashmap.put("vendor_name", map);
        }
        hashmap.put("FeatureName", featurename.a());
        a(hashmap);
    }

    public static String b(Map map)
    {
        Object obj = "";
        if (map != null) goto _L2; else goto _L1
_L1:
        return ((String) (obj));
_L2:
        Iterator iterator = map.entrySet().iterator();
        map = ((Map) (obj));
        do
        {
            obj = map;
            if (!iterator.hasNext())
            {
                continue;
            }
            obj = (java.util.Map.Entry)iterator.next();
            String s = (String)((java.util.Map.Entry) (obj)).getKey();
            Integer integer = (Integer)((java.util.Map.Entry) (obj)).getValue();
            if (s != null && integer != null)
            {
                Object obj1 = map;
                if (!map.isEmpty())
                {
                    obj1 = (new StringBuilder()).append(map).append(", ").toString();
                }
                map = (new StringBuilder()).append(((String) (obj1))).append(s).append(":").append(integer).toString();
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }
}
