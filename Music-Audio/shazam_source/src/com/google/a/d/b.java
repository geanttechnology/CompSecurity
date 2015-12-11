// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.d;

import com.google.a.a.m;
import com.google.a.b.e;
import com.google.a.c.ad;
import com.google.a.c.aq;
import com.google.a.c.ar;
import com.google.a.c.v;
import com.google.a.f.c;
import com.google.a.g.a.q;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.d:
//            j, g, a, f, 
//            k

final class b
    implements j
{
    private static final class a
    {

        private final String a;
        private final List b;

        public final boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag = flag1;
            if (obj instanceof a)
            {
                obj = (a)obj;
                flag = flag1;
                if (a.equals(((a) (obj)).a))
                {
                    flag = flag1;
                    if (b.equals(((a) (obj)).b))
                    {
                        flag = true;
                    }
                }
            }
            return flag;
        }

        public final int hashCode()
        {
            return Arrays.hashCode(new Object[] {
                a, b
            });
        }

        a(Method method)
        {
            a = method.getName();
            b = Arrays.asList(method.getParameterTypes());
        }
    }


    private static final e a = com.google.a.b.b.a().b().a(new com.google.a.b.c() {

        public final volatile Object a(Object obj)
        {
            return b.a((Class)obj);
        }

    });

    b()
    {
    }

    static ad a(Class class1)
    {
        Object obj = c.a(class1).b().d();
        class1 = aq.a();
        for (obj = ((Set) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Method amethod[] = ((Class)((Iterator) (obj)).next()).getMethods();
            int l = amethod.length;
            int i = 0;
            while (i < l) 
            {
                Method method = amethod[i];
                if (method.isAnnotationPresent(com/google/a/d/g) && !method.isBridge())
                {
                    Class aclass[] = method.getParameterTypes();
                    if (aclass.length != 1)
                    {
                        class1 = String.valueOf(String.valueOf(method));
                        i = aclass.length;
                        throw new IllegalArgumentException((new StringBuilder(class1.length() + 128)).append("Method ").append(class1).append(" has @Subscribe annotation, but requires ").append(i).append(" arguments.  Event subscriber methods must require a single argument.").toString());
                    }
                    a a1 = new a(method);
                    if (!class1.containsKey(a1))
                    {
                        class1.put(a1, method);
                    }
                }
                i++;
            }
        }

        return ad.a(class1.values());
    }

    private static ad b(Class class1)
    {
        try
        {
            class1 = (ad)a.b(class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            throw m.a(class1.getCause());
        }
        return class1;
    }

    public final ar a(Object obj)
    {
        v v1 = v.l();
        Iterator iterator = b(obj.getClass()).iterator();
        while (iterator.hasNext()) 
        {
            Object obj1 = (Method)iterator.next();
            Class class1 = ((Method) (obj1)).getParameterTypes()[0];
            boolean flag;
            if (((Method) (obj1)).getAnnotation(com/google/a/d/a) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                obj1 = new f(obj, ((Method) (obj1)));
            } else
            {
                obj1 = new k(obj, ((Method) (obj1)));
            }
            v1.a(class1, obj1);
        }
        return v1;
    }

}
