// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class o extends a
{

    public o(String s, Long long1, String s1, long l)
    {
        super("BC_EventFreesample");
        HashMap hashmap = new HashMap();
        if (s == null)
        {
            hashmap.put("source", "bc");
        } else
        {
            hashmap.put("source", s);
        }
        hashmap.put("operation", s1);
        hashmap.put("event_id", long1.toString());
        if (l > 0L)
        {
            hashmap.put("staytime", Long.toString(l));
        }
        hashmap.put("ver", "1");
        a(hashmap);
    }
}
