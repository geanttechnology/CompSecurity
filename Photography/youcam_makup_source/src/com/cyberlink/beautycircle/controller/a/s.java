// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class s extends a
{

    public static String a = "";

    public s(String s1, String s2, String s3, Long long1, long l)
    {
        super("BC_How_to");
        HashMap hashmap = new HashMap();
        if (s1 == null)
        {
            hashmap.put("source", "bc");
        } else
        {
            hashmap.put("source", s1);
        }
        hashmap.put("operation", s2);
        hashmap.put("former_page", a);
        hashmap.put("posttype", s3);
        hashmap.put("post_id", long1.toString());
        if (l > 0L)
        {
            hashmap.put("staytime", Long.toString(l));
        }
        hashmap.put("ver", "3");
        a(hashmap);
    }

}
