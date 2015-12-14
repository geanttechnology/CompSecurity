// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more.a;

import org.json.JSONObject;

public class a extends com.cyberlink.youcammakeup.database.more.a
{

    private final long a;
    private final long b;
    private final boolean c;
    private final long d;

    public a(JSONObject jsonobject)
    {
        a = jsonobject.getLong("categoryId");
        b = jsonobject.getLong("maxFilmId");
        c = jsonobject.getBoolean("showNew");
        d = jsonobject.getLong("lastModified");
    }

    public long a()
    {
        return a;
    }

    public boolean b()
    {
        return c;
    }

    public long c()
    {
        return d;
    }

    public long d()
    {
        return b;
    }
}
