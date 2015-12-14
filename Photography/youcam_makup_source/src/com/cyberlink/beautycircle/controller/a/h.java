// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class h extends a
{

    public h(String s)
    {
        super("BC_Click_PostExternalLink");
        HashMap hashmap = new HashMap();
        hashmap.put("post_id", s);
        a(hashmap);
    }
}
