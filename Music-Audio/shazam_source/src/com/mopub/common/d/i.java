// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.d;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class i
{
    public static final class a
    {

        public boolean a;
        private final Object b;
        private final String c;
        private Class d;
        private List e;
        private List f;
        private boolean g;

        public final a a(Class class1)
        {
            g = true;
            d = class1;
            return this;
        }

        public final a a(Class class1, Object obj)
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

        public a(Object obj, String s)
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


    public static transient Method a(Class class1, String s, Class aclass[])
    {
_L2:
        if (class1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        Method method = class1.getDeclaredMethod(s, aclass);
        return method;
        NoSuchMethodException nosuchmethodexception;
        nosuchmethodexception;
        class1 = class1.getSuperclass();
        if (true) goto _L2; else goto _L1
_L1:
        throw new NoSuchMethodException();
    }
}
