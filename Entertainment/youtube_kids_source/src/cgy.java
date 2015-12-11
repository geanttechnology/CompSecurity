// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;

public final class cgy
{

    public cfy a;
    public Uri b;
    public String c;
    public boolean d;
    public String e;
    public String f;
    public cgt g;
    public String h;
    public Integer i;

    public cgy()
    {
    }

    public cgy(cgw cgw1)
    {
        c = cgw.a(cgw1);
        e = cgw.b(cgw1);
        f = cgw.c(cgw1);
        g = cgw.d(cgw1);
        b = cgw.e(cgw1);
        d = cgw.f(cgw1);
        a = cgw.g(cgw1);
        h = cgw.h(cgw1);
        i = cgw.i(cgw1);
    }

    public final cgw a()
    {
        return new cgw(this);
    }
}
