// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class PopularityOfEyeLashColorEvent extends BaseEvent
{

    public PopularityOfEyeLashColorEvent(String s, float f)
    {
        super("Popularity of eye lash color");
        HashMap hashmap = new HashMap();
        hashmap.put("Color", s);
        hashmap.put("Intensity", String.valueOf(f));
        a(hashmap);
    }
}
