// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker.albumpage;

import com.cyberlink.youcammakeup.pages.librarypicker.b;

public class a extends b
{

    protected final long d;
    protected final int e;
    protected final String f;
    protected final String g;

    public a(com.cyberlink.youcammakeup.database.b b1)
    {
        super(-1L, b1.d());
        d = b1.a();
        f = b1.b();
        e = b1.c();
        g = b1.e();
    }

    public long e()
    {
        return d;
    }

    public String f()
    {
        return f;
    }

    public int g()
    {
        return e;
    }

    public String toString()
    {
        StringBuilder stringbuilder = super.d();
        stringbuilder.append(", mAlbumId: ");
        stringbuilder.append(d);
        stringbuilder.append(", mImageCount: ");
        stringbuilder.append(e);
        stringbuilder.append(", mName: ");
        stringbuilder.append(f);
        stringbuilder.append(", mImagePath: ");
        stringbuilder.append(g);
        return stringbuilder.toString();
    }
}
