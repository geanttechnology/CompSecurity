// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class af extends a
{

    public af(String s, String s1, Long long1, Long long2)
    {
        super("BC_PageView_Post");
        if (long1.longValue() == 0L)
        {
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put("post_id", s);
        hashmap.put("source_type", s1);
        long l = long2.longValue() - long1.longValue();
        if (l > 0L)
        {
            hashmap.put("duration", String.valueOf(l));
        }
        a(hashmap);
    }
}
