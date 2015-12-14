// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class ah extends BaseEvent
{

    public ah(long l)
    {
        super("YMK_MakeupTipsCategory_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("CategoryID", String.valueOf(l));
        a(hashmap);
    }
}
