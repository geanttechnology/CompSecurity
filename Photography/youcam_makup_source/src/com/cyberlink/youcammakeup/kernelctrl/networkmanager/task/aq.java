// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.networkmanager.task;

import org.json.JSONObject;

public class aq
{

    private final long a;
    private final long b;

    public aq(JSONObject jsonobject)
    {
        a = jsonobject.getLong("maxId");
        b = jsonobject.getLong("lastModified");
    }

    public long a()
    {
        return a;
    }

    public long b()
    {
        return b;
    }
}
