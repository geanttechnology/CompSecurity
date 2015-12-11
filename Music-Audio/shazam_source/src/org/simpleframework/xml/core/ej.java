// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.core;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.simpleframework.xml.a.b;
import org.simpleframework.xml.a.d;
import org.simpleframework.xml.c;
import org.simpleframework.xml.c.i;
import org.simpleframework.xml.d.ag;
import org.simpleframework.xml.d.ah;
import org.simpleframework.xml.d.ai;
import org.simpleframework.xml.d.z;
import org.simpleframework.xml.e.a;

// Referenced classes of package org.simpleframework.xml.core:
//            bc, ar, dw, by, 
//            br, bz, bx, dv, 
//            dm, ct, ap, aq, 
//            af, ag

final class ej
    implements b
{

    final br a;
    final by b;
    final ai c;
    final i d;
    private final dw e;
    private final ar f;
    private final ar g;
    private final z h;
    private final b i;

    public ej()
    {
        this(((b) (new d())));
    }

    private ej(b b1)
    {
        this(b1, ((z) (new bc())));
    }

    private ej(b b1, z z)
    {
        this(b1, z, new i());
    }

    public ej(b b1, z z, i j)
    {
        f = new ar(this, c.a);
        c = new ai(z);
        e = new dw(this);
        g = new ar(this);
        b = new by(j);
        a = new br();
        h = z;
        i = b1;
        d = j;
    }

    public static boolean a(Class class1, Class class2)
    {
        Class class3 = class1;
        if (class1.isPrimitive())
        {
            class3 = c(class1);
        }
        class1 = class2;
        if (class2.isPrimitive())
        {
            class1 = c(class2);
        }
        return class1.isAssignableFrom(class3);
    }

    public static Class c(Class class1)
    {
        Class class2;
        if (class1 == Double.TYPE)
        {
            class2 = java/lang/Double;
        } else
        {
            if (class1 == Float.TYPE)
            {
                return java/lang/Float;
            }
            if (class1 == Integer.TYPE)
            {
                return java/lang/Integer;
            }
            if (class1 == Long.TYPE)
            {
                return java/lang/Long;
            }
            if (class1 == Boolean.TYPE)
            {
                return java/lang/Boolean;
            }
            if (class1 == Character.TYPE)
            {
                return java/lang/Character;
            }
            if (class1 == Short.TYPE)
            {
                return java/lang/Short;
            }
            class2 = class1;
            if (class1 == Byte.TYPE)
            {
                return java/lang/Byte;
            }
        }
        return class2;
    }

    public final String a(Object obj, Class class1)
    {
        ag ag1 = c.a(class1);
        if (ag1 == null)
        {
            throw new ah("Transform of %s not supported", new Object[] {
                class1
            });
        } else
        {
            return ag1.a(obj);
        }
    }

    public final String a(String s)
    {
        return i.a(s);
    }

    public final aq a(Class class1, c c1)
    {
        if (c1 != null)
        {
            return f.a(class1);
        } else
        {
            return g.a(class1);
        }
    }

    public final bx a(af af, Annotation annotation)
    {
        Object obj = null;
        annotation = b.a(af, annotation, org.simpleframework.xml.core.by.a(af, annotation));
        af = obj;
        if (annotation != null)
        {
            af = obj;
            if (((bz) (annotation)).b > 0)
            {
                af = (bx)((bz) (annotation)).a.get(0);
            }
        }
        return af;
    }

    public final dv a(Class class1)
    {
        boolean flag = true;
        dw dw1 = e;
        dv dv1 = (dv)dw1.a.a(class1);
        Object obj = dv1;
        if (dv1 == null)
        {
            aq aq = dw1.b.a(class1, ((c) (null)));
            if (dw1.b.b(class1))
            {
                obj = new dm(aq);
            } else
            {
                ct ct1 = new ct(aq, dw1.b);
                obj = ct1;
                if (ct1.s())
                {
                    while (false) 
                    {
                        if (!java/util/Collection.isAssignableFrom(class1) && !java/util/Map.isAssignableFrom(class1))
                        {
                            flag = class1.isArray();
                        }
                        obj = ct1;
                        if (!flag)
                        {
                            obj = new ap(aq, dw1.b);
                        }
                    }
                } else
                {
                    while (false) 
                    {
                        if (!java/util/Collection.isAssignableFrom(class1) && !java/util/Map.isAssignableFrom(class1))
                        {
                            flag = class1.isArray();
                        }
                        obj = ct1;
                        if (!flag)
                        {
                            obj = new ap(aq, dw1.b);
                        }
                    }
                }
            }
            dw1.a.a(class1, obj);
        }
        return ((dv) (obj));
    }

    public final org.simpleframework.xml.core.ag b(Class class1, c c1)
    {
        if (c1 != null)
        {
            return f.b(class1);
        } else
        {
            return g.b(class1);
        }
    }

    public final boolean b(Class class1)
    {
        while (class1 == java/lang/String || class1 == java/lang/Float || class1 == java/lang/Double || class1 == java/lang/Long || class1 == java/lang/Integer || class1 == java/lang/Boolean || class1.isEnum() || class1.isPrimitive() || c.a(class1) != null) 
        {
            return true;
        }
        return false;
    }

    public final org.simpleframework.xml.core.ag c(Class class1, c c1)
    {
        if (c1 != null)
        {
            return f.c(class1);
        } else
        {
            return g.c(class1);
        }
    }
}
