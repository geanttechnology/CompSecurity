// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class aa extends a
{

    public aa(String s, String s1)
    {
        super("BC_PageView_BrandEvent_Result");
        HashMap hashmap = new HashMap();
        hashmap.put("brand_event_id", s);
        hashmap.put("service_type", s1);
        a(hashmap);
    }
}
