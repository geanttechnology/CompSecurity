// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class ag extends a
{

    public ag(String s)
    {
        super("BC_PageView_Product");
        HashMap hashmap = new HashMap();
        hashmap.put("productID", s);
        a(hashmap);
    }
}
