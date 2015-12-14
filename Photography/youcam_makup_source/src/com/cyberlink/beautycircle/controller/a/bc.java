// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class bc extends a
{

    public bc(String s)
    {
        super("YMK_PageView_BeautyTips");
        HashMap hashmap = new HashMap();
        hashmap.put("source_name", s);
        a(hashmap);
    }
}
