// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class az extends a
{

    private static Long a = Long.valueOf(0L);
    private static final Long b = Long.valueOf(0x2bf20L);

    public az(String s, long l, boolean flag)
    {
        super("BC_Source_of_entrance");
        HashMap hashmap = new HashMap();
        hashmap.put("source", s);
        if (l > 0L)
        {
            hashmap.put("staytime", Long.toString(l));
        }
        hashmap.put("totaltime", Long.toString(System.currentTimeMillis() - a.longValue()));
        hashmap.put("timestamp", a.toString());
        if (flag)
        {
            hashmap.put("registered", "yes");
        } else
        {
            hashmap.put("registered", "no");
        }
        hashmap.put("ver", "2");
        a(hashmap);
    }

    public static void a(Long long1)
    {
        if (long1.longValue() - a.longValue() > b.longValue())
        {
            a = long1;
        }
    }

}
