// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class b extends a
{

    public b(String s, String s1)
    {
        super("ABTest_Register_Completed");
        HashMap hashmap = new HashMap();
        hashmap.put("group", s);
        hashmap.put("caseId", s1);
        a(hashmap);
    }
}
