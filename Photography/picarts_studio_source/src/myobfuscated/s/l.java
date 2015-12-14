// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;

import java.util.List;

final class l
{

    final Object a;
    List b;
    l c;
    l d;

    public l()
    {
        this(null);
    }

    public l(Object obj)
    {
        d = this;
        c = this;
        a = obj;
    }

    public final Object a()
    {
        int i = b();
        if (i > 0)
        {
            return b.remove(i - 1);
        } else
        {
            return null;
        }
    }

    public final int b()
    {
        if (b != null)
        {
            return b.size();
        } else
        {
            return 0;
        }
    }
}
