// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class ae extends a
{

    public ae(String s)
    {
        super("BC_PageView_Notification_SubPage");
        HashMap hashmap = new HashMap();
        hashmap.put("type", s);
        a(hashmap);
    }
}
