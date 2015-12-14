// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;

import java.util.Map;

public class BaseEvent
{

    private String a;
    private Map b;

    public BaseEvent(String s)
    {
        a = s;
        b = null;
    }

    public String a()
    {
        return a;
    }

    public void a(Map map)
    {
        b = map;
    }

    public Map b()
    {
        return b;
    }
}
