// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            w

final class aw extends w
{

    StringBuilder c;

    aw()
    {
        c = new StringBuilder();
    }

    final void a(char c1)
    {
        c.append(c1);
    }

    final void c()
    {
        c.setLength(0);
        b = 0;
    }

    public final String toString()
    {
        return c.toString();
    }
}
