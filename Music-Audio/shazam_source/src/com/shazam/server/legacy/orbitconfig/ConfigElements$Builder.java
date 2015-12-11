// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.server.legacy.orbitconfig:
//            ConfigElements

public static class values
{

    private Map values;

    public static values configElements()
    {
        return new <init>();
    }

    public ConfigElements build()
    {
        return new ConfigElements(this, null);
    }

    public <init> put(String s, String s1)
    {
        values.put(s, s1);
        return this;
    }

    public values withValues(Map map)
    {
        values = map;
        return this;
    }


    public A()
    {
        values = new HashMap();
    }
}
