// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class PopularityOfHairDyeColorEvent extends BaseEvent
{

    public PopularityOfHairDyeColorEvent(String s, float f, float f1)
    {
        super("Popularity of hair dye parameters");
        HashMap hashmap = new HashMap();
        hashmap.put("Color", s);
        hashmap.put("Intensity", String.valueOf(f1));
        hashmap.put("shine", String.valueOf(f));
        a(hashmap);
    }
}
