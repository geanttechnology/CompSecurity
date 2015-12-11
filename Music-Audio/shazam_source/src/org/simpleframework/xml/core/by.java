// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import org.simpleframework.xml.a;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.d;
import org.simpleframework.xml.e;
import org.simpleframework.xml.e.b;
import org.simpleframework.xml.f;
import org.simpleframework.xml.g;
import org.simpleframework.xml.h;
import org.simpleframework.xml.j;
import org.simpleframework.xml.q;
import org.simpleframework.xml.s;

// Referenced classes of package org.simpleframework.xml.core:
//            ca, ElementLabel, af, bx, 
//            ElementListLabel, ElementArrayLabel, ElementMapLabel, ElementUnionLabel, 
//            ElementListUnionLabel, ElementMapUnionLabel, AttributeLabel, VersionLabel, 
//            TextLabel, dd, g, bz

final class by
{
    private static final class a
    {

        final Class a;
        final Class b;
        final Class c;

        public a(Class class1, Class class2)
        {
            this(class1, class2, null);
        }

        public a(Class class1, Class class2, Class class3)
        {
            b = class3;
            a = class2;
            c = class1;
        }
    }


    private final org.simpleframework.xml.e.a a = new b();
    private final i b;

    public by(i k)
    {
        b = k;
    }

    static Object a(af af1, Annotation annotation)
    {
        return new ca(af1, annotation);
    }

    private bx a(af af1, Annotation annotation, Annotation annotation1)
    {
        Object obj;
        if (annotation instanceof d)
        {
            obj = new a(org/simpleframework/xml/core/ElementLabel, org/simpleframework/xml/d);
        } else
        if (annotation instanceof f)
        {
            obj = new a(org/simpleframework/xml/core/ElementListLabel, org/simpleframework/xml/f);
        } else
        if (annotation instanceof e)
        {
            obj = new a(org/simpleframework/xml/core/ElementArrayLabel, org/simpleframework/xml/e);
        } else
        if (annotation instanceof h)
        {
            obj = new a(org/simpleframework/xml/core/ElementMapLabel, org/simpleframework/xml/h);
        } else
        if (annotation instanceof j)
        {
            obj = new a(org/simpleframework/xml/core/ElementUnionLabel, org/simpleframework/xml/j, org/simpleframework/xml/d);
        } else
        if (annotation instanceof g)
        {
            obj = new a(org/simpleframework/xml/core/ElementListUnionLabel, org/simpleframework/xml/g, org/simpleframework/xml/f);
        } else
        if (annotation instanceof org.simpleframework.xml.i)
        {
            obj = new a(org/simpleframework/xml/core/ElementMapUnionLabel, org/simpleframework/xml/i, org/simpleframework/xml/h);
        } else
        if (annotation instanceof org.simpleframework.xml.a)
        {
            obj = new a(org/simpleframework/xml/core/AttributeLabel, org/simpleframework/xml/a);
        } else
        if (annotation instanceof s)
        {
            obj = new a(org/simpleframework/xml/core/VersionLabel, org/simpleframework/xml/s);
        } else
        if (annotation instanceof q)
        {
            obj = new a(org/simpleframework/xml/core/TextLabel, org/simpleframework/xml/q);
        } else
        {
            throw new dd("Annotation %s not supported", new Object[] {
                annotation
            });
        }
        if (((a) (obj)).b != null)
        {
            Class class1 = ((a) (obj)).a;
            Class class3 = ((a) (obj)).b;
            obj = ((a) (obj)).c.getConstructor(new Class[] {
                org/simpleframework/xml/core/af, class1, class3, org/simpleframework/xml/c/i
            });
        } else
        {
            Class class2 = ((a) (obj)).a;
            obj = ((a) (obj)).c.getConstructor(new Class[] {
                org/simpleframework/xml/core/af, class2, org/simpleframework/xml/c/i
            });
        }
        if (!((Constructor) (obj)).isAccessible())
        {
            ((Constructor) (obj)).setAccessible(true);
        }
        if (annotation1 != null)
        {
            return (bx)((Constructor) (obj)).newInstance(new Object[] {
                af1, annotation, annotation1, b
            });
        } else
        {
            return (bx)((Constructor) (obj)).newInstance(new Object[] {
                af1, annotation, b
            });
        }
    }

    private bz b(af af1, Annotation annotation)
    {
        Object aobj[] = annotation.annotationType().getDeclaredMethods();
        if (aobj.length > 0)
        {
            aobj = (Annotation[])(Annotation[])aobj[0].invoke(annotation, new Object[0]);
        } else
        {
            aobj = new Annotation[0];
        }
        if (aobj.length > 0)
        {
            LinkedList linkedlist = new LinkedList();
            int l = aobj.length;
            for (int k = 0; k < l; k++)
            {
                Object obj = a(af1, annotation, aobj[k]);
                if (obj != null)
                {
                    obj = new org.simpleframework.xml.core.g(((bx) (obj)));
                }
                linkedlist.add(obj);
            }

            return new bz(linkedlist);
        } else
        {
            return null;
        }
    }

    final bz a(af af1, Annotation annotation, Object obj)
    {
        bz bz1 = (bz)a.a(obj);
        Object obj1 = bz1;
        if (bz1 == null)
        {
            if (annotation instanceof j)
            {
                af1 = b(af1, annotation);
            } else
            if (annotation instanceof g)
            {
                af1 = b(af1, annotation);
            } else
            if (annotation instanceof org.simpleframework.xml.i)
            {
                af1 = b(af1, annotation);
            } else
            {
                af1 = a(af1, annotation, ((Annotation) (null)));
                if (af1 != null)
                {
                    af1 = new org.simpleframework.xml.core.g(af1);
                }
                af1 = new bz(af1);
            }
            obj1 = af1;
            if (af1 != null)
            {
                a.a(obj, af1);
                obj1 = af1;
            }
        }
        return ((bz) (obj1));
    }
}
