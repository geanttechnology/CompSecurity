// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class k extends a
{

    public k(String s, String s1)
    {
        super("BC_Contest");
        HashMap hashmap = new HashMap();
        hashmap.put("operation", s);
        hashmap.put("event_id", s1);
        hashmap.put("ver", "1");
        a(hashmap);
    }
}
