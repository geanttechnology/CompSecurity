// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.flurry:
//            BaseEvent

public class PopularityOfLookEvent extends BaseEvent
{

    public static String a = "";
    public static String b = "";

    public PopularityOfLookEvent()
    {
        super("Popularity of Look");
        HashMap hashmap = new HashMap();
        hashmap.put("GUID", a);
        hashmap.put("Name", b);
        a(hashmap);
    }

    public static void a(String s)
    {
        if (s != null)
        {
            a = s;
        }
    }

    public static void b(String s)
    {
        if (s != null)
        {
            b = s;
        }
    }

}
