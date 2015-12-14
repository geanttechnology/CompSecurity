// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.friends;

import java.util.List;
import java.util.concurrent.Executor;

// Referenced classes of package com.cyberlink.you.friends:
//            c, e, i, l

public class d
{

    private c a;

    public d(String s, String s1, List list, Class class1)
    {
        a = new c(null);
        com.cyberlink.you.friends.c.a(a, s);
        com.cyberlink.you.friends.c.b(a, s1);
        com.cyberlink.you.friends.c.a(a, list);
        com.cyberlink.you.friends.c.a(a, class1);
    }

    public d a()
    {
        com.cyberlink.you.friends.c.a(a, true);
        return this;
    }

    public d a(e e)
    {
        if (e != null)
        {
            com.cyberlink.you.friends.c.a(a, e);
        }
        return this;
    }

    public d a(i i)
    {
        if (i != null)
        {
            com.cyberlink.you.friends.c.a(a, i);
        }
        return this;
    }

    public d a(l l)
    {
        com.cyberlink.you.friends.c.a(a, l);
        return this;
    }

    public d a(Executor executor)
    {
        com.cyberlink.you.friends.c.a(a, executor);
        return this;
    }

    public d b()
    {
        com.cyberlink.you.friends.c.b(a, true);
        return this;
    }

    public c c()
    {
        return a;
    }
}
