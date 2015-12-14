// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class aw extends a
{

    public aw(long l)
    {
        super("BC_SessionEnd");
        HashMap hashmap = new HashMap();
        hashmap.put("timestamp", (new Timestamp(System.currentTimeMillis())).toString());
        hashmap.put("duration", Long.toString(l));
        a(hashmap);
    }
}
