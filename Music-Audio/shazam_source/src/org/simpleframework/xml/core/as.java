// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.b;
import org.simpleframework.xml.c;
import org.simpleframework.xml.k;
import org.simpleframework.xml.l;
import org.simpleframework.xml.m;
import org.simpleframework.xml.o;

// Referenced classes of package org.simpleframework.xml.core:
//            aq, ce, bk, dp

final class as
    implements aq
{

    private List a;
    private List b;
    private l c;
    private k d;
    private Annotation e[];
    private c f;
    private c g;
    private m h;
    private o i;
    private Class j;
    private String k;
    private boolean l;
    private boolean m;

    public as(Class class1, c c1)
    {
        a = new LinkedList();
        b = new LinkedList();
        e = class1.getDeclaredAnnotations();
        f = c1;
        m = true;
        j = class1;
        a(class1);
        b(class1);
        q();
    }

    private void a(Class class1)
    {
        class1 = class1.getDeclaredMethods();
        int j1 = class1.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            ce ce1 = new ce(class1[i1]);
            a.add(ce1);
        }

    }

    private void b(Class class1)
    {
        class1 = class1.getDeclaredFields();
        int j1 = class1.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            bk bk1 = new bk(class1[i1]);
            b.add(bk1);
        }

    }

    private void q()
    {
        Annotation aannotation[] = e;
        int j1 = aannotation.length;
        int i1 = 0;
        while (i1 < j1) 
        {
            Annotation annotation = aannotation[i1];
            if ((annotation instanceof k) && annotation != null)
            {
                d = (k)annotation;
            }
            if ((annotation instanceof l) && annotation != null)
            {
                c = (l)annotation;
            }
            if ((annotation instanceof o) && annotation != null)
            {
                o o1 = (o)annotation;
                String s = j.getSimpleName();
                if (o1 != null)
                {
                    Object obj = o1.a();
                    boolean flag;
                    if (((String) (obj)).length() == 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (flag)
                    {
                        obj = dp.a(s);
                    }
                    m = o1.b();
                    i = o1;
                    k = ((String) (obj));
                }
            }
            if ((annotation instanceof m) && annotation != null)
            {
                h = (m)annotation;
            }
            if ((annotation instanceof b) && annotation != null)
            {
                obj = (b)annotation;
                l = ((b) (obj)).b();
                g = ((b) (obj)).a();
            }
            i1++;
        }
    }

    public final boolean a()
    {
        return m;
    }

    public final boolean b()
    {
        return l;
    }

    public final boolean c()
    {
        while (Modifier.isStatic(j.getModifiers()) || !j.isMemberClass()) 
        {
            return true;
        }
        return false;
    }

    public final boolean d()
    {
        return j.isPrimitive();
    }

    public final Class e()
    {
        Class class2 = j.getSuperclass();
        Class class1 = class2;
        if (class2 == java/lang/Object)
        {
            class1 = null;
        }
        return class1;
    }

    public final Class f()
    {
        return j;
    }

    public final String g()
    {
        return k;
    }

    public final o h()
    {
        return i;
    }

    public final m i()
    {
        return h;
    }

    public final c j()
    {
        if (f != null)
        {
            return f;
        } else
        {
            return g;
        }
    }

    public final c k()
    {
        return f;
    }

    public final k l()
    {
        return d;
    }

    public final l m()
    {
        return c;
    }

    public final List n()
    {
        return a;
    }

    public final List o()
    {
        return b;
    }

    public final Constructor[] p()
    {
        return j.getDeclaredConstructors();
    }

    public final String toString()
    {
        return j.toString();
    }
}
