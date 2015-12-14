// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class n extends a
{

    public n(String s)
    {
        super("BC_Discover_Category_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("circle_id", s);
        a(hashmap);
    }
}
