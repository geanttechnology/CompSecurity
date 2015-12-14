// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class au extends a
{

    public au(String s, long l, long l1, long l2, 
            long l3, boolean flag, long l4)
    {
        super("BC_Review");
        HashMap hashmap = new HashMap();
        hashmap.put("pagetype", s);
        hashmap.put("staytime", Long.toString(l));
        hashmap.put("postclick", Long.toString(l1));
        hashmap.put("categoryclick", Long.toString(l2));
        hashmap.put("discovertile", Long.toString(l3));
        if (flag)
        {
            hashmap.put("slide", "Yes");
        } else
        {
            hashmap.put("slide", "No");
        }
        hashmap.put("number_post", Long.toString(l4));
        hashmap.put("ver", "1");
        a(hashmap);
    }
}
