// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.flurry.sdk:
//            lx

public class c
{

    private final Object a;
    private final String b;
    private Class c;
    private List d;
    private List e;
    private boolean f;
    private boolean g;

    public c a(Class class1)
    {
        g = true;
        c = class1;
        return this;
    }

    public c a(Class class1, Object obj)
    {
        d.add(class1);
        e.add(obj);
        return this;
    }

    public Object a()
    {
        Class aclass[] = new Class[d.size()];
        aclass = (Class[])d.toArray(aclass);
        Method method = lx.a(c, b, aclass);
        if (f)
        {
            method.setAccessible(true);
        }
        Object aobj[] = e.toArray();
        if (g)
        {
            return method.invoke(null, aobj);
        } else
        {
            return method.invoke(a, aobj);
        }
    }

    public thod(Object obj, String s)
    {
        a = obj;
        b = s;
        d = new ArrayList();
        e = new ArrayList();
        if (obj != null)
        {
            obj = obj.getClass();
        } else
        {
            obj = null;
        }
        c = ((Class) (obj));
    }
}
