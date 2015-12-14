// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.moreview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.cyberlink.youcammakeup.pages.moreview:
//            b, BeautyCategoryItem

public abstract class a
{

    protected Map a;
    protected ArrayList b;

    public a()
    {
        b = new ArrayList();
    }

    public com.cyberlink.youcammakeup.database.more.a a(long l)
    {
        return null;
    }

    public BeautyCategoryItem a(int i)
    {
        return null;
    }

    public void a()
    {
        for (Iterator iterator = b.iterator(); iterator.hasNext(); ((b)iterator.next()).o()) { }
    }

    public void a(b b1)
    {
        b.add(b1);
    }

    public void b()
    {
    }

    public void b(b b1)
    {
        if (b.contains(b1))
        {
            b.remove(b1);
        }
    }

    public int c()
    {
        return 0;
    }

    public Map d()
    {
        return null;
    }

    public Collection e()
    {
        return null;
    }

    public void f()
    {
    }
}
