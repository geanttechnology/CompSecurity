// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class YMKNoticeItemClicksEvent extends BaseEvent
{

    public YMKNoticeItemClicksEvent(long l)
    {
        super("YMK_Notice_item_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("Notice Item ID", String.valueOf(l));
        a(hashmap);
    }
}
