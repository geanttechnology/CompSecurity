// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.mopub.common.d:
//            i

public static final class d
{

    public boolean a;
    private final Object b;
    private final String c;
    private Class d;
    private List e;
    private List f;
    private boolean g;

    public final d a(Class class1)
    {
        g = true;
        d = class1;
        return this;
    }

    public final d a(Class class1, Object obj)
    {
        e.add(class1);
        f.add(obj);
        return this;
    }

    public final Object a()
    {
        Class aclass[] = new Class[e.size()];
        aclass = (Class[])e.toArray(aclass);
        Method method = i.a(d, c, aclass);
        if (a)
        {
            method.setAccessible(true);
        }
        Object aobj[] = f.toArray();
        if (g)
        {
            return method.invoke(null, aobj);
        } else
        {
            return method.invoke(b, aobj);
        }
    }

    public d(Object obj, String s)
    {
        b = obj;
        c = s;
        e = new ArrayList();
        f = new ArrayList();
        if (obj != null)
        {
            obj = obj.getClass();
        } else
        {
            obj = null;
        }
        d = ((Class) (obj));
    }
}
