// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class t extends BaseEvent
{

    public t(String s, String s1)
    {
        super("YMK_Click_MakeupTipsVideo");
        HashMap hashmap = new HashMap();
        hashmap.put("category_id", s);
        hashmap.put("video_id", s1);
        a(hashmap);
    }
}
