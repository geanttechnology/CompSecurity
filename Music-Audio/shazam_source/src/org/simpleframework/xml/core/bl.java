// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.a;
import org.simpleframework.xml.c;
import org.simpleframework.xml.d;
import org.simpleframework.xml.e;
import org.simpleframework.xml.f;
import org.simpleframework.xml.g;
import org.simpleframework.xml.h;
import org.simpleframework.xml.i;
import org.simpleframework.xml.j;
import org.simpleframework.xml.q;
import org.simpleframework.xml.r;
import org.simpleframework.xml.s;

// Referenced classes of package org.simpleframework.xml.core:
//            ag, a, ah, aq, 
//            ej, bk, dp, af, 
//            bj

final class bl extends ag
{

    private final org.simpleframework.xml.core.a a;
    private final ah b = new ah();
    private final ej c;

    public bl(aq aq1, ej ej1)
    {
        a = new org.simpleframework.xml.core.a(aq1, ej1);
        c = ej1;
        Object obj = aq1.k();
        ej1 = aq1.j();
        Class class1 = aq1.e();
        if (class1 != null)
        {
            obj = c.b(class1, ((c) (obj)));
            if (obj != null)
            {
                addAll(((java.util.Collection) (obj)));
            }
        }
        obj = aq1.o();
        if (ej1 == c.a)
        {
            ej1 = ((List) (obj)).iterator();
            do
            {
                if (!ej1.hasNext())
                {
                    break;
                }
                Object obj2 = (bk)ej1.next();
                Annotation aannotation[] = ((bk) (obj2)).a;
                obj2 = ((bk) (obj2)).b;
                Object obj3 = ((Field) (obj2)).getType();
                boolean flag;
                if (Modifier.isStatic(((Field) (obj2)).getModifiers()))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    if (Modifier.isTransient(((Field) (obj2)).getModifiers()))
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        Class aclass[] = org.simpleframework.xml.core.dp.a(((Field) (obj2)));
                        obj3 = a.a(((Class) (obj3)), aclass);
                        if (obj3 != null)
                        {
                            a(((Field) (obj2)), ((Annotation) (obj3)), aannotation);
                        }
                    }
                }
            } while (true);
        }
        for (aq1 = aq1.o().iterator(); aq1.hasNext();)
        {
            Object obj1 = (bk)aq1.next();
            ej1 = ((bk) (obj1)).a;
            obj1 = ((bk) (obj1)).b;
            int l = ej1.length;
            int k = 0;
            while (k < l) 
            {
                Annotation annotation = ej1[k];
                if (annotation instanceof a)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof j)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof g)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof i)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof f)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof e)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof h)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof d)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof s)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
                if (annotation instanceof q)
                {
                    a(((Field) (obj1)), annotation, ej1);
                }
    /* block-local class not found */
    class a {}

                if (annotation instanceof r)
                {
                    b.remove(new a(((Field) (obj1))));
                }
                k++;
            }
        }

        for (aq1 = b.iterator(); aq1.hasNext(); add((af)aq1.next())) { }
    }

    private void a(Field field, Annotation annotation, Annotation aannotation[])
    {
        boolean flag;
        flag = true;
        annotation = new bj(field, annotation, aannotation);
        aannotation = new a(field);
        if (!field.isAccessible())
        {
            field.setAccessible(true);
        }
        field = (af)b.remove(aannotation);
        if (field == null) goto _L2; else goto _L1
_L1:
        if (!(annotation.e() instanceof q))
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L3
_L3:
        b.put(aannotation, field);
        return;
_L2:
        field = annotation;
        if (true) goto _L3; else goto _L4
_L4:
    }
}
