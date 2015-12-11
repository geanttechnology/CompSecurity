// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            vj, vh

class nit> extends vj
{

    final vh a;

    protected int a()
    {
        return a.h;
    }

    protected int a(Object obj)
    {
        if (obj == null)
        {
            return a.a();
        } else
        {
            return a.a(obj, obj.hashCode());
        }
    }

    protected Object a(int i, int j)
    {
        return a.g[(i << 1) + j];
    }

    protected Object a(int i, Object obj)
    {
        return a.a(i, obj);
    }

    protected void a(int i)
    {
        a.d(i);
    }

    protected void a(Object obj, Object obj1)
    {
        a.put(obj, obj1);
    }

    protected int b(Object obj)
    {
        return a.a(obj);
    }

    protected Map b()
    {
        return a;
    }

    protected void c()
    {
        a.clear();
    }

    (vh vh1)
    {
        a = vh1;
        super();
    }
}
