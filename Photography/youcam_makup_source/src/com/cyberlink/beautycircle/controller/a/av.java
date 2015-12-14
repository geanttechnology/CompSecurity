// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class av extends a
{

    public av()
    {
        super("BC_SessionBegin");
        HashMap hashmap = new HashMap();
        hashmap.put("timestamp", (new Timestamp(System.currentTimeMillis())).toString());
        a(hashmap);
    }
}
