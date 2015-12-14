// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class aq extends a
{

    public static String a;
    public static String b;
    public static String c;

    public aq(String s, String s1)
    {
        super("BC_Register");
        HashMap hashmap = new HashMap();
        hashmap.put("source", c);
        hashmap.put("account", s);
        hashmap.put("source_of_entrance", a);
        hashmap.put("campaign_of_entrance", b);
        hashmap.put("success", s1);
        hashmap.put("ver", "3");
        a(hashmap);
    }
}
