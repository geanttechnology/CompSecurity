// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class bb extends a
{

    public bb(String s, String s1, String s2, String s3, String s4, long l)
    {
        super("BC_Woobox");
        HashMap hashmap = new HashMap();
        hashmap.put("source", s);
        hashmap.put("operation", s1);
        hashmap.put("account", s2);
        hashmap.put("success", s3);
        hashmap.put("shareto", s4);
        hashmap.put("event_id", Long.toString(l));
        hashmap.put("ver", "3");
        a(hashmap);
    }
}
