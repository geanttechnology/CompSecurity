// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.unity;

import java.util.HashMap;
import java.util.Map;

public class UnityEvent
{

    private Map attributes;
    private String name;

    public UnityEvent(String s)
    {
        name = s;
        attributes = new HashMap();
    }

    public void addAttribute(String s, Double double1)
    {
        attributes.put(s, double1);
    }

    public void addAttribute(String s, String s1)
    {
        attributes.put(s, s1);
    }

    public Map getAttributes()
    {
        return attributes;
    }

    public String getName()
    {
        return name;
    }

    public void setAttributes(Map map)
    {
        attributes = map;
    }
}
