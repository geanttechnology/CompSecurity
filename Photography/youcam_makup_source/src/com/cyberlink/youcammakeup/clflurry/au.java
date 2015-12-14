// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.clflurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.clflurry:
//            BaseEvent

public class au extends BaseEvent
{

    public au(int i, int j, int k, int l, int i1, int j1)
    {
        super("YMK_UserProfile");
        HashMap hashmap = new HashMap();
        hashmap.put("gender", String.valueOf(i));
        hashmap.put("skin_color", String.format("%06X", new Object[] {
            Integer.valueOf(0xffffff & j)
        }));
        hashmap.put("hair_color", String.format("%06X", new Object[] {
            Integer.valueOf(0xffffff & k)
        }));
        hashmap.put("eyebrow_color", String.format("%06X", new Object[] {
            Integer.valueOf(0xffffff & l)
        }));
        hashmap.put("iris_color", String.format("%06X", new Object[] {
            Integer.valueOf(0xffffff & i1)
        }));
        hashmap.put("lip_color", String.format("%06X", new Object[] {
            Integer.valueOf(0xffffff & j1)
        }));
        a(hashmap);
    }
}
