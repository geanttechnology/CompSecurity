// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class f extends a
{

    public f(String s, String s1, String s2, String s3)
    {
        super("BC_Click_BrandCh_ProductList");
        HashMap hashmap = new HashMap();
        hashmap.put("button_name", s);
        hashmap.put("sku_type", s1);
        hashmap.put("sku_guid", s2);
        hashmap.put("sku_item_guid", s3);
        a(hashmap);
    }
}
