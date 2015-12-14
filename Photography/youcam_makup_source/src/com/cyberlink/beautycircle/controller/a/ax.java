// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class ax extends a
{

    public ax(String s, String s1, String s2, String s3)
    {
        super("BC_Share");
        HashMap hashmap = new HashMap();
        hashmap.put("account", s);
        hashmap.put("source", s1);
        hashmap.put("operation", s2);
        hashmap.put("post_id", s3);
        hashmap.put("ver", "1");
        a(hashmap);
    }
}
