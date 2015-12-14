// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.i;

import org.json.JSONObject;

public class f
{

    private String a;
    private long b;

    public f(JSONObject jsonobject)
    {
        a = jsonobject.getString("type");
        b = Long.parseLong(jsonobject.getString("lastModified"));
    }

    public String a()
    {
        return a;
    }

    public long b()
    {
        return b;
    }
}
