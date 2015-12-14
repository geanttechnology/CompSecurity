// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class t extends a
{

    public t(Long long1)
    {
        super("BC_MemberInfo");
        if (long1 == null)
        {
            return;
        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put("user_id", long1.toString());
            a(hashmap);
            return;
        }
    }
}
