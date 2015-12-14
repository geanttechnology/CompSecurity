// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class ShareItemSelectionEvent extends BaseEvent
{

    public ShareItemSelectionEvent(String s)
    {
        super("Which_social_network_is_popular_in_our_user_group");
        HashMap hashmap = new HashMap();
        hashmap.put("ItemName", String.valueOf(s));
        a(hashmap);
    }
}
