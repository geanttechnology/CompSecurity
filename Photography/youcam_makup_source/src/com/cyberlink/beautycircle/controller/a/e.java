// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class e extends a
{

    public static String a = "discovery_page";

    public e(String s, long l, String s1, boolean flag, long l1)
    {
        super("BC_Category");
        HashMap hashmap = new HashMap();
        hashmap.put("category", s);
        if (s1.equals("PageView"))
        {
            hashmap.put("formerPage", a);
        }
        hashmap.put("stayTime", Long.toString(l));
        hashmap.put("operation", s1);
        if (flag)
        {
            hashmap.put("slide", "Yes");
        } else
        {
            hashmap.put("slide", "No");
        }
        hashmap.put("postclick", Long.toString(l1));
        hashmap.put("ver", "2");
        a(hashmap);
    }

}
