// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class YMKShareToEventOld extends BaseEvent
{

    public YMKShareToEventOld(String s)
    {
        super("YMK_ShareTo");
        HashMap hashmap = new HashMap();
        hashmap.put("APPName", s);
        a(hashmap);
    }
}
