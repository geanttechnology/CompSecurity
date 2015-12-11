// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model;

import com.target.mothership.b;
import com.target.mothership.util.g;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model:
//            d

public class c
{

    public c()
    {
    }

    protected Object a(Class class1)
    {
        Object aobj[] = g.Data;
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            if (class1.isAssignableFrom(obj.getClass()))
            {
                return obj;
            }
        }

        return null;
    }

    protected void a(d d1, Class class1, Class class2)
    {
        if (a())
        {
            d1.b(b(class2));
            return;
        } else
        {
            d1.a(a(class1));
            return;
        }
    }

    protected void a(String s)
    {
        com.target.mothership.b.b b1 = com.target.mothership.b.a().n();
        if (b1 == null)
        {
            throw new IllegalStateException("Can not set the mock response file name: there is no debug server currently setup");
        } else
        {
            b1.a(s);
            return;
        }
    }

    protected boolean a()
    {
        return com.target.mothership.c.a();
    }

    protected com.target.mothership.b b()
    {
        return com.target.mothership.c.b();
    }

    protected Object b(Class class1)
    {
        Object aobj[] = h.Errors;
        int j = aobj.length;
        for (int i = 0; i < j; i++)
        {
            Object obj = aobj[i];
            if (class1.isAssignableFrom(obj.getClass()))
            {
                return obj;
            }
        }

        return null;
    }
}
