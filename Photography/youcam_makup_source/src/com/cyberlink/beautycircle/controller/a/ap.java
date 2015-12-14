// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class ap extends a
{

    public ap(String s, String s1, String s2)
    {
        super("BC_Profile");
        HashMap hashmap = new HashMap();
        hashmap.put("opeation", s);
        hashmap.put("pagetype", s1);
        hashmap.put("userId", s2);
        hashmap.put("ver", "1");
        a(hashmap);
    }
}
