// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.librarypicker;

import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.pf.common.utility.m;

public abstract class b
{

    protected final long a;
    protected long b;
    protected com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState c;

    public b(long l, long l1)
    {
        b = l;
        a = l1;
        c = com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState.g;
    }

    public long a()
    {
        return a;
    }

    public void a(com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState itemstate)
    {
        c = itemstate;
    }

    public long b()
    {
        if (b != -1L)
        {
            return b;
        }
        m.a("pages.librarypicker.Item", (new StringBuilder()).append("mImageId is NO_ID, insert mFileId: ").append(a).toString());
        p p1 = com.cyberlink.youcammakeup.c.f();
        long l = p1.f(a());
        if (l != -1L)
        {
            b = l;
            return b;
        } else
        {
            b = p1.a(new com.cyberlink.youcammakeup.database.m(a)).w();
            return b;
        }
    }

    public com.cyberlink.youcammakeup.pages.libraryview.ItemViewTag.ItemState c()
    {
        return c;
    }

    protected StringBuilder d()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("mFileId: ");
        stringbuilder.append(a);
        stringbuilder.append(", mImageId: ");
        stringbuilder.append(b);
        return stringbuilder;
    }

    public String toString()
    {
        return d().toString();
    }
}
