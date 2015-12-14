// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class d extends a
{

    public d(String s, String s1)
    {
        super("ABTest_SessionEnd");
        HashMap hashmap = new HashMap();
        String s2 = (new Timestamp(System.currentTimeMillis())).toString();
        hashmap.put("group", s);
        hashmap.put("caseId", s1);
        hashmap.put("timestamp", s2);
        a(hashmap);
    }
}
