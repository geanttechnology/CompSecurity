// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            bv, p, cy, AppLovinSdkImpl, 
//            by, bz, o

abstract class cx extends bv
    implements p
{

    private int a;
    private long b;
    private final p c;
    private by d;

    cx(String s, int i, AppLovinSdkImpl applovinsdkimpl)
    {
        super(s, applovinsdkimpl);
        b = -1L;
        d = null;
        a = i;
        c = new cy(this, applovinsdkimpl, s);
    }

    cx(String s, by by1, AppLovinSdkImpl applovinsdkimpl)
    {
        this(s, ((Integer)applovinsdkimpl.a(by1)).intValue(), applovinsdkimpl);
    }

    static int a(cx cx1)
    {
        return cx1.a;
    }

    static int a(cx cx1, int i)
    {
        cx1.a = i;
        return i;
    }

    static long b(cx cx1)
    {
        return cx1.b;
    }

    private void c()
    {
        if (d != null)
        {
            bz bz1 = f.getSettingsManager();
            bz1.a(d, d.c());
            bz1.b();
        }
    }

    static void c(cx cx1)
    {
        cx1.c();
    }

    public void a(int i)
    {
    }

    public void a(long l)
    {
        b = l;
    }

    public void a(by by1)
    {
        d = by1;
    }

    protected abstract void a(o o, p p1);

    public void a(JSONObject jsonobject, int i)
    {
    }

    public void run()
    {
        a(f.getConnectionManager(), c);
    }
}
