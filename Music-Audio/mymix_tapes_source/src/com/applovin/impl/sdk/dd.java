// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;


// Referenced classes of package com.applovin.impl.sdk:
//            db, dc

class dd
{

    final db a;
    private final String b;
    private final long c;
    private final boolean d;

    private dd(db db, String s, long l, boolean flag)
    {
        a = db;
        super();
        b = s;
        c = l;
        d = flag;
    }

    dd(db db, String s, long l, boolean flag, dc dc)
    {
        this(db, s, l, flag);
    }

    public String a()
    {
        return b;
    }

    public long b()
    {
        return c;
    }

    public boolean c()
    {
        return d;
    }
}
