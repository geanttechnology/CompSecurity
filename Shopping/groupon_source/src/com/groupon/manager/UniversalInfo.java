// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import java.util.HashMap;

public class UniversalInfo
{

    protected HashMap options;

    public UniversalInfo()
    {
        options = new HashMap();
    }

    public Object getValue(String s)
    {
        return options.get(s);
    }

    public boolean hasKey(String s)
    {
        return options.containsKey(s);
    }

    public UniversalInfo put(String s, Object obj)
    {
        options.put(s, obj);
        return this;
    }
}
