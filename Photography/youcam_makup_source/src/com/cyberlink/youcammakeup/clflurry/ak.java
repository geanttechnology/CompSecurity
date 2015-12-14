// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class ak extends BaseEvent
{

    public ak(String s, String s1, String s2)
    {
        super("YMK_PageView_AD_From_Room");
        HashMap hashmap = new HashMap();
        if (s != null && !s.isEmpty())
        {
            hashmap.put((new StringBuilder()).append(s).append("_sku_guild").toString(), s1);
            hashmap.put((new StringBuilder()).append(s).append("_item_guid").toString(), s2);
        }
        a(hashmap);
    }
}
