// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class q extends a
{

    public q(Long long1, Long long2)
    {
        super("BC_Followers");
        HashMap hashmap = new HashMap();
        hashmap.put("followerid", long1.toString());
        hashmap.put("followingid", long2.toString());
        hashmap.put("ver", "1");
        a(hashmap);
    }
}
