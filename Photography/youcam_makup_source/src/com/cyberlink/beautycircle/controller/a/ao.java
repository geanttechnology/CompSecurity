// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class ao extends a
{

    public ao(String s, String s1, String s2, String s3)
    {
        super("BC_Product_Filter_Clicks");
        HashMap hashmap = new HashMap();
        hashmap.put("category", s);
        hashmap.put("price", s1);
        hashmap.put("brand", s2);
        hashmap.put("locale", s3);
        a(hashmap);
    }
}
