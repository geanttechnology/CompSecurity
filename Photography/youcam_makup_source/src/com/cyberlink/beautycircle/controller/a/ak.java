// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class ak extends a
{

    public ak(String s, Long long1, Long long2)
    {
        super("BC_PageView_UserProfilePage");
        HashMap hashmap = new HashMap();
        hashmap.put("page_name", s);
        if (long1 != null)
        {
            hashmap.put("viwer_id", long1.toString());
        }
        if (long2 != null)
        {
            hashmap.put("poster_id", long2.toString());
        }
        a(hashmap);
    }
}
