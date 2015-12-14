// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class an extends a
{

    public an(String s, String s1)
    {
        super("BC_Product_Buy_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("product_id", s);
        hashmap.put("store_name", s1);
        a(hashmap);
    }
}
