// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.a;

import com.perfectcorp.a.a;
import java.util.HashMap;
import java.util.Map;

public class m extends a
{

    public m(String s)
    {
        super("BC_CreatePost_From_Usage");
        HashMap hashmap = new HashMap();
        hashmap.put("item", s);
        a(hashmap);
    }
}
