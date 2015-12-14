// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class am extends a
{

    public static String a = "pageview";
    public static String b = "postview";

    public am(String s, String s1, Long long1, Long long2, long l)
    {
        super("BC_PostID");
        HashMap hashmap = new HashMap();
        hashmap.put("source", s);
        hashmap.put("operation", s1);
        if (long1 != null)
        {
            hashmap.put("postID", long1.toString());
        }
        if (long2 != null)
        {
            hashmap.put("userID", long2.toString());
        }
        if (l > 0L)
        {
            hashmap.put("staytime", Long.toString(l));
        }
        hashmap.put("ver", "3");
        a(hashmap);
    }

}
